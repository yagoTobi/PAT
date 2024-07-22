//Si os acordais, al estar en carpetas separadas, para poder hacer uso de 
//clases en otros archivos, debemos implementar el uso de paquetes 
package com.example.demo;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Importamos librerias de SpringBoot (pero esto lo suele incorporar VSCode 
//a solas mientras vas programando)


//Estos operadores @ sirven para implementar funcionalidades en SB y cada 
//una tiene una funcionalidad en particular 
//@SpringBootApplication sirve para poder inicializar el programa 
@SpringBootApplication
@RestController //Esta anotación permite a nuestra apli proporcionar los endpoints 
public class DemoApplication {

	public static void main(String[] args) {
		//Ejecutar el programa 
		SpringApplication.run(DemoApplication.class, args);
	}


	@GetMapping //Le vamos a proporcionar a nuestra apli, este string 
	public List<String> hello()
	{
		return List.of("Arriba", "España");
	}

}
