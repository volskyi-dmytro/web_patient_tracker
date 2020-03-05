package com.stpunk47.dental_clinic.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.stpunk47.dental_clinic.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Patient> getPatients() {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//create a query
		
		Query<Patient> theQuery = 
				currentSession.createQuery("from Patient order by lastName",
						Patient.class);
				
		
		//execute a query and get result list
		List<Patient> patients = theQuery.getResultList();
		
		//return results
		
		return patients;
	}

	@Override
	public void savePatient(Patient thePatient) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//save the patient-info to db
		currentSession.save(thePatient);
	}

}
