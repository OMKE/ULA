INSERT INTO `permission`
VALUES (1,'2020-06-01 21:04:59',0,NULL,'ADMIN'),(2,'2020-06-01 21:04:59',0,NULL,'USER'),(3,'2020-06-01 21:04:59',0,NULL,'STAFF'),(4,'2020-06-01 21:04:59',0,NULL,'CONTENT_CREATOR'),(5,'2020-06-01 21:04:59',0,NULL,'TEACHER'),(6,'2020-06-01 21:04:59',0,NULL,'STUDENT');

INSERT INTO `user`
VALUES (1,'2020-06-01 21:04:59',0,NULL,'admin@admin.com',1,'Admin',NULL,'Adminovic','{bcrypt}$2y$12$8gfi0X7BiKp9LMG/ogyTC.FRg8e1nhbrD9wFZamTOy2YpgUVSjGju','users/admin-icon.png','admin'),(2,'2020-06-01 21:04:59',0,NULL,'omar@ula.com',1,'Omar',NULL,'Iriskic','{bcrypt}$2y$12$4oOoqP6FjZWmvzkpnhfmUePqTwAOt9i4CSRXSOGUVhEdFdgXOKSf2','users/omaririskic.png','omaririskic'), (3,'2020-06-01 21:04:59',0,NULL,'lazar@ula.com',1,'Lazar',NULL,'Filipovic','{bcrypt}$2y$12$bSbLJ9NTVw5E2BGpDPYrLuWRT64U7qpq23XcVeElW5iYZ.Z3DUNOO','users/lazarfilipovic.png','lazarfilipovic'),
    (4, NOW(), 0, NULL, 'eddiebaker@ula.com', 1, 'Eddie', NULL,'Baker', '{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/eddiebaker.png', 'eddiebaker');

INSERT INTO `user`
    (id, created_at, deleted, email, email_verified, first_name, ip_address, last_name, password, profile_image, username)
VALUES
       (5,NOW(), 0, 'henryjohnsons@ula.com', 1, 'Henry', NULL, 'Johnson', '{bcrypt}$2y$12$9TAsX4K0nEUT6F3TYbItpuZZYWbBPNNRui/N9/PNd4CFAN/oSF.LS', 'users/henryjohnson.png', 'henryjohnson'),
       (6,NOW(), 0, 'alishawatts@ula.com', 1, 'Alisha', NULL, 'Watts', '{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/alishawatts.png', 'alishawatts'),
       (7,NOW(), 0, 'klararichards@ula.com', 1, 'Klara', NULL, 'Richards', '{bcrypt}$2y$12$NCye0ld.9IeFjOqn6mM2aOiFz.KGU/8LrSm4CafzPn/xFsDfgjdYu', 'users/klararichards.png', 'klararichards');

# 1. admin - adding role ADMIN,
# 2. admin - adding role USER,
# 3. omaririskic - adding role USER,
# 4. lazarfilipovic - adding role USER,
# 5. lazarfilipovic - adding role STUDENT
# 6. eddiebaker - adding role USER
# 7. eddiebaker - adding role TEACHER
INSERT INTO `user_permission`
VALUES
       (1,'2020-06-01 21:04:59',0,NULL,1,1),
       (2,'2020-06-01 21:04:59', 0, NULL, 2, 1),
       (3,'2020-06-01 21:04:59', 0, NULL, 2, 2),
       (4,'2020-06-01 21:04:59', 0, NULL, 2, 3),
       (5,'2020-06-01 21:04:59', 0, NULL, 6, 3),
       (6, NOW(), 0, NULL, 2, 4),
       (7, NOW(), 0, NULL, 5, 4);


# id	created_at	deleted	updated_at	title
# 1	2020-06-01 21:04:59	0	NULL	ADMIN
# 2	2020-06-01 21:04:59	0	NULL	USER
# 3	2020-06-01 21:04:59	0	NULL	STAFF
# 4	2020-06-01 21:04:59	0	NULL	CONTENT_CREATOR
# 5	2020-06-01 21:04:59	0	NULL	TEACHER
# 6	2020-06-01 21:04:59	0	NULL	STUDENT

# 8. henryjohnson - adding role USER
# 9. henryjohnson - adding role CONTENT_CREATOR
# 10. alishawatts - adding role USER
# 11. alishawatts - adding role STAFF
# 12. klararichards - adding role USER
# 13. klararichards - adding role TEACHER
INSERT INTO `user_permission`
    (id, created_at, deleted, permission_id, user_id)
VALUES
       (8,NOW(), 0, 2, 5),
       (9,NOW(), 0, 4, 5),
       (10,NOW(), 0, 2, 6),
       (11,NOW(), 0, 3, 6),
       (12,NOW(), 0, 2, 7),
       (13,NOW(), 0, 5, 7);


INSERT INTO `administrator` (user_id, created_at)
VALUES (1, NOW());
INSERT INTO `student` (user_id, umcn, phone_number, date_of_birth,created_at)
VALUES (3, '2017270622', '123-456-789', '1998-01-01',NOW());

INSERT INTO `teacher` (created_at, deleted, biography, user_id) VALUES (NOW(), 0, '<h1>Edddie Baker<h1><p>Eddie Baker Biography</p>', 4);
INSERT INTO `teacher` (created_at, deleted, biography, user_id) VALUES (NOW(), 0, '<h1>Klara Richards<h1><p>Klara Richards Biography</p>', 7);

INSERT INTO `content_creator` (id, user_id) VALUES (0, 5);
