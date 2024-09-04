package com.library.dao;

import com.library.model.Ebook;
import com.library.util.Databaseconnection;

import java.sql.*;


public class Ebookdao {

    // Method to add a new e-book to the database
    public boolean addEBook(Ebook ebook) {
        String sql = "INSERT INTO e_book (title, genre, publication_date, author_id, available_copies) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ebook.getTitle());
            pstmt.setString(2, ebook.getGenre());
            pstmt.setDate(3, new java.sql.Date(ebook.getPublicationDate().getTime()));
            pstmt.setInt(4, ebook.getAuthorId());
            pstmt.setInt(5, ebook.getAvailableCopies());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error adding e-book: " + e.getMessage());
            return false;
        }
    }

    // Method to retrieve e-book details by ID
    public Ebook getEBookById(int ebookId) {
        String sql = "SELECT * FROM e_book WHERE ebook_id = ?";
        Ebook ebook = null;
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ebookId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ebook = new Ebook (rs.getInt("ebook_id"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getDate("publication_date"),
                    rs.getInt("author_id"),
                    rs.getInt("available_copies")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving e-book: " + e.getMessage());
        }
        return ebook;
    }

    // Method to update e-book details
    public boolean updateEBook(Ebook ebook) {
        String sql = "UPDATE e_book SET title = ?, genre = ?, publication_date = ?, author_id = ?, available_copies = ? WHERE ebook_id = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ebook.getTitle());
            pstmt.setString(2, ebook.getGenre());
            pstmt.setDate(3, new java.sql.Date(ebook.getPublicationDate().getTime()));
            pstmt.setInt(4, ebook.getAuthorId());
            pstmt.setInt(5, ebook.getAvailableCopies());
            pstmt.setInt(6, ebook.getEbookId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating e-book: " + e.getMessage());
            return false;
        }
    }

    // Method to delete an e-book from the database
    public boolean deleteEBook(int ebookId) {
        String sql = "DELETE FROM ebook WHERE ebook_id = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ebookId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting e-book: " + e.getMessage());
            return false;
        }
    }


}
