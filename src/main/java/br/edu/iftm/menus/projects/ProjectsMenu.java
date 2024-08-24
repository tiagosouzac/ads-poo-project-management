package br.edu.iftm.menus.projects;

import br.edu.iftm.actions.projects.CreateProject;
import br.edu.iftm.actions.projects.ListFinishedProjects;
import br.edu.iftm.actions.projects.ListInProgressProjects;
import br.edu.iftm.actions.projects.ListPendingProjects;
import br.edu.iftm.actions.projects.ListProjects;
import br.edu.iftm.menus.Menu;

public class ProjectsMenu extends Menu {
    public void display() {
        while (true) {
            System.out.println("1. Listar todos os projetos");
            System.out.println("2. Listar os projetos pendentes");
            System.out.println("3. Listar os projetos em andamento");
            System.out.println("4. Listar os projetos finalizados");
            System.out.println("5. Criar um projeto");
            System.out.println("6. Ver os detalhes de um projeto");
            System.out.println("0. Voltar para o menu inicial");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new ListProjects().list();
                    break;

                case 2:
                    new ListPendingProjects().list();
                    break;

                case 3:
                    new ListInProgressProjects().list();
                    break;

                case 4:
                    new ListFinishedProjects().list();
                    break;

                case 5:
                    new CreateProject().create();
                    break;

                case 6:
                    new ProjectDetailsMenu().display();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }

            System.out.println();
        }
    }
}
