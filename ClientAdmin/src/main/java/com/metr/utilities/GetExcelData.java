package com.metr.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class GetExcelData {
	public static String Exceldata(String s, int row, int column) throws EncryptedDocumentException, IOException 
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\git\\repository\\ClientAdmin\\src\\test\\resources\\Client Admin.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(s);
        String data =sheet.getRow(row).getCell(column).toString();
        return data;
        
    }
}
