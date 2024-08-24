package br.edu.iftm.actions.members;

import java.util.List;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Member;

public class ListMembers {
    private final MemberDAO dao = new MemberDAO();

    public void list() {
        List<Member> members = this.dao.list();

        if (!members.isEmpty()) {
            for (Member member : members) {
                System.out.println(member.getId() + ". " + member.getName());
            }
        } else {
            System.out.println("Nenhum funcionário cadastrado ainda!");
        }
    }
}
