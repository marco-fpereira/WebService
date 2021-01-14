package com.example.WebService.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.WebService.service.exceptions.DatabaseException;
import com.example.WebService.service.exceptions.ResourceNotFoundException;

@ControllerAdvice	//It'll intercept the exceptions that occur, so that this object may execute a handling
public class ResourceExceptionHandler {

	//this annotation is used so that this method be able to intercept the request that gave an exception of this type, so that it falls here
	@ExceptionHandler(ResourceNotFoundException.class)	
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)	
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
