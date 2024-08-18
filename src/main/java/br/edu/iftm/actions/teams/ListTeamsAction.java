package br.edu.iftm.actions.teams;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.Team;

public class ListTeamsAction implements Action {
    private final TeamDAO dao = new TeamDAO();

    public void execute() {
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
