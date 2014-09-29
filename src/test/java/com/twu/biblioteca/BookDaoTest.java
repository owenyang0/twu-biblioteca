package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

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
        int originalCounts = bookDao.books.size();
        bookDao.getBook(1);

        assertThat(bookDao.books.size(), is(originalCounts - 1));
    }

    @Test
    public void should_get_checked_book_when_check_out_a_book() throws Exception {
        Book book = bookDao.getBook(1);

        assertThat(book, is(bookDao.getCheckedBooks().get(0)));
    }
}