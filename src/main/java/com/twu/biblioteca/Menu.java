package com.twu.biblioteca;

import com.twu.biblioteca.Controller.Command;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by songyang on 9/19/14.
 */
public class Menu {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Map<String, Command> commandMap;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Map<String, Command> commandMap) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.commandMap = commandMap;
    }

    public static void show() {
        System.out.println("1. List Books");
        System.out.println("2. Checkout Book");

        System.out.println("Select Option: ");
    }

    public void printOptions() {
        printStream.println("Please select your option:");

        for (String index : commandMap.keySet()) {
            printStream.println(index + ". " + commandMap.get(index).description());
        }
    }

    public void select() {

    }

    public boolean go() {
        return true;
    }
}
