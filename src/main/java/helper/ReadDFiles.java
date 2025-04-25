package helper;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

public class ReadDFiles {

    public static void readExcel() throws IOException {
        File execlFile = new File("src/main/resources/demo-data.xls");
        FileInputStream inputStream = new FileInputStream(execlFile);
        Workbook excelWorkbook = new HSSFWorkbook(inputStream);
        Sheet sheet = excelWorkbook.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.println("rowCount: " + rowCount);

        for (int i = 0; i < rowCount+1; i++) {
            Row row = sheet.getRow(i);
            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print Excel data in console
                System.out.print(row.getCell(j).getStringCellValue()+"|| ");
            }
            System.out.println();
        }
    }

    public static void writeDateExcel(String[] dataToWrite) throws IOException {
        File execlFile = new File("src/main/resources/demo-data.xls");
        FileInputStream inputStream = new FileInputStream(execlFile);
        Workbook excelWorkbook = new HSSFWorkbook(inputStream);
        Sheet sheet = excelWorkbook.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount+1);
        for(int j = 0; j < row.getLastCellNum(); j++){

            //Fill data in row

            Cell cell = newRow.createCell(j);

            cell.setCellValue(dataToWrite[j]);

        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(execlFile);
        excelWorkbook.write(outputStream);
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        readExcel();
        String[] Data = {"006","lpab6","123456788"};
        writeDateExcel(Data);
        readExcel();
    }

}
