-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.6.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for protectme
CREATE DATABASE IF NOT EXISTS `CRM` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `CRMcrm`;


-- Dumping structure for table protectme.accounts
CREATE TABLE IF NOT EXISTS `accounts` (
  `AccountID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL DEFAULT 'Unknown',
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Admin` bit(1) NOT NULL DEFAULT b'0',
  `CreatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PictureID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`AccountID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table protectme.accounts: ~3 rows (approximately)
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` (`AccountID`, `Name`, `Username`, `Password`, `Admin`, `CreatedAt`, `PictureID`) VALUES
	(1, 'Mathew Turner', 'regency', 'regency2', b'1', '2014-11-13 22:23:27', 0),
	(2, 'testName', 'testUsername', 'teest', b'0', '2014-11-18 21:48:34', 0),
	(3, 'Vasily', 'shelkv', '123456', b'0', '2015-04-25 12:00:14', 0);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;


-- Dumping structure for table protectme.clients
CREATE TABLE IF NOT EXISTS `clients` (
  `NameID` int(11) NOT NULL,
  `AccountID` int(11) NOT NULL,
  `ClientAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`NameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.clients: ~2 rows (approximately)
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` (`NameID`, `AccountID`, `ClientAt`) VALUES
	(122, 1, '2014-11-19 19:05:41'),
	(130, 1, '2015-05-24 20:29:15');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;


-- Dumping structure for table protectme.comments
CREATE TABLE IF NOT EXISTS `comments` (
  `AccountID` int(11) NOT NULL,
  `NameID` int(11) NOT NULL,
  `CommentID` int(11) NOT NULL,
  `Comment` text,
  `LastUpdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`AccountID`,`NameID`,`CommentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table protectme.comments: ~0 rows (approximately)
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`AccountID`, `NameID`, `CommentID`, `Comment`, `LastUpdated`) VALUES
	(1, 120, 1, 'First Comment', '2015-06-05 15:00:27'),
	(1, 120, 2, 'Second Comment on Same Name', '2015-06-05 15:01:24'),
	(1, 127, 1, 'Second name first comment', '2015-06-05 15:01:33'),
	(2, 127, 1, 'Second Account Second Name Second COmment', '2015-06-05 15:01:59');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;


-- Dumping structure for table protectme.company
CREATE TABLE IF NOT EXISTS `company` (
  `CompanyID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `OfficeNumber` varchar(50) DEFAULT 'N/A',
  PRIMARY KEY (`CompanyID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table protectme.company: ~11 rows (approximately)
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`CompanyID`, `Name`, `OfficeNumber`) VALUES
	(1, 'Alshaya', '22242000'),
	(2, 'Chevron', 'N/A'),
	(3, 'KUFPEC', '1836000'),
	(4, 'Gulf Consult', 'N/A'),
	(5, 'G4S', 'N/A'),
	(6, 'Swift', 'N/A'),
	(7, 'Worley Parons', 'N/A'),
	(8, 'Ernst and Young', '22955341'),
	(9, 'Kuwait Cement', 'N/A'),
	(10, 'ASAR', 'N/A'),
	(11, 'Goldman Sachs', '02085005227'),
	(12, 'The Verve', '02085035226');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;


-- Dumping structure for table protectme.names
CREATE TABLE IF NOT EXISTS `names` (
  `NameID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL DEFAULT 'N/A',
  `OtherNames` varchar(50) NOT NULL DEFAULT 'N/A',
  `MobileNumber` varchar(50) NOT NULL DEFAULT 'N/A',
  `CompanyID` int(11) DEFAULT NULL,
  `PictureID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`NameID`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.names: ~19 rows (approximately)
/*!40000 ALTER TABLE `names` DISABLE KEYS */;
INSERT INTO `names` (`NameID`, `FirstName`, `OtherNames`, `MobileNumber`, `CompanyID`, `PictureID`) VALUES
	(116, 'Stuart', 'Harding', 'N/A', 1, 0),
	(117, 'Dave', 'Ludkin', 'N/A', 1, 0),
	(118, 'Angus', 'Mac Rury', '66981175', 2, 0),
	(119, 'Vernon', 'Barns', 'N/A', 1, 0),
	(120, 'David', 'Gurney', 'N/A', 3, 0),
	(121, 'Kevin', 'Reed', '96967813', 4, 0),
	(122, 'Neil', 'Smith', '96621344', 5, 0),
	(123, 'Pete', 'Oversby', '67012489', 6, 0),
	(124, 'Anthony', 'Lockwood', '67085539', 7, 0),
	(125, 'Darren', 'Yule', 'N/A', 8, 0),
	(126, 'Alan', 'Young', '65826841', 7, 0),
	(127, 'Graham', 'Hall', '97293609', 1, 0),
	(128, 'Lindsay', 'Davidson', '97237056', 8, 0),
	(129, 'Piotr', 'Przyblinski', '66821692', 9, 0),
	(130, 'Ezekiel', 'Tuma', '97250660', 10, 0),
	(131, 'Nigel', 'Hicks', '96969738', 1, 0),
	(132, 'Lee', 'Walker', '97279919', 1, 0),
	(133, 'Vasia', 'Shelkv-Turner', '07807886989', 11, 0),
	(134, 'Harry', 'Bradshaw', '07123456789', 12, 0);
/*!40000 ALTER TABLE `names` ENABLE KEYS */;


-- Dumping structure for table protectme.pictures
CREATE TABLE IF NOT EXISTS `pictures` (
  `PictureID` int(11) NOT NULL AUTO_INCREMENT,
  `Location` varchar(50) NOT NULL DEFAULT 'N/A',
  `AddedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`PictureID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.pictures: ~0 rows (approximately)
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;


-- Dumping structure for table protectme.protectednames
CREATE TABLE IF NOT EXISTS `protectednames` (
  `AccountID` int(11) NOT NULL,
  `NameID` int(11) NOT NULL,
  `Called` bit(1) NOT NULL DEFAULT b'0',
  `Booked` bit(1) NOT NULL DEFAULT b'0',
  `CallBack` timestamp NULL DEFAULT NULL,
  `DateBooked` timestamp NULL DEFAULT NULL,
  `ProtectedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Priority` enum('High','Medium','Low') NOT NULL DEFAULT 'Low',
  PRIMARY KEY (`AccountID`,`NameID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table protectme.protectednames: ~3 rows (approximately)
/*!40000 ALTER TABLE `protectednames` DISABLE KEYS */;
INSERT INTO `protectednames` (`AccountID`, `NameID`, `Called`, `Booked`, `CallBack`, `DateBooked`, `ProtectedAt`, `Priority`) VALUES
	(1, 119, b'1', b'0', '2014-11-19 18:39:32', '2014-11-19 18:39:32', '2014-11-19 18:39:32', 'Low'),
	(1, 120, b'1', b'1', '2014-11-19 18:38:01', '2014-11-19 18:38:01', '2014-11-19 18:38:01', 'Low'),
	(1, 121, b'0', b'1', '2014-11-19 18:39:05', '2014-11-19 18:39:05', '2014-11-19 18:39:05', 'Low');
/*!40000 ALTER TABLE `protectednames` ENABLE KEYS */;


-- Dumping structure for table protectme.unprotectednames
CREATE TABLE IF NOT EXISTS `unprotectednames` (
  `NameID` int(11) NOT NULL,
  `AccountID` int(11) NOT NULL,
  `AddedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Priority` enum('High','Medium','Low') NOT NULL DEFAULT 'Low',
  PRIMARY KEY (`NameID`,`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.unprotectednames: ~10 rows (approximately)
/*!40000 ALTER TABLE `unprotectednames` DISABLE KEYS */;
INSERT INTO `unprotectednames` (`NameID`, `AccountID`, `AddedAt`, `Priority`) VALUES
	(127, 1, '2014-11-18 17:12:16', 'Low'),
	(127, 2, '2015-01-21 22:34:19', 'Low'),
	(128, 1, '2014-11-18 17:12:16', 'Low'),
	(129, 2, '2014-11-18 17:12:16', 'Low'),
	(130, 2, '2014-11-18 17:12:16', 'Low'),
	(131, 2, '2014-11-18 17:12:16', 'Low'),
	(132, 2, '2014-11-18 17:12:16', 'Low'),
	(133, 1, '2015-05-24 20:02:35', 'Low'),
	(133, 2, '2015-02-03 22:54:29', 'Low'),
	(134, 1, '2015-05-24 18:54:33', 'Low');
/*!40000 ALTER TABLE `unprotectednames` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
protectmeprotectme