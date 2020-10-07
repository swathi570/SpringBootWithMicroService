package com.ojas.poc.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.ojas.poc.model.ExcelData;

public interface ExcelService {
	
	ResponseEntity<Object> readExcel(ExcelData excelData) throws  IOException;

}
