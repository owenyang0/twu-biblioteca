package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LoginServiceTest {
    private PrintStream printStream;
    private BufferedReader reader;
    private Login login;
    private LoginService loginService;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        login = mock(Login.class);
        loginService = new LoginService(printStream, reader, login);
    }

    @Test
    public void should_display_invalid_message_when_dont_login() throws Exception {
        when(login.isLogin()).thenReturn(false);
        assertFalse(loginService.isLogin());

        verify(printStream).println("You don't have access to continue, please login first!");
    }

    @Test
    public void should_return_true_after_login() throws Exception {
        when(login.isLogin()).thenReturn(true);
        assertTrue(loginService.isLogin());
    }

    @Test
    public void should_display_auth_message_when_doing_auth() throws Exception {
        String validLibraryNO = "111-2222";
        String validPassword = "123";

        when(reader.readLine()).thenReturn(validLibraryNO).thenReturn(validPassword);
        when(login.author(validLibraryNO, validPassword)).thenReturn(true);
        loginService.auth();

        verify(printStream).println("Please login first with your library number and password!");
        verify(printStream).println("Library NO: ");
        verify(printStream).println("Password: ");
        verify(printStream).println("Login success!");
    }
}