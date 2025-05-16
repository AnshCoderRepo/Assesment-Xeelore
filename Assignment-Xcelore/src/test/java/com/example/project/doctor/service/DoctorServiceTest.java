package com.example.project.doctor.service;

import com.example.project.doctor.entity.Doctor;
import com.example.project.doctor.repository.DoctorRepository;
import com.example.project.files.ResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddDoctor() {
        Doctor doctor = new Doctor();
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        ResponseModel response = doctorService.addDoctor(doctor);
        assertNotNull(response);
        verify(doctorRepository, times(1)).save(doctor);
    }

    @Test
    public void testDeleteDoctor() {
        Long doctorId = 1L;
        doNothing().when(doctorRepository).deleteById(doctorId);

        ResponseModel response = doctorService.deleteDoctor(doctorId);
        assertNotNull(response);
        verify(doctorRepository, times(1)).deleteById(doctorId);
    }

    @Test
    public void testSuggestDoctors() {
        Long patientId = 1L;
        // Add mock behavior for suggestDoctors logic as needed
        ResponseModel response = doctorService.suggestDoctors(patientId);
        assertNotNull(response);
    }
}
