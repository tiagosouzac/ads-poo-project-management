package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.repositories.projects.CreateProjectRepository;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class CreateProjectAction implements Action {
    public void execute() {
        CreateProjectRepository repository = new CreateProjectRepository();
        Scanner scanner = new Scanner();

        String name = this.askProjectName(scanner);
        String description = this.askProjectDescription(scanner);

        repository.create(name, description);
    }

    private String askProjectName(Scanner scanner) {
        String name;

        do {
            System.out.print("Nome do projeto: ");
            name = scanner.read().trim();

            if (!this.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!this.isValidName(name));

        return name;
    }

    private boolean isValidName(String name) {
        return Validator.string.isValid(name, 1, 255);
    }

    private String askProjectDescription(Scanner scanner) {
        String description;

        do {
            System.out.print("Descrição do projeto: ");
            description = scanner.read().trim();

            if (!this.isValidDescription(description)) {
                System.out.println("Descrição deve ter no máximo 255 caracteres!");
            }
        } while (!this.isValidDescription(description));

        return description;
    }

    private boolean isValidDescription(String description) {
        return Validator.string.maxLength(description, 255);
    }
}
