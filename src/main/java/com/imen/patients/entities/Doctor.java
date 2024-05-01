package com.imen.patients.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idDoct;
	 private String nomDoct;
	 private String specialtyDoct;
	 @JsonIgnore
	 @OneToMany(mappedBy = "doctor")
	 private List<Patient> patient;
	 
	 
	 

	/*public Doctor() {
	}

	public Doctor(String nomDoct, String specialtyDoct, List<Patient> patient) {
		super();
		this.nomDoct = nomDoct;
		this.specialtyDoct = specialtyDoct;
		this.patient = patient;
	}

	public Long getIdDoct() {
		return idDoct;
	}

	public void setIdDoct(Long idDoct) {
		this.idDoct = idDoct;
	}

	public String getNomDoct() {
		return nomDoct;
	}

	public void setNomDoct(String nomDoct) {
		this.nomDoct = nomDoct;
	}

	public String getSpecialtyDoct() {
		return specialtyDoct;
	}

	public void setSpecialtyDoct(String specialtyDoct) {
		this.specialtyDoct = specialtyDoct;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}*/
	 

	 
}
