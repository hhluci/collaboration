/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : collaboration

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-07 10:41:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` enum('button','menu') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('17', null, '系统用户修改', '14', null, 'sysuser_update', null, null);
INSERT INTO `sys_permission` VALUES ('16', null, '系统用户删除', '14', null, 'sysuser_delete', null, null);
INSERT INTO `sys_permission` VALUES ('14', null, '系统用户管理', '32', null, 'sysuser_view', null, null);
INSERT INTO `sys_permission` VALUES ('15', null, '系统用户添加', '14', null, 'sysuser_add', null, null);
INSERT INTO `sys_permission` VALUES ('18', null, '用户绑定角色', '14', null, 'sysuser_setroles', null, null);
INSERT INTO `sys_permission` VALUES ('19', null, '系统角色管理', '32', null, 'sysrole_view', null, '');
INSERT INTO `sys_permission` VALUES ('20', null, '系统角色添加', '19', null, 'sysrole_add', null, '');
INSERT INTO `sys_permission` VALUES ('21', null, '系统角色删除', '19', null, 'sysrole_delete', null, null);
INSERT INTO `sys_permission` VALUES ('22', null, '系统角色修改', '19', null, 'sysrole_update', null, null);
INSERT INTO `sys_permission` VALUES ('23', null, '角色绑定用户', '19', null, 'sysrole_setusers', null, null);
INSERT INTO `sys_permission` VALUES ('24', null, '角色绑定权限', '19', null, 'sysrole_setpermissions', null, null);
INSERT INTO `sys_permission` VALUES ('25', null, '系统权限管理', '32', null, 'syspermission_view', null, null);
INSERT INTO `sys_permission` VALUES ('26', null, '系统权限添加', '25', null, 'syspermission_add', null, null);
INSERT INTO `sys_permission` VALUES ('27', null, '系统权限删除', '25', null, 'syspermission_delete', null, null);
INSERT INTO `sys_permission` VALUES ('28', null, '系统权限修改', '25', null, 'syspermission_update', null, null);
INSERT INTO `sys_permission` VALUES ('32', null, '系统管理', null, null, 'sysmanage', null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '\0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('15', '', '拥有删除{用户角色权限} 的权限', 'delete');
INSERT INTO `sys_role` VALUES ('14', '', '拥有查看{用户角色权限} 的权限', 'view');
INSERT INTO `sys_role` VALUES ('16', '', '拥有修改{用户角色权限} 的权限', 'update');
INSERT INTO `sys_role` VALUES ('17', '', '拥有添加{用户角色权限} 的权限', 'add');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`),
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('28', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('27', '1');
INSERT INTO `sys_role_permission` VALUES ('26', '1');
INSERT INTO `sys_role_permission` VALUES ('25', '1');
INSERT INTO `sys_role_permission` VALUES ('22', '1');
INSERT INTO `sys_role_permission` VALUES ('21', '1');
INSERT INTO `sys_role_permission` VALUES ('20', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '1');
INSERT INTO `sys_role_permission` VALUES ('16', '1');
INSERT INTO `sys_role_permission` VALUES ('17', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('24', '1');
INSERT INTO `sys_role_permission` VALUES ('23', '1');
INSERT INTO `sys_role_permission` VALUES ('19', '1');
INSERT INTO `sys_role_permission` VALUES ('18', '1');
INSERT INTO `sys_role_permission` VALUES ('30', '1');
INSERT INTO `sys_role_permission` VALUES ('31', '1');
INSERT INTO `sys_role_permission` VALUES ('27', '15');
INSERT INTO `sys_role_permission` VALUES ('25', '15');
INSERT INTO `sys_role_permission` VALUES ('21', '15');
INSERT INTO `sys_role_permission` VALUES ('25', '14');
INSERT INTO `sys_role_permission` VALUES ('19', '14');
INSERT INTO `sys_role_permission` VALUES ('14', '14');
INSERT INTO `sys_role_permission` VALUES ('28', '16');
INSERT INTO `sys_role_permission` VALUES ('22', '16');
INSERT INTO `sys_role_permission` VALUES ('17', '16');
INSERT INTO `sys_role_permission` VALUES ('26', '17');
INSERT INTO `sys_role_permission` VALUES ('20', '17');
INSERT INTO `sys_role_permission` VALUES ('15', '17');
INSERT INTO `sys_role_permission` VALUES ('19', '15');
INSERT INTO `sys_role_permission` VALUES ('16', '15');
INSERT INTO `sys_role_permission` VALUES ('14', '15');
INSERT INTO `sys_role_permission` VALUES ('14', '16');
INSERT INTO `sys_role_permission` VALUES ('19', '16');
INSERT INTO `sys_role_permission` VALUES ('25', '16');
INSERT INTO `sys_role_permission` VALUES ('19', '17');
INSERT INTO `sys_role_permission` VALUES ('14', '17');
INSERT INTO `sys_role_permission` VALUES ('25', '17');
INSERT INTO `sys_role_permission` VALUES ('32', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UK_f2ksd6h8hsjtd57ipfq9myr64` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0', 'admin');
INSERT INTO `sys_user` VALUES ('21', 'view', '8bc9ac4549cfd14dec47074b08282bbe', '8940533a5a2d2a4af5058451876a9fc6', '0', 'view');
INSERT INTO `sys_user` VALUES ('22', 'delete', '3c3aac83d854a61c0f0f70a472d5c20c', 'dd1f530db7b0a50f171e3ca535dd9c4a', '0', 'delete');
INSERT INTO `sys_user` VALUES ('23', 'add', '0bd3779c75a9f03715f942735115cf12', 'b01377fbff50136ccb5db97c266bfd8b', '0', 'add');
INSERT INTO `sys_user` VALUES ('24', 'update', '68edf26a484c7c8a271f5f79c25548d0', '24a1b2e35ea1f5489983772bdca4d62d', '0', 'update');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `uid` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('23', '17');
INSERT INTO `sys_user_role` VALUES ('22', '15');
INSERT INTO `sys_user_role` VALUES ('21', '14');
INSERT INTO `sys_user_role` VALUES ('1', '12');
INSERT INTO `sys_user_role` VALUES ('1', '11');
INSERT INTO `sys_user_role` VALUES ('1', '2');
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('24', '16');
