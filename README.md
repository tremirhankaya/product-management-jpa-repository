**Spring Boot REST API Example**

This project is a simple demonstration of fundamental CRUD (Create, Read, Update, Delete) operations using Spring Boot and Spring Data JPA. The main goal of this project is to practice and solidify the basics of the `JpaRepository` interface, which is the modern and standard way to handle data access in Spring applications.

---

**Project Highlights**

- **Spring Boot:** The project is built on the Spring Boot framework for rapid application development.
- **Spring Data JPA:** Uses `JpaRepository` for efficient data access with minimal boilerplate code.
- **Service Layer:** A layer of abstraction (`ProductService`) is introduced to encapsulate business logic.
- **RESTful API:** A dedicated `ProductController` class provides a RESTful API for managing product data via HTTP endpoints.
- **Custom Exception Handling:** A centralized exception handling mechanism is implemented using `@ControllerAdvice` to provide clean, standardized JSON error messages with appropriate HTTP status codes.
- **Automated API Documentation:** Uses SpringDoc to automatically generate an interactive API documentation (Swagger UI).
- **PostgreSQL:** Uses a PostgreSQL database to store product data.

---

**Getting Started**

### Prerequisites

- Java 17 or higher
- Maven
- Docker (for PostgreSQL database)

### Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/tremirhankaya/spring-boot-product-rest-api.git](https://github.com/tremirhankaya/spring-boot-product-rest-api.git)
    ```

2.  **Database Configuration:**
    The project uses a PostgreSQL database. You'll need to configure your database connection details in `src/main/resources/application.properties`.
    
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
    spring.datasource.username=postgres
    spring.datasource.password=your_password
    ```
    
    > **Note:** The `application.properties` file is included in `.gitignore` for security reasons. Do not push your credentials to the repository.

3.  **Run the application:**
    You can run the `ProductCrudJpaRepoApplication.java` class directly from your IDE. Once running, the REST API endpoints will be available.

---

**API Endpoints**

- **GET `/api/products`**: Retrieves a list of all products.
- **GET `/api/products/{productId}`**: Retrieves a product by its ID.
- **POST `/api/products`**: Adds a new product. (Request body required)
- **PUT `/api/products/{productId}`**: Updates an existing product. (Request body required)
- **DELETE `/api/products/{productId}`**: Deletes a product by its ID.
- **Swagger UI**: Access the interactive API documentation at `http://localhost:8080/swagger-ui.html`

---

**Project Structure**

The project follows a layered architecture to demonstrate the core concepts:

- `com.emirhan.product_crud_jpa_repo.entity`: Contains the `Product` JPA entity.
- `com.emirhan.product_crud_jpa_repo.dao`: Contains the `ProductRepository` interface.
- `com.emirhan.product_crud_jpa_repo.service`: Contains the `ProductService` interface and its implementation.
- `com.emirhan.product_crud_jpa_repo.controller`: Contains the `ProductController` providing the RESTful API endpoints.
- `com.emirhan.product_crud_jpa_repo.exception`: Contains custom exception classes and a global exception handler.

---

Feel free to explore the code to understand how each layer works together to create a functional web service.