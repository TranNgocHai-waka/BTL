package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelUtils {
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;//Ex: A1

    public static void setExcelFile(String path, String sheetName) throws IOException {
        try {
            File file = new File(path);
            FileInputStream excelFile = new FileInputStream(file);
            // Access the test data sheet
            excelWBook = new XSSFWorkbook(excelFile);
            excelSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e){
            throw (e);
        }
    }

    //gọi lại ra dùng thì gọi hàm setExcelFile trước để khai báo file excel cần dùng xong đến gọi getCellData để lấy data theo từng ô

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
                        cellData = String.valueOf((long)excelCell.getNumericCellValue());
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
//
//        excelCell = excelSheet.getRow(row).getCell(col);
//        excelCell.setCellType(CellType.STRING);
//        String cellData = excelCell.getStringCellValue();
//        return cellData;
    }

    //create new table not title
    //new table only include data email and data password
    //setExcelFile: set excel file theo sheet cần dùng
    public static Object[][] getTableArray(String pathFile, String sheetname) throws IOException {
        String[][] newTableArray = null;
        try {
            File f = new File(pathFile);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exits, so created!");
            }
            FileInputStream excelFile = new FileInputStream(pathFile);
            excelWBook = new XSSFWorkbook(excelFile);
            excelSheet = excelWBook.getSheet(sheetname);
            if (excelSheet == null) {
                excelSheet = excelWBook.createSheet(sheetname);
            }

            int startRow = 1;
            int startCol = 1;
            int ci, cj;
            int totalRows = excelSheet.getLastRowNum();//lay hang cuoi cung
            int totalCols = excelSheet.getRow(1).getLastCellNum()-1;

            newTableArray = new String[totalRows][totalCols];
            for(int i = startRow; i <= totalRows; i++) {
                ci = i - 1;
                for (int j = startCol; j <= totalCols; j++) {
                    cj = j - 1;
                    System.out.println("table array: " + ci + " " + cj);
                    newTableArray[ci][cj] = getCellData(i,j);
                    System.out.println(newTableArray[ci][cj]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newTableArray;
    }

    //đọc excel file : tương tự getTableArray

    //hàm ghi data vào lại File Excel theo từng Cell
    public static void setCellData(String pathFile, String text, int row, int col) {
        try {
            Row rowNumber = excelSheet.getRow(row);
            if (rowNumber == null) {
                rowNumber = excelSheet.createRow(row);
            }
            Cell cell = rowNumber.getCell(col);
            if (cell == null) {
                cell = rowNumber.createCell(col);
            }
            cell.setCellValue(text);
            XSSFCellStyle style = (XSSFCellStyle) excelWBook.createCellStyle();
            style.setFillPattern(FillPatternType.NO_FILL);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            cell.setCellStyle(style);

            FileOutputStream fileOut = new FileOutputStream(pathFile);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
