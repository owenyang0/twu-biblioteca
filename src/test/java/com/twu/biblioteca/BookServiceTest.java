package com.twu.biblioteca;

import com.twu.biblioteca.Controller.CheckoutBookCommand;
import com.twu.biblioteca.Modal.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    private PrintStream printStream;
    private BookService bookService;
    private BookDao bookDao;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bookDao = mock(BookDao.class);
        bookService = new BookService(bookDao);
    }

    @Test
    public void should_list_all_the_checked_books() throws Exception {
        List<Book> checkedBooks = new ArrayList<>();
        String fmt = "%1$-40s %2$-10s %3$10s%n";
        checkedBooks.add(new Book("Pragmatic Programmer", "Andrew", "2011"));

        when(bookDao.getCheckedBooks()).thenReturn(checkedBooks);
        bookService.listChecked(printStream);

        verify(printStream).format(fmt, "Pragmatic Programmer", "Andrew", "2011");
    }
}