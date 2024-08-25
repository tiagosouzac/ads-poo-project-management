package br.edu.iftm.menus.comments;

import br.edu.iftm.actions.comments.CreateTaskComment;
import br.edu.iftm.actions.comments.ListTaskComment;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.menus.Menu;

public class TasksCommentMenu extends Menu {
    private final Task task;

    public TasksCommentMenu(Task task) {
        this.task = task;
    }

    public void display() {
        new ListTaskComment(this.task).list();

        while (true) {
            System.out.println();
            System.out.println("1. Listar todas os comentários");
            System.out.println("2. Criar novo comentário");
            System.out.println("3. Ver detalhes do comentário");
            System.out.println("0. Voltar para os detalhes da tarefa");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new ListTaskComment(task).list();
                    break;

                case 2:
                    new CreateTaskComment(task).create();
                    break;

                case 3:
                    new TasksCommentDetailsMenu(task).display();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }
        }
    }
}
