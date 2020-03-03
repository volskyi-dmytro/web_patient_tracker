package com.stpunk47.dental_clinic.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@RequestMapping("/list")
	public String listPatients(Model theModel) {
		return "list-patients";
	}

}
