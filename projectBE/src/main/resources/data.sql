INSERT INTO role ( ROLE_NAME) VALUES ('ADMIN') on conflict do nothing;
INSERT INTO role ( ROLE_NAME) VALUES ('USER') on conflict do nothing;

INSERT INTO category (NAME) VALUES ('Tutoring') on conflict do nothing;