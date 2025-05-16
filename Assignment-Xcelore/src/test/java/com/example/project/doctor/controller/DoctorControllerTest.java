package com.example.project.doctor.controller;

import com.example.project.doctor.entity.Doctor;
import com.example.project.doctor.service.DoctorService;
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

public class DoctorControllerTest {

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorController doctorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddDoctor() {
        Doctor doctor = new Doctor();
        ResponseModel responseModel = new ResponseModel();
        when(doctorService.addDoctor(any(Doctor.class))).thenReturn(responseModel);

        ResponseModel response = doctorController.addDoctor(doctor);
        assertEquals(responseModel, response);
        verify(doctorService, times(1)).addDoctor(doctor);
    }

    @Test
    public void testDeleteDoctor() {
        Long doctorId = 1L;
        ResponseModel responseModel = new ResponseModel();
        when(doctorService.deleteDoctor(doctorId)).thenReturn(responseModel);

        ResponseModel response = doctorController.deleteDoctor(doctorId);
        assertEquals(responseModel, response);
        verify(doctorService, times(1)).deleteDoctor(doctorId);
    }

    @Test
    public void testSuggestDoctors() {
        Long patientId = 1L;
        ResponseModel responseModel = new ResponseModel();
        when(doctorService.suggestDoctors(patientId)).thenReturn(responseModel);

        ResponseEntity<ResponseModel> responseEntity = doctorController.suggestDoctors(patientId);
        assertEquals(responseModel, responseEntity.getBody());
        verify(doctorService, times(1)).suggestDoctors(patientId);
    }
}
