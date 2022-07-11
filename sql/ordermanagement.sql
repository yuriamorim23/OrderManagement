-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11-Jul-2022 às 18:13
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ordermanagement`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `client`
--

INSERT INTO `client` (`id`, `address`, `email`, `first_name`, `last_name`, `phone_number`, `post_code`) VALUES
(3, '250 Sidney Grove', 'yuri@hotmail.com', 'Boraaa Calixto', 'Amorim', '7893256688', 'NE200'),
(4, '116 Sidney Grove', 'yuri@gmail.com', 'Boa Calixto', 'Amorim', '7893256688', 'NE14EWN'),
(5, '116 Sidney Grove', 'yuri@gmail.com', 'Yuri Calixto', 'Amorim', '7893256688', 'NE14EWN'),
(6, '116 Sidney Grove', 'yuri@gmail.com', 'Euu Calixto', 'Amorim', '7893256688', 'NE14EWN'),
(7, '116 Sidney Grove', 'yuri@gmail.com', 'Modificando Calixto', 'Amorim', '7893256688', 'NE14EWN'),
(8, '116 Sidney Grove', 'yuri@gmail.com', 'Joao Calixto', 'Amorim', '7893256688', 'NE14EWN'),
(10, '116 Sidney Grove', 'yuri@gmail.com', 'Joaooo Calixto', 'Amorim', '7893256688', 'NE14EWN'),
(14, '116 Sidney Grove', 'yuri@gmail.com', 'Joao Calixaaaato', 'Amorim', '7893256688', 'NE14EWN'),
(15, '116 Sidney Grove', 'yuri@gmail.com', 'Joao Caaato', 'Amorim', '7893256688', 'NE14EWN'),
(16, '116 Sidney Grove', 'yuri@gmail.com', 'Joao Caaaeeto', 'Amorim', '7893256688', 'NE14EWN'),
(18, '116 Sidney Grove', 'yuri@gmail.com', 'Joao Baaeeto', 'Amorim', '7893256688', 'NE14EWN'),
(19, '116 Sidney Grove', 'yuri@gmail.com', 'Joao Yeeto', 'Amorim', '7893256688', 'NE14EWN'),
(20, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Yeeto', 'Martins', '7893256688', 'NE14EWN'),
(27, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Peetooo', 'Martins', '7893256688', 'NE14EWN'),
(34, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha', 'Martins', '7893256688', 'NE14EWN'),
(35, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha2', 'Martins', '7893256688', 'NE14EWN'),
(41, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha3', 'Martins', '7893256688', 'NE14EWN'),
(44, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha4', 'Martins', '7893256688', 'NE14EWN'),
(47, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha6', 'Martins', '7893256688', 'NE14EWN'),
(49, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha8', 'Martins', '7893256688', 'NE14EWN'),
(51, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha10', 'Martins', '7893256688', 'NE14EWN'),
(56, '116 Sidney Grove', 'yuri@gmail.com', 'Pedro Bolinha13', 'Martins', '7893257799', 'NE14EWN'),
(57, '126 Sidney Grove', 'yuri@gmaillll.com', 'Pedro Bolinha22', 'Martins', '7893256600', 'NE14EWN'),
(58, '126 Sidney Grove', 'yuri@gmaillll.com', 'Pedro Bolinha23', 'Martins', '7893256600', 'NE14EWN'),
(63, '126 Sidney Grove', 'yuri@gmaillll.com', 'Pedro Bolinha26', 'Martins', '7893256600', 'NE14EWN'),
(66, '126 Sidney Grove', 'yuri@gmaillll.com', 'Pedro Bolinha27', 'Martins', '7893256600', 'NE14EWN'),
(68, '126 Sidney Grove', 'yuri@gmaillll.com', 'Pedro Bolinha28', 'Martins', '7893256600', 'NE14EWN');

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(69);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_c1hgjta913nnj2efpl7pfm0be` (`first_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
