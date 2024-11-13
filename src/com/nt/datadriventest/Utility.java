package com.nt.datadriventest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	private static void loadSheet(String xlFile,String xlsheet)throws Exception {
		fis=new FileInputStream(xlFile);
		 workbook=new XSSFWorkbook(fis);
		 sheet=workbook.getSheet(xlsheet);
	}
	private static void saveAndClose(String xlFile)throws Exception{
		fos=new FileOutputStream(xlFile);
		workbook.write(fos);
		fos.close();
	   fis.close();
		
	}
	//getTotalRowCount
	public static int getRowCount(String xlFile,String xlsheet)throws Exception {
		loadSheet(xlFile,xlsheet);
		int total_rows=sheet.getLastRowNum();
		return total_rows;
	}
	public static int getcellCount(String xlFile,String xlsheet,int rowNum)throws Exception {
		loadSheet(xlFile,xlsheet);
		int total_cell=sheet.getRow(rowNum).getLastCellNum();
		fis.close();
		return total_cell;
	 }
	public static String getcellData(String xlFile,String xlsheet,int rowNum,int columnNum)throws Exception {
		loadSheet(xlFile,xlsheet);
		 String data=sheet.getRow(rowNum).getCell(columnNum).toString();
		 
		 
		fis.close();
		
		return data;
	 }
	public static void setCellData(String xlFile,String xlSheet,int rowNum,int columnNum,String data)throws Exception {
		
		loadSheet(xlFile,xlSheet);
			row=sheet.getRow(rowNum);
			cell=row.createCell(columnNum);
			cell.setCellValue(data);
			saveAndClose(xlFile);
		
	}
	
	public static void fillRedColor(String xlFile, String xlSheet, int rowNum, int columnNum) throws Exception {
	    loadSheet(xlFile, xlSheet);
	    row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);
	    }
	    cell = row.getCell(columnNum);
	    if (cell == null) {
	        cell = row.createCell(columnNum);
	    }

	    // Create a new cell style
	    style = workbook.createCellStyle();

	    try {
	        // Set the foreground color to red
	        style.setFillForegroundColor(IndexedColors.RED.getIndex());

	        // Use the short value for SOLID_FOREGROUND
	        style.setFillPattern(CellStyle.SOLID_FOREGROUND); // Deprecated style in older POI versions

	        // Apply the style to the cell
	        cell.setCellStyle(style);

	        System.out.println("Successfully applied red color to the cell.");
	    } catch (Exception e) {
	        System.out.println("Error applying style: " + e.getMessage());
	        e.printStackTrace();
	    }

	    // Save and close the workbook
	    saveAndClose(xlFile);
	}
	public static void fillGreenColor(String xlFile, String xlSheet, int rowNum, int columnNum) throws Exception {
	    loadSheet(xlFile, xlSheet);
	    row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);
	    }
	    cell = row.getCell(columnNum);
	    if (cell == null) {
	        cell = row.createCell(columnNum);
	    }

	    // Create a new cell style
	    style = workbook.createCellStyle();

	    try {
	        // Set the foreground color to red
	        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());

	        // Use the short value for SOLID_FOREGROUND
	        style.setFillPattern(CellStyle.SOLID_FOREGROUND); // Deprecated style in older POI versions

	        // Apply the style to the cell
	        cell.setCellStyle(style);

	        System.out.println("Successfully applied green color to the cell.");
	    } catch (Exception e) {
	        System.out.println("Error applying style: " + e.getMessage());
	        e.printStackTrace();
	    }

	    // Save and close the workbook
	    saveAndClose(xlFile);
	}
	

		}

	
		
	
	


