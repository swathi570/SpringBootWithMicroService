package com.ojas.poc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.poc.model.CreateJob;

public interface JobRepository extends JpaRepository<CreateJob, Integer>{
	
	public Optional<CreateJob> findById(Integer id);
	
	public List<CreateJob> findByJobType(String jobType);
	
	public List<CreateJob> findByExperience(Integer experience);

	public List<CreateJob> findByCountry(String country);
	
	public List<CreateJob> findByAvailability(String availability);
	
	public List<CreateJob> findByLanguage(String language);
	
	public List<CreateJob> findBySkills(String skills);
	
	public List<CreateJob> findByPayRateBetween(int low, int high);
	
	public List<CreateJob> findAll();
}
