package br.edu.iftm.actions.projects;

import br.edu.iftm.database.daos.TeamDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.utils.Scanner;

public class ChangeProjectTeam {
    private final TeamDAO dao = new TeamDAO();
    private final Scanner scanner = new Scanner();
    private final Project project;

    public ChangeProjectTeam(Project project) {
        this.project = project;
    }

    public void change() {
        int projectId = this.project.getId();
        int teamId = this.askTeamId();

        try {
            if (this.dao.update(teamId, projectId)) {
                System.out.println("Time alterado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível alterar o time. Erro: " + e.getMessage());
        }
    }

    protected int askTeamId() {
        System.out.print("Id do time: ");
        return this.scanner.readInt();
    }
}
