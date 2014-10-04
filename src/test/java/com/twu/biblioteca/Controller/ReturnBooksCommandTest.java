package com.twu.biblioteca.Controller;

import com.twu.biblioteca.BookService;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void should_list_all_the_checked_books() throws Exception {
        command.execute();

        verify(bookService).listChecked(printStream);
    }

    @Test
    public void should_return_success_when_given_correct_book_index_to_return() throws Exception {
        when(reader.readLine()).thenReturn("1");
        when(bookService.returnBookByIndex(1)).thenReturn(true);

        command.execute();
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void should_not_return_when_not_given_correct_book_to_return() throws Exception {
        when(reader.readLine()).thenReturn("1");
        command.execute();

        verify(printStream).println("That is not a valid book to return.");
    }
}