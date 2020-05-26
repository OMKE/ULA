INSERT INTO permission (title, created_at) VALUES ('ADMIN', NOW());
INSERT INTO permission (title, created_at) VALUES ('USER', NOW());
INSERT INTO permission (title, created_at) VALUES ('STAFF', NOW());
INSERT INTO permission (title, created_at) VALUES ('CONTENT_CREATOR', NOW());
INSERT INTO permission (title, created_at) VALUES ('TEACHER', NOW());
INSERT INTO permission (title, created_at) VALUES ('STUDENT', NOW());


INSERT INTO user (username, password, email, first_name, last_name, profile_image, created_at, email_verified) VALUES ('admin', '{bcrypt}$2y$12$8gfi0X7BiKp9LMG/ogyTC.FRg8e1nhbrD9wFZamTOy2YpgUVSjGju', 'admin@admin.com', 'Admin', 'Adminovic', 'admin-icon.png', NOW(), true);

INSERT INTO user_permission (user_id, permission_id, created_at) VALUES (1, 1, NOW());

INSERT INTO administrator (created_at, user_id) VALUES(NOW(), 1);