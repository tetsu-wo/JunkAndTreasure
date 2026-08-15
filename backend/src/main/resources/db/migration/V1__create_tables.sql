-- V1__create_tables.sql
CREATE TABLE IF NOT EXISTS `users` (
    `id` SERIAL PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) UNIQUE NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS `product` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(255) NOT NULL,
   `price` INT NOT NULL,
   PRIMARY KEY (`id`)
    );

