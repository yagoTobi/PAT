# Práctica Final Programación Aplicaciones Telemáticas - Volta Electronic Vehicles

Práctica desarrollada por Luis Bueno y Yago Tobio. 

Para esta práctica final, hemos desarrollado una aplicación que permite la serialización y el alquiler posible de los cargadores de coches eléctricos de particulares. 


# Tipos de Usuarios

Volta permite 2 tipos de usuarios: 
Usuarios que alquilan los cargadores 
Aquellos que prestán sus cargadores a cambio de dinero. 
En nuestra página web se puede llegar a crear ambos tipos de usuarios, pero lo más común es que uno salga a raíz del otro. Aquellos usuarios que se declaren hosts, podrán ingresar en las bases de datos sus cargadores, para los cuales los usuarios podrán visualizarlo en un Mapa, con el fin de poder alquilar su cargador más cercano.  

## Sistema de Reservas

El sistema de Reservas principalmente funciona de manera visual, en la cual el usuario puede buscar su cargador más cercano mediante la busqueda visual en su mapa. (La página hace uso de las librerías OpenTileMap y Leaflet.js) 
Trás haber encontrado su cargador de interés podrá hacer click sobre su icono y reservarlo para si mismo, hasta que el propietario de dicho cargador decida anular la reserva. 

## Clases y tablas involucradas en la práctica: 
- Chargers (Cargadores de EV, pueden ser de Tipo 1, 2 o enchufe estandar)
- Hosts (Aquellos usuarios que deciden alquilar su cargador eléctrico)
- Newsletter (Aquellos usuarios que solo deben de ingresar su correo para suscribirse a la newsletter de la compañía)
- Reservation (Nos indica las propiedades de las reservas hechas trás haber seleccionado los cargadores en el mapa) 
- User (Usuarios estandár que van a alquilar cargadores)
- Vehicle (Para aquellos usuarios que deseen registrar su vehiculo y hacer su experiencia de selección de cargador más rápida)

## Vistas de la página web:
- Contacto => Para poder contactar y enviarle un correo a la empresa u ofrecer la posibilidad de suscribirse a la newsletter 
- Index => Página prinicipal, la cual explica todo el concepto de la compañía 
- hostsCharger => Página en la que los usuarios tipo hosts pueden dar de alta sus cargadores eléctricos con el fin de poderlos alquilar 
- Log In Hosts/Users => Acceder a sus cuentas 
- Sign Up Hosts/Users => Crearse cuentas 
- Users/Map.html => Vista en la que se despliega a la vista todos los cargadores que se han añadido en el sistema del mundo, con la posibilidad de si uno es usuario, poder reservarlo durante un periodo específico de tiempo 

