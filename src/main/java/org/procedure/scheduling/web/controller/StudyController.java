package org.procedure.scheduling.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Sex;
import org.procedure.scheduling.domain.Study;
import org.procedure.scheduling.domain.StudyStatus;
import org.procedure.scheduling.service.PatientService;
import org.procedure.scheduling.service.StudyService;
import org.procedure.scheduling.utils.UtilsService;
import org.procedure.scheduling.web.form.PatientForm;
import org.procedure.scheduling.web.form.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/study")
public class StudyController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private UtilsService utilsService;
	
	@Autowired
	private StudyService studyService;
	
	@RequestMapping(value="/add/{patientId}")
	public String navToAddStudyPage(Model model, @PathVariable("patientId") Integer patientId) {
		
		StudyForm studyForm = new StudyForm();
		
		model.addAttribute("study", studyForm);
		
		Patient patient = patientService.findById(patientId);
		
		model.addAttribute("patient", patient);
		
		List<String> status = Stream.of(StudyStatus.values())
                .map(StudyStatus::name)
                .collect(Collectors.toList());
		
		model.addAttribute("studyStatus", status);
		
		return "/study/add";
	}
	
	@RequestMapping(value="/add/action/{patientId}", method=RequestMethod.POST)
	public String addStudyAction(Model model, @PathVariable("patientId") Integer patientId, @ModelAttribute StudyForm studyForm) {
		Study study = utilsService.convertStudyFormToDomain(studyForm, patientId);
		studyService.createStudy(study);
		return "redirect:/patient";
	}

}
