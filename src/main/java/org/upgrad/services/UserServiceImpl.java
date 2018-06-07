package org.upgrad.services;

import org.upgrad.models.User;
import org.springframework.stereotype.Service;
import org.upgrad.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String findUserByUsername(String user_Name) {
        return userRepository.findByUserName(user_Name);
    }

    @Override
    public void saveUser(String user_Name,String first_Name,String last_Name,String email,String password) {
        userRepository.save(user_Name,first_Name,last_Name,email,password);
    }
}
