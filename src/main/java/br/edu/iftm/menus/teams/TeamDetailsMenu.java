package br.edu.iftm.menus.teams;

import br.edu.iftm.actions.teams.AddTeamMember;
import br.edu.iftm.actions.teams.DeleteTeam;
import br.edu.iftm.actions.teams.RemoveTeamMember;
import br.edu.iftm.actions.teams.TeamDetails;
import br.edu.iftm.actions.teams.UpdateTeam;
import br.edu.iftm.database.models.Team;
import br.edu.iftm.menus.Menu;

public class TeamDetailsMenu extends Menu {
    private Team team = null;

    public void display() {
        while (true) {
            this.findTeam();

            if (this.team == null) {
                break;
            }

            this.displayTeamInfo();

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
                    new AddTeamMember(team).add();
                    break;

                case 3:
                    new RemoveTeamMember().remove();
                    break;

                case 4:
                    new DeleteTeam(team).delete();
                    return;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }

            System.out.println();
        }
    }

    private void findTeam() {
        int teamId = this.team == null ? this.askTeamId() : this.team.getId();
        this.team = new TeamDetails().find(teamId);
    }

    private int askTeamId() {
        System.out.print("ID da equipe: ");
        return this.scanner.readInt();
    }

    private void displayTeamInfo() {
        System.out.println("Nome: " + team.getName());
        System.out.println();
    }
}
