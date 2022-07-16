CREATE TABLE IF NOT EXISTS `dispositivo` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`value` FLOAT(2) NOT NULL,
	`idEstante` BIGINT(20) NOT NULL,
    `idTipoDispositivo` BIGINT(20) NOT NULL,
    `idCategoriaDispositivo` BIGINT(20) NOT NULL,
    `idNicho` BIGINT(20) NOT NULL,
    CONSTRAINT `fk_estante` FOREIGN KEY (`idEstante`) REFERENCES `estante`(`id`),
    CONSTRAINT `fk_tipoDispositivo` FOREIGN KEY (`idTipoDispositivo`) REFERENCES `tipo_dispositivo`(`id`),
    CONSTRAINT `fk_categoriaDispositivo` FOREIGN KEY (`idCategoriaDispositivo`) REFERENCES `categoria_dispositivo`(`id`),
    CONSTRAINT `fk_nicho` FOREIGN KEY (`idNicho`) REFERENCES `nicho`(`id`),
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
