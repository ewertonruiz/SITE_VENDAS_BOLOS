-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Mar-2023 às 03:56
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bolos_caseiros_2023`
--
CREATE DATABASE IF NOT EXISTS `bolos_caseiros_2023` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bolos_caseiros_2023`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `bolo`
--

CREATE TABLE `bolo` (
  `bolo_id` bigint(20) NOT NULL,
  `bolo_sabor_receita_fk` bigint(20) NOT NULL,
  `bolo_sabor_recheio_receita_fk` bigint(20) NOT NULL,
  `bolo_cobertura_receita_fk` bigint(20) NOT NULL,
  `bolo_tamanho` varchar(255) NOT NULL,
  `bolo_produto_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `cliente_id` bigint(20) NOT NULL,
  `cliente_user_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `enderco_id` bigint(20) NOT NULL,
  `endereco_logradouro` varchar(255) NOT NULL,
  `endereco_bairro` varchar(255) NOT NULL,
  `endereco_numero` int(11) NOT NULL,
  `endereco_completo` varchar(255) NOT NULL,
  `endereco_user_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `igrediente`
--

CREATE TABLE `igrediente` (
  `igrediente_id` bigint(20) NOT NULL,
  `igrediente_nome` varchar(255) NOT NULL,
  `igrediente_descricao` varchar(255) NOT NULL,
  `igrediente_preco` double NOT NULL,
  `igrediente_unidade_medida_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `produto_id` bigint(20) NOT NULL,
  `produto_nome` varchar(255) NOT NULL,
  `produto_descrição` varchar(255) NOT NULL,
  `produto_custo` double NOT NULL,
  `produto_preco` double NOT NULL,
  `produto_lucro` double DEFAULT NULL,
  `produto_tipo_produto_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `receita`
--

CREATE TABLE `receita` (
  `receita_id` bigint(20) NOT NULL,
  `receita_modo_preparo_nome` varchar(255) NOT NULL,
  `receita_custo` double NOT NULL,
  `receita_tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `receita_igrediente`
--

CREATE TABLE `receita_igrediente` (
  `receita_igrediente_id` bigint(20) NOT NULL,
  `receita_igrediente_quantidade` double NOT NULL,
  `receita_igrediente_receita_fk` bigint(20) NOT NULL,
  `receita_igrediente_igrediente_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_produto`
--

CREATE TABLE `tipo_produto` (
  `tipo_produto_id` bigint(20) NOT NULL,
  `tipo_produto_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `tipo_usuario_id` bigint(20) NOT NULL,
  `tipo_usuario_nome` varchar(255) NOT NULL,
  `cliente_user_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidade_medida`
--

CREATE TABLE `unidade_medida` (
  `unidade_medida_id` bigint(20) NOT NULL,
  `unidade_medida_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `user_id` bigint(20) NOT NULL,
  `user_login` varchar(255) NOT NULL,
  `user_senha` varchar(255) NOT NULL,
  `user_nome` varchar(255) NOT NULL,
  `user_celular` varchar(20) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_whatsapp` varchar(20) NOT NULL,
  `user_tipo_user_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `venda_id` bigint(20) NOT NULL,
  `venda_valor_total` double NOT NULL,
  `venda_lucro` double NOT NULL,
  `venda_data` date NOT NULL,
  `venda_vendedor_fk` bigint(20) NOT NULL,
  `venda_cliente_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda_produto`
--

CREATE TABLE `venda_produto` (
  `venda_produto_venda_fk` bigint(20) NOT NULL,
  `venda_produto_produto_fk` bigint(20) NOT NULL,
  `venda_produto_quantidade` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor`
--

CREATE TABLE `vendedor` (
  `vendedor_id` bigint(20) NOT NULL,
  `vendedor_user_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `bolo`
--
ALTER TABLE `bolo`
  ADD PRIMARY KEY (`bolo_id`),
  ADD KEY `bolo_sabor_receita_fk` (`bolo_sabor_receita_fk`),
  ADD KEY `bolo_sabor_recheio_receita_fk` (`bolo_sabor_recheio_receita_fk`),
  ADD KEY `bolo_cobertura_receita_fk` (`bolo_cobertura_receita_fk`),
  ADD KEY `bolo_produto_fk` (`bolo_produto_fk`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cliente_id`),
  ADD KEY `cliente_user_fk` (`cliente_user_fk`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`enderco_id`),
  ADD KEY `endereco_user_fk` (`endereco_user_fk`);

--
-- Índices para tabela `igrediente`
--
ALTER TABLE `igrediente`
  ADD PRIMARY KEY (`igrediente_id`),
  ADD KEY `igrediente_unidade_medida_fk` (`igrediente_unidade_medida_fk`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`produto_id`),
  ADD KEY `produto_tipo_produto_fk` (`produto_tipo_produto_fk`);

--
-- Índices para tabela `receita`
--
ALTER TABLE `receita`
  ADD PRIMARY KEY (`receita_id`);

--
-- Índices para tabela `receita_igrediente`
--
ALTER TABLE `receita_igrediente`
  ADD PRIMARY KEY (`receita_igrediente_id`),
  ADD KEY `receita_igrediente_receita_fk` (`receita_igrediente_receita_fk`),
  ADD KEY `receita_igrediente_igrediente_fk` (`receita_igrediente_igrediente_fk`);

--
-- Índices para tabela `tipo_produto`
--
ALTER TABLE `tipo_produto`
  ADD PRIMARY KEY (`tipo_produto_id`);

--
-- Índices para tabela `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`tipo_usuario_id`),
  ADD KEY `cliente_user_fk` (`cliente_user_fk`);

--
-- Índices para tabela `unidade_medida`
--
ALTER TABLE `unidade_medida`
  ADD PRIMARY KEY (`unidade_medida_id`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_tipo_user_fk` (`user_tipo_user_fk`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`venda_id`),
  ADD KEY `venda_vendedor_fk` (`venda_vendedor_fk`),
  ADD KEY `venda_cliente_fk` (`venda_cliente_fk`);

--
-- Índices para tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD KEY `venda_produto_venda_fk` (`venda_produto_venda_fk`),
  ADD KEY `venda_produto_produto_fk` (`venda_produto_produto_fk`);

--
-- Índices para tabela `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`vendedor_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bolo`
--
ALTER TABLE `bolo`
  MODIFY `bolo_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cliente_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `enderco_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `igrediente`
--
ALTER TABLE `igrediente`
  MODIFY `igrediente_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `produto_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `receita`
--
ALTER TABLE `receita`
  MODIFY `receita_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `receita_igrediente`
--
ALTER TABLE `receita_igrediente`
  MODIFY `receita_igrediente_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tipo_produto`
--
ALTER TABLE `tipo_produto`
  MODIFY `tipo_produto_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `tipo_usuario_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `unidade_medida`
--
ALTER TABLE `unidade_medida`
  MODIFY `unidade_medida_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `venda_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `vendedor_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `bolo`
--
ALTER TABLE `bolo`
  ADD CONSTRAINT `bolo_ibfk_1` FOREIGN KEY (`bolo_sabor_receita_fk`) REFERENCES `receita` (`receita_id`),
  ADD CONSTRAINT `bolo_ibfk_2` FOREIGN KEY (`bolo_sabor_recheio_receita_fk`) REFERENCES `receita` (`receita_id`),
  ADD CONSTRAINT `bolo_ibfk_3` FOREIGN KEY (`bolo_cobertura_receita_fk`) REFERENCES `receita` (`receita_id`),
  ADD CONSTRAINT `bolo_ibfk_4` FOREIGN KEY (`bolo_produto_fk`) REFERENCES `produto` (`produto_id`);

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`cliente_user_fk`) REFERENCES `usuario` (`user_id`);

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`endereco_user_fk`) REFERENCES `usuario` (`user_id`);

--
-- Limitadores para a tabela `igrediente`
--
ALTER TABLE `igrediente`
  ADD CONSTRAINT `igrediente_ibfk_1` FOREIGN KEY (`igrediente_unidade_medida_fk`) REFERENCES `unidade_medida` (`unidade_medida_id`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`produto_tipo_produto_fk`) REFERENCES `tipo_produto` (`tipo_produto_id`);

--
-- Limitadores para a tabela `receita_igrediente`
--
ALTER TABLE `receita_igrediente`
  ADD CONSTRAINT `receita_igrediente_ibfk_1` FOREIGN KEY (`receita_igrediente_receita_fk`) REFERENCES `receita` (`receita_id`),
  ADD CONSTRAINT `receita_igrediente_ibfk_2` FOREIGN KEY (`receita_igrediente_igrediente_fk`) REFERENCES `igrediente` (`igrediente_id`);

--
-- Limitadores para a tabela `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD CONSTRAINT `tipo_usuario_ibfk_1` FOREIGN KEY (`cliente_user_fk`) REFERENCES `usuario` (`user_id`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`user_tipo_user_fk`) REFERENCES `usuario` (`user_id`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`venda_vendedor_fk`) REFERENCES `vendedor` (`vendedor_id`),
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`venda_cliente_fk`) REFERENCES `cliente` (`cliente_id`);

--
-- Limitadores para a tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD CONSTRAINT `venda_produto_ibfk_1` FOREIGN KEY (`venda_produto_venda_fk`) REFERENCES `venda` (`venda_id`),
  ADD CONSTRAINT `venda_produto_ibfk_2` FOREIGN KEY (`venda_produto_produto_fk`) REFERENCES `produto` (`produto_id`);

--
-- Limitadores para a tabela `vendedor`
--
ALTER TABLE `vendedor`
  ADD CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`vendedor_id`) REFERENCES `usuario` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
