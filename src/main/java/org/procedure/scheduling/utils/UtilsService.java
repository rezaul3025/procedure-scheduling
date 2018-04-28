package org.procedure.scheduling.utils;

import java.time.LocalDate;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.web.form.PatientForm;

public interface UtilsService {
	Patient convertPatientFormToDomain(PatientForm patientform);
	LocalDate stringToLocalDateFormat(String localDateStr);
}
