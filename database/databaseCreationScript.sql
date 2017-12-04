SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `loans_of_customers` DEFAULT CHARACTER SET utf8 ;
USE `loans_of_customers` ;

DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `loans`;
DROP TABLE IF EXISTS `extended_loans`;

CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` CHAR(32) NOT NULL,
--  `forename` CHAR(32) NOT NULL,
  `registration_date` DATETIME,
--  password CHAR(32) NOT NULL,
  PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `loans` (
  `loans_id` INT(11) NOT NULL AUTO_INCREMENT,
  `customer_id` INT(11) NOT NULL,
  `loan_amount` DOUBLE(5, 2) NOT NULL,
  `passing_term` INTEGER(4) NOT NULL,
  `loan_extended_state` BOOLEAN NOT NULL,
  `take_loan_date` DATETIME,
  PRIMARY KEY (`loans_id`)
--  FOREIGN KEY (`customer_id`) REFERENCES customers(`customer_id`)
);

CREATE TABLE IF NOT EXISTS `extended_loans` (
  `extended_id` INT(11) NOT NULL AUTO_INCREMENT,
  `loans_id` INT(11) NOT NULL,
  `extended_loan_amount` DOUBLE(5, 2),
  `extended_passing_term` INTEGER(4),
  `extend_passing_term_date` DATETIME,
  PRIMARY KEY (`extended_id`)
--  FOREIGN KEY (`loans_id`) REFERENCES loans(`loans_id`)
)
ENGINE = InnoDB

AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;