package org.procedure.scheduling.dao;

import java.util.Optional;

import org.procedure.scheduling.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	Optional<Doctor> findById(Integer id);
}
