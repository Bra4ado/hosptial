# hosptial青软实训医疗项目
## 前台：基于SpringBoot的SSM项目引入了虹软人脸识别
## 后台：基于renren快速开发平台的前后端分离项目（springboot+vue）

## 后台SQL
```
/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 14/10/2021 10:16:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '收费项目编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1015 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of charge
-- ----------------------------
INSERT INTO `charge` VALUES (1001, 'CT', 800, '2019-08-07 09:15:48');
INSERT INTO `charge` VALUES (1002, '甲功三项', 237, '2019-08-07 09:16:03');
INSERT INTO `charge` VALUES (1003, '血常规', 80, '2019-08-07 09:16:12');
INSERT INTO `charge` VALUES (1004, '肝功', 150, '2019-08-07 09:16:22');
INSERT INTO `charge` VALUES (1005, 'B超', 100, '2019-08-07 09:16:29');
INSERT INTO `charge` VALUES (1006, '尿检', 90, '2019-08-07 09:16:39');
INSERT INTO `charge` VALUES (1007, '心脏搭桥', 300000, '2019-08-07 09:16:58');
INSERT INTO `charge` VALUES (1008, '核磁共振', 1500, '2019-08-07 09:17:17');
INSERT INTO `charge` VALUES (1009, '肾脏移植', 150000, '2019-08-07 09:17:38');
INSERT INTO `charge` VALUES (1010, '胸透', 80, '2019-08-07 09:17:51');
INSERT INTO `charge` VALUES (1011, '变性手术', 993800, '2019-08-07 09:18:27');
INSERT INTO `charge` VALUES (1012, '整容', 120000, '2019-08-07 09:18:49');
INSERT INTO `charge` VALUES (1013, '灵魂出窍', 10000, '2019-08-08 14:13:07');
INSERT INTO `charge` VALUES (1014, '洗牙', 90, '2019-08-08 14:13:22');

-- ----------------------------
-- Table structure for charge_register
-- ----------------------------
DROP TABLE IF EXISTS `charge_register`;
CREATE TABLE `charge_register`  (
  `cr_id` int(11) NOT NULL AUTO_INCREMENT,
  `rno` int(11) NULL DEFAULT NULL COMMENT '病人外键',
  `cid` int(11) NULL DEFAULT NULL COMMENT '收费项目表外键',
  `charge_price` double NULL DEFAULT NULL,
  `charge_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cr_id`) USING BTREE,
  INDEX `rno`(`rno`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `charge_register_ibfk_1` FOREIGN KEY (`rno`) REFERENCES `register` (`rno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `charge_register_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `charge` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of charge_register
-- ----------------------------
INSERT INTO `charge_register` VALUES (1, 1001, 1001, 800, '2019-08-08 10:16:01');
INSERT INTO `charge_register` VALUES (2, 1001, 1002, 237, '2019-08-08 10:16:37');
INSERT INTO `charge_register` VALUES (3, 1004, 1002, 237, '2019-08-08 10:49:20');
INSERT INTO `charge_register` VALUES (4, 1002, 1001, 800, '2019-08-08 14:03:06');
INSERT INTO `charge_register` VALUES (5, 1002, 1001, 800, '2019-08-08 14:03:10');
INSERT INTO `charge_register` VALUES (6, 1002, 1011, 993800, '2019-08-08 14:03:23');
INSERT INTO `charge_register` VALUES (7, 1005, 1014, 90, '2019-08-08 14:13:35');
INSERT INTO `charge_register` VALUES (8, 1005, 1013, 10000, '2019-08-08 14:13:45');
INSERT INTO `charge_register` VALUES (9, 1006, 1011, 993800, '2019-10-20 15:37:17');
INSERT INTO `charge_register` VALUES (10, 1006, 1001, 800, '2019-10-20 15:37:42');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptid` int(11) NOT NULL AUTO_INCREMENT,
  `deptname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`deptid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '血液科', 0);
INSERT INTO `dept` VALUES (2, '骨科', 0);
INSERT INTO `dept` VALUES (3, '急诊科', 0);
INSERT INTO `dept` VALUES (4, '风湿免疫科', 0);
INSERT INTO `dept` VALUES (5, '喉颈外壳', 0);

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `card_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `department` tinyint(1) NULL DEFAULT NULL COMMENT '科室',
  `education` tinyint(1) NULL DEFAULT NULL COMMENT '学历',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, '华佗', '123292934984', '188294587132', 0, 50, '2019-08-02 14:20:28', 'huatuo@163.com', 0, 3, '妙手回春');
INSERT INTO `doctor` VALUES (2, '扁鹊', '166284884717', '102945732423', 0, 60, '2019-08-02 14:21:12', 'bianque@163.com', 2, 3, '赛华佗');
INSERT INTO `doctor` VALUES (3, '喜来乐', '194884575757', '1993948811', 0, 40, '2019-08-02 14:21:48', 'xilaile@163.com', 3, 2, '小扁鹊');
INSERT INTO `doctor` VALUES (4, '李时珍', '1948845757572', '19939481111', 0, 30, '2019-08-02 14:21:48', 'lishizhen@163.com', 5, 3, '尝百草');
INSERT INTO `doctor` VALUES (5, '端木蓉', '1884129898484822', '18347466133', 1, 18, '2019-08-02 14:21:48', 'duanmurong@163.com', 2, 3, '三不救');
INSERT INTO `doctor` VALUES (6, '杨永信', '192993848818334', '102945732423', 1, 48, '2019-08-02 14:57:50', 'xin@163.com', 1, 2, '专门治疗网瘾');
INSERT INTO `doctor` VALUES (7, '小甜甜', '103848577222', '102945732423', 1, 31, '1900-01-10 00:00:00', 'xilaile@163.com', 5, 2, '祖传治牙');
INSERT INTO `doctor` VALUES (8, '邯郸名医', '1828502099484823', '19993332256', 1, 80, '2019-10-20 15:31:58', 'sun_5988@163.com', 3, 3, '很厉害');

-- ----------------------------
-- Table structure for hospitalization
-- ----------------------------
DROP TABLE IF EXISTS `hospitalization`;
CREATE TABLE `hospitalization`  (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `rno` int(11) NULL DEFAULT NULL COMMENT '挂号信息外键',
  `bed_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '床号',
  `deposit` double NULL DEFAULT NULL COMMENT '押金',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病情描述',
  `in_date` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入院时间',
  `protect` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护理',
  PRIMARY KEY (`hid`) USING BTREE,
  INDEX `rno`(`rno`) USING BTREE,
  CONSTRAINT `hospitalization_ibfk_1` FOREIGN KEY (`rno`) REFERENCES `register` (`rno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hospitalization
-- ----------------------------
INSERT INTO `hospitalization` VALUES (1, 1001, '10', 200000, '----萌萌的', '2019-08-07 11:21:32', NULL);
INSERT INTO `hospitalization` VALUES (2, 1002, '9', 100022, '桐桐的', '2019-08-07 11:28:33', NULL);
INSERT INTO `hospitalization` VALUES (3, 1004, '666', 50, '疑似死亡', '2019-08-07 16:12:07', NULL);
INSERT INTO `hospitalization` VALUES (4, 1005, '90', 240718, '无病非要住院', '2019-08-08 14:11:38', NULL);
INSERT INTO `hospitalization` VALUES (5, 1006, '80', 20000, '严重掉头发', '2019-10-20 15:36:32', NULL);

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `mid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `in_price` double NULL DEFAULT NULL COMMENT '进价',
  `sal_price` double NULL DEFAULT NULL COMMENT '售价',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '药品类型 0处方1中药2西药',
  `descs` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简单描述',
  `quality_date` int(11) NULL DEFAULT NULL COMMENT '保质期',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细描述',
  `produce_firm` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂商',
  `readme` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服用说明',
  `count_all` int(11) NULL DEFAULT NULL COMMENT '总的进货量',
  `count_surplus` int(11) NULL DEFAULT NULL COMMENT '剩余量',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  UNIQUE INDEX `mid`(`mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('11111111111111', '<img src=\"https://z3.ax1x.com/2021/09/18/4l6ZE6.png\" alt=\"4l6ZE6.png\" border=\"0\" />', 11, 50, '彩虹胶囊', 2, '可以变成彩虹', 36, '2222222', '', '服用几天后生效', NULL, NULL, '');
INSERT INTO `medicine` VALUES ('2132', 'd5dbe243-c318-4691-a362-7775107e0ee1.jpg', 56, 100, '万通筋骨贴', 1, '==', 200, '==', '==', '==', NULL, NULL, '==');
INSERT INTO `medicine` VALUES ('2311', 'd710f815-bfd0-4192-b773-279ab06614e7.jpg', 23, 32, '盘尼西林', 2, '起死回生', 36, '之各种病', '宛西制药', '口服', NULL, NULL, '随便吃');
INSERT INTO `medicine` VALUES ('333', '048ad923-2ba6-4570-bf8b-02110a43a82a.jpg', 1, 1, '123', 1, '1', 36, '1', '1', '1', NULL, NULL, '1');
INSERT INTO `medicine` VALUES ('44', '03910cc8-b9ef-4d62-850a-abd647686533.jpg', 20, 200, '舒血宁注射液', 2, '专注血液病', 36, '专治血液病，立杆见效', '河北大药厂', '口服', NULL, NULL, '详见说明书');
INSERT INTO `medicine` VALUES ('8888888', '04843d99-c317-4291-8dbc-a60300c3fc71.jpg', 1, 999999999999, '脑残片', 0, '脑残专治', 36, '对脑残有奇效', '天知道', '意念服用', NULL, NULL, '');
INSERT INTO `medicine` VALUES ('9999', '43b89952-28a2-4944-ab8d-9ddb7d1d8d80.png', 9.9, 99, '乌鸡凤凰丸', 2, '好吃又大补', 1, '乌鸡变凤凰', '花果山', '当豆子吃', NULL, NULL, '就是棒');
INSERT INTO `medicine` VALUES ('999感冒灵', 'd8816b11-1ccf-40aa-bfe1-2fa8f91681fc.jpg', 5, 20, '感冒灵·', 0, '治疗感冒', 36, '治疗感冒', '1', '1', NULL, NULL, '1');
INSERT INTO `medicine` VALUES ('AAAA-1', '91c26b47-407d-467e-aae6-6f1eb634e8c1.jpg', 11.1111, 1111111111, '多情直男三件套', 0, '若为自由故,两者皆可抛~~~~~', 36, '有了三件套,解决你烦恼.', '大安帝国/.', '想咋吃咋吃.', NULL, NULL, '吃完贼拉拉带劲,干就完咧');
INSERT INTO `medicine` VALUES ('BTT', 'a8b090b2-49f3-4213-afd5-3f71e97345fd.jpg', 10, 20, '宝塔糖', 0, '专职蛔虫', 36, '专职蛔虫', '=====', '不能多吃！更不能随便吃！', NULL, NULL, '=======');
INSERT INTO `medicine` VALUES ('cat-001', '0bab6ddb-7c02-4447-8d6e-619b1f655ca0.jpeg', 100, 101, '猫薄荷', 0, '救猫', 36, '==', '中公猫厂', '吸服', NULL, NULL, '==');
INSERT INTO `medicine` VALUES ('changde-1100', 'afdddd94-7e80-48a3-8b35-f8ea939186ed.jpg', 12, 11, '马来酸非尼拉敏盐酸萘甲唑啉滴眼液', 0, '非常好', 36, '不错', '不', '==', NULL, NULL, '==');
INSERT INTO `medicine` VALUES ('CYN-0011', '173823e3-28c5-400d-a17a-a7ebcdb3ad14.jpg', 25, 30, '肠炎宁', 2, '治疗胃病', 36, '非常实用', '医药公司', '一日3次，每次一片', NULL, NULL, '-----');
INSERT INTO `medicine` VALUES ('DCY-001', '80325b28-b070-4653-82d2-90932cf433e8.jpg', 1, 10, '打虫药', 0, '打虫药', 36, '甜滋滋', '打虫药', '打虫药', NULL, NULL, '打虫药');
INSERT INTO `medicine` VALUES ('DJ-74110', '3a6dc695-65b1-4f14-8da9-c942cc9f98e4.jpg', 1000, 100000, '精神病', 2, '治理精神病', 36, '专治精神病', '未知', '未知', NULL, NULL, '谁用谁知道');
INSERT INTO `medicine` VALUES ('DL-001', '1c180f77-b0e1-495a-991f-e4da13033f59.jpg', 100, 500, '大力出奇迹', 2, '强悍', 11, '大力哥最爱', '大力公司', '直接吞服', NULL, 88, '===');
INSERT INTO `medicine` VALUES ('GMLKL', '938abb13-2c13-4d33-8767-f70717b1708d.jpg', 100, 10, '感冒灵颗粒', 0, '治感冒', 1, '治感冒', '小儿', '1天一盒', NULL, NULL, '包治百病');
INSERT INTO `medicine` VALUES ('H-2345', '1d406b70-85d5-4460-b1b8-2d31c6ce8fc2.jpg', 15, 35, '999感冒灵颗粒', 2, '感冒必备', 36, '感冒必备', '13245678', '口服', NULL, NULL, '####');
INSERT INTO `medicine` VALUES ('hdh1254', '39c7d56c-f7a3-4251-95f7-dc6bd49c48e5.jpg', 30, 50, '鹤顶红', 0, '好用啊', 36, '一点就好用', '奸商', '口服', NULL, NULL, '别不小心自己喝了');
INSERT INTO `medicine` VALUES ('HH-001', '25f703a4-d733-41e0-b53f-d679e9bd69a0.jpg', 100, 10000, '后悔药', 0, '后悔药', 36, '后悔药', '后悔药', '沸水送服', NULL, NULL, '后悔药');
INSERT INTO `medicine` VALUES ('HHY-001', 'b188792d-9787-4d3b-be52-f83e63ca7407.jpg', 25, 100, '红花油', 1, '包治百病！', 36, '好', '好', '直接喝！', NULL, NULL, '好');
INSERT INTO `medicine` VALUES ('HZ-16326', '02b7b77d-d3d1-4c58-9e83-fb26ef6e2da2.jpg', 2, 5, '三黄片', 0, '清热解毒', 36, '具有清热解毒，泻火通便功效。主治三焦热盛，目赤肿痛，口鼻生疮，咽喉肿痛，心烦口渴。', '亚宝药业', '1日2次', NULL, NULL, '无');
INSERT INTO `medicine` VALUES ('HZ-199384', '5a2a44b3-5e97-4aa1-956b-b4bc19fdba01.jpg', 6, 16, '藿香正气水', 1, '治疗中暑', 400, '==', '--', '---', NULL, NULL, '---');
INSERT INTO `medicine` VALUES ('jbsw', 'aa2b3702-94a8-44e9-9a0e-d600fd46bb4b.jpg', 999, 99990, '九步蛇丸', 1, '没有描述', 999, '没有描述', '没有厂商', '随便服用', NULL, NULL, '没有备注');
INSERT INTO `medicine` VALUES ('jj_002', 'cc9e5aa4-febb-404e-a834-aed4f5917293.jpg', 9.9, 19, '九九感冒灵', 0, '治感冒', 36, '疗效', '九九制药', '本品解热镇痛。用于感冒引起的头痛，发热等', NULL, NULL, '本品为浅棕色至深棕色的颗粒，味甜、微苦。每盒含9包，每包袋装10g。解热镇痛功效，用于因感冒引起的头痛，发热，鼻塞，流涕，咽痛等症状。');
INSERT INTO `medicine` VALUES ('ML-001', '25ad4300-8c77-420a-81d0-b0dd400f840e.jpg', 80000, 100000, '爱的魔力药水', 0, '转圈圈', 100, '爱的魔力转圈圈', '爱情', '口服', NULL, NULL, '转圈圈');
INSERT INTO `medicine` VALUES ('No.00001', 'f8658818-341f-4a02-8862-eceb9e67efe5.jpg', 10000, 10000, '还魂丹', 0, '一颗极乐,两颗升天', 1, '灵隐寺', '灵隐寺', '一口吞服', NULL, NULL, '');
INSERT INTO `medicine` VALUES ('No1', 'f11edb5f-a3be-4477-9a66-cf8400062a3e.jpg', 10000, 10000000, '天山雪莲', 1, '老好呲了', 36, '--', '-', '-', NULL, NULL, '-');
INSERT INTO `medicine` VALUES ('No2', 'b25dc979-8b7a-4469-83e6-eccee5b96c1c.jpg', 10002020, 120301230120, 'nice棒棒鼓励片', 0, '老好呲了', 36, '-', '-', '-', NULL, NULL, '-');
INSERT INTO `medicine` VALUES ('No3', '6bde8c74-1736-4108-92ce-a72f9b768d30.jpg', 123123, 123123412312, '肛泰', 0, '-', 36, '-', '-', '-', NULL, NULL, '-');
INSERT INTO `medicine` VALUES ('pc9988', 'f66331a3-bf95-4e35-9d26-d300a8e8b3d5.jpg', 15, 150, '万通筋骨片', 0, '一吃就好', 36, '谁用谁知道', '三九制药', '别忘了吃', NULL, NULL, '忌酒');
INSERT INTO `medicine` VALUES ('QXTYS-110', 'a9c41431-78a0-4146-9eab-25d11695b003.jpg', 10000, 99999, '强效太阳水', 1, '喝一瓶想两瓶', 36, '牛逼', '盛大或者？？？', '外服内服', NULL, NULL, '666');
INSERT INTO `medicine` VALUES ('SKKFF-1-23213', '3bdb01fe-76dd-4a64-a2fa-cb7ea662a79e.jpg', 20, 40, '复方炔诺酮糖衣片', 2, '女人掌握核心科技', 36, '避免意外怀孕', '不知道', '口服', NULL, NULL, '自己理解');
INSERT INTO `medicine` VALUES ('SS-001', '4661e4bd-f27e-4a0a-959a-0d8ff4456a4a.jpg', 111, 10000, '烧烧果实', 0, '烧烧果实', 36, '烧烧果实', '烧烧果实', '烧烧果实', NULL, NULL, '烧烧果实');
INSERT INTO `medicine` VALUES ('STDYW-01', '61173dbe-8214-4c2b-8dc5-91776b994cc6.jpeg', 20, 200, '伸腿瞪眼丸', 1, '很好吃', 36, '吃完就伸腿', '伸腿公司', '生吞', NULL, NULL, '嘎嘎嘎');
INSERT INTO `medicine` VALUES ('SXRJS-001', '790c5e35-78c9-44bb-aeb3-9d7d446304b5.jpg', 34, 430, '黑玉断骨膏', 0, '又香又好吃', 36, '香的一批，又好看又好吃', '孙伟志牌烤肉店', '香的一批，又好看又好吃', NULL, NULL, '孙伟志牌烤肉香的一批，又好看又好吃');
INSERT INTO `medicine` VALUES ('WTJGT-123', '07aa2375-32b9-404f-bbe6-8157745cf340.jpg', 45, 100, '万通胫骨贴', 1, '贴上暖暖的', 36, '直接贴', 'baidu', '直接贴', NULL, NULL, '效果666');
INSERT INTO `medicine` VALUES ('YKN-008', 'c9bd59d3-f0ce-49f1-a1d0-97fced715a68.png', 88, 188, '炎可宁片', 2, '就是牛!', 12, '一粒就见效!', '吉尔吉药业', '使劲吃!', NULL, NULL, '------');
INSERT INTO `medicine` VALUES ('YNBY-001', '559ab16f-82c5-4a1e-8b8e-1f73e0045aea.jpg', 10, 30, '云南白药', 2, '神药', 36, '具特异性香气，味略感清凉，并有麻舌感。', '云南', '口服', NULL, NULL, '。。。');
INSERT INTO `medicine` VALUES ('YSG--110', 'b0af939f-966c-47d4-b566-cafd844733a7.gif', 20, 30000, '药水哥', 2, '解心宽', 36, '解懒解心宽', '--', '==', NULL, NULL, '===');
INSERT INTO `medicine` VALUES ('YYHHS', '02c1c87e-cfcc-4398-ad2b-4a85e28bd7c4.jpg', 250, 500, '阴阳合欢散', 1, '很嗨皮', 50, '嗨皮的很', '自制', '直接服用', NULL, NULL, '嗨到飞起');
INSERT INTO `medicine` VALUES ('ZH-0000001', '93e5753e-6f92-43f0-aa81-c77142857181.jpg', 10000, 200000, '绮罗郁金香', 1, '规避任何毒物', 33333, '不知道', '斗罗大陆', '携带身边', NULL, NULL, '不要食用');
INSERT INTO `medicine` VALUES ('zzw-001', 'd1ce6850-229e-4995-b96b-e5991989a0e2.jpg', 2, 20000, '智障丸', 2, '治智障神药', 36, '一次一片，立刻见效', '智障厂', '==', NULL, NULL, '==');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', NULL, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017C1CE01CF07874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'DESKTOP-OG0HBAG1632963738109', 1632969155719, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1632970800000, 1632969000000, 5, 'WAITING', 'CRON', 1632573107000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017C1CE01CF07874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `rno` int(20) NOT NULL AUTO_INCREMENT COMMENT '病历号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_card` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `si_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社保号',
  `register_money` double NULL DEFAULT NULL COMMENT '挂号费用',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `is_pay` tinyint(4) NULL DEFAULT NULL COMMENT '是否自费',
  `sex` tinyint(4) NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `job` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `consultation` tinyint(4) NULL DEFAULT NULL COMMENT '初复诊',
  `department` tinyint(4) NULL DEFAULT NULL COMMENT '科室',
  `did` int(11) NULL DEFAULT NULL COMMENT '医生外键',
  `status` int(11) NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `register_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rno`) USING BTREE,
  INDEX `did`(`did`) USING BTREE,
  CONSTRAINT `register_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1007 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES (1000, '郭达·斯坦森', '19572773743323', '1287387', 5000, '102945732423', 0, 0, 50, '演员', 1, 2, 4, 3, '=====', '2019-08-06 10:50:27');
INSERT INTO `register` VALUES (1001, '萌萌哒', '19572773743323', '1287387', 8000, '102945732423', 0, 1, 18, '演员123', 1, 2, 6, 3, '====', '2019-08-06 14:17:25');
INSERT INTO `register` VALUES (1002, '桐桐', '19572773743323', '1287387', 1, '102945732423', 0, 1, 48, '杠精', 0, 4, 3, 3, '===', '2019-08-06 14:18:08');
INSERT INTO `register` VALUES (1003, '静静', '19572773743323', '1287387', 11, '102945732423', 0, 1, 50, '演员', 1, 3, 2, 3, '123', '2019-08-06 14:18:37');
INSERT INTO `register` VALUES (1004, '贞子', '19572773743323', '1287387', 5000, '102945732423', 0, 1, 18, '女鬼', 0, 2, 6, 3, '=====', '2019-08-07 16:11:14');
INSERT INTO `register` VALUES (1005, '牛魔王', '19572773743323', '11000', 500, '102945732423', 0, 0, 50, '积雷山山大王', 1, 5, 7, 3, '别有用心', '2019-08-08 14:10:06');
INSERT INTO `register` VALUES (1006, '孙大圣', '183331222', '112255555', 50, '100000000', 0, 0, 22, '程序员', 0, 3, 8, 3, '掉头发', '2019-10-20 15:34:08');

-- ----------------------------
-- Table structure for register_medicine
-- ----------------------------
DROP TABLE IF EXISTS `register_medicine`;
CREATE TABLE `register_medicine`  (
  `mid` int(11) NOT NULL,
  `rid` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of register_medicine
-- ----------------------------

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `text` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `href` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES (6, '资源管理', 'res?mark=findResourcesList');
INSERT INTO `resources` VALUES (7, '门诊医生管理', 'doctor?mark=findDoctorList');
INSERT INTO `resources` VALUES (10, '角色管理', 'role?mark=findRoleList');
INSERT INTO `resources` VALUES (11, '用户管理', 'users?mark=findUserList');
INSERT INTO `resources` VALUES (12, '药品管理', 'medicine?mark=findMedicineListFY');
INSERT INTO `resources` VALUES (13, '挂号信息管理', 'register?mark=findRegisterList');
INSERT INTO `resources` VALUES (14, '检查收费项管理', 'charge?mark=findChargeList');
INSERT INTO `resources` VALUES (15, '住院办理', 'hos?mark=findHospitalizationList');
INSERT INTO `resources` VALUES (16, '检查收费项目登记', 'crs?mark=findChargeList');
INSERT INTO `resources` VALUES (17, '住院结算', 'hac?mark=findHospitalizationAccountsList');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  `rolename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (5, 1, '管理员(系统维护)');
INSERT INTO `role` VALUES (8, 1, '院长');
INSERT INTO `role` VALUES (9, 1, '药师');
INSERT INTO `role` VALUES (10, 1, '财务');
INSERT INTO `role` VALUES (11, 1, '主治医师');

-- ----------------------------
-- Table structure for role_resources
-- ----------------------------
DROP TABLE IF EXISTS `role_resources`;
CREATE TABLE `role_resources`  (
  `role_id` int(11) NULL DEFAULT NULL,
  `res_id` int(11) NULL DEFAULT NULL,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `res_id`(`res_id`) USING BTREE,
  CONSTRAINT `role_resources_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_resources_ibfk_2` FOREIGN KEY (`res_id`) REFERENCES `resources` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_resources
-- ----------------------------
INSERT INTO `role_resources` VALUES (9, 12);
INSERT INTO `role_resources` VALUES (8, 7);
INSERT INTO `role_resources` VALUES (11, 12);
INSERT INTO `role_resources` VALUES (11, 13);
INSERT INTO `role_resources` VALUES (11, 14);
INSERT INTO `role_resources` VALUES (11, 15);
INSERT INTO `role_resources` VALUES (11, 16);
INSERT INTO `role_resources` VALUES (5, 6);
INSERT INTO `role_resources` VALUES (5, 7);
INSERT INTO `role_resources` VALUES (5, 10);
INSERT INTO `role_resources` VALUES (5, 11);
INSERT INTO `role_resources` VALUES (5, 12);
INSERT INTO `role_resources` VALUES (5, 13);
INSERT INTO `role_resources` VALUES (5, 14);
INSERT INTO `role_resources` VALUES (5, 15);
INSERT INTO `role_resources` VALUES (5, 16);
INSERT INTO `role_resources` VALUES (5, 17);
INSERT INTO `role_resources` VALUES (10, 13);
INSERT INTO `role_resources` VALUES (10, 14);
INSERT INTO `role_resources` VALUES (10, 15);
INSERT INTO `role_resources` VALUES (10, 16);
INSERT INTO `role_resources` VALUES (10, 17);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES (1, 'testTask', 'renren', '0 0/30 * * * ?', 0, '参数测试', '2021-09-25 20:13:42');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES (1, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-26 10:30:00');
INSERT INTO `schedule_job_log` VALUES (2, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-26 11:30:00');
INSERT INTO `schedule_job_log` VALUES (3, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-26 14:00:00');
INSERT INTO `schedule_job_log` VALUES (4, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-26 14:30:00');
INSERT INTO `schedule_job_log` VALUES (5, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-26 15:00:00');
INSERT INTO `schedule_job_log` VALUES (6, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-26 15:30:00');
INSERT INTO `schedule_job_log` VALUES (7, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-26 16:00:00');
INSERT INTO `schedule_job_log` VALUES (8, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-26 16:30:00');
INSERT INTO `schedule_job_log` VALUES (9, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-26 17:00:00');
INSERT INTO `schedule_job_log` VALUES (10, 1, 'testTask', 'renren', 0, NULL, 2, '2021-09-27 09:00:00');
INSERT INTO `schedule_job_log` VALUES (11, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-27 10:30:00');
INSERT INTO `schedule_job_log` VALUES (12, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-27 11:00:00');
INSERT INTO `schedule_job_log` VALUES (13, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-27 11:30:00');
INSERT INTO `schedule_job_log` VALUES (14, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-27 18:00:00');
INSERT INTO `schedule_job_log` VALUES (15, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-27 18:30:00');
INSERT INTO `schedule_job_log` VALUES (16, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-27 19:00:00');
INSERT INTO `schedule_job_log` VALUES (17, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-27 19:30:00');
INSERT INTO `schedule_job_log` VALUES (18, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-27 20:00:00');
INSERT INTO `schedule_job_log` VALUES (19, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-27 21:00:00');
INSERT INTO `schedule_job_log` VALUES (20, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-28 09:30:00');
INSERT INTO `schedule_job_log` VALUES (21, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-28 11:30:00');
INSERT INTO `schedule_job_log` VALUES (22, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-28 12:00:00');
INSERT INTO `schedule_job_log` VALUES (23, 1, 'testTask', 'renren', 0, NULL, 2, '2021-09-28 12:30:00');
INSERT INTO `schedule_job_log` VALUES (24, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-28 13:00:00');
INSERT INTO `schedule_job_log` VALUES (25, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-28 13:30:00');
INSERT INTO `schedule_job_log` VALUES (26, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-28 15:30:00');
INSERT INTO `schedule_job_log` VALUES (27, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-28 16:00:00');
INSERT INTO `schedule_job_log` VALUES (28, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-28 16:30:00');
INSERT INTO `schedule_job_log` VALUES (29, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-30 09:30:00');
INSERT INTO `schedule_job_log` VALUES (30, 1, 'testTask', 'renren', 0, NULL, 1, '2021-09-30 10:00:00');
INSERT INTO `schedule_job_log` VALUES (31, 1, 'testTask', 'renren', 0, NULL, 0, '2021-09-30 10:30:00');

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统验证码' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('062e2f19-0e23-40ff-8900-13dc92df5f15', 'xw5p7', '2021-09-29 23:09:18');
INSERT INTO `sys_captcha` VALUES ('9629873a-de81-4089-89d7-b0e08b019fad', 'nd8p8', '2021-09-26 10:32:28');
INSERT INTO `sys_captcha` VALUES ('9cb91814-d872-46ba-8e18-1e65284733b3', '5g882', '2021-09-28 10:30:09');
INSERT INTO `sys_captcha` VALUES ('e8126931-3490-4e5e-8fe8-ee05f053e8f5', 'nnxan', '2021-09-28 10:37:21');
INSERT INTO `sys_captcha` VALUES ('f910f7b4-7e6d-41ea-8390-fd6389c92332', '43ycg', '2021-09-28 10:37:50');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `param_key`(`param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '[{\"menuId\":96,\"parentId\":0,\"name\":\"医院管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"zonghe\",\"orderNum\":0,\"list\":[]}]', 4, '0:0:0:0:0:0:0:1', '2021-09-26 14:36:48');
INSERT INTO `sys_log` VALUES (2, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":96,\"parentId\":0,\"name\":\"医院管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"zonghe\",\"orderNum\":1,\"list\":[]}]', 5, '0:0:0:0:0:0:0:1', '2021-09-26 14:37:27');
INSERT INTO `sys_log` VALUES (3, 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '[{\"menuId\":97,\"parentId\":0,\"name\":\"医院用户管理\",\"url\":\"#\",\"perms\":\"\",\"type\":1,\"icon\":\"admin\",\"orderNum\":1,\"list\":[]}]', 2, '0:0:0:0:0:0:0:1', '2021-09-26 14:39:29');
INSERT INTO `sys_log` VALUES (4, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":97,\"parentId\":96,\"name\":\"医院用户管理\",\"url\":\"#\",\"perms\":\"\",\"type\":1,\"icon\":\"admin\",\"orderNum\":1,\"list\":[]}]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 14:39:48');
INSERT INTO `sys_log` VALUES (5, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":97,\"parentId\":96,\"name\":\"医院用户管理\",\"url\":\"hospital/users\",\"perms\":\"\",\"type\":1,\"icon\":\"admin\",\"orderNum\":1,\"list\":[]}]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 14:40:19');
INSERT INTO `sys_log` VALUES (6, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":97,\"parentId\":96,\"name\":\"医院用户管理\",\"url\":\"hospital/users\",\"perms\":\"\",\"type\":1,\"icon\":\"admin\",\"orderNum\":1,\"list\":[]}]', 2, '0:0:0:0:0:0:0:1', '2021-09-26 14:47:07');
INSERT INTO `sys_log` VALUES (7, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[97]', 36, '0:0:0:0:0:0:0:1', '2021-09-26 14:47:14');
INSERT INTO `sys_log` VALUES (8, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":31,\"parentId\":96,\"name\":\"医院用户管理\",\"url\":\"hospital/users\",\"type\":1,\"icon\":\"config\",\"orderNum\":1,\"list\":[]}]', 4, '0:0:0:0:0:0:0:1', '2021-09-26 14:47:39');
INSERT INTO `sys_log` VALUES (9, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":36,\"parentId\":96,\"name\":\"检查项目\",\"url\":\"hospital/charge\",\"type\":1,\"icon\":\"config\",\"orderNum\":2,\"list\":[]}]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 14:48:56');
INSERT INTO `sys_log` VALUES (10, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":46,\"parentId\":96,\"name\":\"科室管理\",\"url\":\"hospital/dept\",\"type\":1,\"icon\":\"config\",\"orderNum\":3,\"list\":[]}]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 14:49:41');
INSERT INTO `sys_log` VALUES (11, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":51,\"parentId\":96,\"name\":\"医生管理\",\"url\":\"hospital/doctor\",\"type\":1,\"icon\":\"config\",\"orderNum\":3,\"list\":[]}]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 14:50:23');
INSERT INTO `sys_log` VALUES (12, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":51,\"parentId\":96,\"name\":\"医生管理\",\"url\":\"hospital/doctor\",\"type\":1,\"icon\":\"config\",\"orderNum\":4,\"list\":[]}]', 7, '0:0:0:0:0:0:0:1', '2021-09-26 14:50:32');
INSERT INTO `sys_log` VALUES (13, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":56,\"parentId\":96,\"name\":\"住院办理管理\",\"url\":\"hospital/hospitalization\",\"type\":1,\"icon\":\"config\",\"orderNum\":5,\"list\":[]}]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 14:52:18');
INSERT INTO `sys_log` VALUES (14, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":66,\"parentId\":96,\"name\":\"病人管理\",\"url\":\"hospital/register\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 14:53:46');
INSERT INTO `sys_log` VALUES (15, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":61,\"parentId\":96,\"name\":\"药物管理\",\"url\":\"hospital/medicine\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 2, '0:0:0:0:0:0:0:1', '2021-09-26 14:54:48');
INSERT INTO `sys_log` VALUES (16, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[91]', 2, '0:0:0:0:0:0:0:1', '2021-09-26 14:55:08');
INSERT INTO `sys_log` VALUES (17, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[95]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 16:50:56');
INSERT INTO `sys_log` VALUES (18, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[94]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 16:50:58');
INSERT INTO `sys_log` VALUES (19, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[91]', 1, '0:0:0:0:0:0:0:1', '2021-09-26 16:52:02');
INSERT INTO `sys_log` VALUES (20, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[92]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 16:52:05');
INSERT INTO `sys_log` VALUES (21, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[93]', 2, '0:0:0:0:0:0:0:1', '2021-09-26 16:52:13');
INSERT INTO `sys_log` VALUES (22, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[91]', 3, '0:0:0:0:0:0:0:1', '2021-09-26 16:52:20');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'http://localhost:8080/renren-fast/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO `sys_menu` VALUES (6, 1, '定时任务', 'job/schedule', NULL, 1, 'job', 5);
INSERT INTO `sys_menu` VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO `sys_menu` VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);
INSERT INTO `sys_menu` VALUES (31, 96, '医院用户管理', 'hospital/users', NULL, 1, 'config', 1);
INSERT INTO `sys_menu` VALUES (32, 31, '查看', NULL, 'hospital:users:list,hospital:users:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (33, 31, '新增', NULL, 'hospital:users:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (34, 31, '修改', NULL, 'hospital:users:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (35, 31, '删除', NULL, 'hospital:users:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (36, 96, '检查项目', 'hospital/charge', NULL, 1, 'config', 2);
INSERT INTO `sys_menu` VALUES (37, 36, '查看', NULL, 'hospital:charge:list,hospital:charge:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (38, 36, '新增', NULL, 'hospital:charge:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (39, 36, '修改', NULL, 'hospital:charge:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (40, 36, '删除', NULL, 'hospital:charge:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (41, 1, '', 'hospital/chargeregister', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (42, 41, '查看', NULL, 'hospital:chargeregister:list,hospital:chargeregister:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (43, 41, '新增', NULL, 'hospital:chargeregister:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (44, 41, '修改', NULL, 'hospital:chargeregister:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (45, 41, '删除', NULL, 'hospital:chargeregister:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (46, 96, '科室管理', 'hospital/dept', NULL, 1, 'config', 3);
INSERT INTO `sys_menu` VALUES (47, 46, '查看', NULL, 'hospital:dept:list,hospital:dept:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (48, 46, '新增', NULL, 'hospital:dept:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (49, 46, '修改', NULL, 'hospital:dept:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (50, 46, '删除', NULL, 'hospital:dept:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (51, 96, '医生管理', 'hospital/doctor', NULL, 1, 'config', 4);
INSERT INTO `sys_menu` VALUES (52, 51, '查看', NULL, 'hospital:doctor:list,hospital:doctor:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (53, 51, '新增', NULL, 'hospital:doctor:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (54, 51, '修改', NULL, 'hospital:doctor:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (55, 51, '删除', NULL, 'hospital:doctor:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (56, 96, '住院办理管理', 'hospital/hospitalization', NULL, 1, 'config', 5);
INSERT INTO `sys_menu` VALUES (57, 56, '查看', NULL, 'hospital:hospitalization:list,hospital:hospitalization:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (58, 56, '新增', NULL, 'hospital:hospitalization:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (59, 56, '修改', NULL, 'hospital:hospitalization:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (60, 56, '删除', NULL, 'hospital:hospitalization:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (61, 96, '药物管理', 'hospital/medicine', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (62, 61, '查看', NULL, 'hospital:medicine:list,hospital:medicine:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (63, 61, '新增', NULL, 'hospital:medicine:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (64, 61, '修改', NULL, 'hospital:medicine:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (65, 61, '删除', NULL, 'hospital:medicine:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (66, 96, '病人管理', 'hospital/register', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (67, 66, '查看', NULL, 'hospital:register:list,hospital:register:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (68, 66, '新增', NULL, 'hospital:register:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (69, 66, '修改', NULL, 'hospital:register:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (70, 66, '删除', NULL, 'hospital:register:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (71, 1, '', 'hospital/registermedicine', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (72, 71, '查看', NULL, 'hospital:registermedicine:list,hospital:registermedicine:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (73, 71, '新增', NULL, 'hospital:registermedicine:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (74, 71, '修改', NULL, 'hospital:registermedicine:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (75, 71, '删除', NULL, 'hospital:registermedicine:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (76, 1, '', 'hospital/resources', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (77, 76, '查看', NULL, 'hospital:resources:list,hospital:resources:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (78, 76, '新增', NULL, 'hospital:resources:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (79, 76, '修改', NULL, 'hospital:resources:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (80, 76, '删除', NULL, 'hospital:resources:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (81, 1, '', 'hospital/role', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (82, 81, '查看', NULL, 'hospital:role:list,hospital:role:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (83, 81, '新增', NULL, 'hospital:role:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (84, 81, '修改', NULL, 'hospital:role:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (85, 81, '删除', NULL, 'hospital:role:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (86, 1, '', 'hospital/roleresources', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (87, 86, '查看', NULL, 'hospital:roleresources:list,hospital:roleresources:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (88, 86, '新增', NULL, 'hospital:roleresources:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (89, 86, '修改', NULL, 'hospital:roleresources:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (90, 86, '删除', NULL, 'hospital:roleresources:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (96, 0, '医院管理', '', '', 0, 'zonghe', 1);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件上传' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', 1, 1, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户Token' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, '91b9872bb886723e7b837b27e8d3f02c', '2021-09-30 21:02:47', '2021-09-30 09:02:47');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifytime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  `roleid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE,
  INDEX `roleid`(`roleid`) USING BTREE,
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (6, '孙浩楠', 'nan@163.com', 0, 'sunwz', '123456', '2019-08-07 11:43:25', 5);
INSERT INTO `users` VALUES (7, '牛院长', 'xin@163.com', 0, 'niu', '123456', '2019-08-07 11:45:45', 8);
INSERT INTO `users` VALUES (8, '琪琪', 'bianque@163.com', 0, 'qiqi', '123456', '2019-08-07 11:46:05', 9);
INSERT INTO `users` VALUES (9, '萌萌哒', 'huatuo@163.com', 0, 'mm', '123456', '2019-08-07 11:46:29', 10);
INSERT INTO `users` VALUES (10, '程程', 'xin@163.com', 0, 'cc', '123456', '2019-08-07 11:46:51', 11);

SET FOREIGN_KEY_CHECKS = 1;
```

## 前台SQL
```
/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : hosipital2

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 14/10/2021 10:17:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '收费项目编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1015 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of charge
-- ----------------------------
INSERT INTO `charge` VALUES (1001, 'CT', 800, '2019-08-07 09:15:48');
INSERT INTO `charge` VALUES (1002, '甲功三项', 237, '2019-08-07 09:16:03');
INSERT INTO `charge` VALUES (1003, '血常规', 80, '2019-08-07 09:16:12');
INSERT INTO `charge` VALUES (1004, '肝功', 150, '2019-08-07 09:16:22');
INSERT INTO `charge` VALUES (1005, 'B超', 100, '2019-08-07 09:16:29');
INSERT INTO `charge` VALUES (1006, '尿检', 90, '2019-08-07 09:16:39');
INSERT INTO `charge` VALUES (1007, '心脏搭桥', 300000, '2019-08-07 09:16:58');
INSERT INTO `charge` VALUES (1008, '核磁共振', 1500, '2019-08-07 09:17:17');
INSERT INTO `charge` VALUES (1009, '肾脏移植', 150000, '2019-08-07 09:17:38');
INSERT INTO `charge` VALUES (1010, '胸透', 80, '2019-08-07 09:17:51');
INSERT INTO `charge` VALUES (1011, '变性手术', 993800, '2019-08-07 09:18:27');
INSERT INTO `charge` VALUES (1012, '整容', 120000, '2019-08-07 09:18:49');
INSERT INTO `charge` VALUES (1013, '灵魂出窍', 10000, '2019-08-08 14:13:07');
INSERT INTO `charge` VALUES (1014, '洗牙', 90, '2019-08-08 14:13:22');

-- ----------------------------
-- Table structure for charge_register
-- ----------------------------
DROP TABLE IF EXISTS `charge_register`;
CREATE TABLE `charge_register`  (
  `cr_id` int(11) NOT NULL AUTO_INCREMENT,
  `rno` int(11) NULL DEFAULT NULL COMMENT '病人外键',
  `cid` int(11) NULL DEFAULT NULL COMMENT '收费项目表外键',
  `charge_price` double NULL DEFAULT NULL,
  `charge_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cr_id`) USING BTREE,
  INDEX `rno`(`rno`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `charge_register_ibfk_1` FOREIGN KEY (`rno`) REFERENCES `register` (`rno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `charge_register_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `charge` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of charge_register
-- ----------------------------
INSERT INTO `charge_register` VALUES (1, 1001, 1001, 800, '2019-08-08 10:16:01');
INSERT INTO `charge_register` VALUES (2, 1001, 1002, 237, '2019-08-08 10:16:37');
INSERT INTO `charge_register` VALUES (3, 1004, 1002, 237, '2019-08-08 10:49:20');
INSERT INTO `charge_register` VALUES (4, 1002, 1001, 800, '2019-08-08 14:03:06');
INSERT INTO `charge_register` VALUES (5, 1002, 1001, 800, '2019-08-08 14:03:10');
INSERT INTO `charge_register` VALUES (6, 1002, 1011, 993800, '2019-08-08 14:03:23');
INSERT INTO `charge_register` VALUES (7, 1005, 1014, 90, '2019-08-08 14:13:35');
INSERT INTO `charge_register` VALUES (8, 1005, 1013, 10000, '2019-08-08 14:13:45');
INSERT INTO `charge_register` VALUES (9, 1006, 1011, 993800, '2019-10-20 15:37:17');
INSERT INTO `charge_register` VALUES (10, 1006, 1001, 800, '2019-10-20 15:37:42');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptid` int(11) NOT NULL AUTO_INCREMENT,
  `deptname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`deptid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '血液科', 0);
INSERT INTO `dept` VALUES (2, '骨科', 0);
INSERT INTO `dept` VALUES (3, '急诊科', 0);
INSERT INTO `dept` VALUES (4, '风湿免疫科', 0);
INSERT INTO `dept` VALUES (5, '喉颈外壳', 0);

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail`  (
  `did` int(11) NOT NULL,
  `rno` int(11) NULL DEFAULT NULL,
  `mid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `price` decimal(65, 2) NULL DEFAULT NULL,
  `modifyTime` datetime NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES (1, 1000, '2132', 2, 1333.00, '2021-09-28 10:00:59');
INSERT INTO `detail` VALUES (4, 1001, '2132', 11, 133.00, '2021-09-28 11:23:51');
INSERT INTO `detail` VALUES (2, 1002, '2311', 11, 11.00, '2021-09-28 11:25:16');
INSERT INTO `detail` VALUES (4, 1002, '333', 11, 11.00, '2021-09-28 14:26:02');
INSERT INTO `detail` VALUES (1, 1003, 'cat-001', 11, 1111.00, '2021-09-28 14:27:10');
INSERT INTO `detail` VALUES (2, 1002, '333', 11, 11.00, '2021-09-28 14:30:27');
INSERT INTO `detail` VALUES (3, 1002, '2311', 11, 352.00, '2021-09-28 14:30:42');
INSERT INTO `detail` VALUES (2, 1003, '44', 111, 22200.00, '2021-09-28 14:32:49');
INSERT INTO `detail` VALUES (2, 1002, '333', 11, 11.00, '2021-09-28 14:35:22');
INSERT INTO `detail` VALUES (4, 1004, '2311', 11, 352.00, '2021-09-28 14:37:29');
INSERT INTO `detail` VALUES (6, 1003, '333', 11, 11.00, '2021-09-28 14:37:57');
INSERT INTO `detail` VALUES (2, 1003, '2311', 11, 352.00, '2021-09-28 15:45:46');
INSERT INTO `detail` VALUES (7, 1000, 'STDYW-01', 1, 200.00, '2021-09-28 15:48:56');
INSERT INTO `detail` VALUES (7, 1000, 'hdh1254', 1, 50.00, '2021-09-28 15:49:02');
INSERT INTO `detail` VALUES (4, 1003, '44', 11, 2200.00, '2021-09-28 16:03:14');
INSERT INTO `detail` VALUES (3, 1004, 'CYN-0011', 11, 330.00, '2021-09-28 16:08:17');
INSERT INTO `detail` VALUES (5, 1005, 'YNBY-001', 11, 330.00, '2021-09-28 16:11:44');
INSERT INTO `detail` VALUES (2, 1002, '333', 123, 123.00, '2021-09-28 16:12:35');
INSERT INTO `detail` VALUES (4, 1002, '44', 12, 2400.00, '2021-09-28 16:13:29');
INSERT INTO `detail` VALUES (4, 1006, 'No3', 11111, 1368024234198632.00, '2021-09-28 16:14:58');
INSERT INTO `detail` VALUES (4, 1006, 'No3', 3, 369370236936.00, '2021-09-28 16:15:12');
INSERT INTO `detail` VALUES (3, 1000, '333', 1, 1.00, '2021-09-28 16:15:38');
INSERT INTO `detail` VALUES (4, 1006, '8888888', 111, 110999999999889.00, '2021-09-29 10:43:19');
INSERT INTO `detail` VALUES (5, 1002, 'AAAA-1', 1, 1111111111.00, '2021-09-29 10:43:29');
INSERT INTO `detail` VALUES (5, 1005, '9999', 123, 12177.00, '2021-09-29 11:01:59');
INSERT INTO `detail` VALUES (2, 1002, '333', 123, 123.00, '2021-09-29 12:53:53');
INSERT INTO `detail` VALUES (1, 1004, '44', 11, 2200.00, '2021-09-29 12:54:10');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `card_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `department` int(1) NULL DEFAULT NULL COMMENT '科室',
  `education` int(1) NULL DEFAULT NULL COMMENT '学历',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, '华佗', '123292934984', '188294587132', 0, 50, '2019-08-02 14:20:28', 'huatuo@163.com', 1, 3, '妙手回春');
INSERT INTO `doctor` VALUES (2, '扁鹊', '166284884717', '102945732423', 0, 60, '2019-08-02 14:21:12', 'bianque@163.com', 2, 3, '赛华佗');
INSERT INTO `doctor` VALUES (3, '喜来乐', '194884575757', '1993948811', 0, 40, '2019-08-02 14:21:48', 'xilaile@163.com', 3, 2, '小扁鹊');
INSERT INTO `doctor` VALUES (4, '李时珍', '1948845757572', '19939481111', 0, 30, '2019-08-02 14:21:48', 'lishizhen@163.com', 5, 3, '尝百草');
INSERT INTO `doctor` VALUES (5, '端木蓉', '1884129898484822', '18347466133', 1, 18, '2019-08-02 14:21:48', 'duanmurong@163.com', 2, 3, '三不救');
INSERT INTO `doctor` VALUES (6, '杨永信', '192993848818334', '102945732423', 1, 48, '2019-08-02 14:57:50', 'xin@163.com', 1, 2, '专门治疗网瘾');
INSERT INTO `doctor` VALUES (7, '小甜甜', '103848577222', '102945732423', 1, 31, '1900-01-10 00:00:00', 'xilaile@163.com', 5, 2, '祖传治牙');
INSERT INTO `doctor` VALUES (8, '邯郸名医', '1828502099484823', '19993332256', 1, 80, '2019-10-20 15:31:58', 'sun_5988@163.com', 3, 3, '很厉害');

-- ----------------------------
-- Table structure for hospitalization
-- ----------------------------
DROP TABLE IF EXISTS `hospitalization`;
CREATE TABLE `hospitalization`  (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `rno` int(11) NULL DEFAULT NULL COMMENT '挂号信息外键',
  `bed_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '床号',
  `deposit` double NULL DEFAULT NULL COMMENT '押金',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病情描述',
  `in_date` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入院时间',
  `protect` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护理',
  PRIMARY KEY (`hid`) USING BTREE,
  INDEX `rno`(`rno`) USING BTREE,
  CONSTRAINT `hospitalization_ibfk_1` FOREIGN KEY (`rno`) REFERENCES `register` (`rno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hospitalization
-- ----------------------------
INSERT INTO `hospitalization` VALUES (1, 1001, '10', 200000, '----萌萌的', '2019-08-07 11:21:32', NULL);
INSERT INTO `hospitalization` VALUES (2, 1002, '9', 100022, '桐桐的', '2019-08-07 11:28:33', NULL);
INSERT INTO `hospitalization` VALUES (3, 1004, '666', 50, '疑似死亡', '2019-08-07 16:12:07', NULL);
INSERT INTO `hospitalization` VALUES (4, 1005, '90', 240718, '无病非要住院', '2019-08-08 14:11:38', NULL);
INSERT INTO `hospitalization` VALUES (5, 1006, '80', 20000, '严重掉头发', '2019-10-20 15:36:32', NULL);

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `mid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `in_price` double NULL DEFAULT NULL COMMENT '进价',
  `sal_price` double NULL DEFAULT NULL COMMENT '售价',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '药品类型 0处方1中药2西药',
  `descs` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简单描述',
  `quality_date` int(11) NULL DEFAULT NULL COMMENT '保质期',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细描述',
  `produce_firm` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂商',
  `readme` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服用说明',
  `count_all` int(11) NULL DEFAULT NULL COMMENT '总的进货量',
  `count_surplus` int(11) NULL DEFAULT NULL COMMENT '剩余量',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  UNIQUE INDEX `mid`(`mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('11111111111111', 'f9d9bed7-d686-4703-92dc-6fb76c377b8e.jpg', 11, 50, '彩虹胶囊', 2, '可以变成彩虹', 36, '2222222', '', '服用几天后生效', NULL, NULL, '');
INSERT INTO `medicine` VALUES ('2132', 'd5dbe243-c318-4691-a362-7775107e0ee1.jpg', 56, 100, '万通筋骨贴', 1, '==', 200, '==', '==', '==', NULL, NULL, '==');
INSERT INTO `medicine` VALUES ('2311', 'd710f815-bfd0-4192-b773-279ab06614e7.jpg', 23, 32, '盘尼西林', 2, '起死回生', 36, '之各种病', '宛西制药', '口服', NULL, NULL, '随便吃');
INSERT INTO `medicine` VALUES ('333', '048ad923-2ba6-4570-bf8b-02110a43a82a.jpg', 1, 1, '123', 1, '1', 36, '1', '1', '1', NULL, NULL, '1');
INSERT INTO `medicine` VALUES ('44', '03910cc8-b9ef-4d62-850a-abd647686533.jpg', 20, 200, '舒血宁注射液', 2, '专注血液病', 36, '专治血液病，立杆见效', '河北大药厂', '口服', NULL, NULL, '详见说明书');
INSERT INTO `medicine` VALUES ('8888888', '04843d99-c317-4291-8dbc-a60300c3fc71.jpg', 1, 999999999999, '脑残片', 0, '脑残专治', 36, '对脑残有奇效', '天知道', '意念服用', NULL, NULL, '');
INSERT INTO `medicine` VALUES ('9999', '43b89952-28a2-4944-ab8d-9ddb7d1d8d80.png', 9.9, 99, '乌鸡凤凰丸', 2, '好吃又大补', 1, '乌鸡变凤凰', '花果山', '当豆子吃', NULL, NULL, '就是棒');
INSERT INTO `medicine` VALUES ('999感冒灵', 'd8816b11-1ccf-40aa-bfe1-2fa8f91681fc.jpg', 5, 20, '感冒灵·', 0, '治疗感冒', 36, '治疗感冒', '1', '1', NULL, NULL, '1');
INSERT INTO `medicine` VALUES ('AAAA-1', '91c26b47-407d-467e-aae6-6f1eb634e8c1.jpg', 11.1111, 1111111111, '多情直男三件套', 0, '若为自由故,两者皆可抛~~~~~', 36, '有了三件套,解决你烦恼.', '大安帝国/.', '想咋吃咋吃.', NULL, NULL, '吃完贼拉拉带劲,干就完咧');
INSERT INTO `medicine` VALUES ('BTT', 'a8b090b2-49f3-4213-afd5-3f71e97345fd.jpg', 10, 20, '宝塔糖', 0, '专职蛔虫', 36, '专职蛔虫', '=====', '不能多吃！更不能随便吃！', NULL, NULL, '=======');
INSERT INTO `medicine` VALUES ('cat-001', '0bab6ddb-7c02-4447-8d6e-619b1f655ca0.jpeg', 100, 101, '猫薄荷', 0, '救猫', 36, '==', '中公猫厂', '吸服', NULL, NULL, '==');
INSERT INTO `medicine` VALUES ('changde-1100', 'afdddd94-7e80-48a3-8b35-f8ea939186ed.jpg', 12, 11, '马来酸非尼拉敏盐酸萘甲唑啉滴眼液', 0, '非常好', 36, '不错', '不', '==', NULL, NULL, '==');
INSERT INTO `medicine` VALUES ('CYN-0011', '173823e3-28c5-400d-a17a-a7ebcdb3ad14.jpg', 25, 30, '肠炎宁', 2, '治疗胃病', 36, '非常实用', '医药公司', '一日3次，每次一片', NULL, NULL, '-----');
INSERT INTO `medicine` VALUES ('DCY-001', '80325b28-b070-4653-82d2-90932cf433e8.jpg', 1, 10, '打虫药', 0, '打虫药', 36, '甜滋滋', '打虫药', '打虫药', NULL, NULL, '打虫药');
INSERT INTO `medicine` VALUES ('DJ-74110', '3a6dc695-65b1-4f14-8da9-c942cc9f98e4.jpg', 1000, 100000, '精神病', 2, '治理精神病', 36, '专治精神病', '未知', '未知', NULL, NULL, '谁用谁知道');
INSERT INTO `medicine` VALUES ('DL-001', '1c180f77-b0e1-495a-991f-e4da13033f59.jpg', 100, 500, '大力出奇迹', 2, '强悍', 11, '大力哥最爱', '大力公司', '直接吞服', NULL, 88, '===');
INSERT INTO `medicine` VALUES ('GMLKL', '938abb13-2c13-4d33-8767-f70717b1708d.jpg', 100, 10, '感冒灵颗粒', 0, '治感冒', 1, '治感冒', '小儿', '1天一盒', NULL, NULL, '包治百病');
INSERT INTO `medicine` VALUES ('H-2345', '1d406b70-85d5-4460-b1b8-2d31c6ce8fc2.jpg', 15, 35, '999感冒灵颗粒', 2, '感冒必备', 36, '感冒必备', '13245678', '口服', NULL, NULL, '####');
INSERT INTO `medicine` VALUES ('hdh1254', '39c7d56c-f7a3-4251-95f7-dc6bd49c48e5.jpg', 30, 50, '鹤顶红', 0, '好用啊', 36, '一点就好用', '奸商', '口服', NULL, NULL, '别不小心自己喝了');
INSERT INTO `medicine` VALUES ('HH-001', '25f703a4-d733-41e0-b53f-d679e9bd69a0.jpg', 100, 10000, '后悔药', 0, '后悔药', 36, '后悔药', '后悔药', '沸水送服', NULL, NULL, '后悔药');
INSERT INTO `medicine` VALUES ('HHY-001', 'b188792d-9787-4d3b-be52-f83e63ca7407.jpg', 25, 100, '红花油', 1, '包治百病！', 36, '好', '好', '直接喝！', NULL, NULL, '好');
INSERT INTO `medicine` VALUES ('HZ-16326', '02b7b77d-d3d1-4c58-9e83-fb26ef6e2da2.jpg', 2, 5, '三黄片', 0, '清热解毒', 36, '具有清热解毒，泻火通便功效。主治三焦热盛，目赤肿痛，口鼻生疮，咽喉肿痛，心烦口渴。', '亚宝药业', '1日2次', NULL, NULL, '无');
INSERT INTO `medicine` VALUES ('HZ-199384', '5a2a44b3-5e97-4aa1-956b-b4bc19fdba01.jpg', 6, 16, '藿香正气水', 1, '治疗中暑', 400, '==', '--', '---', NULL, NULL, '---');
INSERT INTO `medicine` VALUES ('jbsw', 'aa2b3702-94a8-44e9-9a0e-d600fd46bb4b.jpg', 999, 99990, '九步蛇丸', 1, '没有描述', 999, '没有描述', '没有厂商', '随便服用', NULL, NULL, '没有备注');
INSERT INTO `medicine` VALUES ('jj_002', 'cc9e5aa4-febb-404e-a834-aed4f5917293.jpg', 9.9, 19, '九九感冒灵', 0, '治感冒', 36, '疗效', '九九制药', '本品解热镇痛。用于感冒引起的头痛，发热等', NULL, NULL, '本品为浅棕色至深棕色的颗粒，味甜、微苦。每盒含9包，每包袋装10g。解热镇痛功效，用于因感冒引起的头痛，发热，鼻塞，流涕，咽痛等症状。');
INSERT INTO `medicine` VALUES ('ML-001', '25ad4300-8c77-420a-81d0-b0dd400f840e.jpg', 80000, 100000, '爱的魔力药水', 0, '转圈圈', 100, '爱的魔力转圈圈', '爱情', '口服', NULL, NULL, '转圈圈');
INSERT INTO `medicine` VALUES ('No.00001', 'f8658818-341f-4a02-8862-eceb9e67efe5.jpg', 10000, 10000, '还魂丹', 0, '一颗极乐,两颗升天', 1, '灵隐寺', '灵隐寺', '一口吞服', NULL, NULL, '');
INSERT INTO `medicine` VALUES ('No1', 'f11edb5f-a3be-4477-9a66-cf8400062a3e.jpg', 10000, 10000000, '天山雪莲', 1, '老好呲了', 36, '--', '-', '-', NULL, NULL, '-');
INSERT INTO `medicine` VALUES ('No2', 'b25dc979-8b7a-4469-83e6-eccee5b96c1c.jpg', 10002020, 120301230120, 'nice棒棒鼓励片', 0, '老好呲了', 36, '-', '-', '-', NULL, NULL, '-');
INSERT INTO `medicine` VALUES ('No3', '6bde8c74-1736-4108-92ce-a72f9b768d30.jpg', 123123, 123123412312, '肛泰', 0, '-', 36, '-', '-', '-', NULL, NULL, '-');
INSERT INTO `medicine` VALUES ('pc9988', 'f66331a3-bf95-4e35-9d26-d300a8e8b3d5.jpg', 15, 150, '万通筋骨片', 0, '一吃就好', 36, '谁用谁知道', '三九制药', '别忘了吃', NULL, NULL, '忌酒');
INSERT INTO `medicine` VALUES ('QXTYS-110', 'a9c41431-78a0-4146-9eab-25d11695b003.jpg', 10000, 99999, '强效太阳水', 1, '喝一瓶想两瓶', 36, '牛逼', '盛大或者？？？', '外服内服', NULL, NULL, '666');
INSERT INTO `medicine` VALUES ('SKKFF-1-23213', '3bdb01fe-76dd-4a64-a2fa-cb7ea662a79e.jpg', 20, 40, '复方炔诺酮糖衣片', 2, '女人掌握核心科技', 36, '避免意外怀孕', '不知道', '口服', NULL, NULL, '自己理解');
INSERT INTO `medicine` VALUES ('SS-001', '4661e4bd-f27e-4a0a-959a-0d8ff4456a4a.jpg', 111, 10000, '烧烧果实', 0, '烧烧果实', 36, '烧烧果实', '烧烧果实', '烧烧果实', NULL, NULL, '烧烧果实');
INSERT INTO `medicine` VALUES ('STDYW-01', '61173dbe-8214-4c2b-8dc5-91776b994cc6.jpeg', 20, 200, '伸腿瞪眼丸', 1, '很好吃', 36, '吃完就伸腿', '伸腿公司', '生吞', NULL, NULL, '嘎嘎嘎');
INSERT INTO `medicine` VALUES ('SXRJS-001', '790c5e35-78c9-44bb-aeb3-9d7d446304b5.jpg', 34, 430, '黑玉断骨膏', 0, '又香又好吃', 36, '香的一批，又好看又好吃', '孙伟志牌烤肉店', '香的一批，又好看又好吃', NULL, NULL, '孙伟志牌烤肉香的一批，又好看又好吃');
INSERT INTO `medicine` VALUES ('WTJGT-123', '07aa2375-32b9-404f-bbe6-8157745cf340.jpg', 45, 100, '万通胫骨贴', 1, '贴上暖暖的', 36, '直接贴', 'baidu', '直接贴', NULL, NULL, '效果666');
INSERT INTO `medicine` VALUES ('YKN-008', 'c9bd59d3-f0ce-49f1-a1d0-97fced715a68.png', 88, 188, '炎可宁片', 2, '就是牛!', 12, '一粒就见效!', '吉尔吉药业', '使劲吃!', NULL, NULL, '------');
INSERT INTO `medicine` VALUES ('YNBY-001', '559ab16f-82c5-4a1e-8b8e-1f73e0045aea.jpg', 10, 30, '云南白药', 2, '神药', 36, '具特异性香气，味略感清凉，并有麻舌感。', '云南', '口服', NULL, NULL, '。。。');
INSERT INTO `medicine` VALUES ('YSG--110', 'b0af939f-966c-47d4-b566-cafd844733a7.gif', 20, 30000, '药水哥', 2, '解心宽', 36, '解懒解心宽', '--', '==', NULL, NULL, '===');
INSERT INTO `medicine` VALUES ('YYHHS', '02c1c87e-cfcc-4398-ad2b-4a85e28bd7c4.jpg', 250, 500, '阴阳合欢散', 1, '很嗨皮', 50, '嗨皮的很', '自制', '直接服用', NULL, NULL, '嗨到飞起');
INSERT INTO `medicine` VALUES ('ZH-0000001', '93e5753e-6f92-43f0-aa81-c77142857181.jpg', 10000, 200000, '绮罗郁金香', 1, '规避任何毒物', 33333, '不知道', '斗罗大陆', '携带身边', NULL, NULL, '不要食用');
INSERT INTO `medicine` VALUES ('zzw-001', 'd1ce6850-229e-4995-b96b-e5991989a0e2.jpg', 2, 20000, '智障丸', 2, '治智障神药', 36, '一次一片，立刻见效', '智障厂', '==', NULL, NULL, '==');

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `rno` int(20) NOT NULL AUTO_INCREMENT COMMENT '病历号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_card` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `si_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社保号',
  `register_money` double NULL DEFAULT NULL COMMENT '挂号费用',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `is_pay` tinyint(4) NULL DEFAULT NULL COMMENT '是否自费',
  `sex` tinyint(4) NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `job` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `consultation` tinyint(4) NULL DEFAULT NULL COMMENT '初复诊',
  `department` tinyint(4) NULL DEFAULT NULL COMMENT '科室',
  `did` int(11) NULL DEFAULT NULL COMMENT '医生外键',
  `status` int(11) NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `register_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rno`) USING BTREE,
  INDEX `did`(`did`) USING BTREE,
  CONSTRAINT `register_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1007 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES (1000, '郭达·斯坦森', '19572773743323', '1287387', 5000, '102945732423', 0, 0, 50, '演员', 1, 2, 4, 3, '=====', '2019-08-06 10:50:27');
INSERT INTO `register` VALUES (1001, '萌萌哒', '19572773743323', '1287387', 8000, '102945732423', 0, 1, 18, '演员123', 1, 2, 6, 3, '====', '2019-08-06 14:17:25');
INSERT INTO `register` VALUES (1002, '桐桐', '19572773743323', '1287387', 1, '102945732423', 0, 1, 48, '杠精', 0, 4, 3, 3, '===', '2019-08-06 14:18:08');
INSERT INTO `register` VALUES (1003, '静静', '19572773743323', '1287387', 11, '102945732423', 0, 1, 50, '演员', 1, 3, 2, 3, '123', '2019-08-06 14:18:37');
INSERT INTO `register` VALUES (1004, '贞子', '19572773743323', '1287387', 5000, '102945732423', 0, 1, 18, '女鬼', 0, 2, 6, 3, '=====', '2019-08-07 16:11:14');
INSERT INTO `register` VALUES (1005, '牛魔王', '19572773743323', '11000', 500, '102945732423', 0, 0, 50, '积雷山山大王', 1, 5, 7, 3, '别有用心', '2019-08-08 14:10:06');
INSERT INTO `register` VALUES (1006, '孙大圣', '183331222', '112255555', 50, '100000000', 0, 0, 22, '程序员', 0, 3, 8, 3, '掉头发', '2019-10-20 15:34:08');

-- ----------------------------
-- Table structure for register_medicine
-- ----------------------------
DROP TABLE IF EXISTS `register_medicine`;
CREATE TABLE `register_medicine`  (
  `mid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `num` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of register_medicine
-- ----------------------------

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `text` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `href` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES (6, '资源管理', 'res?mark=findResourcesList');
INSERT INTO `resources` VALUES (7, '门诊医生管理', 'doctor?mark=findDoctorList');
INSERT INTO `resources` VALUES (10, '角色管理', 'role?mark=findRoleList');
INSERT INTO `resources` VALUES (11, '用户管理', 'users?mark=findUserList');
INSERT INTO `resources` VALUES (12, '药品管理', 'medicine?mark=findMedicineListFY');
INSERT INTO `resources` VALUES (13, '挂号信息管理', 'register?mark=findRegisterList');
INSERT INTO `resources` VALUES (14, '检查收费项管理', 'charge?mark=findChargeList');
INSERT INTO `resources` VALUES (15, '住院办理', 'hos?mark=findHospitalizationList');
INSERT INTO `resources` VALUES (16, '检查收费项目登记', 'crs?mark=findChargeList');
INSERT INTO `resources` VALUES (17, '住院结算', 'hac?mark=findHospitalizationAccountsList');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  `rolename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (5, 1, '管理员(系统维护)');
INSERT INTO `role` VALUES (8, 1, '院长');
INSERT INTO `role` VALUES (9, 1, '药师');
INSERT INTO `role` VALUES (10, 1, '财务');
INSERT INTO `role` VALUES (11, 1, '主治医师');

-- ----------------------------
-- Table structure for role_resources
-- ----------------------------
DROP TABLE IF EXISTS `role_resources`;
CREATE TABLE `role_resources`  (
  `role_id` int(11) NULL DEFAULT NULL,
  `res_id` int(11) NULL DEFAULT NULL,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `res_id`(`res_id`) USING BTREE,
  CONSTRAINT `role_resources_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_resources_ibfk_2` FOREIGN KEY (`res_id`) REFERENCES `resources` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_resources
-- ----------------------------
INSERT INTO `role_resources` VALUES (9, 12);
INSERT INTO `role_resources` VALUES (8, 7);
INSERT INTO `role_resources` VALUES (11, 12);
INSERT INTO `role_resources` VALUES (11, 13);
INSERT INTO `role_resources` VALUES (11, 14);
INSERT INTO `role_resources` VALUES (11, 15);
INSERT INTO `role_resources` VALUES (11, 16);
INSERT INTO `role_resources` VALUES (5, 6);
INSERT INTO `role_resources` VALUES (5, 7);
INSERT INTO `role_resources` VALUES (5, 10);
INSERT INTO `role_resources` VALUES (5, 11);
INSERT INTO `role_resources` VALUES (5, 12);
INSERT INTO `role_resources` VALUES (5, 13);
INSERT INTO `role_resources` VALUES (5, 14);
INSERT INTO `role_resources` VALUES (5, 15);
INSERT INTO `role_resources` VALUES (5, 16);
INSERT INTO `role_resources` VALUES (5, 17);
INSERT INTO `role_resources` VALUES (10, 13);
INSERT INTO `role_resources` VALUES (10, 14);
INSERT INTO `role_resources` VALUES (10, 15);
INSERT INTO `role_resources` VALUES (10, 16);
INSERT INTO `role_resources` VALUES (10, 17);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifytime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  `roleid` int(11) NULL DEFAULT NULL,
  `face_id` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `face_feature` blob NULL,
  PRIMARY KEY (`userid`) USING BTREE,
  INDEX `roleid`(`roleid`) USING BTREE,
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '刘升朝', '12@131.com', 0, '123', '123', '2019-08-07 11:46:51', 11, NULL, NULL);
INSERT INTO `users` VALUES (6, '孙浩楠', 'nan@163.com', 0, 'sunwz', '123456', '2019-08-07 11:43:25', 5, NULL, NULL);
INSERT INTO `users` VALUES (7, '牛院长', 'xin@163.com', 0, 'niu', '123456', '2019-08-07 11:45:45', 8, NULL, NULL);
INSERT INTO `users` VALUES (8, '琪琪', 'bianque@163.com', 0, 'qiqi', '123456', '2019-08-07 11:46:05', 9, NULL, NULL);
INSERT INTO `users` VALUES (9, '萌萌哒', 'huatuo@163.com', 0, 'mm', '123456', '2019-08-07 11:46:29', 10, NULL, NULL);
INSERT INTO `users` VALUES (10, '程程', 'xin@163.com', 0, 'cc', '123456', '2019-08-07 11:46:51', 11, NULL, NULL);
INSERT INTO `users` VALUES (11, '刘升朝', NULL, NULL, NULL, NULL, NULL, NULL, 'zl582ab7zr', 0x0080FA440000A0411B8044BD8955A73DA0E3D03B7AC84F3D91D2453DF09B75BB87FE53BCD8460DBDBE26313CBE5BCFBD218398BD355FE73C022E75BC9A9EBEBD3C1F42BE0E1029BDBF970FBD2EA8F0BD4543C73B5589CC3DEAE14B3D96D6F9BC99C0553CCC55CD3D6716D7BDA5DEA83C0FEAA3BBE1B078BD761116BECC0A243D8F33273E8BB0A43BD4D86A380FC1D7BC452EA0BD5C29CCBDC72E433DBE51403CD370133EA63C7CBB9BFD413D3EB74E3C0C7A74BDA02363BCFEDF7DBDD3E001BEEA14C5BBE7E665BB160283BD6B44673DB6F93DBD91D0363D56A9A33BD76737BE6C716BBD026506BD29A646BD6917B23D8170E1BC3706693C2ECA803DDC41AB3DC0976B3C5A8A11BC64074E3D0AF1F7BC7ED113BCE038B93DD97480B9FF0353BB3C95A13C6EE6ACBCEC5F7A3D87567FBDB0CA3EBD9691B23CF9DE373D6C8581BD915A5F3C2F6BBB3CFCB8E33C97BC693DABFCA0BD077A793DC96140BEF93A043EB67373BD8439023E50FF763D1A2315BD7E30B73D7E14B23CCCB6013CB5F28A3CF04ECD3D9C5B173DDFFD06BDE93244BC6FF792BBF7D18DBDFF99BFBDC7D797BDD038E2BC8E4CB2BD85DFB6BDF90D78BC69A52B3CB256A43D6A915ABD393DE3BDA64F00BEFB99CF3D9ADC1F3D7E8E003D20CC6CBA7BBB7FBC596BE2BBD433AF3D6DE29A3DEFFA803C0964B53DFFCC083CE5550D3DCF549DBC9992BC3D74B1C03D9177E8BB6217B23D828F4C3DC637173EDC1497BCB9E8243C4C8FB73C8A890BBCE4D110BD002A62BD64AA793C00E0D43D190539BD058DB4BC5A13803DD68A7ABD41A7F13B77FF16BDB2CD6C3C6F4C3EBDFCA831BDD6DD1B3DCC4893BDBBC3F8BDC7F9FBBACC3A7E3B390F98BD3CB0BCBD71C08BBDEEA878BD2236493D19D14E3CF6EEB2BD495145BC5BA9E9BC39DE03BC51203ABC2203FA3DE13B433CCC90AABD3C6EC3BCE1FBB1BD5F12D83DEC04DD3D2B49523CF922D0BC8AE6983C4433EB3C5689003BDC16383D6FD507BEFAE5B03DB970F53CB193393DA46FEA3DB7E5B53A64DB663DE95D20BE57DBE53D75DE87BD78F497BDD9E1993CE1A4913C8167233DDF02343DEFEB58BDFA6D353DC228CD3B02173BBD88C082BD16BE0ABCD2D219BD4EDA1DBDC139B7BBEC6BBB3C41C9ADBDE39307BD3079D5BCBB2C31BC046C1F3D57653FBDDF95C6BCC037FA3D5EB3D03CB9A93BBD4045D73CC8DD0ABD37243EBD5AD0AE3D0A9F6ABD19392C3D4E04CE3DE2D988BCEEC204BCF42B903DD0930FBA8F01563DCE9C5EBDF58A06BE729CFDBDABA0433D842D823DD054173D1218103D068E403D245828BCA9085EBD3E240EBD9BEDA93D7BD3683D36AB003D9EF3DF3D5BB5BA3CA9A923BC74F15B3D53DC0D3E6FDB523D326613BE9ADDFE3C057B4A3D3486FBBDD541D13D8ED8203C6B84AD3CEF89873D471CBFBD168B173CDB3DB1BD8431043EEA8CB3BD);

SET FOREIGN_KEY_CHECKS = 1;
```
