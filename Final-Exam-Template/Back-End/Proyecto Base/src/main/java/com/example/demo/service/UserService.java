package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.UserModel;

public interface UserService {

        //Metodo para obtener toda si info
        Iterable<UserModel> getUsers();

        //Metodos CRUD
        //GET
        Optional<UserModel> getUserById(Long userId);
        //POST
        void createUser(UserModel user);
        //PUT
        void updateComment(String comment, Long userId);
        //DELETE
        void deleteUser(Long userId);
    
}
