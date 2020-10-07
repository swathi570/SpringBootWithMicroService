package com.ojas.poc.serviceimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.poc.model.ExcelData;
import com.ojas.poc.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService{

	@SuppressWarnings("resource")
	@Override
	public ResponseEntity<Object> readExcel(ExcelData excelData) throws IOException {
		try {
			String excelFile = excelData.getExcelFile();
			byte[] decode = Base64.getDecoder().decode(excelFile);
			FileInputStream inputStream = new FileInputStream(decode.toString());
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheetAt = workbook.getSheetAt(0);
			Iterator<Row> rowiterator = sheetAt.iterator();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
