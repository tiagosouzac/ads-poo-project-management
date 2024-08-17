package br.edu.iftm.presentation.menu;

import java.util.HashMap;
import java.util.Map;
import br.edu.iftm.actions.Action;
import br.edu.iftm.utils.Scanner;

public class Menu {
    private Map<Integer, MenuOption> options;

    public Menu() {
        this.options = new HashMap<Integer, MenuOption>();
    }

    private void add(int key, String name, Action action, boolean shouldCloseMenu) {
        MenuOption option = new MenuOption(name, action, shouldCloseMenu);
        this.options.put(key, option);
    }

    private void add(String name, Action action, boolean shouldCloseMenu) {
        int key = this.options.size() + 1;
        this.add(key, name, action, shouldCloseMenu);
    }

    protected void addOption(String name, Action action) {
        this.add(name, action, false);
    }

    protected void addOption(int key, String name, Action action) {
        this.add(key, name, action, false);
    }

    protected void addCloseOption(String name) {
        this.add(name, () -> {
        }, true);
    }

    protected void addCloseOption(String name, Action action) {
        this.add(name, action, true);
    }

    protected void addCloseOption(int key, String name, Action action) {
        this.add(key, name, action, true);
    }

    private void listOptions() {
        System.out.println();

        this.options.forEach((key, option) -> {
            System.out.println(key + ". " + option.getName());
        });
    }

    private boolean askOption() {
        Scanner scanner = new Scanner();

        int selectedOption;
        boolean shouldCloseMenu = false;

        do {
            this.listOptions();

            selectedOption = scanner.readInt();

            this.clearConsole();

            shouldCloseMenu = this.handle(selectedOption);
        } while (!this.options.containsKey(selectedOption));

        return shouldCloseMenu;
    }

    private boolean handle(int selectedOption) {
        MenuOption option = this.options.get(selectedOption);

        if (option == null) {
            System.out.println("Opção inválida!");
            return false;
        }

        try {
            option.execute();
        } catch (Exception e) {
            System.out.println("Não foi possível executar a opção \"" + option.getName() + "\"");
        }

        return option.getShouldCloseMenu();
    }

    public void display() {
        boolean shouldCloseMenu = false;

        do {
            shouldCloseMenu = this.askOption();
        } while (!shouldCloseMenu);
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
