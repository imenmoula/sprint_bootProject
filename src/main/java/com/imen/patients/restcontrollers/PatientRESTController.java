package com.imen.patients.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imen.patients.entities.Patient;
import com.imen.patients.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class PatientRESTController {
	@Autowired
	PatientService patientservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Patient> getAllPatients() {
	return patientservice.getAllPatients();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Patient getPatientById(@PathVariable("id") Long id) {
	return patientservice.getPatient(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Patient createPatient(@RequestBody Patient patient) {
	return patientservice.savePatient(patient);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void eletePatient(@PathVariable("id") Long id)
	{
		patientservice.deletePatientById(id);
	}
	
	@RequestMapping(value="/patdoct/{idDoct}",method = RequestMethod.GET)
	public List<Patient> getPatientsByIddoct(@PathVariable("idDoct") Long idDoct) {
	return patientservice.findByDoctorByIddoct(idDoct);
	}


	
}
