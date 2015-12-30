DELETE FROM Users;
INSERT INTO Users(user_name, user_address) VALUES('Nobita Nobi', 'Yokohama');
INSERT INTO Users(user_name, user_address) VALUES('Takeshi Goda', 'Tokyo');
INSERT INTO Users(user_name, user_address) VALUES('Suneo Honekawa', 'Saitama');
INSERT INTO Users(user_name, user_address) VALUES('Shizuka Minamoto', 'Chiba');

DELETE FROM Books;
INSERT INTO Books(isbn, book_title, date_of_publication, author_id, category_id)
    VALUES ('9784101010038', '坊っちゃん', DATE '2003-04-01', 1, 1);

INSERT INTO Books_Out_On_Loan(date_issued, date_due_for_return, date_returned, user_id, isbn)
    VALUES (DATE '2015-01-01', DATE '2015-01-31', NULL, 1, '1234567890');

