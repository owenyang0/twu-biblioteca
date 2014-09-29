package com.twu.biblioteca.Controller;

import com.twu.biblioteca.BookService;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBooksCommandTest {

    private BufferedReader reader;
    private PrintStream printStream;
    private BookService bookService;
    private ReturnBooksCommand command;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        bookService = mock(BookService.class);
        command = new ReturnBooksCommand(printStream, reader, bookService);
    }

    @Test
    public void should_show_an_options_to_let_user_return_book() throws Exception {
        command.execute();

        verify(printStream).println("Which book would you like to return?");
    }
}