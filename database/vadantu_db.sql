CREATE DATABASE  IF NOT EXISTS `vadantu_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vadantu_db`;
-- Host: localhost    Database: vadantu_db
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

DROP TABLE IF EXISTS `Account`;
create table Accounts (
             User_Name varchar(20) not null,
             Active bit not null,
             Password varchar(20) not null,
             User_Role varchar(20) not null,
            primary key (User_Name)
        );



-- Table structure for table `lines_item`
--


--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `idorder` bigint(20) NOT NULL AUTO_INCREMENT,
  `ordered` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  `idcustomer` bigint(20) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idorder`),
  KEY `orders_customers_fk_idx` (`idcustomer`),
  CONSTRAINT `orders_customers_fk` FOREIGN KEY (`idcustomer`) REFERENCES `customers` (`idcustomer`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `idproduct` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `idcategory` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproduct`),
  KEY `products_categories_fk` (`idcategory`),
  CONSTRAINT `products_categories_fk` FOREIGN KEY (`idcategory`) REFERENCES `categories` (`idcategory`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
