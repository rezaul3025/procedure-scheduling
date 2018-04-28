package org.procedure.scheduling.dao;

import java.util.Optional;

import org.procedure.scheduling.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findById(Integer id);
}
