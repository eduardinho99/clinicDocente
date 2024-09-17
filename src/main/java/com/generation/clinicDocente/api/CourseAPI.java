package com.generation.clinicDocente.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.clinicDocente.model.entities.Course;

@RestController
@RequestMapping("/clinicdocente/api/courses")
public class CourseAPI 
{
	@GetMapping()
	public ResponseEntity<Course> getCourses()
	{
		
	}
}
