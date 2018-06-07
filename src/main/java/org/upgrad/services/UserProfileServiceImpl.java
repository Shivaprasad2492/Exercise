package org.upgrad.services;


import org.springframework.stereotype.Service;
import org.upgrad.models.UserProfile;
import org.upgrad.repositories.UserProfileRepository;

import java.util.Date;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void saveUser(String user_Name, String about_Me, Date dob, String contact_Number, String country) {
        userProfileRepository.save(user_Name,about_Me,dob,contact_Number,country);
    }
}
