# Healthcare Spring Boot Project

## Overview
This project is a Healthcare management system built using Spring Boot, Java 17, and PostgreSQL. It manages doctors and patients with RESTful API endpoints for adding, deleting, and suggesting doctors and patients based on certain criteria.

## Project Structure
- `src/main/java/com/example/project/doctor`: Contains doctor module with controller, entity, repository, and service layers.
- `src/main/java/com/example/project/patient`: Contains patient module with similar layers.
- `src/main/java/com/example/project/files`: Contains utility classes like `ResponseModel` and constants.
- `src/main/resources/application.properties`: Configuration file for database and server settings.
- `src/test/java/com/example/project`: Contains unit tests for controllers and services.

## Technologies Used
- Java 17
- Spring Boot 3.3.1
- PostgreSQL (configured on port 5433)
- Hibernate 6.5.2
- HikariCP for connection pooling
- Gradle build system
- JUnit and Mockito for testing

## Database Setup
The project uses PostgreSQL with the following setup:

### Database Creation and Schema
Run the SQL script `db_init_corrected.sql` to create the database, enums, tables, and insert initial data.

```sql
-- Create database
CREATE DATABASE healthcare_db;

-- Connect to the database
\c healthcare_db

-- Create enum types
CREATE TYPE city_enum AS ENUM ('Delhi', 'Noida', 'Faridabad');
CREATE TYPE speciality_enum AS ENUM ('Orthopaedic', 'Gynecology', 'Dermatology', 'ENT');
CREATE TYPE symptom_enum AS ENUM ('Arthritis', 'Back Pain', 'Tissue injuries', 'Dysmenorrhea', 'Skin infection', 'Skin burn', 'Ear pain');

-- Create Doctor table
CREATE TABLE Doctor (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city city_enum NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15) UNIQUE NOT NULL,
    speciality speciality_enum NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

-- Create Patient table
CREATE TABLE Patient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city city_enum NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15) UNIQUE NOT NULL,
    symptom symptom_enum NOT NULL
);

-- Insert sample doctors and patients
INSERT INTO Doctor (name, city, email, phone_number, speciality) VALUES 
('Dr. A', 'Delhi', 'dr.a@hospital.com', '9876543210', 'Orthopaedic'),
('Dr. B', 'Noida', 'dr.b@hospital.com', '9876543211', 'Gynecology'),
('Dr. C', 'Faridabad', 'dr.c@hospital.com', '9876543212', 'Dermatology'),
('Dr. D', 'Delhi', 'dr.d@hospital.com', '9876543213', 'ENT');

INSERT INTO Patient (name, city, email, phone_number, symptom) VALUES 
('Patient 1', 'Delhi', 'patient1@healthcare.com', '9123456789', 'Arthritis'),
('Patient 2', 'Noida', 'patient2@healthcare.com', '9123456798', 'Dysmenorrhea'), 
('Patient 3', 'Faridabad', 'patient3@healthcare.com', '9123456791', 'Skin infection'), 
('Patient 4', 'Delhi', 'patient4@healthcare.com', '9123456792', 'Ear pain');
```

## Running the Application
1. Ensure PostgreSQL is running and the database is initialized.
2. Navigate to the `Assignment-Xcelore` directory.
3. Run the application using Gradle wrapper:
   ```
   ./gradlew bootRun
   ```
4. The application runs on port 8082.

## API Endpoints
- `/doctor/add` (POST): Add a new doctor.
- `/doctor/delete/{id}` (DELETE): Delete a doctor by ID.
- `/doctor/suggest` (GET): Suggest doctors for a patient.
- `/patient/add` (POST): Add a new patient.
- `/patient/delete/{id}` (DELETE): Delete a patient by ID.
- `/patient/suggest` (GET): Suggest patients for a doctor.

## Testing
- Unit tests for controllers and services are located in `src/test/java/com/example/project`.
- Run tests using:
  ```
  ./gradlew test
  ```
- Test reports are generated in `build/reports/tests/test/index.html`.

## Postman Collection
A Postman collection `Postman_Collection.json` is provided to manually test the API endpoints. Import it into Postman and use the predefined requests to add doctors and patients.

## Demonstration Guide
Refer to `DEMONSTRATION_GUIDE.md` for detailed steps on setting up, running, and demonstrating the application.

---

This README provides a comprehensive overview of the project, setup, and testing instructions to help you understand and demonstrate the Healthcare Spring Boot application.
