package com.library.dao;

import com.library.model.Author;
import com.library.util.Databaseconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Authordao {

    // Method to add a new author
    public void addAuthor(Author author) {
        String sql = "INSERT INTO author (name, bio, nationality, birth_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, author.getName());
            pstmt.setString(2, author.getBio());
            pstmt.setString(3, author.getNationality());
            pstmt.setDate(4, new java.sql.Date(author.getBirthDate().getTime()));
            pstmt.executeUpdate();
            System.out.println("Author has been added!");

        } catch (SQLException e) {
            System.err.println("Error adding author: " + e.getMessage());
        }
    }

    // Method to update an existing author
    public void updateAuthor(Author author) {
        String sql = "UPDATE author SET name = ?, bio = ?, nationality = ?, birth_date = ? WHERE author_id = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, author.getName());
            pstmt.setString(2, author.getBio());
            pstmt.setString(3, author.getNationality());
            pstmt.setDate(4, new java.sql.Date(author.getBirthDate().getTime()));
            pstmt.setInt(5, author.getAuthorId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Author is updated.");
            } else {
                System.out.println("No author found with the given ID.");
            }


        } catch (SQLException e) {
            System.err.println("Error updating author: " + e.getMessage());
        }
    }

    // Method to retrieve an author by ID
    public Author getAuthorById(int authorId) {
        String sql = "SELECT * FROM author WHERE author_id = ?";
        Author author = null;
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, authorId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                author = new Author(
                    rs.getInt("author_id"),
                    rs.getString("name"),
                    rs.getString("bio"),
                    rs.getString("nationality"),
                    rs.getDate("birth_date")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving author: " + e.getMessage());
        }
        return author;
    }

    // Method to delete an author by ID
    public void deleteAuthor(int authorId) 
    {
        String sql = "DELETE FROM author WHERE author_id = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, authorId);
            pstmt.executeUpdate(); int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Author has been deleted.");
            } else {
                System.out.println("No author found with the given ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting author: " + e.getMessage());
        }
    }
}