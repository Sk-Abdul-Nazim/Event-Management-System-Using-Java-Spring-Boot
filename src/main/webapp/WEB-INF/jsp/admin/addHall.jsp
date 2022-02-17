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
    .center {
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
                                    <h1>Hello, <span>Welcome Here </span><span style="color:red;"> ${errorImageFormat}</span></h1>
                                </div>
                            </div>
                        </div>
                    
                      
                        <div class="col-lg-4 p-l-0 title-margin-left">
                            <div class="page-header">
                                <div class="page-title">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="/addmin_homepage">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Hall</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->

                    <section id="main-content">
                  
                         <h2 class="center">Hall</h2>
                          <br>
                               <form method="POST" action="/addActiveHall" name="addActiveHall" enctype="multipart/form-data" > <!--id="frm"-->
                                  <section class="center">
                                      <div>
                                        <div>
                                           <div>
                                             <lable>Hall Name :</lable>
                                                   <input type="text" autocomplete="off" name="hallname" id="hallname" placeholder="Enter Hall Name" onkeyup="javascript:capitalize(this.id, this.value);" autofocus required/>
                                          </div>

                                          <br>
                                          <div>
                                           <lable>Hall Type</lable>
                                            <select class="selectpicker" name="category">
                                               
                                              <option>select</option>
                                              <c:forEach items="${dropDownCategory}" var="list">
                                              
                                                <option value="${list.id}">${list.name}</option>

                                              </c:forEach>
                                            </select>
                                          </div>

                                        <br>
                                          <div>
                                            <lable>Place :</lable>
                                                  <input type="text" autocomplete="off" name="hallplace" id="hallplace" placeholder="Enter Hall Place" onkeyup="javascript:capitalize(this.id, this.value);" required/>
                                         </div>

                <br>

                                         <div>
                                          <lable>City</lable>
                                           <select class="selectpicker" name="city">
                                             <option>select</option>
                                              <c:forEach items="${dropDownCity}" var="list1">
                                              
                                               <option value="${list1.id }">${list1.name }</option>

                                             </c:forEach>
                                           </select>
                                         </div>

  <br>
                                          <div>
                                              <lable>No. of Seat :</lable>
                                                      <input type="number" autocomplete="off" name="hallseat" id="hallseat" placeholder="Enter Hall Seat" required/>
                                          </div>
                                          <br>
                                         <div>
                                           <lable>Price :</lable>
                                                 <input type="number" autocomplete="off" name="hallprice" id="hallprice" placeholder="Enter Hall Price"  required/>
                                        </div>
<br>
                                        <div>
                                           <lable>Hall Availability :</lable>
                                           <select class="selectpicker" name="avl">
                                             <option>YES</option>
                                             <option>NO</option>
                                           </select>
                                        </div>
<br>
                                        <div>
                                            <lable>Hall Image :</lable>
                                              <input type="file" name="file">
                                        </div>
                                         <br>
                                       <div>
                                             <input type="submit" name="addHall" Value="Submit">
                                            <button>  <a href="/activeHall" style="text-decoration: none;">Back</a> </button>
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
</script>
