package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.repositories.projects.CreateProjectRepository;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class CreateProjectAction implements Action {
    private final CreateProjectRepository repository = new CreateProjectRepository();
    private final Scanner scanner = new Scanner();

    public void execute() {
        String name = this.askProjectName();
        String description = this.askProjectDescription();

        this.repository.create(name, description);
    }

    private String askProjectName() {
        String name;

        do {
            System.out.print("Nome do projeto: ");
            name = this.scanner.read().trim();

            if (!Validator.project.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!Validator.project.isValidName(name));

        return name;
    }

    private String askProjectDescription() {
        String description;

        do {
            System.out.print("Descrição do projeto: ");
            description = this.scanner.read().trim();

            if (!Validator.project.isValidDescription(description)) {
                System.out.println("A descrição deve ter no máximo 255 caracteres!");
            }
        } while (!Validator.project.isValidDescription(description));

        return description;
    }
}
