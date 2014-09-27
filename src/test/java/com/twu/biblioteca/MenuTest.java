package com.twu.biblioteca;

import com.twu.biblioteca.Controller.Command;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MenuTest {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Menu menu;
    private Command command;
    private Map<String, Command> commandMap;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        command = mock(Command.class);
        commandMap = new HashMap<String, Command>();
        menu = new Menu(printStream, bufferedReader, commandMap);
    }

    @Test
    public void should_print_options_what_you_put_in() {
        String index = "1";
        String description = "A description of one command";
        commandMap.put(index, command);

        when(command.description()).thenReturn(description);
        menu.printOptions();
        verify(printStream).println("1. A description of one command");
    }

//    @Test
//    public void shouldCallCommandWhenOptionIsSelected() throws IOException {
//        String input = "1";
//        commandMap.put(input, command);
//        when(bufferedReader.readLine()).thenReturn(input);
//        menu.selectOption();
//        verify(command).execute();
//    }
//
//    @Test
//    public void shouldRePromptWhenGivenInvalidOption() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("Bad Input");
//        menu.selectOption();
//        verify(printStream).println("Select a valid option!");
//    }
//
//    @Test
//    public void shouldBeDoneAfterReceivingQuit() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("Quit");
//        menu.selectOption();
//        assertFalse(menu.shouldContinue());
//    }
//
//    @Test
//    public void ShouldNotBeDoneIfQuitNotReceived() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1");
//        menu.selectOption();
//        assertTrue(menu.shouldContinue());
//    }
}