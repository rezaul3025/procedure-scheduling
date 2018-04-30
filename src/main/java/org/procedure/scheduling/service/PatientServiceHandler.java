package org.procedure.scheduling.service;

import java.util.List;

import org.procedure.scheduling.dao.PatientRepository;
import org.procedure.scheduling.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Patient service class
 * 
 * @author rkarim
 *
 */
@Service
public class PatientServiceHandler implements PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public Patient addPatient(Patient patient) {
		
		return patientRepo.saveAndFlush(patient);
	}
	
	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepo.saveAndFlush(patient);
	}

	@Override
	public void deletePatient(Integer id) {
		patientRepo.deleteById(id);
	}

	@Override
	public List<Patient> findAll() {
		return patientRepo.findAll();
	}

	@Override
	public Patient findById(Integer id) {
		return patientRepo.findById(id).get();
	}

}
