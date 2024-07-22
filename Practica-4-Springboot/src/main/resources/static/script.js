let submit_button = document.getElementById("submit_button");
let find_data_button = document.getElementById("find_data_button");

submit_button.addEventListener(
  "click",
  (postClientData = async () => {
    //Obtenemos los datos del formulario
    let input_id = document.getElementById("input_id").value;
    let input_name = document.getElementById("input_name").value;
    let input_email = document.getElementById("input_email").value;
    let input_dob = document.getElementById("input_dob").value;
    let input_age = document.getElementById("input_age").value;
    let input_username = document.getElementById("user-name").value;
    let input_password = document.getElementById("user-pass").value;

    //Ahora debemos de hacer un fetch de contactos ?
    let request = await fetch("/setMiembros", {
      method: "POST",
      credentials: "same-origin",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        id: parseInt(input_id),
        name: input_name,
        email: input_email,
        dateOfBirth: input_dob,
        age: parseInt(input_age),
        username: input_username,
        password: input_password,
      }),
      dataType: "json",
    });

    if (request.ok) {
      console.log("Success!");
    }
  })
);


find_data_button.addEventListener("click", getClientData = async () => {
    let get = await fetch("/getMiembros", {
      method: "GET",
      credentials: "same-origin",
      dataType: "json",
    });
    if (get.ok) {
      var data = await get.json();
      console.log(data.email);
      var idIn = data.id;
      var nameIn = data.name;
      var emailIn = data.email;
      var dateOfBirthIn = data.dateOfBirth.toString();
      var ageIn = data.age;
      var usernameIn = data.username;
  
      document.getElementById("idIn").innerHTML = idIn;
      document.getElementById("nameIn").innerHTML = nameIn;
      document.getElementById("dateOfBirthIn").innerHTML = dateOfBirthIn;
      document.getElementById("ageIn").innerHTML = ageIn;
      document.getElementById("usernameIn").innerHTML = usernameIn;
      document.getElementById("emailIn").innerHTML = emailIn;
    }
  }
  );

/*
var sub, user, pass, mainContent, loggedIn;
var loggedIn = document.querySelector('.logged-in')

function _(x) {
  return document.getElementById(x);
}

sub = _('submit');
user = _('user-name');
pass = _('user-pass');
mainContent = _('main');
loggedIn = _('logged-in');

sub.addEventListener('click', login);

function login(event) {
  event.preventDefault();
  var userValue = user.value;
  var passValue = pass.value;
  
  if (userValue.length >= 3 && passValue.length >= 3) {_
      mainContent.classList.add('login-true');
      loggedIn.style.display = 'block';
      loggedIn.innerHTML = '<h2>Welcome, ' + userValue + '</h2>';
   } else {
     alert('Username and Password must contain at least 3 characters.')
   }
}*/
