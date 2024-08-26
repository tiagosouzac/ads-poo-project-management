package br.edu.iftm.actions.tasks;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;

public class ProjectTaskDetails {
    private final TaskDAO dao = new TaskDAO();
    private final Project project;

    public ProjectTaskDetails(Project project) {
        this.project = project;
    }

    public Task find(int taskId) {
        try {
            int projectId = this.project.getId();
            return this.dao.find(projectId, taskId);
        } catch (Exception e) {
            System.out.println("Tarefa não encontrada!");
            return null;
        }
    }
}
