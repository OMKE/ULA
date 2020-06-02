-- MySQL dump 10.13  Distrib 8.0.18, for osx10.15 (x86_64)
--
-- Host: localhost    Database: ula_1
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `number` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `postal_code` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `street_name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `city_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpo044ng5x4gynb291cv24vtea` (`city_id`),
  CONSTRAINT `FKpo044ng5x4gynb291cv24vtea` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqrcysxoyqjtyq2obdovndf3dq` (`user_id`),
  CONSTRAINT `FKqrcysxoyqjtyq2obdovndf3dq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `gallery_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg8csxk1m714aagggilrk6t098` (`gallery_id`),
  CONSTRAINT `FKg8csxk1m714aagggilrk6t098` FOREIGN KEY (`gallery_id`) REFERENCES `gallery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campus`
--

DROP TABLE IF EXISTS `campus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp8puwmyh7dmlmay3s43n0wmf` (`location_id`),
  CONSTRAINT `FKp8puwmyh7dmlmay3s43n0wmf` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campus`
--

LOCK TABLES `campus` WRITE;
/*!40000 ALTER TABLE `campus` DISABLE KEYS */;
/*!40000 ALTER TABLE `campus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `country_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrpd7j1p7yxr784adkx4pyepba` (`country_id`),
  CONSTRAINT `FKrpd7j1p7yxr784adkx4pyepba` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_creator`
--

DROP TABLE IF EXISTS `content_creator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_creator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2yfid2fff8r7riry9g6718ugq` (`user_id`),
  CONSTRAINT `FK2yfid2fff8r7riry9g6718ugq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_creator`
--

LOCK TABLES `content_creator` WRITE;
/*!40000 ALTER TABLE `content_creator` DISABLE KEYS */;
/*!40000 ALTER TABLE `content_creator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educational_goal`
--

DROP TABLE IF EXISTS `educational_goal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educational_goal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educational_goal`
--

LOCK TABLES `educational_goal` WRITE;
/*!40000 ALTER TABLE `educational_goal` DISABLE KEYS */;
/*!40000 ALTER TABLE `educational_goal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educational_goal_teaching_term_outcomes`
--

DROP TABLE IF EXISTS `educational_goal_teaching_term_outcomes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educational_goal_teaching_term_outcomes` (
  `educational_goal_id` bigint(20) NOT NULL,
  `teaching_term_outcomes_id` bigint(20) NOT NULL,
  PRIMARY KEY (`educational_goal_id`,`teaching_term_outcomes_id`),
  KEY `FK7bbbcup58wr8qxipq8o53srpe` (`teaching_term_outcomes_id`),
  CONSTRAINT `FK7bbbcup58wr8qxipq8o53srpe` FOREIGN KEY (`teaching_term_outcomes_id`) REFERENCES `teaching_term_outcome` (`id`),
  CONSTRAINT `FKnn63mvgbemu6ml9pb0hdq61fl` FOREIGN KEY (`educational_goal_id`) REFERENCES `educational_goal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educational_goal_teaching_term_outcomes`
--

LOCK TABLES `educational_goal_teaching_term_outcomes` WRITE;
/*!40000 ALTER TABLE `educational_goal_teaching_term_outcomes` DISABLE KEYS */;
/*!40000 ALTER TABLE `educational_goal_teaching_term_outcomes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_verification_token`
--

DROP TABLE IF EXISTS `email_verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_verification_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqmvt3qcly3hbvde97srchdo3x` (`user_id`),
  CONSTRAINT `FKqmvt3qcly3hbvde97srchdo3x` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_verification_token`
--

LOCK TABLES `email_verification_token` WRITE;
/*!40000 ALTER TABLE `email_verification_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_verification_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `end_time` datetime NOT NULL,
  `points` double NOT NULL,
  `start_time` datetime NOT NULL,
  `exam_outcome_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk65f9evbsqayx3ay5or4ug86r` (`exam_outcome_id`),
  KEY `FK54ge0px8gv4a8a95t366e3n3y` (`type_id`),
  CONSTRAINT `FK54ge0px8gv4a8a95t366e3n3y` FOREIGN KEY (`type_id`) REFERENCES `exam_type` (`id`),
  CONSTRAINT `FKk65f9evbsqayx3ay5or4ug86r` FOREIGN KEY (`exam_outcome_id`) REFERENCES `exam_outcome` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_outcome`
--

DROP TABLE IF EXISTS `exam_outcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_outcome` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_outcome`
--

LOCK TABLES `exam_outcome` WRITE;
/*!40000 ALTER TABLE `exam_outcome` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_outcome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_type`
--

DROP TABLE IF EXISTS `exam_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_type`
--

LOCK TABLES `exam_type` WRITE;
/*!40000 ALTER TABLE `exam_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `icon` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `campus_id` bigint(20) NOT NULL,
  `information_id` bigint(20) DEFAULT NULL,
  `university_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkdm1k4ytsf52vxjf04kqrjqjc` (`campus_id`),
  KEY `FKlgaec6gidagd7vuyfnsf26ddv` (`information_id`),
  KEY `FKivqbiytd9en6sk09duabc6scc` (`university_id`),
  CONSTRAINT `FKivqbiytd9en6sk09duabc6scc` FOREIGN KEY (`university_id`) REFERENCES `university` (`id`),
  CONSTRAINT `FKkdm1k4ytsf52vxjf04kqrjqjc` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`id`),
  CONSTRAINT `FKlgaec6gidagd7vuyfnsf26ddv` FOREIGN KEY (`information_id`) REFERENCES `faculty_information` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_information`
--

DROP TABLE IF EXISTS `faculty_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `accreditation` text COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `history` text COLLATE utf8mb4_general_ci NOT NULL,
  `mission` text COLLATE utf8mb4_general_ci NOT NULL,
  `phone_number` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `president` text COLLATE utf8mb4_general_ci NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8epiqpylyynln0yk9qymcip16` (`address_id`),
  CONSTRAINT `FK8epiqpylyynln0yk9qymcip16` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_information`
--

LOCK TABLES `faculty_information` WRITE;
/*!40000 ALTER TABLE `faculty_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `description` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `url` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--



--
-- Table structure for table `gallery`
--

DROP TABLE IF EXISTS `gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gallery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gallery`
--

LOCK TABLES `gallery` WRITE;
/*!40000 ALTER TABLE `gallery` DISABLE KEYS */;
/*!40000 ALTER TABLE `gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `path` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `album_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKklgd5pxhpuh3nwik115myord` (`album_id`),
  CONSTRAINT `FKklgd5pxhpuh3nwik115myord` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `longitude` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news_article`
--

DROP TABLE IF EXISTS `news_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `html` text COLLATE utf8mb4_general_ci NOT NULL,
  `thumbnail_image` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `content_creator_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdhdsonscnb38fe7uugugfmeit` (`content_creator_id`),
  CONSTRAINT `FKdhdsonscnb38fe7uugugfmeit` FOREIGN KEY (`content_creator_id`) REFERENCES `content_creator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_article`
--

LOCK TABLES `news_article` WRITE;
/*!40000 ALTER TABLE `news_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `news_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_resets`
--

DROP TABLE IF EXISTS `password_resets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_resets` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `email` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `expiry_date` datetime NOT NULL,
  `token` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_resets`
--

LOCK TABLES `password_resets` WRITE;
/*!40000 ALTER TABLE `password_resets` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_resets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number`
--

DROP TABLE IF EXISTS `phone_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `contact_info` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `number` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `university_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb7y2y1ohup2ng503nkic56vuj` (`university_id`),
  CONSTRAINT `FKb7y2y1ohup2ng503nkic56vuj` FOREIGN KEY (`university_id`) REFERENCES `university` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number`
--

LOCK TABLES `phone_number` WRITE;
/*!40000 ALTER TABLE `phone_number` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_project`
--

DROP TABLE IF EXISTS `research_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `research_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `html` text COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `researchers` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `content_creator_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpx7qbw8etcoj27cpw6fqjj9cm` (`content_creator_id`),
  CONSTRAINT `FKpx7qbw8etcoj27cpw6fqjj9cm` FOREIGN KEY (`content_creator_id`) REFERENCES `content_creator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_project`
--

LOCK TABLES `research_project` WRITE;
/*!40000 ALTER TABLE `research_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `research_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `phone_number` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `umcn` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9wv9bhkkjhr9rtlj9ul1si0hk` (`umcn`),
  KEY `FKk5m148xqefonqw7bgnpm0snwj` (`user_id`),
  CONSTRAINT `FKk5m148xqefonqw7bgnpm0snwj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_administration_staff`
--

DROP TABLE IF EXISTS `student_administration_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_administration_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6f4dpbs08i81y5ylpy0jvb6ku` (`user_id`),
  CONSTRAINT `FK6f4dpbs08i81y5ylpy0jvb6ku` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_administration_staff`
--

LOCK TABLES `student_administration_staff` WRITE;
/*!40000 ALTER TABLE `student_administration_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_administration_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_on_year`
--

DROP TABLE IF EXISTS `student_on_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_on_year` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `date_of_enrollment` datetime NOT NULL,
  `transcript_identifier` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tit2ome5w0j469hcx7nva8g1a` (`transcript_identifier`),
  KEY `FKb812gt5gk00p6p7uokhfqk9ll` (`student_id`),
  CONSTRAINT `FKb812gt5gk00p6p7uokhfqk9ll` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_on_year`
--

LOCK TABLES `student_on_year` WRITE;
/*!40000 ALTER TABLE `student_on_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_on_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_program`
--

DROP TABLE IF EXISTS `study_program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_program` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `degree_id` bigint(20) DEFAULT NULL,
  `faculty_id` bigint(20) NOT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4te7ds8qg935rxh4t2y983ji2` (`degree_id`),
  KEY `FK48g3nmfegilglqllax2cfjokq` (`faculty_id`),
  KEY `FKa7rdfdlt3ufrvn0pq74h9d6n0` (`location_id`),
  CONSTRAINT `FK48g3nmfegilglqllax2cfjokq` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`),
  CONSTRAINT `FK4te7ds8qg935rxh4t2y983ji2` FOREIGN KEY (`degree_id`) REFERENCES `study_program_degree` (`id`),
  CONSTRAINT `FKa7rdfdlt3ufrvn0pq74h9d6n0` FOREIGN KEY (`location_id`) REFERENCES `study_program_location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_program`
--

LOCK TABLES `study_program` WRITE;
/*!40000 ALTER TABLE `study_program` DISABLE KEYS */;
/*!40000 ALTER TABLE `study_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_program_degree`
--

DROP TABLE IF EXISTS `study_program_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_program_degree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_program_degree`
--

LOCK TABLES `study_program_degree` WRITE;
/*!40000 ALTER TABLE `study_program_degree` DISABLE KEYS */;
/*!40000 ALTER TABLE `study_program_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_program_location`
--

DROP TABLE IF EXISTS `study_program_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_program_location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_program_location`
--

LOCK TABLES `study_program_location` WRITE;
/*!40000 ALTER TABLE `study_program_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `study_program_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `espb` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `number_of_lectures` int(11) NOT NULL,
  `number_of_practical_lectures` int(11) NOT NULL,
  `other_forms_of_lectures` int(11) NOT NULL,
  `other_lectures` int(11) NOT NULL,
  `required` tinyint(1) NOT NULL DEFAULT '1',
  `research_works` int(11) NOT NULL,
  `semestar` int(11) NOT NULL,
  `subject_realization_id` bigint(20) DEFAULT NULL,
  `year_of_study_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKns8222ehd0qt0cvm2xvsy7lml` (`subject_realization_id`),
  KEY `FK3nyqyby8qyjem76s0lqr5hirg` (`year_of_study_id`),
  CONSTRAINT `FK3nyqyby8qyjem76s0lqr5hirg` FOREIGN KEY (`year_of_study_id`) REFERENCES `year_of_study` (`id`),
  CONSTRAINT `FKns8222ehd0qt0cvm2xvsy7lml` FOREIGN KEY (`subject_realization_id`) REFERENCES `subject_realization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_attendance`
--

DROP TABLE IF EXISTS `subject_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_attendance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `final_grade` int(11) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKssoq17x0exg6rd8dw6xo8c40m` (`student_id`),
  CONSTRAINT `FKssoq17x0exg6rd8dw6xo8c40m` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_attendance`
--

LOCK TABLES `subject_attendance` WRITE;
/*!40000 ALTER TABLE `subject_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_prerequisite_for`
--

DROP TABLE IF EXISTS `subject_prerequisite_for`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_prerequisite_for` (
  `subject_id` bigint(20) NOT NULL,
  `prerequisite_for_id` bigint(20) NOT NULL,
  PRIMARY KEY (`subject_id`,`prerequisite_for_id`),
  KEY `FKlgmg1x5wtr92miv0amnt41mmn` (`prerequisite_for_id`),
  CONSTRAINT `FKlgmg1x5wtr92miv0amnt41mmn` FOREIGN KEY (`prerequisite_for_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKlktivyncc6w1ftvqd0j2jgiqa` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_prerequisite_for`
--

LOCK TABLES `subject_prerequisite_for` WRITE;
/*!40000 ALTER TABLE `subject_prerequisite_for` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_prerequisite_for` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_prerequisites`
--

DROP TABLE IF EXISTS `subject_prerequisites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_prerequisites` (
  `subject_id` bigint(20) NOT NULL,
  `prerequisites_id` bigint(20) NOT NULL,
  PRIMARY KEY (`subject_id`,`prerequisites_id`),
  KEY `FKb6urcy33fn50o4fv1qiftrsiw` (`prerequisites_id`),
  CONSTRAINT `FKb6urcy33fn50o4fv1qiftrsiw` FOREIGN KEY (`prerequisites_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKo32vlorx18g6puvs42vyl3mkx` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_prerequisites`
--

LOCK TABLES `subject_prerequisites` WRITE;
/*!40000 ALTER TABLE `subject_prerequisites` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_prerequisites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_realization`
--

DROP TABLE IF EXISTS `subject_realization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_realization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `subject_attendace_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9h40pybqo5jg3jvda401p7sje` (`subject_attendace_id`),
  CONSTRAINT `FK7vt9uu8p0gtggbd1m15euv9ei` FOREIGN KEY (`subject_attendace_id`) REFERENCES `subject_attendance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_realization`
--

LOCK TABLES `subject_realization` WRITE;
/*!40000 ALTER TABLE `subject_realization` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_realization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taking_exam`
--

DROP TABLE IF EXISTS `taking_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taking_exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `note` text COLLATE utf8mb4_general_ci NOT NULL,
  `points` double NOT NULL,
  `exam_id` bigint(20) DEFAULT NULL,
  `student_on_year_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqk131lvlb3dmw2uemmmp3v5gx` (`exam_id`),
  KEY `FK5ssasm6wkxuykr7j5rwlp92b4` (`student_on_year_id`),
  CONSTRAINT `FK5ssasm6wkxuykr7j5rwlp92b4` FOREIGN KEY (`student_on_year_id`) REFERENCES `student_on_year` (`id`),
  CONSTRAINT `FKqk131lvlb3dmw2uemmmp3v5gx` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taking_exam`
--

LOCK TABLES `taking_exam` WRITE;
/*!40000 ALTER TABLE `taking_exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `taking_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `biography` text COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpb6g6pahj1mr2ijg92r7m1xlh` (`user_id`),
  CONSTRAINT `FKpb6g6pahj1mr2ijg92r7m1xlh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_on_realization`
--

DROP TABLE IF EXISTS `teacher_on_realization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_on_realization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `number_of_lectures` int(11) NOT NULL,
  `subject_realization_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp15gjq1a1yyfhblisavlu41lj` (`subject_realization_id`),
  KEY `FKmqsot83g9x9uxkycqb0c7tv4n` (`teacher_id`),
  CONSTRAINT `FKmqsot83g9x9uxkycqb0c7tv4n` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FKp15gjq1a1yyfhblisavlu41lj` FOREIGN KEY (`subject_realization_id`) REFERENCES `subject_realization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_on_realization`
--

LOCK TABLES `teacher_on_realization` WRITE;
/*!40000 ALTER TABLE `teacher_on_realization` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_on_realization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_subjects`
--

DROP TABLE IF EXISTS `teacher_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_subjects` (
  `teacher_id` bigint(20) NOT NULL,
  `subjects_id` bigint(20) NOT NULL,
  PRIMARY KEY (`teacher_id`,`subjects_id`),
  KEY `FK590r5o8kjhiwyp96jylu9yw3o` (`subjects_id`),
  CONSTRAINT `FK590r5o8kjhiwyp96jylu9yw3o` FOREIGN KEY (`subjects_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKjkx6egayo8f0yrpjb1fychxbq` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subjects`
--

LOCK TABLES `teacher_subjects` WRITE;
/*!40000 ALTER TABLE `teacher_subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching_material`
--

DROP TABLE IF EXISTS `teaching_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaching_material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `publishment_date` datetime NOT NULL,
  `file_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkhlfvh5vgv61m3codncf7nov6` (`file_id`),
  CONSTRAINT `FKkhlfvh5vgv61m3codncf7nov6` FOREIGN KEY (`file_id`) REFERENCES `file` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching_material`
--

LOCK TABLES `teaching_material` WRITE;
/*!40000 ALTER TABLE `teaching_material` DISABLE KEYS */;
/*!40000 ALTER TABLE `teaching_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching_material_author`
--

DROP TABLE IF EXISTS `teaching_material_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaching_material_author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `first_name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `last_name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `teaching_material_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2xn3ihuh4mk5xxj9avrstbdvx` (`teaching_material_id`),
  CONSTRAINT `FK2xn3ihuh4mk5xxj9avrstbdvx` FOREIGN KEY (`teaching_material_id`) REFERENCES `teaching_material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching_material_author`
--

LOCK TABLES `teaching_material_author` WRITE;
/*!40000 ALTER TABLE `teaching_material_author` DISABLE KEYS */;
/*!40000 ALTER TABLE `teaching_material_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching_term`
--

DROP TABLE IF EXISTS `teaching_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaching_term` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `end_time` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `subject_realization_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj82749wv5ux1nd41g7n9qkbp9` (`subject_realization_id`),
  CONSTRAINT `FKj82749wv5ux1nd41g7n9qkbp9` FOREIGN KEY (`subject_realization_id`) REFERENCES `subject_realization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching_term`
--

LOCK TABLES `teaching_term` WRITE;
/*!40000 ALTER TABLE `teaching_term` DISABLE KEYS */;
/*!40000 ALTER TABLE `teaching_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching_term_outcome`
--

DROP TABLE IF EXISTS `teaching_term_outcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaching_term_outcome` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `description` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching_term_outcome`
--

LOCK TABLES `teaching_term_outcome` WRITE;
/*!40000 ALTER TABLE `teaching_term_outcome` DISABLE KEYS */;
/*!40000 ALTER TABLE `teaching_term_outcome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching_term_outcome_educational_goals`
--

DROP TABLE IF EXISTS `teaching_term_outcome_educational_goals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaching_term_outcome_educational_goals` (
  `teaching_term_outcome_id` bigint(20) NOT NULL,
  `educational_goals_id` bigint(20) NOT NULL,
  PRIMARY KEY (`teaching_term_outcome_id`,`educational_goals_id`),
  KEY `FK1ouclkn6jr9p3964ktm17jr90` (`educational_goals_id`),
  CONSTRAINT `FK1ouclkn6jr9p3964ktm17jr90` FOREIGN KEY (`educational_goals_id`) REFERENCES `educational_goal` (`id`),
  CONSTRAINT `FKk97qhm8k9flo1my8xenobq885` FOREIGN KEY (`teaching_term_outcome_id`) REFERENCES `teaching_term_outcome` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching_term_outcome_educational_goals`
--

LOCK TABLES `teaching_term_outcome_educational_goals` WRITE;
/*!40000 ALTER TABLE `teaching_term_outcome_educational_goals` DISABLE KEYS */;
/*!40000 ALTER TABLE `teaching_term_outcome_educational_goals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching_type`
--

DROP TABLE IF EXISTS `teaching_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaching_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `teaching_term_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6h26rj8grrf6900jghic11ke` (`teaching_term_id`),
  CONSTRAINT `FK6h26rj8grrf6900jghic11ke` FOREIGN KEY (`teaching_term_id`) REFERENCES `teaching_term` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching_type`
--

LOCK TABLES `teaching_type` WRITE;
/*!40000 ALTER TABLE `teaching_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `teaching_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `university`
--

DROP TABLE IF EXISTS `university`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `university` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `establishment_date` date NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq9af0t50fvg0i0upumvgrig44` (`address_id`),
  CONSTRAINT `FKq9af0t50fvg0i0upumvgrig44` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university`
--

LOCK TABLES `university` WRITE;
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
/*!40000 ALTER TABLE `university` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `email` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `email_verified` tinyint(1) NOT NULL DEFAULT '0',
  `first_name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `ip_address` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `profile_image` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_permission`
--

DROP TABLE IF EXISTS `user_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbklmo9kchans5u3e4va0ouo1s` (`permission_id`),
  KEY `FK7c2x74rinbtf33lhdcyob20sh` (`user_id`),
  CONSTRAINT `FK7c2x74rinbtf33lhdcyob20sh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKbklmo9kchans5u3e4va0ouo1s` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_permission`
--

LOCK TABLES `user_permission` WRITE;
/*!40000 ALTER TABLE `user_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `year_of_study`
--

DROP TABLE IF EXISTS `year_of_study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `year_of_study` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT NULL,
  `year` datetime(6) NOT NULL,
  `student_on_year_id` bigint(20) DEFAULT NULL,
  `study_program_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK340qdf9lv6vsx6e37eit0k4q5` (`student_on_year_id`),
  KEY `FKotv61d8m1dd2wf61wkitdpng` (`study_program_id`),
  CONSTRAINT `FK340qdf9lv6vsx6e37eit0k4q5` FOREIGN KEY (`student_on_year_id`) REFERENCES `student_on_year` (`id`),
  CONSTRAINT `FKotv61d8m1dd2wf61wkitdpng` FOREIGN KEY (`study_program_id`) REFERENCES `study_program` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `year_of_study`
--

LOCK TABLES `year_of_study` WRITE;
/*!40000 ALTER TABLE `year_of_study` DISABLE KEYS */;
/*!40000 ALTER TABLE `year_of_study` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-02  4:02:57
