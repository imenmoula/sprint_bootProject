package com.imen.patients.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imen.patients.entities.Patient;
import com.imen.patients.service.PatientService;

@Controller
public class PatientController {
	/*
	 * @RequestMapping("/myView") public String myView() { return "myView"; }
	 */
	@Autowired
	PatientService patientService;

	@RequestMapping("/ListePatients")
	public String listePatients(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Patient> pats = patientService.getAllPatientsParPage(page, size);
		modelMap.addAttribute("patients", pats);
		modelMap.addAttribute("pages", new int[pats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListePatients";

	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createPatient";
	}

	@RequestMapping("/savePatient")
	public String savePatient(@ModelAttribute("produit") Patient patient, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dateCreation = LocalDate.parse(date, formatter);
	    patient.setDateCreation(dateCreation);

		Patient savePatient = patientService.savePatient(patient);
		String msg = "produit enregistré avec Id " + savePatient.getId();
		modelMap.addAttribute("msg", msg);
		return "createPatient";
	}

	@RequestMapping("/supprimerPatient")
	public String supprimerPatient(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		patientService.deletePatientById(id);
		Page<Patient> pats = patientService.getAllPatientsParPage(page, size);
		modelMap.addAttribute("patients", pats);
		modelMap.addAttribute("pages", new int[pats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListePatients";
	}

	@RequestMapping("/modifierPatient")
	public String editerPatient(@RequestParam("id") Long id, ModelMap modelMap) {
		Patient p = patientService.getPatient(id);
		modelMap.addAttribute("patient", p);
		return "editerPatient";
	}

	@RequestMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("patient") Patient patient, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dateCreation = LocalDate.parse(date, formatter);
	    patient.setDateCreation(dateCreation);

		patientService.updatePatient(patient);
		List<Patient> pat = patientService.getAllPatients();
		modelMap.addAttribute("patients", pat);
		return "listePatients";
	}

}
