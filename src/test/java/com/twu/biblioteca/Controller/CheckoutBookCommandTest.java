package com.twu.biblioteca.Controller;

import com.twu.biblioteca.BookService;
import com.twu.biblioteca.Modal.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CheckoutBookCommandTest {

    private BufferedReader reader;
    private PrintStream printStream;
    private BookService bookService;
    private CheckoutBookCommand command;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        bookService = mock(BookService.class);
        command = new CheckoutBookCommand(printStream, reader, bookService);
    }

    @Test
    public void should_show_an_option_to_let_user_check_out_a_book() throws IOException {
        command.execute();
        verify(printStream).println("Which book would you like to checkout?");
    }

    @Test
    public void should_checkout_select_book() throws IOException {
        when(reader.readLine()).thenReturn("1");
        command.execute();
        verify(bookService).checkout(1);
    }

    @Test
    public void should_return_successful_message_when_succeed() throws Exception {
        when(reader.readLine()).thenReturn("1");
        when(bookService.checkout(1)).thenReturn(new Book("ASync JavaScript", "Trevor", "2013"));

        command.execute();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void should_return_unsuccessful_message_when_failed() throws Exception {
        when(reader.readLine()).thenReturn("0");
        when(bookService.checkout(0)).thenReturn(null);

        command.execute();
        verify(printStream).println("That book is not available.");
    }
}