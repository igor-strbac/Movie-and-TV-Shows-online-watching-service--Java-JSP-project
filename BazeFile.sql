-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dnevnik21
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dnevnik21
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dnevnik21` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `dnevnik21` ;

-- -----------------------------------------------------
-- Table `dnevnik21`.`uloge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`uloge` (
  `id_uloga` INT(11) NOT NULL AUTO_INCREMENT,
  `uloga` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_uloga`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`korisnici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`korisnici` (
  `id_korisnik` INT(11) NOT NULL AUTO_INCREMENT,
  `adresa` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `ime` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `prezime` VARCHAR(255) NULL DEFAULT NULL,
  `telefon` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `uloge_uloga_id` INT(11) NOT NULL,
  PRIMARY KEY (`id_korisnik`),
  INDEX `FK669sfokvxh5334n5ha15bpr8h` (`uloge_uloga_id` ASC) VISIBLE,
  CONSTRAINT `FK669sfokvxh5334n5ha15bpr8h`
    FOREIGN KEY (`uloge_uloga_id`)
    REFERENCES `dnevnik21`.`uloge` (`id_uloga`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`admin` (
  `id_admin` INT(11) NOT NULL,
  PRIMARY KEY (`id_admin`),
  CONSTRAINT `FKlvy1w8osjvn1epfo5ww3ej5i4`
    FOREIGN KEY (`id_admin`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`odeljenja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`odeljenja` (
  `id_odeljenje` INT(11) NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(255) NULL DEFAULT NULL,
  `ucitelj_id_ucitelj` INT(11) NOT NULL,
  PRIMARY KEY (`id_odeljenje`),
  UNIQUE INDEX `UK_3cl5qute4j5rhdesovih3qjku` (`ucitelj_id_ucitelj` ASC) VISIBLE,
  CONSTRAINT `FKowtgfmx90bgr3prt81flnfc8t`
    FOREIGN KEY (`ucitelj_id_ucitelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`cetvrtak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`cetvrtak` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cetvrti` VARCHAR(255) NULL DEFAULT NULL,
  `drugi` VARCHAR(255) NULL DEFAULT NULL,
  `peti` VARCHAR(255) NULL DEFAULT NULL,
  `pretcas` VARCHAR(255) NULL DEFAULT NULL,
  `prvi` VARCHAR(255) NULL DEFAULT NULL,
  `sedmi` VARCHAR(255) NULL DEFAULT NULL,
  `sesti` VARCHAR(255) NULL DEFAULT NULL,
  `treci` VARCHAR(255) NULL DEFAULT NULL,
  `id_odeljenje` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_43sp1e4fg2ii7owptmvx95uc5` (`id_odeljenje` ASC) VISIBLE,
  CONSTRAINT `FKkbrf4k4p6wdf6h1vi7nfyoaim`
    FOREIGN KEY (`id_odeljenje`)
    REFERENCES `dnevnik21`.`odeljenja` (`id_odeljenje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`direktor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`direktor` (
  `id_direktor` INT(11) NOT NULL,
  PRIMARY KEY (`id_direktor`),
  CONSTRAINT `FKs40jo8eof0xukpuhd859lj7g4`
    FOREIGN KEY (`id_direktor`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`obavestenja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`obavestenja` (
  `id_obavestenje` INT(11) NOT NULL AUTO_INCREMENT,
  `admin_id_admin` INT(11) NOT NULL,
  `datum` DATE NULL DEFAULT NULL,
  `sadrzaj_obavestenja` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_obavestenje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`predmeti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`predmeti` (
  `id_predmet` INT(11) NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_predmet`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`ucenici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`ucenici` (
  `id_ucenik` INT(11) NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(255) NULL DEFAULT NULL,
  `prezime` VARCHAR(255) NULL DEFAULT NULL,
  `id_roditelj` INT(11) NOT NULL,
  `odeljenje_id_odeljenje` INT(11) NOT NULL,
  PRIMARY KEY (`id_ucenik`),
  UNIQUE INDEX `UK_48fd5ciohe0sjh2sfyspjcinc` (`id_roditelj` ASC) VISIBLE,
  INDEX `FK1n4aa27g8xahj478vj96u4nyh` (`odeljenje_id_odeljenje` ASC) VISIBLE,
  CONSTRAINT `FK1n4aa27g8xahj478vj96u4nyh`
    FOREIGN KEY (`odeljenje_id_odeljenje`)
    REFERENCES `dnevnik21`.`odeljenja` (`id_odeljenje`),
  CONSTRAINT `FK74evlh4147kj09hy9pdkrhge5`
    FOREIGN KEY (`id_roditelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`ocene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`ocene` (
  `id_ocena` INT(11) NOT NULL AUTO_INCREMENT,
  `datum` DATE NULL DEFAULT NULL,
  `ocena` INT(11) NULL DEFAULT NULL,
  `zaklj_ocena` INT(11) NULL DEFAULT NULL,
  `predmet_id_predmet` INT(11) NOT NULL,
  `ucenik_id_ucenik` INT(11) NOT NULL,
  PRIMARY KEY (`id_ocena`),
  INDEX `FK9wr14nkc7f469gvqjw7q67uhl` (`predmet_id_predmet` ASC) VISIBLE,
  INDEX `FKwbxlls4med9rawp2fem5ggt8` (`ucenik_id_ucenik` ASC) VISIBLE,
  CONSTRAINT `FK9wr14nkc7f469gvqjw7q67uhl`
    FOREIGN KEY (`predmet_id_predmet`)
    REFERENCES `dnevnik21`.`predmeti` (`id_predmet`),
  CONSTRAINT `FKwbxlls4med9rawp2fem5ggt8`
    FOREIGN KEY (`ucenik_id_ucenik`)
    REFERENCES `dnevnik21`.`ucenici` (`id_ucenik`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`otvorena_vrata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`otvorena_vrata` (
  `id_otvorena_vrata` INT(11) NOT NULL AUTO_INCREMENT,
  `odgovor` VARCHAR(255) NULL DEFAULT NULL,
  `roditelj_id_roditelj` INT(11) NULL DEFAULT NULL,
  `ucitelj_id_ucitelj` INT(11) NULL DEFAULT NULL,
  `vreme` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id_otvorena_vrata`),
  INDEX `FKrlo8r549k3h1u9m9s5v3vtqro` (`roditelj_id_roditelj` ASC) VISIBLE,
  INDEX `FKqvu08wscxtrbn4wh5bu7nl8mc` (`ucitelj_id_ucitelj` ASC) VISIBLE,
  CONSTRAINT `FKqvu08wscxtrbn4wh5bu7nl8mc`
    FOREIGN KEY (`ucitelj_id_ucitelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`),
  CONSTRAINT `FKrlo8r549k3h1u9m9s5v3vtqro`
    FOREIGN KEY (`roditelj_id_roditelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`petak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`petak` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cetvrti` VARCHAR(255) NULL DEFAULT NULL,
  `drugi` VARCHAR(255) NULL DEFAULT NULL,
  `peti` VARCHAR(255) NULL DEFAULT NULL,
  `pretcas` VARCHAR(255) NULL DEFAULT NULL,
  `prvi` VARCHAR(255) NULL DEFAULT NULL,
  `sedmi` VARCHAR(255) NULL DEFAULT NULL,
  `sesti` VARCHAR(255) NULL DEFAULT NULL,
  `treci` VARCHAR(255) NULL DEFAULT NULL,
  `id_odeljenje` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_1h16rrud8saqx3260v5elrnjc` (`id_odeljenje` ASC) VISIBLE,
  CONSTRAINT `FKgb0rimtel24t2docd3lw6niwl`
    FOREIGN KEY (`id_odeljenje`)
    REFERENCES `dnevnik21`.`odeljenja` (`id_odeljenje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`ponedeljak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`ponedeljak` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cetvrti` VARCHAR(255) NULL DEFAULT NULL,
  `drugi` VARCHAR(255) NULL DEFAULT NULL,
  `peti` VARCHAR(255) NULL DEFAULT NULL,
  `pretcas` VARCHAR(255) NULL DEFAULT NULL,
  `prvi` VARCHAR(255) NULL DEFAULT NULL,
  `sedmi` VARCHAR(255) NULL DEFAULT NULL,
  `sesti` VARCHAR(255) NULL DEFAULT NULL,
  `treci` VARCHAR(255) NULL DEFAULT NULL,
  `id_odeljenje` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_ollj6a765kxplfiuji5pwc0dn` (`id_odeljenje` ASC) VISIBLE,
  CONSTRAINT `FKs5jpil7auivqi920baxkfeekq`
    FOREIGN KEY (`id_odeljenje`)
    REFERENCES `dnevnik21`.`odeljenja` (`id_odeljenje`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`poruke`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`poruke` (
  `id_poruke` INT(11) NOT NULL AUTO_INCREMENT,
  `datum_vreme` DATETIME NULL DEFAULT NULL,
  `roditelj_id_roditelj` INT(11) NOT NULL,
  `sadrzaj_poruke` VARCHAR(255) NULL DEFAULT NULL,
  `ucitelj_id_ucitelj` INT(11) NOT NULL,
  PRIMARY KEY (`id_poruke`),
  INDEX `FKaw1tfhq2uwnocsngtvguu7ft3` (`roditelj_id_roditelj` ASC) VISIBLE,
  INDEX `FKk5mpjartv40ngtihye8qw3u6w` (`ucitelj_id_ucitelj` ASC) VISIBLE,
  CONSTRAINT `FKaw1tfhq2uwnocsngtvguu7ft3`
    FOREIGN KEY (`roditelj_id_roditelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`),
  CONSTRAINT `FKk5mpjartv40ngtihye8qw3u6w`
    FOREIGN KEY (`ucitelj_id_ucitelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`roditelji`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`roditelji` (
  `id_roditelj` INT(11) NOT NULL,
  PRIMARY KEY (`id_roditelj`),
  CONSTRAINT `FKann2fr5r9mymhw95sbp209s3q`
    FOREIGN KEY (`id_roditelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`sreda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`sreda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cetvrti` VARCHAR(255) NULL DEFAULT NULL,
  `drugi` VARCHAR(255) NULL DEFAULT NULL,
  `peti` VARCHAR(255) NULL DEFAULT NULL,
  `pretcas` VARCHAR(255) NULL DEFAULT NULL,
  `prvi` VARCHAR(255) NULL DEFAULT NULL,
  `sedmi` VARCHAR(255) NULL DEFAULT NULL,
  `sesti` VARCHAR(255) NULL DEFAULT NULL,
  `treci` VARCHAR(255) NULL DEFAULT NULL,
  `id_odeljenje` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_r1jn5x2sjxawcqev2sx34n1bn` (`id_odeljenje` ASC) VISIBLE,
  CONSTRAINT `FK5sj6q4yvubddtw17ld6vpuoc7`
    FOREIGN KEY (`id_odeljenje`)
    REFERENCES `dnevnik21`.`odeljenja` (`id_odeljenje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`subota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`subota` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cetvrti` VARCHAR(255) NULL DEFAULT NULL,
  `drugi` VARCHAR(255) NULL DEFAULT NULL,
  `peti` VARCHAR(255) NULL DEFAULT NULL,
  `pretcas` VARCHAR(255) NULL DEFAULT NULL,
  `prvi` VARCHAR(255) NULL DEFAULT NULL,
  `sedmi` VARCHAR(255) NULL DEFAULT NULL,
  `sesti` VARCHAR(255) NULL DEFAULT NULL,
  `treci` VARCHAR(255) NULL DEFAULT NULL,
  `id_odeljenje` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_n1mydvf4wtq2s2x8g32xeys49` (`id_odeljenje` ASC) VISIBLE,
  CONSTRAINT `FKjqcxwl1s03yhhittfm1b3lq8r`
    FOREIGN KEY (`id_odeljenje`)
    REFERENCES `dnevnik21`.`odeljenja` (`id_odeljenje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`ucitelji`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`ucitelji` (
  `id_ucitelj` INT(11) NOT NULL,
  PRIMARY KEY (`id_ucitelj`),
  CONSTRAINT `FKgakr9nxtj3rh6lwol8pfjifxe`
    FOREIGN KEY (`id_ucitelj`)
    REFERENCES `dnevnik21`.`korisnici` (`id_korisnik`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dnevnik21`.`utorak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dnevnik21`.`utorak` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cetvrti` VARCHAR(255) NULL DEFAULT NULL,
  `drugi` VARCHAR(255) NULL DEFAULT NULL,
  `peti` VARCHAR(255) NULL DEFAULT NULL,
  `pretcas` VARCHAR(255) NULL DEFAULT NULL,
  `prvi` VARCHAR(255) NULL DEFAULT NULL,
  `sedmi` VARCHAR(255) NULL DEFAULT NULL,
  `sesti` VARCHAR(255) NULL DEFAULT NULL,
  `treci` VARCHAR(255) NULL DEFAULT NULL,
  `id_odeljenje` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_q549lxqk2cbby5vousgme98cw` (`id_odeljenje` ASC) VISIBLE,
  CONSTRAINT `FKjlveljgfjao9jw0p9qj9b6k8g`
    FOREIGN KEY (`id_odeljenje`)
    REFERENCES `dnevnik21`.`odeljenja` (`id_odeljenje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
