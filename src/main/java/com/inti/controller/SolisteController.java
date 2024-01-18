package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.service.ISolisteService;

/**
 * @author Hayri ACAR
 * 
 * Permet de réaliser les opérations CRUD
 */


@Controller
@RequestMapping(value = {"soliste", "sol"})
public class SolisteController {
	
	@Autowired
	ISolisteService iss;
	
	@GetMapping("getAllSoliste")
	public String getAllSoliste(Model m)
	{
		m.addAttribute("listeSoliste", iss.getAllSoliste());
		
		return "getAllSoliste";
	}

}
