package org.procedure.scheduling.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.procedure.scheduling.domain.Patient;

/**
 * Study form class to represent the study form data
 * 
 * @author rkarim
 *
 */
public class StudyForm {

	private Integer id;

	private Patient patient;

	@NotNull
	@NotBlank
	private String description;

	@NotNull
	@NotBlank
	private String status;

	@NotNull
	@NotBlank
	private String plannedStartTime;

	private String estimatedEndTime;

	public StudyForm() {

	}

	public StudyForm(Patient patient, String description, String status, String plannedStartTime,
			String estimatedEndTime) {
		this.patient = patient;
		this.description = description;
		this.status = status;
		this.plannedStartTime = plannedStartTime;
		this.estimatedEndTime = estimatedEndTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlannedStartTime() {
		return plannedStartTime;
	}

	public void setPlannedStartTime(String plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}

	public String getEstimatedEndTime() {
		return estimatedEndTime;
	}

	public void setEstimatedEndTime(String estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}
}
