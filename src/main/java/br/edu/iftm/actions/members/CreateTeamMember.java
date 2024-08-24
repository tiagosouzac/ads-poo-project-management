package br.edu.iftm.actions.members;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Team;
import br.edu.iftm.database.models.Member.Role;

public class CreateTeamMember extends CreateMember {
    private final MemberDAO dao = new MemberDAO();
    private final Team team;

    public CreateTeamMember(Team team) {
        this.team = team;
    }

    public void create() {
        String name = this.askMemberName();
        Role role = this.askMemberRole();
        int teamId = this.team.getId();

        try {
            if (this.dao.store(name, role, teamId)) {
                System.out.println("Membro da equipe criado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar o membro da equipe. Erro: " + e.getMessage());
        }
    }

}
