INSERT INTO Address (street, city, state, zipcode) VALUES ('101 S. Main', 'Fairfield', 'IA', '52556');
INSERT INTO Address (street, city, state, zipcode) VALUES ('51 S. George', 'Georgetown', 'MI', '65434');
INSERT INTO Address (street, city, state, zipcode) VALUES ('23 Headley Ave', 'Seville', 'Georgia', '41234');
INSERT INTO Address (street, city, state, zipcode) VALUES ('1 N. Baton', 'Baton Rouge', 'LA', '33556');
INSERT INTO Address (street, city, state, zipcode) VALUES ('5001 Venice Dr.', 'Los Angeles', 'CA', '93736');
INSERT INTO Address (street, city, state, zipcode) VALUES ('1435 Channing Ave', 'Palo Alto', 'CA', '94301');
INSERT INTO Address (street, city, state, zipcode) VALUES ('42 Dogwood Dr.', 'Fairfield', 'IA', '52556');
INSERT INTO Address (street, city, state, zipcode) VALUES ('501 Central', 'Mountain View', 'CA', '94707');


-- hash bcrypt
-- admin
-- patient 
-- toanqc 
-- markpit
-- kamaroy
-- longma
-- doctor
-- doctorkelly


INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('toanqc@gmail.com', '$2a$10$rNQqVynthlBeGumvLLGT5.LMK7CxihzmGj0mbP/8jxdeOk/f4mGqm', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values  ('makinnpit@gmail.com', '$2a$10$XwhFv1palydzwOx5kIf5JOAttlYd3pEE9Mm6wRlK5/16GdPL/cIMm', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('kamanashisroy@gmail.com', '$2a$10$lqL1k89HwPPTDfEAGDMd/uPtK6sgK7bWM.yGpvQah./T8ol7ySBMO', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('longmatime@gmail.com', '$2a$10$1y3rFUCLmjKxZAOmBxWGtutMHI8Uh2PHb7nIRlsJ7zFhZYmJov6aa', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values  ('patient@gmail.com', '$2a$10$69SNqZtbtBRSKqwiq8DvB.G7p5B4Yilj7pkq2VnRZ3fx3.TIUyYHG', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('doctor@gmail.com', '$2a$10$Da.0ppK8Ah65IKboW4m.Y.AoZrh/7qBK5E4c6LBg3kkJt1J8WBpKq', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('doctorkelly@gmail.com', '$2a$10$w3XR157wYnKy6m.sSm1nSObTSG3UfQz09siinsvAmi8vbixb3M8tG', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('admin@gmail.com', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

INSERT INTO Authority (EMAIL, AUTHORITY) values ('toanqc@gmail.com', 'ROLE_PATIENT');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('makinnpit@gmail.com', 'ROLE_PATIENT');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('kamanashisroy@gmail.com', 'ROLE_PATIENT');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('patient@gmail.com', 'ROLE_PATIENT');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('doctor@gmail.com', 'ROLE_DOCTOR');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('doctorkelly@gmail.com', 'ROLE_DOCTOR');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('admin@gmail.com', 'ROLE_ADMIN');


INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Toan', 'Quach', '2001-01-01', 'MALE', '1111', '111-111-1111', 1, 1);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Mark', 'Pit', '2002-02-02', 'MALE', '2222', '222-222-2222', 2, 2);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Kamanashis', 'Roy', '2003-03-03', 'MALE', '3333', '333-333-3333', 3, 3);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Long', 'Ma', '2004-04-04', 'MALE', '4444', '444-444-4444', 4, 4);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Patient', 'Rocker', '2005-05-05', 'FEMALE', '5555', '555-555-5555', 5, 5);

INSERT INTO Doctor(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, LICENSE_NUMBER, SPECIALIZATION, PHONE, ADDRESS_ID, USER_ID) VALUES ('John', 'Doctor', '2006-06-06', 'MALE', '6666', 'DENTIST', '666-666-6666', 6, 6);
INSERT INTO Doctor(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, LICENSE_NUMBER, SPECIALIZATION, PHONE, ADDRESS_ID, USER_ID) VALUES ('Kelly', 'Doctor', '2007-07-07', 'FEMALE', '7777', 'ENT', '777-777-7777', 7, 7);

INSERT INTO Admin(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, STAFF_NUMBER, PHONE, ADDRESS_ID, USER_ID) VALUES ('Admin', 'Super', '2008-08-08', 'MALE', '8888', '888-888-8888', 8, 8);

INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2015-08-13', '', '150', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2015-08-12', '', '250', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2015-08-11', '', '350', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2015-08-10', '', '450', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2015-08-09', '', '550', 'NEW');

INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2015-08-09', '2:00PM', 'I have toothache', '200', 'NEW', 1, 1, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2015-08-10', '2:00PM', 'Something in my ear', '300', 'NEW', 2, 2, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2015-08-16', '2:00PM', 'Need cleaning', '400', 'NEW', 1, 3, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2015-08-16', '2:00PM', 'Nose bleeding', '500', 'NEW', 2, 4, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2015-08-16', '2:00PM', 'May need tooth extraction', '600', 'NEW', 1, 5, 1);