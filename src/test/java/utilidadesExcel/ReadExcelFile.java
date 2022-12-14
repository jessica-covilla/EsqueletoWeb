package utilidadesExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	
		public ReadExcelFile()
		{
			
		}
		
		//METODO DE LECTURA DE ARCHIVO
		
		@SuppressWarnings("resource")
		public void ReadExcel (String filepath, String sheetName) throws IOException
		{
			File file= new File(filepath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook newWorkbook=new XSSFWorkbook(inputStream);
			XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
			int rowCount= newSheet.getLastRowNum() + newSheet.getFirstRowNum();
			for (int i=0; i<rowCount;i++)
					{
						XSSFRow row =newSheet.getRow(i);
						for(int j=0; j<row.getLastCellNum(); j++);
					}
		}

		@SuppressWarnings("resource")
		public String getCellValue(String filepath, String sheetname, int rowNumber, int cellNumber) throws IOException
		{
			File file= new File(filepath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook newWorkbook=new XSSFWorkbook(inputStream);
			XSSFSheet newSheet = newWorkbook.getSheet(sheetname);
			XSSFRow row =newSheet.getRow(rowNumber);
			XSSFCell cell = row.getCell(cellNumber);	
			return cell.getStringCellValue();
		}

		
	}

