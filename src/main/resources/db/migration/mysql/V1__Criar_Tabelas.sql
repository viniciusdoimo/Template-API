CREATE TABLE `model_table` (
  `id` bigint(20) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `model_table`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `model_table`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

CREATE TABLE users (
    id bigint(20) PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    `surname` varchar(30) NOT NULL,
    `email` varchar(70) NOT NULL,
    `cpf` varchar(15) NOT NULL,
    `password` varchar(16) NOT NULL,
    `creation_date` datetime NOT NULL,
    `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;