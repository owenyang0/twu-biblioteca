package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by songyang on 10/5/14.
 */
public class Login {
    private PrintStream printStream;
    private UserDao userDao;

    public Login(PrintStream printStream, UserDao userDao) {
        this.printStream = printStream;
        this.userDao = userDao;
    }
}
