/*CREATE USER 'root'@'%' identified by 'root';*/


CREATE DATABASE `crud_api_server`;



CREATE TABLE `crud_api_server`.`board` (
                         `id` mediumint(9) NOT NULL AUTO_INCREMENT,
                         `title` varchar(100) NOT NULL,
                         `content` text NOT NULL,
                         `writer_id` int(8) NOT NULL,
                         `crt_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                         `mod_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



INSERT INTO crud_api_server.board (title, content, writer_id) VALUES('title_test', 'content_test', 1);
