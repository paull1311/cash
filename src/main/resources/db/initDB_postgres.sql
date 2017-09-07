DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS operations;

CREATE TABLE users (
  id          SERIAL PRIMARY KEY,
  email       TEXT NOT NULL UNIQUE,
  password    TEXT NOT NULL,
  name        TEXT NOT NULL,
  role        INTEGER NOT NULL
);

CREATE TABLE accounts (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL UNIQUE,
  currency    INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE operations (
  id          SERIAL PRIMARY KEY,
  message     TEXT,
  opertype    INTEGER,
  date        TIMESTAMP WITH TIME ZONE NOT NULL,
  amount      NUMERIC (10, 2),
  FOREIGN KEY (account_id) REFERENCES accounts (id) ON DELETE SET NULL
);
