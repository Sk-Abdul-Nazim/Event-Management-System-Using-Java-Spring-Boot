<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <title>Payment</title>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">

	 
   <style>
    .center {
          margin: auto;
          width: 7%;
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
                                        <li class="breadcrumb-item"><a href="/adminHomepage">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Payment</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->

                    <section id="main-content">
                         <h2 style="text-align:center">Payment</h2>
                         <br>
                           <table>

                      
                              <tr>
                                <th> ID </th>
                                <th> Payment Method </th>
                                <th> Date </th>
                                <th> Time </th>
                                <th> Action </th>
                              </tr>
                            
                          <%int count=0; %>
                           <c:forEach items="${allPayment}" var="list">
									<tr>
										<td><% count=count+1;
                                       out.println(count);%></td>
										<td>${list.paymentName}</td>
										<td>${list.paymentDate}</td>
										<td>${list.paymentTime}</td>
										
										<td><a href="/editPaymentMethod?id=${list.paymentId}" >Edit</a>|
<%-- 										 <a href="/deleteCity?id=${list.cityId}">Delete</a></td>  --%>
										 <a href="javascript:void(0);" onclick="chk('${list.paymentId}');">Delete</a></td> 


									</tr>
								</c:forEach>
								
                            </table>

                            

                            <br>
                            <div class="center">
                            <a href="/addPaymentMethod" >Add Payment Method</a>
                          </div>

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
 var result =confirm("Are u want to delete ?");
 if(result){
   location.href="/deletePaymentMethod?id="+val;
 }

}
</script>
