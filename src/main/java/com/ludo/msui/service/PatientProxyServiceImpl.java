package com.ludo.msui.service;

import com.ludo.msui.model.Patient;
import com.ludo.msui.proxies.PatientProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProxyServiceImpl implements PatientProxyService {

    private static final Logger logger = LogManager.getLogger(PatientProxyServiceImpl.class);

    @Autowired
    PatientProxy patientProxy;

    @Override
    public List<Patient> getPatients() {
        return patientProxy.getPatients();
    }

    @Override
    public Patient getPatient(int id) {
        return patientProxy.getPatient(id);
    }

    @Override
    public Patient addPatient(Patient patient) {
        logger.info("patient= " + patient.getLastName());
        patientProxy.addPatient(patient);
        return patient;
    }

    @Override
    public Patient updatePatient(int id, Patient patient) {
        return patientProxy.updatePatient(patient, id);
    }

    @Override
    public void deletePatient(int id) {
        patientProxy.deletePatient(id);
    }
}
