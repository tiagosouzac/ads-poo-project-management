package br.edu.iftm.menus.members;

import br.edu.iftm.actions.members.DeleteMember;
import br.edu.iftm.actions.members.MemberDetails;
import br.edu.iftm.actions.members.UpdateMember;
import br.edu.iftm.actions.members.UpdateMemberTeam;
import br.edu.iftm.database.models.Member;
import br.edu.iftm.menus.Menu;

public class MemberDetailsMenu extends Menu {
    private Member member;

    public void display() {
        while (true) {
            this.findMember();

            if (this.member == null) {
                break;
            }

            this.displayMemberInfo();

            System.out.println("1. Atualizar funcionário");
            System.out.println("2. Mudar de time");
            System.out.println("3. Excluir funcionário");
            System.out.println("0. Voltar para o menu de funcionários");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new UpdateMember(member).update();
                    break;

                case 2:
                    new UpdateMemberTeam(member).update();
                    return;

                case 3:
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

    private void findMember() {
        int memberId = this.member == null ? this.askMemberId() : this.member.getId();
        this.member = new MemberDetails().find(memberId);
    }

    private int askMemberId() {
        System.out.print("ID do integrante: ");
        return this.scanner.readInt();
    }

    private void displayMemberInfo() {
        System.out.println(this.member);
        System.out.println();
    }
}
