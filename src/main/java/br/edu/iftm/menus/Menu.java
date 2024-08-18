package br.edu.iftm.menus;

public abstract class Menu {
    public abstract void display();

    protected void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
