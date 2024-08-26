package br.edu.iftm.actions.members;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Member;

public class MemberDetails {
    private final MemberDAO dao = new MemberDAO();

    public Member find(int memberId) {
        try {
            return this.dao.find(memberId);
        } catch (Exception e) {
            System.out.println("Integrante não encontrado!");
            return null;
        }
    }
}
