package org.procedure.scheduling.dao;

import java.util.Optional;

import org.procedure.scheduling.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PatientRepository extends the Spring JpaRepository which takes the the domain
 * class Doctor to manage as well as the id type of the domain class as type
 * arguments. PatientRepository get the most relevant CRUD methods for standard
 * data access available in a standard DAO out of the box.
 * 
 * @author rkarim
 *
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	@Override
	Optional<Patient> findById(Integer id);
}
