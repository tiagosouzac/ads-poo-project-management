package br.edu.iftm.database.repositories.projects;

import java.util.List;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.models.ProjectModel.Status;

public class ListProjectsRepository {
    public List<ProjectModel> list() {
        ProjectDAO dao = new ProjectDAO();
        List<ProjectModel> projects = dao.list();
        return projects;
    }

    public List<ProjectModel> list(Status status) {
        ProjectDAO dao = new ProjectDAO();
        List<ProjectModel> projects = dao.list(status);
        return projects;
    }
}
