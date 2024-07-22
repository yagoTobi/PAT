let submit_button = document.getElementById("submit_button");

submit_button.addEventListener("click",
    (logInStandard = async () => {
        let email = document.getElementById("e_mail").value;
        let password = document.getElementById("password").value;

        if (email == null || email == '') {
            alert("Porfavor inserte su correo");
        } else if (password == null || password == '') {
            alert("Porfavor inserte una contraseña");
        } else {

            //Nos metemos en el user-controller para observar hasta donde hacemos el Get 
            let link = "/api/v1/userMembers/" + email;
            console.log(link);

            let request = await fetch(link, {
                method: "GET",
            }).catch(console.error);

            if (request.ok) {
                data = await request.json();
                console.log(data);
            }

            if (request.ok) {

                //console.log("Parametros que enviamos");
                //console.log(email);
                //console.log(password);

                //console.log("Parametros de comparacion");
                //console.log(data.email);
                //console.log(data.password);


                if (data[0].email == email && data[0].password == password) {
                    console.log("User Exists... Redirecting")
                    let url = "/users.html";
                    window.location.href = url;
                }else{
                    console.log("Fail, somethings up!");
                }
            }
        }
    }))