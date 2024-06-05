CREATE TABLE station
(
    id      SERIAL PRIMARY KEY,
    station VARCHAR(50) NOT NULL
);

CREATE TABLE "user" (
    id       SERIAL PRIMARY KEY,
    nickname VARCHAR(50)         NOT NULL,
    email    VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE "order"
(
    id              SERIAL PRIMARY KEY,
    user_id         INT NOT NULL,
    from_station_id INT NOT NULL,
    to_station_id   INT NOT NULL,
    status          INT NOT NULL,
    created         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    FOREIGN KEY (from_station_id) REFERENCES station (id),
    FOREIGN KEY (to_station_id) REFERENCES station (id)
);

INSERT INTO station (station) VALUES ('S1');
INSERT INTO station (station) VALUES ('S2');