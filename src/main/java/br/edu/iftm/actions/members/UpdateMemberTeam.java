package br.edu.iftm.actions.members;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Member;
import br.edu.iftm.utils.Scanner;

public class UpdateMemberTeam {
    private final MemberDAO dao = new MemberDAO();
    private final Scanner scanner = new Scanner();
    private final Member member;

    public UpdateMemberTeam(Member member) {
        this.member = member;
    }

    public void update() {
        int id = this.member.getId();
        Integer teamId = this.askTeamId(this.member.getTeamId());

        try {
            if (this.dao.update(id, teamId)) {
                System.out.println("Time do funcionário atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar time do funcionário. Erro: " + e.getMessage());
        }
    }

    protected int askTeamId(int currentTeamId) {
        System.out.println("Realmente deseja alterar? (s/n)");

        char changeTeamId = this.scanner.readChar();

        if (changeTeamId == 'n') {
            return currentTeamId;
        }

        System.out.println("ID time atual: " + currentTeamId);
        System.out.print("Novo ID do time: ");
        int teamId = this.scanner.readInt();

        return teamId;
    }
}
