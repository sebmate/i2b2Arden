/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i2b2arden;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;

/**
 *
 * @author matesn
 */
public class MainForm extends javax.swing.JFrame {

    private String FullMLMCode;
    private boolean deselectLater;
    private boolean noDB;

    /**
     * Creates new form Form
     */
    public MainForm() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();

        rTextScrollPane.setLineNumbersEnabled(true);

        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/myLanguage", "i2b2arden.ArdenTokenMaker");
        MLMCode.setSyntaxEditingStyle("text/myLanguage");

        //MLMCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        //MLMCode.setCodeFoldingEnabled(true);
        deselectFullEditor();
        refreshQueries();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the MainForm Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoadingInfo = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        previousQueries = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ArdenResult = new javax.swing.JTextArea();
        runArden = new javax.swing.JButton();
        generateArden = new javax.swing.JButton();
        refreshQueries = new javax.swing.JButton();
        ontoLookUpBtn = new javax.swing.JButton();
        rTextScrollPane = new org.fife.ui.rtextarea.RTextScrollPane();
        MLMCode = new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea();
        FullEditor = new javax.swing.JCheckBox();
        doLimitPatients = new javax.swing.JCheckBox();
        patientLimit = new javax.swing.JTextField();

        LoadingInfo.setAlwaysOnTop(true);
        LoadingInfo.setBackground(new java.awt.Color(153, 153, 153));
        LoadingInfo.setForeground(java.awt.Color.gray);
        LoadingInfo.setMinimumSize(new java.awt.Dimension(335, 62));
        LoadingInfo.setUndecorated(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Processing, please wait ...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LoadingInfoLayout = new javax.swing.GroupLayout(LoadingInfo.getContentPane());
        LoadingInfo.getContentPane().setLayout(LoadingInfoLayout);
        LoadingInfoLayout.setHorizontalGroup(
            LoadingInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoadingInfoLayout.setVerticalGroup(
            LoadingInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("i2b2 to Arden Preprocessor");
        setLocationByPlatform(true);

        previousQueries.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        previousQueries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQueriesActionPerformed(evt);
            }
        });

        jLabel1.setText("Select an i2b2 query:");

        jLabel4.setText("Results:");

        ArdenResult.setColumns(20);
        ArdenResult.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        ArdenResult.setLineWrap(true);
        ArdenResult.setRows(5);
        ArdenResult.setMaximumSize(new java.awt.Dimension(102, 16));
        jScrollPane3.setViewportView(ArdenResult);

        runArden.setText("Run in Arden2ByteCode");
        runArden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runArdenActionPerformed(evt);
            }
        });

        generateArden.setText("Generate Arden Code");
        generateArden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateArdenActionPerformed(evt);
            }
        });

        refreshQueries.setText("Refresh");
        refreshQueries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshQueriesActionPerformed(evt);
            }
        });

        ontoLookUpBtn.setText("Ontology Look-Up");
        ontoLookUpBtn.setEnabled(false);
        ontoLookUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ontoLookUpBtnActionPerformed(evt);
            }
        });

        rTextScrollPane.setLineNumbersEnabled(true);

        MLMCode.setColumns(20);
        MLMCode.setLineWrap(true);
        MLMCode.setRows(5);
        MLMCode.setTabSize(3);
        MLMCode.setText("maintenance:\n\ttitle: Hello World Example;;\n\tmlmname: hello_world;;\n\tarden: version 2.1;;  \n\tversion: 1.0;;\n\tinstitution: Lehrstuhl fuer Medizinische Informatik, Friedrich-Alexander-Universtitaet Erlangen-Nuernberg;;\n\tauthor: Sebastian Mate;;\n\tspecialist: Sebastian Mate;;\n\tdate: 2016-04-08;;\n\tvalidation: testing;;\n\nlibrary:\n\tpurpose: Test for i2b2Arden;;\n\texplanation: n.a.;;\n\tkeywords: hello world ;;\n\nknowledge:\n\ttype: data-driven\n;;\n\ndata:\n\tstdout_dest := destination{STDOUT};\n;;\n\nevoke:\n;;\n\nlogic:\n\tconclude true;\n;;\n      \naction:\n\t// ---- Begin of your code ----\n\n\twrite \"Hello World!\"  at stdout_dest;  \n\n\t// ---- End of your code ----\n;;\n\nend:\n");
        MLMCode.setToolTipText("");
        MLMCode.setWrapStyleWord(false);
        rTextScrollPane.setViewportView(MLMCode);

        FullEditor.setSelected(true);
        FullEditor.setText("Show Full ARDEN Code");
        FullEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullEditorActionPerformed(evt);
            }
        });

        doLimitPatients.setText("Limit Patients:");

        patientLimit.setText("100");
        patientLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientLimitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rTextScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FullEditor)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(previousQueries, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(refreshQueries, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ontoLookUpBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(doLimitPatients)
                                        .addGap(10, 10, 10)
                                        .addComponent(patientLimit))
                                    .addComponent(generateArden, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addComponent(runArden)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousQueries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(runArden)
                    .addComponent(generateArden)
                    .addComponent(refreshQueries))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FullEditor)
                    .addComponent(doLimitPatients)
                    .addComponent(patientLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ontoLookUpBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rTextScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previousQueriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQueriesActionPerformed
    }//GEN-LAST:event_previousQueriesActionPerformed

    private void runArdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runArdenActionPerformed

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = LoadingInfo.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        LoadingInfo.pack();
        LoadingInfo.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        LoadingInfo.setVisible(true);

        new Thread(new Runnable() {
            private boolean deselectLater;

            public void run() {

                if (!FullEditor.isSelected()) {
                    selectFullEditor();
                    deselectLater = true;
                }

                String a2bcPath = "";
                String a2bcJar = "";
                ArdenResult.setText("");

                FileInputStream ins = null;
                try {
                    ins = new FileInputStream("Arden2ByteCode.properties");
                    Properties prop = new Properties();
                    prop.load(ins);
                    ins.close();
                    a2bcPath = prop.getProperty("a2bc.path");
                    a2bcJar = prop.getProperty("a2bc.jar");
                } catch (IOException ex) {
                    Logger.getLogger(dbHelper.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        ins.close();
                    } catch (IOException ex) {
                        Logger.getLogger(dbHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                try (PrintWriter out = new PrintWriter("outer.mlm")) {
                    out.println(MLMCode.getText());
                    out.close();
                } catch (FileNotFoundException ex) {
                }

                if (deselectLater) {
                    deselectFullEditor();
                }

                try {

                    dbHelper helper = new dbHelper();
                    helper.loadConfigFile("DBConnection.properties");

                    String execString = "java -jar \"" + a2bcPath + a2bcJar + "\" -p \"" + a2bcPath + "ojdbc6.jar\" -d oracle.jdbc.OracleDriver -e \"jdbc:oracle:thin:" + helper.getUser() + "/" + helper.getPassword() + "@" + helper.getServer() + ":" + helper.getPort() + ":" + helper.getSID() + "\" -r \"outer.mlm\"";
                    
                    System.out.println(execString);
                    
                    if (noDB == true)
                    execString = "java -jar \"" + a2bcPath + a2bcJar + "\" -p \"" + a2bcPath + "ojdbc6.jar\" -r \"outer.mlm\"";
                    
                    System.out.println(execString);

                    try (PrintWriter out = new PrintWriter("run.bat")) {
                        out.println(execString);
                        out.println("pause");
                        out.close();
                    } catch (FileNotFoundException ex) {
                    }

                    /*
                     arden.MainClass arden = new arden.MainClass();
                     String[] args = new String[7];
                     args[0] = "-?";
                     args[1] = "-?";
                     args[2] = "-?";
                     args[3] = "-?";
                     args[4] = "-?";
                     args[5] = "-?";
                     args[6] = "-?";
                     MainClass.main(args);
                     */
                    Process proc = Runtime.getRuntime().exec(execString);
                    String thisLine1 = null, thisLine2 = null;
                    BufferedReader reader1
                            = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    BufferedReader reader2
                            = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

                    while ((thisLine1 = reader1.readLine()) != null || (thisLine2 = reader2.readLine()) != null) {
                        String currentArdenText = ArdenResult.getText();
                        if (thisLine1 != null) {
                            currentArdenText += thisLine1;
                        }
                        if (thisLine2 != null) {
                            currentArdenText += thisLine2;
                        }
                        ArdenResult.setText(currentArdenText + "\n");
                    }

                    while (proc.isAlive()) {
                        proc.wait();
                    }

                    /*
                     // Then retreive the process output
                     InputStream in = proc.getInputStream();
                     InputStream err = proc.getErrorStream();

                     byte b[] = new byte[in.available()];
                     in.read(b, 0, b.length);
                     System.out.println(new String(b));

                     byte c[] = new byte[err.available()];
                     err.read(c, 0, c.length);

                     ArdenResult.setText(new String(b) + "\n" + new String(c));

                     */
                } catch (Exception ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                LoadingInfo.setVisible(false);

                if (ArdenResult.getText().contains("no results")) {
                    JOptionPane.showMessageDialog(null, "No patient set found. Did you tick 'Patient set' when running the i2b2 query?", "ARDEN Error Detected", JOptionPane.INFORMATION_MESSAGE);
                }
                if (ArdenResult.getText().contains("ParserException") || ArdenResult.getText().contains("LexerException")) {
                    JOptionPane.showMessageDialog(null, "ParserException. Try renaming the i2b2 query (no spaces and foreign characters).", "Arden2ByteCode Error Detected", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }).start();


    }//GEN-LAST:event_runArdenActionPerformed

    private void generateArdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateArdenActionPerformed
        if (!FullEditor.isSelected()) {
            selectFullEditor();
            deselectLater = true;
        }
        generateArdenCode();
        if (deselectLater) {
            deselectFullEditor();
        }
    }//GEN-LAST:event_generateArdenActionPerformed

    private void refreshQueriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshQueriesActionPerformed
        refreshQueries();
    }//GEN-LAST:event_refreshQueriesActionPerformed

    private void ontoLookUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ontoLookUpBtnActionPerformed
        OntoForm oform = new OntoForm();
        oform.show();
    }//GEN-LAST:event_ontoLookUpBtnActionPerformed


    private void FullEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullEditorActionPerformed

        if (!FullEditor.isSelected()) {

            deselectFullEditor();

        } else {
            selectFullEditor();
        }


    }//GEN-LAST:event_FullEditorActionPerformed

    private void patientLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientLimitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientLimitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ArdenResult;
    private javax.swing.JCheckBox FullEditor;
    private javax.swing.JFrame LoadingInfo;
    private org.fife.ui.rsyntaxtextarea.RSyntaxTextArea MLMCode;
    private javax.swing.JCheckBox doLimitPatients;
    private javax.swing.JButton generateArden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton ontoLookUpBtn;
    private javax.swing.JTextField patientLimit;
    private javax.swing.JComboBox previousQueries;
    private org.fife.ui.rtextarea.RTextScrollPane rTextScrollPane;
    private javax.swing.JButton refreshQueries;
    private javax.swing.JButton runArden;
    // End of variables declaration//GEN-END:variables

    private void generateArdenCode() {

        try {
            String content = new String(Files.readAllBytes(Paths.get("arden-outer-stub.txt")));
            MLMCode.setText(content);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (previousQueries.getSelectedItem() == null) {
            return;
        }

        String dataSlot = "";

        dbHelper helper = new dbHelper();
        helper.loadConfigFile("DBConnection.properties");
        helper.initConnention();
        helper.executeSQL("SELECT NAME, REQUEST_XML, GENERATED_SQL FROM QT_QUERY_MASTER WHERE NAME = '" + previousQueries.getSelectedItem() + "'");
        helper.nextEntry();

        i2b2Helper helper2 = new i2b2Helper();
        if (doLimitPatients.isSelected()) {
            helper2.setPatientLimit(Integer.parseInt(patientLimit.getText()));

        }

        dataSlot += helper2.getBooleanOverview(helper.getColumn("REQUEST_XML")).replaceAll("\\\\", "\\\\\\\\");

        System.out.println(helper.getColumn("REQUEST_XML"));

        String arden = MLMCode.getText();

        arden = arden.replaceAll("#QUERY#", "\"" + previousQueries.getSelectedItem().toString() + "\"");

        /*
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         try {
         Date today = dateFormat.parse(dateFormat.format(new Date()));
         arden = arden.replaceAll("#DATE#", today.toString());
         } catch (ParseException ex) {
         Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
         arden = arden.replaceAll("#DATE#", "2016-01-01");
         }
         */
        arden = arden.replaceAll("#DATE#", "2016-01-01");
        arden = arden.replaceAll("//DATA", dataSlot);
        arden = arden.replaceAll("//LOGIC", "        conclude true;");
        arden = arden.replaceAll("//ACTION", "// Available data structures: Patients, " + helper2.getAvailableVariables2() + "\n\n\twrite \"Number of patients: \" || count of Patients at stdout_dest;");

        MLMCode.setText(arden);
        //ArdenOutput.setText(dataSlot);
        helper.closeConnection();

    }

    private void refreshQueries() {

        try {

            dbHelper helper = new dbHelper();
            helper.loadConfigFile("DBConnection.properties");
            helper.initConnention();

            helper.executeSQL("SELECT QUERY_MASTER_ID, NAME FROM QT_QUERY_MASTER ORDER BY QUERY_MASTER_ID DESC");

            previousQueries.removeAllItems();

            int limit = 0;
            while (helper.nextEntry() && limit <= 20) {
                limit++;
                previousQueries.addItem(helper.getColumn("NAME"));
            }
            helper.closeConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not connect to the i2b2 database. Please check the file DBConnection.properties!\nWithout a proper database connection, you can only run local scripts!", "DB Connection Error", JOptionPane.INFORMATION_MESSAGE);
            noDB = true;
        }
    }

    private void deselectFullEditor() {
        FullMLMCode = MLMCode.getText();
        int startPos = FullMLMCode.indexOf("// ---- Begin of your code ----") + 32;
        int endPos = FullMLMCode.indexOf("// ---- End of your code ----");
        String ActionText = FullMLMCode.substring(startPos, endPos);
        MLMCode.setText(ActionText);
        FullEditor.setSelected(false);
    }

    private void selectFullEditor() {
        String ActionText = MLMCode.getText();
        int startPos = FullMLMCode.indexOf("// ---- Begin of your code ----") + 32;;
        int endPos = FullMLMCode.indexOf("// ---- End of your code ----");
        String part1 = FullMLMCode.substring(0, startPos);
        String part2 = FullMLMCode.substring(endPos);
        FullMLMCode = part1 + ActionText + part2;
        MLMCode.setText(FullMLMCode);
        FullEditor.setSelected(true);
    }
}
