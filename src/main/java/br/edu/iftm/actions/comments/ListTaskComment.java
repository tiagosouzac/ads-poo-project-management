package br.edu.iftm.actions.comments;

import java.util.List;

import br.edu.iftm.database.daos.CommentDAO;
import br.edu.iftm.database.models.Comment;
import br.edu.iftm.database.models.Task;

public class ListTaskComment {
    private final CommentDAO dao = new CommentDAO();
    private final Task task;

    public ListTaskComment(Task task) {
        this.task = task;
    }

    public void list() {
        try {
            List<Comment> comments = this.dao.list(this.task.getId());

            if (!comments.isEmpty()) {
                for (Comment comment : comments) {
                    System.out.println(comment);
                }
            } else {
                System.out.println("Nenhum comentário cadastrado ainda!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível listar os comentários da tarefa. Erro: " + e.getMessage());
        }
    }
}
