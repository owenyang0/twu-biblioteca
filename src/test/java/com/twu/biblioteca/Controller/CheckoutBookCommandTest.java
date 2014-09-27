package com.twu.biblioteca.Controller;

import com.twu.biblioteca.BookService;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


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

//    @Test
//    public void shouldCheckOutSelectedBook() throws IOException {
//        when(reader.readLine()).thenReturn("A book");
//        command.execute();
//        verify(bookService).checkout("A book");
//    }
//
//    @Test
//    public void shouldInformOfSuccessfulCheckout() throws IOException {
//
//        when(reader.readLine()).thenReturn("A book");
//        when(bookService.checkout("A book")).thenReturn(true);
//        command.execute();
//        verify(printStream).println("Thank you! Enjoy the book");
//    }
//
//    @Test
//    public void shouldInformOfUnsuccessfulCheckout() throws IOException {
//        when(reader.readLine()).thenReturn("A book");
//        when(bookService.checkout("A book")).thenReturn(false);
//        command.execute();
//        verify(printStream).println("That book is not available.");
//    }
}