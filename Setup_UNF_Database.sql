CREATE TABLE STUDENT (
Fname varchar(30) NOT NULL,
Lname varchar(30) NOT NULL,
Mid_initial char(1),
Ssn char(11) NOT NULL,
Bdate date NOT NULL,
Sex char(1) NOT NULL,
Class varchar(15),
Degree varchar(20),
Nnumber char(9) NOT NULL,
C_phone char(12),
C_address varchar(94),
P_phone char(12),
P_st_address varchar(45),
P_city varchar(30),
P_state char(2),
P_zip_code char(5),
PRIMARY KEY (Nnumber));

CREATE TABLE DEPARTMENT(
Department_name varchar(45) UNIQUE NOT NULL,
Code varchar(4) NOT NULL,
Office_num NUMERIC(4),
College varchar(45),
Office_phone char(12),
PRIMARY KEY (CODE));

CREATE TABLE CHOOSES_MAJOR (
Nnumber char(9) NOT NULL,
Code varchar(4) NOT NULL,
PRIMARY KEY (Nnumber, Code),
FOREIGN KEY (Nnumber) REFERENCES STUDENT (Nnumber) ON DELETE CASCADE,
FOREIGN KEY (Code) REFERENCES DEPARTMENT (Code) ON DELETE CASCADE);

CREATE TABLE CHOOSES_MINOR (
Nnumber char(9) NOT NULL,
Code varchar(4) NOT NULL,
PRIMARY KEY (Nnumber, Code),
FOREIGN KEY (Nnumber) REFERENCES STUDENT (Nnumber) ON DELETE CASCADE,
FOREIGN KEY (Code) REFERENCES DEPARTMENT (Code) ON DELETE CASCADE);

CREATE TABLE COURSE (
Grade_level varchar(20),
Description varchar(100),
Course_name varchar(45),
Course_num varchar(7) NOT NULL,
Sem_hours NUMERIC(1),
Code varchar(4) NOT NULL,
PRIMARY KEY (Course_num),
FOREIGN KEY (Code) REFERENCES DEPARTMENT (Code) ON DELETE CASCADE);

CREATE TABLE SECTION (
Course_num varchar(7) NOT NULL,
Year NUMERIC(4) NOT NULL,
Semester varchar(7) NOT NULL,
Instructor varchar(45),
Section_num NUMERIC(1) NOT NULL,
CONSTRAINT Semester_chk CHECK (Semester IN ('fall', 'summer', 'spring')),
PRIMARY KEY(Course_num, Year, Section_num, Semester),
FOREIGN KEY (Course_num) REFERENCES COURSE (Course_num) ON DELETE CASCADE);

CREATE TABLE GRADES_FOR (
Grade_letter varchar(2),
Grade_num NUMERIC(5,2),
Course_num varchar(7) NOT NULL,
Year NUMERIC(4) NOT NULL,
Semester varchar(7) NOT NULL,
Nnumber char(9) NOT NULL,
Section_num NUMERIC(5) NOT NULL,
CONSTRAINT Sem_chk CHECK (Semester IN ('fall', 'summer', 'spring')),
PRIMARY KEY (Course_num, Year, Semester, Nnumber, Section_num),
FOREIGN KEY (Nnumber) REFERENCES STUDENT (Nnumber) ON DELETE CASCADE,
FOREIGN KEY (Course_num, Year, Semester, Section_num) REFERENCES SECTION (Course_num, Year, Semester, Section_num) ON DELETE CASCADE); 
