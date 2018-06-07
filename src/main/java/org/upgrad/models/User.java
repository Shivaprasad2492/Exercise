package org.upgrad.models;

import javax.persistence.*;

@Entity
public class User extends UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String first_Name;

    private String last_Name;

    @Column(nullable = false, unique = true, length = 125)
    private String user_Name;

    @Column(nullable = false, unique = true, length = 125)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(){
    }
    public User(String first_Name, String last_Name, String user_Name, String email, String password) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.user_Name = user_Name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String firstName) {
        this.first_Name = first_Name;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setLastName(String lastName) {
        this.last_Name = last_Name;
    }

    public String getUserName() {
        return user_Name;
    }

    public void setUserName(String userName) {
        this.user_Name = user_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
