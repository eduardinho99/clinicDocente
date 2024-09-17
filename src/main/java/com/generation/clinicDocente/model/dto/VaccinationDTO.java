package com.generation.clinicDocente.model.dto;

import java.time.LocalDate;

import com.generation.clinicDocente.model.entities.Vaccination;

public class VaccinationDTO 
{
	int id;
	LocalDate date;
	String vaccine;
	int doctorId;
	
	public VaccinationDTO() {};
	
	public VaccinationDTO(Vaccination vaccination) 
	{
		this.id = vaccination.getId();
		this.date = vaccination.getDate();
		this.vaccine = vaccination.getVaccine();
		this.doctorId = vaccination.getDoctor().getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	
}
