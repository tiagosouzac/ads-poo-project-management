package br.edu.iftm;

import br.edu.iftm.presentation.menus.MainMenu;

public class Application {
    public void run() {
        MainMenu menu = new MainMenu();
        menu.handle(2);
    }
}
