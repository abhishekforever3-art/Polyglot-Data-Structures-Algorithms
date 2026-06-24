CREATE DATABASE  IF NOT EXISTS `rapido` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rapido`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: rapido
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `wallet_balance` decimal(10,2) DEFAULT '0.00',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `customers_chk_1` CHECK ((`wallet_balance` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,1,317.25,'2026-06-19 10:37:11'),(2,2,13.32,'2026-06-19 10:37:11'),(3,3,364.85,'2026-06-19 10:37:11'),(4,4,44.61,'2026-06-19 10:37:11'),(5,5,263.67,'2026-06-19 10:37:11'),(6,6,231.46,'2026-06-19 10:37:11'),(7,7,172.77,'2026-06-19 10:37:11'),(8,8,295.41,'2026-06-19 10:37:11'),(9,9,90.42,'2026-06-19 10:37:11'),(10,10,76.27,'2026-06-19 10:37:11'),(11,11,480.72,'2026-06-19 10:37:11'),(12,12,225.39,'2026-06-19 10:37:11'),(13,13,93.44,'2026-06-19 10:37:11'),(14,14,470.12,'2026-06-19 10:37:12'),(15,15,469.35,'2026-06-19 10:37:12'),(16,16,381.40,'2026-06-19 10:37:12'),(17,17,420.39,'2026-06-19 10:37:12'),(18,18,439.32,'2026-06-19 10:37:12'),(19,19,235.37,'2026-06-19 10:37:12'),(20,20,131.07,'2026-06-19 10:37:12'),(21,21,255.31,'2026-06-19 10:37:12'),(22,22,103.79,'2026-06-19 10:37:12'),(23,23,125.89,'2026-06-19 10:37:12'),(24,24,146.34,'2026-06-19 10:37:12'),(25,25,325.11,'2026-06-19 10:37:12'),(26,26,305.52,'2026-06-19 10:37:12'),(27,27,224.28,'2026-06-19 10:37:12'),(28,28,176.16,'2026-06-19 10:37:12'),(29,29,374.18,'2026-06-19 10:37:12'),(30,30,56.45,'2026-06-19 10:37:12'),(31,31,218.86,'2026-06-19 10:37:12'),(32,32,287.40,'2026-06-19 10:37:12'),(33,33,272.20,'2026-06-19 10:37:12'),(34,34,496.66,'2026-06-19 10:37:12'),(35,35,256.37,'2026-06-19 10:37:12');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drivers` (
  `driver_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `license_no` varchar(50) NOT NULL,
  `rating` decimal(3,2) DEFAULT '5.00',
  `availability` tinyint(1) DEFAULT '1',
  `vehicle_id` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`driver_id`),
  UNIQUE KEY `user_id` (`user_id`),
  UNIQUE KEY `license_no` (`license_no`),
  UNIQUE KEY `vehicle_id` (`vehicle_id`),
  CONSTRAINT `drivers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `drivers_ibfk_2` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`vehicle_id`) ON DELETE SET NULL,
  CONSTRAINT `drivers_chk_1` CHECK ((`rating` between 0.00 and 5.00))
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` VALUES (1,36,'DL-607262',3.86,1,1,'2026-06-19 10:37:12'),(2,37,'DL-835998',4.39,1,2,'2026-06-19 10:37:12'),(3,38,'DL-288008',4.33,1,3,'2026-06-19 10:37:12'),(4,39,'DL-780160',4.89,1,4,'2026-06-19 10:37:12'),(5,40,'DL-935848',4.21,1,5,'2026-06-19 10:37:12'),(6,41,'DL-299115',4.62,1,6,'2026-06-19 10:37:12'),(7,42,'DL-859521',4.11,1,7,'2026-06-19 10:37:12'),(8,43,'DL-883029',4.35,1,8,'2026-06-19 10:37:12'),(9,44,'DL-391416',4.42,1,9,'2026-06-19 10:37:12'),(10,45,'DL-323894',4.18,1,10,'2026-06-19 10:37:12'),(11,46,'DL-937585',4.21,1,11,'2026-06-19 10:37:12'),(12,47,'DL-543765',4.88,1,12,'2026-06-19 10:37:12'),(13,48,'DL-516125',4.40,1,13,'2026-06-19 10:37:12'),(14,49,'DL-250791',4.89,1,14,'2026-06-19 10:37:12'),(15,50,'DL-698940',3.94,1,15,'2026-06-19 10:37:12');
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fare_calculations`
--

DROP TABLE IF EXISTS `fare_calculations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fare_calculations` (
  `fare_id` int NOT NULL AUTO_INCREMENT,
  `ride_id` int NOT NULL,
  `base_fare` decimal(10,2) NOT NULL,
  `distance_fare` decimal(10,2) NOT NULL,
  `time_fare` decimal(10,2) NOT NULL,
  `surge_multiplier` decimal(3,2) DEFAULT '1.00',
  `discount` decimal(10,2) DEFAULT '0.00',
  `total_fare` decimal(10,2) NOT NULL,
  PRIMARY KEY (`fare_id`),
  UNIQUE KEY `ride_id` (`ride_id`),
  CONSTRAINT `fare_calculations_ibfk_1` FOREIGN KEY (`ride_id`) REFERENCES `rides` (`ride_id`) ON DELETE CASCADE,
  CONSTRAINT `fare_calculations_chk_1` CHECK ((`base_fare` >= 0)),
  CONSTRAINT `fare_calculations_chk_2` CHECK ((`distance_fare` >= 0)),
  CONSTRAINT `fare_calculations_chk_3` CHECK ((`time_fare` >= 0)),
  CONSTRAINT `fare_calculations_chk_4` CHECK ((`surge_multiplier` >= 1.00)),
  CONSTRAINT `fare_calculations_chk_5` CHECK ((`discount` >= 0)),
  CONSTRAINT `fare_calculations_chk_6` CHECK ((`total_fare` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fare_calculations`
--

LOCK TABLES `fare_calculations` WRITE;
/*!40000 ALTER TABLE `fare_calculations` DISABLE KEYS */;
INSERT INTO `fare_calculations` VALUES (1,1,25.00,25.44,11.85,1.20,0.00,74.75),(2,2,25.00,128.40,9.58,1.00,0.00,162.98),(3,3,25.00,19.68,9.41,1.00,0.00,54.09),(4,4,25.00,76.92,19.09,1.50,0.00,181.52),(5,5,25.00,83.88,19.56,1.00,0.00,128.44),(6,6,25.00,30.12,15.05,1.00,0.00,70.17),(7,7,25.00,43.56,13.93,1.00,0.00,82.49),(8,8,25.00,114.12,14.92,1.00,0.00,154.04),(9,9,25.00,160.92,6.89,1.00,0.00,192.81),(10,10,25.00,138.36,6.27,1.00,0.00,169.63),(11,11,25.00,149.76,9.69,1.00,0.00,184.45),(12,12,25.00,96.36,16.72,1.00,0.00,138.08),(13,13,25.00,119.04,18.71,1.20,0.00,195.30),(14,14,25.00,54.60,6.15,1.00,0.00,85.75),(15,15,25.00,38.64,18.13,1.20,0.00,98.12),(16,16,25.00,56.64,12.23,1.00,0.00,93.87),(17,17,25.00,64.56,16.13,1.20,0.00,126.83),(18,18,25.00,57.96,17.63,1.00,0.00,100.59),(19,19,25.00,177.60,15.56,1.20,0.00,261.79),(20,20,25.00,34.08,18.55,1.20,0.00,93.16),(21,21,25.00,87.24,10.47,1.00,0.00,122.71),(22,22,25.00,63.72,18.22,1.00,0.00,106.94),(23,23,25.00,168.36,15.25,1.00,0.00,208.61),(24,24,25.00,57.72,5.71,1.00,0.00,88.43),(25,25,25.00,91.80,9.38,1.00,0.00,126.18),(26,26,25.00,130.08,6.89,1.50,0.00,242.95),(27,27,25.00,23.88,18.67,1.00,0.00,67.55),(28,28,25.00,168.12,12.63,1.20,0.00,246.90),(29,29,25.00,43.20,15.32,1.50,0.00,125.28),(30,30,25.00,108.72,8.83,1.00,0.00,142.55);
/*!40000 ALTER TABLE `fare_calculations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `notification_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `message` text NOT NULL,
  `type` varchar(30) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'Unread',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`notification_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `ride_id` int NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `payment_method` varchar(20) NOT NULL,
  `payment_status` varchar(20) NOT NULL DEFAULT 'Pending',
  `transaction_id` varchar(100) DEFAULT NULL,
  `paid_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `ride_id` (`ride_id`),
  UNIQUE KEY `transaction_id` (`transaction_id`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`ride_id`) REFERENCES `rides` (`ride_id`) ON DELETE RESTRICT,
  CONSTRAINT `payments_chk_1` CHECK ((`amount` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,3,54.09,'Cash','Success','TXN906018030','2026-06-19 10:37:12'),(2,7,82.49,'Wallet','Success','TXN383966590','2026-06-19 10:37:13'),(3,8,154.04,'Wallet','Success','TXN726840591','2026-06-19 10:37:13'),(4,9,192.81,'UPI','Success','TXN110815525','2026-06-19 10:37:13'),(5,10,169.63,'UPI','Success','TXN236471641','2026-06-19 10:37:13'),(6,12,138.08,'UPI','Success','TXN751570506','2026-06-19 10:37:13'),(7,13,195.30,'Cash','Success','TXN799378028','2026-06-19 10:37:13'),(8,14,85.75,'UPI','Success','TXN487093554','2026-06-19 10:37:13'),(9,15,98.12,'Wallet','Success','TXN653390070','2026-06-19 10:37:13'),(10,18,100.59,'UPI','Success','TXN704849179','2026-06-19 10:37:13'),(11,19,261.79,'Cash','Success','TXN660215435','2026-06-19 10:37:13'),(12,20,93.16,'UPI','Success','TXN309667190','2026-06-19 10:37:13'),(13,21,122.71,'UPI','Success','TXN551449554','2026-06-19 10:37:13'),(14,22,106.94,'Cash','Success','TXN485981371','2026-06-19 10:37:13'),(15,23,208.61,'Card','Success','TXN875007639','2026-06-19 10:37:13'),(16,24,88.43,'Card','Success','TXN786704911','2026-06-19 10:37:13'),(17,25,126.18,'Wallet','Success','TXN190251657','2026-06-19 10:37:13'),(18,26,242.95,'Cash','Success','TXN518709103','2026-06-19 10:37:14'),(19,30,142.55,'Wallet','Success','TXN345490453','2026-06-19 10:37:14');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rides`
--

DROP TABLE IF EXISTS `rides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rides` (
  `ride_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `driver_id` int DEFAULT NULL,
  `pickup_location` varchar(255) NOT NULL,
  `drop_location` varchar(255) NOT NULL,
  `distance` decimal(5,2) NOT NULL,
  `fare` decimal(10,2) NOT NULL,
  `ride_status` varchar(20) NOT NULL DEFAULT 'Requested',
  `ride_type` varchar(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ride_id`),
  KEY `customer_id` (`customer_id`),
  KEY `driver_id` (`driver_id`),
  CONSTRAINT `rides_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON DELETE RESTRICT,
  CONSTRAINT `rides_ibfk_2` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`driver_id`) ON DELETE RESTRICT,
  CONSTRAINT `rides_chk_1` CHECK ((`distance` > 0)),
  CONSTRAINT `rides_chk_2` CHECK ((`fare` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rides`
--

LOCK TABLES `rides` WRITE;
/*!40000 ALTER TABLE `rides` DISABLE KEYS */;
INSERT INTO `rides` VALUES (1,2,13,'9701 Darlene Mall','92100 Chris Rest Apt. 206',2.12,74.75,'Cancelled','Auto','2026-06-19 10:37:12'),(2,10,1,'7870 Curtis Springs Suite 822','8265 Gentry Dam',10.70,162.98,'Cancelled','Bike','2026-06-19 10:37:12'),(3,9,8,'7373 Floyd Trace Suite 898','53684 Hunter Circles',1.64,54.09,'Completed','Auto','2026-06-19 10:37:12'),(4,16,15,'72894 Jason Lane','980 Watts Coves',6.41,181.52,'Cancelled','Bike','2026-06-19 10:37:12'),(5,24,13,'356 Kirk Mountains Suite 188','92416 Goodman Course',6.99,128.44,'Cancelled','Bike','2026-06-19 10:37:12'),(6,14,1,'58622 Arnold Well','948 Smith Curve Suite 150',2.51,70.17,'Cancelled','Bike','2026-06-19 10:37:12'),(7,29,11,'79620 Jensen Islands Suite 838','0243 Nunez Manors',3.63,82.49,'Completed','Auto','2026-06-19 10:37:13'),(8,15,10,'93795 Emily Way','01890 Kristi Streets Apt. 019',9.51,154.04,'Completed','Auto','2026-06-19 10:37:13'),(9,29,8,'3137 Rodriguez Row','682 Carol Knoll',13.41,192.81,'Completed','Bike','2026-06-19 10:37:13'),(10,23,4,'893 Darryl Junctions','608 Carr Overpass Suite 342',11.53,169.63,'Completed','Auto','2026-06-19 10:37:13'),(11,18,2,'439 Brenda Freeway Suite 420','6451 Katelyn Hollow Apt. 303',12.48,184.45,'Cancelled','Auto','2026-06-19 10:37:13'),(12,11,10,'9016 Morris Centers Apt. 390','457 Woodward Points Suite 664',8.03,138.08,'Completed','Auto','2026-06-19 10:37:13'),(13,20,15,'164 Susan Circles','667 Harris Island',9.92,195.30,'Completed','Bike','2026-06-19 10:37:13'),(14,9,15,'707 Butler Drives Apt. 106','8693 Karen Turnpike Apt. 524',4.55,85.75,'Completed','Auto','2026-06-19 10:37:13'),(15,3,15,'8278 Patricia Mountain','496 Natasha Neck',3.22,98.12,'Completed','Bike','2026-06-19 10:37:13'),(16,6,5,'67136 Chad Loaf Apt. 956','270 Smith Pike',4.72,93.87,'Cancelled','Bike','2026-06-19 10:37:13'),(17,34,12,'8388 Sarah Stream','25812 Hayes Passage',5.38,126.83,'Cancelled','Auto','2026-06-19 10:37:13'),(18,13,10,'87197 Cassandra Ramp Apt. 375','198 Raymond Coves Apt. 762',4.83,100.59,'Completed','Bike','2026-06-19 10:37:13'),(19,20,7,'160 Erickson Circles','604 Amy Path',14.80,261.79,'Completed','Bike','2026-06-19 10:37:13'),(20,17,9,'29035 Oscar Circle','06938 Scott Forest Apt. 756',2.84,93.16,'Completed','Bike','2026-06-19 10:37:13'),(21,30,13,'204 Alexander Mountains Suite 600','3325 Alice Island Suite 215',7.27,122.71,'Completed','Bike','2026-06-19 10:37:13'),(22,24,7,'03406 Buckley Pass Suite 681','34119 Irwin Fall',5.31,106.94,'Completed','Auto','2026-06-19 10:37:13'),(23,10,3,'13576 Todd Point','743 Kyle Lake Apt. 356',14.03,208.61,'Completed','Bike','2026-06-19 10:37:13'),(24,30,2,'0169 Edgar Bypass','4184 Burton Parkway',4.81,88.43,'Completed','Bike','2026-06-19 10:37:13'),(25,31,9,'26615 Jones Plains Suite 916','54133 Brown Causeway Suite 493',7.65,126.18,'Completed','Auto','2026-06-19 10:37:13'),(26,27,10,'0797 Martinez Drives','379 Roberts Unions',10.84,242.95,'Completed','Bike','2026-06-19 10:37:13'),(27,12,10,'746 Jermaine Stream','939 Casey Trail Apt. 889',1.99,67.55,'Cancelled','Bike','2026-06-19 10:37:14'),(28,26,6,'393 Wong Hollow','130 Donovan Cape Apt. 578',14.01,246.90,'Cancelled','Bike','2026-06-19 10:37:14'),(29,35,14,'329 Brock Drive','09223 Jennifer Tunnel Suite 884',3.60,125.28,'Cancelled','Bike','2026-06-19 10:37:14'),(30,9,3,'62955 Andrew Roads Suite 538','90401 Eric Drive',9.06,142.55,'Completed','Auto','2026-06-19 10:37:14');
/*!40000 ALTER TABLE `rides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'David Ferrell','+918996527055','anthony04@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(2,'Eugene Thompson','+919646648394','suzanne10@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(3,'Linda Boyd','+917643593495','iatkinson@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(4,'Dawn Ford DVM','+917845293464','ncarter@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(5,'Melissa Dalton','+919098837377','wardmitchell@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(6,'Aaron Brown','+918448887899','mary14@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(7,'Laura Newton','+918851084580','lisamiller@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(8,'Russell Chapman DVM','+919795937753','heidi15@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(9,'Kristin Robles','+918208726260','alvin71@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(10,'Benjamin Freeman','+918303940522','chapmanmegan@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(11,'Harold Shepard','+917461256877','gregorychapman@example.org','hashed_password_xyz','2026-06-19 10:37:10'),(12,'Ashley Smith','+917724195844','jdavila@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(13,'David Valenzuela','+919843068041','michael66@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(14,'Stephanie Lozano','+918046904714','gbrown@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(15,'Christopher Murphy','+919778104578','amber86@example.org','hashed_password_xyz','2026-06-19 10:37:10'),(16,'Debbie Cooper','+917223805374','theresa37@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(17,'Vanessa Leon','+918780853330','egonzales@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(18,'Karen Martin','+919371351381','stephanie92@example.org','hashed_password_xyz','2026-06-19 10:37:10'),(19,'Robert Obrien','+918946319829','austinrogers@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(20,'Patrick Smith','+919038523628','zgregory@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(21,'Christopher Bailey','+919023478646','shannongarner@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(22,'Diane Cabrera','+918609209041','joanna73@example.net','hashed_password_xyz','2026-06-19 10:37:10'),(23,'Lucas Howell','+918884636976','aowen@example.com','hashed_password_xyz','2026-06-19 10:37:10'),(24,'Sarah Duncan','+917498152411','matthew44@example.com','hashed_password_xyz','2026-06-19 10:37:11'),(25,'Jason Stevenson','+919927407158','samantha88@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(26,'Derrick Mullen','+917198625255','greenmichael@example.net','hashed_password_xyz','2026-06-19 10:37:11'),(27,'Kayla Simpson','+919318611119','ofox@example.net','hashed_password_xyz','2026-06-19 10:37:11'),(28,'Kathy Burton','+919638150061','kathrynramos@example.com','hashed_password_xyz','2026-06-19 10:37:11'),(29,'Kenneth Williams','+918396792662','maryburgess@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(30,'Carl Scott','+918128758456','rowens@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(31,'Michael Smith','+917571414706','erogers@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(32,'Jennifer Thomas','+918350299721','carrollandrew@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(33,'Rebecca Jones','+919463547432','jaylopez@example.com','hashed_password_xyz','2026-06-19 10:37:11'),(34,'Caitlin Conner','+917356104309','allen14@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(35,'Timothy Jensen','+919407760085','karendiaz@example.net','hashed_password_xyz','2026-06-19 10:37:11'),(36,'Jacqueline Huber','+917582845746','gford@example.com','hashed_password_xyz','2026-06-19 10:37:11'),(37,'Brittney Gordon','+918754895599','lindagillespie@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(38,'Mary Hughes','+917109304373','sandrathomas@example.net','hashed_password_xyz','2026-06-19 10:37:11'),(39,'Heather Mills','+919557082332','danielle55@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(40,'Keith White','+917091611210','daviddavis@example.com','hashed_password_xyz','2026-06-19 10:37:11'),(41,'Mary Jackson','+919796637064','lanceford@example.net','hashed_password_xyz','2026-06-19 10:37:11'),(42,'Melissa Taylor','+919162057195','agriffin@example.com','hashed_password_xyz','2026-06-19 10:37:11'),(43,'Alicia Taylor','+919118362185','xfitzgerald@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(44,'Susan Ortiz','+919128968692','kclark@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(45,'Cheryl Griffin','+919108991697','megan56@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(46,'Robert Dunn','+919113535212','hawkinsmelissa@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(47,'Joshua Dudley','+918722836171','kaitlinlambert@example.net','hashed_password_xyz','2026-06-19 10:37:11'),(48,'Anne Nunez','+919460822152','gutierrezmichael@example.net','hashed_password_xyz','2026-06-19 10:37:11'),(49,'Heather Spears','+918062395693','francisclaudia@example.org','hashed_password_xyz','2026-06-19 10:37:11'),(50,'Jonathan Skinner','+917318562934','chadmatthews@example.com','hashed_password_xyz','2026-06-19 10:37:11');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `vehicle_id` int NOT NULL AUTO_INCREMENT,
  `vehicle_number` varchar(20) NOT NULL,
  `vehicle_type` varchar(20) NOT NULL,
  `model` varchar(50) NOT NULL,
  `insurance_no` varchar(50) NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  UNIQUE KEY `vehicle_number` (`vehicle_number`),
  UNIQUE KEY `insurance_no` (`insurance_no`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'TS-73-FL-4382','Bike','Yamaha FZ','INS-946385'),(2,'TS-44-UT-1758','Bike','Yamaha FZ','INS-391175'),(3,'TS-24-MQ-6914','Bike','Yamaha FZ','INS-430659'),(4,'TS-64-XX-1574','Bike','Hero Splendor','INS-873685'),(5,'TS-50-WB-4911','Bike','Hero Splendor','INS-323722'),(6,'TS-74-NX-7799','Auto','Piaggio Ape','INS-858985'),(7,'TS-14-VB-7294','Bike','Honda Activa','INS-862547'),(8,'TS-46-IF-8212','Bike','Honda Activa','INS-199744'),(9,'TS-24-FD-4710','Bike','Honda Activa','INS-722607'),(10,'TS-69-VD-8970','Bike','Hero Splendor','INS-631729'),(11,'TS-85-TY-9906','Auto','Bajaj RE','INS-741443'),(12,'TS-91-SE-5880','Bike','Hero Splendor','INS-579463'),(13,'TS-53-IO-8455','Bike','Hero Splendor','INS-359177'),(14,'TS-95-ZD-7882','Auto','Bajaj RE','INS-162536'),(15,'TS-44-VF-9044','Auto','Piaggio Ape','INS-229226');
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-23 11:33:18
