/*CREATE USER 'root'@'%' identified by 'root';*/


CREATE DATABASE `crud_api_server`;



CREATE TABLE `board` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `title` varchar(100) NOT NULL,
                         `content` text NOT NULL,
                         `writer_id` bigint(20) NOT NULL,
                         `crt_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
                         `mod_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `comment` (
                           `id` mediumint(9) NOT NULL AUTO_INCREMENT,
                           `writer_id` mediumint(9) NOT NULL,
                           `content` text DEFAULT NULL,
                           `crt_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
                           `mod_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
                           `board_id` bigint(20) NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `comment_FK` (`board_id`),
                           CONSTRAINT `comment_FK` FOREIGN KEY (`board_id`) REFERENCES `board` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;