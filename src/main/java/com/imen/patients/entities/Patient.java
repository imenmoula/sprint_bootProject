package com.imen.patients.entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String adresse;
    private String genre;
    private String maladie;
    
    private LocalDate  dateCreation;
    
    @ManyToOne
    private Doctor doctor;

	public Patient() {
		super();
	}


	public Patient(String nom, String prenom, String phone, String email, String adresse, String genre, String maladie,
			LocalDate dateCreation, Doctor doctor) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.phone = phone;
		this.email = email;
		this.adresse = adresse;
		this.genre = genre;
		this.maladie = maladie;
		this.dateCreation = dateCreation;
		this.doctor = doctor;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}




	public String getGenre() {
		return genre;
	}




	public void setGenre(String genre) {
		this.genre = genre;
	}




	public String getMaladie() {
		return maladie;
	}




	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}




	public LocalDate getDateCreation() {
		return dateCreation;
	}




	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}




	public Doctor getDoctor() {
		return doctor;
	}




	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
	

	
	

	
	
    
    

}
