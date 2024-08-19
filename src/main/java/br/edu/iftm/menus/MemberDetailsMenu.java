package br.edu.iftm.menus;

public class MemberDetailsMenu extends Menu {
    public void display() {
        while (true) {
            System.out.println("1. Atualizar funcionário");
            System.out.println("2. Excluir funcionário");
            System.out.println("0. Voltar para o menu de funcionários");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:

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
