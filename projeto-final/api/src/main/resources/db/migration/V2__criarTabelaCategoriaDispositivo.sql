CREATE TABLE IF NOT EXISTS `categoria_dispositivo` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`nome` VARCHAR(255) NOT NULL,
	`medida` VARCHAR(2) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO `categoria_dispositivo` (nome, medida)
VALUES ("Temperatura", "ºC");

INSERT INTO `categoria_dispositivo` (nome, medida)
VALUES ("Umidade do solo", "%");

INSERT INTO `categoria_dispositivo` (nome, medida)
VALUES ("Umidade do Ar", "%");
