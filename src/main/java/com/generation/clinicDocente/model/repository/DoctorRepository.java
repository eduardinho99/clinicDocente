package com.generation.clinicDocente.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.clinicDocente.model.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{

}
