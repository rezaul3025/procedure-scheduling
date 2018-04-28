package org.procedure.scheduling.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.procedure.scheduling.domain.Doctor;
import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Room;
import org.procedure.scheduling.domain.Sex;
import org.procedure.scheduling.service.DoctorService;
import org.procedure.scheduling.service.RoomService;
import org.procedure.scheduling.web.form.PatientForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilsServiceHandler implements UtilsService {
	
	@Autowired
	private DoctorService dcotorService;
	
	@Autowired
	private RoomService roomService;
	
	@Override
	public Patient convertPatientFormToDomain(PatientForm patientform) {
		
		LocalDate dob = stringToLocalDateFormat(patientform.getDob());
		
		Patient patient = new Patient(patientform.getName(), Sex.valueOf(patientform.getPatientSex()),dob);
		
		Doctor doctor = dcotorService.findById(patientform.getDoctorId());
		
		Room room = roomService.findRoomById(patientform.getRoomId());
		patient.setDoctor(doctor);
		patient.setRoom(room);
		return patient;
	}

	@Override
	public LocalDate stringToLocalDateFormat(String localDateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd").ISO_DATE;
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(localDateStr,formatter);
		return localDate;
	}

}
