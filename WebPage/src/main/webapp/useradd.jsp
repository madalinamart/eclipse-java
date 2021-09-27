<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User created!</title>
</head>
<body>
<%-- Need to get the informations from the AddNewUser Servlet
 we have 3 values and must use for each of them--%>
 <h1> Your account was created! </h1>

 <p> 
 First Name: <% String fName = request.getParameter("firstname"); out.print(fName); %> </br>
 Last Name: <% String lName = request.getParameter("lastname"); out.print(lName); %> </br>
 Country: <% String country = request.getParameter("country"); out.print(country); %> </br>
</p>

</body>
</html>