<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 <!DOCTYPE html>
 <html>

 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Booking Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <meta content="text/html; charset=iso-8859-1" http-equiv="Content-Type">
		 <style>
		         .b{
		                padding: 2cm 2cm 2cm 2cm !important;
		                background-image: url('images/bg.jpg');
	             }

             .ghf {
                 background-color: white;
                 border: 1px solid black;
                 color: black;
                 padding: 2px 10px;
                 text-align: center;
                 display: inline-block;
                 font-size: 15px;
                 margin: 5px 20px;
                 cursor: pointer;
                 text-decoration:none;

                 padding-top: 10px;
                 padding-right: 10px;
                  padding-bottom:10px;
                 padding-left: 10px;
             }

     </style>
 </head>

 <body class="b">
     <div align="center">
       <form action="/userPaymentMethod" method="POST">
         <c:forEach items="${eventsHallDetails}" var="list">
       
         <input type="hidden" name="hallId" value="${list.hallId }">
          <input type="hidden" name="catId" value="${list.hallCategoryId }">
           <input type="hidden" name="citId" value="${list.hallCityId }">
         <input type="hidden" name="arr_date" value="${list.hallArrDate }">
         <input type="hidden" name="dep_date" value="${list.hallDepDate }">
          <!-- <input type="hidden" name="payment" value="<?php //echo $payment_id;?>"> -->


         <table width="600" border="1" bordercolor="99CCFF">
             <tbody>
                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="center">
                             <p class="style3" style="font-weight:bold">${list.hallName} Details</p>
                         </div>
                     </td>
                 </tr>
                 <tr>
                  <c:set var="path" value="images\\hallImageDB\\"/>
                  <c:set var="pathWithImageName" value= "${path}${list.hallImage}" />
                     <td colspan="5" bordercolor="99CCFF" bgcolor="99CCFF"><img src="${pathWithImageName }" alt="Hall" width="700" height="250">
                     </td>

                   </tr>
                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left">
                              Thank you for choosing The Hall. We are delighted to confirm the following reservation. Should you require further assistance, please contact our Reservations department via return e-mail or by calling the number listed
                             below.<br>
                         </div>
                     </td>
                 </tr>
                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="#FFC977">
                         <div align="left"><strong>Hall Details:</strong></div>
                     </td>

                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4" style="font-weight:bold">Hall Name</span></div>
                     </td>
                     <b><td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF" style="font-weight:bold">${list.hallName }&nbsp;</td></b>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4" style="font-weight:bold">Hall Type</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF" style="font-weight:bold">${list.hallCategoryName }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4" style="font-weight:bold">Place</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF" style="font-weight:bold">${list.hallPlace }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">City</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.hallCityName }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Your Hall Arrival Date</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.hallArrDate }&nbsp;</td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Your Hall Departure Date</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.hallDepDate }&nbsp;</td>
                 </tr>

                 <!-- <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Payment Method</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF"><?php //echo $rowp['payment_name'];?>&nbsp;</td>
                 </tr> -->
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4" style="font-weight:bold">No Of Seat</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF" style="font-weight:bold">${list.hallSeat }&nbsp;</td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4" style="font-weight:bold">Hall Price</span></div>
                     </td>
                     <c:set var="result" value="${list.hallPrice * totalDay}"/>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF" style="font-weight:bold">${list.hallPrice} * ${totalDay } days = ${result}&nbsp;</td>
                 </tr>

                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="#FFC977">
                         <div align="left"><strong>Hall Policy:</strong></div>
                     </td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left" class="style4" style="font-weight:bold">Hall Check-in time</div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style5" style="font-weight:bold">10.00 am, Adhar Card must be required in checking time for verification. </span></div>
                     </td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Cancellation Policy</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style5">1.If Adhar Card not brought in Check-in time then the hall will be CANCELLED.
                           <br> 2. More then 24 hours before check-in date: FREE CANCELLATION.
                           <br> 3. If you not come in Check-in time then After 12.00 pm  the hall will be Cancelled.
                         </span></div>
                     </td>
                 </tr>
                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="#FFC977">
                         <div align="left"><strong>For Any Query Contact Us:</strong></div>
                     </td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left" class="style4">Mobile No.</div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style5">+919749471818</span></div>
                     </td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left" class="style4">Email ID</div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style5">sknazim4749@gmail.com</span></div>
                     </td>
                 </tr>
             </tbody>
         </table>
          
<div style="text-align:center">
  <a href="/"class="ghf">BACK</a>
   <input type="submit" value="BOOK" name="" class="ghf">

</div>
</c:forEach>
         </form>
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
