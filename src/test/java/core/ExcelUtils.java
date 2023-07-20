package core;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static XSSFWorkbook excelWBook;
    public static XSSFSheet excelSheet;
    public static XSSFRow excelRow;
    public static XSSFCell excelCell;

    public static void setExcelFile(String fileName, String sheetName) throws IOException {
        try {
            File file = new File(fileName);
            FileInputStream excelFile = new FileInputStream(file);
            excelWBook = new XSSFWorkbook(excelFile);
            excelSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //get celldata
    public static String getCellData(int row, int col) {
        try {
            excelCell = excelSheet.getRow(row).getCell(col);
            String cellData = null;
            switch (excelCell.getCellType()) {
                case STRING:
                    cellData = excelCell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(excelCell)) {
                        cellData = String.valueOf(excelCell.getDateCellValue());
                    } else {
                        cellData = String.valueOf((long) excelCell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    cellData = Boolean.toString(excelCell.getBooleanCellValue());
                    break;
                case BLANK:
                    cellData = "";
                    break;
            }
            return cellData;
        } catch (Exception e) {
            return "";
        }
    }

    public static int getRowByTestCaseID(String testCase){
        int rowTotal = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();
        for(int i = 1; i < rowTotal + 1; i++){
            excelCell = excelSheet.getRow(i).getCell(0);
            DataFormatter formatter = new DataFormatter();
            String rowText = formatter.formatCellValue(excelCell);
            if(rowText.equals(testCase)){
                System.out.println(testCase);
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    public static int getCol(String columnName) {
        excelRow = excelSheet.getRow(0);
        for (int i = 0; i < excelRow.getLastCellNum(); i++){
            String name = String.valueOf(excelRow.getCell(i));
            if (name.equals(columnName)){
                System.out.println("col "+ i);
                return i;
            }
        }
        return -1;
    }
}
