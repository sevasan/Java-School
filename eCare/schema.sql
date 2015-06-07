-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: ecare_db
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `contract_options`
--

DROP TABLE IF EXISTS `contract_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_options` (
  `id_contract` int(11) NOT NULL,
  `id_option` int(11) NOT NULL,
  KEY `id_contract` (`id_contract`),
  KEY `id_option` (`id_option`),
  CONSTRAINT `contract_options_ibfk_1` FOREIGN KEY (`id_contract`) REFERENCES `contracts` (`id_contracts`),
  CONSTRAINT `contract_options_ibfk_2` FOREIGN KEY (`id_option`) REFERENCES `options` (`id_options`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contracts`
--

DROP TABLE IF EXISTS `contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contracts` (
  `id_contracts` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber_contracts` varchar(45) NOT NULL,
  `isBlockedByClient_contracts` bit(1) NOT NULL,
  `isBlockedByOperator_contracts` bit(1) NOT NULL,
  `id_client_contracts` int(11) DEFAULT NULL,
  `id_plan_contracts` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_contracts`),
  UNIQUE KEY `unique_phoneNumber_contracts` (`phoneNumber_contracts`),
  KEY `id_client_contracts` (`id_client_contracts`),
  KEY `id_plan_contracts` (`id_plan_contracts`),
  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`id_client_contracts`) REFERENCES `users` (`id_users`),
  CONSTRAINT `contracts_ibfk_2` FOREIGN KEY (`id_plan_contracts`) REFERENCES `plans` (`id_plans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `incompatible_options`
--

DROP TABLE IF EXISTS `incompatible_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incompatible_options` (
  `id_src_option` int(11) NOT NULL,
  `id_incompatible_option` int(11) NOT NULL,
  KEY `id_src_option` (`id_src_option`),
  KEY `id_incompatible_option` (`id_incompatible_option`),
  CONSTRAINT `incompatible_options_ibfk_1` FOREIGN KEY (`id_src_option`) REFERENCES `options` (`id_options`),
  CONSTRAINT `incompatible_options_ibfk_2` FOREIGN KEY (`id_incompatible_option`) REFERENCES `options` (`id_options`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `options` (
  `id_options` int(11) NOT NULL AUTO_INCREMENT,
  `title_options` varchar(45) NOT NULL,
  `price_options` int(11) NOT NULL,
  `activation_price_options` int(11) NOT NULL,
  PRIMARY KEY (`id_options`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `plan_options`
--

DROP TABLE IF EXISTS `plan_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_options` (
  `plan_id` int(11) DEFAULT NULL,
  `option_id` int(11) DEFAULT NULL,
  KEY `plan_id` (`plan_id`),
  KEY `option_id` (`option_id`),
  CONSTRAINT `plan_options_ibfk_1` FOREIGN KEY (`plan_id`) REFERENCES `plans` (`id_plans`),
  CONSTRAINT `plan_options_ibfk_2` FOREIGN KEY (`option_id`) REFERENCES `options` (`id_options`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `plans`
--

DROP TABLE IF EXISTS `plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plans` (
  `id_plans` int(11) NOT NULL AUTO_INCREMENT,
  `price_plans` int(11) DEFAULT NULL,
  `title_plans` varchar(45) NOT NULL,
  PRIMARY KEY (`id_plans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `required_options`
--

DROP TABLE IF EXISTS `required_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `required_options` (
  `id_src_option` int(11) NOT NULL,
  `id_required_option` int(11) NOT NULL,
  KEY `id_src_option` (`id_src_option`),
  KEY `id_required_option` (`id_required_option`),
  CONSTRAINT `required_options_ibfk_1` FOREIGN KEY (`id_src_option`) REFERENCES `options` (`id_options`),
  CONSTRAINT `required_options_ibfk_2` FOREIGN KEY (`id_required_option`) REFERENCES `options` (`id_options`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id_roles` int(11) NOT NULL AUTO_INCREMENT,
  `name_roles` varchar(45) NOT NULL,
  PRIMARY KEY (`id_roles`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_users` int(11) NOT NULL AUTO_INCREMENT,
  `name_users` varchar(45) NOT NULL,
  `lastname_users` varchar(45) NOT NULL,
  `birthdate_users` date NOT NULL,
  `ID_card_users` varchar(255) DEFAULT NULL,
  `address_users` varchar(255) NOT NULL,
  `email_users` varchar(45) NOT NULL,
  `password_users` varchar(45) NOT NULL,
  `role_users` int(11) NOT NULL,
  `role` tinyblob,
  PRIMARY KEY (`id_users`),
  UNIQUE KEY `unique_email_users` (`email_users`),
  KEY `role_users` (`role_users`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_users`) REFERENCES `roles` (`id_roles`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-07 23:35:15
