```markdown
# Spring Security with JWT Authentication

This project demonstrates how to secure a Spring Boot application using Spring Security and JWT (JSON Web Token) for authentication and authorization.

## Features Implemented

1. Spring Security Getting Started
   Basic setup of Spring Security in a Spring Boot project.

2. Setting our own Username and Password
   Custom username and password authentication mechanism using a database.

3. CSRF Token
   Understanding and disabling CSRF protection in stateless JWT authentication.

4. Spring Security Configuration
   Configuring Spring Security to handle authorization and set security policies.

5. Spring Security User from Database
   Fetching user details from a database for authentication.

6. Spring Security BCrypt Password Encoder  
   Implemented BCrypt password encoder to securely hash passwords stored in the database.

7. What is JWT and Why  
   JWT (JSON Web Token) is a compact, URL-safe means of representing claims between two parties. Used for secure and stateless authentication.

8. Spring Security Project Setup for JWT  
   Integrated Spring Security with JWT for stateless authentication.

9. Generating JWT Token  
   Implemented functionality to generate JWT tokens upon successful authentication.

10. Validating JWT Token  
    Added logic to validate JWT tokens during the request lifecycle, ensuring that only authenticated users can access protected endpoints.

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- JWT (JSON Web Token)
- MySQL (or any database)
- Docker for containerized MySQL setup

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-name>
   ```

2. Database Setup (using Docker):
   - Run the following Docker command to set up MySQL:
     ```bash
     docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=authjwt -p 3306:3306 -d mysql:latest
     ```
   - You can access the database using MySQL Workbench or any other client.

3. Update `application.properties`:
   Configure your database connection in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/authjwt
   spring.datasource.username=root
   spring.datasource.password=root
   ```

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

- `/login`: Authentication endpoint (generates JWT token)
- `/register`: Register a new user
- Protected endpoints (e.g., `/user/details`) require the JWT token in the `Authorization` header.

## Future Improvements

- Role-based access control
- Token expiration handling and refresh tokens
- Implementing unit and integration tests

## Troubleshooting

If you face issues with token validation, ensure that:
- The secret key for signing JWT tokens is consistent.
- JWT is passed correctly in the `Authorization` header as `Bearer <token>`.

---

## Contributing

Feel free to submit issues or pull requests if you would like to contribute.

---
