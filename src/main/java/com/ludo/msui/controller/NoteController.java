package com.ludo.msui.controller;

import com.ludo.msui.model.Note;
import com.ludo.msui.service.NoteProxyService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class NoteController {

    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteProxyService noteProxyService;

    @ApiOperation(value = "Get the add note form")
    @GetMapping("/note/add")
    public String showAddNoteForm(@RequestParam int patientId, Model model){
        logger.info("GET /addNote patientId : " + patientId);
        Note note = new Note();
        note.setPatientId(patientId);
        model.addAttribute("currentNote", note);
        return "note/noteForm";
    }

    @ApiOperation(value = "Post the add note form")
    @PostMapping("/note/add")
    public String submitAddNoteForm(@ModelAttribute @Valid Note note, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            logger.info("patientID = " + note.getPatientId());
            noteProxyService.saveNote(note);
            model.addAttribute("notes", note);
            return "redirect:/patient/fiche/" + note.getPatientId();
        }

        return "note/add";
    }

    @ApiOperation(value = "Delete a note by id and patientId")
    @GetMapping("/note/delete/{id}/{patientId}")
    public String deletePatient(@PathVariable String id, @PathVariable int patientId) {
        noteProxyService.deleteNote(id);
        return "redirect:/patient/fiche/{patientId}";
    }

    @ApiOperation(value = "Get the update note form by id")
    @GetMapping("/note/update/{id}")
    public String showUpdateNoteForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("currentNote", noteProxyService.findNote(id));
        return "note/update";
    }

    @ApiOperation(value = "Post the update note form")
    @PostMapping("/note/update/{id}/{patientId}")
    public String updateNote(@PathVariable String id, @ModelAttribute("currentNote") Note currentNote, Model model) {
        // get note from database by id
        Note existingNote = noteProxyService.findNote(id);
        existingNote.setNote(currentNote.getNote());

        //save updated note
        noteProxyService.updateNote(existingNote);
        return "redirect:/patient/fiche/{patientId}";
    }

}
