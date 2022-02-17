<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <style>
  .b{
         padding: 5cm 2cm 2cm 16cm !important;
         background-image: url('images/bg.jpg');
         color:white;
    }
</style>
</head>
<body class="b">
<%
if( (String)session.getAttribute("ParticularHallID") == null) {
	  String redirectURL = "/events";
      response.sendRedirect(redirectURL);
}else{
%>
<p style="color:red;">${errorDate}</p>
<form action="/hallDetails" method="POST">
<input type="hidden" name="hallId" value="<c:out value="${sessionScope.ParticularHallID}" /> ">
<input type="hidden" name="catId" value="<c:out value="${sessionScope.ParticularCategoryID}" /> ">
<input type="hidden" name="citId" value="<c:out value="${sessionScope.ParticularCityID}" /> ">
<div>

<div>
<lable>Arrival date    :</lable>
<input type="date" name="arr_date">
</div>
<br>
<div>
  <lable>
Departure date :</lable>
<input type="date" name="dep_date">
</div>
<br>
<div>

<input type="submit" name = "hallDetails" value="Submit">
</div>
</div>
</form>
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
    window.location.href = "/logoutUser";
        // window.location.reload();
    }
}
</script>
