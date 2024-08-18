package br.edu.iftm.actions.teams;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.TeamModel;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class UpdateTeamAction implements Action {
    private final TeamDAO dao = new TeamDAO();
    private final Scanner scanner = new Scanner();
    private final TeamModel team;

    public UpdateTeamAction(TeamModel team) {
        this.team = team;
    }

    public void execute() {
        try {
            int id = this.team.getId();
            String name = this.askTeamName(this.team.getName());

            if (this.dao.update(id, name)) {
                System.out.println("Equipe atualizada com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar a equipe. Erro: " + e.getMessage());
        }
    }

    private String askTeamName(String currentName) {
        String name;

        do {
            System.out.println("Nome atual: " + currentName);
            System.out.print("Novo nome da equipe (deixe vazio para manter o atual): ");
            name = this.scanner.read().trim();

            if (Validator.string.isEmpty(name)) {
                name = currentName;
                break;
            }

            if (!Validator.team.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!Validator.team.isValidName(name));

        return name;
    }
}
