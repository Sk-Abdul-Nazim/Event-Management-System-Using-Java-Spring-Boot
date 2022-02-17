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
						<li class="active">
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
						<li>
							<a href="/events">EVENTS HALL</a>
						</li>
						<li>
							<a href="/gallery">GALLERY</a>
						</li>
						<li class="active">
							<a href="/blog">BLOG</a>
						</li>
						<li>
							<a href="/contact">CONTACT</a>
						</li>
<!-- 						<li> -->
<!-- 							<a href="#">ADMIN</a> -->
<!-- 						</li> -->

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
				<div class="blog">
					<h2>Blogs</h2>
					<div class="blog-leftgrids">
						<div class="image group">
							<div class="grid images_3_of_1">
								<a href="#">
									<img src="images/blog-img2.jpg" alt="">
								</a>
							</div>
							<div class="grid blog-desc">
								<h4>
									<span>Duis aute irure dolor cillum dolore</span>
								</h4>
								<h4>Sep 14TH, 2013,&nbsp;&nbsp; posted By
									<a href="#" class="post">Lorem ipsum</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit
									esse cillum dolore eu fugiat nulla pariatur.
									<span>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</span>
								</p>
								<a href="#" class="button">Read More</a>
							</div>
						</div>
					</div>
					<div class="blog-leftgrids">
						<div class="image group">
							<div class="grid images_3_of_1">
								<a href="#">
									<img src="images/blog-img1.jpg" alt="">
								</a>
							</div>
							<div class="grid blog-desc">
								<h4>
									<span>Excepteur sint non proident</span>
								</h4>
								<h4>Sep 14TH, 2013,&nbsp;&nbsp; posted By
									<a href="#" class="post">Lorem ipsum</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit
									esse cillum dolore eu fugiat nulla pariatur.
									<span>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</span>
								</p>
								<a href="#" class="button">Read More</a>
							</div>
						</div>
					</div>
					<div class="blog-leftgrids">
						<div class="image group">
							<div class="grid images_3_of_1">
								<a href="#">
									<img src="images/event-img1.jpg" alt="">
								</a>
							</div>
							<div class="grid blog-desc">
								<h4>
									<span>Duis aute irure dolor cillum dolore</span>
								</h4>
								<h4>Sep 14TH, 2013,&nbsp;&nbsp; posted By
									<a href="#" class="post">Lorem ipsum</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit
									esse cillum dolore eu fugiat nulla pariatur.
									<span>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</span>
								</p>
								<a href="#" class="button">Read More</a>
							</div>
						</div>
					</div>
					<div class="content-pagenation">
						<li>
							<a href="#">Frist</a>
						</li>
						<li class="active">
							<a href="#">1</a>
						</li>
						<li>
							<a href="#">2</a>
						</li>
						<li>
							<a href="#">3</a>
						</li>
						<li>
							<span>....</span>
						</li>
						<li>
							<a href="#">Last</a>
						</li>
						<div class="clear"> </div>
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
