package com.twu.biblioteca.Dao;

import com.twu.biblioteca.Modal.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyang on 10/5/14.
 */
public class UserDao {
    List<User> users = new ArrayList<>();

    public UserDao() {
        users.add(new User("111-2222", "song", "song@email.com", "11 1234 5678", "123"));
        users.add(new User("333-4444", "song", "song@email.com", "11 1234 5678", "456"));
        users.add(new User("2", "song", "song@email.com", "11 1234 5678", "2"));
    }

    public List<User> getUsers() {
        return users;
    }
}
