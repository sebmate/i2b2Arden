i2b2Arden
=========

i2b2Arden is a tool for executing Arden Syntax programs on i2b2 result sets.

Implemented by Sebastian Mate with contributions from Stefan Kraus, Friedrich-Alexander-Universität Erlangen-Nürnberg.

Contact: Sebastian.Mate -(at)- fau.de

This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.

Requirements
------------

The tool requires access to an i2b2 database, version 1.7 (1.6 should also work). It is necessary to have all tables from ONT, CRC and WORK in one database schema, not in three separate ones (as in the i2b2 Demo project).

We recommend using our i2b2 Wizard (https://github.com/sebmate/i2b2Wizard) for the i2b2 installation. i2b2Arden is fully compatible with i2b2-Wizard-based installations.

How to use the program
----------------------

  - Download and put "ojdbc6.jar" in the "lib" folder.
  - Modify "DBConnection.properties" so that the tool can connect to your i2b2 database.
  - Launch it by clicking on "i2b2Arden.jar"
  
After triggering Arden2ByteCode from our tool, a "run.bat" file is created. You can use this file to also execute Arden2ByteCode.

The MLM is always stored in "outer.mlm". To load another file, tick "Show Full ARDEN Code", then copy the file contents into the editor.

For developers
--------------

The source code can be built with NetBeans 8.0.1.
  




