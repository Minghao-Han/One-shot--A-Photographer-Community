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

 Date: 10/07/2023 10:11:01
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
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `receiver_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_ShotTags` (`shot_id`,`id`),
  KEY `commentator_id` (`commentator_id`),
  KEY `shot_id` (`shot_id`),
  CONSTRAINT `comment_of_shot_ibfk_1` FOREIGN KEY (`shot_id`) REFERENCES `shot` (`id`),
  CONSTRAINT `comment_of_shot_ibfk_2` FOREIGN KEY (`commentator_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for digital_camera
-- ----------------------------
DROP TABLE IF EXISTS `digital_camera`;
CREATE TABLE `digital_camera` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sensor_format` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sensor_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sensor_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `total_pixels` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image_format` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE,
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for game_participation
-- ----------------------------
DROP TABLE IF EXISTS `game_participation`;
CREATE TABLE `game_participation` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `game_id` int NOT NULL,
  `user_id` int unsigned NOT NULL,
  `total_votes` int unsigned DEFAULT '0',
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_game_participation` (`game_id`,`user_id`),
  KEY `game_participation_ibfk_1` (`user_id`),
  CONSTRAINT `game_participation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `game_participation_ibfk_2` FOREIGN KEY (`game_id`) REFERENCES `game_publish` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for game_publish
-- ----------------------------
DROP TABLE IF EXISTS `game_publish`;
CREATE TABLE `game_publish` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` datetime NOT NULL,
  `winner` int unsigned NOT NULL DEFAULT '0',
  `is_selected` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for instant_camera
-- ----------------------------
DROP TABLE IF EXISTS `instant_camera`;
CREATE TABLE `instant_camera` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sensor_format` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sensor_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sensor_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `total_pixels` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image_format` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE,
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '对应哪个表的消息',
  `references_id` int NOT NULL COMMENT '在点赞/评论表里的id',
  `receiver_id` int NOT NULL COMMENT '谁应该收到这条消息',
  `checked` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '该消息是否被读',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for shot
-- ----------------------------
DROP TABLE IF EXISTS `shot`;
CREATE TABLE `shot` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `title` varchar(20) NOT NULL,
  `content` varchar(50) DEFAULT NULL,
  `total_thumb` int unsigned NOT NULL DEFAULT '0',
  `total_collect` int unsigned NOT NULL DEFAULT '0',
  `page_view` int unsigned NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `id` (`id`),
  CONSTRAINT `shot_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `logID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `Log_Content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作内容',
  `IP_Address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登陆IP地址',
  `OS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户电脑操作系统 ',
  `IE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户用的浏览器',
  `CreateDate` timestamp NULL DEFAULT NULL,
  `Remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`logID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for thumb_of_shot
-- ----------------------------
DROP TABLE IF EXISTS `thumb_of_shot`;
CREATE TABLE `thumb_of_shot` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `shot_id` int unsigned NOT NULL,
  `thumber_id` int unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_ShotThumb` (`shot_id`,`thumber_id`),
  KEY `thumber_id` (`thumber_id`),
  KEY `shot_id` (`shot_id`),
  CONSTRAINT `thumb_of_shot_ibfk_1` FOREIGN KEY (`shot_id`) REFERENCES `shot` (`id`),
  CONSTRAINT `thumb_of_shot_ibfk_2` FOREIGN KEY (`thumber_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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

-- ----------------------------
-- Table structure for vote_of_game
-- ----------------------------
DROP TABLE IF EXISTS `vote_of_game`;
CREATE TABLE `vote_of_game` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `entry_id` int unsigned NOT NULL,
  `voter_id` int unsigned NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ni_vote_game` (`entry_id`,`voter_id`),
  KEY `tvote_of_game_ibfk_2` (`voter_id`),
  CONSTRAINT `tvote_of_game_ibfk_2` FOREIGN KEY (`voter_id`) REFERENCES `account` (`id`),
  CONSTRAINT `vote_of_game_ibfk_1` FOREIGN KEY (`entry_id`) REFERENCES `game_participation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Triggers structure for table vote_of_game
-- ----------------------------
DROP TRIGGER IF EXISTS `before_insert_vote_of_game`;
delimiter ;;
CREATE TRIGGER `before_insert_vote_of_game` BEFORE INSERT ON `vote_of_game` FOR EACH ROW BEGIN
  DECLARE end_time datetime;
  SELECT end_time INTO end_time FROM game_publish WHERE id = (SELECT game_id FROM game_participation WHERE id = NEW.entry_id) LIMIT 1;
  IF NEW.time >= end_time THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Time must be before end_time';
  END IF;
END
;;
delimiter ;

 CREATE TRIGGER `before_insert_game_participation` BEFORE INSERT ON `game_participation` FOR EACH ROW BEGIN
  DECLARE end_time datetime;
  SELECT end_time INTO end_time FROM game_publish WHERE id = NEW.game_id LIMIT 1;
  IF NEW.time >= end_time THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Time must be before end_time';
  END IF;
END

SET FOREIGN_KEY_CHECKS = 1;
