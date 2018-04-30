package org.procedure.scheduling.service;

import java.util.List;

import org.procedure.scheduling.dao.RoomRepository;
import org.procedure.scheduling.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Room service class
 * @author rkarim
 *
 */
@Service
@Transactional(readOnly=true) //Allow only reading on master data
public class RoomServiceHandler implements RoomService{

	@Autowired
	private RoomRepository roomRepo;
	
	public Room findRoomById(Integer id) {
		return roomRepo.findById(id).get();
	}

	@Override
	public List<Room> findAll() {
		return roomRepo.findAll();
	}

}
