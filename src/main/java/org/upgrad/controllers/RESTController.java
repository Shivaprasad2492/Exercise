package org.upgrad.controllers;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.services.UserProfileService;
import org.upgrad.services.UserService;
import org.upgrad.services.*;
import java.util.Date;

@RestController
public class RESTController {

    @Autowired
    private  UserService userService;

    @Autowired
    private  UserProfileService userProfileService;


    @PostMapping("/api/signup")
    public String PostRegistered(@RequestParam String first_Name, @RequestParam String last_Name, @RequestParam String user_Name, @RequestParam String email, @RequestParam String password, @RequestParam String country, @RequestParam String about_Me, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob, @RequestParam String contact_Number) {
        String result = String.valueOf(userService.findUserByUsername(user_Name));
        if (!(result.equalsIgnoreCase("null"))) {
            return "Try any other Username, this Username has already been taken.";
        }
        else if (!(String.valueOf(userService.findUserByEmail(email)).equalsIgnoreCase("null"))) {
            return "This user has already been registered, try with any other emailId.";
        }
        else {
            String sha256hex = Hashing.sha256()
                    .hashString(password, Charsets.US_ASCII)
                    .toString();
            userService.saveUser(user_Name,first_Name,last_Name,email,sha256hex);
            userProfileService.saveUser(user_Name,about_Me,dob,contact_Number,country);
            return user_Name + " successfully registered";
            }
    }

}
