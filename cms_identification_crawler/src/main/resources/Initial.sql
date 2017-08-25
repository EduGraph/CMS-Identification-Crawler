CREATE DATABASE cmsidentifier;

CREATE TABLE `cmsidentifier`.`READ_AnzahlDerVerwendetenCMS` ( `CMS` VARCHAR(250) NOT NULL , `Anzahl` INT NOT NULL ) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier`.`READ_CMSDerHochschulen` ( `Hochschule` VARCHAR(250) NOT NULL , `CMS` VARCHAR(250) NOT NULL ) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier`.`READ_VeraenderungAktuelleWoche` ( `CMS` VARCHAR(250) NOT NULL , `Veraenderung` INT NOT NULL) ENGINE = InnoDB;

CREATE TABLE `cmsidentifier`.`WRITE_Semester` ( `ID` INT NOT NULL AUTO_INCREMENT , `Name` VARCHAR(250) NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier`.`WRITE_Hochschule` ( `ID` INT NOT NULL AUTO_INCREMENT , `Name` VARCHAR(250) NOT NULL , `Website_URL` VARCHAR(250) NULL , `Wikipedia_URL` VARCHAR(250) NULL , `Semester_ID` INT NOT NULL , PRIMARY KEY (`ID`), INDEX (`Semester_ID`)) ENGINE = InnoDB;
ALTER TABLE `hochschule` ADD FOREIGN KEY (`Semester_ID`) REFERENCES `semester`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
CREATE TABLE `cmsidentifier`.`WRITE_Woche` ( `ID` INT NOT NULL AUTO_INCREMENT , `Kalenderwoche` INT NOT NULL , `CMS` VARCHAR(250) NOT NULL , `ID_Semester` INT NOT NULL , `ID_Hochschule` INT NOT NULL , PRIMARY KEY (`ID`), INDEX (`ID_Semester`), INDEX (`ID_Hochschule`)) ENGINE = InnoDB;
ALTER TABLE `woche` ADD FOREIGN KEY (`ID_Hochschule`) REFERENCES `hochschule`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `woche` ADD FOREIGN KEY (`ID_Semester`) REFERENCES `semester`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `semester` ADD `CreateTime` DATE NOT NULL AFTER `Name`;