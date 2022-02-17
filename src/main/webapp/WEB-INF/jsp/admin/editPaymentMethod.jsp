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
           text-align: center;
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
                                           <li class="breadcrumb-item"><a href="/admin_homepage">Dashboard</a></li>
                                           <li class="breadcrumb-item active">Payment</li>
                                       </ol>
                                   </div>
                               </div>
                           </div>
                           <!-- /# column -->
                       </div>
                       <!-- /# row -->

                       <section id="main-content">
                            <h2 class="center">Update Payment</h2>
                            <br>
                            <form method="POST" action="/editPaymentMethod">
                          
                           <section class="center">
                               <div>
                                   <div>
                                       <div>
                                       <c:forEach items="${getPaymentNameWithParticularId}" var="list">
                                           <input type="hidden" name="editPaymentId" value="${list.paymentId}">
                                           <lable>Payment Name :</lable>
                                           <input type="text" name="paymentname" id="paymentname" placeholder="Enter Payment Name" value="${list.paymentName}" onfocus="this.select();" onkeyup="javascript:capitalize(this.id, this.value);" autofocus>
                                           </tr>
                                           </c:forEach>
                                         </div>
                                       <br>
                                       <div>
                                           <input type="submit" name="editPaymentMethod" Value="Submit">
                                         <button>  <a href="/paymentMethod" style="text-decoration: none;">Back</a> </button>
                                       </div>

                                   </div>
                               </div>
                               
                             </section>
                            </form>


   					              	
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


    <script type="text/javascript">
    // capitalize first name and last name
      function capitalize(textboxid, str) {
          // string with alteast one character
          if (str && str.length >= 1)
          {
              var firstChar = str.charAt(0);
              var remainingStr = str.slice(1);
              str = firstChar.toUpperCase() + remainingStr;
          }
          document.getElementById(textboxid).value = str;
      }
      </script>
