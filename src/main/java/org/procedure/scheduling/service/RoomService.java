package org.procedure.scheduling.service;

import java.util.List;

import org.procedure.scheduling.domain.Room;

public interface RoomService {
	Room findRoomById(Integer id);

	List<Room> findAll();
}
