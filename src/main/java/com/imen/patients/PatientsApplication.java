package com.imen.patients;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.imen.patients.entities.Patient;
import com.imen.patients.service.PatientService;

@SpringBootApplication
public class PatientsApplication implements CommandLineRunner {
	@Autowired
	//PatientService patientService;
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Patient.class);

	  
	}
	 /* LocalDate localDate = LocalDate.now();

    patientService.savePatient(new Patient("aaaa", "mounira", "1233345", "user@gmail.com", "nabeul", "femme", "angine", localDate));
    patientService.savePatient(new Patient("bbbb", "jihen", "1111", "user33@gmail.com", "nabeul", "femme", "Diabète ", localDate));
    patientService.savePatient(new Patient("cccc", "wafa", "222222", "user4@gmail.com", "nabeul", "femme", "cardiaque", localDate));*/


}
