DELIMITER //
CREATE TRIGGER create_task_count
AFTER INSERT ON projects
FOR EACH ROW
BEGIN
    INSERT INTO tasks_count(project_id, task_amount)
    VALUES(NEW.`id`, 0);
END;
//
DELIMITER ;