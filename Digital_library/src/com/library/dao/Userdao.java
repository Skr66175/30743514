package com.library.dao;

import com.library.model.User;
import com.library.util.Databaseconnection;

import java.sql.*;


public class Userdao {

    // Method to add a new user to the database
    public boolean addUser(User user) {
        String sql = "INSERT INTO user (username, email, date_of_birth, membership_date, membership_status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setDate(3, new java.sql.Date(user.getDateOfBirth().getTime()));
            pstmt.setDate(4, new java.sql.Date(user.getMembershipDate().getTime()));
            pstmt.setString(5, user.getMembershipStatus());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
            return false;
        }
    }

    // Method to retrieve a user by ID
    public User getUserById(int userId) {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        User user = null;
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getDate("date_of_birth"),
                    rs.getDate("membership_date"),
                    rs.getString("membership_status")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving user: " + e.getMessage());
        }
        return user;
    }

    // Method to update user details
    public boolean updateUser(User user) {
        String sql = "UPDATE user SET username = ?, email = ?, date_of_birth = ?, membership_date = ?, membership_status = ? WHERE user_id = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setDate(3, new java.sql.Date(user.getDateOfBirth().getTime()));
            pstmt.setDate(4, new java.sql.Date(user.getMembershipDate().getTime()));
            pstmt.setString(5, user.getMembershipStatus());
            pstmt.setInt(6, user.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
            return false;
        }
    }

    // Method to delete a user from the database
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }

    
   }
