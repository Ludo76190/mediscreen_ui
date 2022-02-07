package com.ludo.msui.proxies;

import com.ludo.msui.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "mspatient", url = "${ms_patient.url}:9091")
public interface PatientProxy {

    @GetMapping("/patient/list")
    List<Patient> getPatients();

    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable int id);

    @PostMapping(value = "/patient/add", consumes = "application/json")
    Patient addPatient(@RequestBody Patient patient);

    @PostMapping("/patient/update/{id}")
    Patient updatePatient(@RequestBody Patient patient, @PathVariable int id);

    @GetMapping("/patient/delete/{id}")
    void deletePatient(@PathVariable Integer id);

}
