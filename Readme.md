El archivo definitivo es MovieMoodMySqlUltima
Se necesita previamente configurar una conexión en MySql para mooviemood, con un usuario MM y password mm. El esquema de la BBDD se llamará mooviemood.

Éste es el application.properties del proyecto para configurar el servidor y la BBDD:
   server.port:8083
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.url=jdbc:mysql://127.0.0.1:3306/moviemood
   spring.datasource.username=MM
   spring.datasource.password=mm
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
  
Hay dos scripts para la carga de datos iniciales en la siguiente ruta:
    /movieMoodMySqlUltima/src/main/resources/bbdd

Una vez lanzada la aplicación por primera vez las Entities crean automáticamente las tablas, pero los datos
iniciales no se van a cargar ya que no está puesta la propiedad necesaria en el application.properties.
Por ello una vez se hayan creado las tablas, hay que ejecutar en Workbench los archivos: 
    generosdata.sql --> para tener los géneros de las películas
    peliculasdata.sql --> si se desean tener datos iniciales de películas en MovieMood. Si no se cargan, 
                          se puede llenar la BBDD con el servicio de búsqueda en IMDB.

  
