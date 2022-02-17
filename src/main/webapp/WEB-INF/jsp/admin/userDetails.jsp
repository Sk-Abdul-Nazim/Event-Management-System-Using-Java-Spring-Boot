<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <title>User Details</title>
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
        text-align: center;
}

.dot {
  height: 12px;
  width: 12px;
  background-color: green;
  border-radius: 50%;
  display: inline-block;
}
.dotRed {
  height: 12px;
  width: 12px;
  background-color: red;
  border-radius: 50%;
  display: inline-block;
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
                                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                        <li class="breadcrumb-item active">User Details</li>
                                    </ol>
                                </div>

                            </div>
                        </div>
                        <div class="dropdown right">
                           <button class="dropbtn">Sort</button>
                           <div class="dropdown-content">
                           <a href="sortingUserName.php?name=sort">By Name</a>
                           <a href="sortingUserName.php?date=sort">By Reg. Date</a>
                           </div>
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->

                    <section id="main-content">
                         <h2 class="center">User Details</h2>

                     <br>

                        <table>
                          <tr>
                            <th> # </th>
                            <th> User Name </th>
                            <th> User Address </th>
                            <th> User Phone No </th>
                            <th> User Adhar No </th>
                            <th> User Email ID</th>
                            <th> Password</th>
                            <th> User Reg. Date </th>
                            <th> User Reg. Time </th>
                            <th> User Running... </th>

                          </tr>
                      
     
                          <%int count=0; %>
                           <c:forEach items="${allUserDetails}" var="list">
									<tr>
										<td><% count=count+1;
                                       out.println(count);%></td>
                            <td>${list.userName}</td>
                            <td>${list.userAddress}</td>
                            <td>${list.userPhoneNo}</td>
                            <td>${list.userAddharNo}</td>
                            <td>${list.userEmailId}</td>
                            <td>${list.userPassword}</td>
                            <td>${list.userDate}</td>
                            <td>${list.userTime}</td>

                            <c:choose>
                                <c:when test="${list.userActive == '1'}">
                                    <td><span class="dot"></span></td>
                                </c:when>

                                <c:otherwise>
                                    <td><span class="dotRed"></span></td>
                                </c:otherwise>
                           </c:choose>

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

