package br.edu.iftm.actions.comments;

import br.edu.iftm.database.daos.CommentDAO;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class CreateTaskComment {
    private final CommentDAO dao = new CommentDAO();
    private final Scanner scanner = new Scanner();
    private final Task task;

    public CreateTaskComment(Task task) {
        this.task = task;
    }

    public void create() {
        try {
            String text = this.askTaskText();
            int taskId = this.task.getId();

            if (this.dao.store(taskId, text)) {
                System.out.println("Comentário criado com succeso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar o comentário. Erro: " + e.getMessage());
        }
    }

    private String askTaskText() {
        String text;

        do {
            System.out.print("Comentário: ");
            text = this.scanner.read().trim();

            if (!Validator.project.isValidDescription(text)) {
                System.out.println("O comentário deve ter no máximo 255 caracteres!");
            }
        } while (!Validator.project.isValidDescription(text));

        return text;
    }
}
