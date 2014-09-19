package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome!");
        Menu.show();

        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

        while (!input.equals("q")) {
            if (input.equals("1")) {
                new BookService().list();
            } else {
                System.out.println("Select a valid option!");
            }

            input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        }
    }
}
