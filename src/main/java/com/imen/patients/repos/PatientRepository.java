package com.imen.patients.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.imen.patients.entities.Doctor;
import com.imen.patients.entities.Patient;

@RepositoryRestResource(path = "rest")

public interface PatientRepository  extends JpaRepository<Patient, Long>  {

	List<Patient> findByNomPatient(String nom);
	List<Patient> findByNomPatientContains(String nomPatient);
	 
	@Query("select p from Patient p where p.nom like %?1 and p.prenom like%?")
	 List<Patient> findByPrenom(String nom, String prenom);
	 
	 /*@Query("select p from Patient p where p.nom like %?1 and p.prenom like%?")
	 List<Patient> findByPrenom(@Param("nom") String nom,@Param("prenom") String  prenom);*/

	 @Query("select p from Patient p where p.doctor = ?1")
	 List<Patient> findBydoctor(Doctor doctor);
	 
	 List<Patient> findByDoctorByIddoct(Long id);
	 
	 List<Patient> findByOrderByNomPatientAsc();
	 @Query("select p from Patient p order by p.nom ASC, p.maladie DESC")
	 List<Patient> trierPatientsNomMaladie();

	 
}
