package com.imen.patients;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.imen.patients.entities.Doctor;
import com.imen.patients.entities.Patient;
import com.imen.patients.repos.PatientRepository;
import com.imen.patients.service.PatientService;

@SpringBootTest
class PatientsApplicationTests {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	PatientService patientService;
	
	
	

	/*@Test
	public void testCreatePatient(){
	   

	    Patient pat = new Patient("moula", "ichraf", "1233345", "user@gmail.com", "nabeul", "femme","grippe", LocalDate.now());
	    patientRepository.save(pat);
	}*/
	@Test
	public void testCreatePatient() {
	    Patient pat1 = new Patient();
	    pat1.setNom("moula");
	    pat1.setPrenom("imen");
	    pat1.setPhone("1111111");
	    pat1.setEmail("user1@gmail.com");
	    pat1.setAdresse("nabeul");
	    pat1.setGenre("femme");
	    pat1.setMaladie("Grippe");
	    pat1.setDateCreation(LocalDate.now());
	    patientRepository.save(pat1);
	    
	}
	

	
	

	@Test
	public void testFindPatient() {
		Patient p = patientRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdatePatient() {
		Patient p = patientRepository.findById(1L).get();
		p.setEmail("user12@gamil.com");
		patientRepository.save(p);
	}

	@Test
	public void testDeletePatient() {
		patientRepository.deleteById(1L);
		
	}

	@Test
	public void testListerTousPatients() {
		List<Patient> pat = patientRepository.findAll();
		for (Patient p : pat) {
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomPatientContains()
	{
	Page<Patient> pat = patientService.getAllPatientsParPage(0, 2);
	System.out.println(pat.getSize());
	System.out.println(pat.getTotalElements());
	System.out.println(pat.getTotalPages());
	pat.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	
	}
	@Test
	public void testfindByNomPatient()
	{
	List<Patient> pat = patientRepository.findByNomPatient("moula");
	for (Patient p : pat)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByNomPatientContains ()
	{
	List<Patient> pat=patientRepository.findByNomPatientContains("moula");
	for (Patient p : pat)
	{
	System.out.println(p);
	} }
	@Test
	public void testfindByPrenom ()
	{
	List<Patient> pat = patientRepository.findByPrenom("moula", "imen");
	for (Patient p : pat)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindBydoctor()
	{
	Doctor doct = new Doctor();
	doct.setIdDoct(1L);
	List<Patient> pat = patientRepository.findBydoctor(doct);
		for (Patient p : pat)
		{
		System.out.println(p);
		}
	}
	@Test
	public void findByDoctorByIddoct()
	{
	List<Patient> pat = patientRepository.findByDoctorByIddoct(1L);
	for (Patient p : pat)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByNomPatienttAsc()
	{
	List<Patient> pat =patientRepository.findByOrderByNomPatientAsc();
	for (Patient p : pat)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testtrierPatientsNomMaladie()
	{
	List<Patient> pat =patientRepository.trierPatientsNomMaladie();
 
	for (Patient p : pat)
	{
	System.out.println(p);
	}
	}
	


	
	
}
