<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">

 $.get("reservation.jsp", function(data) {
    if(data !== null && data.length > 0 && data === 1) {
        // refresh this page
        document.location = document.location.href;
    }
 });
 </script>

 <html>
     <title>Reservation Details</title>
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

 .dropdown-content a:hover {background-color: grey;color:white}

 .dropdown:hover .dropdown-content {display: block;}

 .dropdown:hover .dropbtn {background-color: grey;}
 </style>
    <style>


 .right {
   margin-left:1143px;
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
                                         <li class="breadcrumb-item"><a href="index.php">Dashboard</a></li>
                                         <li class="breadcrumb-item active">Reservation</li>
                                     </ol>
                                 </div>

                             </div>
                         </div>
                      
                         <!-- /# column -->
                     </div>
                     <!-- /# row -->

                     <section id="main-content">
                          <h2 style="text-align:center">Reservation</h2>

<br>

      <table id="tblCustomers">
        <tr>
              <th> # </th>
              <th>  Order ID </th>
              <th>  User Name </th>
              <th>  User Email ID </th>
              <th>  User Phone No. </th>
              <th>  User Adhar No. </th>
              <th>  User Address </th>
              <th> Hall Name </th>
              <th> Hall Type </th>
         	  <th> Hall Place </th>
          	  <th> City </th>

         	  <th> Hall Arrival Date </th>
        	  <th> Hall Departure Date </th>
         	  <th>  Hall Seat </th>
         	  <th>  Hall Price </th>
        	  <th>  Payment Method </th>
       	      <th>  Book Date </th>
      	      <th>  Book Time </th>
   	          <th>  Action </th>

        </tr>

                          <%int count=0; %>
                           <c:forEach items="${allReservationHall}" var="list">

                            <tr>
                             <td><% count=count+1;
                                       out.println(count);%></td>
                              <td>${list.orderNo}</td>
                              
                               <td>${list.userName}</td>
                                <td>${list.userEmail}</td>
                                 <td>${list.userPhone}</td>
                                  <td>${list.userAdhar}</td>
                                   <td>${list.userAddress}</td>
                                   
                                    <td>${list.hallName}</td>
                                     <td>${list.categoryName}</td>
                                      <td>${list.hallPlace}</td>
                                       <td>${list.cityName}</td>
                                        <td>${list.arrivalDate}</td>
                                         <td>${list.departureDate}</td>
                                          <td>${list.hallSeat}</td>
                                           <td>${list.hallPrice}</td>
                                            <td>${list.paymentName}</td>
                                             <td>${list.bookedDate}</td>
                                              <td>${list.bookedTime}</td>
                                             

          <td><a style="text-decoration:none" href="javascript:void(0);" onclick="chk('${list.reservId}');">Clean</a></td>
 
      </tr>
      </c:forEach>  
      
    </table>
    <br>
    <div>
    <button id="btnExport" style="text-align:center; padding-left:4px;">Export to Excel</button>
  </div>

                           

                             <br>

 					              	 <jsp:include page="../includes/footerAdmin.jsp" />

                    </section>
                </div>
            </div>
        </div>

		 
		 <jsp:include page="../includes/commonheaderJsIncludes.jsp" />
<%} %>
     <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
     <script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>

</body>
</html>
       <script type="text/javascript">
         $(function () {
             $("#btnExport").click(function () {
                 $("#tblCustomers").table2excel({
                     filename: "Reservation Table.xls"
                 });
             });
         });
     </script>
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
  var result =confirm("Are u want to delete ?");
  if(result){
    location.href="/deleteReservationHall?id="+val;
  }

 }
 </script>
