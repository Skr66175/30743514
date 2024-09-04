package com.library.model;

import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String email;
    private Date dateOfBirth;
    private Date membershipDate;
    private String membershipStatus;

    // Constructor
    public User(int userId, String username, String email, Date dateOfBirth, Date membershipDate, String membershipStatus) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.membershipDate = membershipDate;
        this.membershipStatus = membershipStatus;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    //Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", dateOfBirth=" + dateOfBirth
                + ", membershipDate=" + membershipDate + ", membershipStatus=" + membershipStatus + "]";
    }
}
