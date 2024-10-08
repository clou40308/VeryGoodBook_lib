-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: vgb
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `product_cpu`
--

DROP TABLE IF EXISTS `product_cpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_cpu` (
  `product_id` int NOT NULL,
  `cpu_name` varchar(25) NOT NULL,
  `release_date` date DEFAULT NULL,
  `photo_url` varchar(250) DEFAULT NULL,
  `stock` int NOT NULL,
  `ordinal` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`,`cpu_name`),
  CONSTRAINT `FKEY_product_cpu_TO_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_cpu`
--

LOCK TABLES `product_cpu` WRITE;
/*!40000 ALTER TABLE `product_cpu` DISABLE KEYS */;
INSERT INTO `product_cpu` VALUES (6,'Ultra 7','2024-07-10','https://img.pchome.com.tw/cs/items/DHAEGAA900HE4MS/000001_1725335836.jpg',21,1),(6,'Ultra 9','2024-07-01','https://img.pchome.com.tw/cs/items/DHAEGAA900HGCLW/000001_1725336198.jpg',10,2),(7,'Ultra 5','2024-07-24','https://img.pchome.com.tw/cs/items/DHAD6GA900HHJN1/000001_1725956602.jpg',15,3),(7,'Ultra 7','2024-07-15','https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMX/000001_1725956651.jpg',12,4),(8,'Ultra 5','2024-07-17','https://img.pchome.com.tw/cs/items/DHAD6GA900HHJN1/000001_1725956602.jpg',49,6),(8,'Ultra 7','2024-07-16','https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMX/000001_1725956651.jpg',43,5);
/*!40000 ALTER TABLE `product_cpu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-08 10:25:51
