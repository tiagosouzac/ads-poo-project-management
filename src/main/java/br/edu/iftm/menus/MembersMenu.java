package br.edu.iftm.menus;

import br.edu.iftm.utils.Scanner;

public class MembersMenu extends Menu {
    private final Scanner scanner = new Scanner();

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
                    this.displayMemberDetailsMenu();
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

    private void displayMemberDetailsMenu() {
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
