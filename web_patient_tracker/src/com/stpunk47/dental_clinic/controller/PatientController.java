package com.stpunk47.dental_clinic.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		//create model attribute to bind form data
		
		Patient thePatient = new Patient();
		
		theModel.addAttribute("patient", thePatient);
		
		
		return "patient-form";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {
		//save patient method
		patientService.savePatient(thePatient);
		
		return "redirect:/patient/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId") int theId, Model theModel) {
		//get the patient from the service
		Patient thePatient = patientService.getPatient(theId);
		
		
		//set patient as a model attribute to pre-populate the form
		theModel.addAttribute("patient",thePatient);
		
		//send over to form
		
		
		return "patient-form";
	}
	
	
	

}
