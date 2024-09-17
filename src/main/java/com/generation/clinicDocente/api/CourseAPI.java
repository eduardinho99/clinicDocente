package com.generation.clinicDocente.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.clinicDocente.model.dto.CourseDTO;
import com.generation.clinicDocente.model.dto.CourseDTOMapper;
import com.generation.clinicDocente.model.entities.Course;
import com.generation.clinicDocente.model.repository.CourseRepository;

@RestController
@RequestMapping("/clinicdocente/api/courses")
public class CourseAPI 
{
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	CourseDTOMapper courseMapper;
	
	
	@GetMapping()
	public ResponseEntity<List<CourseDTO>> getCourses()
	{
		return new ResponseEntity<List<CourseDTO>>(courseMapper.toDTO(courseRepo.findAll()), HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("id") int id)
	{
		if(id <= 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Optional<Course> optionalCourse = courseRepo.findById(id);
		
		if(optionalCourse.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CourseDTO res = courseMapper.toDTO(optionalCourse.get());
		
		return new ResponseEntity<CourseDTO>(res,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> insertCoure(@RequestBody CourseDTO dto)
	{
		try 
		{
			Course course = courseMapper.fromDTO(dto);
			courseRepo.save(course);
			return new ResponseEntity<Object>(courseMapper.toDTO(course),HttpStatus.CREATED);
			
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
}
