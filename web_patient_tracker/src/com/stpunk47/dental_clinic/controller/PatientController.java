package com.stpunk47.dental_clinic.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stpunk47.dental_clinic.dao.PatientDAO;
import com.stpunk47.dental_clinic.entity.Patient;
import com.stpunk47.dental_clinic.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listPatients(Model theModel) {
		//get patient from the DAO
		List<Patient> thePatients = patientService.getPatients();
		
		
		//add clients to the model
		theModel.addAttribute("patients", thePatients);
		
		
		return "list-patients";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel ) {
		return "patient-form";
	}
	
	
	
	
	
	
	

}
