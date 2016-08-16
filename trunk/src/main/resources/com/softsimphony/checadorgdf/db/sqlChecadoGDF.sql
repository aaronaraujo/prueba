/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jesushl
 * Created: 16-ago-2016
 */

-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: BDChecadorGDF
-- ------------------------------------------------------
-- Server version	5.6.30-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Area`
--

DROP TABLE IF EXISTS `Area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Area` (
  `idArea` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idArea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Area`
--

LOCK TABLES `Area` WRITE;
/*!40000 ALTER TABLE `Area` DISABLE KEYS */;
/*!40000 ALTER TABLE `Area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Horario`
--

DROP TABLE IF EXISTS `Horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Horario` (
  `idHorario` int(11) NOT NULL,
  `horaInicial` date DEFAULT NULL,
  `horaFinal` date DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Horario`
--

LOCK TABLES `Horario` WRITE;
/*!40000 ALTER TABLE `Horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reporte`
--

DROP TABLE IF EXISTS `Reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reporte` (
  `idReporte` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idArear` int(11) DEFAULT NULL,
  `horaRegistro` date DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `idTipoRegistro` int(11) DEFAULT NULL,
  `horaIdeal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReporte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reporte`
--

LOCK TABLES `Reporte` WRITE;
/*!40000 ALTER TABLE `Reporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoRegistro`
--

DROP TABLE IF EXISTS `TipoRegistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoRegistro` (
  `idTipoRegistro` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idTipoRegistro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoRegistro`
--

LOCK TABLES `TipoRegistro` WRITE;
/*!40000 ALTER TABLE `TipoRegistro` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoRegistro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `aPaterno` varchar(30) DEFAULT NULL,
  `aMaterno` varchar(30) DEFAULT NULL,
  `huellaDigital` varchar(500) DEFAULT NULL,
  `idHorario` int(11) DEFAULT NULL,
  `idArea` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-16 14:08:32