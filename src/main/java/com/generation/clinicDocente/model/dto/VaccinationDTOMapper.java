package com.generation.clinicDocente.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.clinicDocente.model.entities.Doctor;
import com.generation.clinicDocente.model.entities.Vaccination;
import com.generation.clinicDocente.model.repository.DoctorRepository;

@Service
public class VaccinationDTOMapper 
{
	//da dto a entity e da entity a dto
	@Autowired
	DoctorRepository doctorRepo;
	
	public VaccinationDTO toDTO(Vaccination vaccination)
	{
		return new VaccinationDTO(vaccination);
	}
	
	public List<VaccinationDTO> toDTO(List<Vaccination> vaccinations)
	{
		List<VaccinationDTO> res = new ArrayList<VaccinationDTO>();
		
		for(Vaccination v : vaccinations)
		{
			res.add(toDTO(v));
		}
		
		return res;
	}
	
	public Vaccination fromDTO(VaccinationDTO vaccinationDTO)
	{
		if(vaccinationDTO.getDoctorId() <= 0)
		{
			throw new RuntimeException("Doctor id not valid");
		}
		
		Optional<Doctor> doctorOptional = doctorRepo.findById(vaccinationDTO.getDoctorId());
		
		if(doctorOptional.isEmpty())
		{
			throw new RuntimeException("Doctor not found");
		}
		
		Vaccination res = new Vaccination();
		res.setId(vaccinationDTO.getId());
		res.setDate(vaccinationDTO.getDate());
		res.setVaccine(vaccinationDTO.getVaccine());
		res.setDoctor(doctorOptional.get());
		
		return res;
	}
	
	public List<Vaccination> fromDTO(List<VaccinationDTO> vaccinationDTO)
	{
			List<Vaccination> res = new ArrayList<Vaccination>();
			
			for(VaccinationDTO c : vaccinationDTO)
			{
				res.add(fromDTO(c));
			}
			return res;
	}
}

