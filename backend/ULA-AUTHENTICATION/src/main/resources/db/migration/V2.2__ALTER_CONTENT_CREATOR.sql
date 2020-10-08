ALTER TABLE `content_creator`
ADD COLUMN `created_at` timestamp NOT NULL AFTER user_id,
ADD COLUMN `deleted` tinyint(1) DEFAULT '0' AFTER created_at,
ADD COLUMN `updated_at` timestamp NULL DEFAULT NULL AFTER deleted;
