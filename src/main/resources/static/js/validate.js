

$('#password, #confirm_password').on('keyup', function () {
  if ($('#password').val() == $('#confirm_password').val()) {
    $('#message').html('Matching').css('color', 'green');
  } else
    $('#message').html('Not Matching').css('color', 'red');
});

// Validate Email
function ValidateEmail() {

      var red = "#B43104";
      var green = "#04B431";
      var email = document.getElementById("u_email").value;
      var lblError = document.getElementById("lblError");
      lblError.innerHTML = "";
      var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
      if (!expr.test(email)) {
        lblError.style.color = red;
          lblError.innerHTML = "Invalid email address.";
      }
      else{
        lblError.style.color = green;
        lblError.innerHTML = "Valid email address";
      }

  }




function PhoneCheck(){
            $('#u_phone').keypress(function(e) {
                var a = [];
                var k = e.which;

                for (i = 48; i <= 57; i++)
                    a.push(i);

                if (!(a.indexOf(k)>=0))
                    e.preventDefault();
            });
        }

function AdharCheck(){
      $('#u_adhar').keypress(function(e) {
          var a = [];
          var k = e.which;

          for (i = 48; i <= 57; i++)
              a.push(i);

          if (!(a.indexOf(k)>=0))
              e.preventDefault();
            });
        }
// Name in uppercase
// function myFunction() {
//
//   var x = document.getElementById("firstname");
//   x.value = x.value.toUpperCase();
//   var badColor = "#FF3333";
//   var green = "#00CC00";
//   var msg = document.getElementById('msg');
//   var charactersOnly = document.getElementById('firstname').value;
//   if (charactersOnly.search(/^[a-zA-Z]+$/) === -1)
//   {
//     msg.style.color = badColor;
//     msg.innerHTML = "Enter Only Character ";
//       }
//       else{
//         msg.style.color = green;
//         msg.innerHTML = "Valid Name";
//       }
//
// }

// // Name in uppercase
// function myFunction1() {
//   var x = document.getElementById("lastname");
//   x.value = x.value.toUpperCase();
//   var badColor = "#FF3333";
//   var green = "#00CC00";
//   var msg = document.getElementById('msg1');
//   var charactersOnly = document.getElementById('lastname').value;
//   if (charactersOnly.search(/^[a-zA-Z]+$/) === -1)
//   {
//     msg.style.color = badColor;
//     msg.innerHTML = "Enter Only Character ";
//       }
//       else{
//         msg.style.color = green;
//         msg.innerHTML = "Valid Name";
//       }
// }


$(document).ready(function(){
    $("#u_name").keypress(function(event){
      //var x = document.getElementById("firstname");
        //x.value = x.value.toUpperCase();
        var inputValue = event.which;
        // allow letters and whitespaces only.
        if(!(inputValue >= 65 && inputValue <= 122) && (inputValue != 32 && inputValue != 0)) {
            event.preventDefault();
        }
    });
});
