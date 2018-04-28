package org.procedure.scheduling.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.procedure.scheduling.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class PatientDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	private SessionFactory sessionFactory;

	public PatientDao() {
		
	}
	
	public Patient createPatient(Patient patient) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(patient);
		
		return patient;
	}

}
