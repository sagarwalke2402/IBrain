-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: example
-- ------------------------------------------------------
-- Server version	8.0.25

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

--
-- Table structure for table `doctorinfo`
--

DROP TABLE IF EXISTS `doctorinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctorinfo` (
  `IDNo` int NOT NULL,
  `lastname` varchar(2000) NOT NULL,
  `firstname` varchar(2000) NOT NULL,
  `city` varchar(2000) NOT NULL,
  `state` varchar(2000) NOT NULL,
  `clinicid` int NOT NULL,
  PRIMARY KEY (`IDNo`),
  KEY `IDNo` (`IDNo`),
  KEY `clinicid_idx` (`clinicid`),
  CONSTRAINT `clinicid` FOREIGN KEY (`clinicid`) REFERENCES `clinicinfo` (`clinicid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctorinfo`
--

LOCK TABLES `doctorinfo` WRITE;
/*!40000 ALTER TABLE `doctorinfo` DISABLE KEYS */;
INSERT INTO `doctorinfo` VALUES (1,'***akkis***','***ihdin***','***esoj nas***','***ac***',1),(2,'******','******','***esoj nas***','***ac***',1),(3,'******','******','***esoj nas***','***ac***',2),(12,'***evitcani***','******','***esoj nas***','***ac***',1),(13,'***akkis***','***.rd***','***esoj nas***','***ac***',1),(14,'***hcneb***','***divad***','***esoj nas***','***ac***',1),(15,'***aim***','******','***esoj nas***','***ac***',2),(16,'***airravahc***','***enaid***','***esoj nas***','***ac***',2),(17,'***zenitram***','***ainos***','***esoj nas***','***ac***',2),(18,'***azne***','******','***esoj nas***','***ac***',2),(19,'***ys***','***llyrehc***','***esoj nas***','***ac***',2),(20,'***asagar***','***enitsuj***','***esoj nas***','***ac***',2),(21,'***ivel***','***elleinad***','***esoj nas***','***ac***',1),(22,'***hahs***','***inahus***','***esoj nas***','***ac***',1),(23,'***ahttahc***','***teerpnom***','***esoj nas***','***ac***',1),(24,'***ahttahc***','***teerpnom***','***esoj nas***','***ac***',1),(25,'***naod***','***yvi***','***esoj nas***','***ac***',1),(26,'***nosnikcid***','***aicirtap***','***esoj nas***','***ac***',1),(27,'***godiba***','***akilegna***','***esoj nas***','***ac***',2),(28,'***iloposab***','***aztiram***','***esoj nas***','***ac***',1),(29,'***lagirdam***','***nimzaj***','***esoj nas***','***ac***',1),(30,'***deys magleb***','***aizahs***','***esoj nas***','***ac***',1),(31,'***zenemij***','***ysiad***','***esoj nas***','***ac***',1),(32,'***deys magleb***','***aizahs***','***esoj nas***','***ac***',1);
/*!40000 ALTER TABLE `doctorinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-30 13:11:17
