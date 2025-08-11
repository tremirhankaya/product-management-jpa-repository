**Product Management with Spring Data JPA**

This project is a simple demonstration of fundamental CRUD (Create, Read, Update, Delete) operations using Spring Boot and Spring Data JPA. The main goal of this project is to practice and solidify the basics of the `JpaRepository` interface, which is the modern and standard way to handle data access in Spring applications.

---

**Project Highlights**

- **Spring Boot:** The project is built on the Spring Boot framework for rapid application development.
- **Spring Data JPA:** Instead of using the low-level `EntityManager`, this project leverages `JpaRepository` to perform database operations with minimal boilerplate code.
- **Service Layer:** An extra layer of abstraction (`ProductService`) is introduced to encapsulate business logic and separate it from data access concerns.
- **PostgreSQL:** Uses a PostgreSQL database to store product data. (You can change this in `application.properties`).
- **CRUD Operations:** Includes examples for creating, reading, updating, and deleting `Product` entities.

---

**Getting Started**

### Prerequisites

- Java 17 or higher
- Maven
- Docker (for PostgreSQL database)

### Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/tremirhankaya/product-management-jpa-repository.git](https://github.com/tremirhankaya/product-management-jpa-repository.git)
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
    You can run the `ProductCrudJpaRepoApplication.java` class directly from your IDE. The CRUD operations are executed via a `CommandLineRunner` on startup.

---

**Project Structure**

The project follows a layered architecture to demonstrate the core concepts:

- `com.emirhan.product_crud_jpa_repo.entity`: Contains the `Product` JPA entity.
- `com.emirhan.product_crud_jpa_repo.dao`: Contains the `ProductRepository` interface, which extends `JpaRepository`.
- `com.emirhan.product_crud_jpa_repo.service`: Contains the `ProductService` interface and its implementation, encapsulating the business logic.
- `com.emirhan.product_crud_jpa_repo`: Contains the main application class with a `CommandLineRunner` for testing the functionalities.

---

Feel free to explore the code to understand how `JpaRepository` and a dedicated `Service` layer simplify data access and management.