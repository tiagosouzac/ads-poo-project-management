package br.edu.iftm.actions.members;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Member;
import br.edu.iftm.utils.Scanner;

public class MemberDetails {
    private final MemberDAO dao = new MemberDAO();
    private final Scanner scanner = new Scanner();

    public Member show() {
        try {
            int memberId = this.askMemberId();

            Member member = this.dao.find(memberId);

            this.displayMemberInfo(member);

            return member;
        } catch (Exception e) {
            System.out.println("Integrante não encontrado!");
            return null;
        }
    }

    private int askMemberId() {
        System.out.print("ID do integrante: ");
        return this.scanner.readInt();
    }

    private void displayMemberInfo(Member member) {
        System.out.println(member);
    }
}
