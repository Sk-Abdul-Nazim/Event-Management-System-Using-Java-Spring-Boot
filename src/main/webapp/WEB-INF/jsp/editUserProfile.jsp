<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                                  

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/styleRegistration.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

</head>

                                 
<body onload='document.registerUser.u_name.focus()' id="user-availability-status" >
    <div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
           <c:forEach items="${updateUserProfile }" var="list">
                    <form method="POST" action="/editUserProfile" id="signup-form" class="signup-form" name="registerUser"  onsubmit="return validateAgreeTerms(this)">
                        <h2 class="form-title">Update account</h2>
                        <div class="form-group">
                            <input type="text" class="form-input" name="emailId" id="email" placeholder="" autocomplete="off" title="Please enter your new password" value="Your EmailID: ${list.userEmailId }" readonly/>
                           
                          
                        </div>
                     <div class="form-group">
                            <input type="text" class="form-input" name="old_password" id="password1" placeholder="Old Password" autocomplete="off" title="Please enter your new password" value="Old Password: ${list.userPassword }" readonly/>
                           
                          
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="Password" autocomplete="off" title="Please enter your new password" required/>
                            <span toggle="#password" class="zmdi zmdi-eye-off field-icon toggle-password"></span>
                            <span id="password_strength"></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="confirmpassword" id="confirm_password" placeholder="Repeat your password" autocomplete="off" title="Please enter your new password" required/>
                            <span id='message'></span>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree_term" id="agree_term" class="agree_term" value="yes"/>
                            <label for="agree_term" class="label-agree_term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            <div style="visibility:hidden; color:red" id="agree_chk_error">
                                 Can't proceed as you didn't agree to the terms!
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="submit" name="updateUser" id="registration" class="form-submit" value="Update"/>
                        </div>
                    </form>
			           		<p class="loginhere">
                       <a href="/userProfile" class="loginhere-link">Back</a>
                    </p>
                    </c:forEach>
                </div>
            </div>
        </section>
    </div>

    <!-- JS -->
    <script src="vendor/jquery/jqueryRegistration.min.js"></script>
    <script src="js/mainRegistration.js"></script>
    <script type="text/javascript" src="js/validate.js"></script>

</body>
                                    
</html>
                           
<script type="text/javascript">

  function validateAgreeTerms(form)
  {
      console.log("checkbox checked is ", form.agree_term.checked);
      if(!form.agree_term.checked)
      {
          document.getElementById('agree_chk_error').style.visibility='visible';
          return false;
      }
      else
      {
          document.getElementById('agree_chk_error').style.visibility='hidden';
          return true;
      }
  }


// capitalize first Character of each word
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

<script type="text/javascript">
    $(function () {
        $("#password").bind("keyup", function () {
            //TextBox left blank.
            if ($(this).val().length == 0) {
                $("#password_strength").html("");
                return;
            }

            //Regular Expressions.
            var regex = new Array();
            regex.push("[A-Z]"); //Uppercase Alphabet.
            regex.push("[a-z]"); //Lowercase Alphabet.
            regex.push("[0-9]"); //Digit.
            regex.push("[$@$!%*#?&]"); //Special Character.

            var passed = 0;

            //Validate for each Regular Expression.
            for (var i = 0; i < regex.length; i++) {
                if (new RegExp(regex[i]).test($(this).val())) {
                    passed++;
                }
            }


            //Validate for length of Password.
            if (passed > 2 && $(this).val().length > 8) {
                passed++;
            }

            //Display status.
            var color = "";
            var strength = "";
            switch (passed) {
                case 0:
                case 1:
                    strength = "Weak";
                    color = "red";
                    break;
                case 2:
                    strength = "Good";
                    color = "darkorange";
                    break;
                case 3:
                case 4:
                    strength = "Strong";
                    color = "green";
                    break;
                case 5:
                    strength = "Very Strong";
                    color = "darkgreen";
                    break;
            }
            $("#password_strength").html(strength);
            $("#password_strength").css("color", color);
        });
    });
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
