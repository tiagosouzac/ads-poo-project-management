CREATE VIEW `project_team_members` AS
SELECT
    p.`id` AS `project_id`,
    p.`name` AS `project_name`,
    GROUP_CONCAT(DISTINCT t.`name` ORDER BY t.`name` SEPARATOR ', ') AS `team_names`,
    GROUP_CONCAT(DISTINCT m.`name` ORDER BY m.`name` SEPARATOR ', ') AS `member_names`
FROM
    `projects` p
    LEFT JOIN `teams` t ON p.`id` = t.`project_id`
    LEFT JOIN `members` m ON t.`id` = m.`team_id`
GROUP BY
    p.`id`, p.`name`;