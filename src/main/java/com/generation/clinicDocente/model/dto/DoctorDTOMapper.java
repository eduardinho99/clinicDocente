package com.generation.clinicDocente.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.clinicDocente.model.entities.Doctor;
import com.generation.clinicDocente.model.repository.CourseRepository;
import com.generation.clinicDocente.model.repository.VaccinationRepository;

@Service
public class DoctorDTOMapper 
{
	
	VaccinationRepository vacciRepo;
	CourseRepository courseRepo;
	VaccinationDTOMapper vacciMapper;
	CourseDTOMapper courseMapper;
	
	
	public DoctorDTO toDTO(Doctor doctor)
	{
		return new DoctorDTO(doctor);
	}
	
	
	public List<DoctorDTO> toDTO(List<Doctor> doctors)
	{
		List<DoctorDTO> res = new ArrayList<DoctorDTO>();
		
		for(Doctor d : doctors)
			res.add(toDTO(d));
		
		return res;
	}
	
	public Doctor fromDTO(DoctorDTO dto)
	{
		Doctor res = new Doctor();
		res.setCourses(courseMapper.fromDTO(dto.getCourses()));
		res.setVaccinations(vacciMapper.fromDTO(dto.getVaccinations()));
		res.setId(dto.getId());
		res.setGender(dto.getGender());
		res.setSpecialization(dto.getSpecialization());
		res.setSurname(dto.getSurname());
		res.setName(dto.getName());
		
		return res;
	}
	
	public List<Doctor> fromDTO(List<DoctorDTO> dtos)
	{
		List<Doctor> res = new ArrayList<Doctor>();
		
		for(DoctorDTO d : dtos)
			res.add(fromDTO(d));
		
		return res;
	}
}
