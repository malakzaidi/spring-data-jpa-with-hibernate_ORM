# 🏥 Hospital Management System using Spring Data JPA with Hibernate ORM

![image_alt](https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM/blob/main/Project1_hospital_management/images/Screenshot%202025-03-16%20225901.png)

## 📖 Table of Contents

1. [Overview](#-overview)
2. [Entities and Relationships](#-entities-and-relationships)
   - [Patient](#-patient)
   - [Rendezvous (Appointment)](#-rendezvous-appointment)
   - [Medecin (Doctor)](#-medecin-doctor)
   - [Consultation](#-consultation)
3. [Project Structure](#-project-structure)
4. [How to Run the Project](#-how-to-run-the-project)
5. [Technologies Used](#-technologies-used)
6. [Database Schema](#-database-schema)
7. [Key Features](#-key-features)
8. [Conclusion](#-conclusion)

---

## 🌟 Overview

This project is a **Hospital Management System** designed to manage appointments (rendez-vous) between patients and doctors. It leverages **Spring Data JPA** with **Hibernate ORM** to handle database operations and relationships between entities. The system allows for efficient management of patients, doctors, appointments, and consultations.

---

## 🧩 Entities and Relationships

### 📋 **Patient**
- **Attributes**:
  - `id`: Unique identifier for the patient (auto-generated).
  - `nom`: Name of the patient.
  - `email`: Email address of the patient.
- **Relationships**:
  - `OneToMany` with `Rendezvous`: A patient can have multiple appointments.
  ![image_alt](https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM/blob/main/Project1_hospital_management/images/Screenshot%202025-03-16%20150053.png)
```java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<Rendezvous> rendezVous;
}
```

- **Explanation**:
  - The `Patient` entity represents a patient in the hospital system.
  - The `@OneToMany` annotation indicates that one patient can have multiple appointments (`Rendezvous`).
  - The `mappedBy` attribute specifies that the `patient` field in the `Rendezvous` entity owns the relationship.

---

### 📅 **Rendezvous (Appointment)**
- **Attributes**:
  - `id`: Unique identifier for the appointment (auto-generated).
  - `dateRendezvous`: Date of the appointment.
- **Relationships**:
  - `ManyToOne` with `Patient`: Each appointment is associated with one patient.
  - `ManyToOne` with `Medecin`: Each appointment is associated with one doctor.
  - `OneToOne` with `Consultation`: Each appointment can have one consultation.

```java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Rendezvous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateRendezvous;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Patient patient;
    @OneToOne
    private Consultation consultation;
}
```
![image_alt](https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM/blob/main/Project1_hospital_management/images/Screenshot%202025-03-16%20150149.png)

- **Explanation**:
  - The `Rendezvous` entity represents an appointment between a patient and a doctor.
  - The `@ManyToOne` relationship with `Patient` and `Medecin` means that multiple appointments can be linked to a single patient or doctor.
  - The `@OneToOne` relationship with `Consultation` means that each appointment can have one associated consultation.

---

### 👨‍⚕️ **Medecin (Doctor)**
- **Attributes**:
  - `id`: Unique identifier for the doctor (auto-generated).
  - `nom`: Name of the doctor.
  - `specialite`: Specialty of the doctor.
  - `email`: Email address of the doctor.
- **Relationships**:
  - `OneToMany` with `Rendezvous`: A doctor can have multiple appointments.

```java
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String specialite;
    private String email;
    @OneToMany(mappedBy = "medecin")
    private Collection<Rendezvous> rendezVous;
}
```
![image_alt](https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM/blob/main/Project1_hospital_management/images/Screenshot%202025-03-16%20150020.png)

- **Explanation**:
  - The `Medecin` entity represents a doctor in the hospital system.
  - The `@OneToMany` relationship with `Rendezvous` means that a doctor can have multiple appointments.
  - The `mappedBy` attribute indicates that the `medecin` field in the `Rendezvous` entity owns the relationship.

---

### 🩺 **Consultation**
- **Attributes**:
  - `id`: Unique identifier for the consultation (auto-generated).
  - `dateConsultation`: Date of the consultation.
  - `rapportConsultation`: Report of the consultation.
  - `prixConsultation`: Price of the consultation.
- **Relationships**:
  - `OneToOne` with `Rendezvous`: Each consultation is associated with one appointment.

```java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateConsultation;
    private String rapportConsultation;
    private double prixConsultation;
    @OneToOne(mappedBy = "consultation")
    private Rendezvous rendezVous;
}
```

![image_alt](https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM/blob/main/Project1_hospital_management/images/Screenshot%202025-03-16%20150224.png) 

- **Explanation**:
  - The `Consultation` entity represents a consultation that occurs after an appointment.
  - The `@OneToOne` relationship with `Rendezvous` means that each consultation is linked to one appointment.
  - The `mappedBy` attribute indicates that the `consultation` field in the `Rendezvous` entity owns the relationship.

---

## 🗂️ Project Structure

The project is structured as follows:

```
Project1_hospital_management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── entities/          # Contains JPA entities (Patient, Rendezvous, Medecin, Consultation)
│   │   │   ├── repositories/      # Contains JPA repositories for each entity
│   │   │   ├── services/          # Contains business logic and service layers
│   │   │   ├── controllers/       # Contains REST controllers to handle HTTP requests
│   │   ├── resources/
│   │   │   ├── application.properties  # Database and application configuration
│   ├── test/
│   │   ├── java/                  # Unit and integration tests
```

---
![image_alt](https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM/blob/main/Project1_hospital_management/images/Screenshot%202025-03-16%20163258.png) 

## 🚀 How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/malakzaidi/spring-data-jpa-with-hibernate_ORM.git
   cd Project1_hospital_management
   ```

2. **Set Up the Database**:
   - Open the `application.properties` file and configure your database connection:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/hospital_management
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
     - `GET /patients`: Retrieve all patients.
     - `POST /rendezvous`: Create a new appointment.
     - `GET /medecins`: Retrieve all doctors.

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

- **Patient**:
  - `id` (Primary Key)
  - `nom`
  - `email`

- **Rendezvous**:
  - `id` (Primary Key)
  - `dateRendezvous`
  - `patient_id` (Foreign Key to Patient)
  - `medecin_id` (Foreign Key to Medecin)
  - `consultation_id` (Foreign Key to Consultation)

- **Medecin**:
  - `id` (Primary Key)
  - `nom`
  - `specialite`
  - `email`

- **Consultation**:
  - `id` (Primary Key)
  - `dateConsultation`
  - `rapportConsultation`
  - `prixConsultation`
  - `rendezvous_id` (Foreign Key to Rendezvous)

---

## 🎯 Key Features

- **CRUD Operations**: Create, Read, Update, and Delete operations for patients, doctors, appointments, and consultations.
- **Relationships**: Efficiently manage one-to-many, many-to-one, and one-to-one relationships between entities.
- **Scalability**: The system is designed to be easily extendable for additional features like billing, prescriptions, etc.

---

## 📝 Conclusion

This project demonstrates the power of **Spring Data JPA** and **Hibernate ORM** in building a robust and scalable hospital management system. It provides a clear structure for managing appointments, patients, doctors, and consultations, making it a great starting point for more complex healthcare applications.

Feel free to contribute, raise issues, or suggest improvements! 🚀

---

**Happy Coding!** 👨‍💻👩‍💻
