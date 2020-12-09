CREATE TABLE `tabela` (
  `id` bigint(20) NOT NULL,
  `mensagem` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `tabela`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `tabela`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  