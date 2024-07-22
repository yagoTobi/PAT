let button = document.getElementById("genTable");
let button_GetUser = document.getElementById("getUser");
let button_PostUser = document.getElementById("postUser");
let button_PutUser = document.getElementById("putUser");
let button_DeleteUser = document.getElementById("deleteUser");
let button_ShowJoin = document.getElementById("showJoin");

//Obtener tabla de los usuarios
button.addEventListener(
  "click",

  (getDatos = async () => {
    let request = await fetch("/api/v1/users", {
      method: "GET",
    }).catch(console.error);

    if (request.ok) {
      data = await request.json();

      document.getElementById("result").innerHTML = "";

      let table = document.createElement("table");

      //Numero de filas
      for (let i = 0; i < data.length; i++) {
        //Numero de columnas
        let row = document.createElement("tr");
        //No nos deja hacerlo mediante un bucle, asi que a manopla

        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);

        cell1.innerHTML = data[i].userId;
        cell2.innerHTML = data[i].userName;
        cell3.innerHTML = data[i].comment;

        table.appendChild(row);
      }

      document.getElementById("result").appendChild(table);
    }
  })
);

//Get Usuario
button_GetUser.addEventListener(
  "click",
  (getUsuario = async () => {
    let user_id = document.getElementById("userId").value;

    let link = "/api/v1/users/" + user_id;
    console.log(link);

    let request = await fetch(link, {
      method: "GET",
    }).catch(console.error);

    if (request.ok) {
      data = await request.json();
      document.getElementById("result").innerHTML = "";

      console.log(data);

      let table = document.createElement("table");
      let row = document.createElement("tr");
      var cell1 = row.insertCell(0);
      var cell2 = row.insertCell(1);
      var cell3 = row.insertCell(2);

      cell1.innerHTML = data.userId;
      cell2.innerHTML = data.userName;
      cell3.innerHTML = data.comment;

      table.appendChild(row);
      document.getElementById("result").appendChild(table);
    }
  })
);

//Post Usuario
button_PostUser.addEventListener(
  "click",
  (postUsuario = async () => {
    let userName = document.getElementById("userName").value;
    let comment = document.getElementById("comment").value;

    let request = await fetch("/api/v1/users", {
      method: "POST",
      credentials: "same-origin",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        //No he incluido el ID porque es un parametro IDENTITY QUE SE AÑADE SOLO
        comment: comment,
        userName: userName,
      }),
      dataType: "json",
    }).catch(console.error);

    if (request.ok) {
      console.log("Success!");
    }
  })
);

//Put Usuario
button_PutUser.addEventListener(
  "click",
  (putUsuario = async () => {
    let userId = document.getElementById("userId").value;
    let comment = document.getElementById("userComment").value;

    let request = await fetch("/api/v1/users/" + userId + "/" + comment, {
      method: "PUT",
      credentials: "same-origin",
      headers: {
        "Content-type": "application/json",
      },
      dataType: "json",
    }).catch(console.error);

    if (request.ok) {
      console.log("Success!");
    }
  })
);

//Delte Usuarios
button_DeleteUser.addEventListener(
  "click",
  (deleteUsuario = async () => {
    let userId = document.getElementById("userId").value;
    console.log("Hola!");
    let request = await fetch("/api/v1/users/" + userId, {
      method: "DELETE",
      credentials: "same-origin",
      dataType: "json",
    }).catch(console.error);

    if (request.ok) {
      console.log("Usuario borrado");
    }
  })
);

button_ShowJoin.addEventListener(
  "click",
  (getJoin = async () => {
    let link = "/api/v1/documents/join";

    let request = await fetch(link, {
      method: "GET",
    }).catch(console.error);

    if (request.ok) {
      data = await request.json();
      document.getElementById("result").innerHTML = "";

      let table = document.createElement("table");

      for(let i = 0; i < data.length; i++) {
        let row = document.createElement("tr");
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
  
        cell1.innerHTML = data[i].userId;
        cell2.innerHTML = data[i].userName;
        cell3.innerHTML = data[i].comment;
        cell4.innerHTML = data[i].docId;
        cell5.innerHTML = data[i].docContent;
        table.appendChild(row);
      }
      

      
      document.getElementById("result").appendChild(table);
    }
  })
);
