/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 26/03/2018 15:04:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(36) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(40) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `BIRTHDAY` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '赵云', '123456', 23, '男', '2018-03-14');
INSERT INTO `user` VALUES (2, '刘备', '123456', 23, '男', '2018-03-14');
INSERT INTO `user` VALUES (3, '关羽', '123456', 23, '男', '2018-03-14');
INSERT INTO `user` VALUES (4, '张飞', '123456', 23, '男', '2018-03-12');
INSERT INTO `user` VALUES (5, '诸葛亮', '123456', 23, '男', '2018-03-14');
INSERT INTO `user` VALUES (6, '曹操', '123456', 22, '女', '1992-06-11');
INSERT INTO `user` VALUES (7, '荀彧', '123456', 55, '男', '1992-06-04');
INSERT INTO `user` VALUES (8, '曹植', '123456', 23, '男', '2018-03-14');
INSERT INTO `user` VALUES (9, '郭嘉', '123456', 55, '女', '2018-03-14');
INSERT INTO `user` VALUES (10, '许褚', '123456', 34, '男', '1992-06-15');
INSERT INTO `user` VALUES (11, '司马懿', '123456', 23, '男', '2018-03-14');
INSERT INTO `user` VALUES (12, '貂蝉', NULL, 33, '女', '2018-03-19');
INSERT INTO `user` VALUES (13, '孙权', NULL, 22, '男', '2018-03-26');
INSERT INTO `user` VALUES (14, '刘婵', NULL, 2, '男', '2018-03-11');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
