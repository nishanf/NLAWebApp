--DROP TABLE users IF EXISTS;


CREATE TABLE Person (
  person_id   INTEGER PRIMARY KEY,
  email  VARCHAR(30),
  name VARCHAR(30),
  phone  VARCHAR(20)
);

CREATE TABLE Book (
  isbn  VARCHAR(30) PRIMARY KEY,
  title VARCHAR(200),
  author  VARCHAR(60)
);

CREATE TABLE Burrowings (
  burrow_id  INTEGER PRIMARY KEY,
  person_id  INTEGER,
  isbn  VARCHAR(30)
);
