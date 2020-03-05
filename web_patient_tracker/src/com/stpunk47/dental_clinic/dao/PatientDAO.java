package com.stpunk47.dental_clinic.dao;

import java.util.List;
import com.stpunk47.dental_clinic.entity.Patient;

public interface PatientDAO {
	
	public List<Patient> getPatients();

	public void savePatient(Patient thePatient);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);

	public List<Patient> searchPatients(String theSearchName);

}
