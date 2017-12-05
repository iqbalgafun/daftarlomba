-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06 Des 2017 pada 00.05
-- Versi Server: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pendaftaran`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendaftar`
--

CREATE TABLE IF NOT EXISTS `pendaftar` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `ttl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pendaftar`
--

INSERT INTO `pendaftar` (`id`, `nama`, `alamat`, `ttl`) VALUES
(1, 'Iqbal Fauzi P', 'Madiun', '1997-06-21');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendaftaran`
--

CREATE TABLE IF NOT EXISTS `pendaftaran` (
  `pid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `description` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pendaftaran`
--

INSERT INTO `pendaftaran` (`pid`, `name`, `email`, `description`, `created_at`, `updated_at`) VALUES
(1, 'Iqbal Fauzi P', 'iqbalgafun@gmail.com', 'Berat sekali cobaan hidup ini', '2017-11-07 17:20:16', '0000-00-00 00:00:00'),
(2, 'Reza Ulul', 'reza@gmail.com', 'tes', '2017-11-08 03:56:46', '0000-00-00 00:00:00'),
(3, 'Andik', 'andi@gmail.com', 'bismillah', '2017-12-05 07:38:04', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `perlombaan`
--

CREATE TABLE IF NOT EXISTS `perlombaan` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `cabang` varchar(50) NOT NULL,
  `tgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `perlombaan`
--

INSERT INTO `perlombaan` (`id`, `nama`, `cabang`, `tgl`) VALUES
(1, 'Iqbal Fauzi P', 'Lari', '2017-12-20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pendaftar`
--
ALTER TABLE `pendaftar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `perlombaan`
--
ALTER TABLE `perlombaan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
