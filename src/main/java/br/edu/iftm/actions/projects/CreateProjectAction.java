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

            if (!Validator.project.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!Validator.project.isValidName(name));

        return name;
    }

    private String askProjectDescription(Scanner scanner) {
        String description;

        do {
            System.out.print("Descrição do projeto: ");
            description = scanner.read().trim();

            if (!Validator.project.isValidDescription(description)) {
                System.out.println("A descrição deve ter no máximo 255 caracteres!");
            }
        } while (!Validator.project.isValidDescription(description));

        return description;
    }
}
