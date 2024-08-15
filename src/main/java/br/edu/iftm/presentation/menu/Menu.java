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

    protected void askOption() {
        Scanner scanner = new Scanner();

        while (true) {
            this.listOptions();

            int selectedOption = scanner.readInt();
            this.handle(selectedOption);

            if (this.options.containsKey(selectedOption)) {
                break;
            }
        }
    }
}
