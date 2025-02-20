CREATE DATABASE mydatabase;
USE mydatabase;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    email VARCHAR(100)
);

INSERT INTO users (name, age, email) VALUES
('Alice', 25, 'alice@example.com'),
('Bob', 30, 'bob@example.com');
