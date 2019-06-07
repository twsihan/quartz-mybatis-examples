USE `quartz-mybatis-examples`;

DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `type` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='信息表';

-- 用户信息
INSERT INTO `example` VALUES ('1', 'test1', '12345678', '1', null);
INSERT INTO `example` VALUES ('2', 'test2', 'aaaa', '2', null);
INSERT INTO `example` VALUES ('3', 'test3', 'bbbb', '1', null);
INSERT INTO `example` VALUES ('4', 'test4', 'cccc', '2', null);
INSERT INTO `example` VALUES ('5', 'test5', 'dddd', '1', null);
