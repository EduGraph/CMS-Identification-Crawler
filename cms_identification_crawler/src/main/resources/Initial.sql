CREATE DATABASE cmsidentifier_read;

CREATE TABLE `cmsidentifier_read`.`AnzahlDerVerwendetenCMS` ( `CMS` VARCHAR(250) NOT NULL , `Anzahl` INT NOT NULL , PRIMARY KEY (`CMS`)) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier_read`.`CMSDerHochschulen` ( `Hochschule` VARCHAR(250) NOT NULL , `CMS` VARCHAR(250) NOT NULL , PRIMARY KEY (`Hochschule`)) ENGINE = InnoDB;
CREATE TABLE `cmsidentifier_read`.`VeraenderungAktuelleWoche` ( `CMS` VARCHAR(250) NOT NULL , `Veraenderung` INT NOT NULL , PRIMARY KEY (`CMS`)) ENGINE = InnoDB;