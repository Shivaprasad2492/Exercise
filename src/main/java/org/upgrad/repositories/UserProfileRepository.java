package org.upgrad.repositories;

import org.upgrad.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.models.UserProfile;

import java.util.Date;

@Repository
public interface UserProfileRepository extends CrudRepository<User, Integer> {

//    @Query(nativeQuery = true,value="SELECT * FROM USER WHERE UPPER(EMAIL) = UPPER (?1)")
//    User findByEmail(String email);
//
//    @Query(nativeQuery = true,value="SELECT * FROM USER WHERE UPPER(USERNAME) = UPPER (?1)")
//    User findByUserName(String username);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="INSERT INTO USERPROFILE(user_Name,about_Me,dob,contact_Number,country) VALUES (?1,?2,?3,?4,?5)")
    void save(String user_Name, String about_Me, Date dob, String contact_Number, String country);
}
