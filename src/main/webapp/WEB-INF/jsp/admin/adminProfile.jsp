<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/styleRegistration.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <style>
                  .link {
                      background-color: white;
                      border: 1px solid black;
                      color: black;
                      padding: 2px 10px;
                      text-align: center;
                      display: inline-block;
                      font-size: 15px;
                      margin: 5px 20px;
                      cursor: pointer;
                      text-decoration:none;

                      padding-top: 10px;
                      padding-right: 10px;
                       padding-bottom:10px;
                      padding-left: 10px;
                  }

          </style>
   <style>

   .aa{
     padding-top: 50px;
     text-align:center;
     font-weight: bold;
     
   }
   </style>
        <style>
           table, th, td {

              margin-right:auto;
              margin-left:auto;
            }
            th, td {
                  padding: 10px;
             }

        </style>
</head>

    <body class="aa">
<% if (session.getAttribute("loggedAdmin") == null) {
	
	response.sendRedirect("/adminLogin");
} else{
	%>


<h2><img src="images/user.png" width="100" height="70" alt="profile"></h2>
<c:forEach items="${getAdminProfile}" var="list">
   <table>

       <tr style="font-size: 20px;text-lign:center; color:white;"><td>User Name</td><td>:</td>
       <td>${list.getAdminUsername()}</td></tr>
       <tr style="font-size: 20px;color:white;"><td>Password</td><td>:</td>
       <td>${list.adminPassword}</td></tr>
        </table>
<br>

<a href="/adminHomepage" class="link">Back</a>
<a href="/editAdminProfile" class="link">Change Profile</a>

</c:forEach>

<%} %>
    </body>
</html>





<script type="text/javascript">
var idleTime = 0;
$(document).ready(function () {
    //Increment the idle time counter every minute.
    var idleInterval = setInterval(timerIncrement, 60000); // 1 minute

    //Zero the idle timer on mouse movement.
    $(this).mousemove(function (e) {
        idleTime = 0;
    });
    $(this).keypress(function (e) {
        idleTime = 0;
    });
});

function timerIncrement() {
    idleTime = idleTime + 1;
    if (idleTime > 19) { // 20 minutes
       //javascript er popup dite hobe, je abar login korar jonno session expired, because security
        window.location.href = "/adminLogout";
        // window.location.reload();
    }
}
</script>
