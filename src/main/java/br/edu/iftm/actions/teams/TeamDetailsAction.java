package br.edu.iftm.actions.teams;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.TeamModel;
import br.edu.iftm.utils.Scanner;

public class TeamDetailsAction implements Action {
    private final TeamDAO dao = new TeamDAO();
    private final Scanner scanner = new Scanner();

    public void execute() {
        try {
            int teamId = this.askTeamId();

            TeamModel team = this.dao.find(teamId);

            this.displayTeamInfo(team);
        } catch (Exception e) {
            System.out.println("Equipe não encontrada!");
        }
    }

    private int askTeamId() {
        System.out.print("ID da equipe: ");
        return this.scanner.readInt();
    }

    private void displayTeamInfo(TeamModel team) {
        System.out.println("Nome: " + team.getName());
    }
}
