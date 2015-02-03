-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.6.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4857
-- --------------------------------------------------------

-- Dumping database structure for protectme
CREATE DATABASE IF NOT EXISTS `protectme` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `protectme`;


-- Dumping structure for table protectme.accounts
CREATE TABLE IF NOT EXISTS `accounts` (
  `Name` varchar(50) NOT NULL DEFAULT 'Unknown',
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL DEFAULT '0',
  `Admin` bit(1) NOT NULL DEFAULT b'0',
  `CreatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PictureID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table protectme.accounts: ~2 rows (approximately)
REPLACE INTO `accounts` (`Name`, `Username`, `Password`, `Admin`, `CreatedAt`, `PictureID`) VALUES
	('Mathew Turner', 'regency', 'regency1', b'1', '2014-11-13 22:23:27', NULL),
	('testName', 'testUsername', 'teest', b'0', '2014-11-18 21:48:34', NULL);


-- Dumping structure for table protectme.clients
CREATE TABLE IF NOT EXISTS `clients` (
  `NameID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `ClientAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`NameID`,`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.clients: ~0 rows (approximately)
REPLACE INTO `clients` (`NameID`, `Username`, `ClientAt`) VALUES
	(122, 'regency', '2014-11-19 19:05:41');


-- Dumping structure for table protectme.names
CREATE TABLE IF NOT EXISTS `names` (
  `NameID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `OtherNames` varchar(50) DEFAULT NULL,
  `MobileNumber` varchar(50) NOT NULL,
  `OfficeNumber` varchar(50) NOT NULL,
  `Company` varchar(50) DEFAULT NULL,
  `PictureID` int(11) DEFAULT NULL,
  PRIMARY KEY (`NameID`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.names: ~17 rows (approximately)
REPLACE INTO `names` (`NameID`, `FirstName`, `OtherNames`, `MobileNumber`, `OfficeNumber`, `Company`, `PictureID`) VALUES
	(116, 'Stuart', 'Harding', 'N/A', '22242000', 'Alshaya', NULL),
	(117, 'Dave', 'Ludkin', 'N/A', '22242000', 'Alshaya', NULL),
	(118, 'Angus', 'Mac Rury', '66981175', 'N/A', 'Chevron', NULL),
	(119, 'Vernon', 'Barns', 'N/A', '22242000', 'Alshaya', NULL),
	(120, 'David', 'Gurney', 'N/A', '1836000', 'KUFPEC', NULL),
	(121, 'Kevin', 'Reed', '96967813', 'N/A', 'Gulf Consult', NULL),
	(122, 'Neil', 'Smith', '96621344', 'N/A', 'G4S', NULL),
	(123, 'Pete', 'Oversby', '67012489', 'N/A', 'Swift', NULL),
	(124, 'Anthony', 'Lockwood', '67085539', 'N/A', 'Worley Parsons', NULL),
	(125, 'Darren', 'Yule', 'N/A', '22955341', 'Ernst and Young', NULL),
	(126, 'Alan', 'Young', '65826841', 'N/A', 'Worley Parsons', NULL),
	(127, 'Graham', 'Hall', '97293609', '', 'Alshaya', NULL),
	(128, 'Lindsay', 'Davidson', '97237056', '', '', NULL),
	(129, 'Piotr', 'Przyblinski', '66821692', '', 'Kuwait Cement', NULL),
	(130, 'Ezekiel', 'Tuma', '97250660', '', 'ASAR', NULL),
	(131, 'Nigel', 'Hicks', '96969738', '', 'Alshaya', NULL),
	(132, 'Lee', 'Walker', '97279919', '', 'Alshaya', NULL);


-- Dumping structure for table protectme.pictures
CREATE TABLE IF NOT EXISTS `pictures` (
  `PictureID` int(11) NOT NULL AUTO_INCREMENT,
  `Location` varchar(50) NOT NULL DEFAULT 'N/A',
  `AddedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`PictureID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.pictures: ~0 rows (approximately)


-- Dumping structure for table protectme.protectedname
CREATE TABLE IF NOT EXISTS `protectednames` (
  `Username` varchar(50) NOT NULL,
  `NameID` int(11) NOT NULL,
  `Comments` varchar(50) DEFAULT NULL,
  `Called` bit(1) NOT NULL,
  `Booked` bit(1) NOT NULL,
  `CallBack` timestamp NULL DEFAULT NULL,
  `DateBooked` timestamp NULL DEFAULT NULL,
  `ProtectedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Priority` enum('High','Medium','Low') NOT NULL DEFAULT 'Low',
  PRIMARY KEY (`Username`,`NameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.protectedname: ~0 rows (approximately)
REPLACE INTO `protectednames` (`Username`, `NameID`, `Comments`, `Called`, `Booked`, `CallBack`, `DateBooked`, `ProtectedAt`, `Priority`) VALUES
	('regency', 119, 'testComment3', b'1', b'0', '2014-11-19 18:39:32', '2014-11-19 18:39:32', '2014-11-19 18:39:32', 'Low'),
	('regency', 120, 'testComment', b'1', b'1', '2014-11-19 18:38:01', '2014-11-19 18:38:01', '2014-11-19 18:38:01', 'Low'),
	('regency', 121, 'testComment2', b'0', b'1', '2014-11-19 18:39:05', '2014-11-19 18:39:05', '2014-11-19 18:39:05', 'Low');


-- Dumping structure for table protectme.unprotectednames
CREATE TABLE IF NOT EXISTS `unprotectednames` (
  `NameID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Comments` varchar(50) DEFAULT NULL,
  `AddedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Priority` enum('High','Medium','Low') NOT NULL DEFAULT 'Low',
  PRIMARY KEY (`NameID`,`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table protectme.unprotectednames: ~6 rows (approximately)
REPLACE INTO `unprotectednames` (`NameID`, `Username`, `Comments`, `AddedAt`, `Priority`) VALUES
	(127, 'regency', 'First booked 03/03/14', '2014-11-18 17:12:16', 'Low'),
	(128, 'regency', 'client', '2014-11-18 17:12:16', 'Low'),
	(129, 'testUsername', 'client', '2014-11-18 17:12:16', 'Low'),
	(130, 'testUsername', 'client', '2014-11-18 17:12:16', 'Low'),
	(131, 'testUsername', 'client', '2014-11-18 17:12:16', 'Low'),
	(132, 'testUsername', 'client', '2014-11-18 17:12:16', 'Low');
