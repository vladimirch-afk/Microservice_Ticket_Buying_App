CREATE TABLE user (
    id       SERIAL PRIMARY KEY,
    nickname VARCHAR(50)         NOT NULL,
    email    VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE session (
    id      SERIAL PRIMARY KEY,
    user_id INT          NOT NULL,
    token   VARCHAR(255) NOT NULL,
    expires TIMESTAMP    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id)
);