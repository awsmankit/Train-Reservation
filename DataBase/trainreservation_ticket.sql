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
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `TicketNo` int NOT NULL AUTO_INCREMENT,
  `TrainNo` int DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  `BookDate` date DEFAULT NULL,
  `PassengerId` int DEFAULT NULL,
  `PaymentStatus` varchar(20) DEFAULT NULL,
  `TrainDate` date DEFAULT NULL,
  PRIMARY KEY (`TicketNo`),
  UNIQUE KEY `PassengerId` (`PassengerId`),
  KEY `TrainNo` (`TrainNo`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`TrainNo`) REFERENCES `train` (`TrainNo`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`PassengerId`) REFERENCES `passenger` (`PassengerId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,101,2,'2022-04-14',608,'sucess','2022-05-10'),(2,100,2,'2022-04-14',585,'sucess','2022-05-10'),(3,102,2,'2022-04-14',586,'sucess','2022-05-10'),(4,105,2,'2022-04-14',587,'sucess','2022-05-10'),(5,108,2,'2022-04-14',588,'sucess','2022-05-10'),(6,108,2,'2022-04-14',589,'sucess','2022-05-10'),(7,108,2,'2022-04-14',590,'sucess','2022-05-10'),(8,105,2,'2022-04-14',591,'sucess','2022-05-10'),(9,105,2,'2022-04-14',592,'sucess','2022-05-10'),(10,101,2,'2022-04-14',609,'sucess','2022-05-10'),(11,101,2,'2022-04-14',607,'sucess','2022-05-10'),(12,101,2,'2022-04-14',595,'sucess','2022-05-10'),(13,100,2,'2022-04-14',598,'sucess','2022-05-10'),(14,100,2,'2022-04-14',599,'sucess','2022-05-10'),(15,100,2,'2022-04-14',600,'sucess','2022-05-10'),(16,100,2,'2022-04-14',601,'sucess','2020-02-10'),(17,100,2,'2022-04-14',602,'sucess','2020-02-10'),(18,100,2,'2022-04-14',603,'sucess','2020-02-10'),(19,100,2,'2022-04-14',604,'sucess','2020-02-10'),(20,100,2,'2022-04-14',605,'sucess','2022-05-10');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-14 12:58:49
