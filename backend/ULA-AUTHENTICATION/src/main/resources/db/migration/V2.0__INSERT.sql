INSERT INTO `permission`
VALUES (1,'2020-06-01 21:04:59',0,NULL,'ADMIN'),(2,'2020-06-01 21:04:59',0,NULL,'USER'),(3,'2020-06-01 21:04:59',0,NULL,'STAFF'),(4,'2020-06-01 21:04:59',0,NULL,'CONTENT_CREATOR'),(5,'2020-06-01 21:04:59',0,NULL,'TEACHER'),(6,'2020-06-01 21:04:59',0,NULL,'STUDENT');

INSERT INTO `user`
VALUES (1,'2020-06-01 21:04:59',0,NULL,'admin@admin.com',1,'Admin',NULL,'Adminovic','{bcrypt}$2y$12$8gfi0X7BiKp9LMG/ogyTC.FRg8e1nhbrD9wFZamTOy2YpgUVSjGju','admin-icon.png','admin');

INSERT INTO `user_permission`
VALUES (1,'2020-06-01 21:04:59',0,NULL,1,1);

INSERT INTO `administrator` (user_id, created_at)
VALUES (1, NOW());
