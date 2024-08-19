package br.edu.iftm.actions.projects;

import java.util.List;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.Project;

public class ListProjects {
    private final ProjectDAO dao = new ProjectDAO();

    public void list() {
        List<Project> projects = this.dao.list();

        if (!projects.isEmpty()) {
            for (Project project : projects) {
                System.out.println(project.getId() + ". " + project.getName() + " - " + project.getStatus());
            }
        } else {
            System.out.println("Nenhum projeto cadastrado ainda!");
        }
    }
}
