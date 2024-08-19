package br.edu.iftm.menus;

public class ProjectDetailsMenu extends Menu {
    public void display() {
        while (true) {
            System.out.println("1. Atualizar o projeto");
            System.out.println("2. Excluir o projeto");
            System.out.println("0. Voltar para o menu de projetos");

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
