package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;

public class DeleteProjectAction implements Action {
    private final ProjectDAO dao = new ProjectDAO();
    private final ProjectModel project;

    public DeleteProjectAction(ProjectModel project) {
        this.project = project;
    }

    public void execute() {
        try {
            this.dao.delete(project.getId());
        } catch (Exception e) {
            System.out.println("Não foi possível excluir o projeto. Erro: " + e.getMessage());
        }
    }
}
