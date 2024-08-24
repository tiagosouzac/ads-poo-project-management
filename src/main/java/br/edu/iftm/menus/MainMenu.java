package br.edu.iftm.menus;

import br.edu.iftm.menus.members.MembersMenu;
import br.edu.iftm.menus.projects.ProjectsMenu;
import br.edu.iftm.menus.teams.TeamsMenu;

public class MainMenu extends Menu {
    public void display() {
        while (true) {
            System.out.println("1. Gerenciar projetos");
            System.out.println("2. Gerenciar equipes");
            System.out.println("3. Gerenciar funcionários");
            System.out.println("0. Encerrar o programa");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new ProjectsMenu().display();
                    break;

                case 2:
                    new TeamsMenu().display();
                    break;

                case 3:
                    new MembersMenu().display();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente!");
                    break;
            }
        }
    }
}
