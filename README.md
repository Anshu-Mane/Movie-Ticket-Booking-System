# Movie-Ticket-Booking-System
A Java-based console application for movie ticket booking using JDBC and MySQL.


A Java-based console application that simulates a movie ticket booking system. 
The application uses JDBC to connect Java with MySQL and manages users, movies, shows, seats, and bookings.

## Features

- User Registration
- User Login Authentication
- View Available Movies
- View Movie Show Timings
- Seat Availability Checking
- Multiple Seat Booking
- Dynamic Ticket Price Calculation
- Booking Management
- Database-driven operations using MySQL

## Tech Stack

- Java
- JDBC (Java Database Connectivity)
- MySQL
- SQL
- VS Code

## Database Design

The system uses the following tables:

- Users
- Movies
- Shows
- Seats
- Bookings

## Project Flow


User Registration/Login
|
↓
View Movies
|
↓
Select Movie
|
↓
Select Show
|
↓
Choose Seats
|
↓
Payment
|
↓
Ticket Booking Confirmation


## How to Run

### 1. Clone the repository


git clone <repository-link>


### 2. Setup MySQL Database

- Open MySQL Workbench
- Create database:

```sql
CREATE DATABASE movie_booking;
Import the SQL file provided in the database folder.
3. Configure Database Connection

Update database credentials in:

DBconnection.java

Example:

DriverManager.getConnection(
"jdbc:mysql://localhost:3306/movie_booking",
"root",
"your_password"
);
4. Add MySQL Connector

Add MySQL JDBC connector jar file to the project libraries.

5. Run the Project

Run:

Main.java
Future Improvements
GUI using Java Swing/JavaFX
Online payment integration
Admin dashboard
Ticket PDF generation
Author

Anshu Mane
