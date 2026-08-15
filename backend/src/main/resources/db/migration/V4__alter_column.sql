ALTER TABLE `users` RENAME COLUMN `name` TO `username`;
ALTER TABLE `users` ADD `password` VARCHAR(255) NULL;
ALTER TABLE `users` ADD `role` VARCHAR(255) NULL;