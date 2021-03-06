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
		
		
		//save/update the patient-info to db
		currentSession.saveOrUpdate(thePatient);
	}

	@Override
	public Patient getPatient(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from db using primary key
		Patient thePatient = currentSession.get(Patient.class, theId);
		
		
		return thePatient;
	}

	@Override
	public void deletePatient(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from Patient where id=:patientId");
		
		theQuery.setParameter("patientId", theId);
		
		theQuery.executeUpdate();
		
		
	}

	@Override
	public List<Patient> searchPatients(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		if(theSearchName!=null&&theSearchName.trim().length()>0) {
			theQuery=currentSession.createQuery("from Patient where lower(firstName) like :theName or lower(lastName) like :theName",Patient.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase()+"%");
		} else {
			theQuery=currentSession.createQuery("from Patient",Patient.class);
		}
		List<Patient> patients = theQuery.getResultList();
		
		
		return patients;
	}

}
