package br.edu.iftm.database.mappers;

import java.util.Date;
import java.util.function.Function;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Project.Status;

public class ProjectMapper {
    public static Function<ResultSet, Project> map() {
        return project -> {
            try {
                int id = project.getInt("id");
                String name = project.getString("name");
                String description = project.getString("description");
                Status status = Status.valueOf(project.getString("status"));
                Date startAt = project.getDate("start_at");
                Date endAt = project.getDate("end_at");

                return new Project(id, name, description, status, startAt, endAt);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
    };
}
