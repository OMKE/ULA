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

# Production Engineering years
INSERT INTO year_of_study (id,year, ordinal_number, study_program_id, created_at) VALUES (1,'2020-11-01', 1, 2, NOW());
INSERT INTO year_of_study (id,year, ordinal_number, study_program_id, created_at) VALUES (2,'2021-11-01', 2, 2, NOW());
INSERT INTO year_of_study (id,year, ordinal_number, study_program_id, created_at) VALUES (3,'2022-11-01', 3, 2, NOW());


# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "Advanced Methods in Metal Forming", 1, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "CAD CAE CAM and CIM Systems", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "Casting Technology", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "Computer Aided Design of Tools and Dies for Metal Forming", 1, 7, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "Contemporary Casting Technologies", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "Contemporary Materials", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "Cutting tools", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (1, "Fixtures", 2, 5, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Innovation Technologies", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Integrated CAPP Systems and Technological Database", 3, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Machines and Devices for Plastic Processing", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Machines for Processing by Deforming", 3, 5, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Mechanical Materials", 4, 8, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Metal Forming", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Nonconventional Procedures in Processing", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (2, "Process Planning", 4, 6, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (3, "Reverse Engineering and CAQ", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (3, "Virtual Product Designing", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (3, "Virtual Production in Technologies of Plastic Deforming", 5, 6, 20, 20, 0, 0, 0, NOW());


# Computer Science years
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (4,'2020-11-01', 1, 3, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (5,'2021-11-01', 2, 3, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (6,'2022-11-01', 3, 3, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (7,'2023-11-01', 4, 3, NOW());

# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Great Ideas in Computer Science", 1, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Elements of Data Science", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Discrete Mathematics for Computer Science", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Introduction to Computer Science", 1, 7, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Abstraction and Design in Computation", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Systems Programming and Machine Organization", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Privacy and Technology", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (4, "Data Science 1: Introduction to Data Science", 2, 5, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Data Science 2: Advanced Topics in Data Science", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Data Structures and Algorithms", 3, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Computing Hardware", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Computer Networks", 3, 5, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Programming Languages", 4, 8, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Computer Graphics", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Machine Learning", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (5, "Artificial Intelligence", 4, 6, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Operating Systems", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Computing at Scale", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Advanced Topics in Programming Languages", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Computational Complexity", 5, 6, 20, 20, 0, 0, 0, NOW());

# 6th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Algorithms at the Ends of the Wire", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Computing Foundations for Computational Science", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Topics on Computation in Networks and Crowds", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (6, "Programming Languages", 6, 6, 20, 20, 0, 0, 0, NOW());

# FOURTH YEAR
# 7th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Distributed systems", 7, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Cloud computing", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Internet technology and web services", 7, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Programming Languages 2", 7, 8, 20, 20, 0, 0, 0, NOW());

# 8th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Project management", 8, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Topics in Theoretical Computer Science: Biology and Complexity", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Software testing and quality insurance", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (7, "Advanced Topics in Programming Languages", 8, 6, 20, 20, 0, 0, 0, NOW());

#Biomedical Engineering
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (8,'2020-11-01', 1, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (9,'2021-11-01', 2, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (10,'2022-11-01', 3, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (11,'2023-11-01', 4, 4, NOW());

# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Physics", 1, 8, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Fundamentals of electrical engineering", 1, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Basics of computing", 1, 8, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Mechanics", 1, 8, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Fundamentals of electronics", 2, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Fundamentals of Anatomy for Engineers", 2, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Introduction to medical informatics", 2, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (8, "Communication systems", 2, 5, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "Microprocessor systems in medicine", 3, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "Electrical and electronic measurements", 3, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "Fundamentals of biomedical engineering", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "Statistical bases, processing and modeling of biomedical signals", 3, 5, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "Biological systems and management", 4, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "System modeling and simulation", 4, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "Biomechanics", 4, 8, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (9, "Rehabilitation devices and systems", 4, 6, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Application of radio and microwaves in medicine", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Neurophysiology and medical rehabilitation", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Analysis and processing of biomedical signals", 5, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Elective position 1", 5, 6, 20, 20, 0, 0, 0, NOW());

# 6th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Biomedical engineering in sports physiology", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Neuroengineering", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Biomechanics of continuous media", 6, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (10, "Sensors and actuators in medicine", 6, 5, 20, 20, 0, 0, 0, NOW());

# FOURTH YEAR
# 7th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Basics of neural dentures", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Shape recognition", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Elective position 5", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Elective position 6", 7, 5, 20, 20, 0, 0, 0, NOW());

# 8th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Equipment and systems to help the elderly, the sick and the disabled", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Image processing in medicine", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Neurorehabilitation", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (11, "Biomedical engineering in cognitive neuroscience", 8, 6, 20, 20, 0, 0, 0, NOW());

#Mechatronics
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (12,'2020-11-01', 1, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (13,'2021-11-01', 2, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (14,'2022-11-01', 3, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (15,'2023-11-01', 4, 4, NOW());

# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Physics", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Fundamentals of product development", 1, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Mathematics 1", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Fundamentals of Electrical Engineering 1", 1, 4, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Mathematics 2", 2, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Fundamentals of Electrical Engineering 2", 2, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Basics of programming", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (12, "Materials in electrical engineering", 2, 5, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Mechanics 2 - general", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Resistance of materials", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Mathematics 3", 3, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Machine elements 1", 3, 5, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Programming and programming languages", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Machine elements 2", 4, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Digital electronics", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (13, "Measurements in technique", 4, 5, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "System modeling and simulation 1", 5, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "Automatic control 2", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "Analog electronics", 5, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "Machine mechanics", 5, 6, 20, 20, 0, 0, 0, NOW());

# 6th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "Industrial robotics", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "Components of technological systems", 6, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "Application of sensors and actuators", 6, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (14, "Elective course 3 MECHATRONICS basic", 6, 7, 20, 20, 0, 0, 0, NOW());

# FOURTH YEAR
# 7th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "Programming and application of programmable logic controllers", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "Professional practice - basic academic studies", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "Mechatronics", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "Graphic communications and CAD", 7, 5, 20, 20, 0, 0, 0, NOW());

# 8th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "Work process automation", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "SUS engine mechatronics", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "Computer integration of production systems", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (15, "Final - graduate thesis", 8, 6, 20, 20, 0, 0, 0, NOW());


#Industrial Engineering
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (16,'2020-11-01', 1, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (17,'2021-11-01', 2, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (18,'2022-11-01', 3, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (19,'2023-11-01', 4, 4, NOW());

# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Fundamentals of industrial engineering and management", 1, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Mathematics 1", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Sociology of work", 1, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Materials in engineering", 1, 5, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Mathematics 2", 2, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Processes and means of work", 2, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Product development and design", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (16, "Mechanics in Industrial Engineering", 2, 5, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Management of technical systems", 3, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Probability theory and statistics", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Računarom podržano projektovanje proizvoda (CAD/CAE)", 3, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Tehnologije obrade proizvoda", 3, 4, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Work study and ergonomics", 4, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Design of work procedures (CAPP, CAM)", 4, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Integral system support - logistics", 4, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (17, "Automatic identification systems", 4, 6, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Assembly technologies", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Material handling technologies", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Product measurement and control technologies", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Reliability of technical systems and maintenance", 5, 6, 20, 20, 0, 0, 0, NOW());

# 6th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Design of production systems", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Information systems design", 6, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Organization of the company", 6, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (18, "Quality management system", 6, 7, 20, 20, 0, 0, 0, NOW());

# FOURTH YEAR
# 7th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Work process management", 7, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Design, verification and analysis of environmental management systems", 7, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Service engineering", 7, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Work process simulation", 7, 4, 20, 20, 0, 0, 0, NOW());

# 8th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Computer integration of production systems", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Entrepreneurship and innovation", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Automation of continuous processes", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (19, "Database systems", 8, 6, 20, 20, 0, 0, 0, NOW());

#Graphic Engineering and Design 
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (20,'2020-11-01', 1, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (21,'2021-11-01', 2, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (22,'2022-11-01', 3, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (23,'2023-11-01', 4, 4, NOW());

# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "Chemistry in graphic engineering", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "Mathematics", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "Arts", 1, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "English - basic", 1, 5, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "Graphic materials", 2, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "Physics", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "Sociology of culture", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (20, "Visual culture", 2, 4, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Introduction to graphic technologies", 3, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Electrical machines", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Letter and typography", 3, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Photography", 3, 4, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Graphic processes", 4, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Electronics and optoelectronics", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Multimedia", 4, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (21, "Graphic culture", 4, 5, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Reproduction technique", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Basics of spatial design", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Printing forms", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Hemigraphy", 5, 6, 20, 20, 0, 0, 0, NOW());

# 6th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Printing techniques", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Finishing graphic processing", 6, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Industrial design", 6, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (22, "Graphic product design", 6, 7, 20, 20, 0, 0, 0, NOW());

# FOURTH YEAR
# 7th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "The science of color", 7, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "Basics of computer games", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "WEB design", 7, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "Simulation modeling and control", 7, 7, 20, 20, 0, 0, 0, NOW());

# 8th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "Graphic systems", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "Graphic design", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "Production systems", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (23, "English for GRID 2", 8, 5, 20, 20, 0, 0, 0, NOW());

#Computing and Control Engineering
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (24,'2020-11-01', 1, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (25,'2021-11-01', 2, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (26,'2022-11-01', 3, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (27,'2023-11-01', 4, 4, NOW());

# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Programming languages ​​and data structures", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Introduction to information and financial engineering ", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Communication", 1, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Mechanics", 1, 5, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Mathematical analysis 1", 2, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Computer architecture ", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Algorithm theory ", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (24, "Fundamentals of financial engineering ", 2, 4, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Mathematical analysis 2", 3, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Fundamentals of graph theory and combinatorics", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Object Oriented Programming", 3, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Logical design of computer systems 1", 3, 4, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Probability and random processes", 4, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Operating systems", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Web programming", 4, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (25, "Fundamentals of financial engineering 2", 4, 5, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Optimization methods", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Numerical algorithms and numerical software", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Databases 1", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Program translators", 5, 6, 20, 20, 0, 0, 0, NOW());

# 6th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Fundamentals of Computer Intelligence ", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Parallel computing", 6, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Practicum in statistics", 6, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (26, "Interaction human computer", 6, 7, 20, 20, 0, 0, 0, NOW());

# FOURTH YEAR
# 7th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Analytical engineering", 7, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Applied information engineering", 7, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Databases 2", 7, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Software specification and modeling", 7, 7, 20, 20, 0, 0, 0, NOW());

# 8th semester

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Computer communications", 8, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Analytical engineering", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Applied information engineering", 8, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (27, "Internet networks", 8, 5, 20, 20, 0, 0, 0, NOW());

#Architecture
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (28,'2020-11-01', 1, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (29,'2021-11-01', 2, 4, NOW());
INSERT INTO year_of_study (id, year, ordinal_number, study_program_id, created_at) VALUES (30,'2022-11-01', 3, 4, NOW());

# Subjects/Courses

# FIRST YEAR
# 1st semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Mathematics", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Descriptive geometry 1", 1, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Constructions, materials and construction", 1, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Elements and assemblies of buildings 1", 1, 5, 20, 20, 0, 0, 0, NOW());

# 2nd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Descriptive geometry 2", 2, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Elements and assemblies of buildings 2", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Architectural analysis, functions and typology 2", 2, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (28, "Sociology and economics of the built environment", 2, 4, 20, 20, 0, 0, 0, NOW());

# SECOND YEAR
# 3rd semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Urban / rural analysis and morphology 1", 3, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Architectural technologies 1", 3, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Housing 1", 3, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Architecture and the city of the Middle Ages", 3, 4, 20, 20, 0, 0, 0, NOW());

# 4th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Architectural technologies 2", 4, 4, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Architectural physics", 4, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Architecture and the city of the new age", 4, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (29, "Resistance of materials", 4, 5, 20, 20, 0, 0, 0, NOW());

# THIRD YEAR
# 5th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "Construction theory and construction systems", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "Urban design", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "Architectural design", 5, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "History of art and culture 2", 5, 6, 20, 20, 0, 0, 0, NOW());

# 6th semester
INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "Development of regional architecture 2", 6, 6, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "Load - bearing structures", 6, 7, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "Architectural design 2", 6, 5, 20, 20, 0, 0, 0, NOW());

INSERT INTO subject (year_of_study_id, name, semester, espb, number_of_lectures, number_of_practical_lectures, other_forms_of_lectures, research_works, other_lectures, created_at) VALUES (30, "Urban design 2", 6, 7, 20, 20, 0, 0, 0, NOW());
