package org.procedure.scheduling.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/patient")
public class PatientController {
	
	public PatientController(){
		
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public String navToPatientListPage(Model model) {
		return "patient/list";
	}

}
