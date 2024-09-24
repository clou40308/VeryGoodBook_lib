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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `unit_price` double NOT NULL,
  `stock` int unsigned NOT NULL,
  `photo_url` varchar(250) DEFAULT NULL,
  `category` varchar(10) NOT NULL,
  `release_date` date NOT NULL DEFAULT (curdate()),
  `description` varchar(300) NOT NULL DEFAULT '',
  `discount` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'ASUS 華碩Vivobook 15 15.6吋效能筆電藍色(i3-1215U/8GB/512GB/WIN11/X1504ZA-0181B1215U)',19900,5,'https://cs-a.ecimg.tw/items/DHAFPQA900H2SZ2/000001_1705301890.jpg','華碩','2024-07-26','Intel®Core™ i3-1215U Processor 1.2 GHz',30),(2,'ASUS ROG 華碩TUF Gaming A15 15.6吋電競筆電黑色(R5-7535HS/16GB/1TB/RTX 3050-4G/WIN11/FA506NC-0042B7535HS)',29499,10,'https://cs-a.ecimg.tw/items/DHAS4JA900H9FQB/000001_1724406567.jpg','華碩','2024-06-26','AMD Ryzen™ 5 7535HS Processor 3.3GHz',15),(3,'ACER 宏碁【Belkin旅充組】ACER Aspire 5 15.6吋 文書效能筆電灰色(i3-1305U/8GB/512GB/WIN11/A515-58P-30EZ)',13400,15,'https://cs-a.ecimg.tw/items/DHAEC91900HQNYI/000001_1724135632.jpg','宏碁','2024-08-26','最新第13代處理器',0),(4,'AVITA SATUS S102 NE15A1 粉',9999,30,'https://cs-a.ecimg.tw/items/DHAM8IA900GISH4/000001_1724407130.jpg','AVITA','2024-07-01','Intel Core i5-1235U',0),(5,'HP 惠普Pavilion Aero 13.3吋 文書效能筆電白色(R5-7535U/16GB/512GB/WIN11/13-be2014AU)',32900,23,'https://cs-a.ecimg.tw/items/DHAGGK1900HOYDV/000001_1722248710.jpg','HP 惠普','2024-06-30','輕薄機身,超高行動性:970g起,1.69cm薄，AMD最新Zen3+ R7處理器,TSMC 6nm製程,效能再提升，400nits高亮度,明亮環境下,畫面可清晰呈現',20),(6,'ACER 宏碁Predator 16吋 AI電競筆電銀色',72900,10,'https://img.pchome.com.tw/cs/items/DHAEGAA900HGCLW/000001_1725336198.jpg','宏碁','2024-07-01','最新IntelR Core  Ultra處理器，具備類神經處理元(NPU)',15),(7,'LENOVO 聯想ThinkBook 16 16吋 商用AI筆電灰色',33990,12,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMX/000001_1725956651.jpg','聯想','2024-07-15','Intel® Core™ Ultra7 155H/16G可擴充記憶體',20),(8,'LENOVO 聯想ThinkBook  商用AI筆電灰色',33990,16,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMX/000001_1725956651.jpg','聯想','2024-07-16','Intel® Core™ Ultra7 155H/16G可擴充記憶體',20),(9,'HP 惠普_ Pavilion 文書效能筆電銀色(R5-8640U/16G/512G SSD/W11/bg0051AU)',37900,9,'https://img.pchome.com.tw/cs/items/DHAG7ZA900HO6E7/000001_1723721517.jpg','HP 惠普','2024-06-15','輕薄機身,超高行動性970g起,1.69cm薄',0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-24 16:43:30
