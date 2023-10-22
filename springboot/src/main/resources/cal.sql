/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : cal

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 22/10/2023 19:59:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit`  (
  `dno` int NOT NULL AUTO_INCREMENT,
  `month` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `rate` decimal(10, 2) NULL DEFAULT NULL,
  `realtime` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`dno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES (1, '活期存款', 0.67, 0.00);
INSERT INTO `deposit` VALUES (2, '三个月', 2.85, 0.25);
INSERT INTO `deposit` VALUES (3, '半年', 3.08, 0.50);
INSERT INTO `deposit` VALUES (4, '一年', 3.25, 1.00);
INSERT INTO `deposit` VALUES (5, '二年', 4.15, 2.00);
INSERT INTO `deposit` VALUES (6, '三年', 4.75, 3.00);
INSERT INTO `deposit` VALUES (7, '五年', 5.25, 5.00);
INSERT INTO `deposit` VALUES (15, '十年', 8.00, 10.00);

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `hno` int NOT NULL AUTO_INCREMENT,
  `exps` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`hno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (1, '3+2=5');
INSERT INTO `history` VALUES (2, '6*9=54');
INSERT INTO `history` VALUES (3, '3*3=9');
INSERT INTO `history` VALUES (4, '4*3=12');
INSERT INTO `history` VALUES (5, '0=0');
INSERT INTO `history` VALUES (6, '3*5=15');
INSERT INTO `history` VALUES (7, '0=0');
INSERT INTO `history` VALUES (8, '0=0');
INSERT INTO `history` VALUES (9, '3+3=6');
INSERT INTO `history` VALUES (10, '8*3=24');
INSERT INTO `history` VALUES (11, '9*9=81');
INSERT INTO `history` VALUES (12, '6=6');
INSERT INTO `history` VALUES (13, '8*9=72');
INSERT INTO `history` VALUES (14, '(2+3)*5=25');
INSERT INTO `history` VALUES (15, '5*(2+3)=25');
INSERT INTO `history` VALUES (16, '1+2-3*4=-9');
INSERT INTO `history` VALUES (17, '(2+3)*5=25');
INSERT INTO `history` VALUES (18, '1+2*3/4=2.5');
INSERT INTO `history` VALUES (19, '(2*3)%5=1');
INSERT INTO `history` VALUES (20, '2+9=11');
INSERT INTO `history` VALUES (21, '11+9=20');
INSERT INTO `history` VALUES (22, '1.37480223%9=1.37480223');

-- ----------------------------
-- Table structure for loan
-- ----------------------------
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan`  (
  `lno` int NOT NULL AUTO_INCREMENT,
  `month` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `rate` decimal(10, 2) NULL DEFAULT NULL,
  `realtime` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`lno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loan
-- ----------------------------
INSERT INTO `loan` VALUES (2, '一年', 6.33, 1.00);
INSERT INTO `loan` VALUES (3, '一至三年', 6.50, 3.00);
INSERT INTO `loan` VALUES (4, '三至五年', 6.65, 4.99);
INSERT INTO `loan` VALUES (5, '五年', 6.80, 5.00);
INSERT INTO `loan` VALUES (6, '六个月', 5.50, 0.50);
INSERT INTO `loan` VALUES (9, '五年', 5.25, 5.00);

SET FOREIGN_KEY_CHECKS = 1;
