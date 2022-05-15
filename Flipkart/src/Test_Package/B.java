package Test_Package;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class B


{
	public static void main(String[]args) throws EncryptedDocumentException, IOException
	{
			File  f = new File("C:\\Users\\sunil.d.kumar.gupta\\Documents\\Sunil\\Automation\\Truck\\Flipkart\\data\\tdata.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet("TC_01");
			Row r = st.getRow(1);
			Cell c = r.getCell(1);
			String data = c.toString();
			System.out.println(data);
	
	}	
}