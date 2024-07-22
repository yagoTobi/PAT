package com.example.demo.Controller;

import com.example.demo.Classes.Miembro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class miembroController {

    Miembro miembro;

    @GetMapping("/getMiembros") // Cuando pongamos /miembros en explorador
                                // se va a ejecutar la funcion getmiembros
    public Miembro getMiembros() {
        return miembro;
    }

    // En caso de que queramos enviar información
    // Dependiendo del metodo vamos a hacer get o post que se ejecute x funcion
    @PostMapping("/setMiembros")
    public void postMiembros(@RequestBody Miembro miembro) {
        this.miembro = miembro;
    }

}

