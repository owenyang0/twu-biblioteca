package com.twu.biblioteca;

import com.twu.biblioteca.Controller.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by songyang on 9/19/14.
 */
public class Menu {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Map<String, Command> commandMap;
    private LoginService loginService;
    private boolean cango = true;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Map<String, Command> commandMap, LoginService loginService) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.commandMap = commandMap;
        this.loginService = loginService;
    }

    private boolean isValid() throws IOException {
        return loginService.isLogin() || loginService.auth();
    }

    public void printOptions() throws IOException {
        if (isValid()) {
            printStream.println();
            printStream.println("Please select your option:");

            for (String index : commandMap.keySet()) {
                printStream.println(index + ". " + commandMap.get(index).description());
            }
            printStream.println("Q. Quit");
            printStream.println();
        } else {
            printOptions();
        }
    }

    public void select() throws IOException {
        String input = bufferedReader.readLine();

        if (input.equalsIgnoreCase("q")) {
            cango = false;
            return;
        }

        if (commandMap.containsKey(input)) {
            commandMap.get(input).execute();
        } else {
            printStream.println("Select a valid option!");
        }

    }

    public boolean go() {
        return cango;
    }
}
