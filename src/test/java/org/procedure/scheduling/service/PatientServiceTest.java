package org.procedure.scheduling.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.procedure.scheduling.ProcedureSchedulingApplication;
import org.procedure.scheduling.domain.Doctor;
import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Room;
import org.procedure.scheduling.domain.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test class for patient services 
 * @author rkarim
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProcedureSchedulingApplication.class)
public class PatientServiceTest {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private DoctorService doctorService;
	
	public PatientServiceTest() {
		
	}
	
	@Test
	public void addPatientTest() {
		Patient patient = new Patient("Test patient", Sex.MALE, LocalDate.of(1987, 6, 12));
		Room room = roomService.findRoomById(1);
		patient.setRoom(room);
		patient = patientService.addPatient(patient);
		assertEquals(Integer.valueOf(4), patient.getId());
	}
	
	@Test
	public void deletePatientTest() {
		patientService.deletePatient(1);
		List<Patient> allPatients = patientService.findAll();
		assertEquals(Integer.valueOf(2), Integer.valueOf(allPatients.size()));
	}
	
	@Test
	public void updatePatientTest() {
		Patient patient = new Patient("Test patient1", Sex.FEMALE, LocalDate.of(1983, 4, 16));
		patient = patientService.addPatient(patient);
		
		//Assign room
		Room room = roomService.findRoomById(1);
		patient.setRoom(room);
		
		//Assign doctor
		Doctor doctor = doctorService.findById(2);
		patient.setDoctor(doctor);
		
		patient = patientService.updatePatient(patient);
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(patient.getRoom().getId()));
		assertEquals(Integer.valueOf(2), Integer.valueOf(patient.getDoctor().getId()));
	}

}
