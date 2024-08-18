package br.edu.iftm.actions.members;

import java.util.List;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.MemberModel;
import br.edu.iftm.database.models.TeamModel;

public class ListTeamMembersAction implements Action {
    private final MemberDAO dao = new MemberDAO();
    private final TeamModel team;

    public ListTeamMembersAction(TeamModel team) {
        this.team = team;
    }

    public void execute() {
        List<MemberModel> members = this.dao.list(this.team.getId());

        if (!members.isEmpty()) {
            for (MemberModel member : members) {
                System.out.println(member.getId() + ". " + member.getName());
            }
        } else {
            System.out.println("Nenhum membro cadastrado ainda!");
        }
    }
}
