SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS vidas;
CREATE SCHEMA vidas;
USE vidas;


CREATE TABLE person(
	person_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,	
	age TINYINT(150) NOT NULL,
	physical_features VARCHAR(100),
	image VARCHAR(50),
	description VARCHAR(70),
	temporary_shelter_id TINYINT UNSIGNED,
	PRIMARY KEY (person_id),
	CONSTRAINT fk_person_shelter FOREIGN KEY (temporary_shelter_id) REFERENCES temporary_shelter(temporary_shelter_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB;


CREATE TABLE temporary_shelter(
	temporary_shelter_id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
	temporary_name VARCHAR(30),
	address_id  SMALLINT UNSIGNED,
	PRIMARY KEY (temporary_shelter_id),
	CONSTRAINT fk_temporary_shelter FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB;


CREATE TABLE address(
	address_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	street VARCHAR(30),
	zip_code VARCHAR(5),
	city_id SMALLINT UNSIGNED,
	temporary_shelter_id TINYINT UNSIGNED,
	PRIMARY KEY(address_id),
	CONSTRAINT fk_address_temporary_shelter FOREIGN KEY (temporary_shelter_id) REFERENCES temporary_shelter(temporary_shelter_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_address_city FOREIGN KEY (city_id) REFERENCES city(city_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB;

CREATE TABLE city(
	city_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	city VARCHAR(30),
	PRIMARY KEY(city_id)
)ENGINE=InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
