/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.26 : Database - studentdormitory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentdormitory` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `studentdormitory`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `name` varchar(50) DEFAULT NULL COMMENT '管理员姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理者表';

/*Data for the table `admin` */

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sname` varchar(100) DEFAULT NULL COMMENT '学生姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `sphone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `sno` varchar(100) DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `register` */

insert  into `register`(`id`,`sname`,`password`,`sphone`,`email`,`sno`) values (1,NULL,NULL,NULL,NULL,NULL),(2,'赵柳','156256','19120592115','2659934495@163.com',NULL),(10,'赵琦','123','19120532669','pang@qq.com',NULL),(11,'赵琦','156256','19120532669','745865734@qq.com',NULL),(12,'赵琦','123','19120532669','745865734@qq.com',NULL),(13,'小明','123456','19120532669','13434929528@qq.com','20195533409'),(14,'小星星','123456','19120532669','745865734@qq.com','20195533408'),(15,'赵琦','123','19120532669','745865734@qq.com','20195533409'),(16,'小胖','123','19120532669','2659934495@qq.com','20195533410');

/*Table structure for table `repaired` */

DROP TABLE IF EXISTS `repaired`;

CREATE TABLE `repaired` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dormitoryid` varchar(100) DEFAULT NULL COMMENT '宿舍楼',
  `reason` varchar(200) DEFAULT NULL COMMENT '报修事由',
  `submit_time` date DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `repaired` */

insert  into `repaired`(`id`,`dormitoryid`,`reason`,`submit_time`) values (3,'26#2035','空调坏了，赶紧修','2021-09-29'),(6,'123','123','2021-10-12'),(7,'25#5016','水龙头坏了','2021-10-16'),(8,'24#1562','未知','2021-10-14'),(9,'23#2012','测试','2021-10-18'),(10,'26#2015','测试','2021-10-19');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(100) DEFAULT NULL,
  `sname` varchar(100) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `sphone` varchar(100) DEFAULT NULL,
  `course` varchar(100) DEFAULT NULL,
  `dormitoryid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`sno`,`sname`,`sex`,`age`,`sphone`,`course`,`dormitoryid`) values (3,'20195544608','小胖子','女','23','19120582114','19php2班','26#5026'),(5,'20195522161','王武舞','男','24','15625607002','20web2班','26#2016'),(6,'20202113','哈哈','女','21','191203698','19php4班','15#2016'),(7,'20195544608','小胖','男','22','19120582116','19php2班','26#5026'),(9,'20195544608','小胖','男','22','19120582116','19php2班','26#5026'),(10,'20195544608','小胖','男','22','19120582116','19php2班','26#5026'),(11,'20195544608','小胖','男','22','19120582116','19php2班','26#5026'),(13,'20195544608','小红','男','22','19120582116','19php2班','26#5026'),(14,'20195522360','笑笑','女','18','19120592115','19web1','25#2013'),(15,'20195533410','津津','男','20','19120592556','19java6班','26#3025'),(16,'','',NULL,'','','','');

/*Table structure for table `vistor` */

DROP TABLE IF EXISTS `vistor`;

CREATE TABLE `vistor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `v_name` varchar(50) DEFAULT NULL COMMENT '来访者姓名',
  `v_phone` varchar(100) DEFAULT NULL COMMENT '来访者电话',
  `v_dormitoryid` varchar(100) DEFAULT NULL COMMENT '来访者宿舍楼',
  `createTime` datetime DEFAULT NULL COMMENT '来访时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='来访者表';

/*Data for the table `vistor` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
