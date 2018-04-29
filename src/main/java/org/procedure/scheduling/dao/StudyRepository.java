package org.procedure.scheduling.dao;

import java.util.List;
import java.util.Optional;

import org.procedure.scheduling.domain.Patient;
import org.procedure.scheduling.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Integer> {
	Optional<Study> findById(Integer id);
	List<Study> findByPatient(Patient patient);
}
