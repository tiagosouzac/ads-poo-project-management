package br.edu.iftm.actions.teams;

import java.util.List;

import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.Team;

public class ListTeams {
    private final TeamDAO dao = new TeamDAO();

    public void list() {
        List<Team> teams = this.dao.list();

        if (!teams.isEmpty()) {
            for (Team team : teams) {
                System.out.println(team.getId() + ". " + team.getName());
            }
        } else {
            System.out.println("Nenhuma equipe cadastrado ainda!");
        }
    }
}
