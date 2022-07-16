CREATE TABLE IF NOT EXISTS `nicho` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`posicaoHorizontal` int NOT NULL,
	`idPrateleira` BIGINT(20) NOT NULL,
    CONSTRAINT `fk_prateleira` FOREIGN KEY (`idPrateleira`) REFERENCES `prateleira`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
