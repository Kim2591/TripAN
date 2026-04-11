package com.tripsdwh0.demo.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("En la montaña");
		lista.add("En la ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");
		model.addAttribute("listadoTrip", lista);
		
		return "listado2";
	}

}
