/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i2b2arden;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByModifier;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.PanelType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.QueryDefinitionType;

/**
 *
 * @author matesn
 */
public class i2b2Helper {

    private int patientLimit;
    private String availableVariables = "";

    List i2b2Variables = new ArrayList();

    public String getBooleanOverview(String xml) {

        System.out.println(xml);
        String sqlStatement = "";
        String ardenCode = "";
        String ardenCode2 = "";
        setAvailableVariables("");

        ardenCode += "\n		// Create a new Arden data structure, which will hold the i2b2 data later:";
        ardenCode += "\n";
        ardenCode += "\n		DataStruct := object [ID, #I2B2VARS#];";
        ardenCode += "\n		PatientData := new DataStruct;";
        ardenCode += "\n";
        ardenCode += "\n		// Fetch all patients from the i2b2 query:";

        try {
            JAXBContext jaxbContext;
            jaxbContext = JAXBContext
                    .newInstance("org.i2b2.xsd.cell.crc.psm.querydefinition._1");

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            @SuppressWarnings("unchecked")
            JAXBElement<QueryDefinitionType> queryDefinition;
            queryDefinition = (JAXBElement<QueryDefinitionType>) unmarshaller
                    .unmarshal(new StringReader(xml));

            QueryDefinitionType definition = queryDefinition.getValue();

            String queryName = definition.getQueryName();

            String PatientSQL = "SELECT PSC.PATIENT_NUM PATIENT_NUM FROM QT_QUERY_MASTER QM, QT_QUERY_INSTANCE QI, QT_QUERY_RESULT_INSTANCE QRI, QT_PATIENT_SET_COLLECTION PSC WHERE QM.QUERY_MASTER_ID = QI.QUERY_MASTER_ID AND QI.QUERY_INSTANCE_ID = QRI.QUERY_INSTANCE_ID AND QRI.RESULT_INSTANCE_ID = PSC.RESULT_INSTANCE_ID AND QM.NAME = '" + queryName + "'";

            if (patientLimit > 0) {
                PatientSQL += " AND ROWNUM <= " + patientLimit;
            }

            ardenCode += "\n\t\tPatients := read {" + PatientSQL + "};";
            String optiQuery = " AND PATIENT_NUM IN (" + PatientSQL + ")";

            List<PanelType> panelList = definition.getPanel();

            ardenCode += "\n\n\t\ti2b2 := object [PATIENT_NUM, VALUE, START_DATE, END_DATE];\n";

            for (int panel = 0; panel < panelList.size(); panel++) {

                System.out.print("Panel " + panel);
                if (panelList.get(panel).getInvert() == 1) {
                    System.out.print(" (exclude)");
                }
                System.out.println();

                ardenCode += "\n\t\t// Panel " + panel;
                if (panelList.get(panel).getInvert() == 1) {
                    System.out.print(" (exclude)");
                }
                ardenCode += "\n";

                List<ItemType> itemList = panelList.get(panel).getItem();
                for (int item = 0; item < itemList.size(); item++) {
                    String itemKey = itemList.get(item).getItemKey().toString()
                            .replace("\\\\i2b2\\", "\\");
                    String itemIcon = itemList.get(item).getItemIcon();
                    String itemName = itemList.get(item).getItemName();

                    String simplifiedName = simplify(itemName);

                    availableVariables += simplifiedName + ", ";

                    i2b2Variables.add(simplifiedName);

                    String sqlQuery = "";

                    ConstrainByModifier modifier = itemList.get(item)
                            .getConstrainByModifier();

                    if (modifier == null) {
                        if (itemIcon != null) {
                            if (itemIcon.equals("LA")) {
                                System.out.println("    Item: " + itemKey);

                                //ardenCode += "\n\t\t" + simplifiedName + " := read as i2b2 {i2b2::query1||" + itemKey + "};\n";
                                ardenCode += "\n\t\t" + simplifiedName + "_ORIG := read as i2b2 {";

                                sqlQuery = "SELECT PATIENT_NUM, (CASE WHEN NVAL_NUM IS NOT NULL THEN NVAL_NUM ELSE 0 END) VALUE, "
                                        //+ "'"+ itemList.get(item).getItemName()
                                        //+ "' CONCEPT, '"
                                        //+ panel + "' PANEL, " +
                                        + "START_DATE, END_DATE FROM OBSERVATION_FACT WHERE CONCEPT_CD IN (SELECT CONCEPT_CD FROM CONCEPT_DIMENSION WHERE CONCEPT_PATH = '"
                                        + itemKey + "')" + optiQuery;
                            } else {
                                System.out.println("    Item: " + itemKey + "%");

                                //ardenCode += "   " + simplifiedName + " := read as i2b2 {i2b2::query1||" + itemKey + "%};\n";
                                ardenCode += "\n\t\t" + simplifiedName + "_ORIG := read as i2b2 {";

                                sqlQuery = "SELECT PATIENT_NUM, (CASE WHEN NVAL_NUM IS NOT NULL THEN NVAL_NUM ELSE 0 END) VALUE, "
                                        //+ "'"
                                        //+ itemList.get(item).getItemName()
                                        //+ "' CONCEPT, '"
                                        //+ panel + "' PANEL, "
                                        + "START_DATE, END_DATE FROM OBSERVATION_FACT WHERE CONCEPT_CD IN (SELECT CONCEPT_CD FROM CONCEPT_DIMENSION WHERE CONCEPT_PATH LIKE '"
                                        + itemKey + "%')" + optiQuery;
                            }
                        }
                    } else {
                        String modifierKey = modifier.getModifierKey().replace(
                                "\\\\i2b2\\", "\\");
                        String modifierConcept = modifier.getModifierName();
                        if (itemIcon.equals("LA")) {

                            System.out.println("    Item: " + itemKey + " | "
                                    + modifierKey);

                            //ardenCode += "\n\t\t" + simplifiedName + " := read as i2b2 {i2b2::query2||" + itemKey + ";" + modifierKey + "};\n";
                            ardenCode += "\n\t\t" + simplifiedName + "_ORIG := read as i2b2 {";

                            sqlQuery = "SELECT PATIENT_NUM, (CASE WHEN NVAL_NUM IS NOT NULL THEN NVAL_NUM ELSE 0 END) VALUE, "
                                    //+ "'"
                                    //+ itemList.get(item).getItemName()
                                    //+ " | "
                                    //+ modifierConcept
                                    //+ "' CONCEPT, "
                                    //+ "'" + panel + "' PANEL, "
                                    + "START_DATE, END_DATE FROM OBSERVATION_FACT WHERE CONCEPT_CD IN (SELECT CONCEPT_CD FROM CONCEPT_DIMENSION WHERE CONCEPT_PATH = '"
                                    + itemKey
                                    + "') AND MODIFIER_CD IN ( SELECT MODIFIER_CD FROM MODIFIER_DIMENSION WHERE MODIFIER_PATH = '"
                                    + modifierKey + "')" + optiQuery;
                        } else {
                            System.out.println("    Item: " + itemKey + "% | "
                                    + modifierKey);

                            //ardenCode += "   " + simplifiedName + " := read as i2b2 {i2b2::query2||" + itemKey + "%;" + modifierKey + "};\n";
                            ardenCode += "\n\t\t" + simplifiedName + "_ORIG := read as i2b2 {";

                            sqlQuery = "SELECT PATIENT_NUM, (CASE WHEN NVAL_NUM IS NOT NULL THEN NVAL_NUM ELSE 0 END) VALUE, "
                                    //+ "'"
                                    //+ itemList.get(item).getItemName()
                                    //+ " | "
                                    //+ modifierConcept
                                    //+ "' CONCEPT, '"
                                    //+ panel + "' PANEL, "
                                    + "START_DATE, END_DATE FROM OBSERVATION_FACT WHERE CONCEPT_CD IN (SELECT CONCEPT_CD FROM CONCEPT_DIMENSION WHERE CONCEPT_PATH LIKE '"
                                    + itemKey
                                    + "%') AND MODIFIER_CD IN ( SELECT MODIFIER_CD FROM MODIFIER_DIMENSION WHERE MODIFIER_PATH = '"
                                    + modifierKey + "')" + optiQuery;
                        }
                    }

                    sqlStatement += sqlQuery;
                    ardenCode += sqlQuery + "};\n";

                    String TsPpTemplate = "";
                    try {
                        TsPpTemplate = new String(Files.readAllBytes(Paths.get("timestamp-preprocessing-stub.txt")));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    TsPpTemplate = TsPpTemplate.replaceAll("#INVAR#", simplifiedName + "_ORIG");
                    TsPpTemplate = TsPpTemplate.replaceAll("#OUTVAR#", simplifiedName);
                    System.out.println(TsPpTemplate);
                    ardenCode2 += TsPpTemplate;


                    /*if (panel < panelList.size() - 1) {
                     sqlStatement += " UNION ";
                     }*/
                }
            }

            // System.out.println(sqlStatement);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ardenCode = ardenCode.replaceAll("#I2B2VARS#", getAvailableVariables());

        ardenCode += "\n        //Generate the PatientData object by aligning time stamps to values:";
        ardenCode += "\n";
        ardenCode += "\n        for CurrentPatient in Patients do";
        ardenCode += "\n";
        ardenCode += ardenCode2;
        ardenCode += "\n			// Finally, add the data elements for the current patient to the PatientData object:";
        ardenCode += "\n";
        ardenCode += "\n			CurrentPatientData := new DataStruct;";
        ardenCode += "\n			CurrentPatientData.ID := CurrentPatient;";
        for (int a = 0; a < i2b2Variables.size(); a++) {
            ardenCode += "\n			CurrentPatientData." + i2b2Variables.get(a) + " := " + i2b2Variables.get(a) + ";";
        }
        ardenCode += "\n			PatientData := PatientData, CurrentPatientData;";
        ardenCode += "\n";
        ardenCode += "\n                enddo;";

        return ardenCode;

    }

    private String simplify(String input) {

        // Taken partially from: http://gordon.koefner.at/blog/coding/replacing-german-umlauts/
        String simplified = "";

        //replace all lower Umlauts
        simplified
                = input
                .replaceAll("ü", "ue")
                .replaceAll("ö", "oe")
                .replaceAll("ä", "ae")
                .replaceAll("ß", "ss");

        //first replace all capital umlaute in a non-capitalized context (e.g. Übung)
        simplified
                = simplified
                .replaceAll("Ü(?=[a-zäöüß ])", "Ue")
                .replaceAll("Ö(?=[a-zäöüß ])", "Oe")
                .replaceAll("Ä(?=[a-zäöüß ])", "Ae");

        //now replace all the other capital umlaute
        simplified
                = simplified
                .replaceAll("Ü", "UE")
                .replaceAll("Ö", "OE")
                .replaceAll("Ä", "AE");

        simplified
                = simplified
                .replaceAll("[^A-Za-z0-9]", "_");

        return simplified;

    }

    void setPatientLimit(int patientLimit) {
        this.patientLimit = patientLimit;
    }

    /**
     * @return the availableVariables
     */
    public String getAvailableVariables() {
        if (availableVariables.length() >= 2) {
            return availableVariables.substring(0, availableVariables.length() - 2);
        } else {
            return "";
        }
    }

    public String getAvailableVariables2() {
        String vars = "PatientData.ID, ";

        for (int a = 0; a < i2b2Variables.size(); a++) {
            vars += "PatientData." + i2b2Variables.get(a) + ", ";
        }

        vars = vars.substring(0, vars.length() - 2);
        return vars;
    }

    /**
     * @param availableVariables the availableVariables to set
     */
    public void setAvailableVariables(String availableVariables) {
        this.availableVariables = availableVariables;
    }

}
