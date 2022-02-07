package com.ludo.msui.service;

import com.ludo.msui.model.Note;

import java.util.List;

public interface NoteProxyService {

    List<Note> getAllNotes();
    List<Note> getNotesByPatient(int patientId);
    Note findNote(String noteId);
    Note saveNote(Note note);
    Note updateNote(Note note);
    void deleteNote(String id);

}
