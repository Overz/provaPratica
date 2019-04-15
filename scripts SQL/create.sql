CREATE SCHEMA `caminhosuave` ;

CREATE TABLE `caminhosuave`.`ALUNO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `sobrenome` VARCHAR(45) NULL,
  `matricula` VARCHAR(45) NOT NULL,
  `nota_P1` DOUBLE NULL,
  `nota_P2` DOUBLE NULL,
  `nota_T1` DOUBLE NOT NULL,
  `nota_T2` DOUBLE NOT NULL ,
  `notapesoprova` DOUBLE NOT NULL ,
  `notapesotrabalho` DOUBLE NOT NULL ,
  `nivel` VARCHAR(45) NOT NULL AFTER,
  `nota_final` DOUBLE NULL,
  `situacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC));

