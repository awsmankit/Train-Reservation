package com.train.exception;

import java.util.Date;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice // Indicates that this class provides exception handling for RESTful
						// controllers.
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // This method handles the ResourceNotFoundException.
	public ResponseEntity<ErrorDetails> HandelResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest request) {
		// This method returns an error response entity when a ResourceNotFoundException
		// is thrown.

		ErrorDetails errorDetails = new ErrorDetails(new Date(), "null", request.getDescription(false));
		// Create an instance of ErrorDetails class with error details.

		System.out.println("Error =" + exception.getMessage() + "   path: " + request.getDescription(false));
		// Log the error message.

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND); // Return the error response entity
																						// with HTTP status NOT_FOUND.
	}

	@ExceptionHandler(Exception.class) // This method handles all other exceptions.
	public ResponseEntity<ErrorDetails> HandelException(Exception exception, WebRequest request) {
		// This method returns an error response entity when any other exception is
		// thrown.

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		// Create an instance of ErrorDetails class with error details.

		System.out.println("Error =" + exception.getMessage() + "   path: " + request.getDescription(false));
		// Log the error message.

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR); // Return the error
																									// response entity
																									// with HTTP status
																									// INTERNAL_SERVER_ERROR.
	}

}
