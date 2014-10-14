package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Modal.Book;
import com.twu.biblioteca.Services.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by songyang on 9/29/14.
 */
public class ReturnBooksCommand implements Command {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final BookService bookService;

    public ReturnBooksCommand(PrintStream printStream, BufferedReader bufferedReader, BookService bookService) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookService = bookService;
    }

    @Override
    public void execute() throws IOException {
        printStream.println("Which book would you like to return?");
        printStream.println();

        bookService.listChecked(printStream);

        String input = bufferedReader.readLine();
        int index = input == null ? 0 : Integer.parseInt(input);
        Book book = bookService.returnBookByIndex(index);

        if (book != null) {
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    @Override
    public String description() {
        return "Return Book";
    }
}
