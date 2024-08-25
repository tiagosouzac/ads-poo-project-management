package br.edu.iftm.menus.tasks;

import br.edu.iftm.actions.tasks.DeleteProjectTask;
import br.edu.iftm.actions.tasks.ProjectTaskDetails;
import br.edu.iftm.actions.tasks.UpdateProjectTaskStatus;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.menus.Menu;
import br.edu.iftm.menus.comments.TasksCommentMenu;

public class ProjectTasksDetailsMenu extends Menu {
    private final Project project;

    public ProjectTasksDetailsMenu(Project project) {
        this.project = project;
    }

    public void display() {
        while (true) {
            Task task = new ProjectTaskDetails(project).show();

            if (task == null) {
                return;
            }

            System.out.println();
            System.out.println("1. Mudar status da tarefa");
            System.out.println("2. Ver os comentários da tarefa");
            System.out.println("3. Excluir tarefa");
            System.out.println("0. Voltar para a listagem de tarefas");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new UpdateProjectTaskStatus(project, task).update();
                    return;

                case 2:
                    new TasksCommentMenu(task).display();
                    break;

                case 3:
                    new DeleteProjectTask(this.project, task).delete();
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
