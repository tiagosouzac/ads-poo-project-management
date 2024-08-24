CREATE TABLE IF NOT EXISTS `members` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `team_id` INT,
    `name` VARCHAR(255) NOT NULL,
    `role` ENUM('DEVELOPER', 'DESIGNER', 'MANAGER') NOT NULL,
    CONSTRAINT `fk_team_id` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`)
);
