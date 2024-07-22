package com.example.demo.service.impl;

import java.util.Optional;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository; // Donde este userRepository incluye el crudRepo

    // En este caso no tenemos que instanciar el JDBCTemplate ya que no estamos
    // haciendo un JOIN

    @Override
    public Iterable<UserModel> getUsers() {
        // Metodo para obtener todos los datos
        return userRepository.findAll();
    }

    // Metodos GET, POST, PUT, DELETE
    // GET
    @Override
    public Optional<UserModel> getUserById(Long userId) {
        return userRepository.findById(userId);

        // Una alternativa sin tener que crear este metodo y solo usando crud sería:
        // return userRepository.findById(userId).get();
    }

    // POST
    @Override
    public void createUser(UserModel user) {
        String userName = user.getUserName();
        String comment = user.getComment();

        userRepository.createUser( comment, userName);
    }

    // PUT
    @Override
    public void updateComment(String comment, Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.updateComment(comment, userId);
        }
    }

    // DELETE
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
