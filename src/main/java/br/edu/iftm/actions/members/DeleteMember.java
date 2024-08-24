package br.edu.iftm.actions.members;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Member;

public class DeleteMember {
    private final MemberDAO dao = new MemberDAO();
    private final Member member;

    public DeleteMember(Member member) {
        this.member = member;
    }

    public void delete() {
        try {
            if (this.dao.delete(this.member.getId())) {
                System.out.println("Funcionário excluído com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível excluir o funcionário. Erro: " + e.getMessage());
        }
    }
}
