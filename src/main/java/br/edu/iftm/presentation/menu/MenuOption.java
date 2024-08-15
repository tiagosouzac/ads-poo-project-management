package br.edu.iftm.presentation.menu;

import br.edu.iftm.actions.Action;

public class MenuOption {
    private String name;
    private Action action;

    public MenuOption(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        this.action.execute();
    }
}
