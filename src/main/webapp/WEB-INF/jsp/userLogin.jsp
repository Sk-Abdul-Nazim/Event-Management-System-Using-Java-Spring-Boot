<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/styleLogin.css">
</head>

<body onload='document.signin.u_email.focus()'>

<!-- 
    elseif (isset($_SESSION['loggedin_search'])) 
     { 
     ?>
      <div class="main">

          <div class="container">
              <div class="signup-content">
                  <form method="POST" id="signin-form" class="signin-form" name="signin" onsubmit="return validateAgreeTerms(this)" action="loginDB.php">
                      <h2>Sign in </h2>
                      <?php
                           if(isset($_SESSION['loggedin_search']) && $_SESSION['loggedin_search'] !="") 
                         { 
                           echo '<span style="color:#B43104; font-family:courier;">'.$_SESSION['loggedin_search'].'</span>'; 
                           unset($_SESSION['loggedin_search']); 
                            } 
                     ?> 
                      <div class="form-group">
                          <input type="email" class="form-input" name="u_email" id="u_email" placeholder="Email" title="Please enter your email" onkeyup="ValidateEmail();" required/>
                          <span id="lblError"></span>
                      </div>
                      <div class="form-group">
                          <input type="password" class="form-input" name="password" id="password" placeholder="Password" required/>
                          <span toggle="#password" class="zmdi zmdi-eye-off field-icon toggle-password"></span>
                      </div>
                      <div class="form-group">
                            <label for="agree_term"><a href="../forgotPasswordUser.php" class="term-service">Forgot Password?</a></label>
                      </div>
                      <div class="form-group">
                          <input type="checkbox" name="agree_term" id="agree_term" class="agree_term" value="yes"/>
                          <label for="agree_term" class="label-agree_term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                          <div style="visibility:hidden; color:#F13535" id="agree_chk_error">
                               Can't proceed as you didn't agree to the terms!
                          </div>
                      </div>

                      <div class="form-group">
                          <input type="submit" name="login" id="submit" class="form-submit submit" value="Sign in"/>
                          <a href="../userRegistration/" class="submit-link submit">Sign up</a>
                            <a href="../" class="submit-link submit">Back</a>
                      </div>
                  </form>
              </div>
          </div>

      </div>

<?php } else{?> -->

  <div class="main">

      <div class="container">
          <div class="signup-content">
              <form method="POST" action="/login" id="signin-form" class="signin-form" name="login" onsubmit="return validateAgreeTerms(this)">
                  <h2>Sign in </h2>
                
                           <span style="color:red; font-family:courier;">${errorLoginMessageEmail }</span>
                       
                  <div class="form-group">
                      <input type="email" class="form-input" name="u_email" id="u_email" placeholder="Email" title="Please enter your email" onkeyup="ValidateEmail();" value="${errorLoginEmail }" required/>
                      <span id="lblError"></span>
                  </div>
                  <div class="form-group">
                      <input type="password" class="form-input" name="password" id="password" placeholder="Password" value="${errorLoginPassword }" required/>
                      <span toggle="#password" class="zmdi zmdi-eye-off field-icon toggle-password"></span>
                  </div>
                  <div class="form-group">
                        <label for="agree_term"><a href="#" class="term-service">Forgot Password?</a></label>
                  </div>
                  <div class="form-group">
                      <input type="checkbox" name="agree_term" id="agree_term" class="agree_term" value="yes"/>
                      <label for="agree_term" class="label-agree_term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                      <div style="visibility:hidden; color:#B43104" id="agree_chk_error">
                           Can't proceed as you didn't agree to the terms!
                      </div>
                  </div>

                  <div class="form-group">
                      <input type="submit" name="login" id="login" class="form-submit submit" value="Sign in"/>
                      <a href="/registerUser" class="submit-link submit">Sign up</a>
                        <a href="/" class="submit-link submit">Back</a>
                  </div>
              </form>
          </div>
      </div>

  </div>




    <!-- JS -->
    <script src="vendor/jquery/jqueryLogin.min.js"></script>
    <script src="js/mainLogin.js"></script>
    <script type="text/javascript" src="js/validate.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
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
