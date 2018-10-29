CREATE SCHEMA `villagae-connect` ;
CREATE TABLE `villagae-connect`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` INT UNSIGNED NOT NULL DEFAULT 1,
  `createdDate` TIMESTAMP NOT NULL DEFAULT now(),
  `modifyDate` TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));

ALTER TABLE `village-connect`.`user` 
ADD COLUMN `village` VARCHAR(45) NOT NULL AFTER `modifyDate`,
ADD COLUMN `district` VARCHAR(45) NOT NULL AFTER `village`;

ALTER TABLE `village-connect`.`user` 
ADD COLUMN `pincode` INT NOT NULL AFTER `district`;

-- student

CREATE TABLE `village-connect`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `class` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `college` VARCHAR(45) NOT NULL,
  `collegeAddress` VARCHAR(45) NOT NULL,
  `economyType` VARCHAR(45) NOT NULL,
  `annualIncome` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `fatherName` VARCHAR(45) NOT NULL,
  `motherName` VARCHAR(45) NOT NULL,
  `parentEducation` VARCHAR(45) NOT NULL COMMENT 'Highest income of parent',
  `status` INT UNSIGNED NOT NULL DEFAULT 1,
  `createdDate` TIMESTAMP NOT NULL DEFAULT now(),
  `modifyDate` TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));


ALTER TABLE `village-connect`.`student` 
ADD INDEX `user-user_id_idx` (`user_id` ASC);
ALTER TABLE `village-connect`.`student` 
ADD CONSTRAINT `user-user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `village-connect`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
