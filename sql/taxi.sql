/*
Navicat MySQL Data Transfer

Source Server         : taxi
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : taxi

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2019-01-27 17:20:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id_c` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(100) DEFAULT NULL,
  `xinghao` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `f_number` varchar(100) DEFAULT NULL,
  `j_number` varchar(100) DEFAULT NULL,
  `selltime` datetime DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `inf` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_c`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '鄂A11111', '捷达', '捷达', 'f1001', 'j1001', '2018-05-07 00:00:00', '维修', '捷达小汽车');
INSERT INTO `car` VALUES ('2', '京B12345', '奥迪', '奥迪', 'a1001', 'j1002', '2018-05-01 18:10:40', '可用', '奥迪小汽车');
INSERT INTO `car` VALUES ('3', '陕C67543', '桑塔纳', '桑塔纳', 's1001', 'j1234', '2018-05-02 00:00:00', '可用', '桑塔纳小汽车');

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge` (
  `id_ch` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `boss` varchar(100) DEFAULT NULL,
  `mile` varchar(100) DEFAULT NULL,
  `charge` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_ch`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge
-- ----------------------------
INSERT INTO `charge` VALUES ('1', '张三', '鄂A11111', '李老板', '4.6', '18.0 ');
INSERT INTO `charge` VALUES ('2', '张三', '鄂A11111', '李老板', '2.875', '8.0 ');
INSERT INTO `charge` VALUES ('3', '张三', '鄂A11111', '李老板', '2.1', '8.0 ');
INSERT INTO `charge` VALUES ('4', '张三', '鄂A11111', '刘老板', '1.85', '8 ');
INSERT INTO `charge` VALUES ('5', '张三', '陕C67543', '王老板', '7.375', '33.0 ');
INSERT INTO `charge` VALUES ('6', '张三', '鄂A11111', '陈老板', '4.525', '18.0 ');

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `id_p` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `nation` varchar(100) DEFAULT NULL,
  `jiguan` varchar(100) DEFAULT NULL,
  `idcard` varchar(100) DEFAULT NULL,
  `xueli` varchar(100) DEFAULT NULL,
  `school` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_p`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('1001', '张三', '男', '汉族', '湖北武汉', '610321197708123214', '大专', '清华大学', '13677889977', '13456723@qq.com', '庙山2街', '正常');
INSERT INTO `driver` VALUES ('1002', '李四', '女', '汉族', '北京', '611197708091234', '本科', '武汉大学', '13456789009', '123@qq.com', '庙山3街', '请假');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('张三', '123', '司机');
INSERT INTO `user` VALUES ('李四', '1234', '司机');
