-- V2__insert_initial_data.sql
INSERT INTO `users` (`id`, `name`, `email`) VALUES
    (1, '管理者ユーザー', 'admin@example.com'),
    (2, '一般ユーザー', 'user@example.com');
--     ON DUPLICATE KEY UPDATE id=id; -- 重複エラーを防ぐ実務の知恵