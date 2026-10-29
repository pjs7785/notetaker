package com.bluestaq.assessment.notetaker.exceptions;

public class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String username) {
        super("The username " + username + " is invalid");
    }
}
