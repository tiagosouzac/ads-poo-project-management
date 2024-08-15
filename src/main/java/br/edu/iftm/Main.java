package br.edu.iftm;

import br.edu.iftm.presentation.menus.MainMenu;
import br.edu.iftm.utils.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.handle(1);
        menu.handle(2);
        menu.show();

        Scanner scanner = new Scanner();
        int value = scanner.readInt();

        System.out.println(value);
    }
}
