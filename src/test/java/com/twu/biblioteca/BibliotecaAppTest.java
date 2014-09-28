package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private PrintStream printStream;
    private BookService bookService;
    private Menu menu;
    private BibliotecaApp biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bookService = mock(BookService.class);
        menu = mock(Menu.class);

        biblioteca = new BibliotecaApp(printStream, menu);
    }

    @Test
    public void should_show_welcome_message() throws Exception {
        biblioteca.start();
        verify(printStream).println("Welcome!");
    }

    @Test
    public void should_show_menu_when_start() throws Exception {
        biblioteca.start();
        verify(menu).printOptions();
    }

    @Test
    public void should_let_users_choose_after_start() throws IOException {
        biblioteca.start();
        verify(menu).select();
    }

    @Test
    public void should_stop_when_menu_receive_false() throws Exception {
        when(menu.go()).thenReturn(false);
        biblioteca.start();

        verify(menu, times(1)).select();
    }

    @Test
    public void should_not_stop_when_menu_can_go() throws Exception {
        when(menu.go()).thenReturn(true).thenReturn(false);
        biblioteca.start();

        verify(menu, times(2)).select();
    }
}