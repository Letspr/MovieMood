package com.lets.movieMood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lets.movieMood.exceptions.ServicioException;

@Controller
public class ControladorError {

	@ExceptionHandler({ ServicioException.class, Exception.class })
    public String  handleException(Model model) {
		
		model.addAttribute("mensaje","Se ha producido un error.");		

		return "error";
    }
}
