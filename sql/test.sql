/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-14 20:10:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小明', '123');

-- ----------------------------
-- Procedure structure for add_pro
-- ----------------------------
DROP PROCEDURE IF EXISTS `add_pro`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_pro`( in num1 int,in num2 int, out result int)
begin
	
	set result=num1+num2;
    


end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for 123
-- ----------------------------
DROP FUNCTION IF EXISTS `123`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `123`(num1 int,num2 int) RETURNS int(11)
begin
		declare num3 int;	
		set  num3 = num1*num2;
		return num3;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for add
-- ----------------------------
DROP FUNCTION IF EXISTS `add`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `add`(
        a  int,
        b   int
) RETURNS int(11)
BEGIN
		DECLARE c int;	
		set c=a*b;
		RETURN c;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for pdd
-- ----------------------------
DROP FUNCTION IF EXISTS `pdd`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `pdd`(num1 int,num2 int) RETURNS int(11)
begin
		declare num3 int;	
		set  num3 = num1*num2;
		return num3;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for qwer
-- ----------------------------
DROP FUNCTION IF EXISTS `qwer`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `qwer`(
        a  int,
        b   int
) RETURNS int(11)
BEGIN
		DECLARE c int;	
		set c=a*b;
		RETURN c;
END
;;
DELIMITER ;
