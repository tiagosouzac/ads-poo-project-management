package br.edu.iftm.menus;

import br.edu.iftm.utils.Scanner;

public abstract class Menu {
    protected final Scanner scanner = new Scanner();

    public abstract void display();

    protected void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
