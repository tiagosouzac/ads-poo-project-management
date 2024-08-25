package br.edu.iftm.actions.tasks;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.database.models.Task.Status;
import br.edu.iftm.utils.Scanner;

public class UpdateProjectTaskStatus {
    private final TaskDAO dao = new TaskDAO();
    private final Scanner scanner = new Scanner();
    private final Project project;
    private final Task task;

    public UpdateProjectTaskStatus(Project project, Task task) {
        this.project = project;
        this.task = task;
    }

    public void update() {
        try {
            int projectId = this.project.getId();
            int taskId = this.task.getId();
            Status status = this.askProjectTaskStatus(this.task.getStatus());

            if (this.dao.update(projectId, taskId, status)) {
                System.out.println("Status da tarefa atualizada com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o status da tarefa. Erro: " + e.getMessage());
        }
    }

    private Status askProjectTaskStatus(Status currentStatus) {
        Status status = null;

        System.out.println("Status da tarefa: " + currentStatus);
        System.out.println("Deseja alterar esse status? (s/n)");

        char changeStatus = this.scanner.readChar();

        if (changeStatus == 'n') {
            return currentStatus;
        }

        System.out.println("1. " + Status.PENDING);
        System.out.println("2. " + Status.IN_PROGRESS);
        System.out.println("3. " + Status.FINISHED);

        do {
            int selectedStatus = this.scanner.readInt();

            switch (selectedStatus) {
                case 1:
                    status = Status.PENDING;
                    break;

                case 2:
                    status = Status.IN_PROGRESS;
                    break;

                case 3:
                    status = Status.FINISHED;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (status == null);

        return status;
    }
}
