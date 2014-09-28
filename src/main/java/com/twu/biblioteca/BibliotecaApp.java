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

    public void start() throws IOException {
        printStream.println("Welcome!");

        do {
            menu.printOptions();
            menu.select();
        } while (menu.go());
    }
}
