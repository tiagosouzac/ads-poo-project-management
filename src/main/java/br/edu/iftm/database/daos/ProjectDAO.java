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

    public void create() {
    }

    public void update() {
    }

    public void delete() {
    }

    public List<ProjectModel> list() {
        return ProjectDAO.fakeProjects;
    }

    public List<ProjectModel> list(Status status) {
        List<ProjectModel> projects = new ArrayList<>();

        for (ProjectModel project : projects) {
            if (project.getStatus() == status) {
                projects.add(project);
            }
        }

        return projects;
    }

    public void find() {
    }
}
