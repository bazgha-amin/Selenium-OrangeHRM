package com.SeleniumDemo.Config;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelData {

    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {

        File file =    new File(filePath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);

        //creating a Sheet object
        XSSFSheet sheet=wb.getSheet(sheetName);

        //get all rows in the sheet
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        int cellCount=sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][cellCount];

        //iterate over all the row to print the data present in each cell.
        for(int i=1;i<=rowCount;i++){

            for(int j=0;j<cellCount;j++){
                String path = System.getProperty("user.dir");
                String result = sheet.getRow(i).getCell(j).toString();
                if(j == 3) {
                    result = path + "\\" + result;
                    System.out.println(result);

                }
                data[i-1][j] = result;

                //System.out.println("the result is " + data[i-1][j]);
            }
        }
        return data;
    }

}
