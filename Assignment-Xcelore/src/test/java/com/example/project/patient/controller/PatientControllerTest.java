package com.example.project.patient.controller;

import com.example.project.patient.entity.Patient;
import com.example.project.patient.service.PatientService;
import com.example.project.files.ResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static com.example.project.files.ApplicationConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddPatient() {
        Patient patient = new Patient();
        ResponseModel responseModel = new ResponseModel();
        when(patientService.addPatient(any(Patient.class))).thenReturn(responseModel);

        ResponseModel response = patientController.addPatient(patient);
        assertEquals(responseModel, response);
        verify(patientService, times(1)).addPatient(patient);
    }

    @Test
    public void testDeletePatient() {
        Long patientId = 1L;
        ResponseModel responseModel = new ResponseModel();
        when(patientService.deletePatient(patientId)).thenReturn(responseModel);

        ResponseModel response = patientController.deletePatient(patientId);
        assertEquals(responseModel, response);
        verify(patientService, times(1)).deletePatient(patientId);
    }

    // Removed testSuggestPatients since suggestPatients method does not exist in PatientService and PatientController
}
