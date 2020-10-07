package com.ojas.poc.service;

import org.springframework.http.ResponseEntity;

import com.ojas.poc.model.CreateJob;

public interface JobService {
	
	public ResponseEntity<Object> saveJob(CreateJob job) throws Exception;
	
	public ResponseEntity<Object> getByJobId(Integer id) throws Exception;
	
	public ResponseEntity<Object> getByJobType(String jobType) throws Exception;
	
	public ResponseEntity<Object> getByExperience(Integer experience) throws Exception;

	public ResponseEntity<Object> getByCountry(String country) throws Exception;
	
	public ResponseEntity<Object> getByAvailability(String availability) throws Exception;
	
	public ResponseEntity<Object> getByLanguage(String language) throws Exception;
	
	public ResponseEntity<Object> getBySkills(String skills) throws Exception;
	
	public ResponseEntity<Object> getByPayRate(int low, int high) throws Exception;
	
	public ResponseEntity<Object> getAllJobs() throws Exception;

}
