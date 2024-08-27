CREATE TABLE tasks_count(
	project_id INT NOT NULL PRIMARY KEY,
    task_amount INT,
    CONSTRAINT fk_task_project_id FOREIGN KEY (project_id) REFERENCES projects (id)
);