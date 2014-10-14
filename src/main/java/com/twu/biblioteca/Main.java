package com.twu.biblioteca;

import com.twu.biblioteca.Controller.CheckoutBookCommand;
import com.twu.biblioteca.Controller.Command;
import com.twu.biblioteca.Controller.ListBooksCommand;
import com.twu.biblioteca.Controller.ReturnBooksCommand;
import com.twu.biblioteca.Dao.BookDao;
import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Services.BookService;
import com.twu.biblioteca.Services.Login;
import com.twu.biblioteca.Services.LoginService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by songyang on 9/28/14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BookDao bookDao = new BookDao();
        BookService bookService = new BookService(bookDao);

        UserDao userDao = new UserDao();
        Login login = new Login(printStream, userDao);
        LoginService loginService = new LoginService(printStream, reader, login);

        Map<String, Command> commandMap = new HashMap();
        commandMap.put("1", new ListBooksCommand(printStream, bookService));
        commandMap.put("2", new CheckoutBookCommand(printStream, reader, bookService));
        commandMap.put("3", new ReturnBooksCommand(printStream, reader, bookService));

        Menu menu = new Menu(printStream, reader, commandMap, loginService);
        BibliotecaApp app = new BibliotecaApp(printStream, menu);

        app.start();
    }
}
