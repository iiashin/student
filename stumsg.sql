/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : stumsg

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/06/2021 18:25:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `classtime` int(11) NULL DEFAULT NULL,
  `term` int(255) NULL DEFAULT NULL,
  `day` int(255) NULL DEFAULT NULL,
  `teac_id` int(11) NULL DEFAULT NULL,
  `room` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `credit` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (101, 'java核心技术', 5, 6, 4, 1001, '1', 5);
INSERT INTO `course` VALUES (102, '计算机组成原理', 2, 1, 5, 1001, '2', 4);
INSERT INTO `course` VALUES (109, '操作系统', 4, 6, 2, 1006, '5', 3);
INSERT INTO `course` VALUES (110, '计算机网络', 3, 6, 1, 1002, '4', 4);
INSERT INTO `course` VALUES (116, '科技英语', 1, 1, 4, 1009, '1', 3);
INSERT INTO `course` VALUES (120, 'Oracle', 7, 6, 2, 1001, '9', 4);

-- ----------------------------
-- Table structure for course_select
-- ----------------------------
DROP TABLE IF EXISTS `course_select`;
CREATE TABLE `course_select`  (
  `course_id` int(11) NOT NULL,
  `stu_id` int(11) NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_select
-- ----------------------------
INSERT INTO `course_select` VALUES (101, 18003, NULL);
INSERT INTO `course_select` VALUES (101, 18001, '90');
INSERT INTO `course_select` VALUES (101, 18002, NULL);
INSERT INTO `course_select` VALUES (109, 18001, '90');
INSERT INTO `course_select` VALUES (109, 18002, NULL);
INSERT INTO `course_select` VALUES (109, 18003, NULL);
INSERT INTO `course_select` VALUES (109, 18004, NULL);
INSERT INTO `course_select` VALUES (110, 18001, '90');
INSERT INTO `course_select` VALUES (110, 18002, NULL);
INSERT INTO `course_select` VALUES (110, 18003, NULL);
INSERT INTO `course_select` VALUES (110, 18004, NULL);
INSERT INTO `course_select` VALUES (102, 18001, NULL);
INSERT INTO `course_select` VALUES (116, 18001, '80');
INSERT INTO `course_select` VALUES (116, 18002, NULL);
INSERT INTO `course_select` VALUES (116, 18006, NULL);
INSERT INTO `course_select` VALUES (120, 18001, NULL);
INSERT INTO `course_select` VALUES (120, 18002, NULL);
INSERT INTO `course_select` VALUES (120, 18007, NULL);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '计算机学院');
INSERT INTO `dept` VALUES (2, '外国语学院');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `major_id` int(11) NOT NULL,
  `major_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '计算机科学与技术182班');
INSERT INTO `major` VALUES (2, ' 英语');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (3, '小柳老师换成大柳老师来上课', '2021-06-20');
INSERT INTO `notice` VALUES (23, '停课', '2021-06-27');

-- ----------------------------
-- Table structure for notice_select
-- ----------------------------
DROP TABLE IF EXISTS `notice_select`;
CREATE TABLE `notice_select`  (
  `notice_id` int(11) NULL DEFAULT NULL,
  `major_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice_select
-- ----------------------------
INSERT INTO `notice_select` VALUES (3, 1);
INSERT INTO `notice_select` VALUES (3, 2);
INSERT INTO `notice_select` VALUES (23, 1);
INSERT INTO `notice_select` VALUES (23, 2);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `stu_dept` int(255) NULL DEFAULT NULL,
  `stu_major` int(255) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `guarder` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `guarder_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18008 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (18001, '苹果', '123', 1, 1, '女', '10086', '小红帽', '233411');
INSERT INTO `student` VALUES (18002, '芒果', '123', 1, 1, '男', '10086', 'dadan', '10086111213');
INSERT INTO `student` VALUES (18006, '橙子', '123', 2, 2, '女', NULL, NULL, NULL);
INSERT INTO `student` VALUES (18007, '桃子', '123', 1, 1, '男', NULL, NULL, NULL);
INSERT INTO `student` VALUES (18008, '小明', '123', 2, 2, '男', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teac_id` int(11) NOT NULL AUTO_INCREMENT,
  `teac_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`teac_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1014 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1001, '桂花', 1, '123');
INSERT INTO `teacher` VALUES (1002, '梨花', 1, '123');
INSERT INTO `teacher` VALUES (1006, '雪花', 1, '123');
INSERT INTO `teacher` VALUES (1009, '栀子花', 2, '123');
INSERT INTO `teacher` VALUES (1011, '水花', 1, '123');

SET FOREIGN_KEY_CHECKS = 1;
