INSERT INTO customers(first_name, last_name) VALUES('Nobita', 'Nobi');
INSERT INTO customers(first_name, last_name) VALUES('Takeshi', 'Goda');
INSERT INTO customers(first_name, last_name) VALUES('Suneo', 'Honekawa');
INSERT INTO customers(first_name, last_name) VALUES('Shizuka', 'Minamoto');


INSERT INTO Users(user_name, user_address) VALUES('Nobita Nobi', 'Yokohama');
INSERT INTO Users(user_name, user_address) VALUES('Takeshi Goda', 'Tokyo');
INSERT INTO Users(user_name, user_address) VALUES('Suneo Honekawa', 'Saitama');
INSERT INTO Users(user_name, user_address) VALUES('Shizuka Minamoto', 'Chiba');

INSERT INTO Books(isbn, book_title, date_of_publication, author_id, category_id)
    VALUES ('1234567890', 'Gradleの本', DATE '2015-01-01', 1, 1);

INSERT INTO Books_Out_On_Loan(date_issued, date_due_for_return, date_returned, user_id, isbn)
    VALUES (DATE '2015-01-01', DATE '2015-01-31', NULL, 1, '1234567890');
