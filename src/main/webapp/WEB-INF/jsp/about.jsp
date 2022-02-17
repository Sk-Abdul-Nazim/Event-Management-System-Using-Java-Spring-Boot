<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>

<head>
	<title>Event Management</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<link href="css/userDropdown.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	
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
						<li class="active">
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
			<li class="active">
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
<!-- 			<li> -->
<!-- 				<a href="#">ADMIN</a> -->
<!-- 			</li> -->

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
				<div class="section group">
					<div class="col_1_of_3 span_1_of_3">
						<h2>
							<span>welcome</span>
						</h2>
						<h4>Lorem ipsum dolor sit amet</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
							Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
							Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
					</div>
					<div class="col_1_of_3 span_1_of_3">
						<div class="menu_timmings">
							<ul>
								<li>
									<div class="txt1">Main Menu</div>
									<div class="txt2 color1">12am - 12pm</div>
								</li>
								<li>
									<div class="txt1">Beer Festival</div>
									<div class="txt2 color2">9am - 8pm</div>
								</li>
								<li>
									<div class="txt1">Live Music</div>
									<div class="txt2 color3">7pm - 12pm</div>
								</li>
								<li>
									<div class="txt1">Disco Dance</div>
									<div class="txt2 color4">8pm - 2am</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="col_1_of_3 span_1_of_3">
						<h2>
							<span>Latest Events</span>
						</h2>
						<div class="event-grid">
							<div class="event_img">
								<img src="images/event1.jpg" title="post1" alt="">
							</div>
							<div class="event_desc">
								<h4>
									<span>NEQUE LIGULA</span>
								</h4>
								<h4>Aug 28Th, 2013</h4>
								<p>Lorem ipsum dolor sit amet consectetur dolor more normal of letters,
									<a href="#">[...]</a>
								</p>
							</div>
							<div class="clear"> </div>
						</div>
						<div class="event-grid">
							<div class="event_img">
								<img src="images/event2.jpg" title="post1" alt="">
							</div>
							<div class="event_desc">
								<h4>
									<span>DOLORE IPSUM</span>
								</h4>
								<h4>Aug 2ND, 2013</h4>
								<p>Lorem ipsum dolor sit amet consectetur dolor more normal of letters,
									<a href="#">[...]</a>
								</p>
							</div>
							<div class="clear"> </div>
						</div>
						<div class="event-grid">
							<div class="event_img">
								<img src="images/event3.jpg" title="post1" alt="">
							</div>
							<div class="event_desc">
								<h4>
									<span>NEQUE LIGULA</span>
								</h4>
								<h4>july 28Th, 2013</h4>
								<p>Lorem ipsum dolor sit amet consectetur dolor more normal of letters,
									<a href="#">[...]</a>
								</p>
							</div>
							<div class="clear"> </div>
						</div>
						<div class="view-all">
							<a href="#">ViewAll</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		 <jsp:include page="./includes/footer.jsp" /> 
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
