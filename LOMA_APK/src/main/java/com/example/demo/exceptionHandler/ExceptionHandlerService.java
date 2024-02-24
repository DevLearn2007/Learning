package com.example.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.DateException;
import com.example.demo.exception.ShapeException;
import com.example.demo.model.ErrorBox;

@RestControllerAdvice
public class ExceptionHandlerService {
	@ExceptionHandler(DateException.class)
	public ErrorBox handler(DateException ex) {
		ErrorBox ebox=new ErrorBox(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ebox;
	}
	
	@ExceptionHandler(ShapeException.class)
	public ErrorBox handler(ShapeException ex) {
		ErrorBox ebox=new ErrorBox(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ebox;
	}

}
