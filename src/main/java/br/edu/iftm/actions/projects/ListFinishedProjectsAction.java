package br.edu.iftm.actions.projects;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.models.ProjectModel.Status;

public class ListFinishedProjectsAction implements Action {
    private final ProjectDAO dao = new ProjectDAO();

    public void execute() {
        List<ProjectModel> projects = this.dao.list(Status.FINISHED);

        if (!projects.isEmpty()) {
            for (ProjectModel project : projects) {
                System.out.println(project.getId() + ". " + project.getName() + " - " + project.getStatus());
            }
        } else {
            System.out.println("Nenhum projeto concluído!");
        }
    }
}
