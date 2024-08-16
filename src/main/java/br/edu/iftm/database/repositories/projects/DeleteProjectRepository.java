package br.edu.iftm.database.repositories.projects;

import br.edu.iftm.database.daos.ProjectDAO;

public class DeleteProjectRepository {
    public boolean delete(int id) throws Exception {
        ProjectDAO dao = new ProjectDAO();
        return dao.delete(id);
    }
}
