INSERT INTO faculty (id, name, icon, campus_id, university_id, created_at) VALUES (1,'Faculty of Technical Sciences', 'faculty_of_technical_sciences.svg', 1, 1, NOW());
INSERT INTO faculty (id, name, icon, campus_id, university_id, created_at) VALUES (2,'Faculty of Philosophy', 'faculty_of_agriculture.svg', 2, 1, NOW());
INSERT INTO faculty (id, name, icon, campus_id, university_id, created_at) VALUES (3,'Faculty of Law', 'faculty_of_law.svg', 3, 1, NOW());
INSERT INTO faculty (id, name, icon, campus_id, university_id, created_at) VALUES (4,'Faculty of Economics', 'faculty_of_economics.svg', 3, 1, NOW());
INSERT INTO faculty (id, name, icon, campus_id, university_id, created_at) VALUES (5,'Faculty of Medicine', 'faculty_of_medicine.svg', 2, 1, NOW());
INSERT INTO faculty (id, name, icon, campus_id, university_id, created_at) VALUES (6,'Academy of Arts', 'academy_of_arts.svg', 3, 1, NOW());



INSERT INTO faculty_information (id, faculty_id, email, history, mission, accreditation, president, phone_number, address_id, created_at) VALUES (1, 1, 'fts@ula.com', 'FTS History HTML CONTENT', 'FTS Mission HTML CONTENT', 'FTS Accreditation HTML CONTENT', 'FTS President HTML CONTENT', '202-555-0184', 1, NOW());
INSERT INTO faculty_information (id, faculty_id, email, history, mission, accreditation, president, phone_number, address_id, created_at) VALUES (2, 2, 'fa@ula.com', 'FA History HTML CONTENT', 'FA Mission HTML CONTENT', 'FA Accreditation HTML CONTENT', 'FA President HTML CONTENT', '202-555-0185', 2, NOW());
INSERT INTO faculty_information (id, faculty_id, email, history, mission, accreditation, president, phone_number, address_id, created_at) VALUES (3, 3, 'fl@ula.com', 'FL History HTML CONTENT', 'FL Mission HTML CONTENT', 'FL Accreditation HTML CONTENT', 'FL President HTML CONTENT', '202-555-0186', 3, NOW());
INSERT INTO faculty_information (id, faculty_id, email, history, mission, accreditation, president, phone_number, address_id, created_at) VALUES (4, 4, 'fe@ula.com', 'FE History HTML CONTENT', 'FE Mission HTML CONTENT', 'FE Accreditation HTML CONTENT', 'FE President HTML CONTENT', '202-555-0187', 2, NOW());
INSERT INTO faculty_information (id, faculty_id, email, history, mission, accreditation, president, phone_number, address_id, created_at) VALUES (5, 5, 'fm@ula.com', 'FM History HTML CONTENT', 'FM Mission HTML CONTENT', 'FM Accreditation HTML CONTENT', 'FM President HTML CONTENT', '202-555-0188', 1, NOW());
INSERT INTO faculty_information (id, faculty_id, email, history, mission, accreditation, president, phone_number, address_id, created_at) VALUES (6, 6, 'aoa@ula.com', 'AOA History HTML CONTENT', 'AOA Mission HTML CONTENT', 'AOA Accreditation HTML CONTENT', 'AOA President HTML CONTENT', '202-555-0189', 1, NOW());



INSERT INTO study_program_degree (id, level) VALUES (1, 'Undergraduate');
INSERT INTO study_program_degree (id, level) VALUES (2, 'Master');
INSERT INTO study_program_degree (id, level) VALUES (3, 'Doctoral');


INSERT INTO study_program_location (id, name) VALUES (1,'Main Campus');
INSERT INTO study_program_location (id, name) VALUES (2, 'West Campus');
INSERT INTO study_program_location (id, name) VALUES (3, 'South Campus');



INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Production Engineering', 1, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Computer Science', 1, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Biomedical Engineering', 1, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Mechatronics', 1, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Industrial Engineering', 1, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Graphic Engineering and Design', 1, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Computing and Control Engineering', 1, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Architecture', 1, 1, 1, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Production Engineering', 2, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Civil Engineering', 2, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Architecture', 2, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Computer Science', 2, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Graphic Engineering and Design', 2, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Biomedical Engineering', 2, 1, 1, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Architecture', 3, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Mechatronics', 3, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Computing and Control Engineering', 3, 1, 1, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Traffic Engineering', 3, 1, 1, NOW());




INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Pedagogy', 1, 2, 2, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Psychology', 1, 2, 2, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Sociology', 1, 2, 2, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Philosophy', 1, 2, 2, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Journalism', 1, 2, 2, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('History', 2, 2, 2, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Pedagogy', 2, 2, 2, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Psychology', 2, 2, 2, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Sociology', 2, 2, 2, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('General Legal Studies', 1, 3, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Criminal Justice Studies', 1, 3, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('General Legal Studies', 2, 3, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Criminal Justice Studies', 2, 3, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('National Security', 2, 3, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Public Law', 3, 3, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Private Law', 3, 3, 3, NOW());



INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Finance, Banking and Insurance', 1, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Management', 1, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Accounting and Auditing', 1, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Trade', 1, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Business Informatics', 1, 4, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Finance, Banking and Insurance', 2, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Management', 2, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Business Information Systems', 2, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Accounting and Auditing', 2, 4, 3, NOW());

INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Economy', 3, 4, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Business Economics and Management', 3, 4, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Nursing', 1, 5, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Medical Rehabilitation', 1, 5, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Special Education and Rehabilitation', 1, 5, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Nursing', 2, 5, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Special Education and Rehabilitation', 2, 5, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Medical Rehabilitation', 2, 5, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Molecular Medicine', 3, 5, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Clinical Medicine', 3, 5, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Public Health', 3, 5, 3, NOW());



INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Composition', 1, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Musicology', 1, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Ethnomusicology', 1, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Music Pedagogy', 1, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Acting', 1, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Мusic Production', 1, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Fine Arts', 1, 6, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Composition', 2, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Musicology', 2, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Ethnomusicology', 2, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Acting', 2, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Мusic Production', 2, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Fine Arts', 2, 6, 3, NOW());


INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Composition', 3, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Musicology', 3, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Ethnomusicology', 3, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Acting', 3, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Мusic Production', 3, 6, 3, NOW());
INSERT INTO study_program (name, degree_id, faculty_id, location_id, created_at) VALUES ('Fine Arts', 3, 6, 3, NOW());
