package com.bd.mysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassController {
	
	//declaramos un metodo
	//ruteamos
	@GetMapping({"/index","/home","/"})
	public String index() {
		//retornamos la vista
		return "index";
		
	}  //fin del metodo index...

}   //fin de la clase class controler
