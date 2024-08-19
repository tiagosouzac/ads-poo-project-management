package br.edu.iftm.menus;

public class MembersMenu extends Menu {
    public void display() {
        while (true) {
            System.out.println("1. Listar todos os funcionários");
            System.out.println("2. Ver detalhes do funcionário");
            System.out.println("3. Criar novo funcionário");
            System.out.println("0. Voltar para o menu inicial");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:
                    new MemberDetailsMenu().display();
                    break;

                case 3:

                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }
        }
    }
}
