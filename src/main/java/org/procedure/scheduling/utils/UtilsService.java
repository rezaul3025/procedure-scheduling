package org.procedure.scheduling.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Study;
import org.procedure.scheduling.web.form.PatientForm;
import org.procedure.scheduling.web.form.StudyForm;

public interface UtilsService {
	Patient convertPatientFormToDomain(PatientForm patientform);

	PatientForm convertPatientDomainToForm(Integer patientId);

	Study convertStudyFormToDomain(StudyForm studyform, Integer patientId);

	StudyForm convertDomainToStudyForm(Integer id);

	LocalDate stringToLocalDateFormat(String localDateStr);

	LocalDateTime stringToLocalDateTimeFormat(String localDateTimeStr);
}
