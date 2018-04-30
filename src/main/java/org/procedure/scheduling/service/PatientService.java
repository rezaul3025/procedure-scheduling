package org.procedure.scheduling.service;

import java.util.List;

import org.procedure.scheduling.domain.Patient;

public interface PatientService {

	Patient addPatient(Patient patient);

	void deletePatient(Integer id);

	Patient updatePatient(Patient patient);

	List<Patient> findAll();

	Patient findById(Integer id);
}
