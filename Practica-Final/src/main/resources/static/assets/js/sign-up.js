let submit_button = document.getElementById("submit_button");

submit_button.addEventListener("click", 
    (postNewUser = async () => {
        let userName = document.getElementById("userName").value;
        let surname = document.getElementById("surname").value;
        let email = document.getElementById("e_mail").value;
        let password = document.getElementById("password").value;
        let password_confirmation = document.getElementById("password_repeat").value;
        let dob = document.getElementById("dob").value.toString();

        if(userName == null || userName == '')
        {
            alert("Porfavor inserte un nombre valido");
        }else if(surname == null || surname == '')
        {
            alert("Porfavor inserte un apellido");
        }else if(email == null || email == '')
        {
            alert("Porfavor inserte su correo");
        }else if(password == null || password == '')
        {
            alert("Porfavor inserte una constraseña");
        }else if(password_confirmation != password)
        {
            alert("Porfavor asegurese que coincidan las contraseñas");
        }else if(dob == null || dob == '')
        {
            alert("Porfavor inserte su fecha de nacimiento");
        }
        else 
        {
            let request = await fetch("/api/v1/userMembers", {
                method: 'POST',
                credentials: "same-origin", 
                headers: {
                    "Content-Type":"application/json"
                }, 
                body: JSON.stringify({
                    userName: userName, 
                    surname: surname, 
                    email: email,
                    password: password, 
                    dob:dob
                }), dataType:"json"
            })

            console.log(userName);

            if(request.ok)
            {
                alert("Usuario creado con exito!");
                console.log("Success!");
                console.log(await request.json());
                window.location.href = "/login.html";
            }
        }

    }))