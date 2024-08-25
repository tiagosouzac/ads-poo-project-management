package br.edu.iftm.actions.projects;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.Project;

public class DeleteProject {
    private final ProjectDAO dao = new ProjectDAO();
    private final Project project;

    public DeleteProject(Project project) {
        this.project = project;
    }

    public void delete() {
        try {
            if (this.dao.delete(project.getId())) {
                System.out.println("Projeto excluído com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível excluir o projeto. Erro: " + e.getMessage());
        }
    }
}
