package com.ojas.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc.model.CreateJob;
import com.ojas.poc.model.ExcelData;
import com.ojas.poc.serviceimpl.JobServiceImpl;

@RestController
@RequestMapping("/poc/job")
public class JobController {

	@Autowired
	private JobServiceImpl jobService;
	static Logger log = Logger.getLogger(UserController.class.getName());

	@PostMapping(path = "/postjob", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> saveJob(@RequestBody CreateJob jobReq) {
		log.debug("Incoming request job controller : " + jobReq);
		return jobService.saveJob(jobReq);
	}

	@GetMapping(path = "/getjob/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getByJobId(@PathVariable Integer id) {
		log.debug("Incoming request jobid method : " + id);
		return jobService.getByJobId(id);
	}

	@GetMapping(path = "/getByType/{type}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getByJobType(@PathVariable String type) {
		log.debug("Incoming request type method : " + type);
		return jobService.getByJobType(type);
	}

	@GetMapping(path = "/getByExp/{exp}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getByExperience(@PathVariable Integer exp) {
		log.debug("Incoming request experience method : " + exp);
		return jobService.getByExperience(exp);
	}

	@GetMapping(path = "/getByCountry/{country}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getByCountry(@PathVariable String country) {
		log.debug("Incoming request country method : " + country);
		return jobService.getByCountry(country);
	}

	@GetMapping(path = "/getByAvailability/{availability}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getByAvailability(@PathVariable String availability) {
		log.debug("Incoming request availability method : " + availability);
		return jobService.getByAvailability(availability);
	}

	@GetMapping(path = "/getBySkills/{skills}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getBySkills(@PathVariable String skills) {
		log.debug("Incoming request skills method : " + skills);
		return jobService.getBySkills(skills);
	}

	@GetMapping(path = "/getByLanguage/{language}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getByLanguage(@PathVariable String language) {
		log.debug("Incoming request language method : " + language);
		return jobService.getByLanguage(language);
	}

	@GetMapping(path = "/getByPayRate/{low}/{high}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getByPayRate(@PathVariable int low, @PathVariable int high) {
		log.debug("Incoming request payrate method : " + low + high);
		return jobService.getByPayRate(low, high);
	}

	@GetMapping(path = "/getalljobs", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getAllJobs() {
		log.debug("Incoming request getalljob method ");
		return jobService.getAllJobs();
	}

	@PostMapping("/excelfileupload")
	public List<CreateJob> uploadFile(@RequestParam("file") MultipartFile file) {

		if (ExcelData.hasExcelFormat(file)) {

			try {
				List<CreateJob> list = jobService.saveAll(file);
				return list;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ArrayList<CreateJob>();

			}
		} else {
			System.out.println("not excel format");
			return new ArrayList<>();
		}

	}
}
