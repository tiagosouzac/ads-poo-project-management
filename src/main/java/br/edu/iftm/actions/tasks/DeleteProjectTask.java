package br.edu.iftm.actions.tasks;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.utils.Scanner;

public class DeleteProjectTask {
    private final TaskDAO dao = new TaskDAO();
    private final Scanner scanner = new Scanner();
    private final Project project;

    public DeleteProjectTask(Project project) {
        this.project = project;
    }

    public void delete() {
        try {
            int projectId = this.project.getId();
            int taskId = this.askTaskId();

            if (this.dao.delete(projectId, taskId)) {
                System.out.println("Tarefa excluída com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível excluir a tarefa. Erro: " + e.getMessage());
        }
    }

    protected int askTaskId() {
        System.out.print("ID da tarefa que será removida: ");
        return this.scanner.readInt();
    }
}
