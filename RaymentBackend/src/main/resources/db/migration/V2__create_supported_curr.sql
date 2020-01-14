USE `payment` ;

CREATE TABLE IF NOT EXISTS `payment`.`supported_curr` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `curr_code` VARCHAR(3) NOT NULL,
  `curr_name` VARCHAR(255) NULL,
  `country` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `curr_code_UNIQUE` (`curr_code` ASC) VISIBLE)
ENGINE = InnoDB;