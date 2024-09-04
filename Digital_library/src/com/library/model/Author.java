package com.library.model;

import java.util.Date;

public class Author {
    private int authorId;
    private String name;
    private String bio;
    private String nationality;
    private Date birthDate;

    // Constructor
    public Author (int authorId, String name, String bio, String nationality, Date birthDate) {
        this.authorId = authorId;
        this.name = name;
        this.bio = bio;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }

    // Getters and Setters
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    //Override
    public String toString() {
        return "Author [authorId=" + authorId + ", name=" + name + ", bio=" + bio + ", nationality=" + nationality
                + ", birthDate=" + birthDate + "]";
    }
}
