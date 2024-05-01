package com.imen.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.imen.patients.entities.Doctor;
import com.imen.patients.entities.Patient;
import com.imen.patients.repos.PatientRepository;

@Service
public class PatientServicelmpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient savePatient(Patient p) {
		return patientRepository.save(p);
	}

	@Override
	public Patient updatePatient(Patient p) {
		return patientRepository.save(p);
	}

	@Override
	public void deletePatient(Patient p) {
		patientRepository.delete(p);
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}

	@Override
	public Patient getPatient(Long id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Page<Patient> getAllPatientsParPage(int page, int size) {
		return patientRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Patient> findByNomPatient(String nom) {
		return patientRepository.findByNomPatient(nom);
	}

	@Override
	public List<Patient> findByNomPatientContains(String nom) {
		return patientRepository.findByNomPatientContains(nom);
	}

	@Override
	public List<Patient> findByPrenom(String nom, String prenom) {
		return patientRepository.findByPrenom(nom, prenom);
	}

	@Override
	public List<Patient> findBydoctor(Doctor doctor) {
		return patientRepository.findBydoctor(doctor);
	}

	@Override
	public List<Patient> findByDoctorByIddoct(Long id) {
		return patientRepository.findByDoctorByIddoct(id);
	}

	@Override
	public List<Patient> findByOrderByNomPatienttAsc() {
		return patientRepository.findByOrderByNomPatientAsc();
	}

	@Override
	public List<Patient> trierPatientsNomMaladie() {
		return patientRepository.trierPatientsNomMaladie();
	}

}