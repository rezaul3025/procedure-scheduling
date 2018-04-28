package org.procedure.scheduling.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class ProcedureSchedulingController {

	public ProcedureSchedulingController() {
		
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String navToLandingPage(Model model) {
		return "index";
	}

}
