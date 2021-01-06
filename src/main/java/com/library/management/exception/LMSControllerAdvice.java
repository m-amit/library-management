package com.library.management.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.library.management.models.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class LMSControllerAdvice {

  public static final Logger logger = LoggerFactory.getLogger(LMSControllerAdvice.class);

  @ExceptionHandler(UnrecognizedPropertyException.class)
  public ResponseEntity<Object> unrecognizedPropertyException() {
    logger.info("IMSControllerAdvice :: unrecognizedPropertyException {}", "UnrecognizedPropertyException Error has been thrown...");
    Response response = new Response("Error", "Requested Service is not available");
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity processRuntimeException(HttpServletRequest req, RuntimeException ex) {
    Response response = new Response("Error", ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
