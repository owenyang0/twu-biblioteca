package com.twu.biblioteca.Controller;

import com.twu.biblioteca.BookService;
import com.twu.biblioteca.Modal.Book;

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

        String input = bufferedReader.readLine();

        int index = input == null ? 0 : Integer.parseInt(input);
        Book book = bookService.checkout(index);


        if (book != null) {
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }

    }

    @Override
    public String description() {
        return "Check out book";
    }
}
