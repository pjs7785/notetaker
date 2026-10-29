package com.bluestaq.assessment.notetaker.services;

import com.bluestaq.assessment.notetaker.data.Note;
import com.bluestaq.assessment.notetaker.data.User;
import com.bluestaq.assessment.notetaker.exceptions.InvalidNoteIdException;
import com.bluestaq.assessment.notetaker.exceptions.InvalidUsernameException;
import com.bluestaq.assessment.notetaker.repositories.NoteRepository;
import com.bluestaq.assessment.notetaker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    public Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Iterable<Note> getNotesForUser(String username) {
        return noteRepository.findByUserUserName(username);
    }

    public void createNote(String username, String text) throws InvalidUsernameException{
        User user = userRepository.findByUserName(username);

        if (user != null) {
            Note note = new Note();
            note.setUser(user);
            note.setText(text);
            noteRepository.save(note);
        } else {
            throw new InvalidUsernameException(username);
        }
    }

    public void updateNote(Long id, String text) throws InvalidNoteIdException {
        Optional<Note> note = noteRepository.findById(id);

        if (note.isPresent()) {
            Note noteValue = note.get();
            noteValue.setText(text);
            noteRepository.save(noteValue);
        } else {
            throw new InvalidNoteIdException(id);
        }
    }

    public void deleteNote(Long id) throws InvalidNoteIdException {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new InvalidNoteIdException(id);
        }
    }
}
