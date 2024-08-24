package br.edu.iftm.menus;

import br.edu.iftm.actions.teams.CreateTeam;
import br.edu.iftm.actions.teams.ListTeams;

public class TeamsMenu extends Menu {
    public void display() {
        while (true) {
            System.out.println("1. Listar equipes");
            System.out.println("2. Criar uma equipe");
            System.out.println("3. Ver detalhes de uma equipe");
            System.out.println("0. Voltar para o menu inicial");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new ListTeams().list();
                    break;

                case 2:
                    new CreateTeam().create();
                    break;

                case 3:
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
