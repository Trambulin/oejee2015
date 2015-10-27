CREATE TABLE User_account(
	UserID SERIAL NOT NULL,
	FirstName CHARACTER VARYING(100) NOT NULL,
	LastName CHARACTER VARYING(100) NOT NULL,
	BirthDate DATE NOT NULL,
	Height INTEGER NOT NULL,
	Weight INTEGER NOT NULL,
	Sex BOOLEAN NOT NULL,
	CONSTRAINT PK_USERS_ID PRIMARY KEY (userID)
);
ALTER TABLE User_account OWNER TO postgres;

CREATE TABLE Meal(
	MealID SERIAL NOT NULL,
	MealTime TIME NOT NULL,
	MealContent CHARACTER VARYING(200) NOT NULL,
	Fullness INT NOT NULL,
	CONSTRAINT PK_Meal_ID PRIMARY KEY (MealID)
);
ALTER TABLE Meal OWNER TO postgres;

CREATE TABLE Type(
	TypeID INT NOT NULL,
	TypeValue CHARACTER VARYING(100),
	CONSTRAINT PK_Type_ID PRIMARY KEY (TypeID)
);
ALTER TABLE Type OWNER TO postgres;

CREATE TABLE Sport(
	SportID SERIAL NOT NULL,
	Length	INT NOT NULL,
	Type INT NOT NULL,
	Exhaustion INT NOT NULL,
	CONSTRAINT PK_Sport_ID PRIMARY KEY (SportID),
	CONSTRAINT FK_Type FOREIGN KEY (Type)
		  REFERENCES Type (TypeID) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE Sport OWNER TO postgres;

CREATE TABLE Feel(
	FeelID SERIAL NOT NULL,
	FeelValue CHARACTER VARYING(100),
	CONSTRAINT PK_Feel_ID PRIMARY KEY (FeelID)
);
ALTER TABLE Feel OWNER TO postgres;

CREATE TABLE Rating(
	RatingID SERIAL NOT NULL,
	Relaxed  INTEGER NOT NULL,
	Feel INTEGER NOT NULL,
	CONSTRAINT FK_Rating_ID PRIMARY KEY (RatingID),
	CONSTRAINT FK_FEEL FOREIGN KEY (Feel)
		  REFERENCES Feel (FeelID) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE Rating OWNER TO postgres;

CREATE TABLE Day(
	DateID Date NOT NULL,
	Tempreature INT NOT NULL,
	FrontImpact CHARACTER VARYING(200),
	Humidity INT NOT NULL,
	Rain BOOLEAN NOT NULL,
	CONSTRAINT PK_Day_ID PRIMARY KEY (DateID)
);
ALTER TABLE Day OWNER TO postgres;

CREATE TABLE Sleep(
	SleepID SERIAL NOT NULL,
	UserID INT NOT NULL,
	StartTime TIME NOT NULL,
	EndTime TIME NOT NULL,
	RatingID INT NOT NULL,
	MealID INT NOT NULL,
	SportID INT NULL,
	DateOfDay DATE,
	CONSTRAINT PK_Sleep_ID PRIMARY KEY (SleepID),
	CONSTRAINT FK_Sleep_USerID FOREIGN KEY (UserID)
	  REFERENCES User_account (UserID) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_Sleep_Meal FOREIGN KEY (MealID)
	  REFERENCES Meal (MealID) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_Sleep_Sport FOREIGN KEY (SportID)
	  REFERENCES Sport (SportID) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_Sleep_Rating FOREIGN KEY (RatingID)
	  REFERENCES Rating (RatingID) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_Sleep_Day FOREIGN KEY (DateOfDay)
	  REFERENCES Day (DateID) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT		
);
ALTER TABLE Sleep OWNER TO postgres;












