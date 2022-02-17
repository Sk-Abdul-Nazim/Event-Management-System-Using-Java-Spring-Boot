<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>

<head>
	<title>Events Management</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/slider.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/userDropdown.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.css" />
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.js"></script>
	

	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>

	<script type="text/javascript">
	$(window).load(function() {
	    $(".loader").fadeOut("slow");
	});
	</script>

	<script type="text/javascript">
		$(window).load(function () {
			$('#slider').nivoSlider();
		});
	</script>


<style>

#search-form_3 {
background: #e1e1e1; /* Fallback color for non-css3 browsers */
width: 365px;
margin: 100px auto;

/* Gradients */
background: -webkit-gradient( linear,left top, left bottom, color-stop(0, rgb(243,243,243)), color-stop(1, rgb(225,225,225)));
background: -moz-linear-gradient( center top, rgb(243,243,243) 0%, rgb(225,225,225) 100%);

/* Rounded Corners */
border-radius: 17px;
-webkit-border-radius: 17px;
-moz-border-radius: 17px;

/* Shadows */
box-shadow: 1px 1px 2px rgba(0,0,0,.3), 0 0 2px rgba(0,0,0,.3);
-webkit-box-shadow: 1px 1px 2px rgba(0,0,0,.3), 0 0 2px rgba(0,0,0,.3);
-moz-box-shadow: 1px 1px 2px rgba(0,0,0,.3), 0 0 2px rgba(0,0,0,.3);
}

/*** TEXT BOX ***/
.search_3{
background: #fafafa; /* Fallback color for non-css3 browsers */

/* Gradients */
background: -webkit-gradient( linear, left bottom, left top, color-stop(0, rgb(250,250,250)), color-stop(1, rgb(230,230,230)));
background: -moz-linear-gradient( center top, rgb(250,250,250) 0%, rgb(230,230,230) 100%);
border: 0;
border-bottom: 1px solid #fff;
border-right: 1px solid rgba(255,255,255,.8);
font-size: 16px;
margin: 1px;
padding: 5px;
width: 230px;

/* Rounded Corners */
border-radius: 17px;
-webkit-border-radius: 17px;
-moz-border-radius: 17px;

/* Shadows */
box-shadow: -1px -1px 2px rgba(0,0,0,.3), 0 0 1px rgba(0,0,0,.2);
-webkit-box-shadow: -1px -1px 2px rgba(0,0,0,.3), 0 0 1px rgba(0,0,0,.2);
-moz-box-shadow: -1px -1px 2px rgba(0,0,0,.3), 0 0 1px rgba(0,0,0,.2);
}

/*** USER IS FOCUSED ON TEXT BOX ***/
.search_3:focus{
outline: none;
background: #fff; /* Fallback color for non-css3 browsers */

/* Gradients */
background: -webkit-gradient( linear, left bottom, left top, color-stop(0, rgb(255,255,255)), color-stop(1, rgb(235,235,235)));
background: -moz-linear-gradient( center top, rgb(255,255,255) 0%, rgb(235,235,235) 100%);
}

/*** SEARCH BUTTON ***/
.submit_3{
background: #44921f;/* Fallback color for non-css3 browsers */
/* Gradients */
background: -webkit-gradient( linear, left top, left bottom, color-stop(0, rgb(188, 32, 162)), color-stop(0.15, rgb(157, 34, 142)), color-stop(0.88, rgb(28, 71, 135)), color-stop(1, rgb(21, 71, 114)));
background: -moz-linear-gradient( center top, rgb(79,188,32) 0%, rgb(73,157,34) 15%, rgb(62,135,28) 88%, rgb(49,114,21) 100%);
border: 0;
color: #eee;
cursor: pointer;
float: right;
font: 16px 'Raleway', sans-serif;
font-weight: bold;
height: 30px;
margin: 4px 4px 0;
text-shadow: 0 -1px 0 rgba(0,0,0,.3);
width: 84px;
outline: none;

/* Rounded Corners */
border-radius: 30px;
-webkit-border-radius: 30px;
-moz-border-radius: 30px;

/* Shadows */
box-shadow: -1px -1px 1px rgba(255,255,255,.5), 1px 1px 0 rgba(0,0,0,.4);
-moz-box-shadow: -1px -1px 1px rgba(255,255,255,.5), 1px 1px 0 rgba(0,0,0,.2);
-webkit-box-shadow: -1px -1px 1px rgba(255,255,255,.5), 1px 1px 0 rgba(0,0,0,.4);
}
/*** SEARCH BUTTON HOVER ***/
.submit_3:hover {
background: #4ea923; /* Fallback color for non-css3 browsers */

/* Gradients */
background: -webkit-gradient( linear, left top, left bottom, color-stop(0, rgb(89,222,27)), color-stop(0.15, rgb(83,179,38)), color-stop(0.8, rgb(66,143,27)), color-stop(1, rgb(54,120,22)));
background: -moz-linear-gradient( center top, rgb(89,222,27) 0%, rgb(83,179,38) 15%, rgb(66,143,27) 80%, rgb(54,120,22) 100%);
}
.submit_3:active {
background: #4ea923; /* Fallback color for non-css3 browsers */

/* Gradients */
background: -webkit-gradient( linear, left bottom, left top, color-stop(0, rgb(89,222,27)), color-stop(0.15, rgb(83,179,38)), color-stop(0.8, rgb(66,143,27)), color-stop(1, rgb(54,120,22)));
background: -moz-linear-gradient( center bottom, rgb(89,222,27) 0%, rgb(83,179,38) 15%, rgb(66,143,27) 80%, rgb(54,120,22) 100%);
}

.loader {
    position: fixed;
    left: 0px;
    top: 0px;
    width: 100%;
    height: 100%;
    z-index: 9999;
    background: url('images/loading.gif') 50% 50% no-repeat rgb(249,249,249);
    opacity: .8;
}

</style>
</head>

<body>
	<div class="loader">
		Loading please wait...
	</div>
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
						<li class="active">
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
<!-- 							<a href="/adminLogin">ADMIN</a> -->
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
						<!-- <div class="clear"></div> -->
					</ul>
				</div>
			 
<%  }else{
 String  str = (String)session.getAttribute("logedUser");
 str = str+" ";
String logedUser = str.substring(0,str.indexOf(' ') + 1); 

%>
    
				<div class="menu">
					<ul>
						<li class="active">
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
<!-- 							<a href="/adminLogin">ADMIN</a> -->
<!-- 						</li> -->

							<li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Hi , <%= logedUser %></a>
                    <div class="dropdown-menu">
                        <a href="/myBooking" class="user userFont"><i class="fa fa-briefcase"></i> My Booking</a>
                        <a href="/userProfile" class="user userFont"><i class="fa fa-user"></i> Profile</a>
                        <a href="/logoutUser" class="user userFont"><i class="fa fa-sign-out"></i> Logout</a>
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
		<!------ Slider ------------>
		<div class="wrap">
			<div class="slider">
				<div class="slider-wrapper theme-default">
					<div id="slider" class="nivoSlider">
						<img src="images/1.jpg" data-thumb="images/1.jpg" alt="" />
						<img src="images/2.jpg" data-thumb="images/2.jpg" alt="" />
						<img src="images/3.jpg" data-thumb="images/3.jpg" alt="" />
						<img src="images/4.jpg" data-thumb="images/4.jpg" alt="" />
						<img src="images/5.jpg" data-thumb="images/5.jpg" alt="" />
					</div>
					<div>

						<section>
						            <div class="container">
						            <p style="color:red;">${errorDate}</p>
						                <div class="row">
						                
						                  <form action="/searchHall" method="POST" name="searchForm">
						                      <div style = "position:absolute; left:300px; top:692px;">
						                          <h5 style="color:white;">Starting Date</h5>
						                          <div>
						                              <input type="date"  name="arr_date" value="" placeholder=""  autocomplete="on" onclick="isDateSelected();" required >
						                          </div>
						                      </div>
																	<div style = "position:absolute; left:500px; top:692px;">
																		 <h5 style="color:white;">Ending Date</h5>
																		 <div>
																				 <input type="date"  name="dep_date" value="" placeholder=""  autocomplete="on" onclick="isDateSelected1();" required>
																		 </div>
																 </div>
																 
								                                    	<div style = "position:absolute; left:690px; top:692px;">
																		 <h5 style="color:white;">Hall Type</h5>
																		 <div>
																		   <select class="selectpicker" name="catId">
																				 <option>select</option>
                                                                                 <c:forEach items="${dropDownCategory}" var="list">
                                              
                                                                                 <option value="${list.id}">${list.name}</option>

                                                                             </c:forEach>
                                                                          </select>
										 								 
																 </div>
																 </div>
																	  <div style = "position:absolute; left:850px; top:720px;">
																			<input  class="search_3" type="text" name="sch" id="sch" placeholder="Search by hall name or city..." onkeyup="javascript:capitalize(this.id, this.value);" required>
																	    <input type="submit" name="search" class="submit_3" value="Search">
																	  </div>

						                      <div>
						                      </div>
						                  </form>
						                </div>
						            </div>
						        </section>

					</div>
				</div>
			</div>

		</div>
		<!------End Slider ------------>
	</div>

	<div class="main">
		<div class="wrap">
			<div class="section group">
				<div class="listview_1_of_3 images_1_of_3 event_grid">
					<a href="events/">
						<div class="listimg listimg_1_of_2">
							<img src="images/event_1.jpg" alt="" />
						</div>
						<div class="text list_1_of_2">
							<div class="date">
								<figure>
									<span>Gallery</span></figure>
							</div>
						</div>
					</a>
				</div>
				<div class="listview_1_of_3 images_1_of_3 event_grid">
					<a href="events/">
						<div class="listimg listimg_1_of_2">
							<img src="images/event_2.jpg" alt="" />
						</div>
						<div class="text list_1_of_2">
							<div class="date">
								<figure>
									<span>Gallery</span></figure>
							</div>
						</div>
					</a>
				</div>
				<div class="listview_1_of_3 images_1_of_3 event_grid">
					<a href="events/">
						<div class="listimg listimg_1_of_2">
							<img src="images/event_3.jpg" alt="" />
						</div>
						<div class="text list_1_of_2">
							<div class="date">
								<figure>
									<span>Gallery</span></figure>
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="content_bottom">
				<div class="section group">
					<div class="col_1_of_3 span_1_of_3 today_show">
						<h3>Today's Show</h3>
						<img src="images/today_show.jpg" alt="" />
						<h5>
							<span>31 March</span>
						</h5>
						<h5>sed do eiusmod tempor incididunt ut labore et dolore magna aliqua sed do eiusmod tempor incididunt ut labore et dolore
							magna aliqua. </h5>
						<a href="#" class="button">View More</a>
					</div>
					<div class="col_1_of_3 span_1_of_3">
						<h3>New Tracks</h3>
						<div class="track_list">
							<ul>
								<li>
									<a href="#">consectetur adipisicing elit</a>
								</li>
								<li>
									<a href="#">sed do eiusmod tempor incididunt</a>
								</li>
								<li>
									<a href="#">labore et dolore magna aliqua.</a>
								</li>
								<li>
									<a href="#">sed do eiusmod tempor</a>
								</li>
								<li>
									<a href="#">abore et dolore magna</a>
								</li>
								<li>
									<a href="#">incididunt ut labore et dolore</a>
								</li>
								<li>
									<a href="#">dolore magna aliqua</a>
								</li>
								<li>
									<a href="#">adipisicing elit, sed do eiusmod</a>
								</li>
								<li>
									<a href="#">incididunt ut labore et dolore</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="col_1_of_3 span_1_of_3">
						<h3>Latest Videos</h3>
						<a href="#">
							<img src="images/videos.jpg" alt="" />
						</a>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. </p>
						<a href="#" class="button">See All</a>
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
function isDateSelected(){
      var today =new Date();
      var inputDate = new Date(document.searchForm.arr_date.value);
      if (inputDate.value == " "){
          return false;
      } else if (inputDate > today) {
          return true;
      } else {
          return false;
      }
  }

  if (isDateSelected() === false) {
      alert("Please enter a valid Arrival Date");
      searchForm.arr_date.focus();
      return false;
  } else {
      return true;
  }

	function isDateSelected1(){
	      var today =new Date();
	      var inputDate = new Date(document.searchForm.dep_date.value);
	      if (inputDate.value == " "){
	          return false;
	      } else if (inputDate > today) {
	          return true;
	      } else {
	          return false;
	      }
	  }

	  if (isDateSelected1() === false) {
	      alert("Please enter a valid Departure Date");
	      searchForm.dep_date.focus();
	      return false;
	  } else {
	      return true;
	  }


</script>
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


var timepicker = new TimePicker('time1', {
  lang: 'en',
  theme: 'dark'
});
timepicker.on('change', function(evt) {

  var value = (evt.hour || '00') + ':' + (evt.minute || '00');
  evt.st_time.value = value;

});
</script>
<script>
function capitalize(textboxid, input) {
    var CapitalizeWords = input[0].toUpperCase();
    for (var i = 1; i <= input.length - 1; i++) {
        let currentCharacter,
            previousCharacter = input[i - 1];
        if (previousCharacter && previousCharacter == ' ') {
            currentCharacter = input[i].toUpperCase();
        } else {
            currentCharacter = input[i];
        }
        CapitalizeWords = CapitalizeWords + currentCharacter;
    }
      document.getElementById(textboxid).value = CapitalizeWords;
}


var timepicker = new TimePicker('time', {
  lang: 'en',
  theme: 'dark'
});
timepicker.on('change', function(evt) {

  var value = (evt.hour || '00') + ':' + (evt.minute || '00');
  evt.element.value = value;

});


</script>

