CREATE TABLE IF NOT EXISTS `tipo_dispositivo` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`nome` VARCHAR(255) NOT NULL,
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO `tipo_dispositivo` (nome)
VALUES ("Atuador");

INSERT INTO `tipo_dispositivo` (nome)
VALUES ("Sensor");
