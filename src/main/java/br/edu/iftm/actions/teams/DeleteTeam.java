package br.edu.iftm.actions.teams;

import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.Team;

public class DeleteTeam {
    private final TeamDAO dao = new TeamDAO();
    private final Team team;

    public DeleteTeam(Team team) {
        this.team = team;
    }

    public void delete() {
        try {
            if (this.dao.delete(this.team.getId())) {
                System.out.println("Equipe excluída com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível excluir a equipe. Erro: " + e.getMessage());
        }
    }
}
