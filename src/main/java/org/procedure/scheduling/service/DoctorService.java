package org.procedure.scheduling.service;

import java.util.List;

import org.procedure.scheduling.domain.Doctor;

public interface DoctorService {

	Doctor findById(Integer id);

	List<Doctor> findAll();
}
