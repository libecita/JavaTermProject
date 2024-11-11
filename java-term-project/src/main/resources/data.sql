INSERT INTO users (user_identifier, last_name, first_name, email_address, username,
                   relationship_status,date_of_birth, date_joined, password)
VALUES
    ('123e4567-e89b-12d3-a456-556642440000', 'Smith', 'John', 'john.smith@example.com', 'John', 'Single', '1988-07-05', '2000-09-30', 'sjhon'),
    ('223e4567-e89b-12d3-a456-556642440001', 'Johnson', 'Emily', 'emily.johnson@example.com', 'Emily', 'Divorced', '1999-03-21', '2013-08-12 Columbia' ,'jemily'),
    ('323e4567-e89b-12d3-a456-556642440002', 'Wong', 'Michael', 'michael.wong@example.com', 'Michael', 'Married', '2000-01-11', '2000-12-26','wmichael');


INSERT INTO posts (post_identifier, date_posted, description, title, username)
VALUES
    ('123e4567-a456-12d3-e89b-556642440000', '2011-12-25', 'Plain white cotton T-shirt', 'T-shirt', 'John'),
    ('123e4567-a456-12d3-e89b-556642440001', '2015-06-07', 'Blue denim jeans', 'Blue jeans', 'Emily'),
    ('123e4567-a456-12d3-e89b-556642440002', '2016-11-30', 'Black and white sneakers', 'Sneakers', 'Michael');


INSERT INTO likes (like_identifier, username, post_identifier)
VALUES
    ('223e4567-oooo-12d3-a456-556642440001', 'John', '123e4567-a456-12d3-e89b-556642440000'),
    ('323e4567-oooo-12d3-a456-556642440002', 'Emily', '123e4567-a456-12d3-e89b-556642440001'),
    ('423e4567-oooo-12d3-a456-556642440003', 'Michael', '123e4567-a456-12d3-e89b-556642440002');
