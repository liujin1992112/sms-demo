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

/*Table structure for table `tb_vip` */

DROP TABLE IF EXISTS `tb_vip`;

CREATE TABLE `tb_vip` (
  `id` int(11) NOT NULL,
  `vip_id` varchar(50) NOT NULL,
  `vip_name` varchar(200) NOT NULL,
  `vip_image` text NOT NULL,
  `month` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `end_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_vip` */

insert  into `tb_vip`(`id`,`vip_id`,`vip_name`,`vip_image`,`month`,`price`,`end_time`) values (1,'com.read.m1','一个月','https://static-test.kemiba.cn/6f721ffd13087b41f3038abececfba07/11B0F425C/avatar/000/300/841.jpg?v=1586921715',1,18,0),(2,'com.read.m3','三个月','https://static-test.kemiba.cn/6f721ffd13087b41f3038abececfba07/11B0F425C/avatar/000/300/841.jpg?v=1586921715',1,18,0),(3,'com.read.m12','十二个月','https://static-test.kemiba.cn/6f721ffd13087b41f3038abececfba07/11B0F425C/avatar/000/300/841.jpg?v=1586921715',1,18,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
