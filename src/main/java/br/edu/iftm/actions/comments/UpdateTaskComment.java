package br.edu.iftm.actions.comments;

import br.edu.iftm.database.daos.CommentDAO;
import br.edu.iftm.database.models.Comment;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class UpdateTaskComment {
    private final CommentDAO dao = new CommentDAO();
    private final Scanner scanner = new Scanner();
    private final Comment comment;
    private final Task task;

    public UpdateTaskComment(Comment comment, Task task) {
        this.comment = comment;
        this.task = task;
    }

    public void update() {
        try {
            int commentId = this.comment.getId();
            int taskId = this.task.getId();
            String text = this.askTaskCommentText(this.comment.getText());

            if (this.dao.update(commentId, taskId, text)) {
                System.out.println("Comentário atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o comentário. Erro: " + e.getMessage());
        }
    }

    private String askTaskCommentText(String currentText) {
        String text;

        do {
            System.out.println("Comentário atual: " + currentText);
            System.out.print("Novo comentário da tarefa (deixe vazio para manter a atual): ");
            text = this.scanner.read().trim();

            if (Validator.string.isEmpty(text)) {
                text = currentText;
                break;
            }

            if (!Validator.project.isValidDescription(text)) {
                System.out.println("O comentário deve ter no máximo 255 caracteres!");
            }
        } while (!Validator.project.isValidDescription(text));

        return text;
    }
}
