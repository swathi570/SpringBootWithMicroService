package com.ojas.poc.serviceimpl;

import static com.ojas.poc.constants.Constants.INVALID_FIELDS;
import static com.ojas.poc.constants.Constants.INVALID_REQUEST;
import static com.ojas.poc.constants.Constants.SUCCESS;
import static com.ojas.poc.constants.Constants.SUCCESS_STATUS;
import static com.ojas.poc.constants.Constants.USER_EXIT;
import static com.ojas.poc.constants.Constants.USER_SAVE;

import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.poc.exception.CustomException;
import com.ojas.poc.exception.Response;
import com.ojas.poc.model.CreateUser;
import com.ojas.poc.repositories.UserRepository;
import com.ojas.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public ResponseEntity<Object> saveUser(CreateUser user) throws CustomException {
		log.debug("Incoming request user service : " + user);

		if (user == null) {
			log.error("Invalid request");
			throw new CustomException(INVALID_REQUEST + user);
		}
		if (user.getUserName() == null || user.getUserName().isEmpty()) {
			log.error("Fields should not be null");
			throw new CustomException(INVALID_FIELDS + user.getUserName());
		}
		Optional<CreateUser> findByUserName = userRepo.findByUserName(user.getUserName());
		if (findByUserName.isPresent()) {
			throw new CustomException(USER_EXIT + user.getUserName());
		}
		CreateUser save = userRepo.save(user);
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(USER_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
