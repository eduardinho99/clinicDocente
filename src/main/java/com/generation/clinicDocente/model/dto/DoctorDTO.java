package com.generation.clinicDocente.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.clinicDocente.model.entities.Doctor;
import com.generation.clinicDocente.model.entities.Gender;
import com.generation.clinicDocente.model.entities.Specialization;

public class DoctorDTO 
{
	@Autowired
	VaccinationDTOMapper vaccinationMapper;
	CourseDTOMapper courseMapper;
	
	int id;
	String name, surname;
	Specialization specialization;
	Gender gender;
	//List di VaccinationDTO
	List<VaccinationDTO> vaccinations = new ArrayList<VaccinationDTO>();
	//List di CourseDTO
	List<CourseDTO> courses = new ArrayList<CourseDTO>();
	
	public DoctorDTO(Doctor doctor)
	{
		this.id = doctor.getId();
		this.name = doctor.getName();
		this.surname = doctor.getSurname();
		this.specialization = doctor.getSpecialization();
		this.gender = doctor.getGender();
		this.vaccinations = vaccinationMapper.toDTO(doctor.getVaccinations());
		this.courses = courseMapper.toDTO(doctor.getCourses());
	}

	public VaccinationDTOMapper getVaccinationMapper() {
		return vaccinationMapper;
	}

	public void setVaccinationMapper(VaccinationDTOMapper vaccinationMapper) {
		this.vaccinationMapper = vaccinationMapper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<VaccinationDTO> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<VaccinationDTO> vaccinations) {
		this.vaccinations = vaccinations;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}
	
	
}
