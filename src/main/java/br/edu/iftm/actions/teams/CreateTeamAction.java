package br.edu.iftm.actions.teams;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class CreateTeamAction implements Action {
    private final TeamDAO dao = new TeamDAO();
    private final Scanner scanner = new Scanner();

    public void execute() {
        String name = this.askTeamName();

        try {
            if (this.dao.store(name)) {
                System.out.println("Equipe criada com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar a equipe. Erro: " + e.getMessage());
        }
    }

    private String askTeamName() {
        String name;

        do {
            System.out.print("Nome da equipe: ");
            name = this.scanner.read().trim();

            if (!Validator.team.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!Validator.team.isValidName(name));

        return name;
    }
}
