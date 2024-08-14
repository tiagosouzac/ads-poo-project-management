package br.edu.iftm.presentation.menus;

import br.edu.iftm.actions.projects.ListProjectsAction;
import br.edu.iftm.actions.teams.ListTeamsAction;
import br.edu.iftm.presentation.menu.Menu;

public class MainMenu extends Menu {
    public MainMenu() {
        this.addOption("Listar todos os projetos", new ListProjectsAction());
        this.addOption("Listar todos as equipes", new ListTeamsAction());
    }
}
