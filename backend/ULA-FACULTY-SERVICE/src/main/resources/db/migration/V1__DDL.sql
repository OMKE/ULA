
# university_id is referenced to ula_university database, table university
CREATE TABLE `faculty` (
    `id` bigint(20) not null auto_increment,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    `university_id` bigint(20) not null comment 'Database: ula_university; Table:university Column: id; No constraint',
    `campus_id` bigint(20) not null comment 'Database: ula_university; Table:campus Column: id; No constraint',
    `name` varchar(256) not null,
    `icon` varchar(256),
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `faculty_information` (
   `id` bigint(20) not null auto_increment,
   `created_at` timestamp not null,
   `deleted` tinyint(1) default '0',
   `updated_at` timestamp null default null,
   `faculty_id` bigint(20) not null ,
   `address_id` bigint(20) not null comment 'Database: ula_university; Table:address Column: id; No constraint',
   `location_id` bigint(20) not null comment 'Database: ula_university; Table:location Column: id; No constraint',
   `history` text not null,
   `president` text not null,
   `mission` text not null,
   `accreditation` text not null,
   `email` varchar(128) not null,
   `phone_number` varchar(64) not null,
   primary key (`id`),
   foreign key (`faculty_id`) references `faculty` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `study_program_location` (
    `id` bigint(20) not null auto_increment,
    `name` varchar(64) not null,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `study_program_degree` (
    `id` bigint(20) not null auto_increment,
    `level` varchar(64) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `study_program` (
   `id` bigint(20) not null auto_increment,
   `created_at` timestamp not null,
   `deleted` tinyint(1) default '0',
   `updated_at` timestamp null default null,
   `name` varchar(256) not null ,
   `description` text not null ,
   `faculty_id` bigint(20) not null ,
   `location_id` bigint(20) not null ,
   `degree_id` bigint(20) not null,
   primary key (`id`),
   foreign key (`faculty_id`) references `faculty` (`id`),
   foreign key (`location_id`) references `study_program_location` (`id`),
   foreign key (`degree_id`) references `study_program_degree` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `study_program_manager` (
    `id` bigint(20) not null auto_increment,
    `study_program_id` bigint(20) not null,
    `first_name` varchar(128) not null ,
    `last_name` varchar(128) not null ,
    `title` varchar(64) not null ,
    `phone_number` varchar(64) not null ,
    `email` varchar(128) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`study_program_id`) references `study_program` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;;


# TODO
# StudentOnYear will reference this table, and this table will reference StudentOnYear
# Student can be on two years at the same time because if he doesn't pass all subjects,
# If he's on third year and he got 2 subjects from second year, we will show him subjects that he didn't pass from previous year in current year
# ManyToMany Relationship, because there will be for example four years, and there are many students, some students will be on two year at the same time

CREATE TABLE `year_of_study` (
    `id` bigint(20) not null auto_increment,
    `year` datetime not null,
    `ordinal_number` int not null ,
    `study_program_id` bigint(20) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`study_program_id`) references `study_program` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `student_on_year` (
    `id` bigint(20) not null auto_increment,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    `student_id` bigint(20) not null,
    `transcript_identifier` varchar(64) not null unique ,
    `date_of_enrollment` timestamp not null default NOW(),
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `student_on_year_year_of_study` (
    `id` bigint(20) not null auto_increment,
    `student_on_year_id` bigint(20) not null ,
    `year_of_study_id` bigint(20) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`student_on_year_id`) references `student_on_year` (`id`),
    foreign key (`year_of_study_id`) references `year_of_study` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `subject` (
    `id` bigint(20) not null auto_increment,
    `year_of_study_id` bigint(20) not null,
    `name` varchar(128) not null,
    `semester` int not null ,
    `espb` int not null ,
    `required` bool default true,
    `number_of_lectures` int not null ,
    `number_of_practical_lectures` int not null ,
    `other_forms_of_lectures` int not null ,
    `research_works` int not null ,
    `other_lectures` int not null,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`year_of_study_id`) references `year_of_study` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `subject_syllabus` (
    `id` bigint(20) not null auto_increment,
    `subject_id` bigint(20) not null ,
    `content` text not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`subject_id`) references `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `subject_prerequisite` (
    `id` bigint(20) not null auto_increment,
    `subject_id` bigint(20) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `subject_and_subject_prerequisite` (
    `id` bigint(20) not null auto_increment,
    `subject_id` bigint not null ,
    `subject_prerequisite_id` bigint not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`subject_id`) references `subject` (`id`),
    foreign key (`subject_prerequisite_id`) references `subject_prerequisite` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `subject_realization` (
    `id` bigint(20) not null auto_increment,
    `subject_id` bigint(20) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`subject_id`) references `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `subject_notification_type` (
    `id` bigint(20) not null auto_increment,
    `name` varchar(32) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `subject_notification` (
    `id` bigint(20) not null auto_increment,
    `subject_realization_id` bigint(20) not null ,
    `type_id` bigint(20) not null ,
    `text` varchar(128) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`subject_realization_id`) references `subject_realization` (`id`),
    foreign key (`type_id`) references `subject_notification_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `subject_attendance`
(
    `id`                     bigint(20) not null auto_increment,
    `subject_realization_id` bigint(20) not null,
    `student_id` bigint(20) not null ,
    `final_grade`            int        null,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`subject_realization_id`) references `subject_realization` (`id`),
    foreign key (student_id) references `student_on_year` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `teacher_on_realization` (
    `id` bigint(20) not null auto_increment,
    `teacher_id` bigint(20) not null comment 'Database: ula_auth; Table:teacher Column: id, no constraint',
    `number_of_lectures` int not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `teacher_subject_realization` (
    `id` bigint(20) not null auto_increment,
    `teacher_on_realization_id` bigint(20) not null ,
    `subject_realization_id` bigint(20) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`teacher_on_realization_id`) references `teacher_on_realization` (`id`),
    foreign key (`subject_realization_id`) references `subject_realization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `educational_goal` (
    `id` bigint(20) not null auto_increment,
    `description` text not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `teaching_type` (
    `id` bigint(20) not null auto_increment,
    `name` varchar(32) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `teaching_term` (
    `id` bigint(20) not null auto_increment,
    `subject_realization_id` bigint(20) not null ,
    `type_id` bigint(20) not null,
    `start_time` timestamp not null ,
    `end_time` timestamp not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`subject_realization_id`) references `subject_realization` (`id`),
    foreign key (`type_id`) references `teaching_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `teaching_term_outcome` (
    `id` bigint(20) not null auto_increment,
    `teaching_term_id` bigint(20) not null ,
    `educational_goal_id` bigint(20) not null ,
    `description` text not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`teaching_term_id`) references `teaching_term` (`id`),
    foreign key (`educational_goal_id`) references `educational_goal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `teaching_material` (
    `id` bigint(20) not null auto_increment,
    `teaching_term_id` bigint(20) not null ,
    `name` varchar(128) not null ,
    `publication_date` date not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`teaching_term_id`) references `teaching_term` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `teaching_material_author` (
    `id` bigint(20) not null auto_increment,
    `teaching_material_id` bigint(20),
    `first_name` varchar(128) not null ,
    `last_name` varchar(128) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`teaching_material_id`) references `teaching_material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `file` (
    `id` bigint(20) not null auto_increment,
    `teaching_material_id` bigint(20) not null ,
    `path` varchar(256) not null ,
    `description` varchar(256) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`teaching_material_id`) references `teaching_material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
