package com.example.demo.controller;

import com.example.demo.model.DocumentModel;
import com.example.demo.service.DocumentService;
import com.example.demo.service.dto.UserDocumentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // El GET del CRUD
    @GetMapping("/documents")
    public ResponseEntity<Iterable<DocumentModel>> retrieveAll() {
        return ResponseEntity.ok().body(documentService.getDocuments());
    }

    // El JOIN
    @GetMapping("/documents/join")
    public ResponseEntity<Iterable<UserDocumentDTO>> retrieveUserDocument() {
        return ResponseEntity.ok().body(documentService.retrieveUserDocuments());
    }
}
