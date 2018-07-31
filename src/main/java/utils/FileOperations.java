package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;

public class FileOperations {
	
	static String path;
	
	public String getValueFromPropertyFile(String filePath, String key) {
		String keyValue = null;
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(filePath));	
			keyValue = prop.getProperty(key);
		}catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}			
		return keyValue;
	}
	
	public static String getTestDataValue(String TestDataName) throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		path = Driver.getRootPath();
		FileInputStream fileLocation = new FileInputStream(
				new File(path + "/src/data/TestData.xlsx"));
		XSSFWorkbook objWorkBook = new XSSFWorkbook(fileLocation);
		XSSFSheet objSheet = objWorkBook.getSheetAt(0);
		int rowNum = objSheet.getLastRowNum();
		for (int i = 1; i <= rowNum; i++) {
			int colNum = objSheet.getRow(i).getLastCellNum();
			for (int j = 0; j < colNum; j++) {
				map.put(objSheet.getRow(i).getCell(0).getStringCellValue(),
						objSheet.getRow(i).getCell(1).getStringCellValue());
			}
		}
		String TestDataValue = map.get(TestDataName);
		//objWorkBook.close();
		fileLocation.close();
		return TestDataValue;
	}
	
	public void writeJSErrorInLogFile(String filePath, LogEntries logEntries ,String pageUrl) throws IOException {
		File f=new File(filePath);
		if(f.exists()){
			FileWriter	fw = new FileWriter(filePath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("=========================================================================================================================\n");
			bw.append("Page URL : " + pageUrl +"\n");
			for (LogEntry entry : logEntries) {
				try {
					bw.append(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage()+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			bw.append("\n=========================================================================================================================");
			bw.close();	
		}
		
	}

}
