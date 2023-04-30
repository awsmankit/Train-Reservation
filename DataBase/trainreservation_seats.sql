-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: trainreservation
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `SeatStatus` varchar(20) DEFAULT NULL,
  `PassengerId` int DEFAULT NULL,
  `SeatNo` int NOT NULL,
  `TrainNo` int NOT NULL,
  `TrainDate` date NOT NULL,
  PRIMARY KEY (`TrainNo`,`SeatNo`,`TrainDate`),
  KEY `PassengerId` (`PassengerId`),
  CONSTRAINT `seats_ibfk_1` FOREIGN KEY (`PassengerId`) REFERENCES `passenger` (`PassengerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES ('sucess',601,1,100,'2020-02-10'),('sucess',585,1,100,'2022-05-10'),('sucess',602,2,100,'2020-02-10'),('sucess',598,2,100,'2022-05-10'),('sucess',603,3,100,'2020-02-10'),('sucess',599,3,100,'2022-05-10'),('sucess',604,4,100,'2020-02-10'),('sucess',600,4,100,'2022-05-10'),('sucess',605,5,100,'2022-05-10'),('sucess',608,1,101,'2022-05-10'),('sucess',609,2,101,'2022-05-10'),('sucess',607,3,101,'2022-05-10'),('sucess',595,4,101,'2022-05-10'),('sucess',586,1,102,'2022-05-10'),('sucess',587,1,105,'2022-05-10'),('sucess',591,2,105,'2022-05-10'),('sucess',592,3,105,'2022-05-10'),('sucess',588,1,108,'2022-05-10'),('sucess',589,2,108,'2022-05-10'),('sucess',590,3,108,'2022-05-10');
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-14 12:58:50
