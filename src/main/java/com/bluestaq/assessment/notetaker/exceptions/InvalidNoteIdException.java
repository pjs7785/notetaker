package com.bluestaq.assessment.notetaker.exceptions;

public class InvalidNoteIdException extends Exception {
    public InvalidNoteIdException(Long noteId) {
        super("The note Id " + noteId + " is invalid");
    }
}
