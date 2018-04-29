INSERT INTO room(id, name) VALUES(1, 'Rose');
INSERT INTO room(id, name) VALUES(2, 'Camellia');

INSERT INTO doctor(id, name) VALUES(1, 'Dr. Prof. Rauf Tim');
INSERT INTO doctor(id, name) VALUES(2, 'Dr. Prof. Hanse Braown');
INSERT INTO doctor(id, name) VALUES(3, 'Dr. Ulrike Li');
INSERT INTO doctor(id, name) VALUES(4, 'Dr. Tim Kual');

INSERT INTO patient(id, name, sex, dob, doctor_id, room_id) VALUES(1, 'Tom Karl',1,'1986-02-13', 2, 1);
INSERT INTO patient(id, name, sex, dob, doctor_id, room_id) VALUES(2, 'Alex blue',3,'1976-05-23', 4, 2);

INSERT INTO study(id, patient_id, description, status, planned_start_time, estimated_end_time) VALUES(1, 1, 'Example desc',1,'2018-04-26 10:30:00', '2018-04-27 15:30:00');
INSERT INTO study(id, patient_id, description, status, planned_start_time, estimated_end_time) VALUES(2, 1, 'Example desc1',2,'2018-04-27 09:30:00', '2018-04-27 13:30:00');
INSERT INTO study(id, patient_id, description, status, planned_start_time, estimated_end_time) VALUES(3, 2, 'Example desc2',1,'2018-04-26 13:30:00', '2018-04-27 16:30:00');
INSERT INTO study(id, patient_id, description, status, planned_start_time, estimated_end_time) VALUES(4, 2, 'Example desc3',2,'2018-04-27 09:30:00', '2018-04-27 15:30:00');


