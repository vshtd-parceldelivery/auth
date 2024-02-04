CREATE SEQUENCE profile_seq;
CREATE TABLE profile (
  id            BIGINT         DEFAULT nextval('profile_seq') PRIMARY KEY,
  username      VARCHAR(50)    NOT NULL UNIQUE,
  password      VARCHAR(500)   NOT NULL,
  role          VARCHAR(50)    NOT NULL
);

-------------------------------------------------------------

INSERT INTO profile (id, username, password, role)
VALUES (nextval('profile_seq'), 'admin', '$2a$10$0YaXSXw7f10v8er3JLjiPejlTejyUPz52jYh.oWQcyE4FgvXMzqYK', 'ROLE_ADMIN');
INSERT INTO profile (id, username, password, role)
VALUES (nextval('profile_seq'), 'user', '$2a$10$0YaXSXw7f10v8er3JLjiPejlTejyUPz52jYh.oWQcyE4FgvXMzqYK', 'ROLE_USER');
INSERT INTO profile (id, username, password, role)
VALUES (nextval('profile_seq'), 'courier', '$2a$10$0YaXSXw7f10v8er3JLjiPejlTejyUPz52jYh.oWQcyE4FgvXMzqYK', 'ROLE_COURIER');