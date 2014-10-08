package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        bookDao = new BookDao();

    }

    @Test
    public void should_get_all_the_books() {
        //when
        List<Book> allBooks = bookDao.getAllBooks();

        //then
        assertThat(allBooks.size(), is(3));
        assertThat(allBooks.get(0).getName(), is("ASync JavaScript"));
        assertThat(allBooks.get(0).getAuthor(), is("Trevor"));
        assertThat(allBooks.get(0).getYear(), is("2013"));
    }

    @Test
    public void should_return_a_book_when_given_valid_index() {
        //when
        int bookIndex = 1;
        Book book = bookDao.getBook(bookIndex);

        //then
        assertThat(book.getName(), is("ASync JavaScript"));
        assertThat(book.getAuthor(), is("Trevor"));
        assertThat(book.getYear(), is("2013"));
    }

    @Test
    public void should_return_null_when_given_invalid_index() throws Exception {
        int invalidIndex = 4;

        assertNull(bookDao.getBook(invalidIndex));
    }


    @Test
    public void should_reduce_counts_of_books_when_checkout() throws Exception {
        int originalCounts = bookDao.getAllBooks().size();
        bookDao.getBook(1);

        assertThat(bookDao.getAllBooks().size(), is(originalCounts - 1));
    }

    @Test
    public void should_get_checked_book_when_check_out_a_book() throws Exception {
        Book book = bookDao.getBook(1);

        assertThat(book, is(bookDao.getCheckedBooks().get(0)));
    }

    @Test
    public void should_return_book_when_given_checked_out_book() throws Exception {
        int originalCounts = bookDao.getAllBooks().size();
        Book book = bookDao.getBook(1);

        assertTrue(bookDao.returnBook(book));
        assertThat(bookDao.getAllBooks().size(), is(originalCounts));
    }

    @Test
    public void should_not_allowed_to_return_book_when_given_unchecked_out_book() throws Exception {
        Book book = new Book("Invalid book", "unknown", "2014");
        assertFalse(bookDao.returnBook(book));
    }

    @Test
    public void should_return_book_when_given_correct_checked_index() throws Exception {
        Book book = new Book("ASync JavaScript", "Trevor", "2013");

        bookDao.getBook(1);
        Book checkedBook = bookDao.getCheckedBook(1);
        assertThat(checkedBook.getName(), is("ASync JavaScript"));
        assertThat(checkedBook.getAuthor(), is("Trevor"));
        assertThat(checkedBook.getYear(), is("2013"));
    }

    @Test
    public void should_return_null_when_given_invalid_checked_book_index() throws Exception {
        int invalidIndex = 4;

        assertNull(bookDao.getCheckedBook(invalidIndex));
    }
}