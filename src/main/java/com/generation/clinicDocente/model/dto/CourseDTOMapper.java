package com.generation.clinicDocente.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.clinicDocente.model.entities.Course;
import com.generation.clinicDocente.model.entities.Doctor;
import com.generation.clinicDocente.model.repository.DoctorRepository;

@Service
public class CourseDTOMapper 
{	
	@Autowired
	DoctorRepository doctorRepo;
	
	public CourseDTO toDTO(Course course)
	{
		return new CourseDTO(course);
	}
	
	public List<CourseDTO> toDTO(List<Course> courses)
	{
		List<CourseDTO> res = new ArrayList<CourseDTO>();
		
		for(Course c : courses)
			res.add(toDTO(c));
		
		return res;
	}
	
	public Course fromDTO(CourseDTO dto)
	{
		if(dto.getId() > 0)
		{
			throw new RuntimeException("Doctor id is not valid");
		}
		
		Optional<Doctor> optionalDoctor = doctorRepo.findById(dto.getDoctorId());
		
		if(optionalDoctor.isEmpty())
		{
			throw new RuntimeException("Doctor not found");
		}
		
		
		Course res = new Course();
		
		res.setId(dto.getId());
		res.setTitle(dto.getTitle());
		res.setCost(dto.getCost());
		res.setDate(dto.getDate());
		res.setDoctor(optionalDoctor.get());
		
		return res;
	}
	
	public List<Course> fromDTO(List<CourseDTO> dtos)
	{
		List<Course> res = new ArrayList<Course>();
		
		for(CourseDTO c : dtos)
		{
			res.add(fromDTO(c));
		}
		
		return res;
	}
}
