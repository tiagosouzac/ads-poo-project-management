package br.edu.iftm.actions.projects;

import java.util.Date;

import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class CreateProject {
    private final ProjectDAO dao = new ProjectDAO();
    private final Scanner scanner = new Scanner();

    public void create() {
        String name = this.askProjectName();
        String description = this.askProjectDescription();
        Date startAt = this.askProjectStartDate();
        Date endAt = this.askProjectEndDate(startAt);

        try {
            if (this.dao.store(name, description, startAt, endAt)) {
                System.out.println("Projeto criado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar o projeto. Erro: " + e.getMessage());
        }
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

    private Date askProjectStartDate() {
        Date startAt = null;

        do {
            System.out.println("Data de início: ");
            startAt = this.scanner.readDate();
        } while (startAt == null);

        return startAt;
    }

    private Date askProjectEndDate(Date starAt) {
        Date endAt = null;

        do {
            System.out.println("Data de finalização: ");
            endAt = this.scanner.readDate();

            if (!Validator.project.isValidEndDate(endAt, starAt)) {
                System.out.println("A finalização deve ser posterior ao início do projeto!");
                endAt = null;
            }
        } while (endAt == null);

        return endAt;
    }
}
