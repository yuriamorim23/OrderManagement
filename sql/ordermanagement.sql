-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Ago-2022 às 17:50
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
(63, '126 Sidney Grove', 'yuri@gmaillll.com', 'Pedro Bolinha26', 'Martins', '7893256600', 'NE14EWN'),
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
(101);

-- --------------------------------------------------------

--
-- Estrutura da tabela `order_client`
--

CREATE TABLE `order_client` (
  `id` bigint(20) NOT NULL,
  `close_sold_date` datetime DEFAULT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `order_client`
--

INSERT INTO `order_client` (`id`, `close_sold_date`, `more_info`, `status`, `client_id`) VALUES
(91, '2022-08-10 16:10:29', 'Infoo222w', '1', NULL),
(93, '2022-08-11 12:07:33', 'Infoo222ww', '1', 7),
(94, '2022-08-11 12:28:27', 'Infoo2223', '0', 68),
(97, '2022-08-12 12:46:40', 'Infoo22234', '0', 3),
(100, '2022-08-12 12:52:08', 'Infoo34', '2', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `order_item`
--

CREATE TABLE `order_item` (
  `price` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `order_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `min_prince` double DEFAULT NULL,
  `stock_quantity` double DEFAULT NULL,
  `code` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `product`
--

INSERT INTO `product` (`id`, `description`, `min_prince`, `stock_quantity`, `code`, `price`) VALUES
(69, 'TV2', 30, 0, 1, 40),
(71, 'PC', 7, 10, 2, 8),
(72, 'Chair', 2, 10, 3, 3),
(77, 'Mouse', 0.1, 10, 4, 0.1),
(80, 'Keyboard', 0.1, 10, 5, 0.1),
(81, 'Mobile', 0.1, 10, 6, 0.1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_c1hgjta913nnj2efpl7pfm0be` (`first_name`);

--
-- Índices para tabela `order_client`
--
ALTER TABLE `order_client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_alruig4j063rdrtwib9jisw6g` (`more_info`),
  ADD KEY `FKi16gr0wu5yjr3gjfph4sr5ln3` (`client_id`);

--
-- Índices para tabela `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`order_id`),
  ADD UNIQUE KEY `UK_61dvm4p9kamoh183lj8a1jqex` (`price`);

--
-- Índices para tabela `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_q2n3melweyrl5d4rqkg7pq6ra` (`description`),
  ADD UNIQUE KEY `UK_h3w5r1mx6d0e5c6um32dgyjej` (`code`);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `order_client`
--
ALTER TABLE `order_client`
  ADD CONSTRAINT `FKi16gr0wu5yjr3gjfph4sr5ln3` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

--
-- Limitadores para a tabela `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `FK5dojljkm6lipf2hw3su7ylqlx` FOREIGN KEY (`order_id`) REFERENCES `order_client` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
