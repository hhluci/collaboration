/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : collaboration

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-24 14:02:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `state` char(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `type` char(2) DEFAULT NULL COMMENT '类型 0菜单 1按钮',
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('4', '1', '系统用户修改', '5', '', 'sysuser_update', '1', '', null);
INSERT INTO `sys_permission` VALUES ('3', '1', '系统用户删除', '5', null, 'sysuser_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('5', '0', '系统用户管理', '1', null, 'sysuser_view', '0', 'sysuser/user', '');
INSERT INTO `sys_permission` VALUES ('2', '1', '系统用户添加', '5', null, 'sysuser_add', '1', null, null);
INSERT INTO `sys_permission` VALUES ('6', '1', '用户绑定角色', '5', null, 'sysuser_setroles', '1', null, null);
INSERT INTO `sys_permission` VALUES ('10', '1', '系统角色管理', '1', null, 'sysrole_view', '0', 'sysrole/role', null);
INSERT INTO `sys_permission` VALUES ('7', '1', '系统角色添加', '10', null, 'sysrole_add', '1', '', null);
INSERT INTO `sys_permission` VALUES ('8', '1', '系统角色删除', '10', null, 'sysrole_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('9', '1', '系统角色修改', '10', null, 'sysrole_update', '1', null, null);
INSERT INTO `sys_permission` VALUES ('11', '1', '角色绑定用户', '10', null, 'sysrole_setusers', '1', null, null);
INSERT INTO `sys_permission` VALUES ('12', '1', '角色绑定权限', '10', null, 'sysrole_setpermissions', '1', null, null);
INSERT INTO `sys_permission` VALUES ('16', '1', '系统权限管理', '1', null, 'syspermission_view', '0', 'syspermission/permission', null);
INSERT INTO `sys_permission` VALUES ('13', '1', '系统权限添加', '16', null, 'syspermission_add', '1', null, null);
INSERT INTO `sys_permission` VALUES ('14', '1', '系统权限删除', '16', null, 'syspermission_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('15', '1', '系统权限修改', '16', null, 'syspermission_update', '1', null, null);
INSERT INTO `sys_permission` VALUES ('1', '1', '系统管理', '0', null, 'sysmanage', '0', null, 'zmdi zmdi-settings');
INSERT INTO `sys_permission` VALUES ('24', '1', '1452', '0', null, '257', '0', '582', 'zmdi zmdi-3d-rotation');
INSERT INTO `sys_permission` VALUES ('23', '1', '测试子节点', '0', null, '156', '0', '4856', 'zmdi zmdi-album');
INSERT INTO `sys_permission` VALUES ('25', '1', '456', '0', null, '15', '0', '48156', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('26', '1', '784562', '0', null, '456', '0', '4985', 'zmdi zmdi-assignment-check');
INSERT INTO `sys_permission` VALUES ('27', '1', '48596', '0', null, '48156', '0', '155', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('28', '1', '测试权限1', '0', null, '98456', '0', '45123', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('29', '1', '测试权限2', '0', null, '32141', '0', '56', 'zmdi zmdi-3d-rotation');
INSERT INTO `sys_permission` VALUES ('30', '1', '测试权限3', '0', null, '456132', '0', '456', 'zmdi zmdi-album');
INSERT INTO `sys_permission` VALUES ('31', '1', '测试权限4', '0', null, '432', '0', '24', 'zmdi zmdi-3d-rotation');
INSERT INTO `sys_permission` VALUES ('32', '1', '测试权限5', '0', null, '4124214', '0', '21414', 'zmdi zmdi-3d-rotation');
INSERT INTO `sys_permission` VALUES ('33', '1', '测试权限6', '0', null, '432', '0', '24', 'zmdi zmdi-3d-rotation');
INSERT INTO `sys_permission` VALUES ('34', '1', '测试权限7', '0', null, '321', '0', '213', 'zmdi zmdi-3d-rotation');
INSERT INTO `sys_permission` VALUES ('35', '1', '测试权限8', '0', null, '45641', '0', '4651', 'zmdi zmdi-album');
INSERT INTO `sys_permission` VALUES ('36', '1', '测试权限9', '0', null, '432432', '0', '42342', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('37', '1', '测试权限10', '0', null, '4156', '0', '156', 'zmdi zmdi-assignment-account');
INSERT INTO `sys_permission` VALUES ('38', '1', '测试权限11', '0', null, '32423', '0', '32423', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('39', '1', 'dadsdasds', '0', null, 'dasdsa', '0', 'das', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('40', '1', '4156', '0', null, '324', '0', '841596', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('41', '1', 'asdas', '0', null, 'fre', '0', 'referf', 'zmdi zmdi-airplane-off');
INSERT INTO `sys_permission` VALUES ('42', '1', 'sdadsad', '0', null, 'dsadas', '0', 'dasd', 'zmdi zmdi-airplane-off');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `state` char(1) CHARACTER SET utf8mb4 DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('15', '1', '拥有删除{用户角色权限} 的权限', 'delete');
INSERT INTO `sys_role` VALUES ('14', '1', '拥有查看{用户角色权限} 的权限', 'view');
INSERT INTO `sys_role` VALUES ('16', '1', '拥有修改{用户角色权限} 的权限', 'update');
INSERT INTO `sys_role` VALUES ('17', '1', '拥有添加{用户角色权限} 的权限', 'add');
INSERT INTO `sys_role` VALUES ('26', '1', '测试测测', '测试测试');
INSERT INTO `sys_role` VALUES ('25', '1', '修改权限', '修改权限');
INSERT INTO `sys_role` VALUES ('24', '0', '999999', '999999');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permission_id` bigint(11) NOT NULL,
  `role_id` bigint(11) NOT NULL,
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`),
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('16', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '1');
INSERT INTO `sys_role_permission` VALUES ('13', '1');
INSERT INTO `sys_role_permission` VALUES ('12', '1');
INSERT INTO `sys_role_permission` VALUES ('11', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '1');
INSERT INTO `sys_role_permission` VALUES ('9', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '26');
INSERT INTO `sys_role_permission` VALUES ('1', '26');
INSERT INTO `sys_role_permission` VALUES ('4', '26');
INSERT INTO `sys_role_permission` VALUES ('16', '25');
INSERT INTO `sys_role_permission` VALUES ('10', '25');
INSERT INTO `sys_role_permission` VALUES ('5', '25');
INSERT INTO `sys_role_permission` VALUES ('1', '25');
INSERT INTO `sys_role_permission` VALUES ('15', '25');
INSERT INTO `sys_role_permission` VALUES ('9', '25');
INSERT INTO `sys_role_permission` VALUES ('4', '25');
INSERT INTO `sys_role_permission` VALUES ('1', '24');
INSERT INTO `sys_role_permission` VALUES ('7', '24');
INSERT INTO `sys_role_permission` VALUES ('8', '24');
INSERT INTO `sys_role_permission` VALUES ('10', '24');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` char(1) CHARACTER SET utf8mb4 DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UK_f2ksd6h8hsjtd57ipfq9myr64` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '管理员', '713c10034f00bbf921992add7b09de95', 'f2b068057ee48ca6fd9f99ad1e453bc6', '0', 'admin');
INSERT INTO `sys_user` VALUES ('21', 'view', '8bc9ac4549cfd14dec47074b08282bbe', '8940533a5a2d2a4af5058451876a9fc6', '1', 'view');
INSERT INTO `sys_user` VALUES ('22', 'delete', '3c3aac83d854a61c0f0f70a472d5c20c', 'dd1f530db7b0a50f171e3ca535dd9c4a', '1', 'delete');
INSERT INTO `sys_user` VALUES ('23', 'add', '0bd3779c75a9f03715f942735115cf12', 'b01377fbff50136ccb5db97c266bfd8b', '0', 'add');
INSERT INTO `sys_user` VALUES ('24', 'update', '68edf26a484c7c8a271f5f79c25548d0', '24a1b2e35ea1f5489983772bdca4d62d', '0', 'update');
INSERT INTO `sys_user` VALUES ('25', '狗头人', 'e2bc4f4a6811d20deb29db834555b138', 'fdc406df8dc16b204e8e386f6187a4ce', '1', '给他扔给他人');
INSERT INTO `sys_user` VALUES ('26', '大萨达', 'f741c38e5ed9ad8b123fc6b3d597e874', '7c9295c8ace78d8b8a5a02cbcc9d0d6b', '1', '145613');
INSERT INTO `sys_user` VALUES ('31', '测试', 'c51ae047dfc5ae7e50153c68950f4093', '739ba0b8cd8c94a24acb2f3421613834', '0', '1563');
INSERT INTO `sys_user` VALUES ('32', 'fqw', 'cdf1d98ab846070a4af6f19df3b65aa5', '386fc10e0992d9cc1dc8d49b8a15ff3f', '1', 'wfqwf');
INSERT INTO `sys_user` VALUES ('33', '废物废物', '2f0ca1eae46d8659622548bcb539f35c', 'f9f1c4c80504239eac1a1526def076d8', '1', '访问请求我服务器');
INSERT INTO `sys_user` VALUES ('34', '废物废物范围', '5af25a302888bce7f54386c2a47fa601', '0cb07d7442198967ed00ff6176a30e02', '1', '废物废物范围');
INSERT INTO `sys_user` VALUES ('35', '4895623', '30546bf2b6d89762990599d9564069e6', 'e7ab2332d2ba9a888d7ad9e49dfc5544', '0', '15623');
INSERT INTO `sys_user` VALUES ('36', '123456', 'c6350b9100d654127ab5c92d8d974221', '06bee759263bfb3f71e57cae66e170c7', '1', '123456');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `uid` bigint(11) NOT NULL,
  `role_id` bigint(11) NOT NULL,
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('23', '17');
INSERT INTO `sys_user_role` VALUES ('22', '15');
INSERT INTO `sys_user_role` VALUES ('21', '14');
INSERT INTO `sys_user_role` VALUES ('1', '17');
INSERT INTO `sys_user_role` VALUES ('1', '16');
INSERT INTO `sys_user_role` VALUES ('1', '14');
INSERT INTO `sys_user_role` VALUES ('1', '15');
INSERT INTO `sys_user_role` VALUES ('24', '16');
INSERT INTO `sys_user_role` VALUES ('31', '14');
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('31', '15');
INSERT INTO `sys_user_role` VALUES ('25', '1');
INSERT INTO `sys_user_role` VALUES ('25', '15');
INSERT INTO `sys_user_role` VALUES ('25', '14');
INSERT INTO `sys_user_role` VALUES ('25', '16');
INSERT INTO `sys_user_role` VALUES ('25', '17');
INSERT INTO `sys_user_role` VALUES ('32', '1');
INSERT INTO `sys_user_role` VALUES ('32', '15');
INSERT INTO `sys_user_role` VALUES ('32', '14');
INSERT INTO `sys_user_role` VALUES ('32', '16');
INSERT INTO `sys_user_role` VALUES ('32', '17');
INSERT INTO `sys_user_role` VALUES ('33', '1');
INSERT INTO `sys_user_role` VALUES ('33', '15');
INSERT INTO `sys_user_role` VALUES ('33', '14');
INSERT INTO `sys_user_role` VALUES ('33', '16');
INSERT INTO `sys_user_role` VALUES ('33', '17');
INSERT INTO `sys_user_role` VALUES ('34', '1');
INSERT INTO `sys_user_role` VALUES ('34', '15');
INSERT INTO `sys_user_role` VALUES ('34', '14');
INSERT INTO `sys_user_role` VALUES ('34', '16');
INSERT INTO `sys_user_role` VALUES ('34', '17');
