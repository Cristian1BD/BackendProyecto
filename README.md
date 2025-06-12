
# Proyecto Integrador

## Descripción

Este proyecto es una API RESTful desarrollada con Spring Boot que implementa un sistema de gestión con autenticación y autorización basada en roles. Está preparada para ejecutarse en entornos locales y en la nube (Render.com) mediante contenedores Docker. La base de datos se gestiona con **MySQL en Aiven**, utilizando **MySQL Workbench** como cliente.

---

## Tecnologías Utilizadas

- Java 21  
- Spring Boot 3.4.3  
- Spring Security  
- Spring Data JPA  
- MySQL (Aiven) / PostgreSQL (opcional)  
- JWT (JSON Web Tokens)  
- Maven  
- Docker  
- Swagger / OpenAPI  

---

## Requisitos Previos

- JDK 21  
- Maven 3.8+  
- Cuenta en Aiven (MySQL) o una base de datos local  
- Docker (opcional para despliegue en contenedor)  

---

## Estructura del Proyecto

```
.
├── .mvn/
├── docs/
├── src/
│   ├── main/
│   │   ├── java/com/cesde/proyecto_integrador/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── mapper/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── security/
│   │   │   └── service/
│   │   └── resources/
│   └── test/
├── uploads/
├── Dockerfile
├── .env
├── .gitignore, .dockerignore, .gitattributes
├── pom.xml
├── project.toml
└── README.md
```

---

## Configuración del Entorno

### Archivo `.env`

```env
# Base de datos Aiven (MySQL)
DB_URL=jdbc:mysql://[HOST]:[PORT]/data_pi?useSSL=true&serverTimezone=UTC
DB_USERNAME=usuario
DB_PASSWORD=contraseña

# JWT
JWT_SECRET=tu_secreto_super_seguro_aqui
```

> ⚠️ No subas este archivo al repositorio. Asegúrate de que `.env` está en `.gitignore`.

---

## Instalación y Ejecución

### Local (con Maven)

```bash
git clone [URL_DEL_REPOSITORIO]
cd proyecto-integrador
# Configura el archivo .env
./mvnw clean package
./mvnw spring-boot:run
```

La API quedará disponible en `http://localhost:8080`.

### Docker

```bash
docker build -t proyecto-integrador .
docker run -d   --name proyecto-integrador   -p 8080:8080   --env-file .env   proyecto-integrador
```

---

## Documentación de la API

- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)  
- OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## Autenticación y Roles

### Endpoint de Login

`POST /api/auth/login`

```json
{
  "email": "usuario@ejemplo.com",
  "password": "contraseña"
}
```

Respuesta:

```json
{
  "token": "jwt_token",
  "username": "usuario@ejemplo.com",
  "role": "ADMIN"
}
```

### Roles Soportados

- **ADMIN**: Acceso total al sistema  
- **STUDENT**: Funcionalidades específicas para estudiantes  
- **TEACHER**: Funcionalidades específicas para profesores  

### Usuarios de Prueba

- **Profesor**: Cristian@Teacher.com / `profesor123`  
- **Estudiante**: Cristian@estudiante.com / `estudiante`  
- **Administrador**: admin@admin.com / `admin`  

---

## Entidades Principales

### User

- id  
- email  
- password (encriptada)  
- role (ADMIN, STUDENT, TEACHER)  
- createdAt, updatedAt  
- Relación: OneToOne con `Profile`

### Profile

- id  
- name, lastName  
- phone, address  
- urlPhoto  
- Relación: OneToOne con `User`

---

## Despliegue en la Nube

### Render.com

El proyecto está configurado para desplegarse directamente en Render:

1. Sube el repositorio a GitHub.
2. Conecta Render al repositorio.
3. Agrega variables de entorno desde el archivo `.env`.
4. Render usará el `Dockerfile` para el despliegue automático.

---

## Dependencias Principales

### Spring Boot

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `spring-boot-starter-validation`
- `spring-boot-devtools`
- `spring-boot-starter-test`

### Seguridad

- `jjwt` (0.9.1)  
- `jaxb-api` y `jaxb-runtime`

### Base de Datos

- `mysql-connector-j` (Aiven)  
- `postgresql` (opcional)

### Documentación API

- `springdoc-openapi-starter-webmvc-ui` (2.8.5)

### Utilidades

- `lombok`  

---

## Documentación Adicional

Revisá la carpeta `docs/` para más detalles sobre:

- Configuración del entorno  
- Modelo de datos  
- Esquema de seguridad  
- Entidades y relaciones  
