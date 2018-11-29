--drop table Role;
--drop table User;

CREATE TABLE IF NOT EXISTS role(
      id BIGINT AUTO_INCREMENT primary key,
       name varchar(255));
CREATE TABLE IF NOT EXISTS user(id BIGINT primary key AUTO_INCREMENT, login varchar(255), password varchar(255),
      email varchar(255), first_name varchar(255), last_name varchar(255), birthday DATE, role_id BIGINT);

-- INSERT INTO role (name) VALUES ("ADMIN");
-- INSERT INTO role (name) VALUES ("USER");
-- INSERT INTO user (login, password, role_id) VALUES ("admin", "admin", 1);
-- INSERT INTO user (login, password, role_id) VALUES ("user", "user", 2);

INSERT INTO "PUBLIC"."ROLE" ("NAME") VALUES ('ADMIN');
INSERT INTO "PUBLIC"."ROLE" ("NAME") VALUES ('USER');
INSERT INTO "PUBLIC"."USER" ("LOGIN", "PASSWORD", "ROLE_ID") VALUES ('admin', 'admin', 1);
-- INSERT INTO "PUBLIC"."USER" ("LOGIN", "PASSWORD", "EMAIL", "FIRST_NAME", "LAST_NAME", "BIRTHDAY", "ROLE_ID") VALUES ('admin', 'admin', 'NULL', 'NULL', 'NULL', 'NULL', NULL);
INSERT INTO "PUBLIC"."USER" ("LOGIN", "PASSWORD", "ROLE_ID") VALUES ('user', 'user', 2);
-- INSERT INTO "PUBLIC"."USER" ("LOGIN", "PASSWORD", "EMAIL", "FIRST_NAME", "LAST_NAME", "BIRTHDAY", "ROLE_ID") VALUES ('user', 'user', 'NULL', 'NULL', 'NULL', 'NULL', NULL);