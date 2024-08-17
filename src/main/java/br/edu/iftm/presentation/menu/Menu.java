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

    public void addOption(String name, Action action) {
        int key = this.options.size() + 1;
        MenuOption option = new MenuOption(name, action);
        this.options.put(key, option);
    }

    public void addOption(int key, String name, Action action) {
        MenuOption option = new MenuOption(name, action);
        this.options.put(key, option);
    }

    public void addCloseOption(String name) {
        this.addOption(0, name, () -> {
        });
    }

    private void listOptions() {
        this.options.forEach((key, action) -> {
            System.out.println(key + ". " + action.getName());
        });
    }

    private void handle(int optionKey) {
        MenuOption option = this.options.get(optionKey);

        if (option == null) {
            System.out.println("Opção inválida!");
            return;
        }

        try {
            option.execute();
        } catch (Exception e) {
            System.out.println("Erro ao executar a ação: " + e.getMessage());
        }
    }

    private int askOption() {
        Scanner scanner = new Scanner();
        int selectedOption;

        while (true) {
            System.out.println();
            this.listOptions();

            selectedOption = scanner.readInt();
            this.clearConsole();
            this.handle(selectedOption);

            if (this.options.containsKey(selectedOption)) {
                break;
            }
        }

        return selectedOption;
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void display() {
        int selectedOption;

        do {
            selectedOption = this.askOption();
        } while (selectedOption != 0);
    }
}
