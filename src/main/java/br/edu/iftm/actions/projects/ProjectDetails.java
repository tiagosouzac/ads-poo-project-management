package br.edu.iftm.actions.projects;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.Project;

public class ProjectDetails {
    private final ProjectDAO dao = new ProjectDAO();

    public Project find(int projectId) {
        try {
            return this.dao.find(projectId);
        } catch (Exception e) {
            System.out.println("Projeto não encontrado!");
            return null;
        }
    }
}
