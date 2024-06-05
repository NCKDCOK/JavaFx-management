/*
 Navicat Premium Data Transfer

 Source Server         : book
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 05/06/2024 08:04:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stuId` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cla` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birth` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `profession` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course`(`profession` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10124 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (10092, '李华英', '20230001', '1', '男', '2000-01-01', '22电计');
INSERT INTO `students` VALUES (10093, '王芳', '20230002', '2', '女', '2000-02-02', '22网工');
INSERT INTO `students` VALUES (10094, '张伟', '20230003', '3', '男', '2000-03-03', '22能环');
INSERT INTO `students` VALUES (10095, '刘强', '20230004', '1', '女', '2000-04-04', '22焊接');
INSERT INTO `students` VALUES (10096, '赵敏', '20230005', '2', '男', '2000-05-05', '22电计');
INSERT INTO `students` VALUES (10097, '孙涛', '20230006', '3', '女', '2000-06-06', '22网工');
INSERT INTO `students` VALUES (10098, '王一', '20230007', '1', '男', '2000-07-07', '22能环');
INSERT INTO `students` VALUES (10099, '李四', '20230008', '2', '女', '2000-08-08', '22焊接');
INSERT INTO `students` VALUES (10100, '周杰', '20230009', '3', '男', '2000-09-09', '22电计');
INSERT INTO `students` VALUES (10101, '吴敏', '20230010', '1', '女', '2000-10-10', '22网工');
INSERT INTO `students` VALUES (10102, '郑涛', '20230011', '2', '男', '2000-11-11', '22能环');
INSERT INTO `students` VALUES (10103, '冯丽', '20230012', '3', '女', '2000-12-12', '22焊接');
INSERT INTO `students` VALUES (10104, '陈明', '20230013', '1', '男', '2001-01-13', '22电计');
INSERT INTO `students` VALUES (10105, '褚强', '20230014', '2', '女', '2001-02-14', '22网工');
INSERT INTO `students` VALUES (10106, '卫华', '20230015', '3', '男', '2001-03-15', '22能环');
INSERT INTO `students` VALUES (10107, '蒋杰', '20230016', '1', '女', '2001-04-16', '22焊接');
INSERT INTO `students` VALUES (10108, '沈涛', '20230017', '2', '男', '2001-05-17', '22电计');
INSERT INTO `students` VALUES (10109, '韩敏', '20230018', '3', '女', '2001-06-18', '22网工');
INSERT INTO `students` VALUES (10110, '杨华', '20230019', '1', '男', '2001-07-19', '22能环');
INSERT INTO `students` VALUES (10111, '朱杰', '20230020', '2', '女', '2001-08-20', '22焊接');
INSERT INTO `students` VALUES (10112, '秦涛', '20230021', '3', '男', '2001-09-21', '22电计');
INSERT INTO `students` VALUES (10113, '尤丽', '20230022', '1', '女', '2001-10-22', '22网工');
INSERT INTO `students` VALUES (10114, '何明', '20230023', '2', '男', '2001-11-23', '22能环');
INSERT INTO `students` VALUES (10115, '吕涛', '20230024', '3', '女', '2001-12-24', '22焊接');
INSERT INTO `students` VALUES (10116, '施华', '20230025', '1', '男', '2002-01-25', '22电计');
INSERT INTO `students` VALUES (10117, '孔杰', '20230026', '2', '女', '2002-02-26', '22网工');
INSERT INTO `students` VALUES (10118, '曹敏', '20230027', '3', '男', '2002-03-27', '22能环');
INSERT INTO `students` VALUES (10119, '严涛', '20230028', '1', '女', '2002-04-28', '22焊接');
INSERT INTO `students` VALUES (10120, '华明', '20230029', '2', '男', '2002-05-29', '22电计');
INSERT INTO `students` VALUES (10121, '金丽', '20230030', '3', '女', '2002-06-30', '22网工');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123467 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
