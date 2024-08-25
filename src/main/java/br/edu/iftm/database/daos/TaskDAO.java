package br.edu.iftm.database.daos;

import java.util.Date;
import java.util.List;

import br.edu.iftm.database.Database;
import br.edu.iftm.database.mappers.TaskMapper;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.database.models.Task.Status;

public class TaskDAO {
    private final Database database = new Database();

    public boolean store(int projectId, String description, Date completionDate) {
        String sql = "INSERT INTO tasks(project_id, description, completion_date) values (?, ?, ?)";

        return this.database.query(sql, projectId, description, completionDate);
    }

    public boolean update(int projectId, int id, String description, Date completionDate, Status status) {
        String sql = "UPDATE tasks SET description = ?, completion_date = ?, status = ? WHERE project_id = ? AND id = ?;";

        return this.database.query(sql, description, completionDate, status.name(), projectId, id);
    }

    public boolean update(int projectId, int id, Status status) {
        String sql = "UPDATE tasks SET status = ? WHERE project_id = ? AND id = ?;";

        return this.database.query(sql, status.name(), projectId, id);
    }

    public boolean delete(int projectId, int taskId) {
        String sql = "DELETE FROM tasks WHERE project_id = ? AND id = ?;";

        return this.database.query(sql, projectId, taskId);
    }

    public List<Task> list(int projectId) {
        String sql = "SELECT * FROM tasks WHERE project_id = ?";

        return this.database.query(sql, TaskMapper.map(), projectId);
    }

    public List<Task> list(int projectId, Status status) {
        String sql = "SELECT * FROM tasks WHERE project_id = ? AND status = ?;";

        return this.database.query(sql, TaskMapper.map(), projectId, status.name());
    }

    public Task find(int projectId, int taskId) {
        String sql = "SELECT * FROM tasks WHERE project_id = ? AND id = ?;";

        return this.database.query(sql, TaskMapper.map(), projectId, taskId).get(0);
    }
}
