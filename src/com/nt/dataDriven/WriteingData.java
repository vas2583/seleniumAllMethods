package com.nt.dataDriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteingData {

	public static void main(String[] args)throws IOException {
		FileOutputStream fos=new FileOutputStream("./sheets/data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("data");
		XSSFRow row=sheet.createRow(1);
		row.createCell(0).setCellValue("welcome");
		row.createCell(1).setCellValue("to");
		row.createCell(2).setCellValue("Selenium");
		row.createCell(3).setCellValue("in");
		row.createCell(4).setCellValue("nareshit");
		
		workbook.write(fos);
		System.out.println("complete writeing");
		
		

	}

}
