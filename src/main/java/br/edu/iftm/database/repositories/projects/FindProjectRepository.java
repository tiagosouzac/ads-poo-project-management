package br.edu.iftm.database.repositories.projects;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;

public class FindProjectRepository {
    public ProjectModel find(int id) throws Exception {
        ProjectDAO dao = new ProjectDAO();
        return dao.find(id);
    }
}
