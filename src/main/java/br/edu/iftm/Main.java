package br.edu.iftm;

import br.edu.iftm.presentation.menus.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.handle(1);
        menu.handle(2);
        menu.show();
    }
}
