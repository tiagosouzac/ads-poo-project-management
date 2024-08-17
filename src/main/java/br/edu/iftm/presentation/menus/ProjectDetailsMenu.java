package br.edu.iftm.presentation.menus;

import br.edu.iftm.actions.projects.DeleteProjectAction;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.presentation.menu.Menu;

public class ProjectDetailsMenu extends Menu {
    public ProjectDetailsMenu(ProjectModel project) {
        this.addCloseOption("Excluir projeto", new DeleteProjectAction(project));
        this.addCloseOption("Voltar para o menu inicial");
    }
}
