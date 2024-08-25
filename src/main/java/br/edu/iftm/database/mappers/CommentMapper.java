package br.edu.iftm.database.mappers;

import java.util.function.Function;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.edu.iftm.database.models.Comment;

public class CommentMapper {
    public static Function<ResultSet, Comment> map() {
        return comment -> {
            try {
                int id = comment.getInt("id");
                int taskId = comment.getInt("task_id");
                String text = comment.getString("text");

                return new Comment(id, taskId, text);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
    };
}
