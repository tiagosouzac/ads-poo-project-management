CREATE TABLE IF NOT EXISTS `teams` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `project_id` INT,
    `name` VARCHAR(255) NOT NULL,
    `description` TEXT,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
);
