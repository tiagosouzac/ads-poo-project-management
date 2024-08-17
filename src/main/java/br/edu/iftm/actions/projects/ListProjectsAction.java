package br.edu.iftm.actions.projects;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.repositories.projects.ListProjectsRepository;
import br.edu.iftm.presentation.menus.ListProjectsMenu;

public class ListProjectsAction implements Action {
    public void execute() {
        ListProjectsRepository repository = new ListProjectsRepository();
        List<ProjectModel> projects = repository.list();

        for (ProjectModel project : projects) {
            System.out.println(project.getId() + ". " + project.getName() + " - " + project.getStatus());
        }

        ListProjectsMenu menu = new ListProjectsMenu();
        menu.display();
    }
}
