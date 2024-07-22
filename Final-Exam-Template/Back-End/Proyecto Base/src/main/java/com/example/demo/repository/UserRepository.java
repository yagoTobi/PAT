package com.example.demo.repository;

import com.example.demo.model.UserModel;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    
    /*NOTA: Por defecto el CrudRepository ya nos incluye una serie de funciones que no 
            son necesarias declarar porque ya vienen incluidas, tales como: 
            - count() -> Que cuenta el numero de elementos 
            - deleteAll(Iterable<UserModel> user) 
            - deleteById(Id id)
            - findAll() <- Que nos permite mostrar todas 

        Pero por ejemplo las del get y delete que me he hecho yo las he hecho por practica o por si 
        surge un caso particular
    */


    //Metodos CRUD en este orden:
    //GET 
    //En este caso, al estar buscando por id, y al ser en nuestra tabla id, valores identity (unicos)
    //Solo nos va a devolver un modelo de usuario, no un iterable!!
    @Query("SELECT * FROM USERS WHERE USERS.USER_ID = :userId")
    public UserModel getUserById(Long userId);
    
    //POST
    @Modifying
    @Query("INSERT INTO USERS (COMMENT, USERNAME) VALUES (:comment,:userName)")
    public void createUser(String comment, String userName);

    //PUT 
    @Modifying
    @Query("UPDATE USERS SET USERS.COMMENT= :comment WHERE USERS.USER_ID =:userId")
    public void updateComment(String comment, Long userId);

    //DELETE
    @Modifying
    @Query("DELETE FROM USERS WHERE USERS.USER_ID= :userId")
    public void deleteUser(Long userId);


}
