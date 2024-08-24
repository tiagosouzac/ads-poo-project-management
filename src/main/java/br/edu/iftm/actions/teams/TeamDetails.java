package br.edu.iftm.actions.teams;

import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.Team;
import br.edu.iftm.utils.Scanner;

public class TeamDetails {
    private final TeamDAO dao = new TeamDAO();
    private final Scanner scanner = new Scanner();

    public Team show() {
        try {
            int teamId = this.askTeamId();

            Team team = this.dao.find(teamId);

            this.displayTeamInfo(team);

            return team;
        } catch (Exception e) {
            System.out.println("Equipe não encontrada!");
            return null;
        }
    }

    private int askTeamId() {
        System.out.print("ID da equipe: ");
        return this.scanner.readInt();
    }

    private void displayTeamInfo(Team team) {
        System.out.println("Nome: " + team.getName());
        
    }
}
