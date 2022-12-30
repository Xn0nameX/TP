-- SET search_path TO boot;
CREATE TABLE products (id serial, title varchar(100), price int, view int default 0);

INSERT INTO products (title, price) VALUES ('Bread', 40), ('Milk', 80), ('Chocolate', 150);

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);



INSERT INTO users
VALUES
('admin', '{bcrypt}$2a$12$pcxLScmE1YgwkWbFac0C5egB.QIfrZ6ro6i.5z9bWFACWcHuYLLBq', true),
('user', '{bcrypt}$2a$12$DDbXPPB6DcWWRuXo8NttMel...9QtXmXTTLrT1fhQr2JHQXtv8T7W', true);



CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    CONSTRAINT authorities_idx UNIQUE (username, authority),

    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username)
    REFERENCES users (username)
);

INSERT INTO authorities
VALUES
('admin', 'ROLE_ADMIN'),
('admin', 'ROLE_USER'),
('user', 'ROLE_USER');