-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Jan 11, 2023 at 06:11 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hrmanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `developer`
--

CREATE TABLE `developer` (
  `id` int(11) NOT NULL,
  `developer_language` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `developer`
--

INSERT INTO `developer` (`id`, `developer_language`) VALUES
(51, 'Java'),
(52, 'Kotlin'),
(53, 'Kotlin'),
(54, 'PHP'),
(55, 'JavaScript');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `employee_first_name` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `employee_last_name` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `employee_salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `employee_first_name`, `employee_last_name`, `employee_salary`) VALUES
(51, 'Minh', 'Le', 1000000),
(52, 'Tuan', 'Le', 2000000),
(53, 'Binh', 'Le', 3000000),
(54, 'Vy', 'Le', 4000000),
(55, 'Nam', 'Le', 5000000),
(56, 'Ngoc', 'Tran', 1000000),
(57, 'Dung', 'Thong', 2000000),
(58, 'Nhu', 'Hoang', 3000000),
(59, 'Lien', 'Trinh', 4000000),
(60, 'Thuy', 'Vo', 5000000);

-- --------------------------------------------------------

--
-- Table structure for table `tester`
--

CREATE TABLE `tester` (
  `id` int(11) NOT NULL,
  `is_automated` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `tester`
--

INSERT INTO `tester` (`id`, `is_automated`) VALUES
(56, 0),
(57, 1),
(58, 1),
(59, 0),
(60, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `developer`
--
ALTER TABLE `developer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tester`
--
ALTER TABLE `tester`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `developer`
--
ALTER TABLE `developer`
  ADD CONSTRAINT `developer_ibfk_1` FOREIGN KEY (`id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `tester`
--
ALTER TABLE `tester`
  ADD CONSTRAINT `tester_ibfk_1` FOREIGN KEY (`id`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
