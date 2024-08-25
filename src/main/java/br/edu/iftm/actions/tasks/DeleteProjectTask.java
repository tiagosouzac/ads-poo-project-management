package br.edu.iftm.actions.tasks;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;

public class DeleteProjectTask {
    private final TaskDAO dao = new TaskDAO();
    private final Project project;
    private final Task task;

    public DeleteProjectTask(Project project, Task task) {
        this.project = project;
        this.task = task;
    }

    public void delete() {
        try {
            int projectId = this.project.getId();
            int taskId = this.task.getId();

            if (this.dao.delete(projectId, taskId)) {
                System.out.println("Tarefa excluída com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível excluir a tarefa. Erro: " + e.getMessage());
        }
    }
}
