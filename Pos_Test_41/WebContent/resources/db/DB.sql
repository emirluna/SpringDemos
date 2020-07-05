CREATE DATABASE  IF NOT EXISTS `pos_test_02` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pos_test_02`;
-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: pos_test_02
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `state` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `street` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `number` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (1,'Mexico','Tlaxcala','Nativitas','Canal San Ignacio','10'),(2,'Mexico','Tlaxcala','Nativitas','Canal San Ignacio','10'),(3,'Mexico','Tlaxcala','Nativitas','Canal San Ignacio','10'),(4,'Mexico','Tlaxcala','Nativitas','Canal San Ignacio','10'),(5,'Mexico','Tlaxcala','Nativitas','Canal San Ignacio','10'),(6,'Mexico','Tlaxcala','Nativitas','Canal San Ignacio','10');
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Branch`
--

DROP TABLE IF EXISTS `Branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Branch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_address` int DEFAULT NULL,
  `id_enterprise` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ATTENDANT_idx` (`id_address`),
  KEY `FK_ENTERPRISE_idx` (`id_enterprise`),
  CONSTRAINT `FK_ADDRESS_BRANCH` FOREIGN KEY (`id_address`) REFERENCES `Address` (`id`),
  CONSTRAINT `FK_BRANCH_ENTERPRISE` FOREIGN KEY (`id_enterprise`) REFERENCES `Enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Branch`
--

LOCK TABLES `Branch` WRITE;
/*!40000 ALTER TABLE `Branch` DISABLE KEYS */;
INSERT INTO `Branch` VALUES (1,'Atoyatenco',2,3),(2,'Atoyatenco',3,4),(3,'Tepetitla',4,5),(4,'Tlaxacala',NULL,5),(5,'Apizaco',NULL,5),(6,'Apizaco',NULL,6),(7,'Apizaco',6,7),(8,'Apizaco',5,7);
/*!40000 ALTER TABLE `Branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Branch_Product_Stock`
--

DROP TABLE IF EXISTS `Branch_Product_Stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Branch_Product_Stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock` int DEFAULT NULL,
  `min_stock` int DEFAULT NULL,
  `max_stock` int DEFAULT NULL,
  `id_branch` int DEFAULT NULL,
  `id_product` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_P_idx` (`id_product`),
  KEY `FK_B_idx` (`id_branch`),
  CONSTRAINT `FK_B` FOREIGN KEY (`id_branch`) REFERENCES `Branch` (`id`),
  CONSTRAINT `FK_P` FOREIGN KEY (`id_product`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Branch_Product_Stock`
--

LOCK TABLES `Branch_Product_Stock` WRITE;
/*!40000 ALTER TABLE `Branch_Product_Stock` DISABLE KEYS */;
INSERT INTO `Branch_Product_Stock` VALUES (1,10,2,50,3,3),(2,10,2,50,4,3),(3,10,2,50,4,2);
/*!40000 ALTER TABLE `Branch_Product_Stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Branch_Users`
--

DROP TABLE IF EXISTS `Branch_Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Branch_Users` (
  `branch_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`branch_id`,`user_id`),
  KEY `FK_USERS_BRANCH_idx` (`user_id`),
  CONSTRAINT `FK_BRANCHES` FOREIGN KEY (`branch_id`) REFERENCES `Branch` (`id`),
  CONSTRAINT `FK_USERS_BRANCH` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Branch_Users`
--

LOCK TABLES `Branch_Users` WRITE;
/*!40000 ALTER TABLE `Branch_Users` DISABLE KEYS */;
/*!40000 ALTER TABLE `Branch_Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BranchProduct`
--

DROP TABLE IF EXISTS `BranchProduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BranchProduct` (
  `id_stock` int NOT NULL,
  `id_product` int NOT NULL,
  `id_branch` int NOT NULL,
  PRIMARY KEY (`id_stock`,`id_product`,`id_branch`),
  KEY `FK_PRODUCT_idx` (`id_product`),
  KEY `FK_BRANCH_idx` (`id_branch`),
  KEY `FK_STOCK_idx` (`id_stock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BranchProduct`
--

LOCK TABLES `BranchProduct` WRITE;
/*!40000 ALTER TABLE `BranchProduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `BranchProduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'Lacteos'),(2,'Quesos');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enterprise`
--

DROP TABLE IF EXISTS `Enterprise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Enterprise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `area` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_address` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ADDRESS_idx` (`id_address`),
  CONSTRAINT `FK_ADDRESS` FOREIGN KEY (`id_address`) REFERENCES `Address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enterprise`
--

LOCK TABLES `Enterprise` WRITE;
/*!40000 ALTER TABLE `Enterprise` DISABLE KEYS */;
INSERT INTO `Enterprise` VALUES (1,'Arem-Soft','Software',NULL),(2,'Happy-Code','Software',1),(3,'Happy-Code','Software',2),(4,'Happy-Code','Software',3),(5,'Smart-Code','Software',4),(6,'Smart-Code','Software',NULL),(7,'Smart-Code','Software',6);
/*!40000 ALTER TABLE `Enterprise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `short_name` varchar(10) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `measure` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `barcode` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_category` int DEFAULT NULL,
  `id_detail` int DEFAULT NULL,
  `id_enterprise` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CATEGORY_idx` (`id_category`),
  KEY `FK_DETAIL_idx` (`id_detail`),
  KEY `FK_PRODUCT_ENTERPRISE_idx` (`id_enterprise`),
  CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`id_category`) REFERENCES `Category` (`id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`id_detail`) REFERENCES `Product_Detail` (`id`),
  CONSTRAINT `FK_PRODUCT_ENTERPRISE` FOREIGN KEY (`id_enterprise`) REFERENCES `Enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,'Leche de Chocolate','chocoleche',1,11,'1234567789',1,1,NULL),(2,'Yogurt de fresa','yogfre',2,6,'123123123',1,2,NULL),(3,'Queso Blanco','blanco',2,30.45,'222211221',2,3,7);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product_Detail`
--

DROP TABLE IF EXISTS `Product_Detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product_Detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `description` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product_Detail`
--

LOCK TABLES `Product_Detail` WRITE;
/*!40000 ALTER TABLE `Product_Detail` DISABLE KEYS */;
INSERT INTO `Product_Detail` VALUES (1,'Lala','Leche sabor a chocolate'),(2,'Alpura','Yogurt sabor fresa de 50 gr'),(3,'La vaquita','500 gr de queso blanco');
/*!40000 ALTER TABLE `Product_Detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Stock`
--

DROP TABLE IF EXISTS `Stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock` int DEFAULT NULL,
  `min_stock` int DEFAULT NULL,
  `max_stock` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Stock`
--

LOCK TABLES `Stock` WRITE;
/*!40000 ALTER TABLE `Stock` DISABLE KEYS */;
INSERT INTO `Stock` VALUES (2,10,2,50),(3,10,2,50);
/*!40000 ALTER TABLE `Stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `last_name` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_address` int DEFAULT NULL,
  `id_enterprise` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ENTERPRISE_idx` (`id_enterprise`),
  KEY `FK_USER_ADDRESS_idx` (`id_address`),
  CONSTRAINT `FK_ENTERPRISE` FOREIGN KEY (`id_enterprise`) REFERENCES `Enterprise` (`id`),
  CONSTRAINT `FK_USER_ADDRESS` FOREIGN KEY (`id_address`) REFERENCES `Address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-04 22:07:20
