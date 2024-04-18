create table tasks (
     id INT AUTO_INCREMENT PRIMARY KEY,
     description VARCHAR(50) NOT NULL,
     status varchar(50),
     date_of_create TIMESTAMP
);