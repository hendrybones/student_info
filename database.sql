-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2021 at 09:01 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hendrytech`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `regNo` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `dateofreg` varchar(255) DEFAULT NULL,
  `dateofadmin` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`regNo`, `course`, `gender`, `dateofreg`, `dateofadmin`) VALUES
('tuo1', 'bbit', 'male', '27-6-1996', '2-4-2019'),
('tuo4', 'software', 'male', '2-04-1021', '23-5-2019'),
('tuo6', 'bps', 'female', '23-4-2120', '2-9-8712'),
('tuo7', 'bcom', 'male', '22-4-1998', '23-4-1234'),
('tuo9', 'nursing', 'female', '32-9-2019', '2-33-2018');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
