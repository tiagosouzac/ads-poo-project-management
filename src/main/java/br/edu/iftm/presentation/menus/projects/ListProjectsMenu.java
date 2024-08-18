package br.edu.iftm.presentation.menus.projects;

import br.edu.iftm.actions.projects.CreateProjectAction;
import br.edu.iftm.actions.projects.ListFinishedProjectsAction;
import br.edu.iftm.actions.projects.ListInProgressProjectsAction;
import br.edu.iftm.actions.projects.ListPendingProjectsAction;
import br.edu.iftm.presentation.menu.Menu;

public class ListProjectsMenu extends Menu {
    public ListProjectsMenu() {
        this.addOption("Listar projetos pendentes", new ListPendingProjectsAction());
        this.addOption("Listar projetos em andamento", new ListInProgressProjectsAction());
        this.addOption("Listar projetos concluídos", new ListFinishedProjectsAction());
        this.addCloseOption("Criar um projeto", new CreateProjectAction());
        this.addCloseOption("Voltar para o menu inicial");
    }
}
