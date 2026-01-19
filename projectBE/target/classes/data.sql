INSERT INTO role ( ROLE_NAME) VALUES ('ADMIN') on conflict do nothing;
INSERT INTO role ( ROLE_NAME) VALUES ('USER') on conflict do nothing;

INSERT INTO category (NAME, DESCRIPTION) VALUES ('Tutoring','Expert one-on-one guidance for academic success. Personalized lessons, homework help, and exam prep to excel in any subject.') on conflict do nothing;
INSERT INTO category (NAME, DESCRIPTION) VALUES ('Homework Assistance','Get reliable help with your assignments. Experienced tutors provide guidance and support to ensure your academic success.') on conflict do nothing;
INSERT INTO category (NAME, DESCRIPTION) VALUES ('Circuit Repair','Fast and reliable electrical circuit repair services to restore functionality and ensure efficient operation.') on conflict do nothing;
INSERT INTO category (NAME, DESCRIPTION) VALUES ('Circuit Design','Customized circuits for optimal performance. Expert engineers create tailored solutions to meet your unique needs.') on conflict do nothing;
INSERT INTO category (NAME, DESCRIPTION) VALUES ('Housekeeping','Professional and thorough home services for a pristine and inviting living space.') on conflict do nothing;
INSERT INTO category (NAME, DESCRIPTION) VALUES ('Career Assistance','Personalized guidance for success. Expert advice, resume building, interview prep, and job search strategies.') on conflict do nothing;
INSERT INTO category (NAME, DESCRIPTION) VALUES ('General Services','Versatile solutions by skilled professionals to meet diverse needs efficiently.') on conflict do nothing;