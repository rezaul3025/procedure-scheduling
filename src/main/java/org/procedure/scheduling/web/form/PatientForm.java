package org.procedure.scheduling.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Patient form class to represent patient form data
 * 
 * @author rkarim
 *
 */
public class PatientForm {

	public PatientForm() {

	}

	public PatientForm(String name, String patientSex, String dob) {
		this.name = name;
		this.patientSex = patientSex;
		this.dob = dob;
	}

	private Integer id;

	@NotNull
	@NotBlank
	private String name;

	private String patientSex;

	private String dob;

	private Integer doctorId;

	private Integer roomId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
}
