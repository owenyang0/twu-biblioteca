package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Modal.User;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by songyang on 10/5/14.
 */
public class Login {
    private PrintStream printStream;
    private UserDao userDao;
    private boolean authorized = false;
    private List<User> users;

    public Login(PrintStream printStream, UserDao userDao) {
        this.printStream = printStream;
        this.userDao = userDao;
        this.users = userDao.getUsers();
    }

    public boolean isLogin() {
        return authorized;
    }

    public boolean author(String libraryNumber, String password) {
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password)) {
                authorized = true;
                return true;
            }
        }

        return false;
    }
}
