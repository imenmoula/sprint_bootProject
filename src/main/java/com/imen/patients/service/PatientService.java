package com.imen.patients.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.imen.patients.entities.Doctor;
import com.imen.patients.entities.Patient;

public interface PatientService {
	Patient savePatient(Patient p);

	Patient updatePatient(Patient p);

	void deletePatient(Patient p);

	void deletePatientById(Long id);

	Patient getPatient(Long id);

	List<Patient> getAllPatients();

	Page<Patient> getAllPatientsParPage(int page, int size);

	List<Patient> findByNomPatient(String nom);

	List<Patient> findByNomPatientContains(String nom);

	List<Patient> findByPrenom(String nom, String prenom);

	List<Patient> findBydoctor(Doctor doctor);

	List<Patient> findByDoctorByIddoct(Long id);

	List<Patient> findByOrderByNomPatienttAsc();

	List<Patient> trierPatientsNomMaladie();

}