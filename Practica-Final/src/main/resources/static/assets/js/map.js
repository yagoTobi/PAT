const map = L.map("map").setView([0, 0], 5);

const chargerIcon = L.icon({
    iconUrl: "assets/img/charger.png",
    iconSize: [70, 70],
    iconAnchor: [48, 32],
});

const attribution =
    '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';
const tileUrl = "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png";
const tiles = L.tileLayer(tileUrl, { attribution });
tiles.addTo(map);

async function getChargers() {
    let request = await fetch("/api/v1/chargers", {
        method: "GET",
    }).catch(console.error);

    if (request.ok) {
        data = await request.json();
        console.log(data);

        for (let i = 1; i - 1 < data.length; i++) {
            async function getCharger() {
                const { chargerId, chargerType, latitude, longitude, userId } =
                    data[i - 1];
                const marcador = L.marker([latitude, longitude], {
                    icon: chargerIcon,
                }).addTo(map);
                map.setView([latitude, longitude], map.getZoom());
                marcador.setLatLng([latitude, longitude]);
                marcador
                    .bindPopup(
                        `<h3>Tipo de cargador:</h3><h4>` +
                        chargerType +
                        `</h4><div class="row d-flex justify-content-center"><button onclick="getSpecificCharger('${userId}')" class="btn btn-dark btn-lg btn-block" id= "reservation_button` +
                        i +
                        `" type="button">Reservar</button></div>`
                    )
                    .openPopup();
            }
            getCharger();
        }
        /*
            for (let i = 1; i - 1 < data.length; i++) {
              var reservation_button = document.getElementById(
                "reservation_button" + i
              );
              console.log(reservation_button);
              reservation_button.addEventListener(
                "click",
                (postNewReservation = async () => {
                  const now = new Date();
                  const reservationHour = now.getHours() + ":" + now.getMinutes();
                  const reservationDate = now.getDate();
                  let request2 = await fetch("/api/v1/charger/" + i, {
                    method: "GET",
                  }).catch(console.error);
        
                  if (request2.ok) {
                    data2 = await request.json();
                    console.log(data);
        
                    let request1 = await fetch(
                      "/api/v1/hostMembers/" + data2[0].userId,
                      {
                        method: "GET",
                      }
                    ).catch(console.error);
        
                    if (request1.ok) {
                      data1 = await request1.json();
        
                      let request = await fetch("/api/v1/reservations", {
                        method: "POST",
                        credentials: "same-origin",
                        headers: {
                          "Content-Type": "application/json",
                        },
                        body: JSON.stringify({
                          userId: data2[0].userId,
                          hostId: data1[0].hostId,
                          price: data1[0].hourlyrate,
                          latitude: data2[0].latitude,
                          longitude: data2[0].longitude,
                          reservationDate: reservationDate,
                          reservationHour: reservationHour,
                        }),
                        dataType: "json",
                      });
        
                      console.log(userName);
        
                      if (request.ok) {
                        console.log("Success!");
                        console.log(await request.json());
                      }
                    }
                  }
                })
              );
            }*/
    }
}
getChargers();

async function getSpecificCharger(userId) {
    const now = new Date();
    const reservationHour = now.getHours() + ":" + now.getMinutes();
    const reservationDate = now.getDate();
    //El tipo de chargerId es el long
    let request_a = await fetch("/api/v1/charger/" + userId, {
        method: "GET",
    }).catch(console.error);

    if (request_a.ok) {
        data = await request_a.json();
        console.log(data);
    }
}

/*@GetMapping("/charger/{id}/")
public ResponseEntity<ChargerModel> retrieveCharger(@PathVariable Long id) {
ChargerModel response = service.retrieveCharger(id);
return ResponseEntity.ok().body(response);
}*/
