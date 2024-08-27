DELIMITER //
CREATE TRIGGER update_task_count
AFTER INSERT ON tasks
FOR EACH ROW
BEGIN
    DECLARE task_count INT;
    SELECT task_amount INTO task_count FROM tasks_count WHERE project_id = NEW.project_id;
    UPDATE tasks_count
    SET task_amount = task_count + 1
    WHERE project_id = NEW.project_id;
END;
//
DELIMITER ;