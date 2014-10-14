package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Dao.BookDao;
import com.twu.biblioteca.Services.BookService;
import org.junit.Test;

public class ListBooksCommandTest {

    @Test
    public void should_list_all_the_books() throws Exception {
        new ListBooksCommand(System.out, new BookService(new BookDao())).execute();
    }
}