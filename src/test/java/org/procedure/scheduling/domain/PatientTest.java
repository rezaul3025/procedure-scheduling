package org.procedure.scheduling.domain;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class PatientTest {

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		factory.getValidator();
	}

	@Test
	public void testPatientCreate() {

	}

}
