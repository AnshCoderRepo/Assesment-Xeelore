-- Create Doctor table
CREATE TABLE IF NOT EXISTS Doctor (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    speciality VARCHAR(255),
    is_active BOOLEAN DEFAULT true
);

-- Insert doctors
INSERT INTO Doctor (name, city, email, phone_number, speciality) VALUES 
('Dr. A', 'Delhi', 'dr.a@hospital.com', '9876543219', 'Orthopaedic'),
('Dr. B', 'Noida', 'dr.b@hospital.com', '9876543211', 'Gynecology'), 
('Dr. C', 'Faridabad', 'dr.c@hospital.com', '9876543212', 'Dermatology'), 
('Dr. D', 'Delhi', 'dr.d@hospital.com', '9876543213', 'ENT');

-- Create Patient table
CREATE TABLE IF NOT EXISTS Patient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    symptom VARCHAR(255)
);

-- Insert patients
INSERT INTO Patient (name, city, email, phone_number, symptom) VALUES 
('Patient 1', 'Delhi', 'patient1@healthcare.com', '9123456789', 'Arthritis'),
('Patient 2', 'Noida', 'patient2@healthcare.com', '9123456798', 'Dysmenorrhea'), 
('Patient 3', 'Faridabad', 'patient3@healthcare.com', '9123456791', 'Skin infection'), 
('Patient 4', 'Delhi', 'patient4@healthcare.com', '9123456792', 'Ear pain');

-- Create indexes
CREATE INDEX IF NOT EXISTS idx_doctor_city_speciality ON Doctor(city, speciality);
CREATE INDEX IF NOT EXISTS idx_patient_city_symptom ON Patient(city, symptom);
