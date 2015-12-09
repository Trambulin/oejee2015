<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Add Trainer ::</title>
</head>
<body>
<form action="AddTrainerService" method="POST">
	Name: <input name="name"></input><br/>
	Height: <input name="height"></input><br/>
	Weight: <input name="weight"></input><br/>
	Contacts: <br/>
	Type:<input name="contact_type"></input> Value:<input name="contact_value"></input><br/>
	Qualifications:<br/>
	Name:<input name="qualification_name"></input> Level:<input name="qualification_level"></input> Year:<input name="qualification_year"></input><br/>
	<input type="submit" value="Add trainer"></input>
</form>
</body>
</html>