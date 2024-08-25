package br.edu.iftm.actions.comments;

import br.edu.iftm.database.daos.CommentDAO;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.database.models.Comment;

public class DeleteTaskComment {
    private final CommentDAO dao = new CommentDAO();
    private final Comment comment;
    private final Task task;

    public DeleteTaskComment(Comment comment, Task task) {
        this.comment = comment;
        this.task = task;
    }

    public void delete() {
        try {
            int commentId = this.comment.getId();
            int taskId = this.task.getId();

            if (this.dao.delete(commentId, taskId)) {
                System.out.println("Comentário excluído com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível excluir o comentário. Erro: " + e.getMessage());
        }
    }
}
