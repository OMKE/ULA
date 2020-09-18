INSERT INTO exam_type
(id, name, created_at) VALUES
(0, 'Quiz', NOW()), (0, 'Essay', NOW()), (0, 'Oral', NOW()), (0, 'Practical', NOW());


INSERT INTO exam_term
    (id, name, start_date, end_date, created_at) VALUES
(0, "January", "2020-01-20T08:00", "2020-02-01T16:00", NOW()),
(0, "February", "2020-02-03T08:00", "2020-02-14T16:00", NOW()),
(0, "June", "2020-06-22T08:00", "2020-07-05T16:00", NOW()),
(0, "July", "2020-07-06T08:00", "2020-07-19T16:00", NOW()),
(0, "September 1", "2020-08-31T08:00", "2020-09-13T16:00", NOW()),
(0, "September 2", "2020-09-14T08:00", "2020-09-27T16:00", NOW()),
(0, "October 1", "2020-10-01T08:00", "2020-10-15T16:00", NOW()),
(0, "October 2", "2020-10-16T08:00", "2020-10-31T16:00", NOW());

INSERT INTO taking_exam
    (id, subject_attendance_id, points, note, created_at) VALUES
    (0, 1, 0, "Subject: Advanced Methods in Metal forming", NOW()),
    (0, 2, 0, "Subject: CAD CAE CAM and CIM Systems", NOW()),
    (0, 3, 0, "Subject: Casting Technology", NOW()),
    (0, 4, 0, "Subject: Computer Aided Design of Tools and Dies for Metal Forming", NOW()),
    (0, 5, 0, "Subject: Contemporary Casting Technologies", NOW()),
    (0, 6, 0, "Subject: Contemporary Materials", NOW()),
    (0, 7, 0, "Subject: Cutting tools", NOW()),
    (0, 8, 0, "Subject: Fixtures", NOW());
