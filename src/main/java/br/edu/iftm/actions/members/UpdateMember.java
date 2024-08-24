package br.edu.iftm.actions.members;

import br.edu.iftm.database.daos.MemberDAO;
import br.edu.iftm.database.models.Member;
import br.edu.iftm.database.models.Member.Role;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class UpdateMember {
    private final MemberDAO dao = new MemberDAO();
    private final Scanner scanner = new Scanner();
    private final Member member;

    public UpdateMember(Member member) {
        this.member = member;
    }

    public void update() {
        int id = this.member.getId();
        String name = this.askMemberName(this.member.getName());
        Role role = this.askMemberRole(this.member.getRole());

        try {
            if (this.dao.update(id, name, role)) {
                System.out.println("Funcionário atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o funcionário. Erro: " + e.getMessage());
        }
    }

    protected String askMemberName(String currentName) {
        String name;

        do {
            System.out.println("Nome atual: " + currentName);
            System.out.print("Novo nome do funcionário (deixe vazio para manter o atual): ");
            name = this.scanner.read().trim();

            if (Validator.string.isEmpty(name)) {
                name = currentName;
                break;
            }

            if (!Validator.member.isValidName(name)) {
                System.out.println("Nome é obrigatório!");
            }
        } while (!Validator.member.isValidName(name));

        return name;
    }

    protected Role askMemberRole(Role currentRole) {
        Role role = null;

        System.out.println("Cargo atual: " + currentRole);
        System.out.println("Deseja alterar? (s/n)");

        char changeRole = this.scanner.readChar();

        if (changeRole == 'n') {
            return currentRole;
        }

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
}
