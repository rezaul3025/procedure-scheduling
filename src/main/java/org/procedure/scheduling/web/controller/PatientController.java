package org.procedure.scheduling.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Sex;
import org.procedure.scheduling.service.DoctorService;
import org.procedure.scheduling.service.PatientService;
import org.procedure.scheduling.service.RoomService;
import org.procedure.scheduling.utils.UtilsService;
import org.procedure.scheduling.web.form.PatientForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UtilsService utilsService;
	
	public PatientController(){
		
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public String navToPatientListPage(Model model) {
		model.addAttribute("patients", patientService.findAll());
		return "patient/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String navToAddPatientPage(Model model) {
		
		model.addAttribute("patientForm", new PatientForm());
		
		model.addAttribute("doctors", doctorService.findAll());
		
		model.addAttribute("rooms", roomService.findAll());
		
		List<String> patientSex = Stream.of(Sex.values())
                .map(Sex::name)
                .collect(Collectors.toList());
		
		model.addAttribute("patientSex", patientSex);
		
		model.addAttribute("operation", "A");
		
		return "patient/add";
	}
	
	@RequestMapping(value="/add/action", method=RequestMethod.POST)
	public String addPatientAction(Model model, @ModelAttribute PatientForm patientForm) {
		Patient patient = utilsService.convertPatientFormToDomain(patientForm);
		patientService.addPatient(patient);
		return "redirect:/patient";
	}
	
	@RequestMapping(value="/update/{patientId}", method=RequestMethod.GET)
	public String navToUpdatePatientPage(Model model, @PathVariable("patientId") Integer patientId) {
		
		PatientForm patientForm = utilsService.convertPatientDomainToForm(patientId);
		
		model.addAttribute("patientForm", patientForm);
		
		model.addAttribute("doctors", doctorService.findAll());
		
		model.addAttribute("rooms", roomService.findAll());
		
		List<String> patientSex = Stream.of(Sex.values())
                .map(Sex::name)
                .collect(Collectors.toList());
		
		model.addAttribute("patientSex", patientSex);
		
		model.addAttribute("operation", "U");
	
		//Same add patient also use update
		return "patient/add";
	}
	
	@RequestMapping(value="/update/action", method=RequestMethod.POST)
	public String updatePatientAction(Model model, @ModelAttribute PatientForm patientForm) {
		
		Patient patient = utilsService.convertPatientFormToDomain(patientForm);

		patientService.updatePatient(patient);
		
		return "redirect:/patient";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deletePatient(Model model, @PathVariable("id") Integer id) {
		
		patientService.deletePatient(id);
		
		return "redirect:/patient";
	}

}
