-- Create database
CREATE DATABASE healthcare_db;

-- Connect to the database (this is a client command, not SQL)
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

-- Insert doctors
INSERT INTO Doctor (name, city, email, phone_number, speciality) VALUES 
('Dr. A', 'Delhi', 'dr.a@hospital.com', '9876543210', 'Orthopaedic'),
('Dr. B', 'Noida', 'dr.b@hospital.com', '9876543211', 'Gynecology'),
('Dr. C', 'Faridabad', 'dr.c@hospital.com', '9876543212', 'Dermatology'),
('Dr. D', 'Delhi', 'dr.d@hospital.com', '9876543213', 'ENT');
