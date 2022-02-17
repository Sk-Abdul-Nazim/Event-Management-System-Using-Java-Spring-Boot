<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    


<html>
    <title>Hall</title>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">

	
   <style>
.dropbtn {
  background-color: grey;
  color: white;
  padding: 6px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: white;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: grey;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}
.right {
  margin-left:1143px;
}
.dropdown-content a:hover {background-color: grey;color:white}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: grey;}
</style>
   <style>
    .center {
          margin: auto;
          width: 8%;
          border: 3px solid #73AD21;
          padding: 10px;
}

   </style>

 <style>
    table, th, td {
       border: 1px solid black;
       margin-right:auto;
       margin-left:auto;
     }
     th, td {
           padding: 10px;
      }

 </style>
<jsp:include page="../includes/commonStyleIncludes.jsp" /> 
</head>

    <body>
    
<% if (session.getAttribute("loggedAdmin") == null) {
	
	response.sendRedirect("/adminLogin");
} else{
	%>
    

	<jsp:include page="../includes/left_nav.jsp" />

		<jsp:include page="../includes/heading.jsp" />


	<div class="content-wrap">
            <div class="main">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-8 p-r-0 title-margin-right">
                            <div class="page-header">
                                <div class="page-title">
                                    <h1>Hello, <span>Welcome Here</span></h1>
                                </div>
                            </div>
                        </div>
                        <!-- /# column -->
                        <div class="col-lg-4 p-l-0 title-margin-left">
                            <div class="page-header">
                                <div class="page-title">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.php">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Booked Hall</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                        <div class="dropdown right">
                           <button class="dropbtn">Sort</button>
                           <div class="dropdown-content">
                           <a href="sortingHallName.php?shname=sort">By Name</a>
                           <a href="sortingHallName.php?shplace=sortPlace">By Place Name</a>
                           <a href="sortingHallName.php?shcity=sortCity">By City Name</a>
                           </div>
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->

                    <section id="main-content">
                         <h2 style="text-align:center">Booked Hall</h2>
                         <br>
                           <table>


                              <tr>
                                <th> # </th>
                                <th> Hall Name </th>
                                <th> Hall Type </th>
                                <th> Place </th>
                                <th> City </th>
                                <th> No. of Seat</th>
                                <th> Price </th>
                                <th> Date </th>
                                <th> Time </th>
                                <th> Availability </th>
                                <th> Image </th>
                                <th> Action </th>

                              </tr>
                             
                           <%int count=0; %>
                           <c:forEach items="${allBookedHall}" var="list">

                            <tr>
                              <tr>
                             <td><% count=count+1;
                                       out.println(count);%></td>
                              <td>${list.hallName}</td>
                              <td>${list.hallCategoryName}</td>
                              <td>${list.hallPlace}</td>
                              <td>${list.hallCityName}</td>
                              <td>${list.hallSeat}</td>
                              <td>${list.hallPrice}</td>
                              <td>${list.hallDate}</td>
                              <td>${list.hallTime}</td>
                              <td>${list.getHallAvailability()}</td>
                              
                            
                             
                             
                             
                              
                               <c:set var="path" value="images\\hallImageDB\\"/>
                                <c:set var="pathWithImageName" value= "${path}${list.hallImage}" />
                                
                                 <c:set var="fullPath" value="E:\\Spring Suite 4 Projects\\EMS\\src\\main\\resources\\static\\images\\hallImageDB\\"/>
                               <c:set var="fullPathWithImageName" value= "${fullPath}${list.hallImage}" />
                              
                              <td><a href="${fullPathWithImageName}" target="_blank"><img src="${pathWithImageName}" alt="HTML5 Icon" style="width:128px;height:100px" /></a></td> 


                              <td>
                              <a style="text-decoration:none" href="javascript:void(0);" onclick="chk('${list.hallId}');">Activate</a>
                                </td>
                            </tr>
                            
                             </c:forEach>

                            </table>

                       

                            <br>
                           

					              	 <jsp:include page="../includes/footerAdmin.jsp" />

                    </section>
                </div>
            </div>
        </div>

		 
		 <jsp:include page="../includes/commonheaderJsIncludes.jsp" />
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
<script>
function chk(val){
 var result =confirm("Are u want to activete this hall ?");
 if(result){
   location.href="/activatedHall?id="+val;
 }

}
</script>
  