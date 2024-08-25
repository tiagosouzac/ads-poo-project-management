package br.edu.iftm.database.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.function.Function;

import br.edu.iftm.database.models.Task;
import br.edu.iftm.database.models.Task.Status;

public class TaskMapper {
    public static Function<ResultSet, Task> map() {
        return task -> {
            try {
                int id = task.getInt("id");
                int projectId = task.getInt("project_id");
                String description = task.getString("description");
                Date completionDate = task.getDate("completion_date");
                Status status = Status.valueOf(task.getString("status"));

                return new Task(id, projectId, description, completionDate, status);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
    };
}
