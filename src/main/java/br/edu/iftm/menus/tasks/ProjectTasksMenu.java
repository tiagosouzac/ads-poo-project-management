package br.edu.iftm.menus.tasks;

import br.edu.iftm.actions.tasks.CreateProjectTask;
import br.edu.iftm.actions.tasks.ListFinishedProjectTasks;
import br.edu.iftm.actions.tasks.ListInProgressProjectTasks;
import br.edu.iftm.actions.tasks.ListPendingProjectTasks;
import br.edu.iftm.actions.tasks.ListProjectTasks;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.menus.Menu;

public class ProjectTasksMenu extends Menu {
    private final Project project;

    public ProjectTasksMenu(Project project) {
        this.project = project;
    }

    public void display() {
        new ListProjectTasks(this.project).list();

        while (true) {
            System.out.println();
            System.out.println("1. Listar todas as tarefas");
            System.out.println("2. Listar tarefas pendentes");
            System.out.println("3. Listar tarefas em andamento");
            System.out.println("4. Listar tarefas finalizadas");
            System.out.println("5. Criar nova tarefa");
            System.out.println("6. Ver detalhes da tarefa");
            System.out.println("0. Voltar para os detalhes do projeto");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new ListProjectTasks(project).list();
                    break;

                case 2:
                    new ListPendingProjectTasks(project).list();
                    break;

                case 3:
                    new ListInProgressProjectTasks(project).list();
                    break;

                case 4:
                    new ListFinishedProjectTasks(project).list();
                    break;

                case 5:
                    new CreateProjectTask(project).create();
                    break;

                case 6:
                    new ProjectTasksDetailsMenu(project).display();
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
