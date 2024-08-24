package br.edu.iftm.actions.teams;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.utils.Scanner;

public class RemoveTeamMember {
    private final MemberDAO dao = new MemberDAO();
    private final Scanner scanner = new Scanner();

    public void remove() {
        int id = this.askMemberId();

        try {
            if (this.dao.update(id, null)) {
                System.out.println("Integrante removido com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível remover o integrante. Erro: " + e.getMessage());
        }
    }

    protected int askMemberId() {
        System.out.print("Id do integrante que será removido: ");
        return this.scanner.readInt();
    }
}
