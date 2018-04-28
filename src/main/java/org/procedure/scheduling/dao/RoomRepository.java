package org.procedure.scheduling.dao;

import java.util.Optional;

import org.procedure.scheduling.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	Optional<Room> findById(Integer id);
}
