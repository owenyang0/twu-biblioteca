package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LoginServiceTest {
    private PrintStream printStream;
    private Login login;
    private LoginService loginService;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        login = mock(Login.class);
        loginService = new LoginService(printStream, login);
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
}