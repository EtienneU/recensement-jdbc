CREATE TABLE ville (
	id 			INT 			NOT NULL AUTO_INCREMENT,
	nom 		VARCHAR (200)	NOT NULL,
	population 	INT 			NOT NULL,
	id_dep		INT 			NOT NULL,
	id_region	INT 			NOT NULL,

	PRIMARY KEY (id),
    FOREIGN KEY (id_dep) REFERENCES departement(id),
    FOREIGN KEY (id_region) REFERENCES region(id)
);

CREATE TABLE departement (
	id 			INT 			NOT NULL AUTO_INCREMENT,
	code 		VARCHAR (200)	NOT NULL,
	population 	INT 			NOT NULL,
	id_region	INT 			NOT NULL,

	PRIMARY KEY (id),
    FOREIGN KEY (id_region) REFERENCES region(id)
);

CREATE TABLE region (
	id 			INT 			NOT NULL AUTO_INCREMENT,
	code 		VARCHAR (200)	NOT NULL,
	population 	INT 			NOT NULL,

	PRIMARY KEY (id)
);
