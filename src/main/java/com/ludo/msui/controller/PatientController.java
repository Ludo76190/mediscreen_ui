package com.ludo.msui.controller;

import com.ludo.msui.model.Note;
import com.ludo.msui.model.Patient;
import com.ludo.msui.proxies.ReportProxy;
import com.ludo.msui.service.NoteProxyService;
import com.ludo.msui.service.PatientProxyService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {

    private static final Logger logger = LogManager.getLogger(PatientController.class);

    @Autowired
    private PatientProxyService patientProxy;

    @Autowired
    private NoteProxyService noteProxy;

    @Autowired
    private ReportProxy reportProxy;

    @GetMapping("/patient/list")
    public String getPatients(Model model) {
        List<Patient> patients = patientProxy.getPatients();
        model.addAttribute("patients", patients);

        return "patient/list";
    }

    @ApiOperation(value = "Get patient(s informations by id")
    @GetMapping("/patient/fiche/{id}")
    public String getPatient(@PathVariable Integer id, Model model) {
        Patient patient = patientProxy.getPatient(id);
        String risk = reportProxy.getReportByPatient(id);

        model.addAttribute("patient", patient);
        model.addAttribute("risk", risk);

        List<Note> notes = noteProxy.getNotesByPatient(id);
        model.addAttribute("notes", notes);

        return "patient/fichePatient";
    }

    @ApiOperation(value = "Get the add patient form")
    @GetMapping("/patient/add")
    public String showAddPatientForm(Patient patient) {
        return "patient/add";
    }

    @ApiOperation(value = "Post the add patient form")
    @PostMapping("/patient/add")
    public String submitAddPatientForm(@Valid Patient patient, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            patientProxy.addPatient(patient);
            model.addAttribute("patients", patientProxy.getPatients());
            logger.info("POST /patient/validate : OK");
            return "redirect:/patient/list";
        }
        logger.info("/patient/validate : KO");
        return "patient/add";
    }

    @ApiOperation(value = "Get the update patient form")
    @GetMapping("/patient/update/{id}")
    public String updatePatientForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("patient", patientProxy.getPatient(id));
        return "patient/update";
    }

    @ApiOperation(value = "Post the update patient form")
    @PostMapping("/patient/update/{id}")
    public String updatePatient(@Valid Patient patient, @PathVariable("id") int id, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            patientProxy.updatePatient(id, patient);
            model.addAttribute("patients", patientProxy.getPatients());
            logger.info("POST /patient/update : OK");
            return "redirect:/patient/fiche/{id}";
        }
        logger.info("/patient/update : KO");
        return "patient/update";
    }

    @ApiOperation(value = "Delete a patient by id")
    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patientProxy.deletePatient(id);
        return "redirect:/patient/list";
    }

}
