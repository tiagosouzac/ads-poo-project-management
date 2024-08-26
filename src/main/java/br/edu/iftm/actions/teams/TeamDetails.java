package br.edu.iftm.actions.teams;

import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.Team;

public class TeamDetails {
    private final TeamDAO dao = new TeamDAO();

    public Team find(int teamId) {
        try {
            return this.dao.find(teamId);
        } catch (Exception e) {
            System.out.println("Equipe não encontrada!");
            return null;
        }
    }
}
