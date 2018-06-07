package org.upgrad.services;

import org.upgrad.models.User;

public interface UserService {
    String findUserByEmail(String email);

    String findUserByUsername(String user_Name);

    void saveUser(String user_Name,String first_Name, String last_Name, String email, String password);
}
