package com.twu.biblioteca;

import com.twu.biblioteca.Controller.Command;
import com.twu.biblioteca.Controller.ListBooksCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by songyang on 9/28/14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BookService bookService = new BookService();

        Map<String, Command> commandMap = new HashMap();
        commandMap.put("1", new ListBooksCommand(bookService));

        Menu menu = new Menu(printStream, reader, commandMap);
        BibliotecaApp app = new BibliotecaApp(printStream, menu);

        app.start();
    }
}