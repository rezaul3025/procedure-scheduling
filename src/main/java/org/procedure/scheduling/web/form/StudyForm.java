package org.procedure.scheduling.web.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.StudyStatus;

public class StudyForm {

	private Integer id;
	
	@NotNull
	private Patient patient;
	
	@NotNull
	private String description;
	
	@NotNull
	private StudyStatus status;
	
	private LocalDateTime plannedStartTime;
	
	private LocalDateTime estimatedEndTime;
	
	public StudyForm() {
		
	}
	
	public StudyForm(Patient patient, String description, StudyStatus status, LocalDateTime plannedStartTime, LocalDateTime estimatedEndTime) {
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

	public StudyStatus getStatus() {
		return status;
	}

	public void setStatus(StudyStatus status) {
		this.status = status;
	}

	public LocalDateTime getPlannedStartTime() {
		return plannedStartTime;
	}

	public void setPlannedStartTime(LocalDateTime plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}

	public LocalDateTime getEstimatedEndTime() {
		return estimatedEndTime;
	}

	public void setEstimatedEndTime(LocalDateTime estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}
}
