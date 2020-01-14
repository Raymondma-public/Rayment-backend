USE `payment` ;

INSERT INTO `payment`.`account` (`id`,`phone`,`email`,`name`,`password`,`create_date`) VALUES (1,'+852-95860001','raymondma.public@gmail.com','Raymond Ma','123456789',NULL);
INSERT INTO `payment`.`account` (`id`,`phone`,`email`,`name`,`password`,`create_date`) VALUES (2,'+852-98765432','tom@abc.com','Tom','23456',NULL);
INSERT INTO `payment`.`account` (`id`,`phone`,`email`,`name`,`password`,`create_date`) VALUES (3,'+852-91234567','roy@gmail.com','Roy','123456','2020-01-12 05:41:02');
INSERT INTO `payment`.`account` (`id`,`phone`,`email`,`name`,`password`,`create_date`) VALUES (4,'+852-91234568','roy2@gmail.com','Roy2','123456','2020-01-12 07:26:56');
INSERT INTO `payment`.`account` (`id`,`phone`,`email`,`name`,`password`,`create_date`) VALUES (5,'+852-91234569','roy3@gmail.com','Roy3','123456','2020-01-12 07:31:04');
INSERT INTO `payment`.`currency_account` (`id`,`currency`,`balance`,`account_id`) VALUES (1,'HKD',800,1);
INSERT INTO `payment`.`currency_account` (`id`,`currency`,`balance`,`account_id`) VALUES (2,'HKD',400,2);
INSERT INTO `payment`.`currency_account` (`id`,`currency`,`balance`,`account_id`) VALUES (3,'HKD',0,5);
INSERT INTO `payment`.`currency_account` (`id`,`currency`,`balance`,`account_id`) VALUES (4,'CNY',0,5);
