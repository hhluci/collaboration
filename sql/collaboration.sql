/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : collaboration

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-17 19:25:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_moudle
-- ----------------------------
DROP TABLE IF EXISTS `sys_moudle`;
CREATE TABLE `sys_moudle` (
  `module_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '模块标识',
  `module_name` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `module_parent` int(4) DEFAULT NULL COMMENT '上层模块',
  `module_hierarchy` varchar(512) DEFAULT NULL COMMENT '层级',
  `module_level` int(2) DEFAULT NULL COMMENT '级别',
  `icon_name` varchar(64) DEFAULT NULL COMMENT '图标名',
  `module_url` varchar(512) DEFAULT NULL COMMENT '对应连接',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_moudle
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `role_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `moudel_id` int(4) DEFAULT NULL COMMENT '模块标识',
  `crud_operation` int(4) DEFAULT NULL COMMENT '操作权限',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(256) DEFAULT NULL COMMENT '角色描述',
  `role_priv_level` tinyint(1) DEFAULT NULL COMMENT '角色权限等级',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '普通用户', '', null);
INSERT INTO `sys_role` VALUES ('2', '管理员', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '登录名',
  `login_password` varchar(32) DEFAULT NULL COMMENT '密码',
  `role_priv_level` int(1) DEFAULT NULL COMMENT '角色权限等级',
  `role_id` int(4) DEFAULT NULL COMMENT '所属角色',
  `if_online` tinyint(1) DEFAULT NULL COMMENT '是否在线',
  `is_locked` tinyint(1) DEFAULT NULL COMMENT '是否锁定',
  `user_expired` datetime(6) DEFAULT NULL COMMENT '过期时间',
  `user_mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(64) DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '曹操', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2', '郭嘉', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('3', '刘备', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('4', '司马懿', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('5', '夏侯惇', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('6', '关羽', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('7', '张飞', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('8', '诸葛亮', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('9', '赵云', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('10', '魏延', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('11', '黄忠', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('12', '马超', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('13', '孙权', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('14', '孙策', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('15', '吕蒙', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('16', '吕布', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('17', '周瑜', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('18', '于禁', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('19', '何进', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('20', '庞统', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('21', '许诸', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('22', '曹丕', '123456', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('23', '庞德', '123456', null, null, null, null, null, null, null);
