package br.edu.iftm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Scanner {
    private java.util.Scanner scanner;

    public Scanner() {
        this.scanner = new java.util.Scanner(System.in);
    }

    public String read() {
        try {
            return this.scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Valor inválido, digite novamente");
            return this.read();
        }
    }

    public char readChar() {
        try {
            return this.scanner.nextLine().charAt(0);
        } catch (Exception e) {
            System.out.println("Valor inválido, digite novamente");
            return this.readChar();
        }
    }

    public int readInt() {
        try {
            String value = this.read();
            return Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("Valor inválido, insira um número");
            return this.readInt();
        }
    }

    public Date readDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            String value = this.read();
            return dateFormat.parse(value);
        } catch (Exception e) {
            System.out.println("Formato de data inválido. Insira a data no formato dd/mm/yyyy.");
            return this.readDate();
        }
    }
}
