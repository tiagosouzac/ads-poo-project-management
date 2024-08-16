package br.edu.iftm.database.repositories.projects;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;

public class CreateProjectRepository {
    public ProjectModel create(String name, String description) {
        ProjectDAO dao = new ProjectDAO();
        return dao.store(name, description);
    }
}
