package br.edu.iftm.actions.projects;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;

public class ListProjectsAction implements Action {
    private final ProjectDAO dao = new ProjectDAO();

    public void execute() {
        List<ProjectModel> projects = this.dao.list();

        if (!projects.isEmpty()) {
            for (ProjectModel project : projects) {
                System.out.println(project.getId() + ". " + project.getName() + " - " + project.getStatus());
            }
        } else {
            System.out.println("Nenhum projeto cadastrado ainda!");
        }
    }
}
