package org.procedure.scheduling.validation;

import java.util.List;

import org.procedure.scheduling.web.form.StudyForm;

public interface ValidationService {
	List<String> studyFormValidation(StudyForm studyForm);
}
