package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.UserDao;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void should_return_false_when_first_time_get_status() throws Exception {
        assertFalse(login.isLogin());
    }

    @Test
    public void should_return_true_after_correct_auth() throws Exception {
        String validLibraryNO = "111-2222";
        String validPassword = "123";

        assertTrue(login.author(validLibraryNO, validPassword));
        assertTrue(login.isLogin());
    }

    @Test
    public void should_return_false_when_login_with_invalid_info() throws Exception {
        String invalidLibraryNO = "111-2222-0";
        String invalidPassword = "123";

        assertFalse(login.author(invalidLibraryNO, invalidPassword));
        assertFalse(login.isLogin());
    }
}