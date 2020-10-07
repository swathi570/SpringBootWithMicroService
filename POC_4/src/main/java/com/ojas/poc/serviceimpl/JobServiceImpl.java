package com.ojas.poc.serviceimpl;

import static com.ojas.poc.constants.Constants.GET_ALLJOBS_DATA;
import static com.ojas.poc.constants.Constants.GET_BY_AVAILABILITY;
import static com.ojas.poc.constants.Constants.GET_BY_COUNTRY;
import static com.ojas.poc.constants.Constants.GET_BY_EXPERIENCE;
import static com.ojas.poc.constants.Constants.GET_BY_JOBID;
import static com.ojas.poc.constants.Constants.GET_BY_JOBTYPE;
import static com.ojas.poc.constants.Constants.GET_BY_LANGUAGE;
import static com.ojas.poc.constants.Constants.GET_BY_PAYRATE;
import static com.ojas.poc.constants.Constants.GET_BY_SKILLS;
import static com.ojas.poc.constants.Constants.INVALID_FIELDS;
import static com.ojas.poc.constants.Constants.INVALID_REQUEST;
import static com.ojas.poc.constants.Constants.JOB_SAVE;
import static com.ojas.poc.constants.Constants.RECORD_NOT_FOUND;
import static com.ojas.poc.constants.Constants.SUCCESS;
import static com.ojas.poc.constants.Constants.SUCCESS_STATUS;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc.exception.CustomException;
import com.ojas.poc.exception.Response;
import com.ojas.poc.model.CreateJob;
import com.ojas.poc.model.ExcelData;
import com.ojas.poc.repositories.JobRepository;
import com.ojas.poc.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepo;

	static Logger log = Logger.getLogger(JobServiceImpl.class.getName());

	@Override
	public ResponseEntity<Object> saveJob(CreateJob job) {
		log.debug("Incoming request job service : " + job);

		if (job == null) {
			log.error("Invalid request");
			throw new CustomException(INVALID_REQUEST);
		}

		if ((job.getJobType() == null || job.getJobType().isEmpty())
				|| (job.getJobTitle() == null || job.getJobTitle().isEmpty()) || (job.getExperience() == null)
				|| (job.getAvailability() == null || job.getAvailability().isEmpty())
				|| (job.getJobDescription() == null || job.getJobDescription().isEmpty())
				|| (job.getCountry() == null || job.getCountry().isEmpty())
				|| (job.getLanguage() == null || job.getLanguage().isEmpty())
				|| (job.getState() == null || job.getState().isEmpty()) || (job.getReplyRate() == null)
				|| (job.getSkills() == null || job.getSkills().isEmpty()) || (job.getUserInfo() == null)) {
			log.error("Fields should not be null");
			throw new CustomException(INVALID_FIELDS);
		}

		CreateJob save = jobRepo.save(job);
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(JOB_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByJobId(Integer id) {
		log.debug("Incoming request job service id method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<CreateJob> findById = jobRepo.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_JOBID);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByJobType(String jobType) {
		log.debug("Incoming request job service type method : " + jobType);

		if (jobType == null || jobType.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		List<CreateJob> findByJobType = jobRepo.findByJobType(jobType);
		if (findByJobType.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_JOBTYPE);
		response.setTimestamp(new Date());
		response.setData(findByJobType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByExperience(Integer experience) {
		log.debug("Incoming request job service experience method : " + experience);

		if (experience == null) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		List<CreateJob> findByExperience = jobRepo.findByExperience(experience);
		if (findByExperience.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_EXPERIENCE);
		response.setTimestamp(new Date());
		response.setData(findByExperience);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> getByCountry(String country) {
		log.debug("Incoming request job service country method : " + country);

		if (country == null || country.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		List<CreateJob> findByCountry = jobRepo.findByCountry(country);
		if (findByCountry.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_COUNTRY);
		response.setTimestamp(new Date());
		response.setData(findByCountry);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> getByAvailability(String availability) {
		log.debug("Incoming request job service availability method : " + availability);
		if (availability == null || availability.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		List<CreateJob> findByAvailability = jobRepo.findByAvailability(availability);
		if (findByAvailability.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_AVAILABILITY);
		response.setTimestamp(new Date());
		response.setData(findByAvailability);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByLanguage(String language) {
		log.debug("Incoming request job service language method : " + language);

		if (language == null || language.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		List<CreateJob> findByLanguage = jobRepo.findByLanguage(language);
		if (findByLanguage.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_LANGUAGE);
		response.setTimestamp(new Date());
		response.setData(findByLanguage);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getAllJobs() {
		log.debug("Incoming request job service getalljob method ");
		List<CreateJob> findAllJobs = jobRepo.findAll();
		if (findAllJobs.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_ALLJOBS_DATA);
		response.setTimestamp(new Date());
		response.setData(findAllJobs);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getBySkills(String skills) {
		log.debug("Incoming request job service skills method : " + skills);
		if (skills == null || skills.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		List<CreateJob> findBySkills = jobRepo.findBySkills(skills);
		if (findBySkills.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_SKILLS);
		response.setTimestamp(new Date());
		response.setData(findBySkills);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> getByPayRate(int low, int high) {
		log.debug("Incoming request job service payrate method : " + low + high);
		List<CreateJob> findByPayRate = jobRepo.findByPayRateBetween(low, high);
		if (findByPayRate.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_PAYRATE);
		response.setTimestamp(new Date());
		response.setData(findByPayRate);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public List<CreateJob> saveAll(MultipartFile file) {
		try {
			List<CreateJob> jobs = ExcelData.excelToJob(file.getInputStream());
			List<CreateJob> saveAll = jobRepo.saveAll(jobs);
			System.out.println(saveAll);
			return saveAll;
		} catch (IOException e) {
			System.out.println("from exception");
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}
