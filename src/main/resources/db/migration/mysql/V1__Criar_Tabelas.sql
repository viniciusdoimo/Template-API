CREATE TABLE `model_table` (
  `id` bigint(20) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `model_table`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `model_table`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;