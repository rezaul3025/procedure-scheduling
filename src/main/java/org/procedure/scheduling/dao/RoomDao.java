package org.procedure.scheduling.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.procedure.scheduling.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class RoomDao {	
	
	
	private SessionFactory sessionFactory;
	
	public Room getRoomById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Room room = session.get(Room.class, id);
		return room;
	}

}
