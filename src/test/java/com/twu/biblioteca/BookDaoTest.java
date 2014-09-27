package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookDaoTest {
    @Test
    public void should_get_all_the_books() {
        //given
        BookDao bookDao = new BookDao();

        //when
        List<Book> allBooks = bookDao.getAllBooks();

        //then
        assertThat(allBooks.size(), is(3));
        assertThat(allBooks.get(0).getName(), is("ASync JavaScript"));
        assertThat(allBooks.get(0).getAuthor(), is("Trevor"));
        assertThat(allBooks.get(0).getYear(), is("2013"));
    }

    @Test
    public void should_return_a_book_when_given_index() {
        //given
        BookDao bookDao = new BookDao();

        //when
        int bookIndex = 1;
        Book book = bookDao.getBook(bookIndex);

        //then
        assertThat(book.getName(), is("ASync JavaScript"));
        assertThat(book.getAuthor(), is("Trevor"));
        assertThat(book.getYear(), is("2013"));
    }
}