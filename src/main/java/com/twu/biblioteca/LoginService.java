package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by songyang on 10/7/14.
 */
public class LoginService {
    private PrintStream printStream;
    private Login login;

    public LoginService(PrintStream printStream, Login login) {
        this.printStream = printStream;
        this.login = login;
    }

//    public boolean author(String libraryNumber, String password) {
//        return super.author(libraryNumber, password);
//    }

    public boolean isLogin() {
        if (login.isLogin()) {
            return true;
        } else {
            printStream.println("You don't have access to continue, please login first!");
            return false;
        }

    }
}
