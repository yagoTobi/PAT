package volta.cars.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import volta.cars.project.model.ChargerModel;
import volta.cars.project.repository.ChargerRepository;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChargerE2EControllerTest {
    @Autowired
    private ChargerRepository repository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    // Primer test GetAll
    @Test
    public void ChargerTest() {
        Iterable<ChargerModel> documents = repository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/chargers";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<ChargerModel>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<ChargerModel>>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(documents);
    }


    //Segundo Test para el PostMapping
    @Test
    public void testPostMapping()
    {
        ChargerModel model = new ChargerModel();
        model.setChargerType("Type 2");
        model.setLatitude((float) 15.404);
        model.setLongitude((float)105.678);
        model.setUserId(Long.valueOf(5));

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/chargers";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ChargerModel> entity = new HttpEntity<>(model, headers);

        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> result = testRestTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<String>() {
        });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    ///Some bullshit
    @Test
    public void chargerLongTest() {

        Iterable<ChargerModel> documents = repository.retrieveChargerLong(1.0f);

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/chargersLon";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<ChargerModel>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<ChargerModel>>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(documents);
    }


}
