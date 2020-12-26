INSERT INTO t_city(id,name) VALUES (1,'Ankara');
INSERT INTO t_city(id,name) VALUES (2,'İstanbul');
INSERT INTO t_city(id,name) VALUES (3,'İzmir');

INSERT INTO t_clinic(id,name) VALUES (1,'Harezmi Pet Clinic');

INSERT INTO t_pet_type (id,name) VALUES (1,  'kedi');
INSERT INTO t_pet_type (id,name) VALUES (2,  'kopek');
INSERT INTO t_pet_type (id,name) VALUES (3,  'balik');
INSERT INTO t_pet_type (id,name) VALUES (4,  'yilan');
INSERT INTO t_pet_type (id,name) VALUES (5,  'kus');
INSERT INTO t_pet_type (id,name) VALUES (6,  'kaplumbaga');
INSERT INTO t_pet_type (id,name) VALUES (7,  'at');
INSERT INTO t_pet_type (id,name) VALUES (8,  'koyun');
INSERT INTO t_pet_type (id,name) VALUES (9,  'timsah');
INSERT INTO t_pet_type (id,name) VALUES (10,  'tavuk');

INSERT INTO t_specialty (id,name) VALUES (1,  'radyoloji');
INSERT INTO t_specialty (id,name) VALUES (2,  'cerrahi');
INSERT INTO t_specialty (id,name) VALUES (3,  'discilik');
INSERT INTO t_specialty (id,name) VALUES (4,  'anestezi');
INSERT INTO t_specialty (id,name) VALUES (5,  'dogum');

INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('V',1,  'Jale', 'Cengiz',100,1);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('V',2,  'Hale', 'Lale',100,1);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('V',3,  'Leyla', 'Denge',100,1);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('V',4,  'Rafi', 'Orta',100,1);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('V',5,  'Hasan', 'Sari',100,1);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('V',6,  'Sedat', 'Kuzu',100,1);

INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',7,  'Baha', 'Koc',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',8,  'Besir', 'Dal',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',9,  'Elif', 'Koc',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',10,  'Selim', 'Duru',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',11,  'Pinar', 'Mus',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',12,  'Moon', 'Su',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',13,  'Asli', 'Zor',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',14,  'Murat', 'Eski',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',15,  'Davut', 'Saz',200,0);
INSERT INTO t_person (person_type,id,first_name,last_name,rating,works_full_time) VALUES ('O',16,  'Kadir', 'Mutlu',200,0);







INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (7, 1, '1. Sokak Kecioren', '5325551023','HOME');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (8, 1, '2. Sokak Cankaya', '5325551749','HOME');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (9, 1, '3. Sokak Cankaya', '5555558763','WORK');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (10, 2, '4. Sokak Acibadem', '5335553198','HOME');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (11, 2, '5. Sokak Kartal', '5445552765','WORK');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (12, 2, '6. Sokak Beyoglu', '5055552654','WORK');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (13, 2, '7. Sokak Sariyer', '5555555387','WORK');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (14, 3,'8. Sokak Konak', '5425557683','HOME');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (15, 3, '9. Sokak Altinordu', '5325559435','HOME');
INSERT INTO t_address (owner_id,city_id,street,phone,phone_type) VALUES (16, 3, '10. Sokak Karsiyaka', '5335555487','WORK');

INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (1, 1);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (1, 2);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (1, 3);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (2, 1);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (2, 2);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (3, 2);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (4, 3);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (5, 2);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (5, 3);
INSERT INTO t_vet_specialty (vet_id,specialty_id) VALUES (5, 4);

INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (1,  'Pitir', '2005-09-07', 1, 7);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (2,  'Mars', '2008-08-06', 6, 8);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (3,  'Karabas', '2001-04-17', 2, 9);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (4,  'Joe', '2009-03-07', 2, 9);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (5,  'Canavar', '2010-11-30', 3, 10);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (6,  'Tatlim', '2010-01-20', 4, 11);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (7,  'Samanta', '2008-09-04', 1, 12);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (8,  'Boncuk', '2008-09-04', 1, 12);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (9,  'Sansli', '2007-08-06', 5, 13);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (10,  'Karaburun', '2009-02-24', 2, 13);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (11,  'Twetty', '2000-03-09', 5, 15);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (12,  'Tarcin', '2000-06-24', 2, 16);
INSERT INTO t_pet (id,pet_name,birth_date,type_id,owner_id) VALUES (13,  'Sari', '2002-06-08', 1, 16);

INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (1,  7, 0, '2013-03-04', 'yaralanma');
INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (2,  7, 1, '2011-03-04', 'hastalik');
INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (3,  8, 0, '2010-06-04', 'kontrol');
INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (4,  8, 1, '2012-09-04', 'kisirlastirma');
INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (5,  8, 2, '2013-10-14', 'asi');
INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (6,  8, 3, '2014-11-04', 'kontrol');
INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (7,  9, 0, '2015-11-22', 'yaralanma');
INSERT INTO t_visit (id,pet_id,visit_order,visit_date,visit_description) VALUES (8,  10, 0, '2015-11-22', 'yaralanma');


