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
