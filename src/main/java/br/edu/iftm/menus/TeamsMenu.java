package br.edu.iftm.menus;

public class TeamsMenu extends Menu {
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
                    new TeamDetailsMenu().display();
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
