package br.edu.iftm.actions.teams;

import br.edu.iftm.actions.Action;
import br.edu.iftm.repositories.teams.ListTeamsRepository;

public class ListTeamsAction implements Action {
    public void execute() {
        ListTeamsRepository repository = new ListTeamsRepository();
        repository.list();
    }
}
