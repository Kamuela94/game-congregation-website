Drop table Boat_Details cascade constraints;
Drop table Booking_Details cascade constraints;
Drop table Boating_Types cascade constraints;
Drop table Boating_Locations cascade constraints;

drop sequence hibernate_sequence;
create sequence hibernate_sequence start with 1010 increment by 1;

CREATE TABLE Boating_Locations(
	location VARCHAR2(25),
	CONSTRAINT pk_boating_locations_location PRIMARY KEY(location)
);

CREATE TABLE Boating_Types(
	boatingType VARCHAR2(1),
	description VARCHAR2(50) NOT NULL,
	CONSTRAINT pk_boating_types_boatingType PRIMARY KEY(boatingType)
);

CREATE TABLE Boat_Details(
    boatId   VARCHAR2(5),
    boatingType VARCHAR2(1) NOT NULL,
    location VARCHAR2(25) NOT NULL,
    cost NUMBER(8,2) NOT NULL,
    CONSTRAINT pk_boat_details_boatId PRIMARY KEY(boatId),
    CONSTRAINT fk_boat_details_boatingType FOREIGN KEY(boatingType) REFERENCES Boating_Types(boatingType) ON DELETE CASCADE,
    CONSTRAINT fk_boat_details_location FOREIGN KEY(location) REFERENCES Boating_Locations(location) ON DELETE CASCADE,
    CONSTRAINT chk_boat_details_cost CHECK (cost > 0.0)
 );


CREATE TABLE Booking_Details(
  	bookingId NUMBER(10), 
  	boatId VARCHAR2(5) NOT NULL, 
  	dateOfRide DATE NOT NULL,
  	noOfPeople NUMBER(2) NOT NULL,
  	contactNo NUMBER(10) NOT NULL,
  	bookingStatus VARCHAR2(2) DEFAULT 'PN' NOT NULL,
    CONSTRAINT pk_booking_details_bookingId PRIMARY KEY(bookingId),
    CONSTRAINT fk_booking_details_boatingType FOREIGN KEY(boatId) REFERENCES Boat_Details(boatId) ON DELETE CASCADE,
    CONSTRAINT chk_booking_details_noOfPeople CHECK (noOfPeople > 0 and noOfPeople <= 12),
    CONSTRAINT chk_booking_details_status CHECK (bookingStatus in ('PN','CO')) 
);
--PN - pending CO - confirmed

INSERT INTO Boating_Types VALUES ('D', 'Day Cruise');
INSERT INTO Boating_Types VALUES ('N', 'Night Stay');
INSERT INTO Boating_Types VALUES ('F', 'Day and Night');

Commit;

INSERT INTO Boating_Locations VALUES ('Allepey');
INSERT INTO Boating_Locations VALUES ('Kumarakom');
INSERT INTO Boating_Locations VALUES ('Tarkarli');

Commit;

INSERT INTO Boat_Details VALUES ('B101', 'D','Allepey',10000.00);
INSERT INTO Boat_Details VALUES ('B102', 'N','Allepey',15000.00);
INSERT INTO Boat_Details VALUES ('B103', 'F','Allepey',25000.00);
INSERT INTO Boat_Details VALUES ('B104', 'D','Kumarakom',9000.00);
INSERT INTO Boat_Details VALUES ('B105', 'N','Kumarakom',12000.00);
INSERT INTO Boat_Details VALUES ('B106', 'F','Kumarakom',22000.00);
INSERT INTO Boat_Details VALUES ('B107', 'D','Tarkarli',7000.00);
INSERT INTO Boat_Details VALUES ('B108', 'N','Tarkarli',11000.00);
INSERT INTO Boat_Details VALUES ('B109', 'F','Tarkarli',26000.00);

Commit;


INSERT INTO Booking_Details VALUES ('1001','B101',SYSDATE+1,6,8095487654,'PN');
INSERT INTO Booking_Details VALUES ('1002','B101',SYSDATE+3,8,9968456711,'PN');
INSERT INTO Booking_Details VALUES ('1003','B106',SYSDATE+6,5,9869228325,'PN');
INSERT INTO Booking_Details VALUES ('1004','B105',SYSDATE+1,10,8095112299,'CO');
INSERT INTO Booking_Details VALUES ('1005','B106',SYSDATE-1,6,9769454513,'CO');
INSERT INTO Booking_Details VALUES ('1006','B103',SYSDATE+5,12,9543436767,'PN');
INSERT INTO Booking_Details VALUES ('1007','B105',SYSDATE-7,4,8769001234,'CO');
INSERT INTO Booking_Details VALUES ('1008','B106',SYSDATE+4,4,8963636364,'CO');
INSERT INTO Booking_Details VALUES ('1009','B106',SYSDATE-3,6,9996734521,'CO');

Commit;

			