-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18.04.2017 klo 11:58
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
-- Rakenne taululle `reserved`
--

CREATE TABLE `reserved` (
  `ID` bigint(20) UNSIGNED NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `Start` datetime DEFAULT NULL,
  `Stop` datetime DEFAULT NULL,
  `Description` varchar(255) NOT NULL,
  `Place` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `reserved`
--

INSERT INTO `reserved` (`ID`, `UserID`, `Start`, `Stop`, `Description`, `Place`) VALUES
(36, 1, '2017-04-18 00:00:00', '2017-04-24 00:00:00', 'Haravointi', 'Sarkamäki'),
(37, 1, '2017-04-20 17:00:00', '2001-06-20 17:00:00', 'Huoltotyö', 'Kuopio'),
(40, NULL, '2017-04-18 00:00:00', '2017-04-19 00:00:00', 'Aidan maalaus', 'Sarkamäki');

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
  `Place` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
(1, 'JTu', 'testi', 'testi'),
(2, 'Testi', 'testi', 'testi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reserved`
--
ALTER TABLE `reserved`
  ADD PRIMARY KEY (`ID`);

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
-- AUTO_INCREMENT for table `reserved`
--
ALTER TABLE `reserved`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
