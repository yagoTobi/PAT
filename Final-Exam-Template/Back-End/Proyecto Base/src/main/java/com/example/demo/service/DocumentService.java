package com.example.demo.service;

import com.example.demo.model.DocumentModel;
import com.example.demo.service.dto.UserDocumentDTO;

public interface DocumentService {

    //Para obtener todo
    Iterable<DocumentModel> getDocuments();

    Iterable<UserDocumentDTO> retrieveUserDocuments();
    
}
