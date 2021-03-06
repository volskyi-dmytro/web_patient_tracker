package com.stpunk47.dental_clinic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stpunk47.dental_clinic.dao.PatientDAO;
import com.stpunk47.dental_clinic.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	@Transactional
	public List<Patient> getPatients() {
		
		return patientDAO.getPatients();
	}

	@Override
	@Transactional
	public void savePatient(Patient thePatient) {
		patientDAO.savePatient(thePatient);
		
	}

	@Override
	@Transactional
	public Patient getPatient(int theId) {
		
		return patientDAO.getPatient(theId);
	}

	@Override
	@Transactional
	public void deletePatient(int theId) {
		patientDAO.deletePatient(theId);
		
	}

	@Override
	@Transactional
	public List<Patient> searchPatients(String theSearchName) {
		
		return patientDAO.searchPatients(theSearchName);
	}

}
