
CREATE TABLE `country` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `created_at` timestamp NOT NULL,
                           `deleted` tinyint(1) DEFAULT '0',
                           `updated_at` timestamp NULL DEFAULT NULL,
                           `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `city` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `created_at` timestamp NOT NULL,
                        `deleted` tinyint(1) DEFAULT '0',
                        `updated_at` timestamp NULL DEFAULT NULL,
                        `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                        `country_id` bigint(20) NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FKrpd7j1p7yxr784adkx4pyepba` (`country_id`),
                        CONSTRAINT `FKrpd7j1p7yxr784adkx4pyepba` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `address` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `created_at` timestamp NOT NULL,
                           `deleted` tinyint(1) DEFAULT '0',
                           `updated_at` timestamp NULL DEFAULT NULL,
                           `number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           `postal_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           `street_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           `city_id` bigint(20) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FKpo044ng5x4gynb291cv24vtea` (`city_id`),
                           CONSTRAINT `FKpo044ng5x4gynb291cv24vtea` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `university` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `created_at` timestamp NOT NULL,
                              `deleted` tinyint(1) DEFAULT '0',
                              `updated_at` timestamp NULL DEFAULT NULL,
                              `establishment_date` date NOT NULL,
                              `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                              `address_id` bigint(20) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKq9af0t50fvg0i0upumvgrig44` (`address_id`),
                              CONSTRAINT `FKq9af0t50fvg0i0upumvgrig44` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `university_information` (
  `id` bigint(20) not null auto_increment,
  `created_at` timestamp not null ,
  `deleted` tinyint(1) default '0',
  `updated_at` timestamp null default null,
  `about` text not null ,
  `history` text not null ,
  `president` text not null ,
  `teaching_staff` text not null ,
  `publishing` text not null ,
  `university_id` bigint(20) not null ,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`university_id`) references `university` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `phone_number` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `created_at` timestamp NOT NULL,
                                `deleted` tinyint(1) DEFAULT '0',
                                `updated_at` timestamp NULL DEFAULT NULL,
                                `contact_info` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                `number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                `university_id` bigint(20) DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FKb7y2y1ohup2ng503nkic56vuj` (`university_id`),
                                CONSTRAINT `FKb7y2y1ohup2ng503nkic56vuj` FOREIGN KEY (`university_id`) REFERENCES `university` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `gallery` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `created_at` timestamp NOT NULL,
                           `deleted` tinyint(1) DEFAULT '0',
                           `updated_at` timestamp NULL DEFAULT NULL,
                           `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `album` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `created_at` timestamp NOT NULL,
                         `deleted` tinyint(1) DEFAULT '0',
                         `updated_at` timestamp NULL DEFAULT NULL,
                         `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                         `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                         `gallery_id` bigint(20) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FKg8csxk1m714aagggilrk6t098` (`gallery_id`),
                         CONSTRAINT `FKg8csxk1m714aagggilrk6t098` FOREIGN KEY (`gallery_id`) REFERENCES `gallery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `image` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `created_at` timestamp NOT NULL,
                         `deleted` tinyint(1) DEFAULT '0',
                         `updated_at` timestamp NULL DEFAULT NULL,
                         `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                         `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
                         `path` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                         `album_id` bigint(20) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FKklgd5pxhpuh3nwik115myord` (`album_id`),
                         CONSTRAINT `FKklgd5pxhpuh3nwik115myord` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `location` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `latitude` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                            `longitude` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                            `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                            `created_at` timestamp NOT NULL,
                            `deleted` tinyint(1) DEFAULT '0',
                            `updated_at` timestamp NULL DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `campus` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `created_at` timestamp NOT NULL,
                          `deleted` tinyint(1) DEFAULT '0',
                          `updated_at` timestamp NULL DEFAULT NULL,
                          `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                          `location_id` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FKp8puwmyh7dmlmay3s43n0wmf` (`location_id`),
                          CONSTRAINT `FKp8puwmyh7dmlmay3s43n0wmf` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
