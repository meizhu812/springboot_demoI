CREATE TABLE student
(
    name     VARCHAR(10)             NOT NULL
        PRIMARY KEY,
    gender   ENUM ('Male', 'Female') NULL,
    class_id VARCHAR(10)             NOT NULL
);