INSERT INTO users (user_identifier, last_name, first_name, email_address, username,
                   relationship_status,date_of_birth, date_joined, password)
VALUES
    ('121u', 'Smith', 'John', 'john.smith@example.com', 'John', 'Single', '1988-07-05', '2000-09-30', 'sjhon'),
    ('122u', 'Johnson', 'Emily', 'emily.johnson@example.com', 'Emily', 'Divorced', '1999-03-21', '2013-08-12' ,'jemily'),
    ('123u', 'Wong', 'Michael', 'michael.wong@example.com', 'Michael', 'Married', '2000-01-11', '2000-12-26','wmichael');


INSERT INTO posts (post_identifier, date_posted, description, title,picture,username)
VALUES
    ('100', '2011-12-25', 'Got a new T-shirt!', 'T-shirt', 'img100.png','John'),
    ('101', '2015-06-07', 'Selling blue jeans for 50$. Anyone interested?', 'Blue jeans', 'img101.png','Emily'),
    ('102', '2016-11-30', 'Sneaky sneakers :)', 'Sneakers','img102.png', 'Michael');


