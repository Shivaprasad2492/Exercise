package org.upgrad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String about_Me;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String contact_Number;

    private String country;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private User user;

    public UserProfile(){
    }

    public UserProfile getUpdatedFromSource(UserProfile source) {
        about_Me = source.about_Me;
        dob = source.dob;
        contact_Number = source.contact_Number;
        country = source.country;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAboutMe() {
        return about_Me;
    }

    public void setAboutMe(String aboutMe) {
        this.about_Me = about_Me;
    }

    public Date getDateOfBirth() {
        return dob;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dob = dob;
    }

    public String getContactNumber() {
        return contact_Number;
    }

    public void setContactNumber(String contactNumber) {
        this.contact_Number = contact_Number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
