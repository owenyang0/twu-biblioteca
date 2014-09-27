package com.twu.biblioteca.Controller;

import com.twu.biblioteca.BookService;

import java.io.IOException;

/**
 * Created by songyang on 9/27/14.
 */
public class ListBooksCommand implements Command {
    private final BookService bookService;

    public ListBooksCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void execute() throws IOException {
        bookService.list();
    }

    @Override
    public String description() {
        return "List books";
    }
}
