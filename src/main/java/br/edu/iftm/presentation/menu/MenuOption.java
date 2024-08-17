package br.edu.iftm.presentation.menu;

import br.edu.iftm.actions.Action;

public class MenuOption {
    private String name;
    private Action action;
    private boolean shouldCloseMenu;

    public MenuOption(String name, Action action) {
        this.name = name;
        this.action = action;
        this.shouldCloseMenu = false;
    }

    public MenuOption(String name, Action action, boolean shouldCloseMenu) {
        this.name = name;
        this.action = action;
        this.shouldCloseMenu = shouldCloseMenu;
    }

    public String getName() {
        return this.name;
    }

    public boolean getShouldCloseMenu() {
        return this.shouldCloseMenu;
    }

    public void execute() {
        this.action.execute();
    }
}
