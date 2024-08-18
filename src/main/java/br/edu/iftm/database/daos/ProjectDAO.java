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

    public ProjectModel store(String name, String description, Date start_at, Date end_at) {
        String sql = "INSERT INTO projects(name, description, start_at, end_at) VALUES (?, ?, ?, ?)";

        return this.database
                .query(sql, ProjectMapper.map(), name, description, start_at, end_at)
                .get(0);
    }

    public ProjectModel update(ProjectModel project) throws Exception {
        String sql = "UPDATE projects SET name = ?, description = ?, status = ?, start_at = ?, end_at = ? WHERE id = ?;";

        return this.database
                .query(sql, ProjectMapper.map(), project.getName(), project.getDescription(),
                        project.getStatus().name(),
                        project.getStartDate(), project.getEndDate())
                .get(0);
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
