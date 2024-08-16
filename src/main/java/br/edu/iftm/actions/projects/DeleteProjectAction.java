package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.repositories.projects.DeleteProjectRepository;
import br.edu.iftm.utils.Scanner;

public class DeleteProjectAction implements Action {
    public void execute() {
        Scanner scanner = new Scanner();
        DeleteProjectRepository repository = new DeleteProjectRepository();

        int id = this.askProjectId(scanner);

        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int askProjectId(Scanner scanner) {
        System.out.print("ID do projeto: ");
        return scanner.readInt();
    }
}
