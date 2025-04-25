package helper;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class ReadDFiles {

    public static void readExcel() throws IOException {
        FileInputStream inputStream = new FileInputStream("src/main/resources/demo-data.xls");
        Workbook workbook = new HSSFWorkbook(inputStream); // dùng cho .xls
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    System.out.print("NULL || ");
                    continue;
                }
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " || ");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " || ");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + " || ");
                        break;
                    case FORMULA:
                        System.out.print(cell.getCellFormula() + " || ");
                        break;
                    case BLANK:
                        System.out.print("BLANK || ");
                        break;
                    default:
                        System.out.print("UNKNOWN || ");
                        break;
                }
            }
            System.out.println();
        }
        workbook.close();
        inputStream.close();
    }

    public static void writeDateExcel(String[] dataToWrite) throws IOException {
        String path = "src/main/resources/demo-data.xls";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int newRowIdx = sheet.getLastRowNum() + 1;
        Row newRow = sheet.createRow(newRowIdx);
        for (int i = 0; i < dataToWrite.length; i++) {
            Cell cell = newRow.createCell(i);
            cell.setCellValue(dataToWrite[i]);
        }

        inputStream.close(); // luôn đóng input trước khi mở output
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        readExcel();
        String[] data = {"006", "lpab6", "123456788"};
        writeDateExcel(data);
        readExcel();
    }
}
