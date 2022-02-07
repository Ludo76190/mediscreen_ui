package com.ludo.msui.service;


import com.ludo.msui.model.Note;
import com.ludo.msui.proxies.NoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteProxyServiceImpl implements NoteProxyService {

    private static final Logger logger = LoggerFactory.getLogger(NoteProxyServiceImpl.class);

    @Autowired
    private NoteProxy noteProxy;

    @Override
    public List<Note> getAllNotes() {
        return noteProxy.getAll();
    }

    @Override
    public List<Note> getNotesByPatient(int patientId) {
        return noteProxy.getNotesForPatientId(patientId);
    }

    @Override
    public Note findNote(String noteId) {
        return noteProxy.findNote(noteId);
    }

    @Override
    public Note saveNote(Note noteToSave) {
        return noteProxy.saveNote(noteToSave);
    }

    @Override
    public Note updateNote(Note note) {
        return noteProxy.updateNote(note);
    }

    @Override
    public void deleteNote(String id) {
        noteProxy.deleteNote(id);
    }
}
