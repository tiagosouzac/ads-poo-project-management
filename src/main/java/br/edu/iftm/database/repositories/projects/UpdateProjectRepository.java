package br.edu.iftm.database.repositories.projects;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;

public class UpdateProjectRepository {
    public ProjectModel update(ProjectModel project) throws Exception {
        ProjectDAO dao = new ProjectDAO();
        return dao.update(project);
    }
}
