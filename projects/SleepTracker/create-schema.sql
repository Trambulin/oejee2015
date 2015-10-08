CREATE TABLE Users(
	userID SERIAL NOT NULL,
	FirstName varchar(100) NOT NULL,
	LastName varchar(100) NOT NULL,
	Wheight varchar(10) NOT NULL,
	CONSTRAINT PK_USERS_ID PRIMARY KEY (userID)
);

ALTER TABLE User OWNER TO postgres;

CREATE TABLE Sleeps(
);
ALTER TABLE Sleeps OWNER TO postgres;

CREATE TABLE Rating(
);
ALTER TABLE Rating OWNER TO postgres;

CREATE TABLE Eat(
);
ALTER TABLE Eat OWNER TO postgres;

CREATE TABLE Sports(
);
ALTER TABLE Sports OWNER TO postgres;

CREATE TABLE RatingString(
);
ALTER TABLE RatingString OWNER TO postgres;