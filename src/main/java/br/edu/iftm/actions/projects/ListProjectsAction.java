package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.repositories.projects.ListProjectsRepository;

public class ListProjectsAction implements Action {
    public void execute() {
        ListProjectsRepository repository = new ListProjectsRepository();
        repository.list();
    }
}
