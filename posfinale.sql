-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 25, 2023 at 04:45 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posfinale`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ID` int(10) UNSIGNED NOT NULL,
  `QR` int(20) UNSIGNED NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  `BaseOfMeasure` tinyint(3) UNSIGNED NOT NULL,
  `Stock` double DEFAULT 0,
  `Cost` double NOT NULL,
  `Supplier` text DEFAULT NULL,
  `Description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ID`, `QR`, `Name`, `Price`, `BaseOfMeasure`, `Stock`, `Cost`, `Supplier`, `Description`) VALUES
(1, 0, 'milk', 65, 0, -9, 50, 'Maliban', ''),
(2, 1, 'Butter', 135, 0, 295, 120, 'Anchor', ''),
(3, 11, 'Maggie', 75, 0, 0, 55, 'Maggie', ''),
(4, 111, 'Coca Cola 50ml', 55, 0, 0, 45, 'Coke', ''),
(5, 1111, 'Coca cola 100ml', 110, 0, 0, 100, 'Coke', ''),
(6, 1000, 'Soya meat', 80, 0, 0, 65, 'Lanka Soy', ''),
(7, 1100, 'Butter Cake', 150, 1, 0, 100, 'Bakehouse', ''),
(8, 1110, 'Chcolate Cake', 250, 1, 0, 200, 'Bakehouse', ''),
(9, 1010, 'Fresh Milk 500ml', 230, 0, 0, 170, 'Anchor', ''),
(10, 1011, 'Chicken', 650, 1, 0, 500, 'Maxies', ''),
(11, 1101, 'Ham', 750, 1, 0, 700, 'Maxies', ''),
(12, 1001, 'Bread', 65, 0, 0, 50, 'Bakehouse', '');

-- --------------------------------------------------------

--
-- Table structure for table `saleproduct`
--

CREATE TABLE `saleproduct` (
  `ID` int(10) UNSIGNED NOT NULL,
  `SaleID` int(10) UNSIGNED NOT NULL,
  `ProID` int(10) UNSIGNED NOT NULL,
  `Price` double NOT NULL,
  `QTY` double NOT NULL,
  `NetAmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saleproduct`
--

INSERT INTO `saleproduct` (`ID`, `SaleID`, `ProID`, `Price`, `QTY`, `NetAmount`) VALUES
(1, 5, 4, 55, 1, 55),
(2, 5, 3, 75, 1, 75),
(3, 5, 1, 65, 1, 65),
(4, 6, 9, 230, 1, 230),
(5, 7, 9, 230, 1, 230),
(6, 8, 5, 110, 2, 220),
(7, 8, 2, 135, 1, 135),
(8, 8, 6, 80, 1, 80),
(9, 9, 1, 65, 1, 65);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Invoice` int(10) UNSIGNED NOT NULL,
  `Cashier` varchar(45) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Amount` double NOT NULL,
  `Discount` double NOT NULL,
  `NetTotal` double NOT NULL,
  `ProductCost` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ID`, `Invoice`, `Cashier`, `Date`, `Time`, `Amount`, `Discount`, `NetTotal`, `ProductCost`) VALUES
(1, 1, 'dfhgfd', '2021-09-08', '10:35:00', 3543536, 3553, 355, 545),
(2, 2, '', '2021-11-04', '22:33:28', 0, 0, 0, 0),
(3, 3, '', '2021-11-04', '23:09:55', 175, 0, 175, 150),
(4, 4, '', '2021-11-04', '23:09:56', 175, 0, 175, 150),
(5, 5, '', '2021-11-04', '23:11:44', 195, 0, 195, 150),
(6, 6, '', '2021-11-04', '23:12:58', 230, 0, 230, 170),
(7, 7, '', '2021-11-04', '23:14:58', 230, 0, 230, 170),
(8, 8, 'Gihon', '2021-11-07', '23:30:43', 435, 10, 425, 285),
(9, 9, 'Gihon', '2021-11-09', '00:56:23', 65, 0, 65, 50);

-- --------------------------------------------------------

--
-- Table structure for table `shopdetails`
--

CREATE TABLE `shopdetails` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `PhoneNumber` int(10) UNSIGNED NOT NULL,
  `Status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopdetails`
--

INSERT INTO `shopdetails` (`ID`, `Name`, `Address`, `PhoneNumber`, `Status`) VALUES
(1, 'Store Name', '123 Katubedda Moratuwa', 70123456, 1);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `ID` int(10) UNSIGNED NOT NULL,
  `ProId` int(10) UNSIGNED NOT NULL,
  `Stock` double NOT NULL,
  `Description` text NOT NULL,
  `DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`ID`, `ProId`, `Stock`, `Description`, `DATE`) VALUES
(1, 2, 100, 'new Stock', '2021-11-07'),
(2, 2, 100, 'New Stock', '2021-11-09'),
(3, 2, 100, 'new stock', '2021-11-09');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Role` varchar(45) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Gender` tinyint(1) NOT NULL,
  `Contact` int(10) UNSIGNED NOT NULL,
  `CreatedDate` date NOT NULL,
  `CreatedTime` time NOT NULL,
  `Password` text NOT NULL,
  `UserName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `Role`, `FirstName`, `LastName`, `Gender`, `Contact`, `CreatedDate`, `CreatedTime`, `Password`, `UserName`) VALUES
(1, 'Admin', 'Gihon', 'Diraj', 1, 702221756, '2021-11-30', '10:39:00', '123', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `saleproduct`
--
ALTER TABLE `saleproduct`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `shopdetails`
--
ALTER TABLE `shopdetails`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `saleproduct`
--
ALTER TABLE `saleproduct`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `shopdetails`
--
ALTER TABLE `shopdetails`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
