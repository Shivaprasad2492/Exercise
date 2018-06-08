package org.upgrad.services;

import org.upgrad.models.User;

public interface UserService {
    String findUserByEmail(String email);

    String findUserByUsername(String user_Name);

    public String findUserPassword(String user_name);

    public String findUserRole(String user_name);

    public Iterable<User> getAllUsers();

    void saveUser(String user_Name,String first_Name, String last_Name, String email, String password);
}
