package com.example.demo.controller;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Optional;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserE2EControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    // Test para el GET version CRUD
    @Test
    public void UserTest() {
        Iterable<UserModel> users = userRepository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserModel>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<UserModel>>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Asegurate para el .isEqualTo que has creado el metodo isEqualTo en el modelo
        // correspondiente.
        // en caso de que te dé un error.
        then(result.getBody()).isEqualTo(users);
    }



    // Test del POST
    @Test
    public void userPostTest() {
        UserModel user = new UserModel();
        user.setUserName("Yago");
        user.setComment("Vamos a petar el examen de PAT");

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserModel> entity = new HttpEntity<>(user, headers);

        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> result = testRestTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<String>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    // Test del PUT
    @Test
    public void userPutTest() {
        String comment = "Vamos a petar el examen de PAT";
        // En este caso lo tengo que hacer OPTIONAL ya que el DATO DEL ID ES UN LONG Y
        // NO UN STRING
        Optional<UserModel> user = userService.getUserById((long) 1);
        userService.updateComment("Vamos a petar el examen de PAT", (long) 1);

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users/1/" + comment;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Optional<UserModel>> entity = new HttpEntity<>(user, headers);

        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<UserModel> result = testRestTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                new ParameterizedTypeReference<UserModel>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    // Test del DELETE
    @Test
    public void userDeleteTest() {
        Optional<UserModel> user = userService.getUserById((long) 1);

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users/1";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Optional<UserModel>> entity = new HttpEntity<>(user, headers);

        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<UserModel> result = testRestTemplate.exchange(
                url,
                HttpMethod.DELETE,
                entity,
                new ParameterizedTypeReference<UserModel>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}


/*EN CASO DE QUE NOS PIDAN EL TEST DEL GET HECHO POR NOSOTROS ID: 
jugar con esto:
 @Test
    public void userGetTest(){
        Iterable<UserModel> users = userService.getUser();

        String url = "http://localhost:"+Integer.toString(port)+"/api/v1/users";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserModel>> result = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserModel>>() {}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(users);
    }

*/




