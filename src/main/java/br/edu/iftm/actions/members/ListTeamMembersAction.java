package br.edu.iftm.actions.members;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Member;
import br.edu.iftm.database.models.Team;

public class ListTeamMembersAction implements Action {
    private final MemberDAO dao = new MemberDAO();
    private final Team team;

    public ListTeamMembersAction(Team team) {
        this.team = team;
    }

    public void execute() {
        List<Member> members = this.dao.list(this.team.getId());

        if (!members.isEmpty()) {
            for (Member member : members) {
                System.out.println(member.getId() + ". " + member.getName());
            }
        } else {
            System.out.println("Nenhum membro cadastrado ainda!");
        }
    }
}
