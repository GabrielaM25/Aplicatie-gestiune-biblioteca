-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: feb. 26, 2021 la 03:25 PM
-- Versiune server: 10.4.11-MariaDB
-- Versiune PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `date_proiect_ti_2020`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `aplicatie_biblioteca`
--

CREATE TABLE `aplicatie_biblioteca` (
  `autor` varchar(50) NOT NULL,
  `denumire` varchar(50) NOT NULL,
  `an_editare` int(5) NOT NULL,
  `cod_ISSN` varchar(30) NOT NULL,
  `format` varchar(10) NOT NULL,
  `cod_locatie` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `aplicatie_biblioteca`
--

INSERT INTO `aplicatie_biblioteca` (`autor`, `denumire`, `an_editare`, `cod_ISSN`, `format`, `cod_locatie`) VALUES
('MIRCEA BERTEA', 'Dictionar Englez-Roman, Roman-Englez', 2016, '9789975850506', 'A5', 'D2R17'),
('IOAN LAZARESCU', 'Dictionar roman-german / german-roman', 2004, '9789737485809', 'A5', 'D5R9'),
('ALEXANDRA MARTINI', 'On Time', 2011, '9763037680810', 'A4', 'LS23R6'),
('Malka Adler', 'Fratii de la Auschwitz', 2019, '9786060065043', 'A5', 'BL5R3'),
('DAN ARIELY', 'Decizii extraordinare', 2020, '9786067223996', 'A5', 'LU6R20'),
('IOAN ABRUDAN, SANDA BULGAREAN', 'Memorator de geografie pentru liceu', 2020, '9789734731916', 'A6', 'SR10R2'),
('MIHAI EMINESCU', 'Mihai Eminescu - Poezii', 2003, '9786060093084', 'A5', 'LR2R9');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
