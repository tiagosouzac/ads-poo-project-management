CREATE TABLE `comments` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `task_id` INT NOT NULL,
    `member_id` INT NOT NULL,
    `text` TEXT,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
    CONSTRAINT	`fk_member_id` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`)
);
