DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS likes;

CREATE TABLE IF NOT EXISTS users (
                                         id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         user_identifier VARCHAR(50) UNIQUE,
                                         last_name VARCHAR(50),
                                         first_name VARCHAR(50),
                                         email_address VARCHAR(50),
                                         username VARCHAR(50) UNIQUE,
                                         relationship_status VARCHAR(50),
                                         date_of_birth DATE,
                                         date_joined DATE,
                                         password VARCHAR(50)
);



CREATE TABLE IF NOT EXISTS posts (
                                        id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        post_identifier VARCHAR(50) UNIQUE,
                                        date_posted DATE,
                                        description VARCHAR(300),
                                        title VARCHAR(50),
                                        username VARCHAR(50) UNIQUE,
                                        FOREIGN KEY (username) REFERENCES users(username)
);


CREATE TABLE IF NOT EXISTS likes (
                                      id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                      like_identifier VARCHAR(50) UNIQUE,
                                      username VARCHAR(50) UNIQUE,
                                      post_identifier VARCHAR(50) UNIQUE,
                                      FOREIGN KEY (username) REFERENCES users(username),
                                      FOREIGN KEY (post_identifier) REFERENCES posts(post_identifier)

);
