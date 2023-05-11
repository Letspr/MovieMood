package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exceptions.ServicioException;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler({ ServicioException.class, Exception.class })
    public String  handleException(Model model) {
		
		model.addAttribute( "mensaje","Se ha producido un error.");		

		return "error";
    }
}
