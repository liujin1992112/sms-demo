/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.26 : Database - tqf-app
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tqf-app` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tqf-app`;

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `gender` int(11) NOT NULL,
  `nickName` varchar(100) DEFAULT NULL,
  `vipLevel` int(11) NOT NULL,
  `phoneNum` varchar(20) NOT NULL,
  `qqNum` varchar(100) DEFAULT NULL,
  `weiChatNum` varchar(100) DEFAULT NULL,
  `vipEndTime` int(11) DEFAULT NULL,
  `avatar` text NOT NULL,
  `timeCreated` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`gender`,`nickName`,`vipLevel`,`phoneNum`,`qqNum`,`weiChatNum`,`vipEndTime`,`avatar`,`timeCreated`) values (1,1,'缘阁阁',0,'',NULL,NULL,NULL,'https://static-test.kemiba.cn/6f721ffd13087b41f3038abececfba07/11B0F425C/avatar/000/300/841.jpg?v=1586921715',1586921364);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
