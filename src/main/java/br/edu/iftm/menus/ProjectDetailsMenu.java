package br.edu.iftm.menus;

import br.edu.iftm.actions.projects.DeleteProject;
import br.edu.iftm.actions.projects.ProjectDetails;
import br.edu.iftm.actions.projects.UpdateProject;
import br.edu.iftm.database.models.Project;

public class ProjectDetailsMenu extends Menu {
    public void display() {
        while (true) {
            Project project = new ProjectDetails().show();

            System.out.println("1. Atualizar o projeto");
            System.out.println("2. Excluir o projeto");
            System.out.println("0. Voltar para o menu de projetos");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new UpdateProject(project).update();
                    return;

                case 2:
                    new DeleteProject(project).delete();
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
