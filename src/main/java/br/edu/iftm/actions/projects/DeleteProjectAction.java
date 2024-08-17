package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.repositories.projects.DeleteProjectRepository;

public class DeleteProjectAction implements Action {
    private ProjectModel project;

    public DeleteProjectAction(ProjectModel project) {
        this.project = project;
    }

    public void execute() {
        DeleteProjectRepository repository = new DeleteProjectRepository();

        try {
            repository.delete(project.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
