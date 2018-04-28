package org.procedure.scheduling.web.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.procedure.scheduling.domain.Sex;

public class PatientForm {

	public PatientForm() {
		
	}
	
	public PatientForm(String name, Sex patientSex, LocalDate dob)
	{
		this.name=name;
		this.patientSex = patientSex;
		this.dob = dob;
	}
	

	private Integer id;
	
	@NotNull
	private String name;
	
	private Sex patientSex;
	
	private LocalDate dob;

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

	public Sex getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(Sex patientSex) {
		this.patientSex = patientSex;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
