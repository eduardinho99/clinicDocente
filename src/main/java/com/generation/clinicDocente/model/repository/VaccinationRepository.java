package com.generation.clinicDocente.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.clinicDocente.model.entities.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Integer>{

}
