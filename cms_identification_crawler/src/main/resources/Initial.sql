CREATE DATABASE cmsidentifier_read;

CREATE TABLE `cmsidentifier_read`.`AnzahlDerVerwendetenCMS` ( `CMS` VARCHAR(250) NOT NULL , `Anzahl` INT NOT NULL , PRIMARY KEY (`CMS`)) ENGINE = InnoDB;