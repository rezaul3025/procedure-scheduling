package org.procedure.scheduling.validation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.procedure.scheduling.dao.StudyRepository;
import org.procedure.scheduling.domain.Study;
import org.procedure.scheduling.utils.UtilsService;
import org.procedure.scheduling.web.form.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceHandler implements ValidationService {

	@Autowired
	private UtilsService utilsService;

	@Autowired
	private StudyRepository studyRepository;

	@Override
	public List<String> studyFormValidation(StudyForm studyForm) {
		List<String> errorMessages = new ArrayList<String>();

		String plannedStartTimeStr = studyForm.getPlannedStartTime();

		String estimatedEndTimeStr = studyForm.getEstimatedEndTime();

		if (plannedStartTimeStr != null && !plannedStartTimeStr.isEmpty() && estimatedEndTimeStr != null
				&& !estimatedEndTimeStr.isEmpty()) {

			LocalDateTime plannedStartTime = utilsService.stringToLocalDateTimeFormat(plannedStartTimeStr);

			LocalDateTime estimatedEndTime = utilsService.stringToLocalDateTimeFormat(estimatedEndTimeStr);

			if (estimatedEndTime.isBefore(plannedStartTime)) {
				errorMessages.add("Estimated end time  cannot be before planned start time ");
			}
		}

		return errorMessages;
	}

}
