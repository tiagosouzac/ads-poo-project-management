package br.edu.iftm.database.daos;

import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.models.ProjectModel.Status;

public class ProjectDAO {
    private static List<ProjectModel> fakeProjects = new ArrayList<>() {
        {
            add(new ProjectModel(1, "Projeto 1", "Descrição do projeto 1"));
            add(new ProjectModel(2, "Projeto 2", "Descrição do projeto 2", Status.IN_PROGRESS));
            add(new ProjectModel(3, "Projeto 3", "Descrição do projeto 3", Status.FINISHED));
        }
    };

    public ProjectModel store(String name, String description) {
        int id = ProjectDAO.fakeProjects.size() + 1;
        ProjectModel project = new ProjectModel(id, name, description);
        ProjectDAO.fakeProjects.add(project);
        return project;
    }

    public ProjectModel update(ProjectModel project) throws Exception {
        try {
            ProjectModel oldProject = this.find(project.getId());
            int index = ProjectDAO.fakeProjects.indexOf(oldProject);
            ProjectDAO.fakeProjects.set(index, project);
            return project;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean delete(int id) throws Exception {
        boolean removed = ProjectDAO.fakeProjects.removeIf((project) -> project.getId() == id);

        if (removed) {
            return removed;
        } else {
            throw new Exception("Projeto não encontrado!");
        }
    }

    public List<ProjectModel> list() {
        return ProjectDAO.fakeProjects;
    }

    public List<ProjectModel> list(Status status) {
        List<ProjectModel> projects = new ArrayList<>();

        for (ProjectModel project : ProjectDAO.fakeProjects) {
            if (project.getStatus() == status) {
                projects.add(project);
            }
        }

        return projects;
    }

    public ProjectModel find(int id) throws Exception {
        ProjectModel project = null;

        for (ProjectModel p : ProjectDAO.fakeProjects) {
            if (p.getId() == id) {
                project = p;
            }
        }

        if (project == null) {
            throw new Exception("Projeto não encontrado!");
        }

        return project;
    }
}
