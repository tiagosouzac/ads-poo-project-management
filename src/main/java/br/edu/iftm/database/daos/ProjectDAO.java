package br.edu.iftm.database.daos;

import java.util.Date;
import java.util.List;

import br.edu.iftm.database.Database;
import br.edu.iftm.database.mappers.ProjectMapper;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.models.ProjectModel.Status;

public class ProjectDAO {
    private final Database database;

    public ProjectDAO() {
        this.database = new Database();
    }

    public boolean store(String name, String description, Date startAt, Date endAt) {
        String sql = "INSERT INTO projects(name, description, start_at, end_at) VALUES (?, ?, ?, ?)";

        return this.database.query(sql, name, description, startAt, endAt);
    }

    public boolean update(int id, String name, String description, Status status, Date startAt, Date endAt)
            throws Exception {
        String sql = "UPDATE projects SET name = ?, description = ?, status = ?, start_at = ?, end_at = ? WHERE id = ?;";

        return this.database.query(sql, name, description, status.name(), startAt, endAt, id);
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM projects WHERE id = ?;";

        return this.database.query(sql, id);
    }

    public List<ProjectModel> list() {
        String sql = "SELECT * FROM projects;";

        return this.database.query(sql, ProjectMapper.map());
    }

    public List<ProjectModel> list(Status status) {
        String sql = "SELECT * FROM projects WHERE status = ?;";

        return this.database.query(sql, ProjectMapper.map(), status.name());
    }

    public ProjectModel find(int id) {
        String sql = "SELECT * FROM projects WHERE id = ?;";

        return this.database.query(sql, ProjectMapper.map(), id).get(0);
    }
}
