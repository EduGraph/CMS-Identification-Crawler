CREATE DATABASE cmsidentifier_read;

CREATE TABLE `cmsidentifier_read`.`AnzahlDerVerwendetenCMS` ( `CMS` VARCHAR(250) NOT NULL , `Anzahl` INT NOT NULL , PRIMARY KEY (`CMS`)) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier_read`.`CMSDerHochschulen` ( `Hochschule` VARCHAR(250) NOT NULL , `CMS` VARCHAR(250) NOT NULL , PRIMARY KEY (`Hochschule`)) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier_read`.`VeraenderungAktuelleWoche` ( `CMS` VARCHAR(250) NOT NULL , `Veraenderung` INT NOT NULL , PRIMARY KEY (`CMS`)) ENGINE = InnoDB;

CREATE DATABASE cmsidentifier_write;

CREATE TABLE `cmsidentifier_write`.`Semester` ( `ID` INT NOT NULL AUTO_INCREMENT , `Name` VARCHAR(250) NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier_write`.`Hochschule` ( `ID` INT NOT NULL AUTO_INCREMENT , `Name` VARCHAR(250) NOT NULL , `Website_URL` VARCHAR(250) NOT NULL , `Wikipedia_URL` VARCHAR(250) NOT NULL , `Semester_ID` INT NOT NULL , PRIMARY KEY (`ID`), INDEX (`Semester_ID`)) ENGINE = InnoDB;
ALTER TABLE `hochschule` ADD FOREIGN KEY (`Semester_ID`) REFERENCES `semester`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
CREATE TABLE `cmsidentifier_write`.`Woche` ( `ID` INT NOT NULL AUTO_INCREMENT , `Kalenderwoche` INT NOT NULL , `CMS` VARCHAR(250) NOT NULL , `ID_Semester` INT NOT NULL , `ID_Hochschule` INT NOT NULL , PRIMARY KEY (`ID`), INDEX (`ID_Semester`), INDEX (`ID_Hochschule`)) ENGINE = InnoDB;
ALTER TABLE `woche` ADD FOREIGN KEY (`ID_Hochschule`) REFERENCES `hochschule`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `woche` ADD FOREIGN KEY (`ID_Semester`) REFERENCES `semester`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
