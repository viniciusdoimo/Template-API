CREATE TABLE users (
    id bigint(20) PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    `surname` varchar(30) NOT NULL,
    `email` varchar(70) NOT NULL,
    `cpf` varchar(15) NOT NULL,
    `password` varchar(255) NOT NULL,
    `creation_date` datetime NOT NULL,
    `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;