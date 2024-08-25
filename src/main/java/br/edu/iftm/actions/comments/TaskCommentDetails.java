package br.edu.iftm.actions.comments;

import br.edu.iftm.database.daos.CommentDAO;
import br.edu.iftm.database.models.Comment;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.utils.Scanner;

public class TaskCommentDetails {
    private final CommentDAO dao = new CommentDAO();
    private final Scanner scanner = new Scanner();
    private final Task task;

    public TaskCommentDetails(Task task) {
        this.task = task;
    }

    public Comment show() {
        try {
            int taskId = this.task.getId();
            int commentId = this.askCommentId();

            Comment comment = this.dao.find(commentId, taskId);

            this.displayCommentTaskInfo(comment);

            return comment;
        } catch (Exception e) {
            System.out.println("Comentário não encontrada!");
            return null;
        }
    }

    private int askCommentId() {
        System.out.print("ID do comentário: ");
        return this.scanner.readInt();
    }

    private void displayCommentTaskInfo(Comment comment) {
        System.out.println(comment.getText());
    }
}
