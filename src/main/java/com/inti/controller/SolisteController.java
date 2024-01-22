package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Soliste;
import com.inti.service.ISolisteService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Hayri ACAR
 * 
 * Permet de réaliser les opérations CRUD
 */


@Controller
@RequestMapping(value = {"soliste", "sol"})
@Slf4j
public class SolisteController {
	
	@Autowired
	ISolisteService iss;
	
	@GetMapping("getAllSoliste")
	@Secured({"ROLE_ADMIN"})
	public String getAllSoliste(Model m)
	{
		m.addAttribute("listeSoliste", iss.getAllSoliste());
		
		log.info("Affichage de tous les solistes");
		
		return "getAllSoliste";
	}
	
	@GetMapping("formSoliste")
	public String formSoliste() {
		return "formSoliste";
	}
	
	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste soliste)
	{
		iss.save(soliste);
		
		return "redirect:getAllSoliste";
	}
	
	@GetMapping("deleteSoliste/{num}")
	public String deleteSoliste(@PathVariable("num") Long num) {
		iss.delete(num);
		return "redirect:/soliste/getAllSoliste";
	}
	
	@GetMapping("updateSoliste/{num}")
	public String updateSoliste(@PathVariable("num") Long num, Model m) {
		m.addAttribute("soliste", iss.getSoliste(num));
		return "formUpdateSoliste";
	}
	
	@PostMapping("updateSoliste")
	public String updateSoliste(@ModelAttribute("solist") Soliste soliste)
	{
		iss.save(soliste);
		
		return "redirect:getAllSoliste";
	}
	

}
