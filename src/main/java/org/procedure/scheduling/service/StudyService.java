package org.procedure.scheduling.service;

import java.util.List;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Study;

public interface StudyService {

	Study createStudy(Study study);

	void deleteStudy(Integer id);

	Study updateStudy(Study study);

	Study findById(Integer id);

	List<Study> findAll();

	List<Study> findByPatient(Patient patient);
}
