package com.ludo.msui.service;

import com.ludo.msui.model.Patient;
import com.ludo.msui.proxies.PatientProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PatientProxyServiceImplTest {

    private PatientProxyServiceImpl patientProxyServiceImplUnderTest;

    final Patient patient = new Patient();
    final Patient patient1 = new Patient();

    @BeforeEach
    void setUp() {
        patientProxyServiceImplUnderTest = new PatientProxyServiceImpl();
        patientProxyServiceImplUnderTest.patientProxy = mock(PatientProxy.class);

        patient.setId(1);
        patient.setFirstName("firstName");
        patient.setLastName("lastName");
        patient.setBirthdate(LocalDate.of(2020, 1, 1));
        patient.setSex("M");
        patient.setAddress("address");
        patient.setPhone("phone");


        patient1.setId(2);
        patient1.setFirstName("firstName");
        patient1.setLastName("lastName");
        patient1.setBirthdate(LocalDate.of(2020, 1, 1));
        patient1.setSex("sex");
        patient1.setAddress("address");
        patient1.setPhone("phone");

    }

    @Test
    void testGetPatients() {
        final List<Patient> patients = Collections.singletonList(patient);
        when(patientProxyServiceImplUnderTest.patientProxy.getPatients()).thenReturn(patients);

        final List<Patient> result = patientProxyServiceImplUnderTest.getPatients();

        verify(patientProxyServiceImplUnderTest.patientProxy).getPatients();

    }

    @Test
    void testGetPatients_PatientProxyReturnsNoItems() {
        when(patientProxyServiceImplUnderTest.patientProxy.getPatients()).thenReturn(Collections.emptyList());

        final List<Patient> result = patientProxyServiceImplUnderTest.getPatients();

        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetPatient() {
        when(patientProxyServiceImplUnderTest.patientProxy.getPatient(1)).thenReturn(patient);

        final Patient result = patientProxyServiceImplUnderTest.getPatient(1);

        verify(patientProxyServiceImplUnderTest.patientProxy).getPatient(1);

    }

    @Test
    void testAddPatient() {

        when(patientProxyServiceImplUnderTest.patientProxy.addPatient(any(Patient.class))).thenReturn(patient1);

        final Patient result = patientProxyServiceImplUnderTest.addPatient(patient);

        verify(patientProxyServiceImplUnderTest.patientProxy).addPatient(any(Patient.class));
    }

    @Test
    void testUpdatePatient() {
        when(patientProxyServiceImplUnderTest.patientProxy.updatePatient(any(Patient.class), eq(2))).thenReturn(patient1);

        final Patient result = patientProxyServiceImplUnderTest.updatePatient(1, patient);

        verify(patientProxyServiceImplUnderTest.patientProxy).updatePatient(patient, 1);

    }

    @Test
    void testDeletePatient() {
        patientProxyServiceImplUnderTest.deletePatient(1);

        verify(patientProxyServiceImplUnderTest.patientProxy).deletePatient(1);
    }
}
