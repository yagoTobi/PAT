let submit_button = document.getElementById("submit_button");

submit_button.addEventListener(
  "click",
  (postNewCharger = async () => {
    //Planning: 1.- Caso en el que no este definido el cargador
    //          2.- Caso en el que no este definida la dir
    //          3.- Todo ok

    let chargerType =
      document.getElementById("chargerType").options[
        document.getElementById("chargerType").selectedIndex
      ].text;

    let address = document.getElementById("chargerAddress").value;

    if (
      chargerType == "Seleccione su tipo de cargador" ||
      chargerType == "" ||
      chargerType == null
    ) {
      alert("Porfavor asegurese de seleccionar su tipo de cargador");
    } else if (address == "" || address == null) {
      alert("Porfavor inserte la ubicación de su cargador");
    } else {
      //Procedimiento todo OK
      var url_api ="https://nominatim.openstreetmap.org/search?format=json&limit=3&q=" + address.split(' ').join('+');
      console.log(url_api);

      let request = await fetch(url_api);
      if(request.ok)
      {
          let addressArr = await request.json();
          console.log(addressArr);
          let latitude = addressArr[0].lat;
          let longitude = addressArr[0].lon;

          console.log(latitude, longitude, chargerType);


          //Ahora toca hacer el post JSON 
          let request = await fetch("/api/v1/chargers/", {
              method: "POST", 
              credentials: "same-origin", 
              headers: {
                  "Content-Type": "application/json", 
              }, 
              body: JSON.stringify({
                  
              })
          })
      }
    }
  })
);
