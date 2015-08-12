Family doctor
==============

The purpose of the project is to understand the web application architecture. Here we used spring framework, as we learnt it in the theoratical study. This website helps the patient to communicate with the hospital to create an appointment. Doctors can accept the appointment. And patients can view the prescriptions and history. As it is only demonstration, it is not fully featured website for patient. 

Site Goals
===========

Revision history
=================


Table of contents
==================

Introduction
=============

Purpose
========

Usage scenarios
===============

The site has three kinds of users. 

- Patient
- Doctor
- Administrator

The administrator creates doctor. The patient registers in the site and creates appointment. And doctors agrees upon the appointment. Afterwards the patient can see appointment history and prescriptions.

character | description | task 
----------|:------------|:---------------------
Patient | The patient is the client of the hospital. He needs therapy for his or her illness. And he wants to see a doctor. He needs an appointment to do that. | He registers in the hospital and creates appointments.
Doctor | Doctor gives the patient the therapy for illness. He has specialization for some illness. | Doctor confirms registration and he updates the appointments.
Administrator | He is the hospital administrator | He creates new doctor accounts and updates the site.

#### Patient registraion

![patient registration](diagrams/patient_registration.svg)

The patient/user clicks on the Register link on the home page and is directed to the Patient Registration page where they need to fill the patient information. They need to input their firstname, lastname, street address, city, state, zipcode, phone number, date of birth, Social Security Number, email address and password.
After successful registration, they are directed to the Patient dashboard.

#### Registration of doctor by admin

![doctor registration](diagrams/doctor_registration.svg)

The master admin user will login and clicks on the Add Doctor link which will load the Doctor Registration page.  The Admin fills in the Doctor firstname, lastname, street address, phone, email address, license number, specialization, Social Security Number and a temporary password.  
The doctor is notified via email with his username and password. The doctor will login, enters his username and password in the login page.  After successful login, the doctor is directed to the doctor dashboard.  The doctor then clicks on Account link and is directed to the Account page where the doctor can change his email address and/or password.  

#### Patient appointment

![patient asks for appointment](diagrams/patient_appointment.svg)

A patient can request an appointment with a specific doctor.  The patient needs to login and proceeds to the patient dashboard where there is a link to create an appointment.  
In the appointment page, the patient needs to fill the form and enter the illness, date the illness started, date and time of appointment request.  The system will check for available date and time of the doctor selected.  The doctors are available from 9AM – 12PM and 2PM – 5PM Monday to Saturday.  If no doctor is selected, the system will assign a doctor who is available on the given date. The appointment for also needs to get the Credit Card information from the user.  This is to ensure the user is serious about the appointment.  

#### Doctor updates appointment

![doctor updates the appointment](diagrams/doctor_updates_appointment.svg)

The doctor will login and proceeds to the dashboard where a list of appointments (sorted by date, most recent first) with the status (Pending, Completed).  The doctor clicks on an appointment link and will then shown the appointment page.  In the appointment page the doctor can enter comments or prescriptions and change the status to Completed. When an appointment status is changed to Completed, an automatic payment is created by the system using the patient credit card details.  A payment notification is then sent to the patient email address.

High level design
=================

The project contains a domain model. It has presentation tier, business tier and persistant tier. In the diagram below the components for each tier is demonstrated.

![components](https://cloud.githubusercontent.com/assets/973414/9238426/c3786380-4117-11e5-9e9b-ebd6f519a207.jpg)

The domain are saved by JPA and they are handled as entity. The service components wraps the business logic. And the controller is used to maintain the interface workflow. 

The domain contains the following entities.

class | description
------|:-----------
Authority | This class along with User helps user login and role based security control.
Admin | It contains the site administrator information.
User | It contains the login information.
Patient | It keeps the patient information.
Doctor | It keeps the doctor information.
Appointment | It contains appointment room,time,date and status.
Invoice | It contains invoice date,amount and status.
Address | It contains address.



Detail design
==============

#### Class diagram
The class diagram below shows the domain model.

![class diagram](diagrams/classdiagram.svg)

class | description
------|:-----------
Authority | *Authority* is contained by User. The spring security module uses authority role for managing access to the pages and services.
Admin | It is subclass of *Person*. It is the specialization to contain admisnitration related staff. As it has *is a* relationship with *Person*, the super class contains all the address and identification fields. It creates *Doctor* instance.
User | It contains the login information. It contains the *Authority*.
Patient | It keeps the patient information. Again it has *is a* relationship with *Person*. It contains all the appointments. It creates appointments. It can also pay for appointments.
Doctor | It keeps the doctor information. And it has *is a* relationship with *Person*. It contains related appointments. It approves the invoice.
Appointment | It contains appointment room,time,date and status. It is contained by both *Patient* and *Doctor*. It creates the invoice.
Invoice | It contains invoice date,amount and status. It can be payed by the *Patient*.
Address | It contains streat,city and zipcode. It can be contained by *Person*.
Person | It is the generalization of *Doctor*,*Patient* and *Admin*. It contains identification and communication information. It contains *Address*.


#### Interaction Diagram

The scenario below shows the appointment creation ..

 TODO fill me

