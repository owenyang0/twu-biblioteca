package com.twu.biblioteca;

import com.twu.biblioteca.Controller.Command;
import com.twu.biblioteca.Services.BookService;
import com.twu.biblioteca.Services.LoginService;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
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

    public static class MenuTest {

        private PrintStream printStream;
        private BufferedReader bufferedReader;
        private Menu menu;
        private Command command;
        private Map<String, Command> commandMap;
        private LoginService loginService;

        @Before
        public void setUp() throws Exception {
            printStream = mock(PrintStream.class);
            bufferedReader = mock(BufferedReader.class);
            command = mock(Command.class);
            commandMap = new HashMap<String, Command>();
            loginService = mock(LoginService.class);
            menu = new Menu(printStream, bufferedReader, commandMap, loginService);
        }

        @Test
        public void should_display_common_message_when_print_options() throws Exception {
            when(menu.isValid()).thenReturn(true);
            menu.printOptions();

            verify(printStream).println("Please select your option:");
            verify(printStream).println("Q. Quit");
        }

        @Test
        public void should_print_options_what_you_put_in() throws IOException {
            String index = "1";
            String description = "A description of one command";
            commandMap.put(index, command);

            when(command.description()).thenReturn(description);
            when(menu.isValid()).thenReturn(true);
            menu.printOptions();
            verify(printStream).println("1. A description of one command");
        }

        @Test
        public void should_execute_command_when_select() throws Exception {
            String index = "1";
            commandMap.put(index, command);

            when(bufferedReader.readLine()).thenReturn(index);
            menu.select();
            verify(command).execute();
        }

        @Test
        public void should_prompt_invalid_message_when_given_invalid_input() throws Exception {
            when(bufferedReader.readLine()).thenReturn("Invalid input");
            menu.select();
            verify(printStream).println("Select a valid option!");
        }

        @Test
        public void should_not_continue_when_received_q() throws Exception {
            when(bufferedReader.readLine()).thenReturn("Q");
            menu.select();
            assertFalse(menu.go());
        }

        @Test
        public void should_continue_when_not_received_q() throws Exception {
            when(bufferedReader.readLine()).thenReturn("1");
            menu.select();
            assertTrue(menu.go());
        }
    }
}