package com.bluestaq.assessment.notetaker.rest;

import com.bluestaq.assessment.notetaker.data.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotesController {

    @GetMapping("/notes")
    public List<Note> getNotes(String username) {
        return null;
    }
}
