CREATE TABLE physicalbooks ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, title VARCHAR(30) NOT NULL, author VARCHAR(30) NOT NULL, pageNumber INT(6), genre VARCHAR(30), publicationYear INT(6), userRating DOUBLE(5,2), nrRatings INT(6), stock INT(6), coverType VARCHAR(30), isNew boolean);
CREATE TABLE digitalbooks ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, title VARCHAR(30) NOT NULL, author VARCHAR(30) NOT NULL, pageNumber INT(6), genre VARCHAR(30), publicationYear INT(6), userRating DOUBLE(5,2), nrRatings INT(6), stock INT(6), format VARCHAR(30), freeTrial boolean);
CREATE TABLE persons ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, username VARCHAR(30) NOT NULL, password VARCHAR(30) NOT NULL, email VARCHAR(30) NOT NULL, firstName VARCHAR(30), lastName VARCHAR(30), deliveryAddress VARCHAR(30), phoneNumber VARCHAR(30), id_company INT(6) UNSIGNED, FOREIGN KEY(id_company) references companies(id) on delete cascade);
CREATE TABLE pickuppoints ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, city VARCHAR(30) NOT NULL, address VARCHAR(30) NOT NULL, openedOnWeekends boolean);
CREATE TABLE borrowings ( id_user INT, id_book INT, PRIMARY KEY (id_user, id_book), starting_date DATE, ending_date DATE);
CREATE TABLE companies (id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, username VARCHAR(30), password VARCHAR(30), email VARCHAR(30), companyName VARCHAR(30), location VARCHAR(30));

select * from companies;
select * from persons;
select * from physicalbooks;
select * from digitalbooks;
select * from borrowings;
select * from pickuppoints;

delete from physicalbooks where pageNumber = 500;