<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>

<head>
	<title>Event Management</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<!------ Light Box ------>
	<link rel="stylesheet" href="css/swipebox.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<link href="css/userDropdown.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="js/jquery.swipebox.min.js"></script>
		
			
	<script type="text/javascript">
		jQuery(function ($) {
			$(".swipebox").swipebox();
		});
	</script>
	<!------ Eng Light Box ------>
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
						<li class="active">
							<a href="/gallery">GALLERY</a>
						</li>
						<li>
							<a href="/blog">BLOG</a>
						</li>
						<li>
							<a href="/contact">CONTACT</a>
						</li>
						
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


// Hi , ${sessionScope.logedUser} for get session name.
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
						<li class="active">
							<a href="/gallery">GALLERY</a>
						</li>
						<li>
							<a href="/blog">BLOG</a>
						</li>
						<li>
							<a href="/contact">CONTACT</a>
						</li>
						

							<li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Hi ,<%= logedUser %></a>
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
				<div class="gallery">
					<h3>Latest Photos</h3>
					<div class="section group">
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img1_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img1.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img2_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img2.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img3_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img3.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img4_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img4.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
					</div>
					<div class="section group">
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img5_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img5.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img6_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img6.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img7_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img7.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
						<div class="grid_1_of_4 images_1_of_4">
							<a href="images/gallery_img8_b.jpg" class="swipebox" title="Image Title">
								<img src="images/gallery_img8.jpg" alt="">
								<span class="zoom-icon"></span>
							</a>
						</div>
					</div>
					<div class="projects-bottom-paination">
						<ul>
							<li class="active">
								<a href="#">1</a>
							</li>
							<li>
								<a href="#">2</a>
							</li>
						</ul>
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
