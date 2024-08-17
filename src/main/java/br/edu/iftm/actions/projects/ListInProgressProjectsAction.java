package br.edu.iftm.actions.projects;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.models.ProjectModel.Status;
import br.edu.iftm.database.repositories.projects.ListProjectsRepository;

public class ListInProgressProjectsAction implements Action {
    public void execute() {
        ListProjectsRepository repository = new ListProjectsRepository();
        List<ProjectModel> projects = repository.list(Status.IN_PROGRESS);

        if (!projects.isEmpty()) {
            for (ProjectModel project : projects) {
                System.out.println(project.getId() + ". " + project.getName() + " - " + project.getStatus());
            }
        } else {
            System.out.println("Nenhum projeto em andamento!");
        }
    }
}
