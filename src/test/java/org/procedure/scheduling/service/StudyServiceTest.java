package org.procedure.scheduling.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.procedure.scheduling.ProcedureSchedulingApplication;
import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Study;
import org.procedure.scheduling.domain.StudyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProcedureSchedulingApplication.class)
public class StudyServiceTest {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private StudyService studytService;
	
	@Test
	public void createStudyTest() { 
		
		Patient patient = patientService.findById(1);
		LocalDateTime plannedStartTime = LocalDateTime.of(LocalDate.of(2018, 04, 28), LocalTime.of(9, 30));
		LocalDateTime estimatedEndTime = LocalDateTime.of(LocalDate.of(2018, 04, 28), LocalTime.of(13, 30));
		
		Study study = new Study(patient, "Study desc", StudyStatus.Planned, plannedStartTime, estimatedEndTime);
		
		study = studytService.createStudy(study);
		assertEquals(Integer.valueOf(5), Integer.valueOf(study.getId()));
	}
	
	@Test
	public void updateStudyTest() { 
		
		LocalDateTime estimatedEndTime = LocalDateTime.of(LocalDate.of(2018, 04, 28), LocalTime.of(14, 30));
			
		Study study = studytService.findById(4);
		
		study.setDescription("Study desc new");
		
		study.setEstimatedEndTime(estimatedEndTime);
		
		study.setStatus(StudyStatus.InProgress);
		
		study = studytService.updateStudy(study);
		
		assertEquals("Study desc new", study.getDescription());
		
		assertEquals(estimatedEndTime, study.getEstimatedEndTime());
		
		assertEquals(StudyStatus.InProgress, study.getStatus().InProgress);

	}
	
	@Test
	public void deleteStudyTest() {
		
		studytService.deleteStudy(1);
		
		List<Study> studies = studytService.findAll();
		
		assertEquals(Integer.valueOf(3), Integer.valueOf(studies.size()));
		
	}
	
	@Test
	public void findStudyByPatientTest() {
		
		Patient patient = patientService.findById(1);

		List<Study> studies = studytService.findByPatient(patient);
		
		assertEquals(Integer.valueOf(2), Integer.valueOf(studies.size()));
		
	}

}
