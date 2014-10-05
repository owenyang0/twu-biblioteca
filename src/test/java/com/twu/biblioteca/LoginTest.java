package com.twu.biblioteca;

import org.junit.Before;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LoginTest {
    private PrintStream printStream;
    private Login login;
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        userDao = new UserDao();
        login = new Login(printStream, userDao);
    }
}