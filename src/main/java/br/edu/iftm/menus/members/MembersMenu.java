package br.edu.iftm.menus.members;

import br.edu.iftm.actions.members.CreateMember;
import br.edu.iftm.actions.members.ListMembers;
import br.edu.iftm.menus.Menu;

public class MembersMenu extends Menu {
    public void display() {
        while (true) {
            System.out.println("1. Listar todos os funcionários");
            System.out.println("2. Criar novo funcionário");
            System.out.println("3. Ver detalhes do funcionário");
            System.out.println("0. Voltar para o menu inicial");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new ListMembers().list();
                    break;

                case 2:
                    new CreateMember().create();
                    break;

                case 3:
                    new MemberDetailsMenu().display();
                    break;

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
