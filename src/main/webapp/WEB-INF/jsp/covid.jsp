<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/covid" method="post">
<table>
<tr>
<td>adhar</td>
<td><input type="text" name="adhar"/></td>
</tr>

<tr>
<td>DOB</td>
<td><input type="date" name="dob"/></td>
</tr>

<tr>
<td>phone</td>
<td><input type="text" name="phone"/></td>
</tr>

<tr>
<td>Appointment Date</td>
<td><input type="date" name="appdate"/></td>
</tr>

<tr>
<td>Condition</td>
<td><select name="condition">
<option>Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select> </td>
</tr>
<tr>
<td>Vaccine Name</td>
<td><select name="vaccine">
<option>Select</option>
<option value="coviSheild">CoviSheild</option>
<option value="covaccine">Covaccine</option>
</select> </td>
</tr>
</table>
<input type="submit" value="Submit"/>
</form>
</body>
</html>