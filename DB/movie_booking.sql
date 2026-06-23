create database movie_booking;
use movie_booking;
create table users(
    user_id int primary key auto_increment,
    user_name varchar(50) not null,
    phone_number int(15) unique not null,
    email varchar(100) unique,
    password varchar(100) unique not null 
);
desc users;
create table movies(
    movie_id int primary key auto_increment,
    movie_name varchar(200) not null UNIQUE,
    duration varchar(10) not null
);
desc movies;
DROP TABLE IF EXISTS shows;
CREATE TABLE shows(
    show_id int primary key auto_increment,
    movie_id INT not null,
    timing varchar(10) not null,
    show_date date not null,
    foreign key(movie_id) references movies(movie_id)
);
desc shows;
create table seats(
seat_id int primary key auto_increment,
show_id int not null,
seat_number varchar(10) not null unique,
state enum('Available' , 'Booked') not null,
FOREIGN KEY(show_id) REFERENCES shows(show_id));
desc seats;
create table booking(
booking_id int primary key auto_increment,
user_id int not null,
show_id int not null,
seat_number varchar(10) not null unique,
payment double,
booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(user_id)REFERENCES users(user_id),
FOREIGN KEY(show_id)REFERENCES shows(show_id),
foreign key(seat_number)references seats(seat_number)
);
desc booking;

