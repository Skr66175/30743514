package com.library.main;

import com.library.dao.Authordao;
import com.library.dao.Ebookdao;
import com.library.dao.Userdao;
import com.library.model.Author;
import com.library.model.Ebook;
import com.library.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Library {
    private static Scanner scanner = new Scanner(System.in);
    private static Authordao authorDAO = new Authordao();
    private static Ebookdao eBookDAO = new Ebookdao();
    private static Userdao userDAO = new Userdao();

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int choice = getIntegerInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    eBookManagementMenu();
                    break;
                case 2:
                    authorManagementMenu();
                    break;
                case 3:
                    membershipManagementMenu();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\nDigital Library Management System");
        System.out.println("---------------------------------");
        System.out.println("1. E-Book Management");
        System.out.println("2. Author Management");
        System.out.println("3. Membership Management");
        System.out.println("4. Exit");
    }

    // E-Book Management
    private static void eBookManagementMenu() {
        while (true) {
            System.out.println("\nE-Book Management");
            System.out.println("-----------------");
            System.out.println("1. Add a new e-book");
            System.out.println("2. View e-book details");
            System.out.println("3. Update e-book information");
            System.out.println("4. Delete an e-book");
            System.out.println("5. Back to Main Menu");
            int choice = getIntegerInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addEBook();
                    break;
                case 2:
                    viewEBook();
                    break;
                case 3:
                    updateEBook();
                    break;
                case 4:
                    deleteEBook();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEBook() {
        System.out.println("\nAdd New E-Book");
        int ebookID = getIntegerInput("Enter Ebook ID: ");
        String title = getStringInput("Enter title: ");
        String genre = getStringInput("Enter genre: ");
        Date publicationDate = getDateInput("Enter publication date (yyyy-MM-dd): ");
        int authorId = getIntegerInput("Enter author ID: ");
        int availableCopies = getIntegerInput("Enter available copies: ");

        Ebook eBook = new Ebook(ebookID, title, genre, publicationDate, authorId, availableCopies);
//        eBook.setTitle(title);
//        eBook.setGenre(genre);
//        eBook.setPublicationDate(publicationDate);
//        eBook.setAuthorId(authorId);
//        eBook.setAvailableCopies(availableCopies);

        eBookDAO.addEBook(eBook);
    }

    private static void viewEBook() {
        System.out.println("\nView E-Book Details");
        int ebookId = getIntegerInput("Enter e-book ID: ");
        Ebook eBook = eBookDAO.getEBookById(ebookId);
        if (eBook != null) {
            System.out.println(eBook);
        } else {
            System.out.println("E-Book not found.");
        }
    }

    private static void updateEBook() {
        System.out.println("\nUpdate E-Book Information");
        int ebookId = getIntegerInput("Enter e-book ID to update: ");
        Ebook eBook = eBookDAO.getEBookById(ebookId);
        if (eBook != null) {
            String title = getStringInput("Enter new title (" + eBook.getTitle() + "): ");
            String genre = getStringInput("Enter new genre (" + eBook.getGenre() + "): ");
            Date publicationDate = getDateInput("Enter new publication date (yyyy-MM-dd) (" + eBook.getPublicationDate() + "): ");
            int authorId = getIntegerInput("Enter new author ID (" + eBook.getAuthorId() + "): ");
            int availableCopies = getIntegerInput("Enter new available copies (" + eBook.getAvailableCopies() + "): ");

            eBook.setTitle(title);
            eBook.setGenre(genre);
            eBook.setPublicationDate(publicationDate);
            eBook.setAuthorId(authorId);
            eBook.setAvailableCopies(availableCopies);

            eBookDAO.updateEBook(eBook);
        } else {
            System.out.println("E-Book not found.");
        }
    }

    private static void deleteEBook() {
        System.out.println("\nDelete E-Book");
        int ebookId = getIntegerInput("Enter e-book ID to delete: ");
        eBookDAO.deleteEBook(ebookId);
    }

    // Author Management
    private static void authorManagementMenu() {
        while (true) {
            System.out.println("\nAuthor Management");
            System.out.println("------------------");
            System.out.println("1. Add a new author");
            System.out.println("2. View author details");
            System.out.println("3. Update author information");
            System.out.println("4. Delete an author");
            System.out.println("5. Back to Main Menu");
            int choice = getIntegerInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addAuthor();
                    break;
                case 2:
                    viewAuthor();
                    break;
                case 3:
                    updateAuthor();
                    break;
                case 4:
                    deleteAuthor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAuthor() {
        System.out.println("\nAdd New Author");
        int authorID= getIntegerInput("Enter Author ID: ");
        String name = getStringInput("Enter name: ");
        String bio = getStringInput("Enter bio: ");
        String nationality = getStringInput("Enter nationality: ");
        Date birthDate = getDateInput("Enter birth date (yyyy-MM-dd): ");

        Author author = new Author(authorID, name, bio, nationality, birthDate);
//        author.setName(name);
//        author.setBio(bio);
//        author.setNationality(nationality);
//        author.setBirthDate(birthDate);

        authorDAO.addAuthor(author);
    }

    private static void viewAuthor() {
        System.out.println("\nView Author Details");
        int authorId = getIntegerInput("Enter author ID: ");
        Author author = authorDAO.getAuthorById(authorId);
        if (author != null) {
            System.out.println(author);
        } else {
            System.out.println("Author not found.");
        }
    }

    private static void updateAuthor() {
        System.out.println("\nUpdate Author Information");
        int authorId = getIntegerInput("Enter author ID to update: ");
        Author author = authorDAO.getAuthorById(authorId);
        if (author != null) {
            String name = getStringInput("Enter new name (" + author.getName() + "): ");
            String bio = getStringInput("Enter new bio (" + author.getBio() + "): ");
            String nationality = getStringInput("Enter new nationality (" + author.getNationality() + "): ");
            Date birthDate = getDateInput("Enter new birth date (yyyy-MM-dd) (" + author.getBirthDate() + "): ");

            author.setName(name);
            author.setBio(bio);
            author.setNationality(nationality);
            author.setBirthDate(birthDate);

            authorDAO.updateAuthor(author);
        } else {
            System.out.println("Author not found.");
        }
    }

    private static void deleteAuthor() {
        System.out.println("\nDelete Author");
        int authorId = getIntegerInput("Enter author ID to delete: ");
        authorDAO.deleteAuthor(authorId);
    }

    // Membership Management
    private static void membershipManagementMenu() {
        while (true) {
            System.out.println("\nMembership Management");
            System.out.println("----------------------");
            System.out.println("1. Register a new user");
            System.out.println("2. View user membership details");
            System.out.println("3. Update membership information");
            System.out.println("4. Cancel a membership");
            System.out.println("5. Back to Main Menu");
            int choice = getIntegerInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    viewUser();
                    break;
                case 3:
                    updateUser();
                    break; 
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser() {
        System.out.println("\nRegister New User");
        int userID= getIntegerInput("Enter user id: ");
        String username = getStringInput("Enter username: ");
        String email = getStringInput("Enter email: ");
        Date dob = getDateInput("Enter date of birth (yyyy-MM-dd): ");
        Date membershipDate = new Date(); // Current date
        String membershipStatus = "active";

        User user = new User (userID,username,email,dob,membershipDate,membershipStatus);
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setDateOfBirth(dob);
//        user.setMembershipDate(membershipDate);
//        user.setMembershipStatus(membershipStatus);

        userDAO.addUser(user);
    }

    private static void viewUser() {
        System.out.println("\nView User Membership Details");
        int userId = getIntegerInput("Enter user ID: ");
        User user = userDAO.getUserById(userId);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void updateUser() {
        System.out.println("\nUpdate Membership Information");
        int userId = getIntegerInput("Enter user ID to update: ");
        User user = userDAO.getUserById(userId);
        if (user != null) {
            String username = getStringInput("Enter new username (" + user.getUsername() + "): ");
            String email = getStringInput("Enter new email (" + user.getEmail() + "): ");
            Date dob = getDateInput("Enter new date of birth (yyyy-MM-dd) (" + user.getDateOfBirth() + "): ");
            String membershipStatus = getStringInput("Enter new membership status (active/inactive) (" + user.getMembershipStatus() + "): ");

            user.setUsername(username);
            user.setEmail(email);
            user.setDateOfBirth(dob);
            user.setMembershipStatus(membershipStatus);

            userDAO.updateUser(user);
        } else {
            System.out.println("User not found.");
        }
    }

//    private static void cancelMembership() {
//        System.out.println("\nCancel Membership");
//        int userId = getIntegerInput("Enter user ID to cancel membership: ");
//        userDAO.cancelMembership(userId);
//    }

    // Helper Methods for Input
    private static int getIntegerInput(String prompt) {
        int input = -1;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static Date getDateInput(String prompt) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        while (true) {
            try {
                System.out.print(prompt);
                String dateStr = scanner.nextLine();
                if (dateStr.isEmpty()) {
                    return null;
                }
                date = formatter.parse(dateStr);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }
        return date;
    }
}

