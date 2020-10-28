-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2020 at 05:45 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_rekayasasistem`
--
CREATE DATABASE IF NOT EXISTS `db_rekayasasistem` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_rekayasasistem`;

-- --------------------------------------------------------

--
-- Table structure for table `tb_siswa`
--

CREATE TABLE IF NOT EXISTS `tb_siswa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noinduk` int(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tanggallahir` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jeniskelamin` varchar(20) NOT NULL,
  `gambar` varchar(200) DEFAULT NULL,
  `notelp` int(20) NOT NULL,
  `namawali` varchar(50) NOT NULL,
  `sekolahasal` varchar(50) NOT NULL,
  `tempatlahir` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `tb_siswa`
--

INSERT INTO `tb_siswa` (`id`, `noinduk`, `nama`, `tanggallahir`, `alamat`, `jeniskelamin`, `gambar`, `notelp`, `namawali`, `sekolahasal`, `tempatlahir`) VALUES
(2, 1831142, 'michael', '2000-04-20', 'penuin center', 'male', NULL, 8124124, 'akam', 'kaam', 'indonesis'),
(3, 1831143, 'michael', '2000-03-12', 'aa', 'bb', NULL, 3120, 'jajaj', 'kdsksdk', 'dskals'),
(4, 1831143, '', '2000-02-11', 'hihi', 'haha ', NULL, 392932, 'hehe', 'haha', 'haha'),
(6, 1831143, '', '2000-02-11', 'hihi', 'haha ', NULL, 392932, 'hehe', 'haha', 'haha'),
(7, 1831143, 'juken', '2000-02-11', 'hihi', 'haha ', NULL, 392932, 'hehe', 'haha', 'haha'),
(8, 1831143, 'juken', '2000-02-11', 'hihi', 'haha ', NULL, 392932, 'hehe', 'haha', 'haha'),
(9, 1831143, 'juken', '2000-02-11', 'hihi', 'haha ', NULL, 392932, 'hehe', 'haha', 'haha'),
(10, 1831147, 'haha', '2000-02-11', 'hehe', 'hehe', NULL, 38238, 'hoho', 'haha', 'huhu');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
