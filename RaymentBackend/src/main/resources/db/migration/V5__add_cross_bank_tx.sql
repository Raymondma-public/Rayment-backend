USE `payment`;
CREATE TABLE IF NOT EXISTS `payment`.`xbank_tx_status`
(
    `id`          INT         NOT NULL,
    `code`        VARCHAR(45) NULL DEFAULT NULL,
    `name`        VARCHAR(45) NULL DEFAULT NULL,
    `description` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `payment`.`xbank_tx_type`
(
    `id`          INT         NOT NULL,
    `code`        VARCHAR(45) NULL DEFAULT NULL,
    `name`        VARCHAR(45) NULL DEFAULT NULL,
    `description` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `payment`.`xbank_tx`
(
    `id`            INT         NOT NULL,
    `from_bank`     VARCHAR(45) NULL DEFAULT NULL,
    `from_account`  VARCHAR(45) NULL DEFAULT NULL,
    `to_bank`       VARCHAR(45) NULL DEFAULT NULL,
    `to_account`    VARCHAR(45) NULL DEFAULT NULL,
    `amount`        DECIMAL     NULL DEFAULT NULL,
    `currency`      VARCHAR(3)  NULL DEFAULT NULL,
    `tx_type`       INT         NULL DEFAULT NULL,
    `status`        INT         NULL DEFAULT NULL,
    `creation_date` DATETIME    NULL DEFAULT NULL,
    `status_date`   DATETIME    NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `xbank_tx_type_fk_idx` (`tx_type` ASC) VISIBLE,
    INDEX `xbank_tx_status_idx` (`status` ASC) VISIBLE,
    CONSTRAINT `xbank_tx_type_fk`
        FOREIGN KEY (`tx_type`)
            REFERENCES `payment`.`xbank_tx_type` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `xbank_tx_status`
        FOREIGN KEY (`status`)
            REFERENCES `payment`.`xbank_tx_status` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;




