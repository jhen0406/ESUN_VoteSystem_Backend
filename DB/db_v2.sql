-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: vote
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response` (
  `user_name` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `select_item` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
INSERT INTO `response` VALUES ('JJJ','101010','2;4;8;12;10;14;17'),('AAA','111','1;11;9;13'),('KKK','111111','3;5;4;11;10;15;17'),('LLL','121212','3;4;6;8;12;10;14;17'),('MMM','131313','2;4;5;9;11;14;18'),('NNN','141414','1;4;9;12;13;17;7'),('OOO','151515','3;6;8;12;10;14;17'),('BBB','222','4;2;5;10;1;15;17'),('CCC','333','3;5;7;8;11;14;15;16;6'),('DDD','444','4;7;3;11;9;13;17;18'),('EEE','555','2;8;7;12;14;18;16'),('FFF','666','3;6;5;8;11;14;16'),('GGG','777','1;5;2;7;11;12;13;18;17'),('HHH','888','2;4;6;8;7;12;13;10;15;16'),('III','999','1;5;7;9;11;13;18;16');
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `intro` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES (1,'螢幕A','ACER 13吋'),(2,'螢幕B','ACER 14吋'),(3,'螢幕C','ACER 15.6 吋'),(4,'螢幕D ','ASUS 15吋'),(5,'筆電A','ACER 13吋'),(6,'筆電B','ACER 14吋'),(7,'筆電C','ACER 15.6 吋'),(8,'筆電D ','ASUS 15吋'),(9,'螢幕A','Samsung 24吋'),(10,'螢幕B','PHILLIPS 32吋'),(11,'螢幕C','ASUS 28吋'),(12,'滑鼠A','羅技 M240'),(13,'滑鼠B','M650'),(14,'滑鼠C','羅技 M331'),(15,'滑鼠B','羅技 M650'),(16,'鍵盤A ','羅技 K780'),(17,'鍵盤B','LENOVO'),(18,'鍵盤C','MSI');
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-15 22:38:19
