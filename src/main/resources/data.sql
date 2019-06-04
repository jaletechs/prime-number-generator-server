
INSERT INTO USER(email, password, full_name, last_password_reset_date) VALUES ('admin@gmail.com', '$2a$10$qkgHAwJWwvFEAg7992m8I.jyBYeCkKZh0GhxWCLTAoCz8TyIDET6i', 'Test User 1', PARSEDATETIME('01-06-2019', 'dd-MM-yyyy'));
INSERT INTO USER(email, password, full_name, last_password_reset_date) VALUES ('user@gmail.com', '$2a$10$qkgHAwJWwvFEAg7992m8I.jyBYeCkKZh0GhxWCLTAoCz8TyIDET6i', 'Test User 2', PARSEDATETIME('01-06-2019', 'dd-MM-yyyy'));

INSERT INTO authority (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_authority (user_id, authority_id) VALUES ('admin@gmail.com', 1);
INSERT INTO user_authority (user_id, authority_id) VALUES ('admin@gmail.com', 2);
INSERT INTO user_authority (user_id, authority_id) VALUES ('user@gmail.com', 1);
INSERT INTO user_authority (user_id, authority_id) VALUES ('user@gmail.com', 2);