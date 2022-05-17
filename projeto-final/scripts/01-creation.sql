-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db
-- ------------------------------------------------------
-- Server version	5.7.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE locadora;
USE locadora;

--
-- Table structure for table `CARRO`
--

DROP TABLE IF EXISTS `CARRO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CARRO` (
  `id_carro` varchar(20) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `ano` int(11) NOT NULL,
  `km_atual` float DEFAULT NULL,
  `status_locacao` varchar(45) DEFAULT NULL,
  `num_max_dias` int(11) DEFAULT NULL,
  `codigoQR` varchar(45) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_carro`),
  KEY `FK_CARRO_CATEGORIA_idx` (`id_categoria`),
  CONSTRAINT `FK_CARRO_CATEGORIA` FOREIGN KEY (`id_categoria`) REFERENCES `CATEGORIA` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CARRO`
--

LOCK TABLES `CARRO` WRITE;
/*!40000 ALTER TABLE `CARRO` DISABLE KEYS */;
/*!40000 ALTER TABLE `CARRO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORIA`
--

DROP TABLE IF EXISTS `CATEGORIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CATEGORIA` (
  `id_categoria` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `preco_diario` float NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORIA`
--

LOCK TABLES `CATEGORIA` WRITE;
/*!40000 ALTER TABLE `CATEGORIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `CATEGORIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CONTATO`
--

DROP TABLE IF EXISTS `CONTATO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CONTATO` (
  `id_contato` varchar(20) NOT NULL,
  `telefoneResidencial` varchar(45) DEFAULT NULL,
  `telefoneComercial` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `id_pessoa` varchar(20) NOT NULL,
  PRIMARY KEY (`id_contato`),
  KEY `FK_CONTATO_PESSOA_idx` (`id_pessoa`),
  CONSTRAINT `FK_CONTATO_PESSOA` FOREIGN KEY (`id_pessoa`) REFERENCES `PESSOA` (`id_pessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CONTATO`
--

LOCK TABLES `CONTATO` WRITE;
/*!40000 ALTER TABLE `CONTATO` DISABLE KEYS */;
/*!40000 ALTER TABLE `CONTATO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DEVOLUCAO`
--

DROP TABLE IF EXISTS `DEVOLUCAO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DEVOLUCAO` (
  `id_devolucao` varchar(20) NOT NULL,
  `data` datetime NOT NULL,
  `valor_total` float NOT NULL,
  `id_locacao` varchar(20) NOT NULL,
  PRIMARY KEY (`id_devolucao`),
  KEY `FK_DEVOLUCAO_LOCACAO_idx` (`id_locacao`),
  CONSTRAINT `FK_DEVOLUCAO_LOCACAO` FOREIGN KEY (`id_locacao`) REFERENCES `LOCACAO` (`id_locacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEVOLUCAO`
--

LOCK TABLES `DEVOLUCAO` WRITE;
/*!40000 ALTER TABLE `DEVOLUCAO` DISABLE KEYS */;
/*!40000 ALTER TABLE `DEVOLUCAO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENDERECO`
--

DROP TABLE IF EXISTS `ENDERECO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENDERECO` (
  `id_endereco` varchar(20) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENDERECO`
--

LOCK TABLES `ENDERECO` WRITE;
/*!40000 ALTER TABLE `ENDERECO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENDERECO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENDERECO_PESSOA`
--

DROP TABLE IF EXISTS `ENDERECO_PESSOA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENDERECO_PESSOA` (
  `fk_pessoa` varchar(20) NOT NULL,
  `fk_endereco` varchar(20) NOT NULL,
  KEY `FK_PESSOA_ENDERECO_idx` (`fk_pessoa`),
  KEY `FK_ENDERECO_PESSOA_idx` (`fk_endereco`),
  CONSTRAINT `FK_ENDERECO_PESSOA` FOREIGN KEY (`fk_endereco`) REFERENCES `ENDERECO` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PESSOA_ENDERECO` FOREIGN KEY (`fk_pessoa`) REFERENCES `PESSOA` (`id_pessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENDERECO_PESSOA`
--

LOCK TABLES `ENDERECO_PESSOA` WRITE;
/*!40000 ALTER TABLE `ENDERECO_PESSOA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENDERECO_PESSOA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FATURA`
--

DROP TABLE IF EXISTS `FATURA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FATURA` (
  `id_fatura` int(11) NOT NULL,
  `quantidade_parcelas` int(11) NOT NULL,
  `forma_pagamento` varchar(45) NOT NULL,
  `valor_total` float NOT NULL,
  `id_locacao` varchar(20) NOT NULL,
  PRIMARY KEY (`id_fatura`),
  KEY `FK_LOCACAO_FATURA_idx` (`id_locacao`),
  CONSTRAINT `FK_LOCACAO_FATURA` FOREIGN KEY (`id_locacao`) REFERENCES `LOCACAO` (`id_locacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FATURA`
--

LOCK TABLES `FATURA` WRITE;
/*!40000 ALTER TABLE `FATURA` DISABLE KEYS */;
/*!40000 ALTER TABLE `FATURA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FISICA`
--

DROP TABLE IF EXISTS `FISICA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FISICA` (
  `id_fisica` varchar(20) NOT NULL,
  `nascimento` datetime NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `fk_pessoa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_fisica`),
  KEY `FK_PESSOA_FISICA_idx` (`fk_pessoa`),
  CONSTRAINT `FK_PESSOA_FISICA` FOREIGN KEY (`fk_pessoa`) REFERENCES `PESSOA` (`id_pessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FISICA`
--

LOCK TABLES `FISICA` WRITE;
/*!40000 ALTER TABLE `FISICA` DISABLE KEYS */;
/*!40000 ALTER TABLE `FISICA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ITEM`
--

DROP TABLE IF EXISTS `ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ITEM` (
  `id_item` varchar(20) NOT NULL,
  `previsao_devolucao` datetime DEFAULT NULL,
  `km_devolucao` float DEFAULT NULL,
  `diarias` int(11) DEFAULT NULL,
  `id_devolucao` varchar(20) DEFAULT NULL,
  `id_locacao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `FK_ITEM_DEVOLUCAO_idx` (`id_devolucao`),
  KEY `FK_ITEM_LOCACAO_idx` (`id_locacao`),
  CONSTRAINT `FK_ITEM_DEVOLUCAO` FOREIGN KEY (`id_devolucao`) REFERENCES `DEVOLUCAO` (`id_devolucao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ITEM_LOCACAO` FOREIGN KEY (`id_locacao`) REFERENCES `LOCACAO` (`id_locacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEM`
--

LOCK TABLES `ITEM` WRITE;
/*!40000 ALTER TABLE `ITEM` DISABLE KEYS */;
/*!40000 ALTER TABLE `ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JURIDICA`
--

DROP TABLE IF EXISTS `JURIDICA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `JURIDICA` (
  `id_juridica` varchar(20) NOT NULL,
  `CNPJ` varchar(45) NOT NULL,
  `fk_pessoa` varchar(20) NOT NULL,
  PRIMARY KEY (`id_juridica`),
  KEY `FK_PESSOA_JURIDICA_idx` (`fk_pessoa`),
  CONSTRAINT `FK_PESSOA_JURIDICA` FOREIGN KEY (`fk_pessoa`) REFERENCES `PESSOA` (`id_pessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JURIDICA`
--

LOCK TABLES `JURIDICA` WRITE;
/*!40000 ALTER TABLE `JURIDICA` DISABLE KEYS */;
/*!40000 ALTER TABLE `JURIDICA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOCACAO`
--

DROP TABLE IF EXISTS `LOCACAO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LOCACAO` (
  `id_locacao` varchar(20) NOT NULL,
  `data` datetime NOT NULL,
  `status` varchar(45) NOT NULL,
  `id_pessoa` varchar(20) NOT NULL,
  PRIMARY KEY (`id_locacao`),
  KEY `FK_LOCACAO_PESSOA_idx` (`id_pessoa`),
  CONSTRAINT `FK_LOCACAO_PESSOA` FOREIGN KEY (`id_pessoa`) REFERENCES `PESSOA` (`id_pessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOCACAO`
--

LOCK TABLES `LOCACAO` WRITE;
/*!40000 ALTER TABLE `LOCACAO` DISABLE KEYS */;
/*!40000 ALTER TABLE `LOCACAO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PARCELA`
--

DROP TABLE IF EXISTS `PARCELA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PARCELA` (
  `id_parcela` int(11) NOT NULL,
  `vencimento` datetime NOT NULL,
  `pagamento` datetime DEFAULT NULL,
  `valor` float NOT NULL,
  `juros` float DEFAULT NULL,
  `multa` float DEFAULT NULL,
  `id_fatura` int(11) NOT NULL,
  PRIMARY KEY (`id_parcela`),
  KEY `FK_PARCELA_FATURA_idx` (`id_fatura`),
  CONSTRAINT `FK_PARCELA_FATURA` FOREIGN KEY (`id_fatura`) REFERENCES `FATURA` (`id_fatura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PARCELA`
--

LOCK TABLES `PARCELA` WRITE;
/*!40000 ALTER TABLE `PARCELA` DISABLE KEYS */;
/*!40000 ALTER TABLE `PARCELA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PESSOA`
--

DROP TABLE IF EXISTS `PESSOA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PESSOA` (
  `id_pessoa` varchar(20) NOT NULL,
  `nome` varchar(80) NOT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PESSOA`
--

LOCK TABLES `PESSOA` WRITE;
/*!40000 ALTER TABLE `PESSOA` DISABLE KEYS */;
/*!40000 ALTER TABLE `PESSOA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SERVICO`
--

DROP TABLE IF EXISTS `SERVICO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SERVICO` (
  `id_servico` varchar(20) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  `id_item` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_servico`),
  KEY `FK_SERVICO_ITEM_idx` (`id_item`),
  CONSTRAINT `FK_SERVICO_ITEM` FOREIGN KEY (`id_item`) REFERENCES `ITEM` (`id_item`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SERVICO`
--

LOCK TABLES `SERVICO` WRITE;
/*!40000 ALTER TABLE `SERVICO` DISABLE KEYS */;
/*!40000 ALTER TABLE `SERVICO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-08 19:11:10