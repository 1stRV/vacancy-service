CREATE TABLE vacancy (
  id         INTEGER AUTO_INCREMENT,
  name       VARCHAR(255),
  salary     INTEGER,
  experience VARCHAR(255),
  city       VARCHAR(255)
);

INSERT INTO vacancy(name, salary, experience, city)
VALUES ('test_name', 200, 'test_experience', 'test_city');

SELECT * FROM vacancy;