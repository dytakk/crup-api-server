/*CREATE USER 'root'@'%' identified by 'root';*/


CREATE DATABASE `crud_api_server`;



CREATE TABLE `crud_api_server`.`board` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `title` varchar(100) NOT NULL,
                         `content` text NOT NULL,
                         `writer_id` int(8) NOT NULL,
                         `crt_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                         `mod_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO crud_api_server.board (title, content, writer_id) VALUES('title_test', 'content_test', 1);

CREATE TABLE `member` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `username` varchar(50) NOT NULL,
                          `password` varchar(100) DEFAULT NULL,
                          `name` varchar(12) DEFAULT NULL,
                          `grade` char(1) DEFAULT NULL,
                          `mail_address` varchar(100) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `member_UN` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO crud_api_server.member (username, name) VALUES('test_id', '테스트이름');
