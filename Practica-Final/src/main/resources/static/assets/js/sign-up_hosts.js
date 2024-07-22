let submit_button = document.getElementById("submit_button");

submit_button.addEventListener("click",
    (postNewUser = async () => {
        let e_mail = document.getElementById("e_mail").value;
        let password = document.getElementById("password").value;
        let hourlyRate = document.getElementById("hourly_rate").value;
        let numberHosted = document.getElementById("number_hosted").value;
        let identification = document.getElementById("identification").value;

        if (e_mail == null || e_mail == '') {
            alert("Porfavor inserte su correo");
        } else if (password == null || password == '') {
            alert("Porfavor inserte una constraseña");
        } else if (hourlyRate == null || hourlyRate == '') {
            alert("Porfavor inserte su precio por hora");
        } else if (numberHosted == null || numberHosted == '') {
            alert("Porfavor inserte el número de clientes que puedes tener");
        } else if (identification == null || identification == '') {
            alert("Porfavor inserte su DNI, pasaporte o carnet de identificación");
        }
        else {

            //Verificamos si es un usuario completamente nuevo o si coincide con un UserId ya creado 
            let link = "/api/v1/userMembers/" + e_mail;
            console.log(link);

            let request1 = await fetch(link, {
                method: "GET",
            }).catch(console.error);

            if (request1.ok) {
                data = await request1.json();
                console.log(data);

                //Comprobar que la contraseña sea igual que la del userId
                let request2 = await fetch("/api/v1/hostMembers", {
                    method: 'POST',
                    credentials: "same-origin",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        userId: data[0].userId,
                        hourlyRate: hourlyRate,
                        numberHosted: numberHosted,
                        identification: identification
                    }), dataType: "json"
                })

                if (request2.ok) {
                    console.log("Success!");
                    console.log(await request2.json());
                }
            }
        }

    }))