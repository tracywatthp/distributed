-- 用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(10) DEFAULT NULL COMMENT '名称',
  `db_name` varchar(10) DEFAULT NULL COMMENT '数据库名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 多数据库(同表数据)脚本
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `user_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `db_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'tinxi', '胡旭', database());
INSERT INTO `user` VALUES (2, 'zhangsan', '张三', database());
INSERT INTO `user` VALUES (3, 'lisi', '李四', database());
INSERT INTO `user` VALUES (4, 'wangwu', '王武', database());
INSERT INTO `user` VALUES (5, 'zhaoliu', '赵六', database());
INSERT INTO `user` VALUES (1148789602065129473, 'qianqi', '钱七', database());
INSERT INTO `user` VALUES (1148792234230005762, 'xiaoba', '小八', database());
