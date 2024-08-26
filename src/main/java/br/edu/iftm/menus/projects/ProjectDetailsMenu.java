package br.edu.iftm.menus.projects;

import br.edu.iftm.actions.projects.ChangeProjectTeam;
import br.edu.iftm.actions.projects.DeleteProject;
import br.edu.iftm.actions.projects.ProjectDetails;
import br.edu.iftm.actions.projects.UpdateProject;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.menus.Menu;
import br.edu.iftm.menus.tasks.ProjectTasksMenu;

public class ProjectDetailsMenu extends Menu {
    private Project project;

    public void display() {
        while (true) {
            this.findProject();

            if (this.project == null) {
                break;
            }

            this.displayProjectDetails();

            System.out.println("1. Atualizar o projeto");
            System.out.println("2. Alterar equipe do projeto");
            System.out.println("3. Ver as tarefas do projeto");
            System.out.println("4. Excluir o projeto");
            System.out.println("0. Voltar para o menu de projetos");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new UpdateProject(project).update();
                    break;

                case 2:
                    new ChangeProjectTeam(project).change();
                    break;

                case 3:
                    new ProjectTasksMenu(project).display();
                    break;

                case 4:
                    new DeleteProject(project).delete();
                    return;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }

            System.out.println();
        }
    }

    private void findProject() {
        int projectId = this.project == null ? this.askProjectId() : this.project.getId();
        this.project = new ProjectDetails().find(projectId);
    }

    private int askProjectId() {
        System.out.print("ID do projeto: ");
        return this.scanner.readInt();
    }

    private void displayProjectDetails() {
        System.out.println("Nome: " + this.project.getName());
        System.out.println("Descrição: " + this.project.getDescription());
        System.out.println("Status: " + this.project.getStatus());

        if (this.project.getStartAt() != null) {
            System.out.println("Iniciado em: " + this.project.getStartAt());
        }

        if (this.project.getEndAt() != null) {
            System.out.println("Finalizado em: " + this.project.getEndAt());
        }

        System.out.println();
    }
}
