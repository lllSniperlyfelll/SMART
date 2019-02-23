-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2019 at 08:19 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smart_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `smart_table`
--

CREATE TABLE `smart_table` (
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `age` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob_day` varchar(5) NOT NULL,
  `dob_month` varchar(60) NOT NULL,
  `dob_year` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `height` varchar(10) NOT NULL,
  `weight` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `smart_table`
--

INSERT INTO `smart_table` (`first_name`, `last_name`, `gender`, `age`, `email`, `dob_day`, `dob_month`, `dob_year`, `password`, `height`, `weight`) VALUES
('user', 'user1', 'Male', '21', 'something@example.com', '1', 'January', '2018', '123456', '123', '61'),
('user3', '', 'Male', '21', 'user3@exmaple.com', '1', 'January', '2018', '5665665', '', ''),
('user2', 'user', 'Female', '39', 'user@example.com', '22', 'May', '1995', '78494979', '191', '55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `smart_table`
--
ALTER TABLE `smart_table`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
