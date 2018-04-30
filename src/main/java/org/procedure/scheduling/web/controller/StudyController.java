package org.procedure.scheduling.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Study;
import org.procedure.scheduling.domain.StudyStatus;
import org.procedure.scheduling.service.PatientService;
import org.procedure.scheduling.service.StudyService;
import org.procedure.scheduling.utils.UtilsService;
import org.procedure.scheduling.validation.ValidationService;
import org.procedure.scheduling.web.form.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Study controller class to provide the Study related interaction between the
 * Study data interface and data service layer
 * 
 * @author rkarim
 *
 */

@Controller
@RequestMapping(value = "/study")
public class StudyController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private UtilsService utilsService;

	@Autowired
	private StudyService studyService;

	@Autowired
	private ValidationService validationService;

	// Get all studies and navigate to study list page
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String navToStudyListPage(Model model) {
		model.addAttribute("studies", studyService.findAll());
		return "study/list";
	}

	// Find all studies for patient
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public String navToPatientStudiesPage(Model model, @PathVariable("id") Integer id) {
		Patient patient = patientService.findById(id);
		model.addAttribute("patient", patient);
		model.addAttribute("studies", studyService.findByPatient(patient));
		return "patient/studies";
	}

	// Navigate to add study for patient page, get and initialize necessary
	// information
	@RequestMapping(value = "/add/{patientId}")
	public String navToAddStudyPage(Model model, @PathVariable("patientId") Integer patientId) {

		StudyForm studyForm = new StudyForm();

		model.addAttribute("studyForm", studyForm);

		Patient patient = patientService.findById(patientId);

		model.addAttribute("patient", patient);

		List<String> status = Stream.of(StudyStatus.values()).map(StudyStatus::name).collect(Collectors.toList());

		model.addAttribute("studyStatus", status);

		model.addAttribute("operation", "C");

		return "/study/add";
	}

	// Navigate to update study page for patient, get and initialize necessary
	// information
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String navToUpdateStudyPage(Model model, @PathVariable("id") Integer id) {

		StudyForm studyForm = utilsService.convertDomainToStudyForm(id);

		model.addAttribute("studyForm", studyForm);

		model.addAttribute("patient", studyForm.getPatient());

		List<String> status = Stream.of(StudyStatus.values()).map(StudyStatus::name).collect(Collectors.toList());

		model.addAttribute("studyStatus", status);

		model.addAttribute("operation", "U");

		// Same add study view also use for update
		return "study/add";
	}

	// Add study information for patient
	@RequestMapping(value = "/add/action/{patientId}", method = RequestMethod.POST)
	public String addStudyAction(Model model, @PathVariable("patientId") Integer patientId,
			@ModelAttribute("studyForm") @Valid StudyForm studyForm, RedirectAttributes attr) {

		List<String> validationMesg = validationService.studyFormValidation(studyForm);

		boolean isValid = validationMesg.isEmpty();

		if (!isValid) {
			attr.addFlashAttribute("validationMesg", validationMesg);
			return "redirect:/study/add/" + patientId;
		}

		Study study = utilsService.convertStudyFormToDomain(studyForm, patientId);

		studyService.createStudy(study);

		return "redirect:/patient";
	}

	// Update study information for patient
	@RequestMapping(value = "/update/action/{patientId}", method = RequestMethod.POST)
	public String updateStudyAction(Model model, @PathVariable("patientId") Integer patientId,
			@ModelAttribute("studyForm") @Valid StudyForm studyForm) {

		Study study = utilsService.convertStudyFormToDomain(studyForm, patientId);

		studyService.updateStudy(study);

		return "redirect:/study/patient/" + study.getPatient().getId();
	}

	// Delete study information
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePatient(Model model, @PathVariable("id") Integer id) {

		studyService.deleteStudy(id);

		return "redirect:/study";
	}

}
