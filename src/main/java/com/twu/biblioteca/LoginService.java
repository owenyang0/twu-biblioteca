package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by songyang on 10/7/14.
 */
public class LoginService {
    private PrintStream printStream;
    private BufferedReader reader;
    private Login login;

    public LoginService(PrintStream printStream, BufferedReader reader, Login login) {
        this.printStream = printStream;
        this.reader = reader;
        this.login = login;
    }

    public boolean auth() throws IOException {
        printStream.println("Please login first with your library number and password!");

        printStream.println("Library NO: ");
        String libraryNO = reader.readLine();
        printStream.println("Password: ");
        String passwords = reader.readLine();

        if (login.author(libraryNO, passwords)) {
            printStream.println("Login success!");
            return true;
        }
        return false;
    }

    public boolean isLogin() {
        if (login.isLogin()) {
            return true;
        } else {
            printStream.println("You don't have access to continue, please login first!");
            return false;
        }

    }
}
