# API de Bomberos

## Descripción
Esta API es un intento de registrar los bomberos, vehiculos, y rangos

## Base de Datos

El proyecto utiliza una base de datos para almacenar la información. Asegúrese de tener una base de datos disponible y configure las credenciales de conexión en el archivo `application.properties`.

Ejemplo de configuración para una base de datos H2 en memoria:

```properties
spring.application.name=backends2
spring.datasource.url=jdbc:mysql://localhost:3306/ejercicios2bd?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=********
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
