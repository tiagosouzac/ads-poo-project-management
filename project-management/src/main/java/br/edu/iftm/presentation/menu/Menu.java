package br.edu.iftm.presentation.menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, MenuOption> options;

    public Menu() {
        this.options = new HashMap<Integer, MenuOption>();
    }

    public void addOption(String name, MenuAction action) {
        int key = this.options.size() + 1;
        MenuOption option = new MenuOption(name, action);
        this.options.put(key, option);
    }

    public void handle(int optionKey) {
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
}
