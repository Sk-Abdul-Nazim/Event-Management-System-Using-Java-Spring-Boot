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
						<li>
							<a href="/blog">BLOG</a>
						</li>
						<li class="active">
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
						<li>
							<a href="/blog">BLOG</a>
						</li>
						<li class="active">
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
				<div class="contact">
					<div class="section group">
						<div class="col_1_of_3 contact_1_of_3">
							<div class="contact-form">
								<h3>Get In Touch</h3>
								<form>
									<div>
										<span>
											<input type="text" class="textbox" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
										</span>
									</div>
									<div>
										<span>
											<input type="text" class="textbox" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
										</span>
									</div>
									<div>
										<span>
											<textarea value="Message:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Message</textarea>
										</span>
									</div>
									<div>
										<span>
											<input type="submit" class="mybutton" value="Submit">
										</span>
									</div>
								</form>
							</div>
						</div>
						<div class="col_1_of_3 contact_1_of_3">
							<div class="company_address">
								<h3>Address</h3>
								<p>500 Lorem Ipsum Dolor Sit,</p>
								<p>22-56-2-9 Sit Amet, Lorem,</p>
								<p>USA</p>
								<p>Phone:(00) 222 666 444</p>
								<p>Fax: (000) 000 00 00 0</p>
								<p>Email:
									<span>
										<a href="mailto:info@example.com">mail@example.com</a>
									</span>
								</p>
								<p>Follow on:
									<span>Facebook</span>,
									<span>Twitter</span>
								</p>
							</div>
						</div>
						<div class="col_1_of_3 contact_1_of_3">
							<div class="contact_info">
								<h3>Find Us Here</h3>
								<div class="map">
									<iframe width="100%" height="250" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
									<br>
									<small>
										<a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265"
										    style="color:#F39EFF;;text-align:left;font-size:0.85em">View Larger Map</a>
									</small>
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
