package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BibliotecaApp {
    private PrintStream printStream;
    private Menu menu;

    public BibliotecaApp(PrintStream printStream, Menu menu) {
        this.printStream = printStream;
        this.menu = menu;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome!");
        Menu.show();

        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

        while (!input.equals("q")) {
            if (input.equals("1")) {
                new BookService().list();
            } else if (input.equals("2")) {
                input = new BufferedReader(new InputStreamReader(System.in)).readLine();
                System.out.println(new BookService().checkout(Integer.parseInt(input)));
            } else {
                System.out.println("Select a valid option!");
            }

            input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        }
    }

    public void start() {
        printStream.println("Welcome!");

        do {
            menu.printOptions();
            menu.select();
        } while (menu.go());
    }
}
