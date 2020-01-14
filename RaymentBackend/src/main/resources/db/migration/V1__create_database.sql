CREATE SCHEMA IF NOT EXISTS `payment` DEFAULT CHARACTER SET utf8 ;
USE `payment` ;


CREATE TABLE IF NOT EXISTS `payment`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(256) NULL,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `payment`.`currency_account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currency` VARCHAR(3) NULL,
  `balance` DOUBLE NOT NULL,
  `account_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `currency_account_fk_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `currency_account_fk`
    FOREIGN KEY (`account_id`)
    REFERENCES `payment`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `payment`.`history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from` INT NULL,
  `to` INT NULL,
  `currency` VARCHAR(3) NULL,
  `amount` DOUBLE NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `from_currency_account_history_fk_idx` (`from` ASC) VISIBLE,
  INDEX `to_currency_account_history_fk_idx` (`to` ASC) VISIBLE,
  CONSTRAINT `from_currency_account_history_fk`
    FOREIGN KEY (`from`)
    REFERENCES `payment`.`currency_account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `to_currency_account_history_fk`
    FOREIGN KEY (`to`)
    REFERENCES `payment`.`currency_account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `payment`.`dda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from_acc_id` INT NULL,
  `to_acc_id` INT NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `dda_from_account_fk_idx` (`from_acc_id` ASC) INVISIBLE,
  INDEX `dda_to_account_fk_idx` (`to_acc_id` ASC) VISIBLE,
  CONSTRAINT `dda_from_account_fk`
    FOREIGN KEY (`from_acc_id`)
    REFERENCES `payment`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dda_to_account_fk`
    FOREIGN KEY (`to_acc_id`)
    REFERENCES `payment`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
