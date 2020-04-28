USE se2db;
CREATE TABLE se2db_admin (
  `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL UNIQUE,
  `password` VARCHAR(50) NOT NULL UNIQUE,
  `email` VARCHAR(50) NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO se2db_admin (`id`, `username`, `password`, `email`) VALUES ('1', 'duaf1xd', 'duaf1xd', NULL);

