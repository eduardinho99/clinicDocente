package com.generation.clinicDocente.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.clinicDocente.model.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>
{

}
