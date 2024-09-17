package com.generation.clinicDocente.model.dto;

import java.time.LocalDate;

import com.generation.clinicDocente.model.entities.Course;

public class CourseDTO 
{
	int id;
	String title;
	LocalDate date;
	double cost;
	int doctorId;
	String doctor;
	
	public CourseDTO () {};
	
	public CourseDTO(Course course)
	{
		this.id = course.getId();
		this.title = course.getTitle();
		this.date = course.getDate();
		this.cost = course.getCost();
		this.doctorId = course.getDoctor().getId();
		this.doctor = course.getDoctor().getName() + " " + course.getDoctor().getSurname();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	
}
