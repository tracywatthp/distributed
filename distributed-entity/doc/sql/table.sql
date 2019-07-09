-- 用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(10) DEFAULT NULL COMMENT '名称',
  `db_name` varchar(10) DEFAULT NULL COMMENT '数据库名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;