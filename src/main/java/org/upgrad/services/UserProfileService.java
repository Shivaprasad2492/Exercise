package org.upgrad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.upgrad.models.UserProfile;



import java.util.Date;

public interface UserProfileService {
    void saveUser(String user_Name, String about_Me, Date dob, String contact_Number, String country);
}
