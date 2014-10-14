package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Services.BookService;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by songyang on 9/27/14.
 */
public class ListBooksCommand implements Command {
    private final BookService bookService;
    private final PrintStream printStream;

    public ListBooksCommand(PrintStream printStream, BookService bookService) {
        this.printStream = printStream;
        this.bookService = bookService;
    }

    @Override
    public void execute() throws IOException {
        bookService.list(printStream);
    }

    @Override
    public String description() {
        return "List books";
    }
}
