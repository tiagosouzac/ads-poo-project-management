package br.edu.iftm;

import br.edu.iftm.presentation.menus.MainMenu;

public class Main {
    public static void main(String[] args) {
        while (true) {
            MainMenu menu = new MainMenu();
            menu.display();
        }
    }
}
