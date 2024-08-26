package br.edu.iftm.actions.tasks;

import java.util.Date;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.utils.Scanner;
import br.edu.iftm.utils.Validator;

public class CreateProjectTask {
    private final TaskDAO dao = new TaskDAO();
    private final Scanner scanner = new Scanner();
    private final Project project;

    public CreateProjectTask(Project project) {
        this.project = project;
    }

    public void create() {
        try {
            String description = this.askTaskDescription();
            Date completionDate = this.askTaskCompletionDate();
            int projectId = this.project.getId();

            if (this.dao.store(projectId, description, completionDate)) {
                System.out.println("Tarefa criada com succeso!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar a tarefa. Erro: " + e.getMessage());
        }
    }

    private String askTaskDescription() {
        String description;

        do {
            System.out.print("Descrição da tarefa: ");
            description = this.scanner.read().trim();

            if (!Validator.task.isValidDescription(description)) {
                System.out.println("A descrição deve ter no máximo 255 caracteres!");
            }
        } while (!Validator.task.isValidDescription(description));

        return description;
    }

    private Date askTaskCompletionDate() {
        Date completionDate = null;
        Date projectStartAt = this.project.getStartAt();
        Date projectEndAt = this.project.getEndAt();

        do {
            System.out.println("Data de entrega: ");
            completionDate = this.scanner.readDate();

            if (!Validator.task.isValidCompletionDate(completionDate, projectStartAt, projectEndAt)) {
                System.out.println("Data está fora do prazo do projeto! O projeto inicia em: " + projectStartAt
                        + " e finaliza em " + projectEndAt);
                completionDate = null;
            }
        } while (completionDate == null);

        return completionDate;
    }
}
