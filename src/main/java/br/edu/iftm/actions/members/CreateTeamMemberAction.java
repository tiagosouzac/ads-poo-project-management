package br.edu.iftm.actions.members;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.MemberModel.Role;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class CreateTeamMemberAction implements Action {
    private final MemberDAO dao = new MemberDAO();
    private final Scanner scanner = new Scanner();

    public void execute() {
        String name = this.askMemberName();
        Role role = this.askMemberRole();
        int teamId = this.askTeamId();

        try {
            if (this.dao.store(name, role, teamId)) {
                System.out.println("Membro da equipe criado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar o membro da equipe. Erro: " + e.getMessage());
        }
    }

    private String askMemberName() {
        String name;

        do {
            System.out.print("Nome: ");
            name = this.scanner.read().trim();

            if (!Validator.member.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!Validator.member.isValidName(name));

        return name;
    }

    private Role askMemberRole() {
        Role role = null;

        System.out.println("Cargo:");
        System.out.println("1. " + Role.DEVELOPER);
        System.out.println("2. " + Role.DESIGNER);
        System.out.println("3. " + Role.MANAGER);

        do {
            int selectedRole = this.scanner.readInt();

            switch (selectedRole) {
                case 1:
                    role = Role.DEVELOPER;
                    break;

                case 2:
                    role = Role.DESIGNER;
                    break;

                case 3:
                    role = Role.MANAGER;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (role == null);

        return role;
    }

    private int askTeamId() {
        System.out.print("ID da equipe: ");
        return this.scanner.readInt();
    }
}
