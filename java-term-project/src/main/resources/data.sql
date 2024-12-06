INSERT INTO users (user_identifier, last_name, first_name, email_address, username,
                   relationship_status,date_of_birth, date_joined, password)
VALUES
    ('121u', 'Smith', 'John', 'john.smith@example.com', 'johnny', 'Single', '1988-07-05', '2015-09-22',  'sjhon'),
    ('122u', 'Johnson', 'Emily', 'emily.johnson@example.com', 'em234', 'Divorced', '1999-03-21', '2017-03-05', 'jemily'),
    ('123u', 'Wong', 'Michael', 'michael.wong@example.com', 'mik09', 'Married', '2000-01-11', '2020-06-24', 'wmichael');
INSERT INTO posts (post_identifier, date_posted, description, title,picture,user_identifier)
VALUES
    ('100', '2011-12-25', 'Beautiful Miami!', 'Miami', 'miami.jpg','121u'),
    ('101', '2015-06-07', 'Cutest cats ever!!', 'Cats', 'cats.jpg','122u'),
    ('102', '2016-11-30', 'Beautiful day at the park.', 'Park','park.jpg', '123u'),
    ('103', '2015-06-07', 'Cutest dogs ever!!', 'Dogs', 'dogs.jpg','122u'),
    ('104', '2016-12-30', 'Staying home todayyy!', 'Home Alone','home.jpg', '123u');


