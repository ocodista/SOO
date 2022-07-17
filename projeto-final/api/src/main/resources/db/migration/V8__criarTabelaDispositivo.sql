CREATE TABLE IF NOT EXISTS `dispositivo` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`value` FLOAT(2) NOT NULL,
	`idEstante` BIGINT(20) NOT NULL,
    `idTipoDispositivo` BIGINT(20) NOT NULL,
    `idCategoriaDispositivo` BIGINT(20) NOT NULL,
    `idNicho` BIGINT(20) NOT NULL,
    FOREIGN KEY (`idEstante`) REFERENCES `estante`(`id`),
    FOREIGN KEY (`idTipoDispositivo`) REFERENCES `tipo_dispositivo`(`id`),
    FOREIGN KEY (`idCategoriaDispositivo`) REFERENCES `categoria_dispositivo`(`id`),
    FOREIGN KEY (`idNicho`) REFERENCES `nicho`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
