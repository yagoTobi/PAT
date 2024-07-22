let submit_button = document.getElementById("submit_button");

submit_button.addEventListener("click",
    (postNewHost = async () => {
        let email = document.getElementById("e_mail").value;
        let password = document.getElementById("password").value;

        if (email == null || email == '') {
            alert("Porfavor inserte su correo");
        } else if (password == null || password == '') {
            alert("Porfavor inserte una constraseña");
        } else {

            let link = "/api/v1/userMembers/" + email;
            console.log(link);

            let request1 = await fetch(link, {
                method: "GET",
            }).catch(console.error);

            if (request1.ok) {
                data = await request1.json();

                console.log(data[0].email);
                console.log(email);
                console.log(data[0].password);
                console.log(password);

                if (data[0].email == email && data[0].password == password) {
                    let url = "/hosts.html";
                    window.location.href = url;
                }
            }
        }
    }))