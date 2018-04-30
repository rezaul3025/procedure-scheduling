/**
 * 
 */
package org.procedure.scheduling.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Patient domain class which is map to patient table
 * 
 * @author rkarim
 *
 */
@Entity
@Table(name = "patient")
public class Patient {

	/**
	 * 
	 */
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, Sex patientSex, LocalDate dob) {
		this.setName(name);
		this.patientSex = patientSex;
		this.dob = dob;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String name;

	@Column(name = "sex")
	private Sex patientSex;

	private LocalDate dob;

	// Column 'room_id' in 'patient' table will be null if no room assign during
	// creation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;

	// Column 'doctor_id' in 'patient' table will be null if no doctor assign during
	// creation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<Study> studies = new HashSet<>();

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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Set<Study> getStudies() {
		return studies;
	}

	public void setStudies(Set<Study> studies) {
		this.studies = studies;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
