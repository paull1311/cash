DELETE FROM operations;
ALTER SEQUENCE operations_id_seq RESTART WITH 1;
DELETE FROM accounts;
ALTER SEQUENCE accounts_id_seq RESTART WITH 1;
DELETE FROM users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;

INSERT INTO users (email, password, name, role)
VALUES ('admin@mail.com', '$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK', 'Administrator', 0);
INSERT INTO users (email, password, name, role)
VALUES ('user@mail.com', '$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm', 'Username', 1);

INSERT INTO accounts (name, currency, user_id)
VALUES ('Зарплатный', 0, 0);
INSERT INTO accounts (name, currency, user_id)
VALUES ('Копилка', 1, 0);

INSERT INTO operations (message, opertype, amount, account_id)
VALUES ('Зарплата', 0, 10000.00, 0);
INSERT INTO operations (message, opertype, amount, account_id)
VALUES ('Продукты', 1, -243.65, 0);
INSERT INTO operations (message, opertype, amount, account_id)
VALUES ('Beer', 1, -200.00, 0);
INSERT INTO operations (message, opertype, amount, account_id)
VALUES ('Такси', 1, -120.00, 0);
INSERT INTO operations (message, opertype, amount, account_id)
VALUES ('Заначка', 1, -2650.00, 0);
INSERT INTO operations (message, opertype, amount, account_id)
VALUES ('Заначка с з/п', 1, 100.00, 1);