/*Remember to use chcp 1258 or 65001 to work with command prompt

Version 1.1

Authors: 
-Nguyễn Khắc Hiếu
-Nguyễn Duy Thái Sơn
*/

CREATE DATABASE se2db;
USE se2db;
CREATE TABLE se2db_vietnam (
  `id` INT NOT NULL AUTO_INCREMENT,
  `province_name` VARCHAR(45) NOT NULL,
  `current_infected` INT NULL,
  `current_death` INT NULL,
  `current_recovered` INT NULL,
  `date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;
INSERT INTO se2db_vietnam (`id`, `province_name`, `current_infected`, `current_death`, `current_recovered`, `date`) VALUES ('1', 'Hà Nội', '112', '0', '75', '2020-04-19');
INSERT INTO se2db_vietnam (`id`, `province_name`, `current_infected`, `current_death`, `current_recovered`, `date`) VALUES ('2', 'Hồ Chí Minh', '55', '0', '52', '2020-04-19');
INSERT INTO se2db_vietnam (`id`, `province_name`, `current_infected`, `current_death`, `current_recovered`, `date`) VALUES ('3', 'Vĩnh Phúc', '19', '0', '13', '2020-04-19');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('4', 'Ninh Bình');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('5', 'Bình Thuận');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('6', 'Quảng Ninh');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('7', 'Đà Nẵng');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('8', 'Hà Nam');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('9', 'Bắc Giang');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('10', 'Hà Tĩnh');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('11', 'Đồng Tháp');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('12', 'Bạc Liêu');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('13', 'Thanh Hóa');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('14', 'Quảng Nam ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('15', 'Tây Ninh');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('16', 'Trà Vinh');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('17', 'Cần Thơ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('18', 'Lào Cai');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('19', 'Thừa Thiên Huế ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('20', 'Ninh Thuận');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('21', 'Bến Tre');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('22', 'Hưng Yên ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('23', 'Hà Giang');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('24', 'Bắc Ninh ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('25', 'Đồng Nai ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('26', 'Hải Dương ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('27', 'Thái Nguyên ');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('28', 'Lai Châu');
INSERT INTO se2db_vietnam (`id`, `province_name`) VALUES ('29', 'Khánh Hoà');


CREATE TABLE se2db_world (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(45) NOT NULL,
  `current_infected` INT NULL,
  `current_death` INT NULL,
  `current_recovered` INT NULL,
  `date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO se2db_world (`id`, `country_name`, `current_infected`, `current_death`, `current_recovered`, `date`) VALUES ('1', 'United States', 794330, 72410 , 42634, '2020-04-21');
INSERT INTO se2db_world (`id`, `country_name`, `current_infected`, `current_death`, `current_recovered`, `date`) VALUES ('2', 'Spain', 204178, 82514, 21282, '2020-04-21');
INSERT INTO se2db_world (`id`, `country_name`, `current_infected`, `current_death`, `current_recovered`, `date`) VALUES ('3', 'Italy', 181228 , 48877 , 24114, '2020-04-21');
INSERT INTO se2db_world (`id`, `country_name`) VALUES ('4', 'France');
INSERT INTO se2db_world (`id`, `country_name`) VALUES ('5', 'Germany');