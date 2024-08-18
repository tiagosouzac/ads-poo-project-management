package br.edu.iftm.actions.projects;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Project.Status;

public class ListInProgressProjectsAction implements Action {
    private final ProjectDAO dao = new ProjectDAO();

    public void execute() {
        List<Project> projects = this.dao.list(Status.IN_PROGRESS);

        if (!projects.isEmpty()) {
            for (Project project : projects) {
                System.out.println(project.getId() + ". " + project.getName() + " - " + project.getStatus());
            }
        } else {
            System.out.println("Nenhum projeto em andamento!");
        }
    }
}
