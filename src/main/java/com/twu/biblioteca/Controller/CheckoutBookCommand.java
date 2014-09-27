package com.twu.biblioteca.Controller;

import com.twu.biblioteca.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by songyang on 9/27/14.
 */
public class CheckoutBookCommand implements Command {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final BookService bookService;

    public CheckoutBookCommand(PrintStream printStream, BufferedReader bufferedReader, BookService bookService) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookService = bookService;
    }

    @Override
    public void execute() throws IOException {
        printStream.println("Which book would you like to checkout?");
    }

    @Override
    public String description() {
        return "Check out book";
    }
}
