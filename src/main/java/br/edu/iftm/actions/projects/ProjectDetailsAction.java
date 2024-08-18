package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.utils.Scanner;

public class ProjectDetailsAction implements Action {
    private final ProjectDAO dao = new ProjectDAO();
    private final Scanner scanner = new Scanner();

    public void execute() {
        try {
            int projectId = this.askProjectId();

            ProjectModel project = this.dao.find(projectId);

            this.displayProjectInfo(project);
        } catch (Exception e) {
            System.out.println("Projeto não encontrado!");
        }
    }

    private int askProjectId() {
        System.out.print("ID do projeto: ");
        return this.scanner.readInt();
    }

    private void displayProjectInfo(ProjectModel project) {
        System.out.println("Nome: " + project.getName());
        System.out.println("Descrição: " + project.getDescription());
        System.out.println("Status: " + project.getStatus());

        if (project.getStartDate() != null) {
            System.out.println("Iniciado em: " + project.getStartDate());
        }

        if (project.getEndDate() != null) {
            System.out.println("Finalizado em: " + project.getEndDate());
        }
    }
}
