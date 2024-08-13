package br.edu.iftm.actions;

import br.edu.iftm.repositories.ListProjectsRepository;

public class ListProjectsAction {
    private ListProjectsRepository listProjectRepository;

    public ListProjectsAction(ListProjectsRepository listProjectRepository) {
        this.listProjectRepository = listProjectRepository;
    }

    public void execute() {
        this.listProjectRepository.list();
    }
}
