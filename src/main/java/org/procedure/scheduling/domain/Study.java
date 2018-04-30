package org.procedure.scheduling.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Study domain class which is map to study table
 * 
 * @author rkarim
 *
 */
@Entity
@Table(name = "study")
public class Study {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	@NotNull
	private Patient patient;

	@NotNull
	private String description;

	@NotNull
	private StudyStatus status;

	@NotNull
	@Column(name = "planned_start_time")
	private LocalDateTime plannedStartTime;

	@Column(name = "estimated_end_time")
	private LocalDateTime estimatedEndTime;

	public Study() {

	}

	public Study(Patient patient, String description, StudyStatus status, LocalDateTime plannedStartTime,
			LocalDateTime estimatedEndTime) {
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
