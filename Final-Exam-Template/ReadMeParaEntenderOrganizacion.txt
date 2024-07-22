===== Planning de esta plantilla: =====

-> Tenemos 2 tablas: Usuarios y Documentos: 
    -> Para Usuarios voy a incluir SOLO los métodos CRUD
    -> Para Documentos voy a incluir SOLO los JOIN con los usuarios

-> Testing: 
    -> Para Usuarios voy a hacer el testing para cada método CRUD
    -> Para Documentos voy a hacer un unit test y el testing para uno de los JOIN 

=========================================

Pasos de desarollo para poder hacer un buen back-end:

- 1. Asegurate de que tienes bien el application.properties (Copia y Pega el del Proyecto Base, metiendo los sql en la carpeta database)
- 2. Analiza el schema.sql para hacer bien los model en su carpeta.

    Estructura de carpetas back-end (Hacerlo en este orden): 

    (IMPORTANTE: PARA SEGUIR UNA ESTRUCTURA LIMPIA Y EVITAR LIOS, HAZ QUE LOS ARCHIVOS SE NOMBREN AL ESTILO DE xxxModel/xxxRepository/xxxService)

        - Model: Réplica de los modelos sql como objetos java

        - Repository: INTERFAZ de acceso a la base de datos. Donde relacionas los comandos SQL sobre tus tablas con métodos Java
        
        - Service: Partido en 2 partes (Service a secas, Service/impl, DTO's)
                    - Service a secas: Interfaz en la que defines el constructor de los métodos que manipulan tus clases de Java (Incluye ambas funciones con SQL y las que No)
                    - Service IMPL: Clase en la que implementas el service anterior respectivo y desarrollas los metodos definidos en el anterior archivo, implementando el repositorio para jugar con las bases de datos.
                    
                    (En caso de tener que hacer un JOIN)
                    - DTO: Estos tienen que ser los modelos/clases de Java para las tablas que formemos trás hacer un JOIN. Se desarrolla como una clase normal. 
        
        - Controller: El archivo en donde relacionamos nuestro front-end con nuestro back-end. Es donde llamamos a las funciones particulares, en caso de navegar mediante PUT/POST/FETCH/DELETE a una URL en particular. 


- En caso de tener que hacer un metodo CRUD -> GET, POST, PUT, DELETE:

- En caso de tener que hacer algún tipo de JOIN -> LEFT/RIGHT/FULL OUTER/INNER:

=======================================================================================================================================================================================================================

Anotaciones clave para cada carpeta: 

- Model: (Antes del método:) @Data
                             @Table("NombreDeLaTabla")
         (Despues del método:) @Column("Columna respectiva de la tabla SQL") <- Tambien no vendría mal, que pusieras los getters y setters en caso de que no funcione Lombok

- Repository: (Antes del constructor:) @Modifying 
                                       @Query("Con la instruccion SQL a ejecutar")

- Service/impl: @Service (antes de la clase) 
                @Autowired (para instanciar el repositorio) 
                @Override (porque estamos sobre-escribiendo los constructores de la interfaz)

- Controller: (Antes de la clase:) @RestController 
                                   @RequestMapping("/api/v1") <- Para mantener versiones en caso de cambios

              (Despues de la clase:) @Autowired (para instanciar el service)
                                     @Get/Put/Delete/PostMapping("Url") <- Para ejecutar esa función cuando se acceda a dicha url mediante un post, get, fetch, delete, etc...


========================================================================================================================================================================================================================

RECUERDATE ANTES DE EJECUTAR EL MVN SPRING-BOOT:RUN QUE ESTAS METIDO EN LA CARPETA DEL PROYECTO CORRECTA