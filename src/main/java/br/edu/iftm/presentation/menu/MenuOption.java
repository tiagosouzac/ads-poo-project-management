package br.edu.iftm.presentation.menu;

public class MenuOption {
    private String name;
    private MenuAction action;

    public MenuOption(String name, MenuAction action) {
        this.name = name;
        this.action = action;
    }

    public void execute() {
        this.action.execute();
    }
}
