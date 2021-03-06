-- This is the SQL script for setting up the DDL for the h2 database
-- In a typical project you would only distinguish between main and test for flyway SQLs
-- However, in this sample application we provde support for multiple databases in parallel
-- You can simply choose the DB of your choice by setting spring.profiles.active=XXX in config/application.properties
-- Assuming that the preconfigured user exists with according credentials using the included SQLs

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000000;

-- *** Staffmemeber ***
CREATE TABLE SAMPLEDATA(
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name VARCHAR(255),
  surname VARCHAR(255),
  age BIGINT,
  mail VARCHAR(255),
  CONSTRAINT PK_SampleData PRIMARY KEY(id),
  CONSTRAINT UC_SampleData_mail UNIQUE(mail)
);

CREATE TABLE MOREDATA(
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  product VARCHAR(255),
  description VARCHAR(255),
  stock BIGINT,
  CONSTRAINT PK_MoreData PRIMARY KEY(id),
  CONSTRAINT UC_MoreData_product UNIQUE(product)
);

CREATE TABLE BinaryObject (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  data BLOB(2147483647),
  size BIGINT NOT NULL,
  mimeType VARCHAR(255),
  PRIMARY KEY (ID)
);

-- *** RevInfo (Commit log for envers audit trail) ***
CREATE TABLE RevInfo(
  id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  timestamp BIGINT NOT NULL,
  user VARCHAR(255)
);
