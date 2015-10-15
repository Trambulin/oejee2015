INSERT INTO User_account(FirstName, LastName, BirthDate, Height, Weight, Sex) VALUES ('Várady','László', '1993-12-18', 180, 60, true);
INSERT INTO Meal(MealTime, MealContent, Fullness) VALUES ('09:00', 'Pacal pürkütt', 10);
INSERT INTO Feel(FeelValue) VALUES ('Kipihent');
INSERT INTO Type(TypeID, TypeValue) VALUES (1, 'Futás');
INSERT INTO Day(DateID,Tempreature, FrontImpact, Humidity, Rain) VALUES ('2015-10-08', 15, 'Hidegfront, fáj a lábujjam.', 50, true );
INSERT INTO Sport(Length, Type, Exhaustion) VALUES (60, 1, 7);
INSERT INTO Rating(Relaxed, Feel) VALUES (8, 1);
INSERT INTO Sleep(UserID, StartTime, EndTime, RatingID, MealID, SportID, DateOfDay) VALUES (1,'11:30','18:30', 1,1,1,'2015-10-08');





