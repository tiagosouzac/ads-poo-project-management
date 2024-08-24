package br.edu.iftm.menus;

import br.edu.iftm.actions.teams.DeleteTeam;
import br.edu.iftm.actions.teams.TeamDetails;
import br.edu.iftm.actions.teams.UpdateTeam;
import br.edu.iftm.database.models.Team;

public class TeamDetailsMenu extends Menu {
    public void display() {
        while (true) {
            Team team = new TeamDetails().show();

            System.out.println("1. Atualizar informações da equipe");
            System.out.println("2. Adicionar integrante na equipe");
            System.out.println("3. Remover integrante da equipe");
            System.out.println("4. Excluir equipe");
            System.out.println("0. Voltar para o menu de equipes");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:
                    new UpdateTeam(team).update();
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    new DeleteTeam(team).delete();
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
