package com.ojas.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.poc.model.ExcelData;
import com.ojas.poc.serviceimpl.ExcelServiceImpl;

@RestController
@RequestMapping("/job")
public class ExcelDataController {

	@Autowired
	private ExcelServiceImpl excelService;

	@PostMapping("/processjobexcel")
	public ResponseEntity<Object> readExcelData(@RequestBody ExcelData excelDataReq) {

		try {
			
			if(excelDataReq.getExcelFile() == null || excelDataReq.getExcelFile().isEmpty()) {
				return new ResponseEntity<>("Invalid request data ", HttpStatus.UNPROCESSABLE_ENTITY);
			}
			
			return excelService.readExcel(excelDataReq);

		} catch (Exception e) {
			String message = e.getMessage();
			return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
