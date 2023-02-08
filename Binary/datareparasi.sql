-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 28, 2023 at 04:46 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datareparasi`
--

-- --------------------------------------------------------

--
-- Table structure for table `barangdb`
--

CREATE TABLE `barangdb` (
  `ID_BARANG` int(11) NOT NULL,
  `namabarang` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `garansi` varchar(25) NOT NULL,
  `waktu` date NOT NULL,
  `keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barangdb`
--

INSERT INTO `barangdb` (`ID_BARANG`, `namabarang`, `jumlah`, `harga`, `garansi`, `waktu`, `keterangan`) VALUES
(3, 'RAM', 10, 800000, '1 Tahun', '2022-08-27', 'none'),
(4, 'MOUSE', 3, 30000, '1 bulan', '2022-08-27', 'none'),
(5, 'MONITOR', 6, 1500000, '1 Tahun', '2022-08-27', 'asdas'),
(6, 'TINTA', 0, 50000, '3 BULAN', '2022-09-06', 'NONE'),
(9, 'Mousepad', 2, 50000, '3 bulan', '2022-09-09', 'NONE'),
(10, 'CATRIDGE', 2, 20000, '3 BULAN', '2022-10-17', 'ASDASDASD'),
(11, 'mousepad', 2, 20000, '2 bulan', '2023-01-28', 'aaaaa');

-- --------------------------------------------------------

--
-- Table structure for table `bulan`
--

CREATE TABLE `bulan` (
  `IDBULAN` varchar(11) NOT NULL,
  `BULAN` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bulan`
--

INSERT INTO `bulan` (`IDBULAN`, `BULAN`) VALUES
('01', 'JANUARI'),
('02', 'FEBRUARI'),
('03', 'MARET');

-- --------------------------------------------------------

--
-- Table structure for table `diagnosa`
--

CREATE TABLE `diagnosa` (
  `no` int(11) NOT NULL,
  `keluhan` varchar(27) NOT NULL,
  `harga` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diagnosa`
--

INSERT INTO `diagnosa` (`no`, `keluhan`, `harga`) VALUES
(1, 'REPARASI WIN 11', 60000),
(2, 'REPARASI WIN 8', 80000);

-- --------------------------------------------------------

--
-- Table structure for table `masukmemasuk`
--

CREATE TABLE `masukmemasuk` (
  `NO` int(11) NOT NULL,
  `ID_PELANGGAN` int(11) NOT NULL,
  `NOSERI` varchar(11) NOT NULL,
  `JENIS` varchar(11) NOT NULL,
  `KELENGKAPAN` varchar(11) NOT NULL,
  `MEREK` varchar(11) NOT NULL,
  `KELUHAN` text NOT NULL,
  `HARGADIAGNOSA` bigint(12) NOT NULL,
  `APLIKASI` varchar(24) NOT NULL,
  `HARGAAPLIKASI` bigint(12) NOT NULL,
  `STATUS` varchar(25) NOT NULL,
  `CATATAN` text NOT NULL,
  `WAKTU` date DEFAULT NULL,
  `TOTALHARGA` bigint(12) NOT NULL,
  `CODE` varchar(25) NOT NULL,
  `USER` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `masukmemasuk`
--

INSERT INTO `masukmemasuk` (`NO`, `ID_PELANGGAN`, `NOSERI`, `JENIS`, `KELENGKAPAN`, `MEREK`, `KELUHAN`, `HARGADIAGNOSA`, `APLIKASI`, `HARGAAPLIKASI`, `STATUS`, `CATATAN`, `WAKTU`, `TOTALHARGA`, `CODE`, `USER`) VALUES
(43, 2, 'asd111', 'Printer', 'asaaaaaa', 'asdadad', 'REPARASI WIN 11', 60000, 'adasd', 40000, 'PROSES', 'adsasdasd', '2022-10-25', 100000, '2RV25102022', 'dayat'),
(44, 1, '23edasd3q', 'Laptop', 'chargeer', 'ASUS', 'REPARASI WIN 8', 80000, 'corel draw', 40000, 'PROSES', 'ssssss', '2022-10-26', 100000, '1RV26102022', 'dayat');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `ID_PELANGGAN` int(11) NOT NULL,
  `NAMA` varchar(30) NOT NULL,
  `NOHP` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`ID_PELANGGAN`, `NAMA`, `NOHP`) VALUES
(1, 'DAYAT', '082292214605'),
(2, 'RULI AMRI', '09282937474'),
(26, 'DAYAT', '082292214605');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `NO` int(11) NOT NULL,
  `ID_PELANGGAN` int(11) NOT NULL,
  `ID_BARANG` int(11) NOT NULL,
  `JUMLAH` int(30) NOT NULL,
  `WAKTU` date NOT NULL,
  `HARGA` bigint(11) NOT NULL,
  `TOTAL` int(11) NOT NULL,
  `BAYAR` int(20) NOT NULL,
  `KEMBALIAN` int(20) NOT NULL,
  `GARANSI` varchar(30) NOT NULL,
  `CODE` varchar(24) NOT NULL,
  `USER` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`NO`, `ID_PELANGGAN`, `ID_BARANG`, `JUMLAH`, `WAKTU`, `HARGA`, `TOTAL`, `BAYAR`, `KEMBALIAN`, `GARANSI`, `CODE`, `USER`) VALUES
(68, 2, 3, 2, '2022-09-11', 800000, 1600000, 10000000, 8400000, '1 Tahun', '2PB11092022', 'dayat'),
(73, 2, 6, 2, '2022-09-13', 50000, 100000, 100000, 0, '3 BULAN', '2PB13092022', 'dayat');

--
-- Triggers `pembelian`
--
DELIMITER $$
CREATE TRIGGER `kurangan` AFTER INSERT ON `pembelian` FOR EACH ROW BEGIN
 UPDATE barangdb SET jumlah = jumlah-NEW.JUMLAH
 WHERE ID_BARANG = NEW.ID_BARANG;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `menambah` AFTER DELETE ON `pembelian` FOR EACH ROW BEGIN
 UPDATE barangdb SET jumlah = jumlah + OLD.JUMLAH
 WHERE ID_BARANG = OLD.ID_BARANG;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `perjanjian`
--

CREATE TABLE `perjanjian` (
  `PERJANJIAN` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `perjanjian`
--

INSERT INTO `perjanjian` (`PERJANJIAN`) VALUES
('1. Pelanggan wajib membackup data terlebih dahulu\r\n ');

-- --------------------------------------------------------

--
-- Table structure for table `transaksibarangkeluar`
--

CREATE TABLE `transaksibarangkeluar` (
  `NO` int(11) NOT NULL,
  `KODE` varchar(11) NOT NULL,
  `NAMA` varchar(255) NOT NULL,
  `TOTAL` mediumint(25) NOT NULL,
  `BAYAR` mediumint(11) NOT NULL,
  `KEMBALIAN` mediumint(25) NOT NULL,
  `WAKTU` date NOT NULL,
  `USER` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksibarangkeluar`
--

INSERT INTO `transaksibarangkeluar` (`NO`, `KODE`, `NAMA`, `TOTAL`, `BAYAR`, `KEMBALIAN`, `WAKTU`, `USER`) VALUES
(26, '3RV7092022', 'RULI AMRI', 100000, 1200000, 1100000, '2022-09-11', 'dayat'),
(27, '1RV11092022', 'DAYAT', 100000, 120000, 20000, '2022-09-11', 'dayat');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `IDUSER` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `nohp` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `level` enum('PEMILIK','KARYAWAN') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`IDUSER`, `username`, `nohp`, `pass`, `level`) VALUES
(20, 'dayat', '082292214', 'dayat', 'PEMILIK');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barangdb`
--
ALTER TABLE `barangdb`
  ADD PRIMARY KEY (`ID_BARANG`);

--
-- Indexes for table `bulan`
--
ALTER TABLE `bulan`
  ADD PRIMARY KEY (`IDBULAN`);

--
-- Indexes for table `diagnosa`
--
ALTER TABLE `diagnosa`
  ADD PRIMARY KEY (`no`);

--
-- Indexes for table `masukmemasuk`
--
ALTER TABLE `masukmemasuk`
  ADD PRIMARY KEY (`NO`),
  ADD KEY `ID_PELANGGAN` (`ID_PELANGGAN`),
  ADD KEY `CODE` (`CODE`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`ID_PELANGGAN`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`NO`),
  ADD KEY `ID_PELANGGAN` (`ID_PELANGGAN`),
  ADD KEY `ID_BARANG` (`ID_BARANG`);

--
-- Indexes for table `perjanjian`
--
ALTER TABLE `perjanjian`
  ADD UNIQUE KEY `PERJANJIAN` (`PERJANJIAN`) USING HASH;

--
-- Indexes for table `transaksibarangkeluar`
--
ALTER TABLE `transaksibarangkeluar`
  ADD PRIMARY KEY (`NO`),
  ADD UNIQUE KEY `KODE` (`KODE`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`IDUSER`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barangdb`
--
ALTER TABLE `barangdb`
  MODIFY `ID_BARANG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `diagnosa`
--
ALTER TABLE `diagnosa`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `masukmemasuk`
--
ALTER TABLE `masukmemasuk`
  MODIFY `NO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `ID_PELANGGAN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `NO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT for table `transaksibarangkeluar`
--
ALTER TABLE `transaksibarangkeluar`
  MODIFY `NO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `IDUSER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `masukmemasuk`
--
ALTER TABLE `masukmemasuk`
  ADD CONSTRAINT `masukmemasuk_ibfk_1` FOREIGN KEY (`ID_PELANGGAN`) REFERENCES `pelanggan` (`ID_PELANGGAN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`ID_PELANGGAN`) REFERENCES `pelanggan` (`ID_PELANGGAN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`ID_BARANG`) REFERENCES `barangdb` (`ID_BARANG`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
