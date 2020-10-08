CREATE TABLE `research` (
    `id` bigint(20) not null auto_increment,
    `title` varchar(128) not null ,
    `content` text not null ,
    `thumbnail` varchar(256) not null ,
    `publication_date` date not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `author` (
    `id` bigint(20) not null auto_increment,
    `research_id` bigint(20),
    `first_name` varchar(64) not null ,
    `last_name` varchar(64) not null ,
    `created_at` timestamp not null,
    `deleted` tinyint(1) default '0',
    `updated_at` timestamp null default null,
    primary key (`id`),
    foreign key (`research_id`) references `research` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


