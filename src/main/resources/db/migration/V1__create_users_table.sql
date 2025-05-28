CREATE TABLE IF NOT EXISTS users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NULL,
    name       VARCHAR(100)          NOT NULL,
    email      VARCHAR(150)          NOT NULL,
    password   VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);