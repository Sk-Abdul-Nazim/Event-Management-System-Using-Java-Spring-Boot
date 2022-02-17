<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML>
<html>

<head>
	<title>Event Management</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>

		<link href="css/userDropdown.css" rel="stylesheet" type="text/css" media="all" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
</head>

<body>

	<div class="header">
		<div class="header_top">
			<div class="wrap">
				<div class="logo">
					<a href="/">
						<img src="images/logo.png" alt="" />
					</a>
				</div>

				<% if (session.getAttribute("logedUser") == null) { %>

				<div class="menu">
					<ul>
						<li>
							<a href="/">HOME</a>
						</li>
						<li>
							<a href="/about">ABOUT</a>
						</li>
						<li>
							<a href="/events">EVENTS HALL</a>
						</li>
						<li>
							<a href="/gallery">GALLERY</a>
						</li>
						<li>
							<a href="/blog">BLOG</a>
						</li>
						<li>
							<a href="/contact">CONTACT</a>
						</li>
<!-- 						<li> -->
<!-- 							<a href="#">ADMIN</a> -->
<!-- 						</li> -->
						<li>
							<a href="/login" title="login"><i class="fa fa-sign-in" aria-hidden="true"></i></a>
						</li>
						<li>
							<a href="/registerUser" title="Register"><i class="fa fa-registered" aria-hidden="true"></i></a>
						</li>
						<li>
							<a href="javascript:;" title="User"><i class="fa fa-user" aria-hidden="true"></i></a>
						</li>


						<div class="clear"></div>
					</ul>
				</div>

		<% } else {
 String  str = (String)session.getAttribute("logedUser");
 str = str+" ";
String logedUser = str.substring(0,str.indexOf(' ') + 1); 

%>
				<div class="menu">
					<ul>
						<li>
							<a href="/">HOME</a>
						</li>
						<li>
							<a href="/about">ABOUT</a>
						</li>
						<li class="active">
							<a href="/events">EVENTS HALL</a>
						</li>
						<li>
							<a href="/gallery">GALLERY</a>
						</li>
						<li>
							<a href="/blog">BLOG</a>
						</li>
						<li>
							<a href="/contact">CONTACT</a>
						</li>

							<li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Hi , <%= logedUser %></a>
                    <div class="dropdown-menu">
                        <a href="#" class="user userFont"><i class="fa fa-briefcase"></i> My Booking</a>
                        <a href="#" class="user userFont"><i class="fa fa-user"></i> Profile</a>
                        <a href="/logout" class="user userFont"><i class="fa fa-sign-out"></i> Logout</a>
                        <div class="dropdown-divider"></div>
                        <a href="#"class="userFontBooking userFont"> Booking History</a>
                    </div>
                </li>

						<div class="clear"></div>
					</ul>
				</div>
			<% } %>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="wrap">
			<div class="content_top">
				<div class="events">

					<h2>Events Hall</h2>

					<div class="section group">
					  <c:forEach items="${searchHall }" var="list">
						<div class="grid_1_of_3 events_1_of_3">
						
							<div class="event-time">
								<h4>
									<span>Hall Name: 

							        	${list.hallName }
									</span><br>
									
									<span>Hall Type :

										${list.hallCategoryName }
									 
									 </span><br>
								</h4>
								
								<h4>place : 
								
									${list.hallPlace }
								</h4>
								<h4>city  : 
								
									${list.hallCityName }
								</h4>
								<h4>price :
								
									${list.hallPrice }
								 <small> / day</small></h4>
							</div>

							<div class="event-img">
<%-- 							   <c:set var="path" value="/imagesFile/"/> --%>
							    <c:set var="path" value="images\\hallImageDB\\"/>
                                <c:set var="pathWithImageName" value= "${path}${list.hallImage}" />
                                
                                 <c:set var="fullPath" value="E:\\Spring Suite 4 Projects\\EMS\\src\\main\\resources\\static\\images\\hallImageDB\\"/>
                                 
                               <c:set var="fullPathWithImageName" value= "${fullPath}${list.hallImage}" />
                               
<%--                              <a href="javascript:(0)"  onclick="onclickFunction('${list.hallId},${list.hallCategoryId},${list.hallCityId}');"> --%>
                               <a href="/eventsHallDate?hallId=${list.hallId}&catId=${list.hallCategoryId}&citId=${list.hallCityId}">
							   	<img src="${pathWithImageName}" alt="feature_1" width="80px" height="200px" />
									<span>VIEW</span>
								</a>
								</div>
								</div>
								</c:forEach>
							</div>
							</div>
						
							
						</div>

					</div>
					
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<!-- include footer -->
	 <jsp:include page="./includes/footer.jsp" /> 
		<!-- include footer -->
	</div>

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
