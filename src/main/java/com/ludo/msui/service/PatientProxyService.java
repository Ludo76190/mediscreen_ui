package com.ludo.msui.service;

import com.ludo.msui.model.Patient;

import java.util.List;

public interface PatientProxyService {

    List<Patient> getPatients();
    Patient getPatient(int id);
    Patient addPatient(Patient patient);
    Patient updatePatient(int id, Patient patient);
    void deletePatient(int id);

}
