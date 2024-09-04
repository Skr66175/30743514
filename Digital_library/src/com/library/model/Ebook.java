package com.library.model;

import java.util.Date;

public class Ebook {
    private int ebookId;
    private String title;
    private String genre;
    private Date publicationDate;
    private int authorId;
    private int availableCopies;

    // Constructor
    public Ebook (int ebookId, String title, String genre, Date publicationDate, int authorId, int availableCopies) {
        this.ebookId = ebookId;
        this.title = title;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    // Getters and Setters
    public int getEbookId() {
        return ebookId;
    }

    public void setEbookId(int ebookId) {
        this.ebookId = ebookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    //Override
    public String toString() {
        return "EBook [ebookId=" + ebookId + ", title=" + title + ", genre=" + genre + ", publicationDate=" + publicationDate
                + ", authorId=" + authorId + ", availableCopies=" + availableCopies + "]";
    }
}
