package com.apimanipular.jpa_api.exceptions;

public class TaskAlreadyFinalizedException extends RuntimeException {
    public TaskAlreadyFinalizedException(String message) {
        super(message);
    }
}
