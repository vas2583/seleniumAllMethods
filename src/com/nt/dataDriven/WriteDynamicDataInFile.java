package com.nt.dataDriven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDynamicDataInFile {

	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		FileOutputStream fos=new FileOutputStream("./dydata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("dydata");
		System.out.println("How many rows you want 3");
		int total_row=sc.nextInt();
		System.out.println("How many cells you want 3");
		int total_cell=sc.nextInt();
		for(int i=0;i<=total_row;i++) {
			XSSFRow row=sheet.createRow(i);
		for(int j=0;j<total_cell;j++) {
			XSSFCell cell=row.createCell(j);
			System.out.println("enter the cell date in row"+i+" in cell"+j);
			cell.setCellValue(sc.next());
		    }
		}
		workbook.write(fos);
		System.out.println("write ing is Completed");
		
			
		}
		
		
		

	}


