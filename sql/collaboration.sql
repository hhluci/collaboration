/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : collaboration

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-12 17:52:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for moudle_define
-- ----------------------------
DROP TABLE IF EXISTS `moudle_define`;
CREATE TABLE `moudle_define` (
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
-- Records of moudle_define
-- ----------------------------

-- ----------------------------
-- Table structure for permission_define
-- ----------------------------
DROP TABLE IF EXISTS `permission_define`;
CREATE TABLE `permission_define` (
  `role_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `moudel_id` int(4) DEFAULT NULL COMMENT '模块标识',
  `crud_operation` int(4) DEFAULT NULL COMMENT '操作权限',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_define
-- ----------------------------

-- ----------------------------
-- Table structure for role_define
-- ----------------------------
DROP TABLE IF EXISTS `role_define`;
CREATE TABLE `role_define` (
  `role_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(256) DEFAULT NULL COMMENT '角色描述',
  `role_priv_level` tinyint(1) DEFAULT NULL COMMENT '角色权限等级',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_define
-- ----------------------------

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `user_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '登录名',
  `login_password` tinyint(32) DEFAULT NULL COMMENT '密码',
  `role_priv_level` int(1) DEFAULT NULL COMMENT '角色权限等级',
  `role_id` int(4) DEFAULT NULL COMMENT '所属角色',
  `if_online` tinyint(1) DEFAULT NULL COMMENT '是否在线',
  `is_locked` tinyint(1) DEFAULT NULL COMMENT '是否锁定',
  `user_expired` datetime(6) DEFAULT NULL COMMENT '过期时间',
  `user_mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(64) DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_login
-- ----------------------------
