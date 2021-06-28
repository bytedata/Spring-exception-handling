package com.bytedata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bytedata.exception.OrderException;
import com.bytedata.model.ErrorDto;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ErrorDto> mapExceptionAdvice(OrderException oe){
		ErrorDto errorDto = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), oe.getMessage());
		return new ResponseEntity<ErrorDto>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
