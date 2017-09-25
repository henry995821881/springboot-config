/*
Navicat MySQL Data Transfer

Source Server         : 192.168.119.200
Source Server Version : 50173
Source Host           : 192.168.119.200:3306
Source Database       : wx_account

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-09-25 14:57:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tab_account
-- ----------------------------
DROP TABLE IF EXISTS `tab_account`;
CREATE TABLE `tab_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `user_id` varchar(50) NOT NULL,
  `money` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `wx_address_PK` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_account
-- ----------------------------
INSERT INTO `tab_account` VALUES ('2', '超市', '肉', '23sdsd', '1000', '2017-09-20 00:27:04');
INSERT INTO `tab_account` VALUES ('3', '电费', null, '23221213ds', '10000', '2017-09-20 00:27:21');
INSERT INTO `tab_account` VALUES ('4', '其他', 'f', '', '123', '2017-09-22 00:54:30');
INSERT INTO `tab_account` VALUES ('5', '其他1', 'f', '', '123', '2017-09-22 00:55:01');
INSERT INTO `tab_account` VALUES ('6', '电费', 'test', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '123453', '2017-09-24 19:56:15');
INSERT INTO `tab_account` VALUES ('7', 'hel', '23ssd', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '1500', '2017-09-24 22:34:06');
INSERT INTO `tab_account` VALUES ('8', 'TBM', 'ggh', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '1600', '2017-09-24 22:59:42');
INSERT INTO `tab_account` VALUES ('9', '水电煤', '2k', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '8000', '2017-09-24 23:01:24');
INSERT INTO `tab_account` VALUES ('10', '衣服', '南大街', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '8000', '2017-09-24 23:03:02');
INSERT INTO `tab_account` VALUES ('11', '餐费', '金街', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '9000', '2017-09-24 23:05:23');
INSERT INTO `tab_account` VALUES ('12', '交通', 'ggg', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '5600', '2017-09-24 23:24:03');
INSERT INTO `tab_account` VALUES ('13', '交通', 'ggg', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '5600', '2017-09-24 23:39:54');
INSERT INTO `tab_account` VALUES ('14', '交通', 'ggg', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '5600', '2017-09-24 23:44:37');
INSERT INTO `tab_account` VALUES ('15', '交通', 'ggg', 'oCEcg0T6whakY-JCO3CZZniqoSLI', '5600', '2017-09-24 23:49:02');
