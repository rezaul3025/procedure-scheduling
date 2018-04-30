package org.procedure.scheduling.dao;

import java.util.Optional;

import org.procedure.scheduling.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoomRepository extends the Spring JpaRepository which takes the the domain
 * class Doctor to manage as well as the id type of the domain class as type
 * arguments. RoomRepository get the most relevant CRUD methods for standard
 * data access available in a standard DAO out of the box.
 * 
 * @author rkarim
 *
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Override
	Optional<Room> findById(Integer id);
}
