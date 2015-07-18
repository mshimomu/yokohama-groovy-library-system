CREATE TABLE IF NOT EXISTS Users (
    user_id INT  PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(30),
    user_address VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS Books_Out_On_Loan (
    book_borrowing_id INT  PRIMARY KEY AUTO_INCREMENT,
    date_issued DATE,
    date_due_for_return DATE,
    date_returned DATE,
    user_id INT,
    isbn VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS Books (
    isbn VARCHAR(30),
    book_title VARCHAR(30),
    date_of_publication DATE,
    author_id INT,
    category_id INT
);

CREATE TABLE IF NOT EXISTS Author (
    author_id INT  PRIMARY KEY AUTO_INCREMENT,
    author_firstname VARCHAR(30),
    author_surname VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(30)
)