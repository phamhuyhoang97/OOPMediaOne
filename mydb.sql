-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `idBill` varchar(10) NOT NULL,
  `billDate` date NOT NULL,
  `billType` int(11) NOT NULL,
  `billTotal` double NOT NULL,
  PRIMARY KEY (`idBill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_book`
--

DROP TABLE IF EXISTS `bill_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_book` (
  `idBill` varchar(10) NOT NULL,
  `idBook` varchar(10) NOT NULL,
  `billAmount` int(11) NOT NULL,
  PRIMARY KEY (`idBill`,`idBook`),
  KEY `fk_bill_has_book_book1_idx` (`idBook`),
  KEY `fk_bill_has_book_bill_idx` (`idBill`),
  CONSTRAINT `fk_bill_has_book_bill` FOREIGN KEY (`idBill`) REFERENCES `bill` (`idBill`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_has_book_book1` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_book`
--

LOCK TABLES `bill_book` WRITE;
/*!40000 ALTER TABLE `bill_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_film`
--

DROP TABLE IF EXISTS `bill_film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_film` (
  `idBill` varchar(10) NOT NULL,
  `idFilm` varchar(10) NOT NULL,
  `billAmount` int(11) NOT NULL,
  PRIMARY KEY (`idBill`,`idFilm`),
  KEY `fk_bill_has_film_film1_idx` (`idFilm`),
  KEY `fk_bill_has_film_bill1_idx` (`idBill`),
  CONSTRAINT `fk_bill_has_film_bill1` FOREIGN KEY (`idBill`) REFERENCES `bill` (`idBill`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_has_film_film1` FOREIGN KEY (`idFilm`) REFERENCES `film` (`idFilm`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_film`
--

LOCK TABLES `bill_film` WRITE;
/*!40000 ALTER TABLE `bill_film` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_music`
--

DROP TABLE IF EXISTS `bill_music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_music` (
  `idBill` varchar(10) NOT NULL,
  `idMusic` varchar(10) NOT NULL,
  `billAmount` int(11) NOT NULL,
  PRIMARY KEY (`idBill`,`idMusic`),
  KEY `fk_bill_has_music_music1_idx` (`idMusic`),
  KEY `fk_bill_has_music_bill1_idx` (`idBill`),
  CONSTRAINT `fk_bill_has_music_bill1` FOREIGN KEY (`idBill`) REFERENCES `bill` (`idBill`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_has_music_music1` FOREIGN KEY (`idMusic`) REFERENCES `music` (`idMusic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_music`
--

LOCK TABLES `bill_music` WRITE;
/*!40000 ALTER TABLE `bill_music` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `idBook` varchar(10) NOT NULL,
  `bookName` varchar(45) NOT NULL,
  `bookAmount` int(11) NOT NULL,
  `bookPrice` double NOT NULL,
  `bookCost` double NOT NULL,
  `bookAuthor` varchar(45) NOT NULL,
  `bookPublic` varchar(45) NOT NULL,
  PRIMARY KEY (`idBook`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `idEmployee` varchar(10) NOT NULL,
  `employeeName` varchar(45) NOT NULL,
  `employeePhone` varchar(15) NOT NULL,
  `employeeEmail` varchar(45) NOT NULL,
  `employeePassword` varchar(45) NOT NULL,
  `employeeAddress` varchar(45) NOT NULL,
  `employeeSalary` double NOT NULL,
  `status` int(11) NOT NULL,
  `checkAdmin` varchar(20) NOT NULL,
  `beginDate` date NOT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`idEmployee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('EM1','hieu','1234','hieu1','1','ha noi',20145,1,'1','2017-12-10',NULL),('EM2','admin','admin','admin','admin','ha noi',0,1,'0','2017-12-10',NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `idFilm` varchar(10) NOT NULL,
  `filmName` varchar(45) NOT NULL,
  `filmAmount` int(11) NOT NULL,
  `filmPrice` double NOT NULL,
  `filmCost` double NOT NULL,
  `filmActor` varchar(45) NOT NULL,
  `filmDirector` varchar(45) NOT NULL,
  PRIMARY KEY (`idFilm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music` (
  `idMusic` varchar(10) NOT NULL,
  `musicName` varchar(45) NOT NULL,
  `musicAmount` int(11) NOT NULL,
  `musicPrice` double NOT NULL,
  `musicCost` double NOT NULL,
  `musicSinger` varchar(45) NOT NULL,
  `musicCategory` varchar(45) NOT NULL,
  PRIMARY KEY (`idMusic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_cost`
--

DROP TABLE IF EXISTS `other_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `other_cost` (
  `idCost` int(11) NOT NULL AUTO_INCREMENT,
  `costDate` date NOT NULL,
  `costName` varchar(45) NOT NULL,
  `costMoney` double NOT NULL,
  `costType` int(11) NOT NULL,
  PRIMARY KEY (`idCost`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_cost`
--

LOCK TABLES `other_cost` WRITE;
/*!40000 ALTER TABLE `other_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `other_cost` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10 12:02:22
