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

    public boolean update(int id, String description, Date completionDate, Status status) {
        String sql = "UPDATE tasks SET description = ?, completion_date = ?, status = ? WHERE id = ?;";

        return this.database.query(sql, description, completionDate, status.name(), id);
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?;";

        return this.database.query(sql, id);
    }

    public List<Task> list() {
        String sql = "SELECT * FROM tasks";

        return this.database.query(sql, TaskMapper.map());
    }

    public List<Task> list(Status status) {
        String sql = "SELECT * FROM tasks WHERE status = ?;";

        return this.database.query(sql, TaskMapper.map(), status.name());
    }

    public Task find(int id) {
        String sql = "SELECT * FROM tasks WHERE id = ?;";

        return this.database.query(sql, TaskMapper.map(), id).get(0);
    }
}
