package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.models.ProjectModel.Status;
import br.edu.iftm.database.repositories.projects.FindProjectRepository;
import br.edu.iftm.database.repositories.projects.UpdateProjectRepository;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class UpdateProjectAction implements Action {
    private ProjectModel project;

    public UpdateProjectAction(ProjectModel project) {
        this.project = project;
    }

    public void execute() {
        UpdateProjectRepository updateRepository = new UpdateProjectRepository();
        FindProjectRepository findRepository = new FindProjectRepository();
        Scanner scanner = new Scanner();

        try {
            ProjectModel existingProject = findRepository.find(this.project.getId());

            String name = existingProject.getName();
            String description = existingProject.getDescription();
            Status status = existingProject.getStatus();

            name = askProjectName(scanner, name);
            description = askProjectDescription(scanner, description);
            status = askProjectStatus(scanner, status);

            ProjectModel updatedProject = new ProjectModel(this.project.getId(), name, description, status);

            updateRepository.update(updatedProject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String askProjectName(Scanner scanner, String currentName) {
        String name;

        do {
            System.out.println("Nome atual: " + currentName);
            System.out.print("Novo nome do projeto (deixe vazio para manter o atual): ");
            name = scanner.read().trim();

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

    private String askProjectDescription(Scanner scanner, String currentDescription) {
        String description;

        do {
            System.out.println("Descrição atual: " + currentDescription);
            System.out.print("Nova descrição do projeto (deixe vazio para manter a atual): ");
            description = scanner.read().trim();

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

    private Status askProjectStatus(Scanner scanner, Status currentStatus) {
        Status status = null;

        System.out.println("Status do projeto: ");
        System.out.println("1. " + Status.PENDING);
        System.out.println("2. " + Status.IN_PROGRESS);
        System.out.println("3. " + Status.FINISHED);

        do {
            int selectedStatus = scanner.readInt();

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
}
