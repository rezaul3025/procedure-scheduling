package org.procedure.scheduling.service;

import java.util.List;

import org.procedure.scheduling.dao.StudyRepository;
import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Study service class
 * 
 * @author rkarim
 *
 */
@Service
public class StudyServiceHandler implements StudyService{
	
	@Autowired
	private StudyRepository studyRepo;
	
	@Override
	public Study createStudy(Study study) {
		return studyRepo.saveAndFlush(study);
	}

	@Override
	public void deleteStudy(Integer id) {
		studyRepo.deleteById(id);
	}

	@Override
	public Study updateStudy(Study study) {
		return studyRepo.saveAndFlush(study);
	}

	@Override
	public Study findById(Integer id) {
		
		return studyRepo.findById(id).get();
	}

	@Override
	public List<Study> findAll() {
		return studyRepo.findAll();
	}

	@Override
	public List<Study> findByPatient(Patient patient) {
		
		return studyRepo.findByPatient(patient);
	}

}
