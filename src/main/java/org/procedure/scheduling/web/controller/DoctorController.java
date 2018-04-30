package org.procedure.scheduling.web.controller;

import org.procedure.scheduling.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Doctor controller class to provide the doctor related interaction between the
 * doctor data interface and data service layer
 * 
 * @author rkarim
 *
 */
@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String navToDoctorListPage(Model model) {

		model.addAttribute("doctors", doctorService.findAll());

		return "doctor/list";
	}
}
