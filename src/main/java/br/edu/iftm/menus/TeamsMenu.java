package br.edu.iftm.menus;

import br.edu.iftm.utils.Scanner;

public class TeamsMenu extends Menu {
    private final Scanner scanner = new Scanner();

    public void display() {
        while (true) {
            System.out.println("1. Listar equipes");
            System.out.println("2. Ver detalhes de uma equipe");
            System.out.println("0. Voltar para o menu inicial");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:
                    this.displayTeamDetailsMenu();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }
        }
    }

    private void displayTeamDetailsMenu() {
        while (true) {
            System.out.println("1. Atualizar informações da equipe");
            System.out.println("2. Adicionar integrante na equipe");
            System.out.println("3. Remover integrante da equipe");
            System.out.println("4. Excluir equipe");
            System.out.println("0. Voltar para o menu de equipes");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

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
