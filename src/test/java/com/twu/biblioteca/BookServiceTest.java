package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

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

//    @Test
//    public void should_return_book_by_index_correctly() throws Exception {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("ASync JavaScript", "Trevor", "2013"));
//
//        when(bookDao.getCheckedBooks()).thenReturn(books);
//        Book b = bookService.returnBookByIndex(1);
//        assertNotNull(bookService.returnBookByIndex(1));
//    }

    @Test
    public void should_return_false_when_given_wrongly_index() throws Exception {
        assertNull(bookService.returnBookByIndex(1));
    }
}