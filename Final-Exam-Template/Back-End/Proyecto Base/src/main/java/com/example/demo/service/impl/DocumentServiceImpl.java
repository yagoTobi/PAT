package com.example.demo.service.impl;

import com.example.demo.model.DocumentModel;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.service.DocumentService;
import com.example.demo.service.dto.UserDocumentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentRepository documentRepository;

    //Ahora siiii porque si que estamos haciendo un Join Refashero
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Se tienen que implementar los metodos definidos en el Document 
    @Override
    public Iterable<DocumentModel> getDocuments() {
        return documentRepository.findAll();
    }

    //HORA DE HACER EL JOIN
    @Override
    public Iterable<UserDocumentDTO> retrieveUserDocuments() {
        
        String query = 
        """
        SELECT USERS.USER_ID, USERS.COMMENT, USERS.USERNAME, DOCUMENTS.DOC_ID, DOCUMENTS.CONTENT 
        FROM DOCUMENTS      
        INNER JOIN USERS ON USERS.USER_ID = DOCUMENTS.USER_ID
        """;//En donde pone INNER JOIN, CAMBIARÍAMOS EL TIPO DE JOIN QUE TENEMOS AL QUE DESEEMOS

        Iterable<UserDocumentDTO> userDocumentJoins = jdbcTemplate.query(
            query,
            (data, rowNum) -> {
                return new UserDocumentDTO(
                data.getLong("USERS.USER_ID"),
                data.getString("USERS.COMMENT"),
                data.getString("USERS.USERNAME"),
                data.getLong("DOCUMENTS.DOC_ID"), 
                data.getString("DOCUMENTS.CONTENT")
                );
            } 
        );

        return userDocumentJoins;
    }
    
}
