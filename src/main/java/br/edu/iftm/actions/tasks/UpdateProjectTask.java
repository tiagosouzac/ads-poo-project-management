package br.edu.iftm.actions.tasks;

import java.util.Date;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.database.models.Task.Status;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class UpdateProjectTask {
    private final TaskDAO dao = new TaskDAO();
    private final Scanner scanner = new Scanner();
    private final Project project;
    private final Task task;

    public UpdateProjectTask(Project project, Task task) {
        this.project = project;
        this.task = task;
    }

    public void update() {
        try {
            int projectId = this.project.getId();
            int taskId = this.askTaskId();
            String description = this.askProjectTaskDescription(this.task.getDescription());
            Date completionDate = this.askProjectTaskCompletionDate(this.task.getCompletionDate());
            Status status = this.askProjectTaskStatus(this.task.getStatus());

            if (this.dao.update(projectId, taskId, description, completionDate, status)) {
                System.out.println("Tarefa atualizada com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar a tarefa. Erro: " + e.getMessage());
        }
    }

    private int askTaskId() {
        System.out.print("ID da tarefa que será removida: ");
        return this.scanner.readInt();
    }

    private String askProjectTaskDescription(String currentDescription) {
        String description;

        do {
            System.out.println("Descrição atual: " + currentDescription);
            System.out.print("Nova descrição da tarefa (deixe vazio para manter a atual): ");
            description = this.scanner.read().trim();

            if (Validator.string.isEmpty(description)) {
                description = currentDescription;
                break;
            }

            if (!Validator.project.isValidDescription(description)) {
                System.out.println("A descrição deve ter no máximo 255 caracteres!");
            }
        } while (!Validator.project.isValidDescription(description));

        return description;
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

    private Date askProjectTaskCompletionDate(Date currentStartDate) {
        Date completionDate = null;

        System.out.println("Data de entrega: " + currentStartDate);
        System.out.println("Deseja alterar essa data? (s/n)");

        char changeStatus = this.scanner.readChar();

        if (changeStatus == 'n') {
            return currentStartDate;
        }

        do {
            System.out.println("Nova data de entrega: ");
            completionDate = this.scanner.readDate();
        } while (completionDate == null);

        return completionDate;
    }
}
