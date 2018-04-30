package org.procedure.scheduling.dao;

import java.util.Optional;

import org.procedure.scheduling.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DoctorRepository extends the Spring JpaRepository which takes the the domain class Doctor 
 * to manage as well as the id type of the domain class as type arguments.
 * DoctorRepository get the most relevant CRUD methods for standard data access available
 * in a standard DAO out of the box.
 * 
 * @author rkarim
 *
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	@Override
	Optional<Doctor> findById(Integer id);
}
