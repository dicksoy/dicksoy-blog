/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : dicksoy_blog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-16 20:43:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_aphorism`
-- ----------------------------
DROP TABLE IF EXISTS `t_aphorism`;
CREATE TABLE `t_aphorism` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aphorism_english` varchar(200) DEFAULT NULL,
  `aphorism_chinese` varchar(200) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_aphorism
-- ----------------------------
INSERT INTO `t_aphorism` VALUES ('1', 'If we can only encounter each other rather than stay with each\r\n				other,then I wish we had never encountered.', '如果只是遇见，不能停留，不如不遇见。', '1', null, '1');
INSERT INTO `t_aphorism` VALUES ('2', 'No dream is too big, and no dreamer is too small.', '梦想再大也不嫌大，追梦的人再小也不嫌小。', '1', null, '1');
INSERT INTO `t_aphorism` VALUES ('3', 'No way is impossible to courage.', '勇敢面前没有通不过的路。', '1', null, '1');
INSERT INTO `t_aphorism` VALUES ('4', 'A life without a dress rehearsal, every day is broadcast live. ', '人生没有彩排，每天都是现场直播。', '1', null, '1');
INSERT INTO `t_aphorism` VALUES ('5', 'Whatever happens tomorrow, we had today.', '不管明天会发生什么，我们还有今天。', '1', null, '1');

-- ----------------------------
-- Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` bigint(20) NOT NULL,
  `title` varchar(40) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '哈哈哈哈', '安徽省尽快的哈开始打哈空间收到货k何时可掇安徽就开始的痕迹卡萨丁安徽省尽快的哈开始打哈空间收到货k何时可掇安徽就开始的痕迹卡萨丁安徽省尽快的哈开始打哈空间收到货k何时可掇安徽就开始的痕迹卡萨丁安徽省尽快的哈开始打哈空间收到货k何时可掇安徽就开始的痕迹卡萨丁', '1', '2017-07-25 16:23:23', null);
INSERT INTO `t_article` VALUES ('3', '123dfgdf', '爱神的箭卡号三德科技安徽省尽快的哈会计师的哈克金黄色的空间暗红色的空间哈数据库的哈会计师的会计哈可接受的黄金卡山东矿机安徽省道具卡山东矿机', '1', '2017-07-26 13:04:02', null);
INSERT INTO `t_article` VALUES ('12', '123123', '安徽省尽快的哈开始打哈空间收到货k何时可掇安徽就开始的痕迹卡萨丁', '2', '2017-07-26 13:03:52', null);

-- ----------------------------
-- Table structure for `t_resources`
-- ----------------------------
DROP TABLE IF EXISTS `t_resources`;
CREATE TABLE `t_resources` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `resources_url` varchar(100) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `parent_id` int(5) DEFAULT NULL,
  `sort` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resources
-- ----------------------------
INSERT INTO `t_resources` VALUES ('1', '2', '123', '1', '12', '12', null);

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `gender` tinyint(3) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `head_image` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `state` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '123123', '123', '4297f44b13955235245b2497399d7a93', null, null, null, null, null, null, '0');
