package br.edu.iftm.menus.tasks;

import br.edu.iftm.actions.tasks.DeleteProjectTask;
import br.edu.iftm.actions.tasks.ProjectTaskDetails;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.menus.Menu;

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
            System.out.println("1. Marcar como \"pendente\"");
            System.out.println("2. Marcar como \"em andamento\"");
            System.out.println("3. Marcar como \"finalizada\"");
            System.out.println("4. Excluir tarefa");
            System.out.println("0. Voltar para a listagem de tarefas");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    new DeleteProjectTask(this.project, task).delete();
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
