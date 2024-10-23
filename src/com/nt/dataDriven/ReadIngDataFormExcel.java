package com.nt.dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadIngDataFormExcel {

	public static void main(String[] args)throws IOException {
		FileInputStream fis=new FileInputStream("./sheets/Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		//count no.of rows
		int rows=sheet.getLastRowNum();
		System.out.println(rows);
		int cells=sheet.getRow(1).getLastCellNum();
		System.out.println(cells);
		for(int i=1;i<=rows;i++) {
			XSSFRow row=sheet.getRow(i);
		for(int j=0;j<cells;j++) {
			XSSFCell cell=row.getCell(j);
			System.out.print(cell.toString()+" ");
		    }
		System.out.println();
		}
		
		String prodName=sheet.getRow(5).getCell(1).toString();
		System.out.println(prodName);
		

	}

}
