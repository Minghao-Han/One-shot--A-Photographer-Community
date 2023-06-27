/*
 Navicat Premium Data Transfer

 Source Server         : OneShot
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : OneShot

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 27/06/2023 20:43:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for admin_account
-- ----------------------------
DROP TABLE IF EXISTS `admin_account`;
CREATE TABLE `admin_account` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for collect_of_post
-- ----------------------------
DROP TABLE IF EXISTS `collect_of_post`;
CREATE TABLE `collect_of_post` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `post_id` int unsigned NOT NULL,
  `collector_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_PostCollect` (`post_id`,`collector_id`),
  KEY `collector_id` (`collector_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `collect_of_post_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `collect_of_post_ibfk_2` FOREIGN KEY (`collector_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for collect_of_shot
-- ----------------------------
DROP TABLE IF EXISTS `collect_of_shot`;
CREATE TABLE `collect_of_shot` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `shot_id` int unsigned NOT NULL,
  `collector_id` int unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_ShotCollect` (`shot_id`,`collector_id`),
  KEY `collector_id` (`collector_id`),
  KEY `shot_id` (`shot_id`),
  CONSTRAINT `collect_of_shot_ibfk_1` FOREIGN KEY (`shot_id`) REFERENCES `shot` (`id`),
  CONSTRAINT `collect_of_shot_ibfk_2` FOREIGN KEY (`collector_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for comment_of_post
-- ----------------------------
DROP TABLE IF EXISTS `comment_of_post`;
CREATE TABLE `comment_of_post` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `inner_id` int unsigned DEFAULT NULL,
  `post_id` int unsigned NOT NULL,
  `parent_id` int unsigned NOT NULL,
  `commentator_id` int unsigned NOT NULL,
  `content` varchar(256) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_read` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_ShotTags` (`post_id`,`id`),
  KEY `commentator_id` (`commentator_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `comment_of_post_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `comment_of_post_ibfk_2` FOREIGN KEY (`commentator_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for comment_of_shot
-- ----------------------------
DROP TABLE IF EXISTS `comment_of_shot`;
CREATE TABLE `comment_of_shot` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `inner_id` int unsigned NOT NULL,
  `shot_id` int unsigned NOT NULL,
  `parent_id` int unsigned NOT NULL,
  `commentator_id` int unsigned NOT NULL,
  `content` varchar(256) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_read` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_ShotTags` (`shot_id`,`id`),
  KEY `commentator_id` (`commentator_id`),
  KEY `shot_id` (`shot_id`),
  CONSTRAINT `comment_of_shot_ibfk_1` FOREIGN KEY (`shot_id`) REFERENCES `shot` (`id`),
  CONSTRAINT `comment_of_shot_ibfk_2` FOREIGN KEY (`commentator_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `user_id` int unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `browser` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`time`),
  KEY `time` (`time`),
  CONSTRAINT `login_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` varchar(512) DEFAULT NULL,
  `total_thumb` int unsigned NOT NULL,
  `total_collect` int unsigned NOT NULL,
  `page_view` int unsigned NOT NULL,
  `time` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `id` (`id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for shot
-- ----------------------------
DROP TABLE IF EXISTS `shot`;
CREATE TABLE `shot` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `title` varchar(20) NOT NULL,
  `content` varchar(50) DEFAULT NULL,
  `total_thumb` int unsigned NOT NULL,
  `total_collect` int unsigned NOT NULL,
  `page_view` int unsigned NOT NULL,
  `time` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `id` (`id`),
  CONSTRAINT `shot_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for shot_tags
-- ----------------------------
DROP TABLE IF EXISTS `shot_tags`;
CREATE TABLE `shot_tags` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `shot_id` int unsigned NOT NULL,
  `tag` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_ShotTags` (`shot_id`,`tag`),
  KEY `shot_id` (`shot_id`),
  CONSTRAINT `shot_tags_ibfk_1` FOREIGN KEY (`shot_id`) REFERENCES `shot` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `subscribed_id` int unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_Subscribe` (`user_id`,`subscribed_id`),
  KEY `subscribed_id` (`subscribed_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `subscribe_ibfk_1` FOREIGN KEY (`subscribed_id`) REFERENCES `account` (`id`),
  CONSTRAINT `subscribe_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for thumb_of_post
-- ----------------------------
DROP TABLE IF EXISTS `thumb_of_post`;
CREATE TABLE `thumb_of_post` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `post_id` int unsigned NOT NULL,
  `thumber_id` int unsigned NOT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_PostThumb` (`post_id`,`thumber_id`),
  KEY `thumber_id` (`thumber_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `thumb_of_post_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `thumb_of_post_ibfk_2` FOREIGN KEY (`thumber_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for thumb_of_shot
-- ----------------------------
DROP TABLE IF EXISTS `thumb_of_shot`;
CREATE TABLE `thumb_of_shot` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `shot_id` int unsigned NOT NULL,
  `thumber_id` int unsigned NOT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_ShotThumb` (`shot_id`,`thumber_id`),
  KEY `thumber_id` (`thumber_id`),
  KEY `shot_id` (`shot_id`),
  CONSTRAINT `thumb_of_shot_ibfk_1` FOREIGN KEY (`shot_id`) REFERENCES `shot` (`id`),
  CONSTRAINT `thumb_of_shot_ibfk_2` FOREIGN KEY (`thumber_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL,
  `user_name` varchar(15) NOT NULL,
  `personal_signature` varchar(50) DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `age` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_preference
-- ----------------------------
DROP TABLE IF EXISTS `user_preference`;
CREATE TABLE `user_preference` (
  `user_id` int unsigned NOT NULL,
  `tag` varchar(8) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`tag`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_preference_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
