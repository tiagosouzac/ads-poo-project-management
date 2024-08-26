package br.edu.iftm.actions.comments;

import br.edu.iftm.database.daos.CommentDAO;
import br.edu.iftm.database.models.Comment;
import br.edu.iftm.database.models.Task;

public class TaskCommentDetails {
    private final CommentDAO dao = new CommentDAO();
    private final Task task;

    public TaskCommentDetails(Task task) {
        this.task = task;
    }

    public Comment find(int commentId) {
        try {
            int taskId = this.task.getId();
            return this.dao.find(commentId, taskId);
        } catch (Exception e) {
            System.out.println("Comentário não encontrada!");
            return null;
        }
    }
}
