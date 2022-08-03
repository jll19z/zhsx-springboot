/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : wxapp

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 03/08/2022 18:47:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for index_banner
-- ----------------------------
DROP TABLE IF EXISTS `index_banner`;
CREATE TABLE `index_banner`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `banner_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图',
  `banner_rank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示优先级',
  `banner_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息',
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_banner
-- ----------------------------
INSERT INTO `index_banner` VALUES (1, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/m1.png', '1', NULL, '0');
INSERT INTO `index_banner` VALUES (2, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/m2.png', '1', NULL, '0');
INSERT INTO `index_banner` VALUES (3, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/m3.png', '1', NULL, '0');
INSERT INTO `index_banner` VALUES (5, 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/8.jpg', '1', '·', '1');
INSERT INTO `index_banner` VALUES (6, 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/d35e53e2cfa2ed0c9f0632964a4814bc.jpg', '1', '1', '1');
INSERT INTO `index_banner` VALUES (7, 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/20210604233136_5419a.jpg', '1', '11', '1');
INSERT INTO `index_banner` VALUES (8, 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/419ccbfc1e178a82104336e7e103738da877e8b1 (2).jpg', '1', '111', '1');
INSERT INTO `index_banner` VALUES (9, 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/d35e53e2cfa2ed0c9f0632964a4814bc.jpg', '1', '22', '1');
INSERT INTO `index_banner` VALUES (10, 'string', 'string', 'string', '1');
INSERT INTO `index_banner` VALUES (11, 'string', 'string', 'string', 'string');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `product_id` int NOT NULL COMMENT '产品id',
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int NOT NULL COMMENT '数量',
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `product_img` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小图',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `idx_order_id`(`order_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (12, 'D1655988520320682933', 1, '雪王大圣代(黑糖珍珠)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-06-23 20:48:42', '2022-06-23 20:48:42');
INSERT INTO `order_detail` VALUES (13, 'D1655988520320682933', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-23 20:48:42', '2022-06-23 20:48:42');
INSERT INTO `order_detail` VALUES (14, 'D1655988520320682933', 3, '雪王大圣代(草莓)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-06-23 20:48:42', '2022-06-23 20:48:42');
INSERT INTO `order_detail` VALUES (15, 'D1655988656169929844', 10, '黄桃燕麦酸奶', 13.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/htymsn.png', '2022-06-23 20:50:57', '2022-06-23 20:50:57');
INSERT INTO `order_detail` VALUES (16, 'D1655988656169929844', 9, '柠檬益菌多', 9.99, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/nmyjd.png', '2022-06-23 20:50:57', '2022-06-23 20:50:57');
INSERT INTO `order_detail` VALUES (17, 'D1655988863040982088', 1, '雪王大圣代(黑糖珍珠)', 6.00, 2, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-06-23 20:54:24', '2022-06-23 20:54:24');
INSERT INTO `order_detail` VALUES (18, 'D1655989204779111523', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-23 21:00:07', '2022-06-23 21:00:07');
INSERT INTO `order_detail` VALUES (19, 'D1655989204779111523', 3, '雪王大圣代(草莓)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-06-23 21:00:07', '2022-06-23 21:00:07');
INSERT INTO `order_detail` VALUES (20, 'D1655989282050252583', 2, '雪王大圣代(芒果)', 6.00, 2, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-23 21:01:24', '2022-06-23 21:01:24');
INSERT INTO `order_detail` VALUES (21, 'D1655989428469606439', 1, '雪王大圣代(黑糖珍珠)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-06-23 21:03:50', '2022-06-23 21:03:50');
INSERT INTO `order_detail` VALUES (22, 'D1655989428469606439', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-23 21:03:50', '2022-06-23 21:03:50');
INSERT INTO `order_detail` VALUES (23, 'D1655989485793080249', 1, '雪王大圣代(黑糖珍珠)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-06-23 21:04:46', '2022-06-23 21:04:46');
INSERT INTO `order_detail` VALUES (24, 'D1655989485793080249', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-23 21:04:46', '2022-06-23 21:04:46');
INSERT INTO `order_detail` VALUES (25, 'D1655989493545635323', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-23 21:04:55', '2022-06-23 21:04:55');
INSERT INTO `order_detail` VALUES (26, 'D1655989493545635323', 3, '雪王大圣代(草莓)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-06-23 21:04:55', '2022-06-23 21:04:55');
INSERT INTO `order_detail` VALUES (28, 'D1656053530051070550', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-24 14:52:11', '2022-06-24 14:52:11');
INSERT INTO `order_detail` VALUES (29, 'D1656053583287865994', 3, '雪王大圣代(草莓)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-06-24 14:53:04', '2022-06-24 14:53:04');
INSERT INTO `order_detail` VALUES (30, 'D1656053840705819474', 3, '雪王大圣代(草莓)', 6.00, 2, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-06-24 14:58:00', '2022-06-24 14:58:00');
INSERT INTO `order_detail` VALUES (31, 'D1656053946325744343', 4, '雪王大圣代(奥利奥)', 6.00, 2, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(奥利奥).png', '2022-06-24 14:59:09', '2022-06-24 14:59:09');
INSERT INTO `order_detail` VALUES (32, 'D1656053946325744343', 1, '雪王大圣代(黑糖珍珠)', 6.00, 2, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-06-24 14:59:09', '2022-06-24 14:59:09');
INSERT INTO `order_detail` VALUES (33, 'D1656055511875623175', 1, '雪王大圣代(黑糖珍珠)', 6.00, 6, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-06-24 15:25:20', '2022-06-24 15:25:20');
INSERT INTO `order_detail` VALUES (34, 'D1656055536338223539', 1, '雪王大圣代(黑糖珍珠)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-06-24 15:25:37', '2022-06-24 15:25:37');
INSERT INTO `order_detail` VALUES (35, 'D1656055536338223539', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-06-24 15:25:37', '2022-06-24 15:25:37');
INSERT INTO `order_detail` VALUES (36, 'D1656055536338223539', 3, '雪王大圣代(草莓)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-06-24 15:25:37', '2022-06-24 15:25:37');
INSERT INTO `order_detail` VALUES (37, 'D1656055536338223539', 4, '雪王大圣代(奥利奥)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(奥利奥).png', '2022-06-24 15:25:37', '2022-06-24 15:25:37');
INSERT INTO `order_detail` VALUES (38, 'D1656055536338223539', 5, '冰鲜柠檬水', 5.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/bxnms.png', '2022-06-24 15:25:37', '2022-06-24 15:25:37');
INSERT INTO `order_detail` VALUES (39, 'D1656055536338223539', 6, '森林玫果', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/slmg.png', '2022-06-24 15:25:37', '2022-06-24 15:25:37');
INSERT INTO `order_detail` VALUES (40, 'D1657341164382528679', 1, '雪王大圣代(黑糖珍珠)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-07-09 12:39:59', '2022-07-09 12:39:59');
INSERT INTO `order_detail` VALUES (41, 'D1657341164382528679', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-07-09 12:39:59', '2022-07-09 12:39:59');
INSERT INTO `order_detail` VALUES (42, 'D1657347348181906461', 1, '雪王大圣代(黑糖珍珠)', 6.00, 3, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-07-09 14:16:13', '2022-07-09 14:16:13');
INSERT INTO `order_detail` VALUES (43, 'D1657348677325917379', 30, '拉阿拉蕾', 1111.00, 2, '0', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/黑珍珠大圣代.png', '2022-07-09 14:38:33', '2022-07-09 14:38:33');
INSERT INTO `order_detail` VALUES (44, 'D16584754315197547210', 6, '森林玫果', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/slmg.png', '2022-07-22 15:37:12', '2022-07-22 15:37:12');
INSERT INTO `order_detail` VALUES (45, 'D1658479886091953665', 2, '雪王大圣代(芒果)', 6.00, 2, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-07-22 16:51:26', '2022-07-22 16:51:26');
INSERT INTO `order_detail` VALUES (46, 'D1658480256504223766', 3, '雪王大圣代(草莓)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-07-22 16:57:36', '2022-07-22 16:57:36');
INSERT INTO `order_detail` VALUES (47, 'D1658480256504223766', 1, '雪王大圣代(黑糖珍珠)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', '2022-07-22 16:57:36', '2022-07-22 16:57:36');
INSERT INTO `order_detail` VALUES (48, 'D1658480256504223766', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-07-22 16:57:36', '2022-07-22 16:57:36');
INSERT INTO `order_detail` VALUES (49, 'D1658480256504223766', 4, '雪王大圣代(奥利奥)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(奥利奥).png', '2022-07-22 16:57:37', '2022-07-22 16:57:37');
INSERT INTO `order_detail` VALUES (50, 'D1658480450417465484', 2, '雪王大圣代(芒果)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', '2022-07-22 17:00:50', '2022-07-22 17:00:50');
INSERT INTO `order_detail` VALUES (51, 'D1658480450417465484', 3, '雪王大圣代(草莓)', 6.00, 1, '0', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', '2022-07-22 17:00:50', '2022-07-22 17:00:50');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `order_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `buyer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家微信openid',
  `order_buynum` int NULL DEFAULT NULL,
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint NOT NULL DEFAULT 0 COMMENT '订单状态, 默认为新下单',
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志',
  `order_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `pay_status` tinyint NOT NULL DEFAULT 0 COMMENT '支付状态, 默认未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `idx_buyer_openid`(`buyer_openid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES (23, 2, 'D1655988520320682933', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 3, 15.84, 1, '0', NULL, 1, '2022-06-23 20:48:41', '2022-07-25 15:21:27');
INSERT INTO `order_master` VALUES (26, 2, 'D1655989204779111523', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 1, '0', NULL, 1, '2022-06-23 21:00:07', '2022-07-25 15:23:12');
INSERT INTO `order_master` VALUES (27, 2, 'D1655989282050252583', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 1, '0', NULL, 1, '2022-06-23 21:01:24', '2022-07-25 15:21:36');
INSERT INTO `order_master` VALUES (28, 2, 'D1655989428469606439', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 0, '0', NULL, 1, '2022-06-23 21:03:50', '2022-06-24 16:50:49');
INSERT INTO `order_master` VALUES (29, 2, 'D1655989485793080249', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 0, '0', NULL, 1, '2022-06-23 21:04:46', '2022-06-24 16:55:15');
INSERT INTO `order_master` VALUES (30, 2, 'D1655989493545635323', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 0, '0', NULL, 1, '2022-06-23 21:04:54', '2022-06-24 16:55:17');
INSERT INTO `order_master` VALUES (31, 2, 'D1656053530051070550', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 1, 5.28, 0, '0', NULL, 1, '2022-06-24 14:52:11', '2022-06-24 16:55:19');
INSERT INTO `order_master` VALUES (32, 2, 'D1656053583287865994', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 1, 5.28, 0, '0', NULL, 1, '2022-06-24 14:53:04', '2022-06-24 16:55:04');
INSERT INTO `order_master` VALUES (33, 2, 'D1656053840705819474', 'zzZ', '1111111111', '贵州大学4栋', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 0, '0', NULL, 0, '2022-06-24 14:58:00', '2022-06-24 14:58:00');
INSERT INTO `order_master` VALUES (34, 2, 'D1656053946325744343', 'zzZ', '123568999', '贵州大学11111', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 4, 21.12, 0, '0', NULL, 0, '2022-06-24 14:59:09', '2022-06-24 14:59:09');
INSERT INTO `order_master` VALUES (35, 2, 'D1656055511875623175', 'zzZ', '111111', '11111', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 6, 31.68, 0, '0', NULL, 0, '2022-06-24 15:25:20', '2022-06-24 15:25:20');
INSERT INTO `order_master` VALUES (36, 2, 'D1656055536338223539', 'zzZ', '111111', '11111', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 6, 30.12, 0, '0', NULL, 0, '2022-06-24 15:25:37', '2022-06-24 15:25:37');
INSERT INTO `order_master` VALUES (37, 2, 'D1657341164382528679', 'zzZ', '123131', '的方式方式', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 0, '0', NULL, 0, '2022-07-09 12:39:59', '2022-07-09 12:39:59');
INSERT INTO `order_master` VALUES (38, 2, 'D1657347348181906461', 'zzZ', '12233445566', 'gggg', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 3, 15.84, 1, '0', NULL, 1, '2022-07-09 14:16:13', '2022-07-09 14:18:23');
INSERT INTO `order_master` VALUES (39, 2, 'D1657348677325917379', 'zzZ', '121212121', 'guizhoudaxue', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 244.00, 1, '0', NULL, 1, '2022-07-09 14:38:32', '2022-07-09 14:39:07');
INSERT INTO `order_master` VALUES (42, 13, 'D16584754315197547210', 'zzZ', '12312', '贵州大学', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 1, 5.00, 0, '0', NULL, 1, '2022-07-22 15:37:12', '2022-07-22 16:56:59');
INSERT INTO `order_master` VALUES (44, 13, 'D1658479886091953665', 'zzZ', '12312', '贵州大学', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 0, '0', NULL, 1, '2022-07-22 16:51:26', '2022-07-22 16:56:28');
INSERT INTO `order_master` VALUES (45, 13, 'D1658480256504223766', 'zzZ', '12312', '贵州大学', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 4, 5015.84, 0, '0', NULL, 0, '2022-07-22 16:57:36', '2022-07-22 16:57:36');
INSERT INTO `order_master` VALUES (46, 13, 'D1658480450417465484', 'zzZ', '12312', '贵州大学', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 10.56, 0, '0', NULL, 0, '2022-07-22 17:00:50', '2022-07-22 17:00:50');
INSERT INTO `order_master` VALUES (47, 13, 'D16584910771263710396', 'zzZ', '2342342342', '贵州大学北校区4栋11111111111111', 'ogL6u5EjgYnltQWYZjJTz310tHFI', 2, 5005.28, 0, '1', NULL, 1, '2022-07-22 19:57:57', '2022-07-25 15:13:14');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名字',
  `category_type` int NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(20, 2) NOT NULL COMMENT '单价',
  `product_price_now` decimal(20, 2) NULL DEFAULT NULL COMMENT '折扣价',
  `product_stock` int NOT NULL COMMENT '库存',
  `product_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `product_img` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小图',
  `tab_type` int NOT NULL COMMENT '类目编号',
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志\r\n',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `quantity` int NULL DEFAULT NULL COMMENT '数量',
  `product_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态 上架 下架',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES (1, '雪王大圣代(黑糖珍珠)', 6.00, 5000.00, 500, '是', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/黑珍珠大圣代.png', 1, '0', '2022-06-21 11:58:44', '2022-07-25 15:04:10', 0, '0');
INSERT INTO `product_info` VALUES (2, '雪王大圣代(芒果)', 6.00, 5.28, 994, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(芒果).png', 1, '0', '2022-06-21 12:05:33', '2022-07-25 15:04:09', 0, '0');
INSERT INTO `product_info` VALUES (3, '雪王大圣代(草莓)', 6.00, 5.28, 997, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(草莓).png', 1, '0', '2022-06-21 11:58:44', '2022-06-23 14:06:43', 0, '0');
INSERT INTO `product_info` VALUES (4, '雪王大圣代(奥利奥)', 6.00, 5.28, 998, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/雪王大圣代(奥利奥).png', 1, '0', '2022-06-21 12:05:33', '2022-06-23 14:06:44', 0, '0');
INSERT INTO `product_info` VALUES (5, '冰鲜柠檬水', 5.00, 4.00, 999, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/bxnms.png', 2, '0', '2022-06-21 11:58:44', '2022-06-23 14:06:46', 0, '0');
INSERT INTO `product_info` VALUES (6, '森林玫果', 6.00, 5.00, 999, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/slmg.png', 2, '0', '2022-06-21 12:05:33', '2022-06-23 14:06:48', 0, '0');
INSERT INTO `product_info` VALUES (7, '蜜桃四季春', 7.80, 6.00, 999, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/mtsjc.png', 2, '0', '2022-06-21 11:58:44', '2022-06-23 14:06:54', 0, '0');
INSERT INTO `product_info` VALUES (8, '满杯百香果', 9.90, 8.88, 999, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/mbnxg.png', 2, '0', '2022-06-21 12:05:33', '2022-06-23 14:06:53', 0, '0');
INSERT INTO `product_info` VALUES (9, '柠檬益菌多', 9.99, 7.00, 999, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/nmyjd.png', 2, '0', '2022-06-21 21:13:19', '2022-06-23 14:07:11', NULL, '0');
INSERT INTO `product_info` VALUES (10, '黄桃燕麦酸奶', 13.00, 10.99, 999, NULL, 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/htymsn.png', 2, '0', '2022-06-21 21:14:02', '2022-06-23 14:07:13', NULL, '0');
INSERT INTO `product_info` VALUES (11, '港式杨枝甘露', 11.99, 11.00, 999, NULL, NULL, 2, '0', '2022-06-21 21:14:35', '2022-06-23 14:07:08', NULL, '0');
INSERT INTO `product_info` VALUES (12, '芋圆葡萄', 8.88, 7.00, 999, NULL, NULL, 2, '0', '2022-06-21 21:15:01', '2022-06-23 14:07:21', NULL, '0');
INSERT INTO `product_info` VALUES (13, '荔枝啵啵', 9.00, 7.00, 999, NULL, NULL, 2, '0', '2022-06-21 21:15:33', '2022-06-23 14:07:18', NULL, '0');
INSERT INTO `product_info` VALUES (14, '珍珠奶茶', 9.00, 6.00, 999, NULL, NULL, 3, '0', '2022-06-21 21:16:09', '2022-06-23 14:07:23', NULL, '0');
INSERT INTO `product_info` VALUES (15, '燕麦奶茶', 9.00, 7.00, 999, NULL, NULL, 3, '0', '2022-06-21 21:16:32', '2022-06-23 14:07:25', NULL, '0');
INSERT INTO `product_info` VALUES (16, '椰果奶茶', 9.00, 7.00, 999, NULL, NULL, 3, '0', '2022-06-21 21:16:53', '2022-06-23 14:07:26', NULL, '0');
INSERT INTO `product_info` VALUES (17, '红豆奶茶', 9.00, 7.00, 999, NULL, NULL, 3, '0', '2022-06-21 21:17:13', '2022-06-23 14:07:28', NULL, '0');
INSERT INTO `product_info` VALUES (18, '芋圆奶茶', 10.00, 8.00, 999, NULL, NULL, 3, '0', '2022-06-21 21:17:29', '2022-06-23 14:07:29', NULL, '0');
INSERT INTO `product_info` VALUES (19, '薯条', 3.00, 1.99, 999, NULL, NULL, 4, '0', '2022-06-21 21:17:59', '2022-06-23 14:07:31', NULL, '0');
INSERT INTO `product_info` VALUES (20, '瓜子', 4.99, 3.99, 999, NULL, NULL, 4, '0', '2022-06-21 21:18:20', '2022-06-23 14:07:33', NULL, '0');
INSERT INTO `product_info` VALUES (21, '美式咖啡', 5.99, 4.99, 999, NULL, 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/419ccbfc1e178a82104336e7e103738da877e8b1 (2).jpg', 5, '0', '2022-06-21 21:18:57', '2022-06-23 14:07:35', NULL, '0');
INSERT INTO `product_info` VALUES (29, '啦啦啦啦', 100.00, 99.00, 9999, '<p>11</p>', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/419ccbfc1e178a82104336e7e103738da877e8b1 (2).jpg', 1, '0', '2022-07-09 14:19:43', '2022-07-09 14:19:43', NULL, '0');
INSERT INTO `product_info` VALUES (30, '拉阿拉蕾', 1111.00, 122.00, 888, '', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/黑珍珠大圣代.png', 1, '0', '2022-07-09 14:37:38', '2022-07-09 14:37:38', NULL, '0');
INSERT INTO `product_info` VALUES (31, '虽赊', 22.00, 22.00, 555, '虽赊', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658718253781', 2, '0', '2022-07-25 11:04:43', '2022-07-25 11:04:43', NULL, '0');
INSERT INTO `product_info` VALUES (32, '虽赊222', 22.00, 22.00, 555, '虽赊', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658718253781', 2, '1', '2022-07-25 11:05:00', '2022-07-25 11:23:13', NULL, '0');
INSERT INTO `product_info` VALUES (33, '121', 11.00, 11.00, 11, '1', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658719152543', 4, '1', '2022-07-25 11:19:22', '2022-07-25 11:23:10', NULL, '0');

-- ----------------------------
-- Table structure for product_tab
-- ----------------------------
DROP TABLE IF EXISTS `product_tab`;
CREATE TABLE `product_tab`  (
  `tab_type` int NOT NULL AUTO_INCREMENT,
  `tab_typename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `tab_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图',
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志',
  `tab_rank` int NULL DEFAULT 1 COMMENT '分类排序等级',
  PRIMARY KEY (`tab_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_tab
-- ----------------------------
INSERT INTO `product_tab` VALUES (1, '节日限定', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/icon1.png', '0', 0);
INSERT INTO `product_tab` VALUES (2, '真鲜果茶', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/icon1.png', '0', 1);
INSERT INTO `product_tab` VALUES (3, '醇香奶茶', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/icon1.png', '0', 1);
INSERT INTO `product_tab` VALUES (4, '小小零食', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/icon1.png', '0', 1);
INSERT INTO `product_tab` VALUES (5, '鲜萃咖啡', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658722412293', '0', 1);
INSERT INTO `product_tab` VALUES (6, '芝士奶盖', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/icon1.png', '0', 1);
INSERT INTO `product_tab` VALUES (7, '原叶绿茶', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/icon1.png', '0', 1);
INSERT INTO `product_tab` VALUES (8, '雪王周边', 'https://image-zzz.oss-cn-chengdu.aliyuncs.com/img/icon1.png', '0', 1);
INSERT INTO `product_tab` VALUES (11, '哇哇', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/419ccbfc1e178a82104336e7e103738da877e8b1 (2).jpg', '1', 1);
INSERT INTO `product_tab` VALUES (12, '额', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/20210504040003_3bf49.jpeg', '1', 2);
INSERT INTO `product_tab` VALUES (13, '啊啊啊', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/20201013170602_1fa7f.jpeg', '1', 1);
INSERT INTO `product_tab` VALUES (14, '啊啊', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1012.jpg', '0', 1);
INSERT INTO `product_tab` VALUES (15, 'w\'w', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658722149112', '0', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `positions` int NULL DEFAULT 5 COMMENT '权限',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '卖家信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '33v', 'string', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658663028870', 3, 'string', '2022-06-21 06:24:43', '2022-07-24 20:32:21', '0');
INSERT INTO `user` VALUES (2, 'zzZ', '123456', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoUIiarCqq9jnl2RHeic3giaFcFOS784y7WkJ8k6kJO1yXviaoIz5kLEfcCZNIRAxh9n2R6ic9yunicgk4g/132', 0, '11ogL6u5EjgYnltQWYZjJTz310tHFI', '2022-06-21 14:29:53', '2022-07-24 20:32:23', '0');
INSERT INTO `user` VALUES (4, 'string', 'string', 'string', 0, '12312', '2022-06-21 07:23:11', '2022-07-24 20:32:24', '0');
INSERT INTO `user` VALUES (5, 'str222', 'string', 'string', 0, '1231yyy2', '2022-06-21 07:23:11', '2022-07-24 20:32:25', '0');
INSERT INTO `user` VALUES (6, 'admin', '123456', NULL, 5, '111', '2022-07-16 14:59:06', '2022-07-24 21:49:45', '0');
INSERT INTO `user` VALUES (7, 'aaa', 'aaa', NULL, 1, '22', '2022-07-16 19:31:13', '2022-07-24 22:10:04', '0');
INSERT INTO `user` VALUES (13, 'zzZ', '', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoUIiarCqq9jnl2RHeic3giaFcFOS784y7WkJ8k6kJO1yXviaoIz5kLEfcCZNIRAxh9n2R6ic9yunicgk4g/132', 1, 'ogL6u5EjgYnltQWYZjJTz310tHFI', '2022-07-22 15:22:43', '2022-07-24 20:32:27', '0');
INSERT INTO `user` VALUES (14, '123', '123', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658663914355', 2, '0', '2022-07-24 17:58:06', '2022-07-24 20:32:28', '0');
INSERT INTO `user` VALUES (15, '435345', '35', '', 3, '0', '2022-07-24 18:01:15', '2022-07-24 20:32:30', '0');
INSERT INTO `user` VALUES (16, '5434威威虽赊', '4324', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658659325919', 3, '0', '2022-07-24 18:42:10', '2022-07-24 20:32:32', '0');
INSERT INTO `user` VALUES (17, 'zzZ', '123456', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoUIiarCqq9jnl2RHeic3giaFcFOS784y7WkJ8k6kJO1yXviaoIz5kLEfcCZNIRAxh9n2R6ic9yunicgk4g/132', 2, '11ogL6u5EjgYnltQWYZjJTz310tHFI', '2022-06-21 14:29:53', '2022-07-24 20:32:33', '0');
INSERT INTO `user` VALUES (18, '123 他', '12', NULL, 3, NULL, '2022-07-24 19:33:12', '2022-07-24 20:32:34', '0');
INSERT INTO `user` VALUES (19, '1232222', '12322', NULL, 4, NULL, '2022-07-24 19:34:29', '2022-07-24 20:32:35', '0');
INSERT INTO `user` VALUES (20, '但是都是', '是多少', NULL, 3, NULL, '2022-07-24 19:35:28', '2022-07-24 20:32:37', '0');
INSERT INTO `user` VALUES (21, '认为水水水水水水水水水水水', '额外', NULL, 4, NULL, '2022-07-24 19:36:33', '2022-07-24 20:32:17', '0');
INSERT INTO `user` VALUES (22, '13', '123', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658662647245', 4, NULL, '2022-07-24 19:37:29', '2022-07-24 20:32:02', '1');
INSERT INTO `user` VALUES (24, 'zzZ', '123456', 'http://image-zzz.oss-cn-chengdu.aliyuncs.com/1658662801103', 4, '11ogL6u5EjgYnltQWYZjJTz310tHFI', '2022-06-21 14:29:53', '2022-07-24 20:32:00', '1');
INSERT INTO `user` VALUES (25, '而非我', '二分', NULL, 3, NULL, '2022-07-24 19:43:40', '2022-07-24 20:22:42', '1');
INSERT INTO `user` VALUES (26, '666', '666', NULL, 1, NULL, '2022-07-24 20:36:06', '2022-07-24 20:36:06', '0');
INSERT INTO `user` VALUES (27, '虽赊', '是', NULL, 5, NULL, '2022-07-24 21:43:44', '2022-07-24 21:43:44', '0');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'ogL6u5EjgYnltQWYZjJTz310tHFI', 'lalal', '12312312', '0');
INSERT INTO `user_info` VALUES (2, 'ogL6u5EjgYnltQWYZjJTz310tHFI', '贵州大学北校区4栋11111111111111', '2342342342', '0');
INSERT INTO `user_info` VALUES (4, 'ogL6u5EjgYnltQWYZjJTz310tHFI', '贵州大学', '12312', '0');
INSERT INTO `user_info` VALUES (5, 'ogL6u5EjgYnltQWYZjJTz310tHFI', '123', '123', '0');
INSERT INTO `user_info` VALUES (6, 'ogL6u5EjgYnltQWYZjJTz310tHFI', '1123233333333', '123', '0');
INSERT INTO `user_info` VALUES (7, 'ogL6u5EjgYnltQWYZjJTz310tHFI', '123', '123', '0');
INSERT INTO `user_info` VALUES (8, 'ogL6u5EjgYnltQWYZjJTz310tHFI', '123123123', '123', '0');
INSERT INTO `user_info` VALUES (10, 'ogL6u5EjgYnltQWYZjJTz310tHFI', 'uuuu', '123456', '0');

-- ----------------------------
-- Table structure for user_position
-- ----------------------------
DROP TABLE IF EXISTS `user_position`;
CREATE TABLE `user_position`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `position_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `power` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_position
-- ----------------------------
INSERT INTO `user_position` VALUES (1, '外卖员', NULL, '0', NULL);
INSERT INTO `user_position` VALUES (2, '前台', NULL, '0', NULL);
INSERT INTO `user_position` VALUES (3, '管理员', NULL, '0', NULL);
INSERT INTO `user_position` VALUES (4, '普通用户', NULL, '0', NULL);

-- ----------------------------
-- Table structure for vue_menu
-- ----------------------------
DROP TABLE IF EXISTS `vue_menu`;
CREATE TABLE `vue_menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `authName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_order` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parentid` int NULL DEFAULT NULL,
  `deleteflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `power` int NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vue_menu
-- ----------------------------
INSERT INTO `vue_menu` VALUES (1, '用户管理', '1', 'users', 0, '0', 3);
INSERT INTO `vue_menu` VALUES (2, '轮播图管理', NULL, 'banner', 0, '0', 2);
INSERT INTO `vue_menu` VALUES (4, '商品管理', '2', 'product', 0, '0', 2);
INSERT INTO `vue_menu` VALUES (5, '商品管理', NULL, 'product', 4, '0', 2);
INSERT INTO `vue_menu` VALUES (6, '添加商品', NULL, 'productadd', 4, '1', 2);
INSERT INTO `vue_menu` VALUES (7, '商品分类管理', NULL, 'tab', 9, '0', 2);
INSERT INTO `vue_menu` VALUES (8, '商品分类添加', NULL, 'tabadd', 9, '1', 2);
INSERT INTO `vue_menu` VALUES (9, '分类信息', NULL, 'tab', 0, '0', 2);
INSERT INTO `vue_menu` VALUES (10, '用户信息', '1', 'users', 1, '0', 2);
INSERT INTO `vue_menu` VALUES (11, '轮播图', NULL, 'banner', 2, '0', 2);
INSERT INTO `vue_menu` VALUES (12, '订单管理', NULL, 'orders', 0, '0', 1);
INSERT INTO `vue_menu` VALUES (13, '订单信息', NULL, 'master', 12, '0', 1);
INSERT INTO `vue_menu` VALUES (14, '订单详情', NULL, 'detail', 12, '0', 1);
INSERT INTO `vue_menu` VALUES (15, '库存管理', NULL, 'stock', 0, '1', 2);
INSERT INTO `vue_menu` VALUES (16, '库存管理', NULL, 'stock', 15, '1', 2);

SET FOREIGN_KEY_CHECKS = 1;
