/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100128
 Source Host           : localhost:3306
 Source Schema         : cafe

 Target Server Type    : MySQL
 Target Server Version : 100128
 File Encoding         : 65001

 Date: 04/01/2018 19:41:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bayiler
-- ----------------------------
DROP TABLE IF EXISTS `bayiler`;
CREATE TABLE `bayiler`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `badi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bayiler
-- ----------------------------
INSERT INTO `bayiler` VALUES (1, 'Beşiktaş');

-- ----------------------------
-- Table structure for kullanicilar
-- ----------------------------
DROP TABLE IF EXISTS `kullanicilar`;
CREATE TABLE `kullanicilar`  (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `yid` int(11) NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `kadi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ksifre` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`kid`) USING BTREE,
  UNIQUE INDEX `kadi`(`kadi`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kullanicilar
-- ----------------------------
INSERT INTO `kullanicilar` VALUES (1, 1, 2, 'muharrem', '1234');

-- ----------------------------
-- Table structure for menuler
-- ----------------------------
DROP TABLE IF EXISTS `menuler`;
CREATE TABLE `menuler`  (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NULL DEFAULT NULL,
  `madi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menuler
-- ----------------------------
INSERT INTO `menuler` VALUES (1, NULL, 'Ana Yemek');
INSERT INTO `menuler` VALUES (2, NULL, 'Ara Sıcak');
INSERT INTO `menuler` VALUES (3, NULL, 'Salata');
INSERT INTO `menuler` VALUES (4, NULL, 'Soğuk İçecekler');
INSERT INTO `menuler` VALUES (5, NULL, 'Sıcak İçecekler');
INSERT INTO `menuler` VALUES (6, NULL, 'Tatlılar');
INSERT INTO `menuler` VALUES (7, NULL, 'Çorbalar');

-- ----------------------------
-- Table structure for personeller
-- ----------------------------
DROP TABLE IF EXISTS `personeller`;
CREATE TABLE `personeller`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `ptckn` int(11) NOT NULL,
  `padi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `psoyadi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `pdogumtarihi` datetime(0) NOT NULL,
  `ptel` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `padres` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  UNIQUE INDEX `ptckn`(`ptckn`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for raporlar
-- ----------------------------
DROP TABLE IF EXISTS `raporlar`;
CREATE TABLE `raporlar`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NULL DEFAULT NULL,
  `radi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `rtutar` decimal(10, 2) UNSIGNED NOT NULL,
  `rtarih` datetime(0) NOT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for salonlar
-- ----------------------------
DROP TABLE IF EXISTS `salonlar`;
CREATE TABLE `salonlar`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NULL DEFAULT NULL,
  `sadi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `smasa` int(5) NULL DEFAULT NULL,
  `sdurum` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `sbid`(`bid`) USING BTREE,
  CONSTRAINT `sbid` FOREIGN KEY (`bid`) REFERENCES `bayiler` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salonlar
-- ----------------------------
INSERT INTO `salonlar` VALUES (1, 1, 'Bahçe', 20, b'1');

-- ----------------------------
-- Table structure for urunler
-- ----------------------------
DROP TABLE IF EXISTS `urunler`;
CREATE TABLE `urunler`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `bid` int(11) NULL DEFAULT NULL,
  `uadi` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `ualisfiyat` decimal(10, 2) NOT NULL,
  `usatisfiyat` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `uadet` int(11) NULL DEFAULT NULL,
  `uresim` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `umid`(`mid`) USING BTREE,
  INDEX `ubid`(`bid`) USING BTREE,
  CONSTRAINT `umid` FOREIGN KEY (`mid`) REFERENCES `menuler` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ubid` FOREIGN KEY (`bid`) REFERENCES `bayiler` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of urunler
-- ----------------------------
INSERT INTO `urunler` VALUES (1, 4, 1, 'Coca-Cola', 1.00, '2', 100, 'img/coca.jpeg');

-- ----------------------------
-- Table structure for yetkiler
-- ----------------------------
DROP TABLE IF EXISTS `yetkiler`;
CREATE TABLE `yetkiler`  (
  `yid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`yid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
