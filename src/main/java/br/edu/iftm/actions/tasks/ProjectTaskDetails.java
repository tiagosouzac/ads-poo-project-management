package br.edu.iftm.actions.tasks;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.utils.Scanner;

public class ProjectTaskDetails {
    private final TaskDAO dao = new TaskDAO();
    private final Scanner scanner = new Scanner();
    private final Project project;

    public ProjectTaskDetails(Project project) {
        this.project = project;
    }

    public Task show() {
        try {
            int projectId = this.project.getId();
            int taskId = this.askTaskId();

            Task task = this.dao.find(projectId, taskId);

            this.displayProjectTaskInfo(task);

            return task;
        } catch (Exception e) {
            System.out.println("Tarefa não encontrada!");
            return null;
        }
    }

    private int askTaskId() {
        System.out.print("ID da tarefa: ");
        return this.scanner.readInt();
    }

    private void displayProjectTaskInfo(Task task) {
        System.out.println("[" + task.getStatus() + "] " + task.getDescription());
        System.out.println("Data de entrega: " + task.getCompletionDate());
    }
}
