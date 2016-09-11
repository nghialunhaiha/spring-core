package org.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    public BaseController() {
    }

    protected <T> ResponseEntity<T> response(T data) {
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }
}
