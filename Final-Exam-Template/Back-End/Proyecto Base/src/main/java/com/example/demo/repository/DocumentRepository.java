package com.example.demo.repository;

import com.example.demo.model.DocumentModel;

import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentModel, Long> {

    //Aqui no vamos a implementar ningún metodo CRUD, porque con este solo queremos hacer un join 
    
}
