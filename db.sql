CREATE DATABASE mall_network;
use mall_network;

CREATE TABLE mall(
    Id int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(60) NOT NULL,
    CityName varchar(60) NOT NULL,
    StateOfCountry varchar(60) NOT NULL,
    Country varchar(60) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE department_store(
    Id int(11) NOT NULL AUTO_INCREMENT,
    CNPJ VARCHAR(14) NOT NULL UNIQUE,
    Name varchar(60) NOT NULL,
    Email varchar(60) NOT NULL,
    CreationDate datetime NOT NULL,
    StartedDateAtMall datetime NOT NULL,
    -- the measure is done by pattern deppartment_stores something like 5square metters
    CurrentSizeOccupy int NOT NULL,
    MallId int(11) NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (MallId) REFERENCES mall(id)
);

CREATE TABLE rent(
    Id int(11) NOT NULL AUTO_INCREMENT,
    CurrentMonth Date NOT NULL,
    MallId int(11) NOT NULL,
    DepartmentStoreId int(11) NOT NULL,
    CurrentRent decimal(20,2) NOT NULL,
    CurrentPayedRent decimal(20,2) NOT NULL,
    payed BOOLEAN NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (MallId) REFERENCES mall(Id),
    FOREIGN KEY (DepartmentStoreId) REFERENCES department_store(Id)
);

INSERT INTO mall (Name,CityName,StateOfCountry,Country) VALUES
('shopping 1','Porto Alegre','Rio Grande Do sul','Brasil'),
('shopping 2','Pelotas','Rio Grande Do sul','Brasil');


INSERT INTO department_store (CNPJ,Name,Email,CreationDate,StartedDateAtMall,CurrentSizeOccupy,MallId) VALUES
('00000000000100','loja1','loja1@shopping1.com','2022-05-07 00:00:00','2022-05-07 00:00:00',2,1),
('00000000000101','loja2','loja2@shopping2.com','2022-05-07 00:00:00','2022-05-07 00:00:00',3,2);

INSERT INTO rent (CurrentMonth,MallId,DepartmentStoreId,CurrentRent,CurrentPayedRent,payed) VALUES
('2022-05-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-05-01 00:00:00',2,2,3000.00,3000.00,1),
('2022-06-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-06-01 00:00:00',2,2,3000.00,3000.00,1),
('2022-07-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-07-01 00:00:00',2,2,3000.00,3000.00,1),
('2022-08-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-08-01 00:00:00',2,2,3000.00,3000.00,1),
('2022-09-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-09-01 00:00:00',2,2,3000.00,3000.00,1),
('2022-10-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-10-01 00:00:00',2,2,3000.00,3000.00,1),
('2022-11-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-11-01 00:00:00',2,2,3000.00,3000.00,1),
('2022-12-01 00:00:00',1,1,1000.00,1000.00,1),
('2022-12-01 00:00:00',2,2,3000.00,3000.00,1);