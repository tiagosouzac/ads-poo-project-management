package br.edu.iftm.menus.members;

import br.edu.iftm.actions.members.DeleteMember;
import br.edu.iftm.actions.members.MemberDetails;
import br.edu.iftm.database.models.Member;
import br.edu.iftm.menus.Menu;

public class MemberDetailsMenu extends Menu {
    public void display() {
        while (true) {
            Member member = new MemberDetails().show();

            if (member == null) {
                break;
            }

            System.out.println("1. Atualizar funcionário");
            System.out.println("2. Excluir funcionário");
            System.out.println("0. Voltar para o menu de funcionários");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:
                    new DeleteMember(member).delete();
                    return;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }

            System.out.println();
        }
    }
}
