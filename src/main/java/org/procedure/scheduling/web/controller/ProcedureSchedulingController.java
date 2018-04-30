package org.procedure.scheduling.web.controller;

import org.procedure.scheduling.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class ProcedureSchedulingController {

	@Autowired
	private PatientService patientService;

	public ProcedureSchedulingController() {

	}

	// Navigate to application landing page , in this case landing page is patient
	// list page
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String navToLandingPage(Model model) {
		model.addAttribute("patients", patientService.findAll());

		return "patient/list";
	}

}
