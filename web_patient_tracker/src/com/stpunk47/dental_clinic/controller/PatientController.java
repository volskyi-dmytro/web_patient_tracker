package com.stpunk47.dental_clinic.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stpunk47.dental_clinic.dao.PatientDAO;
import com.stpunk47.dental_clinic.entity.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	//inject patient DAO
	@Autowired
	private PatientDAO patientDAO;
	
	
	@RequestMapping("/list")
	public String listPatients(Model theModel) {
		//get patient from the DAO
		List<Patient> thePatients = patientDAO.getPatients();
		
		
		//add clients to the model
		theModel.addAttribute("patients", thePatients);
		
		
		return "list-patients";
	}

}
