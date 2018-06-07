package org.upgrad.repositories;

import org.upgrad.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(nativeQuery = true,value="SELECT * FROM USERS WHERE UPPER(EMAIL) = UPPER (?1)")
    String findByEmail(String email);

    @Query(nativeQuery = true,value="SELECT * FROM USERS WHERE UPPER(USER_NAME) = UPPER (?1)")
    String findByUserName(String user_Name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="INSERT INTO USERS (USER_NAME,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD) VALUES (?1,?2,?3,?4,?5)")
    void save(String user_Name,String first_Name, String last_Name,  String email, String password);
}

