package br.edu.iftm.presentation.menus;

import br.edu.iftm.actions.projects.ListProjectsAction;
import br.edu.iftm.presentation.menu.Menu;

public class MainMenu extends Menu {
    public MainMenu() {
        this.addOption("Listar todos os projetos", new ListProjectsAction());
        this.addCloseOption("Encerrar o programa");
    }

    @Override
    public void display() {
        System.out.println("Bem vindo! O que deseja fazer?");
        super.display();
    }
}
