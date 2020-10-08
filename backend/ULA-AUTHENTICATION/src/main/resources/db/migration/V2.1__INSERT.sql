INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(8, 'Michael', 'Castro', 'michaelcastro', 'michael.castro@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 8, NOW()), (0, 5, 8, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 8, '<h1>Michael Castro</h1><p>Michael Castro Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(9, 'Justin', 'Lambert', 'justinlambert', 'justin.lambert@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 9, NOW()), (0, 5, 9, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 9, '<h1>Justin Lambert</h1><p>Justin Lambert Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(10, 'Bobby', 'Lee', 'bobbylee', 'bobby.lee@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 10, NOW()), (0, 5, 10, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 10, '<h1>Bobby Lee</h1><p>Bobby Lee Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(11, 'Andre', 'Bowman', 'andrebowman', 'andre.bowman@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 11, NOW()), (0, 5, 11, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 11, '<h1>Andre Bowman</h1><p>Andre Bowman Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(12, 'Brent', 'Chavez', 'brentchavez', 'brent.chavez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 12, NOW()), (0, 5, 12, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 12, '<h1>Brent Chavez</h1><p>Brent Chavez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(13, 'Lisa', 'Vincent', 'lisavincent', 'lisa.vincent@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 13, NOW()), (0, 5, 13, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 13, '<h1>Lisa Vincent</h1><p>Lisa Vincent Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(14, 'Edwin', 'Price', 'edwinprice', 'edwin.price@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 14, NOW()), (0, 5, 14, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 14, '<h1>Edwin Price</h1><p>Edwin Price Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(15, 'Christopher', 'Bennett', 'christopherbennett', 'christopher.bennett@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 15, NOW()), (0, 5, 15, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 15, '<h1>Christopher Bennett</h1><p>Christopher Bennett Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(16, 'Deanna', 'Patel', 'deannapatel', 'deanna.patel@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 16, NOW()), (0, 5, 16, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 16, '<h1>Deanna Patel</h1><p>Deanna Patel Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(17, 'Robert', 'Lewis', 'robertlewis', 'robert.lewis@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 17, NOW()), (0, 5, 17, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 17, '<h1>Robert Lewis</h1><p>Robert Lewis Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(18, 'Richard', 'Elliott', 'richardelliott', 'richard.elliott@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 18, NOW()), (0, 5, 18, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 18, '<h1>Richard Elliott</h1><p>Richard Elliott Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(19, 'Edward', 'Johnson', 'edwardjohnson', 'edward.johnson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 19, NOW()), (0, 5, 19, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 19, '<h1>Edward Johnson</h1><p>Edward Johnson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(20, 'Ivan', 'Ortega', 'ivanortega', 'ivan.ortega@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 20, NOW()), (0, 5, 20, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 20, '<h1>Ivan Ortega</h1><p>Ivan Ortega Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(21, 'Terri', 'Harris', 'terriharris', 'terri.harris@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 21, NOW()), (0, 5, 21, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 21, '<h1>Terri Harris</h1><p>Terri Harris Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(22, 'Adam', 'Pollard', 'adampollard', 'adam.pollard@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 22, NOW()), (0, 5, 22, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 22, '<h1>Adam Pollard</h1><p>Adam Pollard Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(23, 'Michael', 'Smith', 'michaelsmith', 'michael.smith@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 23, NOW()), (0, 5, 23, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 23, '<h1>Michael Smith</h1><p>Michael Smith Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(24, 'James', 'James', 'jamesjames', 'james.james@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 24, NOW()), (0, 5, 24, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 24, '<h1>James James</h1><p>James James Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(25, 'Katie', 'Heath', 'katieheath', 'katie.heath@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 25, NOW()), (0, 5, 25, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 25, '<h1>Katie Heath</h1><p>Katie Heath Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(26, 'Natalie', 'Thomas', 'nataliethomas', 'natalie.thomas@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 26, NOW()), (0, 5, 26, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 26, '<h1>Natalie Thomas</h1><p>Natalie Thomas Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(27, 'Jeremy', 'Jones', 'jeremyjones', 'jeremy.jones@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 27, NOW()), (0, 5, 27, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 27, '<h1>Jeremy Jones</h1><p>Jeremy Jones Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(28, 'Laura', 'Martin', 'lauramartin', 'laura.martin@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 28, NOW()), (0, 5, 28, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 28, '<h1>Laura Martin</h1><p>Laura Martin Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(29, 'Alexander', 'Hill', 'alexanderhill', 'alexander.hill@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 29, NOW()), (0, 5, 29, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 29, '<h1>Alexander Hill</h1><p>Alexander Hill Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(30, 'Patricia', 'Newton', 'patricianewton', 'patricia.newton@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 30, NOW()), (0, 5, 30, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 30, '<h1>Patricia Newton</h1><p>Patricia Newton Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(31, 'Heather', 'Flores', 'heatherflores', 'heather.flores@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 31, NOW()), (0, 5, 31, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 31, '<h1>Heather Flores</h1><p>Heather Flores Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(32, 'Sandra', 'Martinez', 'sandramartinez', 'sandra.martinez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 32, NOW()), (0, 5, 32, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 32, '<h1>Sandra Martinez</h1><p>Sandra Martinez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(33, 'Jacqueline', 'Miller', 'jacquelinemiller', 'jacqueline.miller@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 33, NOW()), (0, 5, 33, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 33, '<h1>Jacqueline Miller</h1><p>Jacqueline Miller Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(34, 'Megan', 'Curtis', 'megancurtis', 'megan.curtis@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 34, NOW()), (0, 5, 34, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 34, '<h1>Megan Curtis</h1><p>Megan Curtis Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(35, 'Jonathan', 'English', 'jonathanenglish', 'jonathan.english@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 35, NOW()), (0, 5, 35, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 35, '<h1>Jonathan English</h1><p>Jonathan English Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(36, 'Matthew', 'Jackson', 'matthewjackson', 'matthew.jackson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 36, NOW()), (0, 5, 36, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 36, '<h1>Matthew Jackson</h1><p>Matthew Jackson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(37, 'Sean', 'Tyler', 'seantyler', 'sean.tyler@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 37, NOW()), (0, 5, 37, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 37, '<h1>Sean Tyler</h1><p>Sean Tyler Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(38, 'Sarah', 'Peterson', 'sarahpeterson', 'sarah.peterson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 38, NOW()), (0, 5, 38, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 38, '<h1>Sarah Peterson</h1><p>Sarah Peterson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(39, 'Cameron', 'Bass', 'cameronbass', 'cameron.bass@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 39, NOW()), (0, 5, 39, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 39, '<h1>Cameron Bass</h1><p>Cameron Bass Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(40, 'Michael', 'Anderson', 'michaelanderson', 'michael.anderson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 40, NOW()), (0, 5, 40, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 40, '<h1>Michael Anderson</h1><p>Michael Anderson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(41, 'Lisa', 'Vance', 'lisavance', 'lisa.vance@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 41, NOW()), (0, 5, 41, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 41, '<h1>Lisa Vance</h1><p>Lisa Vance Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(42, 'Keith', 'Brown', 'keithbrown', 'keith.brown@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 42, NOW()), (0, 5, 42, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 42, '<h1>Keith Brown</h1><p>Keith Brown Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(43, 'John', 'Lee', 'johnlee', 'john.lee@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 43, NOW()), (0, 5, 43, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 43, '<h1>John Lee</h1><p>John Lee Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(44, 'Samuel', 'Haas', 'samuelhaas', 'samuel.haas@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 44, NOW()), (0, 5, 44, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 44, '<h1>Samuel Haas</h1><p>Samuel Haas Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(45, 'Joseph', 'Martinez', 'josephmartinez', 'joseph.martinez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 45, NOW()), (0, 5, 45, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 45, '<h1>Joseph Martinez</h1><p>Joseph Martinez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(46, 'Jerry', 'Patterson', 'jerrypatterson', 'jerry.patterson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 46, NOW()), (0, 5, 46, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 46, '<h1>Jerry Patterson</h1><p>Jerry Patterson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(47, 'Holly', 'Gray', 'hollygray', 'holly.gray@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 47, NOW()), (0, 5, 47, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 47, '<h1>Holly Gray</h1><p>Holly Gray Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(48, 'Russell', 'Collins', 'russellcollins', 'russell.collins@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 48, NOW()), (0, 5, 48, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 48, '<h1>Russell Collins</h1><p>Russell Collins Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(49, 'Samantha', 'White', 'samanthawhite', 'samantha.white@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 49, NOW()), (0, 5, 49, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 49, '<h1>Samantha White</h1><p>Samantha White Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(50, 'Brian', 'Holmes', 'brianholmes', 'brian.holmes@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 50, NOW()), (0, 5, 50, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 50, '<h1>Brian Holmes</h1><p>Brian Holmes Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(51, 'Willie', 'Knox', 'willieknox', 'willie.knox@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 51, NOW()), (0, 5, 51, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 51, '<h1>Willie Knox</h1><p>Willie Knox Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(52, 'Richard', 'Flores', 'richardflores', 'richard.flores@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 52, NOW()), (0, 5, 52, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 52, '<h1>Richard Flores</h1><p>Richard Flores Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(53, 'Troy', 'Vaughan', 'troyvaughan', 'troy.vaughan@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 53, NOW()), (0, 5, 53, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 53, '<h1>Troy Vaughan</h1><p>Troy Vaughan Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(54, 'Diana', 'Garcia', 'dianagarcia', 'diana.garcia@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 54, NOW()), (0, 5, 54, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 54, '<h1>Diana Garcia</h1><p>Diana Garcia Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(55, 'Jenna', 'Morgan', 'jennamorgan', 'jenna.morgan@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 55, NOW()), (0, 5, 55, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 55, '<h1>Jenna Morgan</h1><p>Jenna Morgan Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(56, 'Troy', 'Holmes', 'troyholmes', 'troy.holmes@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 56, NOW()), (0, 5, 56, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 56, '<h1>Troy Holmes</h1><p>Troy Holmes Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(57, 'Elizabeth', 'Jacobson', 'elizabethjacobson', 'elizabeth.jacobson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 57, NOW()), (0, 5, 57, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 57, '<h1>Elizabeth Jacobson</h1><p>Elizabeth Jacobson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(58, 'Melissa', 'Myers', 'melissamyers', 'melissa.myers@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 58, NOW()), (0, 5, 58, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 58, '<h1>Melissa Myers</h1><p>Melissa Myers Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(59, 'Karina', 'Gregory', 'karinagregory', 'karina.gregory@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 59, NOW()), (0, 5, 59, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 59, '<h1>Karina Gregory</h1><p>Karina Gregory Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(60, 'Thomas', 'Mcdonald', 'thomasmcdonald', 'thomas.mcdonald@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 60, NOW()), (0, 5, 60, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 60, '<h1>Thomas Mcdonald</h1><p>Thomas Mcdonald Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(61, 'Connie', 'Roth', 'connieroth', 'connie.roth@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 61, NOW()), (0, 5, 61, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 61, '<h1>Connie Roth</h1><p>Connie Roth Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(62, 'Elizabeth', 'Johnston', 'elizabethjohnston', 'elizabeth.johnston@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 62, NOW()), (0, 5, 62, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 62, '<h1>Elizabeth Johnston</h1><p>Elizabeth Johnston Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(63, 'Kristin', 'Olson', 'kristinolson', 'kristin.olson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 63, NOW()), (0, 5, 63, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 63, '<h1>Kristin Olson</h1><p>Kristin Olson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(64, 'Jeffrey', 'Beard', 'jeffreybeard', 'jeffrey.beard@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 64, NOW()), (0, 5, 64, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 64, '<h1>Jeffrey Beard</h1><p>Jeffrey Beard Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(65, 'Tracy', 'Abbott', 'tracyabbott', 'tracy.abbott@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 65, NOW()), (0, 5, 65, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 65, '<h1>Tracy Abbott</h1><p>Tracy Abbott Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(66, 'Steven', 'Miller', 'stevenmiller', 'steven.miller@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 66, NOW()), (0, 5, 66, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 66, '<h1>Steven Miller</h1><p>Steven Miller Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(67, 'Travis', 'Rhodes', 'travisrhodes', 'travis.rhodes@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 67, NOW()), (0, 5, 67, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 67, '<h1>Travis Rhodes</h1><p>Travis Rhodes Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(68, 'Miguel', 'Mccoy', 'miguelmccoy', 'miguel.mccoy@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 68, NOW()), (0, 5, 68, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 68, '<h1>Miguel Mccoy</h1><p>Miguel Mccoy Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(69, 'Eric', 'Kennedy', 'erickennedy', 'eric.kennedy@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 69, NOW()), (0, 5, 69, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 69, '<h1>Eric Kennedy</h1><p>Eric Kennedy Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(70, 'Kevin', 'Krause', 'kevinkrause', 'kevin.krause@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 70, NOW()), (0, 5, 70, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 70, '<h1>Kevin Krause</h1><p>Kevin Krause Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(71, 'Erin', 'Tran', 'erintran', 'erin.tran@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 71, NOW()), (0, 5, 71, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 71, '<h1>Erin Tran</h1><p>Erin Tran Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(72, 'Allison', 'Avila', 'allisonavila', 'allison.avila@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 72, NOW()), (0, 5, 72, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 72, '<h1>Allison Avila</h1><p>Allison Avila Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(73, 'Bradley', 'Beasley', 'bradleybeasley', 'bradley.beasley@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 73, NOW()), (0, 5, 73, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 73, '<h1>Bradley Beasley</h1><p>Bradley Beasley Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(74, 'Jennifer', 'Miller', 'jennifermiller', 'jennifer.miller@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 74, NOW()), (0, 5, 74, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 74, '<h1>Jennifer Miller</h1><p>Jennifer Miller Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(75, 'Dawn', 'Calderon', 'dawncalderon', 'dawn.calderon@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 75, NOW()), (0, 5, 75, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 75, '<h1>Dawn Calderon</h1><p>Dawn Calderon Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(76, 'Stephanie', 'Dillon', 'stephaniedillon', 'stephanie.dillon@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 76, NOW()), (0, 5, 76, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 76, '<h1>Stephanie Dillon</h1><p>Stephanie Dillon Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(77, 'Kristina', 'Morris', 'kristinamorris', 'kristina.morris@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 77, NOW()), (0, 5, 77, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 77, '<h1>Kristina Morris</h1><p>Kristina Morris Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(78, 'David', 'Perry', 'davidperry', 'david.perry@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 78, NOW()), (0, 5, 78, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 78, '<h1>David Perry</h1><p>David Perry Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(79, 'John', 'Lloyd', 'johnlloyd', 'john.lloyd@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 79, NOW()), (0, 5, 79, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 79, '<h1>John Lloyd</h1><p>John Lloyd Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(80, 'Chad', 'Thompson', 'chadthompson', 'chad.thompson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 80, NOW()), (0, 5, 80, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 80, '<h1>Chad Thompson</h1><p>Chad Thompson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(81, 'Heidi', 'Hall', 'heidihall', 'heidi.hall@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 81, NOW()), (0, 5, 81, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 81, '<h1>Heidi Hall</h1><p>Heidi Hall Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(82, 'Robert', 'Thomas', 'robertthomas', 'robert.thomas@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 82, NOW()), (0, 5, 82, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 82, '<h1>Robert Thomas</h1><p>Robert Thomas Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(83, 'Billy', 'Olson', 'billyolson', 'billy.olson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 83, NOW()), (0, 5, 83, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 83, '<h1>Billy Olson</h1><p>Billy Olson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(84, 'Martin', 'Wright', 'martinwright', 'martin.wright@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 84, NOW()), (0, 5, 84, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 84, '<h1>Martin Wright</h1><p>Martin Wright Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(85, 'Christopher', 'Randall', 'christopherrandall', 'christopher.randall@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 85, NOW()), (0, 5, 85, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 85, '<h1>Christopher Randall</h1><p>Christopher Randall Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(86, 'Karen', 'Wallace', 'karenwallace', 'karen.wallace@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 86, NOW()), (0, 5, 86, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 86, '<h1>Karen Wallace</h1><p>Karen Wallace Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(87, 'Joanna', 'Haynes', 'joannahaynes', 'joanna.haynes@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 87, NOW()), (0, 5, 87, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 87, '<h1>Joanna Haynes</h1><p>Joanna Haynes Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(88, 'Joshua', 'Blair', 'joshuablair', 'joshua.blair@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 88, NOW()), (0, 5, 88, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 88, '<h1>Joshua Blair</h1><p>Joshua Blair Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(89, 'Kelly', 'Collins', 'kellycollins', 'kelly.collins@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 89, NOW()), (0, 5, 89, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 89, '<h1>Kelly Collins</h1><p>Kelly Collins Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(90, 'Walter', 'Reyes', 'walterreyes', 'walter.reyes@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 90, NOW()), (0, 5, 90, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 90, '<h1>Walter Reyes</h1><p>Walter Reyes Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(91, 'Teresa', 'Ross', 'teresaross', 'teresa.ross@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 91, NOW()), (0, 5, 91, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 91, '<h1>Teresa Ross</h1><p>Teresa Ross Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(92, 'Alex', 'Sanders', 'alexsanders', 'alex.sanders@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 92, NOW()), (0, 5, 92, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 92, '<h1>Alex Sanders</h1><p>Alex Sanders Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(93, 'Kevin', 'Nguyen', 'kevinnguyen', 'kevin.nguyen@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 93, NOW()), (0, 5, 93, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 93, '<h1>Kevin Nguyen</h1><p>Kevin Nguyen Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(94, 'Kayla', 'Campbell', 'kaylacampbell', 'kayla.campbell@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 94, NOW()), (0, 5, 94, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 94, '<h1>Kayla Campbell</h1><p>Kayla Campbell Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(95, 'Terri', 'French', 'terrifrench', 'terri.french@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 95, NOW()), (0, 5, 95, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 95, '<h1>Terri French</h1><p>Terri French Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(96, 'Gloria', 'Kramer', 'gloriakramer', 'gloria.kramer@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 96, NOW()), (0, 5, 96, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 96, '<h1>Gloria Kramer</h1><p>Gloria Kramer Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(97, 'Hunter', 'Randolph', 'hunterrandolph', 'hunter.randolph@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 97, NOW()), (0, 5, 97, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 97, '<h1>Hunter Randolph</h1><p>Hunter Randolph Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(98, 'Michael', 'Bass', 'michaelbass', 'michael.bass@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 98, NOW()), (0, 5, 98, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 98, '<h1>Michael Bass</h1><p>Michael Bass Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(99, 'Daniel', 'Hudson', 'danielhudson', 'daniel.hudson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 99, NOW()), (0, 5, 99, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 99, '<h1>Daniel Hudson</h1><p>Daniel Hudson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(100, 'Kevin', 'Scott', 'kevinscott', 'kevin.scott@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 100, NOW()), (0, 5, 100, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 100, '<h1>Kevin Scott</h1><p>Kevin Scott Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(101, 'Lauren', 'Brown', 'laurenbrown', 'lauren.brown@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 101, NOW()), (0, 5, 101, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 101, '<h1>Lauren Brown</h1><p>Lauren Brown Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(102, 'Carrie', 'Cisneros', 'carriecisneros', 'carrie.cisneros@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 102, NOW()), (0, 5, 102, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 102, '<h1>Carrie Cisneros</h1><p>Carrie Cisneros Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(103, 'Michael', 'Brown', 'michaelbrown', 'michael.brown@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 103, NOW()), (0, 5, 103, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 103, '<h1>Michael Brown</h1><p>Michael Brown Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(104, 'Jennifer', 'Hunter', 'jenniferhunter', 'jennifer.hunter@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 104, NOW()), (0, 5, 104, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 104, '<h1>Jennifer Hunter</h1><p>Jennifer Hunter Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(105, 'Joel', 'Suarez', 'joelsuarez', 'joel.suarez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 105, NOW()), (0, 5, 105, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 105, '<h1>Joel Suarez</h1><p>Joel Suarez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(106, 'Ariel', 'Sullivan', 'arielsullivan', 'ariel.sullivan@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 106, NOW()), (0, 5, 106, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 106, '<h1>Ariel Sullivan</h1><p>Ariel Sullivan Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(107, 'Misty', 'Maldonado', 'mistymaldonado', 'misty.maldonado@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 107, NOW()), (0, 5, 107, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 107, '<h1>Misty Maldonado</h1><p>Misty Maldonado Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(108, 'Jenny', 'Ford', 'jennyford', 'jenny.ford@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 108, NOW()), (0, 5, 108, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 108, '<h1>Jenny Ford</h1><p>Jenny Ford Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(109, 'Brandon', 'Carroll', 'brandoncarroll', 'brandon.carroll@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 109, NOW()), (0, 5, 109, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 109, '<h1>Brandon Carroll</h1><p>Brandon Carroll Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(110, 'Jon', 'Davis', 'jondavis', 'jon.davis@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 110, NOW()), (0, 5, 110, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 110, '<h1>Jon Davis</h1><p>Jon Davis Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(111, 'Dawn', 'Goodman', 'dawngoodman', 'dawn.goodman@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 111, NOW()), (0, 5, 111, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 111, '<h1>Dawn Goodman</h1><p>Dawn Goodman Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(112, 'Bryan', 'Humphrey', 'bryanhumphrey', 'bryan.humphrey@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 112, NOW()), (0, 5, 112, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 112, '<h1>Bryan Humphrey</h1><p>Bryan Humphrey Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(113, 'Michael', 'Lynch', 'michaellynch', 'michael.lynch@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 113, NOW()), (0, 5, 113, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 113, '<h1>Michael Lynch</h1><p>Michael Lynch Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(114, 'Anna', 'Holland', 'annaholland', 'anna.holland@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 114, NOW()), (0, 5, 114, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 114, '<h1>Anna Holland</h1><p>Anna Holland Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(115, 'Richard', 'James', 'richardjames', 'richard.james@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 115, NOW()), (0, 5, 115, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 115, '<h1>Richard James</h1><p>Richard James Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(116, 'Michele', 'Griffin', 'michelegriffin', 'michele.griffin@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 116, NOW()), (0, 5, 116, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 116, '<h1>Michele Griffin</h1><p>Michele Griffin Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(117, 'Susan', 'Smith', 'susansmith', 'susan.smith@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 117, NOW()), (0, 5, 117, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 117, '<h1>Susan Smith</h1><p>Susan Smith Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(118, 'Michael', 'Griffin', 'michaelgriffin', 'michael.griffin@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 118, NOW()), (0, 5, 118, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 118, '<h1>Michael Griffin</h1><p>Michael Griffin Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(119, 'Leah', 'Hendrix', 'leahhendrix', 'leah.hendrix@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 119, NOW()), (0, 5, 119, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 119, '<h1>Leah Hendrix</h1><p>Leah Hendrix Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(120, 'Linda', 'Johnson', 'lindajohnson', 'linda.johnson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 120, NOW()), (0, 5, 120, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 120, '<h1>Linda Johnson</h1><p>Linda Johnson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(121, 'Holly', 'Steele', 'hollysteele', 'holly.steele@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 121, NOW()), (0, 5, 121, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 121, '<h1>Holly Steele</h1><p>Holly Steele Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(122, 'Jeffery', 'Sullivan', 'jefferysullivan', 'jeffery.sullivan@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 122, NOW()), (0, 5, 122, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 122, '<h1>Jeffery Sullivan</h1><p>Jeffery Sullivan Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(123, 'Lindsay', 'Williams', 'lindsaywilliams', 'lindsay.williams@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 123, NOW()), (0, 5, 123, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 123, '<h1>Lindsay Williams</h1><p>Lindsay Williams Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(124, 'Eric', 'Mejia', 'ericmejia', 'eric.mejia@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 124, NOW()), (0, 5, 124, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 124, '<h1>Eric Mejia</h1><p>Eric Mejia Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(125, 'Joshua', 'Ryan', 'joshuaryan', 'joshua.ryan@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 125, NOW()), (0, 5, 125, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 125, '<h1>Joshua Ryan</h1><p>Joshua Ryan Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(126, 'Kathryn', 'Bray', 'kathrynbray', 'kathryn.bray@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 126, NOW()), (0, 5, 126, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 126, '<h1>Kathryn Bray</h1><p>Kathryn Bray Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(127, 'Laurie', 'Guerra', 'laurieguerra', 'laurie.guerra@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 127, NOW()), (0, 5, 127, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 127, '<h1>Laurie Guerra</h1><p>Laurie Guerra Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(128, 'Philip', 'Le', 'philiple', 'philip.le@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 128, NOW()), (0, 5, 128, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 128, '<h1>Philip Le</h1><p>Philip Le Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(129, 'Daniel', 'Collins', 'danielcollins', 'daniel.collins@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 129, NOW()), (0, 5, 129, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 129, '<h1>Daniel Collins</h1><p>Daniel Collins Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(130, 'Henry', 'Cruz', 'henrycruz', 'henry.cruz@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 130, NOW()), (0, 5, 130, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 130, '<h1>Henry Cruz</h1><p>Henry Cruz Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(131, 'Michael', 'Carter', 'michaelcarter', 'michael.carter@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 131, NOW()), (0, 5, 131, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 131, '<h1>Michael Carter</h1><p>Michael Carter Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(132, 'Jeffrey', 'Black', 'jeffreyblack', 'jeffrey.black@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 132, NOW()), (0, 5, 132, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 132, '<h1>Jeffrey Black</h1><p>Jeffrey Black Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(133, 'Richard', 'Bauer', 'richardbauer', 'richard.bauer@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 133, NOW()), (0, 5, 133, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 133, '<h1>Richard Bauer</h1><p>Richard Bauer Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(134, 'Thomas', 'Jones', 'thomasjones', 'thomas.jones@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 134, NOW()), (0, 5, 134, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 134, '<h1>Thomas Jones</h1><p>Thomas Jones Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(135, 'John', 'James', 'johnjames', 'john.james@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 135, NOW()), (0, 5, 135, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 135, '<h1>John James</h1><p>John James Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(136, 'Maria', 'Beasley', 'mariabeasley', 'maria.beasley@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 136, NOW()), (0, 5, 136, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 136, '<h1>Maria Beasley</h1><p>Maria Beasley Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(137, 'Casey', 'Warren', 'caseywarren', 'casey.warren@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 137, NOW()), (0, 5, 137, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 137, '<h1>Casey Warren</h1><p>Casey Warren Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(138, 'Steven', 'Pineda', 'stevenpineda', 'steven.pineda@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 138, NOW()), (0, 5, 138, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 138, '<h1>Steven Pineda</h1><p>Steven Pineda Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(139, 'Traci', 'Gutierrez', 'tracigutierrez', 'traci.gutierrez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 139, NOW()), (0, 5, 139, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 139, '<h1>Traci Gutierrez</h1><p>Traci Gutierrez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(140, 'Greg', 'Fisher', 'gregfisher', 'greg.fisher@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 140, NOW()), (0, 5, 140, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 140, '<h1>Greg Fisher</h1><p>Greg Fisher Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(141, 'Sara', 'Hayes', 'sarahayes', 'sara.hayes@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 141, NOW()), (0, 5, 141, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 141, '<h1>Sara Hayes</h1><p>Sara Hayes Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(142, 'William', 'Anderson', 'williamanderson', 'william.anderson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 142, NOW()), (0, 5, 142, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 142, '<h1>William Anderson</h1><p>William Anderson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(143, 'Anna', 'Munoz', 'annamunoz', 'anna.munoz@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 143, NOW()), (0, 5, 143, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 143, '<h1>Anna Munoz</h1><p>Anna Munoz Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(144, 'Joseph', 'Carr', 'josephcarr', 'joseph.carr@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 144, NOW()), (0, 5, 144, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 144, '<h1>Joseph Carr</h1><p>Joseph Carr Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(145, 'James', 'Silva', 'jamessilva', 'james.silva@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 145, NOW()), (0, 5, 145, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 145, '<h1>James Silva</h1><p>James Silva Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(146, 'Jessica', 'Pope', 'jessicapope', 'jessica.pope@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 146, NOW()), (0, 5, 146, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 146, '<h1>Jessica Pope</h1><p>Jessica Pope Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(147, 'Samantha', 'Morales', 'samanthamorales', 'samantha.morales@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 147, NOW()), (0, 5, 147, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 147, '<h1>Samantha Morales</h1><p>Samantha Morales Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(148, 'Karen', 'Curtis', 'karencurtis', 'karen.curtis@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 148, NOW()), (0, 5, 148, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 148, '<h1>Karen Curtis</h1><p>Karen Curtis Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(149, 'Adrian', 'Carter', 'adriancarter', 'adrian.carter@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 149, NOW()), (0, 5, 149, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 149, '<h1>Adrian Carter</h1><p>Adrian Carter Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(150, 'Martha', 'Gardner', 'marthagardner', 'martha.gardner@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 150, NOW()), (0, 5, 150, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 150, '<h1>Martha Gardner</h1><p>Martha Gardner Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(151, 'Julie', 'Wilson', 'juliewilson', 'julie.wilson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 151, NOW()), (0, 5, 151, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 151, '<h1>Julie Wilson</h1><p>Julie Wilson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(152, 'Christopher', 'Gordon', 'christophergordon', 'christopher.gordon@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 152, NOW()), (0, 5, 152, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 152, '<h1>Christopher Gordon</h1><p>Christopher Gordon Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(153, 'Loretta', 'Johnson', 'lorettajohnson', 'loretta.johnson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 153, NOW()), (0, 5, 153, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 153, '<h1>Loretta Johnson</h1><p>Loretta Johnson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(154, 'Jacob', 'Rivera', 'jacobrivera', 'jacob.rivera@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 154, NOW()), (0, 5, 154, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 154, '<h1>Jacob Rivera</h1><p>Jacob Rivera Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(155, 'Brandon', 'Moore', 'brandonmoore', 'brandon.moore@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 155, NOW()), (0, 5, 155, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 155, '<h1>Brandon Moore</h1><p>Brandon Moore Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(156, 'William', 'Allen', 'williamallen', 'william.allen@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 156, NOW()), (0, 5, 156, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 156, '<h1>William Allen</h1><p>William Allen Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(157, 'Anthony', 'Walters', 'anthonywalters', 'anthony.walters@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 157, NOW()), (0, 5, 157, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 157, '<h1>Anthony Walters</h1><p>Anthony Walters Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(158, 'Teresa', 'Miller', 'teresamiller', 'teresa.miller@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 158, NOW()), (0, 5, 158, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 158, '<h1>Teresa Miller</h1><p>Teresa Miller Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(159, 'Shirley', 'Shaw', 'shirleyshaw', 'shirley.shaw@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 159, NOW()), (0, 5, 159, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 159, '<h1>Shirley Shaw</h1><p>Shirley Shaw Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(160, 'Christian', 'Choi', 'christianchoi', 'christian.choi@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 160, NOW()), (0, 5, 160, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 160, '<h1>Christian Choi</h1><p>Christian Choi Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(161, 'Courtney', 'Kennedy', 'courtneykennedy', 'courtney.kennedy@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 161, NOW()), (0, 5, 161, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 161, '<h1>Courtney Kennedy</h1><p>Courtney Kennedy Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(162, 'Edward', 'Moore', 'edwardmoore', 'edward.moore@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 162, NOW()), (0, 5, 162, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 162, '<h1>Edward Moore</h1><p>Edward Moore Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(163, 'Brianna', 'Wilson', 'briannawilson', 'brianna.wilson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 163, NOW()), (0, 5, 163, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 163, '<h1>Brianna Wilson</h1><p>Brianna Wilson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(164, 'Kayla', 'Rodriguez', 'kaylarodriguez', 'kayla.rodriguez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 164, NOW()), (0, 5, 164, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 164, '<h1>Kayla Rodriguez</h1><p>Kayla Rodriguez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(165, 'Theresa', 'Jackson', 'theresajackson', 'theresa.jackson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 165, NOW()), (0, 5, 165, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 165, '<h1>Theresa Jackson</h1><p>Theresa Jackson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(166, 'Joseph', 'Kirby', 'josephkirby', 'joseph.kirby@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 166, NOW()), (0, 5, 166, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 166, '<h1>Joseph Kirby</h1><p>Joseph Kirby Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(167, 'Sheryl', 'Harris', 'sherylharris', 'sheryl.harris@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 167, NOW()), (0, 5, 167, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 167, '<h1>Sheryl Harris</h1><p>Sheryl Harris Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(168, 'Ronald', 'Nguyen', 'ronaldnguyen', 'ronald.nguyen@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 168, NOW()), (0, 5, 168, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 168, '<h1>Ronald Nguyen</h1><p>Ronald Nguyen Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(169, 'William', 'Stone', 'williamstone', 'william.stone@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 169, NOW()), (0, 5, 169, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 169, '<h1>William Stone</h1><p>William Stone Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(170, 'Marissa', 'Moore', 'marissamoore', 'marissa.moore@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 170, NOW()), (0, 5, 170, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 170, '<h1>Marissa Moore</h1><p>Marissa Moore Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(171, 'Erin', 'Perez', 'erinperez', 'erin.perez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 171, NOW()), (0, 5, 171, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 171, '<h1>Erin Perez</h1><p>Erin Perez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(172, 'Andrew', 'Santos', 'andrewsantos', 'andrew.santos@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 172, NOW()), (0, 5, 172, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 172, '<h1>Andrew Santos</h1><p>Andrew Santos Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(173, 'Mark', 'Rivas', 'markrivas', 'mark.rivas@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 173, NOW()), (0, 5, 173, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 173, '<h1>Mark Rivas</h1><p>Mark Rivas Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(174, 'Wendy', 'Stewart', 'wendystewart', 'wendy.stewart@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 174, NOW()), (0, 5, 174, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 174, '<h1>Wendy Stewart</h1><p>Wendy Stewart Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(175, 'Cynthia', 'Jimenez', 'cynthiajimenez', 'cynthia.jimenez@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 175, NOW()), (0, 5, 175, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 175, '<h1>Cynthia Jimenez</h1><p>Cynthia Jimenez Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(176, 'Raymond', 'Burnett', 'raymondburnett', 'raymond.burnett@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 176, NOW()), (0, 5, 176, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 176, '<h1>Raymond Burnett</h1><p>Raymond Burnett Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(177, 'Christopher', 'Reed', 'christopherreed', 'christopher.reed@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 177, NOW()), (0, 5, 177, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 177, '<h1>Christopher Reed</h1><p>Christopher Reed Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(178, 'Christine', 'King', 'christineking', 'christine.king@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 178, NOW()), (0, 5, 178, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 178, '<h1>Christine King</h1><p>Christine King Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(179, 'Sarah', 'Peck', 'sarahpeck', 'sarah.peck@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 179, NOW()), (0, 5, 179, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 179, '<h1>Sarah Peck</h1><p>Sarah Peck Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(180, 'Christopher', 'Castro', 'christophercastro', 'christopher.castro@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 180, NOW()), (0, 5, 180, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 180, '<h1>Christopher Castro</h1><p>Christopher Castro Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(181, 'Jerry', 'Garcia', 'jerrygarcia', 'jerry.garcia@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 181, NOW()), (0, 5, 181, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 181, '<h1>Jerry Garcia</h1><p>Jerry Garcia Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(182, 'Nancy', 'Bush', 'nancybush', 'nancy.bush@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 182, NOW()), (0, 5, 182, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 182, '<h1>Nancy Bush</h1><p>Nancy Bush Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(183, 'Victoria', 'Graves', 'victoriagraves', 'victoria.graves@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 183, NOW()), (0, 5, 183, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 183, '<h1>Victoria Graves</h1><p>Victoria Graves Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(184, 'Tina', 'Adams', 'tinaadams', 'tina.adams@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 184, NOW()), (0, 5, 184, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 184, '<h1>Tina Adams</h1><p>Tina Adams Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(185, 'Rebecca', 'White', 'rebeccawhite', 'rebecca.white@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 185, NOW()), (0, 5, 185, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 185, '<h1>Rebecca White</h1><p>Rebecca White Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(186, 'Jonathan', 'Hill', 'jonathanhill', 'jonathan.hill@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 186, NOW()), (0, 5, 186, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 186, '<h1>Jonathan Hill</h1><p>Jonathan Hill Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(187, 'Thomas', 'Davis', 'thomasdavis', 'thomas.davis@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 187, NOW()), (0, 5, 187, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 187, '<h1>Thomas Davis</h1><p>Thomas Davis Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(188, 'Anthony', 'Rasmussen', 'anthonyrasmussen', 'anthony.rasmussen@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 188, NOW()), (0, 5, 188, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 188, '<h1>Anthony Rasmussen</h1><p>Anthony Rasmussen Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(189, 'Randy', 'Harris', 'randyharris', 'randy.harris@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 189, NOW()), (0, 5, 189, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 189, '<h1>Randy Harris</h1><p>Randy Harris Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(190, 'Michael', 'Kim', 'michaelkim', 'michael.kim@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 190, NOW()), (0, 5, 190, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 190, '<h1>Michael Kim</h1><p>Michael Kim Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(191, 'Jamie', 'Wright', 'jamiewright', 'jamie.wright@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 191, NOW()), (0, 5, 191, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 191, '<h1>Jamie Wright</h1><p>Jamie Wright Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(192, 'Jay', 'Ryan', 'jayryan', 'jay.ryan@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 192, NOW()), (0, 5, 192, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 192, '<h1>Jay Ryan</h1><p>Jay Ryan Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(193, 'Tammy', 'Knight', 'tammyknight', 'tammy.knight@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 193, NOW()), (0, 5, 193, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 193, '<h1>Tammy Knight</h1><p>Tammy Knight Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(194, 'James', 'Leonard', 'jamesleonard', 'james.leonard@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 194, NOW()), (0, 5, 194, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 194, '<h1>James Leonard</h1><p>James Leonard Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(195, 'Lisa', 'Joseph', 'lisajoseph', 'lisa.joseph@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 195, NOW()), (0, 5, 195, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 195, '<h1>Lisa Joseph</h1><p>Lisa Joseph Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(196, 'William', 'Hoover', 'williamhoover', 'william.hoover@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 196, NOW()), (0, 5, 196, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 196, '<h1>William Hoover</h1><p>William Hoover Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(197, 'Michael', 'Olson', 'michaelolson', 'michael.olson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 197, NOW()), (0, 5, 197, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 197, '<h1>Michael Olson</h1><p>Michael Olson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(198, 'Cassidy', 'Davis', 'cassidydavis', 'cassidy.davis@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 198, NOW()), (0, 5, 198, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 198, '<h1>Cassidy Davis</h1><p>Cassidy Davis Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(199, 'Alexis', 'Wells', 'alexiswells', 'alexis.wells@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 199, NOW()), (0, 5, 199, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 199, '<h1>Alexis Wells</h1><p>Alexis Wells Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(200, 'Wendy', 'Bennett', 'wendybennett', 'wendy.bennett@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 200, NOW()), (0, 5, 200, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 200, '<h1>Wendy Bennett</h1><p>Wendy Bennett Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(201, 'Jared', 'Thomas', 'jaredthomas', 'jared.thomas@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 201, NOW()), (0, 5, 201, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 201, '<h1>Jared Thomas</h1><p>Jared Thomas Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(202, 'Marie', 'Kelly', 'mariekelly', 'marie.kelly@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 202, NOW()), (0, 5, 202, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 202, '<h1>Marie Kelly</h1><p>Marie Kelly Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(203, 'Christopher', 'Silva', 'christophersilva', 'christopher.silva@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 203, NOW()), (0, 5, 203, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 203, '<h1>Christopher Silva</h1><p>Christopher Silva Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(204, 'Cindy', 'Henry', 'cindyhenry', 'cindy.henry@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 204, NOW()), (0, 5, 204, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 204, '<h1>Cindy Henry</h1><p>Cindy Henry Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(205, 'Thomas', 'Lambert', 'thomaslambert', 'thomas.lambert@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 205, NOW()), (0, 5, 205, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 205, '<h1>Thomas Lambert</h1><p>Thomas Lambert Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(206, 'Rickey', 'Jackson', 'rickeyjackson', 'rickey.jackson@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 206, NOW()), (0, 5, 206, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 206, '<h1>Rickey Jackson</h1><p>Rickey Jackson Biography</p>', NOW());

INSERT INTO `user` (id, first_name, last_name, username, email, password, profile_image, email_verified, created_at) VALUES(207, 'Christine', 'Jenkins', 'christinejenkins', 'christine.jenkins@ula.com','{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/teacher-icon.png', 1, NOW());
INSERT INTO `user_permission` (id, permission_id, user_id, created_at) VALUES (0, 2, 207, NOW()), (0, 5, 207, NOW());
INSERT INTO `teacher` (id, user_id, biography, created_at) VALUES (0, 207, '<h1>Christine Jenkins</h1><p>Christine Jenkins Biography</p>', NOW());

