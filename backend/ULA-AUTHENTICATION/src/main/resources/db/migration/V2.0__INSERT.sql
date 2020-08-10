INSERT INTO `permission`
VALUES (1,'2020-06-01 21:04:59',0,NULL,'ADMIN'),(2,'2020-06-01 21:04:59',0,NULL,'USER'),(3,'2020-06-01 21:04:59',0,NULL,'STAFF'),(4,'2020-06-01 21:04:59',0,NULL,'CONTENT_CREATOR'),(5,'2020-06-01 21:04:59',0,NULL,'TEACHER'),(6,'2020-06-01 21:04:59',0,NULL,'STUDENT');

INSERT INTO `user`
VALUES (1,'2020-06-01 21:04:59',0,NULL,'admin@admin.com',1,'Admin',NULL,'Adminovic','{bcrypt}$2y$12$8gfi0X7BiKp9LMG/ogyTC.FRg8e1nhbrD9wFZamTOy2YpgUVSjGju','admin-icon.png','admin'),(2,'2020-06-01 21:04:59',0,NULL,'omar@ula.com',1,'Omar',NULL,'Iriskic','{bcrypt}$2y$12$4oOoqP6FjZWmvzkpnhfmUePqTwAOt9i4CSRXSOGUVhEdFdgXOKSf2','omaririskic.png','omaririskic'), (3,'2020-06-01 21:04:59',0,NULL,'lazar@ula.com',1,'Lazar',NULL,'Filipovic','{bcrypt}$2y$12$bSbLJ9NTVw5E2BGpDPYrLuWRT64U7qpq23XcVeElW5iYZ.Z3DUNOO','lazarfilipovic.png','lazarfilipovic');


# 1. admin - adding role ADMIN,
# 2. admin - adding role USER,
# 3. omaririskic - adding role USER,
# 4. lazarfilipovic - adding role USER,
# 5. lazarfilipovic - adding role STUDENT
INSERT INTO `user_permission`
VALUES
       (1,'2020-06-01 21:04:59',0,NULL,1,1),
       (2,'2020-06-01 21:04:59', 0, NULL, 2, 1),
       (3,'2020-06-01 21:04:59', 0, NULL, 2, 2),
       (4,'2020-06-01 21:04:59', 0, NULL, 2, 3),
       (5,'2020-06-01 21:04:59', 0, NULL, 6, 3);

INSERT INTO `administrator` (user_id, created_at)
VALUES (1, NOW());
INSERT INTO `student` (user_id, umcn, phone_number, date_of_birth,created_at)
VALUES (3, '2017270622', '123-456-789', '1998-01-01',NOW());
