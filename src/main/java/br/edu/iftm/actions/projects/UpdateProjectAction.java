package br.edu.iftm.actions.projects;

import java.util.Date;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.models.ProjectModel.Status;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class UpdateProjectAction implements Action {
    private final ProjectDAO dao = new ProjectDAO();
    private final Scanner scanner = new Scanner();
    private ProjectModel project;

    public UpdateProjectAction(ProjectModel project) {
        this.project = project;
    }

    public void execute() {
        try {
            ProjectModel existingProject = this.dao.find(this.project.getId());

            int id = existingProject.getId();
            String name = this.askProjectName(existingProject.getName());
            String description = this.askProjectDescription(existingProject.getDescription());
            Status status = this.askProjectStatus(existingProject.getStatus());
            Date startAt = this.askProjectStartDate(existingProject.getStartDate());
            Date endAt = this.askProjectEndDate(existingProject.getEndDate(), startAt);

            if (this.dao.update(id, name, description, status, startAt, endAt)) {
                System.out.println("Projeto atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o projeto. Erro: " + e.getMessage());
        }
    }

    private String askProjectName(String currentName) {
        String name;

        do {
            System.out.println("Nome atual: " + currentName);
            System.out.print("Novo nome do projeto (deixe vazio para manter o atual): ");
            name = this.scanner.read().trim();

            if (Validator.string.isEmpty(name)) {
                name = currentName;
                break;
            }

            if (!Validator.project.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!Validator.project.isValidName(name));

        return name;
    }

    private String askProjectDescription(String currentDescription) {
        String description;

        do {
            System.out.println("Descrição atual: " + currentDescription);
            System.out.print("Nova descrição do projeto (deixe vazio para manter a atual): ");
            description = this.scanner.read().trim();

            if (Validator.string.isEmpty(description)) {
                description = currentDescription;
                break;
            }

            if (!Validator.project.isValidDescription(description)) {
                System.out.println("A descrição deve ter no máximo 255 caracteres!");
            }
        } while (!Validator.project.isValidDescription(description));

        return description;
    }

    private Status askProjectStatus(Status currentStatus) {
        Status status = null;

        System.out.println("Status do projeto: " + currentStatus);
        System.out.println("Deseja alterar esse status? (s/n)");

        char changeStatus = this.scanner.readChar();

        if (changeStatus == 'n') {
            return currentStatus;
        }

        System.out.println("1. " + Status.PENDING);
        System.out.println("2. " + Status.IN_PROGRESS);
        System.out.println("3. " + Status.FINISHED);

        do {
            int selectedStatus = this.scanner.readInt();

            switch (selectedStatus) {
                case 1:
                    status = Status.PENDING;
                    break;

                case 2:
                    status = Status.IN_PROGRESS;
                    break;

                case 3:
                    status = Status.FINISHED;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (status == null);

        return status;
    }

    private Date askProjectStartDate(Date currentStartDate) {
        Date startAt = null;

        System.out.println("Data de início: " + currentStartDate);
        System.out.println("Deseja alterar essa data? (s/n)");

        char changeStatus = this.scanner.readChar();

        if (changeStatus == 'n') {
            return currentStartDate;
        }

        do {
            System.out.println("Nova data de início: ");
            startAt = this.scanner.readDate();
        } while (startAt == null);

        return startAt;
    }

    private Date askProjectEndDate(Date currentEndDate, Date starAt) {
        Date endAt = null;

        if (currentEndDate.after(starAt)) {
            System.out.println("Data de finalização: " + currentEndDate);
            System.out.println("Deseja alterar essa data? (s/n)");

            char changeStatus = this.scanner.readChar();

            if (changeStatus == 'n') {
                return currentEndDate;
            }
        }

        do {
            System.out.println("Nova data de finalização: ");
            endAt = this.scanner.readDate();

            if (endAt.before(starAt)) {
                System.out.println("A finalização deve ser posterior ao início do projeto!");
                endAt = null;
            }
        } while (endAt == null);

        return endAt;
    }
}
