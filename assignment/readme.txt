

# Spring Boot Assignment

This project is a Spring Boot-based web application that demonstrates the implementation of a user and role management system with different levels of access. It includes functionalities for handling users (admin, moderator, and regular user) and securing access using JWT tokens and BCrypt password hashing.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Project Setup](#project-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Seeding Data](#seeding-data)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used

- **Spring Boot**: Framework used for building the application.
- **Spring Security**: For authentication and authorization management.
- **MySQL**: Database used to store user and role data.
- **JPA/Hibernate**: ORM used for interacting with the database.
- **BCryptPasswordEncoder**: For securely hashing passwords.
- **Maven**: Build automation tool for managing dependencies.
- **JWT**: For token-based authentication.
- **H2 Database (Optional)**: In-memory database for testing.

## Project Setup

### Prerequisites

Ensure that you have the following software installed:

- Java 17 or higher
- MySQL database or H2 (if using in-memory)
- Maven (for managing the build)
- Git (for version control)

### Clone the Repository

Clone the repository to your local machine using:

```bash
git clone https://github.com/vasikaran53/assignment.git
```

### Configure the Database

1. **Create the Database**  
   Create a database called `assignment_dbf` in MySQL or use H2 for testing.
   ```sql
   CREATE DATABASE assignment_dbss;
   ```

2. **Configure `application.properties`**  
   Update the `application.properties` file with your database credentials.  
   Example for MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/assignment_dbss
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.security.jwt.secret=yourSecretKey
   spring.security.jwt.expiration=86400000 # 1 day in milliseconds
   server.port=8090
   ```

### Install Dependencies

Navigate to the project folder and run the following command to install all dependencies:

```bash
mvn install
```

## Configuration

- **Spring Security**: Used to secure the application with JWT and role-based access control.
- **Roles and Users**: The project includes three predefined roles: `ROLE_USER`, `ROLE_ADMIN`, and `ROLE_MODERATOR`. Admin and Moderator users are created automatically upon first run.
- **BCrypt**: Used for password encryption to ensure secure authentication.
  
### JWT Authentication
The application supports JWT-based authentication. JWT tokens are generated upon successful login and must be provided in the `Authorization` header for accessing protected resources.

## Running the Application

### Running the Application with Maven

To run the application locally, use the following command:

```bash
mvn spring-boot:run
```

This will start the Spring Boot application, and it will be available at `http://localhost:8090`.

### Running the Application with Jar

You can build the project into a JAR and run it:

```bash
mvn clean package
java -jar target/assignment-0.0.1-SNAPSHOT.jar
```

## Seeding Data

The project includes a data seeding functionality, which will automatically create roles (`ROLE_USER`, `ROLE_ADMIN`, `ROLE_MODERATOR`) and users (admin, moderator) when the application is started for the first time.

- **Admin User**:  
  - Username: `admin`  
  - Password: `adminPassword`

- **Moderator User**:  
  - Username: `moderator`  
  - Password: `moderator123`

These users will be available in the system after the first run, and their roles will be automatically assigned.

## Endpoints

### Public Endpoints

- **POST /auth/login**:  
  - Used for login. Returns a JWT token for authorized access.
  
### Protected Endpoints (Requires JWT)

- **GET /test/users**:  
  - Fetches all users (requires valid JWT).
  
## Contributing

If you’d like to contribute to this project, feel free to fork it and create a pull request. If you encounter any issues or have suggestions for improvements, open an issue on the GitHub repository.

## License

This project is licensed under the MIT License.

