/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : collaboration

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-30 09:00:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `DICT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `KEYY` bigint(20) DEFAULT NULL COMMENT '键',
  `VALUEE` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '值',
  `FIELD_NAME` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '字段名称',
  `TABLE_NAME` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '表名',
  PRIMARY KEY (`DICT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `logid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `module` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `responsedata` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `data` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `params` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `methoddescription` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('9', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '8', '192.168.2.2', '2019-06-30 08:39:04', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('10', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.deleteLogss()', '126', '192.168.2.2', '2019-06-30 08:39:11', '执行成功！', '  ids: \"8,7\"', '删除日志');
INSERT INTO `sys_log` VALUES ('11', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '8', '192.168.2.2', '2019-06-30 08:39:12', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('12', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '6', '192.168.2.2', '2019-06-30 08:39:30', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('13', 'admin', '在线用户管理', 'nuc.crowdsys.controller.SessionController.getAllSession()', '0', '192.168.2.2', '2019-06-30 08:39:31', '执行成功！', '  request: org.apache.shiro.web.servlet.ShiroHttpServletRequest@58d63854', '获取在线用户');
INSERT INTO `sys_log` VALUES ('14', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '6', '192.168.2.2', '2019-06-30 08:39:32', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('15', 'admin', '字典管理', 'nuc.crowdsys.controller.SysDictController.dictList()', '54', '192.168.2.2', '2019-06-30 08:39:37', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  dict: SysDict(dictId=null, keyy=, valuee=, tableName=, fieldName=)', '获取所有字典');
INSERT INTO `sys_log` VALUES ('16', 'admin', '系统权限管理', 'nuc.crowdsys.controller.SysPermissionController.menuList()', '6', '192.168.2.2', '2019-06-30 08:39:39', '执行成功！', '  menu: \"SysPermission(id=null, name=, type=, url=null, permission=null, parentId=null, parentIds=null, state=, icon=null)\"', '查询所有权限');
INSERT INTO `sys_log` VALUES ('17', 'admin', '系统角色管理', 'nuc.crowdsys.controller.SysRoleController.roleList()', '6', '192.168.2.2', '2019-06-30 08:39:41', '执行成功！', '  request: \"QueryRequest{pageSize=0, pageNum=0}\"', '查询所有角色');
INSERT INTO `sys_log` VALUES ('18', 'admin', '系统用户管理', 'nuc.crowdsys.controller.SysUserController.userList()', '8', '192.168.2.2', '2019-06-30 08:39:41', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  sysUser: \"SysUser(uid=null, username=, name=null, password=null, salt=null, state=)\"', '查询所有用户');
INSERT INTO `sys_log` VALUES ('19', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '9', '192.168.2.2', '2019-06-30 08:39:43', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('20', 'admin', '系统角色管理', 'nuc.crowdsys.controller.SysRoleController.roleList()', '4', '192.168.2.2', '2019-06-30 08:40:15', '执行成功！', '  request: \"QueryRequest{pageSize=0, pageNum=0}\"', '查询所有角色');
INSERT INTO `sys_log` VALUES ('21', 'admin', '系统用户管理', 'nuc.crowdsys.controller.SysUserController.userList()', '7', '192.168.2.2', '2019-06-30 08:40:15', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  sysUser: \"SysUser(uid=null, username=, name=null, password=null, salt=null, state=)\"', '查询所有用户');
INSERT INTO `sys_log` VALUES ('22', 'admin', '系统用户管理', 'nuc.crowdsys.controller.SysUserController.addUser()', '40', '192.168.2.2', '2019-06-30 08:40:39', '执行成功！', '  user: \"SysUser(uid=null, username=xis, name=asas, password=123456, salt=null, state=on)\"  roles: \"[Ljava.lang.Long;@6b1c6238\"', '添加用户');
INSERT INTO `sys_log` VALUES ('23', 'admin', '系统用户管理', 'nuc.crowdsys.controller.SysUserController.userList()', '8', '192.168.2.2', '2019-06-30 08:40:39', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  sysUser: \"SysUser(uid=null, username=, name=null, password=null, salt=null, state=)\"', '查询所有用户');
INSERT INTO `sys_log` VALUES ('24', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '14', '192.168.2.2', '2019-06-30 08:40:42', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('25', 'admin', '系统权限管理', 'nuc.crowdsys.controller.SysPermissionController.menuList()', '5', '192.168.2.2', '2019-06-30 08:41:01', '执行成功！', '  menu: \"SysPermission(id=null, name=, type=, url=null, permission=null, parentId=null, parentIds=null, state=, icon=null)\"', '查询所有权限');
INSERT INTO `sys_log` VALUES ('26', 'admin', '系统权限管理', 'nuc.crowdsys.controller.SysPermissionController.addMenu()', '3', '192.168.2.2', '2019-06-30 08:41:10', '执行成功！', '  menu: \"SysPermission(id=null, name=dsa, type=1, url=, permission=das, parentId=null, parentIds=null, state=on, icon=)\"', '添加权限');
INSERT INTO `sys_log` VALUES ('27', 'admin', '系统权限管理', 'nuc.crowdsys.controller.SysPermissionController.menuList()', '5', '192.168.2.2', '2019-06-30 08:41:10', '执行成功！', '  menu: \"SysPermission(id=null, name=, type=, url=null, permission=null, parentId=null, parentIds=null, state=, icon=null)\"', '查询所有权限');
INSERT INTO `sys_log` VALUES ('28', 'admin', '系统权限管理', 'nuc.crowdsys.controller.SysPermissionController.deleteMenus()', '75', '192.168.2.2', '2019-06-30 08:41:17', '执行成功！', '  ids: \"60\"', '删除权限');
INSERT INTO `sys_log` VALUES ('29', 'admin', '系统权限管理', 'nuc.crowdsys.controller.SysPermissionController.menuList()', '4', '192.168.2.2', '2019-06-30 08:41:17', '执行成功！', '  menu: \"SysPermission(id=null, name=, type=, url=null, permission=null, parentId=null, parentIds=null, state=, icon=null)\"', '查询所有权限');
INSERT INTO `sys_log` VALUES ('30', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '12', '192.168.2.2', '2019-06-30 08:41:20', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('31', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '10', '192.168.2.2', '2019-06-30 08:41:57', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('32', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '4', '192.168.2.2', '2019-06-30 08:42:07', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('33', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '39', '192.168.2.2', '2019-06-30 08:42:18', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=jurui, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('34', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '9', '192.168.2.2', '2019-06-30 08:42:54', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('35', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '50', '192.168.2.2', '2019-06-30 08:44:43', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=失败, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('36', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '7', '192.168.2.2', '2019-06-30 08:44:45', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('37', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '242', '192.168.2.2', '2019-06-30 08:45:15', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-05-03~2019-06-02, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('38', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '15', '192.168.2.2', '2019-06-30 08:45:25', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-06-29~2019-06-30, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('39', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '15', '192.168.2.2', '2019-06-30 08:45:33', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-06-30~2019-07-02, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('40', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '6', '192.168.2.2', '2019-06-30 08:45:38', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('41', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '26', '192.168.2.2', '2019-06-30 08:45:54', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-06-29~2019-06-29, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('42', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '18', '192.168.2.2', '2019-06-30 08:46:00', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-06-30~2019-06-30, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('43', 'admin', '系统菜单模块', 'nuc.crowdsys.controller.MenuController.getUserMenu()', '42', '192.168.2.2', '2019-06-30 08:47:58', '执行成功！', '  userId: \"1\"', '获取菜单');
INSERT INTO `sys_log` VALUES ('44', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '163', '192.168.2.2', '2019-06-30 08:48:01', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('45', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '63', '192.168.2.2', '2019-06-30 08:48:07', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-06-30~2019-06-30, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('46', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '10', '192.168.2.2', '2019-06-30 08:48:12', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-06-29~2019-06-30, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('47', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '7', '192.168.2.2', '2019-06-30 08:48:15', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=2019-06-29~2019-06-29, description=, params=null)', '查询所有日志');
INSERT INTO `sys_log` VALUES ('48', 'admin', '系统权限管理', 'nuc.crowdsys.controller.SysPermissionController.menuList()', '5', '192.168.2.2', '2019-06-30 08:48:20', '执行成功！', '  menu: \"SysPermission(id=null, name=, type=, url=null, permission=null, parentId=null, parentIds=null, state=, icon=null)\"', '查询所有权限');
INSERT INTO `sys_log` VALUES ('49', 'admin', '系统角色管理', 'nuc.crowdsys.controller.SysRoleController.roleList()', '12', '192.168.2.2', '2019-06-30 08:48:21', '执行成功！', '  request: \"QueryRequest{pageSize=0, pageNum=0}\"', '查询所有角色');
INSERT INTO `sys_log` VALUES ('50', 'admin', '系统用户管理', 'nuc.crowdsys.controller.SysUserController.userList()', '12', '192.168.2.2', '2019-06-30 08:48:21', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  sysUser: \"SysUser(uid=null, username=, name=null, password=null, salt=null, state=)\"', '查询所有用户');
INSERT INTO `sys_log` VALUES ('51', 'admin', '字典管理', 'nuc.crowdsys.controller.SysDictController.dictList()', '15', '192.168.2.2', '2019-06-30 08:48:23', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  dict: SysDict(dictId=null, keyy=, valuee=, tableName=, fieldName=)', '获取所有字典');
INSERT INTO `sys_log` VALUES ('52', 'admin', '系统菜单模块', 'nuc.crowdsys.controller.MenuController.getUserMenu()', '33', '192.168.2.2', '2019-06-30 08:50:43', '执行成功！', '  userId: \"1\"', '获取菜单');
INSERT INTO `sys_log` VALUES ('53', 'admin', '系统菜单模块', 'nuc.crowdsys.controller.MenuController.getUserMenu()', '50', '192.168.2.2', '2019-06-30 08:53:09', '执行成功！', '  userId: \"1\"', '获取菜单');
INSERT INTO `sys_log` VALUES ('54', 'admin', '系统菜单模块', 'nuc.crowdsys.controller.MenuController.getUserMenu()', '49', '192.168.2.2', '2019-06-30 08:59:06', '执行成功！', '  userId: \"1\"', '获取菜单');
INSERT INTO `sys_log` VALUES ('55', 'admin', '系统日志管理', 'nuc.crowdsys.controller.SysLogController.logList()', '181', '192.168.2.2', '2019-06-30 08:59:30', '执行成功！', '  request: \"QueryRequest{pageSize=10, pageNum=1}\"  log: SysLog(logid=null, username=, module=null, methoddescription=null, method=null, responsedata=null, ip=null, data=, description=, params=null)', '查询所有日志');

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
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('4', '1', '系统用户修改', '5', '', 'sysuser_update', '1', '', null);
INSERT INTO `sys_permission` VALUES ('3', '1', '系统用户删除', '5', null, 'sysuser_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('5', '1', '系统用户管理', '1', null, 'sysuser_view', '0', 'sysuser/user', 'zmdi zmdi-account');
INSERT INTO `sys_permission` VALUES ('2', '1', '系统用户添加', '5', null, 'sysuser_add', '1', null, null);
INSERT INTO `sys_permission` VALUES ('6', '1', '用户绑定角色', '5', null, 'sysuser_setroles', '1', null, null);
INSERT INTO `sys_permission` VALUES ('10', '1', '系统角色管理', '1', null, 'sysrole_view', '0', 'sysrole/role', 'zmdi zmdi-accounts');
INSERT INTO `sys_permission` VALUES ('7', '1', '系统角色添加', '10', null, 'sysrole_add', '1', '', null);
INSERT INTO `sys_permission` VALUES ('8', '1', '系统角色删除', '10', null, 'sysrole_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('9', '1', '系统角色修改', '10', null, 'sysrole_update', '1', null, null);
INSERT INTO `sys_permission` VALUES ('11', '1', '角色绑定用户', '10', null, 'sysrole_setusers', '1', null, null);
INSERT INTO `sys_permission` VALUES ('12', '1', '角色绑定权限', '10', null, 'sysrole_setpermissions', '1', null, null);
INSERT INTO `sys_permission` VALUES ('16', '1', '系统权限管理', '1', null, 'syspermission_view', '0', 'syspermission/permission', 'zmdi zmdi-assignment-alert');
INSERT INTO `sys_permission` VALUES ('13', '1', '系统权限添加', '16', null, 'syspermission_add', '1', null, null);
INSERT INTO `sys_permission` VALUES ('14', '1', '系统权限删除', '16', null, 'syspermission_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('15', '1', '系统权限修改', '16', null, 'syspermission_update', '1', null, null);
INSERT INTO `sys_permission` VALUES ('1', '1', '系统管理', '0', null, 'sysmanage', '0', null, 'zmdi zmdi-settings');
INSERT INTO `sys_permission` VALUES ('56', '1', '查看字典', '44', null, 'sysdict_view', '1', null, null);
INSERT INTO `sys_permission` VALUES ('57', '1', '查看系统日志', '50', null, 'syslog_view', '1', null, null);
INSERT INTO `sys_permission` VALUES ('55', '1', '查看系统权限', '16', null, 'syspermission_view', '1', null, null);
INSERT INTO `sys_permission` VALUES ('54', '1', '查看系统角色', '10', null, 'sysrole_view', '1', null, null);
INSERT INTO `sys_permission` VALUES ('53', '1', '查看系统用户', '5', null, 'sysuser_view', '1', null, null);
INSERT INTO `sys_permission` VALUES ('50', '1', '系统日志', '48', null, 'syslog_view', '0', 'syslog/log', 'zmdi zmdi-folder-outline');
INSERT INTO `sys_permission` VALUES ('49', '1', '在线用户管理', '48', null, 'session_view', '0', 'session/session', 'zmdi zmdi-account');
INSERT INTO `sys_permission` VALUES ('48', '1', '系统监控', '0', null, 'sysmonitor', '0', '', 'zmdi zmdi-shield-security');
INSERT INTO `sys_permission` VALUES ('47', '1', '删除字典', '44', null, 'sysdict_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('46', '1', '修改字典', '44', null, 'sysdict_update', '1', null, null);
INSERT INTO `sys_permission` VALUES ('45', '1', '新增字典', '44', null, 'sysdict_add', '1', null, null);
INSERT INTO `sys_permission` VALUES ('44', '1', '字典管理', '1', null, 'sysdict_view', '0', 'sysdict/dict', 'zmdi zmdi-assignment-o');
INSERT INTO `sys_permission` VALUES ('52', '1', '系统日志删除', '50', null, 'syslog_delete', '1', null, null);
INSERT INTO `sys_permission` VALUES ('58', '1', '查看在线用户', '49', null, 'session_view', '1', null, null);
INSERT INTO `sys_permission` VALUES ('59', '1', '踢出用户', '49', null, 'session_kickout', '1', null, null);

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
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '超级管理员', 'admin');
INSERT INTO `sys_role` VALUES ('31', '1', '踢出用户', '踢出用户');
INSERT INTO `sys_role` VALUES ('30', '1', '可以查看全部信息', '观察者');

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
INSERT INTO `sys_role_permission` VALUES ('49', '1');
INSERT INTO `sys_role_permission` VALUES ('50', '1');
INSERT INTO `sys_role_permission` VALUES ('59', '1');
INSERT INTO `sys_role_permission` VALUES ('58', '1');
INSERT INTO `sys_role_permission` VALUES ('52', '1');
INSERT INTO `sys_role_permission` VALUES ('57', '1');
INSERT INTO `sys_role_permission` VALUES ('48', '1');
INSERT INTO `sys_role_permission` VALUES ('44', '1');
INSERT INTO `sys_role_permission` VALUES ('16', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '1');
INSERT INTO `sys_role_permission` VALUES ('45', '1');
INSERT INTO `sys_role_permission` VALUES ('46', '1');
INSERT INTO `sys_role_permission` VALUES ('47', '1');
INSERT INTO `sys_role_permission` VALUES ('56', '1');
INSERT INTO `sys_role_permission` VALUES ('55', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '1');
INSERT INTO `sys_role_permission` VALUES ('13', '1');
INSERT INTO `sys_role_permission` VALUES ('55', '30');
INSERT INTO `sys_role_permission` VALUES ('54', '30');
INSERT INTO `sys_role_permission` VALUES ('54', '1');
INSERT INTO `sys_role_permission` VALUES ('12', '1');
INSERT INTO `sys_role_permission` VALUES ('11', '1');
INSERT INTO `sys_role_permission` VALUES ('9', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '1');
INSERT INTO `sys_role_permission` VALUES ('53', '30');
INSERT INTO `sys_role_permission` VALUES ('1', '30');
INSERT INTO `sys_role_permission` VALUES ('5', '30');
INSERT INTO `sys_role_permission` VALUES ('7', '1');
INSERT INTO `sys_role_permission` VALUES ('53', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('56', '30');
INSERT INTO `sys_role_permission` VALUES ('57', '30');
INSERT INTO `sys_role_permission` VALUES ('58', '30');
INSERT INTO `sys_role_permission` VALUES ('10', '30');
INSERT INTO `sys_role_permission` VALUES ('16', '30');
INSERT INTO `sys_role_permission` VALUES ('44', '30');
INSERT INTO `sys_role_permission` VALUES ('48', '30');
INSERT INTO `sys_role_permission` VALUES ('50', '30');
INSERT INTO `sys_role_permission` VALUES ('49', '30');
INSERT INTO `sys_role_permission` VALUES ('59', '31');
INSERT INTO `sys_role_permission` VALUES ('58', '31');
INSERT INTO `sys_role_permission` VALUES ('49', '31');
INSERT INTO `sys_role_permission` VALUES ('48', '31');

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
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '管理员', '713c10034f00bbf921992add7b09de95', 'f2b068057ee48ca6fd9f99ad1e453bc6', '0', 'admin');
INSERT INTO `sys_user` VALUES ('40', '观察者', '5443f46d8d9b46d7197493d51810b7e7', 'b4823c5b8283fb4fca9fb0ed806954d8', '0', 'viewer');
INSERT INTO `sys_user` VALUES ('41', 'asas', '873d9e9ae02ba839643bb7a8595778a3', '9e04e7b254f71f499efbc9ce7411cf98', '1', 'xis');

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
INSERT INTO `sys_user_role` VALUES ('40', '31');
INSERT INTO `sys_user_role` VALUES ('40', '30');
INSERT INTO `sys_user_role` VALUES ('41', '30');
INSERT INTO `sys_user_role` VALUES ('1', '1');
