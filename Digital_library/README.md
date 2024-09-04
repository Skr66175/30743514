
# Digital Library Management System

This project is a menu-based console application that simulates a digital library management system for a communications and media company. The application is built using Core Java, MySQL, and JDBC to manage e-books, authors, and user memberships efficiently. The project demonstrates the use of Data Access Objects (DAO) for database operations and follows standard coding conventions with proper exception handling and resource management.


## Features

E-Book Management

Add a New E-Book: Allows the addition of a new e-book to the library's database.

View E-Book Details: Retrieves and displays details of an e-book based on its ID.

Update E-Book Information: Updates the information of an existing e-book.

Delete an E-Book: Removes an e-book from the library's database.

Author Management

Add a New Author: Allows the addition of a new author to the library's database.

View Author Details: Retrieves and displays details of an author based on their ID.

Update Author Information: Updates the information of an existing author.

Delete an Author: Removes an author from the library's database.


Membership Management

Register a New User: Registers a new user and adds them to the library's database.

View User Membership Details: Retrieves and displays details of a user based on their ID.

Update Membership Information: Updates the membership details of an existing user.

Cancel a Membership: Cancels a user's membership in the library's database.



The project follows a modular structure, with each functionality encapsulated in its respective package:

com.library.main: Contains the main application class (Library) that drives the application.

com.library.model: Contains Java classes (EBook, Author, User) representing the database entities.

com.library.dao: Contains Data Access Object (DAO) classes (EBookDAO, AuthorDAO, UserDAO) for database operations.

com.library.util: Contains utility classes such as DatabaseConnection for managing the database connection.

com.library.exception: (Optional) Contains custom exception classes for handling application-specific errors.



## Deployment

Prerequisites

Java Development Kit (JDK): Ensure that JDK 8 or higher is installed.

MySQL Database: Install MySQL Server and MySQL Workbench.

JDBC Driver: Ensure the MySQL JDBC driver (mysql-connector-java) is included in your project's classpath.

Eclipse IDE: Recommended for Java development.
Database Setup

Create Database: Create a MySQL database named jdbcdb.

Create Tables: 

Use the following SQL scripts to create the required tables:

CREATE TABLE author (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    bio TEXT,
    nationality VARCHAR(50),
    birth_date DATE
);

CREATE TABLE ebook (
    ebook_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    genre VARCHAR(50),
    publication_date DATE,
    author_id INT,
    available_copies INT,
    FOREIGN KEY (author_id) REFERENCES author(author_id)
);

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    email VARCHAR(100),
    date_of_birth DATE,
    membership_date DATE,
    membership_status VARCHAR(10)
);

Project Setup

Clone the Repository: Clone this repository to your local machine.

Import into Eclipse: Open Eclipse IDE and import the project as a Maven project.

Configure MySQL Connection: Modify the DatabaseConnection class in com.library.util package to match your MySQL database credentials.

Run the Application: Run the Library class in the com.library.main package to start the application.

Running the Application

The application presents a menu with options to manage e-books, authors, and users.

Navigate through the menu by entering the corresponding option number.

Perform operations such as adding, viewing, updating, or deleting records in the library database.





## License

This project is for educational purposes and is provided as-is without any warranties. Feel free to modify and use the code as needed.
## Acknowledgements

This project was developed as part of a case study to assess proficiency in Core Java, MySQL, and JDBC.


