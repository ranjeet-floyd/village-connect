CREATE SCHEMA `villagae-connect` ;
CREATE TABLE `villagae-connect`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` INT UNSIGNED NOT NULL DEFAULT 1,
  `createdDate` TIMESTAMP NOT NULL DEFAULT now(),
  `modifyDate` TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));