/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-09-20 14:58:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) default NULL,
  `age` int(11) default NULL,
  `desc` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('henry', '1', '123');
INSERT INTO `user` VALUES ('admin', '13', 'sdjf');

-- ----------------------------
-- Procedure structure for henry1
-- ----------------------------
DROP PROCEDURE IF EXISTS `henry1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `henry1`()
BEGIN
 select * from user;
end
;;
DELIMITER ;
