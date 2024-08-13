package br.edu.iftm.presentation.menus;

import br.edu.iftm.actions.ListProjectsAction;
import br.edu.iftm.presentation.menu.Menu;
import br.edu.iftm.repositories.ListProjectsRepository;

public class MainMenu extends Menu {
    public MainMenu() {
        this.addOption("Listar todos os projetos", () -> {
            ListProjectsRepository listProjectsRepository = new ListProjectsRepository();
            ListProjectsAction listProjectsAction = new ListProjectsAction(listProjectsRepository);
            listProjectsAction.execute();
        });

        this.addOption("Listar todos as equipes", () -> {
            System.out.println("Executando a opção 2");
        });
    }
}
