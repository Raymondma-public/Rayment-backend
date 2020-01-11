-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema payment
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema payment
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `payment` DEFAULT CHARACTER SET utf8 ;
USE `payment` ;

-- -----------------------------------------------------
-- Table `payment`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `payment`.`Account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(256) NULL,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `payment`.`Currency_Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `payment`.`Currency_Account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currency` VARCHAR(3) NULL,
  `balance` DOUBLE NOT NULL,
  `account_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `Currency_Account_FK_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `Currency_Account_FK`
    FOREIGN KEY (`account_id`)
    REFERENCES `payment`.`Account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `payment`.`History`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `payment`.`History` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from` INT NULL,
  `to` INT NULL,
  `currency` VARCHAR(3) NULL,
  `amount` DOUBLE NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `From_Currency_Account_History_FK_idx` (`from` ASC) VISIBLE,
  INDEX `To_Currency_Account_History_FK_idx` (`to` ASC) VISIBLE,
  CONSTRAINT `From_Currency_Account_History_FK`
    FOREIGN KEY (`from`)
    REFERENCES `payment`.`Currency_Account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `To_Currency_Account_History_FK`
    FOREIGN KEY (`to`)
    REFERENCES `payment`.`Currency_Account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `payment`.`DDA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `payment`.`DDA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from_acc_id` INT NULL,
  `to_acc_id` INT NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `DDA_from_account_FK_idx` (`from_acc_id` ASC) INVISIBLE,
  INDEX `DDA_to_account_FK_idx` (`to_acc_id` ASC) VISIBLE,
  CONSTRAINT `DDA_from_account_FK`
    FOREIGN KEY (`from_acc_id`)
    REFERENCES `payment`.`Account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DDA_to_account_FK`
    FOREIGN KEY (`to_acc_id`)
    REFERENCES `payment`.`Account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
