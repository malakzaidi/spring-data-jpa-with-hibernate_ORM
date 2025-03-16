# 🛡️ Spring Data JPA with Hibernate ORM - Many-to-Many Relationship: User and Role

## 🌟 Overview

This project demonstrates a **Many-to-Many Relationship** between **User** and **Role** entities using **Spring Data JPA** and **Hibernate ORM**. The use case involves managing users and roles, where a user can have multiple roles, and a role can be assigned to multiple users. This project is part of a series exploring different types of relationships in JPA.

---

## 📖 Table of Contents

1. [Overview](#-overview)
2. [Entities and Relationships](#-entities-and-relationships)
   - [User](#-user)
   - [Role](#-role)
3. [Project Structure](#-project-structure)
4. [How to Run the Project](#-how-to-run-the-project)
5. [Technologies Used](#-technologies-used)
6. [Database Schema](#-database-schema)
7. [Key Features](#-key-features)
8. [Conclusion](#-conclusion)

---

## 🧩 Entities and Relationships

### 👤 **User**
- **Attributes**:
  - `userId`: Unique identifier for the user (auto-generated using UUID).
  - `userName`: Unique username of the user.
  - `password`: Password of the user.
- **Relationships**:
  - `ManyToMany` with `Role`: A user can have multiple roles.

```java
@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name="USER_NAME", unique=true, length=30)
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
```

- **Explanation**:
  - The `User` entity represents a user in the system.
  - The `@ManyToMany` annotation indicates that a user can have multiple roles.
  - The `mappedBy` attribute specifies that the `users` field in the `Role` entity owns the relationship.

---

### 🛡️ **Role**
- **Attributes**:
  - `id`: Unique identifier for the role (auto-generated).
  - `desc`: Description of the role.
  - `roleName`: Unique name of the role.
- **Relationships**:
  - `ManyToMany` with `User`: A role can be assigned to multiple users.

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Description")
    private String desc;
    @Column(length=20, unique=true)
    private String roleName;

    @ManyToMany
    @ToString.Exclude
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private List<User> users = new ArrayList<>();
}
```

- **Explanation**:
  - The `Role` entity represents a role in the system.
  - The `@ManyToMany` annotation indicates that a role can be assigned to multiple users.
  - The `@ToString.Exclude` and `@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)` annotations are used to avoid circular references and hide sensitive data in JSON responses.

---

## 🗂️ Project Structure

The project is structured as follows:

```
Project2_Many_To_Many_Use_Case/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── entities/          # Contains JPA entities (User, Role)
│   │   │   ├── repositories/      # Contains JPA repositories for each entity
│   │   │   ├── services/          # Contains business logic and service layers
│   │   │   ├── controllers/       # Contains REST controllers to handle HTTP requests
│   │   ├── resources/
│   │   │   ├── application.properties  # Database and application configuration
│   ├── test/
│   │   ├── java/                  # Unit and integration tests
```

---

## 🚀 How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM.git
   cd Project2_Many_To_Many_Use_Case
   ```

2. **Set Up the Database**:
   - Open the `application.properties` file and configure your database connection:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/user_role_db
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Run the Application**:
   - Use your IDE or run the following command:
     ```bash
     mvn spring-boot:run
     ```

4. **Access the API**:
   - Use tools like **Postman** or **curl** to interact with the REST API.
   - Example endpoints:
     - `POST /users`: Create a new user.
     - `POST /roles`: Create a new role.
     - `PUT /users/{username}/roles/{roleName}`: Assign a role to a user.
     - `GET /users/{username}`: Retrieve a user by username.

---

## 🛠️ Technologies Used

- **Spring Boot**: For building the application.
- **Spring Data JPA**: For database operations.
- **Hibernate ORM**: For object-relational mapping.
- **MySQL**: As the database (can be replaced with any other relational database).
- **Lombok**: For reducing boilerplate code (e.g., `@Data`, `@NoArgsConstructor`).

---

## 📊 Database Schema

The database schema is automatically generated by Hibernate based on the entities. Here’s a simplified version:

- **User**:
  - `userId` (Primary Key)
  - `userName`
  - `password`

- **Role**:
  - `id` (Primary Key)
  - `desc`
  - `roleName`

- **User_Role** (Join Table):
  - `user_id` (Foreign Key to User)
  - `role_id` (Foreign Key to Role)

---

## 🎯 Key Features

- **CRUD Operations**: Create, Read, Update, and Delete operations for users and roles.
- **Many-to-Many Relationship**: Efficiently manage the relationship between users and roles.
- **Authentication**: Basic user authentication functionality.
- **Scalability**: The system is designed to be easily extendable for additional features like permissions, etc.

---

## 📝 Conclusion

This project demonstrates the use of **Spring Data JPA** and **Hibernate ORM** to manage a many-to-many relationship between users and roles. It provides a clear structure for managing user roles and is a great starting point for more complex security and access control applications.

Feel free to contribute, raise issues, or suggest improvements! 🚀

---

**Happy Coding!** 👨‍💻👩‍💻
