# Demonstration Guide for Healthcare Spring Boot Application

This guide will help you demonstrate the Healthcare application to the panel effectively.

## Prerequisites
- PostgreSQL installed and running
- Java 17 installed
- Gradle installed or use the Gradle wrapper included
- Postman installed

## Step 1: Initialize the Database
1. Open your PostgreSQL client (psql or any GUI client like pgAdmin).
2. Run the SQL script `db_init_corrected.sql` to create the database, tables, enums, and insert initial data.
   - If using psql CLI:
     ```
     psql -U your_db_username -f db_init_corrected.sql
     ```
   - Replace `your_db_username` with your PostgreSQL username.

## Step 2: Start the Spring Boot Application
1. Open a terminal and navigate to the `Assignment-Xcelore` directory.
2. Run the application using Gradle wrapper:
   ```
   ./gradlew bootRun
   ```
3. The application will start on port 8082 (as configured).

## Step 3: Import Postman Collection
1. Open Postman.
2. Import the `Postman_Collection.json` file provided.
3. This collection contains requests to add doctors and patients.

## Step 4: Test API Endpoints
1. Use the imported requests to:
   - Add a new doctor.
   - Add a new patient.
2. Send the requests and observe the responses.
3. You can also extend the collection to test other endpoints like delete and suggest.

## Step 5: Explain the Application Flow
- Describe how the application handles requests.
- Show the database tables and how data is stored.
- Highlight the unit tests and service layer logic.

## Optional: Run Unit Tests
- You can run unit tests using:
  ```
  ./gradlew test
  ```
- Show the test reports to demonstrate coverage.

---

This guide should help you confidently demonstrate the application to the panel. If you need any scripts or further assistance, please let me know.
