INSERT INTO `location` (id, latitude, longitude,name) VALUES (1, '34.019714', '-118.274852', 'Main Location');
INSERT INTO `location` (id, latitude, longitude,name) VALUES (2, '34.023841', '-118.286074', 'Second Location');
INSERT INTO `location` (id, latitude, longitude,name) VALUES (3, '34.021242', '-118.287217', 'Third Location');


INSERT INTO `country` (id, name, created_at) VALUES (1, 'USA', NOW());

INSERT INTO `city` (id, name, country_id, created_at) VALUES (1,'Los Angeles', 1, NOW());

INSERT INTO `address` (id, street_name, number, postal_code, city_id, created_at) VALUES (1, 'Watt Way', '1234', '90089', 1, NOW());
INSERT INTO `address` (id, street_name, number, postal_code, city_id, created_at) VALUES (2, 'West 34th Street', '925', '90007', 1, NOW());
INSERT INTO `address` (id, street_name, number, postal_code, city_id, created_at) VALUES (3, 'South Hill Street', '3320', '90007', 1, NOW());
INSERT INTO `address` (id, street_name, number, postal_code, city_id, created_at) VALUES (4, 'Red Maple Drive', '3839', '90017', 1, NOW());
INSERT INTO `address` (id, street_name, number, postal_code, city_id, created_at) VALUES (5, 'Canis Heights Drive', '3514', '90089', 1, NOW());



INSERT INTO `university` (id, name, establishment_date, address_id, created_at) VALUES (1,'University of Los Angeles', '2020-05-05', 1, NOW());

INSERT INTO `phone_number` (id, contact_info, number, university_id, created_at) VALUES (1, 'ULA - Main Management Office', '202-555-0149', 1, NOW());
INSERT INTO `phone_number` (id, contact_info, number, university_id, created_at) VALUES (2, 'ULA - Management Office Downtown', '202-555-0150', 1, NOW());
INSERT INTO `phone_number` (id, contact_info, number, university_id, created_at) VALUES (3, 'ULA - Management Office Uptown', '202-555-0151', 1, NOW());


INSERT INTO `campus` (id, name, location_id, created_at) VALUES (1, 'Main Campus', 1, NOW());
INSERT INTO `campus` (id, name, location_id, created_at) VALUES (2, 'West Campus', 2, NOW());
INSERT INTO `campus` (id, name, location_id, created_at) VALUES (3, 'South Campus', 3, NOW());
