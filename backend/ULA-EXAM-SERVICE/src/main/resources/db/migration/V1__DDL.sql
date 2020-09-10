CREATE TABLE `taking_exam` (
       `id` bigint(20) not null auto_increment,
       `subject_attendance_id` bigint(20) not null ,
       `points` double default 0,
       `note` text null,
       `created_at` timestamp not null,
       `deleted` tinyint(1) default '0',
       `updated_at` timestamp null default null,
       primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `exam_type` (
     `id` bigint(20) not null auto_increment,
     `name` varchar(64) not null ,
     `created_at` timestamp not null,
     `deleted` tinyint(1) default '0',
     `updated_at` timestamp null default null,
     primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `exam_term` (
    `id` bigint(20) not null auto_increment,
    `name` varchar(128) not null ,
    `start_date` timestamp not null ,
    `end_date` timestamp not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `exam` (
    `id` bigint(20) not null auto_increment,
    `type_id` bigint(20) not null ,
    `taking_exam_id` bigint(20) not null ,
    `start_time` timestamp not null ,
    `end_time` timestamp not null ,
    `points` double not null ,
    `final_exam` tinyint(1) default 0,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`type_id`) references `exam_type` (`id`),
    foreign key (`taking_exam_id`) references `taking_exam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `exam_entry` (
      `id` bigint(20) not null auto_increment,
      `exam_term_id` bigint(20) not null ,
      `exam_id` bigint(20) not null ,
      `active` tinyint(1) default 0,
      `created_at` timestamp not null,
      `deleted` tinyint(1) default '0',
      `updated_at` timestamp null default null,
      primary key (`id`),
      foreign key (`exam_term_id`) references `exam_term` (`id`),
      foreign key (`exam_id`) references `exam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `exam_outcome` (
    `id` bigint(20) not null auto_increment,
    `description` text not null ,
    `exam_id` bigint(20) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`exam_id`) references `exam` (`id`)
);
