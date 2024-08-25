CREATE TABLE `tasks` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `project_id` INT,
    `description` TEXT,
    `status` ENUM('PENDING', 'IN_PROGRESS', 'FINISHED') NOT NULL,
    `completion_date` DATE,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_project_task_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
);
