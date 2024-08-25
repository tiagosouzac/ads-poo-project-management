package br.edu.iftm.menus.comments;

import br.edu.iftm.actions.comments.DeleteTaskComment;
import br.edu.iftm.actions.comments.TaskCommentDetails;
import br.edu.iftm.actions.comments.UpdateTaskComment;
import br.edu.iftm.database.models.Comment;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.menus.Menu;

public class TasksCommentDetailsMenu extends Menu {
    private final Task task;

    public TasksCommentDetailsMenu(Task task) {
        this.task = task;
    }

    public void display() {
        while (true) {
            Comment comment = new TaskCommentDetails(task).show();

            if (comment == null) {
                return;
            }

            System.out.println();
            System.out.println("1. Atualizar o comentário");
            System.out.println("2. Excluir o comentário");
            System.out.println("0. Voltar para a listagem de comentários");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new UpdateTaskComment(comment, task).update();
                    return;

                case 2:
                    new DeleteTaskComment(comment, task).delete();
                    return;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }
        }
    }
}
