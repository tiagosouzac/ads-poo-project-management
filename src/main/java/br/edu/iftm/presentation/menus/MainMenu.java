package br.edu.iftm.presentation.menus;

import br.edu.iftm.actions.projects.ListFinishedProjectsAction;
import br.edu.iftm.actions.projects.ListInProgressProjectsAction;
import br.edu.iftm.actions.projects.ListPendingProjectsAction;
import br.edu.iftm.actions.projects.ListProjectsAction;
import br.edu.iftm.presentation.menu.Menu;

public class MainMenu extends Menu {
    public MainMenu() {
        this.addOption("Listar todos os projetos", new ListProjectsAction());
        this.addOption("Listar os projetos pendentes", new ListPendingProjectsAction());
        this.addOption("Listar os projetos em andamento", new ListInProgressProjectsAction());
        this.addOption("Listar os projetos concluídos", new ListFinishedProjectsAction());
    }

    public void display() {
        System.out.println("Bem vindo! O que deseja fazer?");
        System.out.println();

        super.askOption();
    }
}
