package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by songyang on 9/19/14.
 */
public class BookService {
    private String fmt = "%1$-40s %2$-10s %3$10s%n";
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    private void printHeader(PrintStream printStream) {
        printStream.format(fmt, "Book Name", "Author", "Published Year");
        printStream.format(fmt, "---------", "------", "--------------");
    }

    public void list(PrintStream printStream) {
        List<Book> books = bookDao.getAllBooks();
        printHeader(printStream);

        for (Book book : books) {
            printStream.format(fmt, book.getName(), book.getAuthor(), book.getYear());
        }
    }

    public Book checkout(int index) {
        return bookDao.getBook(index);
    }

    public boolean returnBook(Book book) {
        return bookDao.returnBook(book);
    }

    public void listChecked(PrintStream printStream) {
        printHeader(printStream);

        List<Book> checkedBooks = bookDao.getCheckedBooks();

        for (Book book : checkedBooks) {
            printStream.format(fmt, book.getName(), book.getAuthor(), book.getYear());
        }
    }

    public Book returnBookByIndex(int index) {
        return bookDao.getCheckedBook(index);
    }
}
