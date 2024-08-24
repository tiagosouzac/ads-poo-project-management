package br.edu.iftm.actions.teams;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Team;
import br.edu.iftm.utils.Scanner;

public class AddTeamMember {
    private final MemberDAO dao = new MemberDAO();
    private final Scanner scanner = new Scanner();
    private final Team team;

    public AddTeamMember(Team team) {
        this.team = team;
    }

    public void add() {
        int id = this.askMemberId();
        int teamId = this.team.getId();

        try {
            if (this.dao.update(id, teamId)) {
                System.out.println("Integrante adicionado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível adicionar o integrante. Erro: " + e.getMessage());
        }
    }

    protected int askMemberId() {
        System.out.print("Id do novo integrante: ");
        return this.scanner.readInt();
    }
}
