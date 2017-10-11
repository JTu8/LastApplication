-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 09.04.2017 klo 13:55
-- Palvelimen versio: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaharjoitustyö`
--

-- --------------------------------------------------------

--
-- Rakenne taululle `task`
--

CREATE TABLE `task` (
  `ID` bigint(20) UNSIGNED NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `Start` datetime DEFAULT NULL,
  `Stop` datetime DEFAULT NULL,
  `Description` varchar(255) NOT NULL,
  `Place` varchar(255) NOT NULL,
  `Reserved` varchar(50) DEFAULT 'Vapaa'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `task`
--

INSERT INTO `task` (`ID`, `UserID`, `Start`, `Stop`, `Description`, `Place`, `Reserved`) VALUES
(1, NULL, '2009-04-20 17:00:00', '2012-06-20 17:00:00', 'Huolto', 'Kuopio', NULL),
(2, NULL, '2010-04-20 17:00:00', '2015-07-20 17:00:00', 'Korjaus', 'Kuopio', NULL),
(3, NULL, '2012-05-20 17:00:00', '2001-06-20 17:00:00', 'Testi', 'Kuopio', NULL),
(4, NULL, '2014-06-20 17:00:00', '2013-07-20 17:00:00', 'Korjaus', 'Kuopio', NULL),
(5, NULL, '2013-05-20 17:00:00', '2017-05-20 17:00:00', 'Huolto', 'Kuopio', NULL),
(6, NULL, '2015-06-20 17:00:00', '2030-06-20 17:00:00', 'Korjaus', 'Kuopio', NULL),
(7, NULL, NULL, NULL, '', '', NULL),
(8, NULL, '2012-06-20 17:00:00', '2014-06-20 17:00:00', 'Korjaus', 'Kuopio', 'Vapaa');

-- --------------------------------------------------------

--
-- Rakenne taululle `user`
--

CREATE TABLE `user` (
  `ID` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Description` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `user`
--

INSERT INTO `user` (`ID`, `Name`, `Password`, `Description`) VALUES
(1, 'JTu', 'testi', 'testi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
