package org.procedure.scheduling.service;


import java.util.List;

import org.procedure.scheduling.dao.DoctorRepository;
import org.procedure.scheduling.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true) //Allow only reading on master data
public class DoctorServiceHandler implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepo;
	
	@Override
	public Doctor findById(Integer id) {
		
		return doctorRepo.findById(id).get();
	}

	@Override
	public List<Doctor> findAll() {
		return doctorRepo.findAll();
	}

}
