<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 <!DOCTYPE html>
 <html>

 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My Booking</title>
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
         
<c:forEach items="${allReservationHallOfParticular}" var="list">
        <div id="${list.reservId }">
     <div align="center">
         <table width="600" border="1" bordercolor="99CCFF">
             <tbody>
                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="center">
                             <p class="style3">${list.hallName } </p>
                         </div>
                     </td>
                 </tr>
                 <tr>
                 <c:set var="path" value="images\\hallImageDB\\"/>
                  <c:set var="pathWithImageName" value= "${path}${list.hallImageName}" />
                     <td colspan="5" bordercolor="99CCFF" bgcolor="99CCFF"><img src="${pathWithImageName }" alt="Hall" width="700" height="250">
                     </td>

                   </tr>
                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="99CCFF">
                         <!-- <div align="left">
                              Thank you for choosing The Hall. We are delighted to confirm the following reservation. Should you require further assistance, please contact our Reservations department via return e-mail or by calling the number listed
                             below.<br>
                         </div> -->
                     </td>
                 </tr>
                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="#FFC977">
                         <div align="left"><strong>Hall Details:</strong></div>
                     </td>

                 </tr>

                                      <td bordercolor="99CCFF" bgcolor="99CCFF">
                                          <div align="left"><span class="style4">Order ID</span></div>
                                      </td>
                                      <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.orderNo }&nbsp;</td>
                                  </tr>
                                  <tr>
                                      <td width="121" bordercolor="99CCFF" bgcolor="99CCFF">
                                          <div align="left"><span class="style4">Your's Name</span></div>
                                      </td>
                                      <td width="473" colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.userName }&nbsp;</td>
                                  </tr>
                                  <tr>
                                      <td width="121" bordercolor="99CCFF" bgcolor="99CCFF">
                                          <div align="left"><span class="style4">Your's Adhar no.</span></div>
                                      </td>
                                      <td width="473" colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.userAdhar }&nbsp;</td>
                                  </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Hall Name</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.hallName }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Hall Type</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.categoryName }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Place</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.hallPlace }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">City</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.cityName }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Your Hall Arrival Date</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.arrivalDate }&nbsp;</td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Your Hall Departure Date</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.departureDate }&nbsp;</td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Payment Method</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.paymentName }&nbsp;</td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">No Of Seat</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.hallSeat }&nbsp;</td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Hall Price</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">${list.hallPrice }&nbsp;</td>
                 </tr>

                 <tr>
                     <td colspan="5" bordercolor="99CCFF" bgcolor="#FFC977">
                         <div align="left"><strong>Hall Policy:</strong></div>
                     </td>
                 </tr>
                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left" class="style4">Hall Check-in time</div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style5">10:00 am, Must be Carry on User's Adhar Card for verification. </span></div>
                     </td>
                 </tr>

                 <tr>
                     <td bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style4">Cancellation Policy</span></div>
                     </td>
                     <td colspan="4" bordercolor="99CCFF" bgcolor="99CCFF">
                         <div align="left"><span class="style5">1.If Adhar Card not brought then the hall will be CANCELLED.
                           <br> 2. More then 24 hours before check-in date: FREE CANCELLATION.
                           <br> 3. If you not come in Check-in time then After 12.00 pm  the hall will be Cancelled.
                         </span></div>
                     </td>
                 </tr>
             </tbody>
         </table>
     </div>
	 </div><!-- printable area close-->
<div style="text-align:center">
  <a href="/"class="ghf">BACK</a>
  <a href="javascript:void(0)" onclick="printDiv('${list.reservId }')" class="ghf">Print<a>
     <a href="javascript:void(0)"class="ghf" onclick="chk('${list.reservId }')">Cancel Hall</a>
<!-- <a href="javascript:void(0)" onclick="printDiv('printableArea')" class="ghf">Print<a> -->
</div>
<p style="color:red;">-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
</c:forEach>

</body>
</html>
<script>
function chk(val){
  var result = confirm("Are you want to Cancel This Hall ?");
  if(result){
     location.href="/cancelReservedHall?id="+val;
  }
}
</script>
 <script>
 function printDiv(divName) {
      var printContents = document.getElementById(divName).innerHTML;
      var originalContents = document.body.innerHTML;

      document.body.innerHTML = printContents;

      window.print();

      document.body.innerHTML = originalContents;
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
 </script>
tml>