package com.jonah.planner.exception;

public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(Long id) {
        super("Could not find note " + id);
    }

}
