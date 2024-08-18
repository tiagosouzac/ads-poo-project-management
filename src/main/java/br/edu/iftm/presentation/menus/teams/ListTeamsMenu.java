package br.edu.iftm.presentation.menus.teams;

import br.edu.iftm.actions.teams.CreateTeamAction;
import br.edu.iftm.presentation.menu.Menu;

public class ListTeamsMenu extends Menu {
    public ListTeamsMenu() {
        this.addCloseOption("Criar uma equipe", new CreateTeamAction());
        this.addCloseOption("Voltar para o menu inicial");
    }
}
