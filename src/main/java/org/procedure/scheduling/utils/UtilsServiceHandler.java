package org.procedure.scheduling.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.procedure.scheduling.domain.Doctor;
import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Room;
import org.procedure.scheduling.domain.Sex;
import org.procedure.scheduling.domain.Study;
import org.procedure.scheduling.domain.StudyStatus;
import org.procedure.scheduling.service.DoctorService;
import org.procedure.scheduling.service.PatientService;
import org.procedure.scheduling.service.RoomService;
import org.procedure.scheduling.service.StudyService;
import org.procedure.scheduling.web.form.PatientForm;
import org.procedure.scheduling.web.form.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Utils service class to do some extra calculation like conversion , formatting
 * etc
 * 
 * @author rkarim
 *
 */
@Service
public class UtilsServiceHandler implements UtilsService {

	@Autowired
	private DoctorService dcotorService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private StudyService studyService;

	@Override
	public Patient convertPatientFormToDomain(PatientForm patientform) {

		LocalDate dob = stringToLocalDateFormat(patientform.getDob());

		Patient patient = new Patient(patientform.getName(), Sex.valueOf(patientform.getPatientSex()), dob);

		Doctor doctor = dcotorService.findById(patientform.getDoctorId());

		Room room = roomService.findRoomById(patientform.getRoomId());

		patient.setId(patientform.getId());
		patient.setDoctor(doctor);
		patient.setRoom(room);
		return patient;
	}

	@Override
	public LocalDate stringToLocalDateFormat(String localDateStr) {

		if (localDateStr == null) {
			return null;
		} else if (localDateStr.isEmpty()) {
			return null;
		}

		DateTimeFormatter.ofPattern("yyyy-MM-dd");

		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(localDateStr, formatter);

		return localDate;
	}

	@Override
	public LocalDateTime stringToLocalDateTimeFormat(String localDateTimeStr) {

		if (localDateTimeStr == null) {
			return null;
		} else if (localDateTimeStr.isEmpty()) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		// convert String to LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeStr, formatter);

		return localDateTime;
	}

	@Override
	public Study convertStudyFormToDomain(StudyForm studyform, Integer patientId) {

		LocalDateTime plannedStartTime = stringToLocalDateTimeFormat(studyform.getPlannedStartTime());

		LocalDateTime estimatedEndTime = stringToLocalDateTimeFormat(studyform.getEstimatedEndTime());

		Patient patient = patientService.findById(patientId);

		Study study = new Study(patient, studyform.getDescription(), StudyStatus.valueOf(studyform.getStatus()),
				plannedStartTime, estimatedEndTime);

		study.setId(studyform.getId());

		return study;
	}

	@Override
	public PatientForm convertPatientDomainToForm(Integer patientId) {

		Patient patient = patientService.findById(patientId);

		LocalDate dob = patient.getDob();

		PatientForm patientForm = new PatientForm(patient.getName(), patient.getPatientSex().toString(),
				dob == null ? null : dob.toString());

		patientForm.setId(patient.getId());

		patientForm.setDoctorId(patient.getDoctor().getId());

		patientForm.setRoomId(patient.getRoom().getId());

		return patientForm;
	}

	@Override
	public StudyForm convertDomainToStudyForm(Integer id) {

		Study study = studyService.findById(id);

		String plannedStartTime = study.getPlannedStartTime() == null ? null
				: study.getPlannedStartTime().toString().replace("T", " ");
		;

		String estimatedEndTime = study.getEstimatedEndTime() == null ? null
				: study.getEstimatedEndTime().toString().replace("T", " ");

		StudyForm studyForm = new StudyForm(study.getPatient(), study.getDescription(), study.getStatus().toString(),
				plannedStartTime, estimatedEndTime);

		studyForm.setId(study.getId());

		return studyForm;
	}

}
