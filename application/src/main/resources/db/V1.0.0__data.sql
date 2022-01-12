-- MySQL dump 10.13  Distrib 8.0.27, for macos12.0 (x86_64)
--
-- Host: 127.0.0.1    Database: wiki
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login_log`
--

DROP TABLE IF EXISTS `login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_log`
(
    `id`              int          NOT NULL AUTO_INCREMENT COMMENT '主键',
    `login_user_name` varchar(127) NOT NULL COMMENT '登陆用户名',
    `login_time`      datetime    DEFAULT NULL COMMENT '登陆时间',
    `login_ip`        varchar(63) DEFAULT NULL COMMENT '登陆地址',
    `is_status`       bit(1)      DEFAULT NULL COMMENT '登陆状态',
    `logout_time`     datetime    DEFAULT NULL COMMENT '登出时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登陆日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_log`
--

LOCK
TABLES `login_log` WRITE;
/*!40000 ALTER TABLE `login_log` DISABLE KEYS */;
INSERT INTO `login_log`
VALUES (1, 'admin', '2021-12-29 11:53:15', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (2, 'admin', '2021-12-29 13:31:17', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (3, 'admin', '2021-12-29 14:53:49', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (4, 'admin', '2021-12-29 15:21:44', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (5, 'test', '2021-12-29 17:11:35', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (6, 'admin', '2021-12-29 17:13:47', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (7, 'admin', '2021-12-29 17:20:28', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (8, 'admin', '2021-12-29 17:25:13', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (9, 'admin', '2021-12-30 09:19:30', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (10, 'admin', '2021-12-30 09:19:49', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (11, 'admin', '2021-12-30 09:37:53', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (12, 'admin', '2021-12-30 13:08:44', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (13, 'admin', '2021-12-30 13:08:50', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (14, 'admin', '2021-12-30 14:13:31', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (15, 'admin', '2021-12-30 15:34:11', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (16, 'admin', '2021-12-31 08:42:55', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (17, 'admin', '2021-12-31 13:59:53', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (18, 'test', '2021-12-31 14:34:30', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (19, 'admin', '2021-12-31 16:58:53', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (20, 'admin', '2022-01-04 09:05:03', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (21, 'admin', '2022-01-04 11:04:00', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (22, 'admin', '2022-01-05 09:36:18', NULL, _binary '\0', NULL);
INSERT INTO `login_log`
VALUES (23, 'admin', '2022-01-05 09:37:06', NULL, _binary '\0', NULL);
INSERT INTO `login_log`
VALUES (24, 'admin', '2022-01-05 09:38:32', NULL, _binary '\0', NULL);
INSERT INTO `login_log`
VALUES (25, 'admin', '2022-01-05 09:39:49', NULL, _binary '\0', NULL);
INSERT INTO `login_log`
VALUES (26, 'admin', '2022-01-05 09:47:28', NULL, _binary '\0', NULL);
INSERT INTO `login_log`
VALUES (27, 'admin', '2022-01-05 09:49:07', NULL, _binary '\0', NULL);
INSERT INTO `login_log`
VALUES (28, 'admin', '2022-01-05 09:55:43', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (29, 'admin', '2022-01-05 10:55:17', NULL, _binary '', NULL);
INSERT INTO `login_log`
VALUES (30, 'admin', '2022-01-05 11:52:53', NULL, _binary '', NULL);
/*!40000 ALTER TABLE `login_log` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `operation_log`
--

DROP TABLE IF EXISTS `operation_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operation_log`
(
    `id`                int          NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name`         varchar(127) NOT NULL COMMENT '用户姓名',
    `operation_module`  varchar(255) DEFAULT NULL COMMENT '操作模块',
    `request_address`   varchar(255) DEFAULT NULL COMMENT '请求地址',
    `request_method`    varchar(31)  DEFAULT NULL COMMENT '请求方式(GET,POST,PUT,DELETE)',
    `request_parameter` longtext COMMENT '请求参数',
    `return_result`     longtext COMMENT '返回结果',
    `is_status`         bit(1)       NOT NULL COMMENT '状态（1-成功，0-失败）',
    `create_time`       datetime     NOT NULL COMMENT '创建时间',
    `query_end_time`    bigint       DEFAULT NULL COMMENT '执行时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation_log`
--

LOCK
TABLES `operation_log` WRITE;
/*!40000 ALTER TABLE `operation_log` DISABLE KEYS */;
INSERT INTO `operation_log`
VALUES (1, '非法登陆', 'User', '/user/addUser', 'POST',
        '{\"userAddDto\":{\"createUser\":1,\"userAge\":0,\"userEmail\":\"admin@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://admin\",\"userName\":\"admin\",\"userNickName\":\"管理员\",\"userPassword\":\"111111\",\"userPhone\":\"11122223333\",\"userQq\":\"1036322239\",\"userRealName\":\"阿撒托斯\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        'true', _binary '', '2021-12-29 11:30:18', 432);
INSERT INTO `operation_log`
VALUES (2, '非法登陆', 'User', '/user/addUser', 'POST',
        '{\"userAddDto\":{\"createUser\":1,\"userAge\":0,\"userEmail\":\"test@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://test\",\"userName\":\"test\",\"userNickName\":\"测试员\",\"userPassword\":\"111111\",\"userPhone\":\"44455556666\",\"userQq\":\"2965522699\",\"userRealName\":\"人类\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        'true', _binary '', '2021-12-29 11:50:57', 141);
INSERT INTO `operation_log`
VALUES (3, '非法登陆', 'User', '/user/addUser', 'POST',
        '{\"userAddDto\":{\"createUser\":1,\"userAge\":0,\"userEmail\":\"anyone@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://anyone\",\"userName\":\"anyone\",\"userNickName\":\"匿名用户\",\"userPassword\":\"111111\",\"userPhone\":\"77788889999\",\"userQq\":\"1098733367\",\"userRealName\":\"D级人员\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        'true', _binary '', '2021-12-29 11:52:50', 92);
INSERT INTO `operation_log`
VALUES (4, 'admin', 'Role', '/role/addRole', 'POST',
        '{\"roleAddDto\":{\"createUser\":1,\"roleDescription\":\"管理员权限，拥有所有权限\",\"roleName\":\"admin\"}}', 'true',
        _binary '', '2021-12-29 13:53:46', 2425);
INSERT INTO `operation_log`
VALUES (5, 'admin', 'Role', '/role/addRole', 'POST',
        '{\"roleAddDto\":{\"createUser\":1,\"roleDescription\":\"管理员权限，拥有所有权限\",\"roleName\":\"admin\"}}', 'true',
        _binary '', '2021-12-29 13:54:49', 292);
INSERT INTO `operation_log`
VALUES (6, 'admin', 'Role', '/role/addRole', 'POST',
        '{\"roleAddDto\":{\"createUser\":1,\"roleDescription\":\"测试员，拥有测试权限\",\"roleName\":\"test\"}}', 'true',
        _binary '', '2021-12-29 13:55:16', 5);
INSERT INTO `operation_log`
VALUES (7, 'admin', 'Role', '/role/addRole', 'POST',
        '{\"roleAddDto\":{\"createUser\":1,\"roleDescription\":\"匿名用户，无权限\",\"roleName\":\"anyone\"}}', 'true',
        _binary '', '2021-12-29 13:55:36', 4);
INSERT INTO `operation_log`
VALUES (8, 'admin', 'UserRole', '/user/addUserRole', 'POST',
        '{\"userRoleRelationDto\":{\"createUser\":1,\"roleId\":1,\"userId\":1}}', 'true', _binary '',
        '2021-12-29 13:57:16', 66);
INSERT INTO `operation_log`
VALUES (9, 'admin', 'UserRole', '/user/addUserRole', 'POST',
        '{\"userRoleRelationDto\":{\"createUser\":1,\"roleId\":2,\"userId\":2}}', 'true', _binary '',
        '2021-12-29 13:57:34', 6);
INSERT INTO `operation_log`
VALUES (10, 'admin', 'UserRole', '/user/addUserRole', 'POST',
        '{\"userRoleRelationDto\":{\"createUser\":1,\"roleId\":3,\"userId\":3}}', 'true', _binary '',
        '2021-12-29 13:57:44', 9);
INSERT INTO `operation_log`
VALUES (11, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionDto\":{\"createUser\":1,\"permissionName\":\"用户查询权限\",\"permissionUrl\":\"/user/addUser\"}}',
        'true', _binary '', '2021-12-29 15:03:53', 296);
INSERT INTO `operation_log`
VALUES (12, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"permission\":1,\"roleId\":1}}', 'true', _binary '',
        '2021-12-29 15:22:08', 34);
INSERT INTO `operation_log`
VALUES (13, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"permission\":2,\"roleId\":1}}', 'true', _binary '',
        '2021-12-29 15:22:13', 3);
INSERT INTO `operation_log`
VALUES (14, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"permission\":1,\"roleId\":2}}', 'true', _binary '',
        '2021-12-31 14:17:10', 24);
INSERT INTO `operation_log`
VALUES (15, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"permission\":1,\"roleId\":3}}', 'true', _binary '',
        '2021-12-31 14:25:07', 29);
INSERT INTO `operation_log`
VALUES (16, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"permission\":1,\"roleId\":3}}', 'true', _binary '',
        '2021-12-31 14:26:18', 164110);
INSERT INTO `operation_log`
VALUES (17, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"roleId\":3}}', 'true', _binary '', '2021-12-31 14:29:17',
        106311);
INSERT INTO `operation_log`
VALUES (18, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"roleId\":3}}', 'true', _binary '', '2021-12-31 14:31:44',
        34994);
INSERT INTO `operation_log`
VALUES (19, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"permissionId\":2,\"roleId\":3}}', 'true', _binary '',
        '2021-12-31 14:33:16', 8667);
INSERT INTO `operation_log`
VALUES (20, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"用户删除权限\",\"permissionUrl\":\"/user/deleteUser\"}}',
        'true', _binary '', '2021-12-31 16:11:13', 20);
INSERT INTO `operation_log`
VALUES (21, 'admin', 'RolePermission', '/role/addRolePermission', 'POST',
        '{\"rolePermissionRelationDto\":{\"createUser\":1,\"permissionId\":3,\"roleId\":1}}', 'true', _binary '',
        '2021-12-31 16:12:04', 5963);
INSERT INTO `operation_log`
VALUES (22, 'admin', 'UserRole', '/user/addUserRole', 'POST',
        '{\"userRoleRelationDto\":{\"createUser\":1,\"roleId\":1,\"userId\":4}}', 'true', _binary '',
        '2022-01-04 09:20:30', 68);
INSERT INTO `operation_log`
VALUES (23, 'admin', 'UserRole', '/user/addUserRole', 'EXCEPTION',
        '{\"userRoleRelationDto\":{\"createUser\":1,\"roleId\":2,\"userId\":4}}', '已有此角色', _binary '\0',
        '2022-01-04 09:20:42', -1);
INSERT INTO `operation_log`
VALUES (24, 'admin', 'UserRole', '/user/addUserRole', 'EXCEPTION',
        '{\"userRoleRelationDto\":{\"createUser\":1,\"roleId\":2,\"userId\":4}}', '已有此角色', _binary '\0',
        '2022-01-04 09:22:20', -1);
INSERT INTO `operation_log`
VALUES (25, 'admin', 'UserRole', '/user/addUserRole', 'EXCEPTION',
        '{\"userRoleRelationDto\":{\"createUser\":1,\"roleId\":2,\"userId\":4}}', '已有此角色', _binary '\0',
        '2022-01-04 09:24:39', -1);
INSERT INTO `operation_log`
VALUES (26, 'admin', 'User', '/user/updateUser', 'EXCEPTION',
        '{\"userUpdateDto\":{\"id\":\"4\",\"status\":true,\"userAge\":0,\"userEmail\":\"\",\"userFacebook\":\"\",\"userGender\":0,\"userGoogle\":\"\",\"userIcon\":\"\",\"userName\":\"testDeleted\",\"userNickName\":\"\",\"userPassword\":\"\",\"userPhone\":\"\",\"userQq\":\"\",\"userRealName\":\"\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        '更新用户失败', _binary '\0', '2022-01-04 14:03:43', -1);
INSERT INTO `operation_log`
VALUES (27, 'admin', 'User', '/user/updateUser', 'EXCEPTION',
        '{\"userUpdateDto\":{\"id\":\"4\",\"status\":true,\"userAge\":0,\"userEmail\":\"\",\"userFacebook\":\"\",\"userGender\":0,\"userGoogle\":\"\",\"userIcon\":\"\",\"userName\":\"testDeleted\",\"userNickName\":\"\",\"userPassword\":\"\",\"userPhone\":\"\",\"userQq\":\"\",\"userRealName\":\"\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        '更新用户失败', _binary '\0', '2022-01-04 14:07:08', -1);
INSERT INTO `operation_log`
VALUES (28, 'admin', 'User', '/user/updateUser', 'EXCEPTION',
        '{\"userUpdateDto\":{\"id\":\"4\",\"status\":true,\"userAge\":0,\"userEmail\":\"\",\"userFacebook\":\"\",\"userGender\":0,\"userGoogle\":\"\",\"userIcon\":\"\",\"userName\":\"testDeleted\",\"userNickName\":\"\",\"userPassword\":\"\",\"userPhone\":\"\",\"userQq\":\"\",\"userRealName\":\"\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        '更新用户失败', _binary '\0', '2022-01-04 15:00:22', -1);
INSERT INTO `operation_log`
VALUES (29, 'admin', 'User', '/user/updateUser', 'PUT',
        '{\"userUpdateDto\":{\"id\":\"4\",\"status\":true,\"userAge\":0,\"userEmail\":\"\",\"userFacebook\":\"\",\"userGender\":0,\"userGoogle\":\"\",\"userIcon\":\"\",\"userName\":\"testDeleted\",\"userNickName\":\"\",\"userPassword\":\"\",\"userPhone\":\"\",\"userQq\":\"\",\"userRealName\":\"\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        'true', _binary '', '2022-01-04 15:44:36', 4256);
INSERT INTO `operation_log`
VALUES (30, 'admin', 'User', '/user/addUser', 'POST',
        '{\"userAddDto\":{\"userAge\":0,\"userEmail\":\"\",\"userFacebook\":\"\",\"userGender\":0,\"userGoogle\":\"\",\"userIcon\":\"\",\"userName\":\"testAccount\",\"userNickName\":\"\",\"userPassword\":\"\",\"userPhone\":\"\",\"userQq\":\"\",\"userRealName\":\"\",\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}}',
        'true', _binary '', '2022-01-04 15:45:46', 11);
INSERT INTO `operation_log`
VALUES (31, 'admin', 'UserRole', '/user/addUserRole', 'POST',
        '{\"userRoleRelationAddDto\":{\"createUser\":1,\"roleId\":1,\"userId\":5}}', 'true', _binary '',
        '2022-01-04 15:53:44', 50);
INSERT INTO `operation_log`
VALUES (32, 'admin', 'User', '/user/deleteUser/5', 'DELETE', '{\"id\":\"5\"}', 'true', _binary '',
        '2022-01-04 15:53:54', 26);
INSERT INTO `operation_log`
VALUES (33, 'admin', 'User', '/user/batchDeleteUser', 'DELETE', '{\"idList\":[4,5]}', 'true', _binary '',
        '2022-01-04 15:54:40', 17);
INSERT INTO `operation_log`
VALUES (34, 'admin', 'User', '/user/getPage', 'GET', '{\"userQuery\":{\"pageNum\":1,\"pageSize\":20}}',
        '{\"data\":[{\"createTime\":\"2021-12-29T11:50:57\",\"createUser\":1,\"deleted\":true,\"id\":2,\"status\":true,\"system\":true,\"updateTime\":\"2021-12-29T13:58:25\",\"userAge\":0,\"userEmail\":\"test@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://test\",\"userName\":\"test\",\"userNickName\":\"测试员\",\"userPasswordUpdateTime\":\"2021-12-29T11:50:57\",\"userPhone\":\"44455556666\",\"userQq\":\"2965522699\",\"userRealName\":\"人类\",\"userRole\":[{\"id\":2,\"roleName\":\"test\"}],\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"},{\"createTime\":\"2021-12-29T11:52:50\",\"createUser\":1,\"deleted\":true,\"id\":3,\"status\":true,\"system\":true,\"updateTime\":\"2021-12-29T13:58:25\",\"userAge\":0,\"userEmail\":\"anyone@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://anyone\",\"userName\":\"anyone\",\"userNickName\":\"匿名用户\",\"userPasswordUpdateTime\":\"2021-12-29T11:52:50\",\"userPhone\":\"77788889999\",\"userQq\":\"1098733367\",\"userRealName\":\"D级人员\",\"userRole\":[{\"id\":3,\"roleName\":\"anonymous\"}],\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"},{\"createTime\":\"2021-12-29T11:30:18\",\"createUser\":1,\"deleted\":true,\"id\":1,\"status\":true,\"system\":true,\"updateTime\":\"2021-12-29T13:58:25\",\"userAge\":0,\"userEmail\":\"admin@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://admin\",\"userName\":\"admin\",\"userNickName\":\"管理员\",\"userPasswordUpdateTime\":\"2021-12-29T11:30:18\",\"userPhone\":\"11122223333\",\"userQq\":\"1036322239\",\"userRealName\":\"阿撒托斯\",\"userRole\":[{\"id\":1,\"roleName\":\"admin\"}],\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}],\"pageNum\":1,\"pageSize\":20,\"totalPage\":1,\"totalSize\":3}',
        _binary '', '2022-01-05 10:04:50', 91);
INSERT INTO `operation_log`
VALUES (35, 'admin', 'UserRole', '/user/addUserRole', 'POST',
        '{\"userRoleRelationAddDto\":{\"createUser\":1,\"roleId\":1,\"userId\":7}}', 'true', _binary '',
        '2022-01-05 10:06:35', 27);
INSERT INTO `operation_log`
VALUES (36, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"更新用户权限\",\"permissionUrl\":\"/user/updateUser\"}}',
        'true', _binary '', '2022-01-05 10:58:09', 78);
INSERT INTO `operation_log`
VALUES (37, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"批量删除用户权限\",\"permissionUrl\":\"/user/batchDeleteUser\"}}',
        'true', _binary '', '2022-01-05 10:58:37', 2);
INSERT INTO `operation_log`
VALUES (38, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"给予角色权限\",\"permissionUrl\":\"/user/addUserRole\"}}',
        'true', _binary '', '2022-01-05 10:59:33', 7);
INSERT INTO `operation_log`
VALUES (39, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"移除角色权限\",\"permissionUrl\":\"/user/deleteUserRole\"}}',
        'true', _binary '', '2022-01-05 11:00:17', 5);
INSERT INTO `operation_log`
VALUES (40, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"修改密码权限\",\"permissionUrl\":\"/user/updateUserPassword\"}}',
        'true', _binary '', '2022-01-05 11:00:42', 6);
INSERT INTO `operation_log`
VALUES (41, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"获取角色分页权限\",\"permissionUrl\":\"/role/getPage\"}}',
        'true', _binary '', '2022-01-05 11:01:27', 15);
INSERT INTO `operation_log`
VALUES (42, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"添加角色权限\",\"permissionUrl\":\"/role/addRole\"}}',
        'true', _binary '', '2022-01-05 11:01:41', 2);
INSERT INTO `operation_log`
VALUES (43, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"删除角色权限\",\"permissionUrl\":\"/role/deleteRole\"}}',
        'true', _binary '', '2022-01-05 11:02:03', 6);
INSERT INTO `operation_log`
VALUES (44, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"更新角色权限\",\"permissionUrl\":\"/role/updateRole\"}}',
        'true', _binary '', '2022-01-05 11:02:18', 6);
INSERT INTO `operation_log`
VALUES (45, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"批量删除角色权限\",\"permissionUrl\":\"/role/batchDeleteRole\"}}',
        'true', _binary '', '2022-01-05 11:02:45', 5);
INSERT INTO `operation_log`
VALUES (46, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"添加角色权限的权限\",\"permissionUrl\":\"/role/addRolePermission\"}}',
        'true', _binary '', '2022-01-05 11:03:19', 6);
INSERT INTO `operation_log`
VALUES (47, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"添加权限的权限\",\"permissionUrl\":\"/permission/add\"}}',
        'true', _binary '', '2022-01-05 11:04:00', 6);
INSERT INTO `operation_log`
VALUES (48, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"添加权限分页的权限\",\"permissionUrl\":\"/permission/get\"}}',
        'true', _binary '', '2022-01-05 11:04:10', 3);
INSERT INTO `operation_log`
VALUES (49, 'admin', 'Permission', '/permission/add', 'POST',
        '{\"permissionAddDto\":{\"createUser\":1,\"permissionName\":\"登出系统的权限\",\"permissionUrl\":\"/logout\"}}',
        'true', _binary '', '2022-01-05 11:04:44', 2);
INSERT INTO `operation_log`
VALUES (50, 'admin', 'User', '/user/getPage', 'GET', '{\"userQuery\":{\"pageNum\":1,\"pageSize\":20}}',
        '{\"data\":[{\"createTime\":\"2021-12-29T11:50:57\",\"createUser\":1,\"deleted\":true,\"id\":2,\"status\":true,\"system\":true,\"updateTime\":\"2021-12-29T13:58:25\",\"userAge\":0,\"userEmail\":\"test@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://test\",\"userName\":\"test\",\"userNickName\":\"测试员\",\"userPasswordUpdateTime\":\"2021-12-29T11:50:57\",\"userPhone\":\"44455556666\",\"userQq\":\"2965522699\",\"userRealName\":\"人类\",\"userRole\":[{\"id\":2,\"roleName\":\"test\"}],\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"},{\"createTime\":\"2021-12-29T11:52:50\",\"createUser\":1,\"deleted\":true,\"id\":3,\"status\":true,\"system\":true,\"updateTime\":\"2021-12-29T13:58:25\",\"userAge\":0,\"userEmail\":\"anyone@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://anyone\",\"userName\":\"anyone\",\"userNickName\":\"匿名用户\",\"userPasswordUpdateTime\":\"2021-12-29T11:52:50\",\"userPhone\":\"77788889999\",\"userQq\":\"1098733367\",\"userRealName\":\"D级人员\",\"userRole\":[{\"id\":3,\"roleName\":\"anonymous\"}],\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"},{\"createTime\":\"2021-12-29T11:30:18\",\"createUser\":1,\"deleted\":true,\"id\":1,\"status\":true,\"system\":true,\"updateTime\":\"2021-12-29T13:58:25\",\"userAge\":0,\"userEmail\":\"admin@jwiki.com\",\"userFacebook\":\"\",\"userGender\":2,\"userGoogle\":\"\",\"userIcon\":\"url://admin\",\"userName\":\"admin\",\"userNickName\":\"管理员\",\"userPasswordUpdateTime\":\"2021-12-29T11:30:18\",\"userPhone\":\"11122223333\",\"userQq\":\"1036322239\",\"userRealName\":\"阿撒托斯\",\"userRole\":[{\"id\":1,\"roleName\":\"admin\"}],\"userTelegram\":\"\",\"userTwitter\":\"\",\"userWechat\":\"\"}],\"pageNum\":1,\"pageSize\":20,\"totalPage\":1,\"totalSize\":3}',
        _binary '', '2022-01-05 11:53:34', 41);
/*!40000 ALTER TABLE `operation_log` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission`
(
    `id`              int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `permission_name` varchar(127) DEFAULT NULL COMMENT '资源名称',
    `permission_url`  varchar(255) DEFAULT NULL COMMENT '资源地址',
    `create_time`     datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime     DEFAULT NULL COMMENT '更改时间',
    `create_user`     int          DEFAULT NULL COMMENT '创建人',
    `update_user`     int          DEFAULT NULL COMMENT '修改人',
    `is_status`       bit(1)       DEFAULT b'1' COMMENT '状态1-启用，0-禁用',
    `is_deleted`      bit(1)       DEFAULT b'1' COMMENT '删除状态1-未删除，0-删除',
    `is_system`       bit(1)       DEFAULT b'0' COMMENT '是否为系统预制1-是，0-不是',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK
TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission`
VALUES (1, '用户查询', '/user/getPage', '2021-12-29 15:01:32', '2021-12-29 15:01:32', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (2, '添加用户', '/user/addUser', '2021-12-29 15:03:53', '2021-12-29 15:03:53', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (3, '删除用户', '/user/deleteUser', '2021-12-31 16:11:13', '2021-12-31 16:11:13', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (4, '错误页', '/cp/error', NULL, NULL, 1, NULL, _binary '', _binary '', _binary '');
INSERT INTO `permission`
VALUES (5, '登陆', '/login', NULL, NULL, 1, NULL, _binary '', _binary '', _binary '');
INSERT INTO `permission`
VALUES (6, '权限查看', '/permission/get', '2021-12-31 17:26:50', '2021-12-31 17:26:50', 0, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (7, '更新用户', '/user/updateUser', '2022-01-05 10:58:09', '2022-01-05 10:58:09', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (8, '批量删除用户', '/user/batchDeleteUser', '2022-01-05 10:58:37', '2022-01-05 10:58:37', 1, NULL, _binary '',
        _binary '', _binary '');
INSERT INTO `permission`
VALUES (9, '给予角色', '/user/addUserRole', '2022-01-05 10:59:33', '2022-01-05 10:59:33', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (10, '移除角色', '/user/deleteUserRole', '2022-01-05 11:00:17', '2022-01-05 11:00:17', 1, NULL, _binary '',
        _binary '', _binary '');
INSERT INTO `permission`
VALUES (11, '修改密码', '/user/updateUserPassword', '2022-01-05 11:00:42', '2022-01-05 11:00:42', 1, NULL, _binary '',
        _binary '', _binary '');
INSERT INTO `permission`
VALUES (12, '获取角色分页', '/role/getPage', '2022-01-05 11:01:27', '2022-01-05 11:01:27', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (13, '添加角色', '/role/addRole', '2022-01-05 11:01:41', '2022-01-05 11:01:41', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (14, '删除角色', '/role/deleteRole', '2022-01-05 11:02:03', '2022-01-05 11:02:03', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (15, '更新角色', '/role/updateRole', '2022-01-05 11:02:18', '2022-01-05 11:02:18', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (16, '批量删除角色', '/role/batchDeleteRole', '2022-01-05 11:02:45', '2022-01-05 11:02:45', 1, NULL, _binary '',
        _binary '', _binary '');
INSERT INTO `permission`
VALUES (17, '添加角色权限的', '/role/addRolePermission', '2022-01-05 11:03:19', '2022-01-05 11:03:19', 1, NULL, _binary '',
        _binary '', _binary '');
INSERT INTO `permission`
VALUES (18, '添加权限', '/permission/add', '2022-01-05 11:04:00', '2022-01-05 11:04:00', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `permission`
VALUES (19, '登出', '/logout', '2022-01-05 11:04:44', '2022-01-05 11:04:44', 1, NULL, _binary '', _binary '',
        _binary '');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role`
(
    `id`               int    NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
    `role_name`        varchar(255)    DEFAULT NULL COMMENT '用户角色名称',
    `role_description` varchar(255)    DEFAULT NULL COMMENT '用户角色描述',
    `role_user_count`  int             DEFAULT NULL COMMENT '用户角色使用人数',
    `create_time`      datetime        DEFAULT CURRENT_TIMESTAMP COMMENT '用户角色创建时间',
    `update_time`      datetime        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户角色更新时间',
    `create_user`      int             DEFAULT NULL COMMENT '创建用户',
    `update_user`      int             DEFAULT NULL COMMENT '修改者',
    `is_status`        bit(1)          DEFAULT b'1' COMMENT '用户角色状态',
    `is_deleted`       bit(1)          DEFAULT b'1' COMMENT '用户角色删除状态',
    `is_system`        bit(1) NOT NULL DEFAULT b'0' COMMENT '是否为系统角色（0-不是，1-是）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK
TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role`
VALUES (1, 'admin', '管理员权限，拥有所有权限', NULL, '2021-12-29 13:54:49', '2022-01-04 08:45:43', 1, NULL, _binary '',
        _binary '', _binary '');
INSERT INTO `role`
VALUES (2, 'test', '测试员，拥有测试权限', NULL, '2021-12-29 13:55:16', '2021-12-29 13:58:38', 1, NULL, _binary '', _binary '',
        _binary '');
INSERT INTO `role`
VALUES (3, 'anonymous', '匿名用户，无权限', NULL, '2021-12-29 13:55:36', '2021-12-31 15:06:51', 1, NULL, _binary '',
        _binary '', _binary '');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `role_permission_relation`
--

DROP TABLE IF EXISTS `role_permission_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission_relation`
(
    `id`            int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `role_id`       int      DEFAULT NULL COMMENT '角色id',
    `permission_id` int      DEFAULT NULL COMMENT '权限id',
    `create_time`   datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime DEFAULT NULL COMMENT '修改时间',
    `create_user`   int      DEFAULT NULL COMMENT '创建人',
    `update_user`   int      DEFAULT NULL COMMENT '修改人',
    `is_status`     bit(1)   DEFAULT b'1' COMMENT '状态1-可用，0-禁用',
    `is_deleted`    bit(1)   DEFAULT b'1' COMMENT '删除状态 1-未删除，0-删除',
    `is_system`     bit(1)   DEFAULT b'0' COMMENT '是否为系统预制 1-是，0-不是',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission_relation`
--

LOCK
TABLES `role_permission_relation` WRITE;
/*!40000 ALTER TABLE `role_permission_relation` DISABLE KEYS */;
INSERT INTO `role_permission_relation`
VALUES (1, 1, 1, '2021-12-29 15:22:08', '2021-12-29 15:22:08', 1, NULL, _binary '', _binary '', _binary '\0');
INSERT INTO `role_permission_relation`
VALUES (2, 1, 2, '2021-12-29 15:22:13', '2021-12-29 15:22:13', 1, NULL, _binary '', _binary '', _binary '\0');
INSERT INTO `role_permission_relation`
VALUES (3, 2, 1, '2021-12-31 14:17:10', '2021-12-31 14:17:10', 1, NULL, _binary '', _binary '', _binary '\0');
INSERT INTO `role_permission_relation`
VALUES (9, 1, 3, '2021-12-31 16:12:10', '2021-12-31 16:12:10', 1, NULL, _binary '', _binary '', _binary '\0');
INSERT INTO `role_permission_relation`
VALUES (10, 3, 4, NULL, NULL, 1, NULL, _binary '', _binary '', _binary '');
INSERT INTO `role_permission_relation`
VALUES (11, 3, 5, NULL, NULL, 1, NULL, _binary '', _binary '', _binary '');
INSERT INTO `role_permission_relation`
VALUES (12, 1, 6, '2021-12-31 17:28:52', '2021-12-31 17:28:52', 1, NULL, _binary '', _binary '', _binary '\0');
/*!40000 ALTER TABLE `role_permission_relation` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user`
(
    `id`                        int          NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `user_name`                 varchar(255) NOT NULL COMMENT '账号名称',
    `user_password`             varchar(255) NOT NULL COMMENT '账号密码',
    `user_password_update_time` datetime     DEFAULT NULL COMMENT '密码更新时间',
    `user_real_name`            varchar(64)  DEFAULT NULL COMMENT '用户真实姓名',
    `user_gender`               int          DEFAULT NULL COMMENT '用户性别（0-男，1-女，2-保密）',
    `user_age`                  int          DEFAULT NULL COMMENT '年龄',
    `user_nick_name`            varchar(255) DEFAULT NULL COMMENT '用户昵称',
    `user_icon`                 varchar(255) DEFAULT NULL COMMENT '用户头像',
    `user_email`                varchar(255) DEFAULT NULL COMMENT '用户邮箱',
    `user_phone`                varchar(255) DEFAULT NULL COMMENT '用户电话',
    `user_qq`                   varchar(32)  DEFAULT NULL COMMENT '用户qq',
    `user_wechat`               varchar(256) DEFAULT NULL COMMENT '用户微信',
    `user_google`               varchar(256) DEFAULT NULL COMMENT '用户谷歌',
    `user_telegram`             varchar(256) DEFAULT NULL COMMENT '用户tg',
    `user_twitter`              varchar(256) DEFAULT NULL COMMENT '用户推特',
    `user_facebook`             varchar(256) DEFAULT NULL COMMENT '用户脸书',
    `create_time`               datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
    `update_time`               datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户更新时间',
    `user_login_ip`             varchar(128) DEFAULT NULL COMMENT '用户最后登陆ip',
    `user_login_num`            int          DEFAULT NULL COMMENT '用户总登陆次数',
    `user_login_time`           datetime     DEFAULT NULL COMMENT '用户最后登陆时间',
    `create_user`               int          DEFAULT NULL COMMENT '用户创建者',
    `is_status`                 bit(1)       DEFAULT b'1' COMMENT '用户状态0禁用-1启用',
    `is_deleted`                bit(1)       DEFAULT b'1' COMMENT '用户删除状态0删除1未删除',
    `is_system`                 bit(1)       DEFAULT b'0' COMMENT '是否为系统内置用户（0-不是系统用户，1-是系统用户）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK
TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user`
VALUES (1, 'admin', '$2a$10$EthbHmZa588wUZJqWxmZrObybDjim7ddRYJfa1Ln.WOqlODtLs8Su', '2021-12-29 11:30:18', '阿撒托斯', 2, 0,
        '管理员', 'url://admin', 'admin@jwiki.com', '11122223333', '1036322239', '', '', '', '', '', '2021-12-29 11:30:18',
        '2021-12-29 13:58:25', NULL, NULL, NULL, 1, _binary '', _binary '', _binary '');
INSERT INTO `user`
VALUES (2, 'test', '$2a$10$iAExDKGyUpRVL9NsGf0YsOHp4US9tF7bAoO0fmeauVVK9QsdYjdUm', '2021-12-29 11:50:57', '人类', 2, 0,
        '测试员', 'url://test', 'test@jwiki.com', '44455556666', '2965522699', '', '', '', '', '', '2021-12-29 11:50:57',
        '2021-12-29 13:58:25', NULL, NULL, NULL, 1, _binary '', _binary '', _binary '');
INSERT INTO `user`
VALUES (3, 'anyone', '$2a$10$kPuwWgNKh7Z2F/r/ueApKOf37g01e7grSoeNnE36lht4f4AjZYWa.', '2021-12-29 11:52:50', 'D级人员', 2,
        0, '匿名用户', 'url://anyone', 'anyone@jwiki.com', '77788889999', '1098733367', '', '', '', '', '',
        '2021-12-29 11:52:50', '2021-12-29 13:58:25', NULL, NULL, NULL, 1, _binary '', _binary '', _binary '');
INSERT INTO `user`
VALUES (4, 'testDeleted', '', NULL, '', 0, 0, '', '', '', '', '', '', '', '', '', '', '2021-12-31 16:09:59',
        '2022-01-04 15:54:39', NULL, NULL, NULL, NULL, _binary '', _binary '\0', _binary '\0');
INSERT INTO `user`
VALUES (5, 'testAccount', '', NULL, '', 0, 0, '', '', '', '', '', '', '', '', '', '', '2022-01-04 15:45:46',
        '2022-01-04 15:54:39', NULL, NULL, NULL, NULL, _binary '', _binary '\0', _binary '\0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user_group_relation`
--

DROP TABLE IF EXISTS `user_group_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_group_relation`
(
    `id`          int NOT NULL AUTO_INCREMENT COMMENT '用户组用户id',
    `user_id`     int NOT NULL COMMENT '用户id',
    `group_id`    int NOT NULL COMMENT '用户组id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户组用户创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户组用户更新时间',
    `create_user` int      DEFAULT NULL COMMENT '创建用户',
    `is_deleted`  bit(1)   DEFAULT b'1' COMMENT '用户组用户删除状态',
    `is_system`   bit(1)   DEFAULT b'0' COMMENT '是否为系统内置(0-不是，1-是)',
    `is_status`   bit(1)   DEFAULT b'1' COMMENT '状态',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_group_relation`
--

LOCK
TABLES `user_group_relation` WRITE;
/*!40000 ALTER TABLE `user_group_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_group_relation` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user_groups`
--

DROP TABLE IF EXISTS `user_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_groups`
(
    `id`                int NOT NULL AUTO_INCREMENT COMMENT '用户组id',
    `group_name`        varchar(255) DEFAULT NULL COMMENT '用户组名称',
    `group_description` varchar(255) DEFAULT NULL COMMENT '用户组描述',
    `create_time`       datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '用户组创建时间',
    `update_time`       datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户组更新时间',
    `create_user`       int          DEFAULT NULL,
    `update_user`       int          DEFAULT NULL COMMENT '修改者',
    `is_status`         bit(1)       DEFAULT b'1' COMMENT '用户组状态',
    `is_deleted`        bit(1)       DEFAULT b'1' COMMENT '用户组删除状态',
    `is_system`         bit(1)       DEFAULT b'0' COMMENT '是否为系统组（0-不是，1-是）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_groups`
--

LOCK
TABLES `user_groups` WRITE;
/*!40000 ALTER TABLE `user_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_groups` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user_role_relation`
--

DROP TABLE IF EXISTS `user_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role_relation`
(
    `id`          int NOT NULL AUTO_INCREMENT COMMENT '用户权限id',
    `user_id`     int NOT NULL COMMENT '用户id',
    `role_id`     int NOT NULL COMMENT '权限id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户权限创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户权限更新时间',
    `create_user` int      DEFAULT NULL COMMENT '创建用户',
    `update_user` int      DEFAULT NULL COMMENT '修改人',
    `is_status`   bit(1)   DEFAULT b'1' COMMENT '用户权限状态',
    `is_deleted`  bit(1)   DEFAULT b'1' COMMENT '用户权限删除状态',
    `is_system`   bit(1)   DEFAULT b'0' COMMENT '是否为系统创建(0-不是.1-是)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_relation`
--

LOCK
TABLES `user_role_relation` WRITE;
/*!40000 ALTER TABLE `user_role_relation` DISABLE KEYS */;
INSERT INTO `user_role_relation`
VALUES (1, 1, 1, '2021-12-29 13:57:16', '2021-12-29 13:58:14', 1, NULL, _binary '', _binary '', _binary '');
INSERT INTO `user_role_relation`
VALUES (2, 2, 2, '2021-12-29 13:57:34', '2021-12-29 13:58:14', 1, NULL, _binary '', _binary '', _binary '');
INSERT INTO `user_role_relation`
VALUES (3, 3, 3, '2021-12-29 13:57:44', '2021-12-29 13:58:14', 1, NULL, _binary '', _binary '', _binary '');
INSERT INTO `user_role_relation`
VALUES (4, 4, 1, '2022-01-04 09:20:31', '2022-01-04 09:20:31', 1, NULL, _binary '', _binary '', _binary '\0');
INSERT INTO `user_role_relation`
VALUES (5, 4, 2, '2022-01-04 09:28:14', '2022-01-04 09:28:14', 1, NULL, _binary '', _binary '', _binary '\0');
INSERT INTO `user_role_relation`
VALUES (6, 5, 1, '2022-01-04 15:53:44', '2022-01-04 15:53:44', 1, NULL, _binary '', _binary '', _binary '\0');
INSERT INTO `user_role_relation`
VALUES (7, 7, 1, '2022-01-05 10:06:35', '2022-01-05 10:06:35', 1, NULL, _binary '', _binary '', _binary '\0');
/*!40000 ALTER TABLE `user_role_relation` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-09 15:19:30
