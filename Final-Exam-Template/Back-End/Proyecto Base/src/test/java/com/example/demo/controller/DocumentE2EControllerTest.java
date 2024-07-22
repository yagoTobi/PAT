package com.example.demo.controller;

import com.example.demo.model.DocumentModel;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.service.dto.UserDocumentDTO;

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
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DocumentE2EControllerTest {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    // Primer test es el del GetAll
    @Test
    public void DocumentTest() {
        Iterable<DocumentModel> documents = documentRepository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/documents";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<DocumentModel>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<DocumentModel>>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(documents);
    }

    // Test del JOIN de documentos
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //ASEGURAROS SI OS DA ERROR QUE TENEIS LOS CONSTRUCTORES VACIOS Y EL COMPLETO EN EL DTO 
    //Y QUE TAMBIEN HABEIS DEFINIDO EL MÉTODO EQUALS PARA SOLO EL SITIO EN DONDE HACES EL JOIN, QUE EN ESTE CASO ES EL USER_ID
    @Test
    public void documentUsersTest(){
        String query = "SELECT USERS.USER_ID, USERS.COMMENT, USERS.USERNAME, DOCUMENTS.DOC_ID, DOCUMENTS.CONTENT FROM DOCUMENTS INNER JOIN USERS ON USERS.USER_ID = DOCUMENTS.USER_ID";
        
        Iterable<UserDocumentDTO> userDocumentJoin = jdbcTemplate.query(
            query,
            (data,rowNum) -> {
                return new UserDocumentDTO(
                    data.getLong("USERS.USER_ID"),
                    data.getString("USERS.COMMENT"),
                    data.getString("USERS.USERNAME"),
                    data.getLong("DOCUMENTS.DOC_ID"),
                    data.getString("DOCUMENTS.CONTENT")
                );
            }
        );

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/documents/join";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserDocumentDTO>>result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserDocumentDTO>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(userDocumentJoin);
    
    }
}
