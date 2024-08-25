package br.edu.iftm.database.daos;

import java.util.List;

import br.edu.iftm.database.Database;
import br.edu.iftm.database.mappers.CommentMapper;
import br.edu.iftm.database.models.Comment;

public class CommentDAO {
    private final Database database = new Database();

    public boolean store(int taskId, String text) {
        String sql = "INSERT INTO comments(task_id, text) values (?, ?)";

        return this.database.query(sql, taskId, text);
    }

    public boolean update(int commentId, int taskId, String text) {
        String sql = "UPDATE comments SET text = ? WHERE task_id = ? AND id = ?;";

        return this.database.query(sql, text, taskId, commentId);
    }

    public boolean delete(int commentId, int taskId) {
        String sql = "DELETE FROM comments WHERE task_id = ? AND id = ?;";

        return this.database.query(sql, taskId, commentId);
    }

    public List<Comment> list(int taskId) {
        String sql = "SELECT * FROM comments WHERE task_id = ?";

        return this.database.query(sql, CommentMapper.map(), taskId);
    }

    public Comment find(int commentId, int taskId) {
        String sql = "SELECT * FROM comments WHERE task_id = ? AND id = ?;";

        return this.database.query(sql, CommentMapper.map(), taskId, commentId).get(0);
    }
}
