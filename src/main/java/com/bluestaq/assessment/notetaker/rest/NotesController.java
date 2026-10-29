package com.bluestaq.assessment.notetaker.rest;

import com.bluestaq.assessment.notetaker.data.Note;
import com.bluestaq.assessment.notetaker.exceptions.InvalidNoteIdException;
import com.bluestaq.assessment.notetaker.exceptions.InvalidUsernameException;
import com.bluestaq.assessment.notetaker.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;

    @GetMapping("/getAllNotes")
    public Iterable<Note> getNotes() {
        return notesService.getAllNotes();
    }

    @GetMapping("/getNotesForUser/{username}")
    public Iterable<Note> getNotesForUser(@PathVariable("username")String username) {
        return notesService.getNotesForUser(username);
    }

    @PostMapping("/createNote/{username}")
    public String createNote(@PathVariable("username")String username, @RequestBody String text) {
        //TODO: replace the returning of a string status message with a ResponseEntity<Note>,
        // after figuring out how to do that for Spring Boot
        String statusMessage;
        try {
            notesService.createNote(username, text);
            statusMessage = "success";
        } catch (InvalidUsernameException e) {
            statusMessage = e.getMessage();
        }

        return statusMessage;
    }

    @PutMapping("/updateNote/{noteId}")
    public String updateNote(@PathVariable("noteId") Long noteId, @RequestBody String text) {
        //TODO: replace the returning of a string status message with a ResponseEntity<Note>,
        // after figuring out how to do that for Spring Boot
        String statusMessage;

        try {
            notesService.updateNote(noteId, text);
            statusMessage = "success";
        } catch (InvalidNoteIdException e) {
            statusMessage = e.getMessage();
        }

        return statusMessage;
    }

    @DeleteMapping("deleteNote/{noteId}")
    public String deleteNote(@PathVariable("noteId") Long noteId) {
        //TODO: replace the returning of a string status message with a ResponseEntity,
        // after figuring out how to do that for Spring Boot
        String statusMessage;

        try {
            notesService.deleteNote(noteId);
            statusMessage = "success";
        } catch (InvalidNoteIdException e) {
            statusMessage = e.getMessage();
        }

        return statusMessage;
    }
}
