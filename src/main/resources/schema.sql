
CREATE TABLE user (
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY  ,
 username VARCHAR(20) NOT NULL ,
 email VARCHAR NOT NULL,
 password VARCHAR NOT NULL ,
 create_time TIMESTAMP  DEFAULT CURRENT_TIMESTAMP);

INSERT INTO User(username, email, password)
VALUES ('Cardinal', 'Stavanger', 'Norway'),
       ('Taras', 'Shev4enko', 'Ukraine');