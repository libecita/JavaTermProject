DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;


CREATE TABLE IF NOT EXISTS users (
                                         id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         user_identifier VARCHAR(50) UNIQUE,
                                         last_name VARCHAR(50),
                                         first_name VARCHAR(50),
                                         email_address VARCHAR(50),
                                         username VARCHAR(50) UNIQUE,
                                         relationship_status VARCHAR(50),
                                         date_of_birth VARCHAR(50),
                                         date_joined VARCHAR(50),
                                         password VARCHAR(50)
);



CREATE TABLE IF NOT EXISTS posts (
                                        id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        post_identifier VARCHAR(50) UNIQUE,
                                        date_posted VARCHAR(50),
                                        description VARCHAR(300),
                                        title VARCHAR(50),
                                        picture VARCHAR(50),
                                        user_identifier VARCHAR(50) ,
                                        FOREIGN KEY (user_identifier) REFERENCES users(user_identifier)

);

