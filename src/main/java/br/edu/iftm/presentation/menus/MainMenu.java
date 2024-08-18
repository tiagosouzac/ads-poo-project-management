package br.edu.iftm.presentation.menus;

import br.edu.iftm.actions.projects.CreateProjectAction;
import br.edu.iftm.actions.projects.ListProjectsAction;
import br.edu.iftm.actions.projects.ProjectDetailsAction;
import br.edu.iftm.actions.teams.CreateTeamAction;
import br.edu.iftm.actions.teams.ListTeamsAction;
import br.edu.iftm.actions.teams.TeamDetailsAction;
import br.edu.iftm.presentation.menu.Menu;

public class MainMenu extends Menu {
    public MainMenu() {
        this.addOption("Listar todos os projetos", new ListProjectsAction());
        this.addOption("Ver detalhes de um projeto", new ProjectDetailsAction());
        this.addOption("Criar um projeto", new CreateProjectAction());
        this.addOption("Listar equipes", new ListTeamsAction());
        this.addOption("Ver detalhes de uma equipe", new TeamDetailsAction());
        this.addOption("Criar uma equipe", new CreateTeamAction());
        this.addCloseOption("Encerrar o programa");
    }

    @Override
    public void display() {
        System.out.println("Bem vindo! O que deseja fazer?");
        super.display();
    }
}
