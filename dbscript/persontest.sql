create database familydoctor;
use familydoctor;

create table Person(
	id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

select * from Person