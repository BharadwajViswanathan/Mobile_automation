package TestNgpratice;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataExportToExistingFile {
    public static void main(String[] args) throws IOException {
        // Load the existing Excel file
        FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/Writedatausingexcel.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet2"); 
        for (int rowIndex = sheet.getLastRowNum(); rowIndex >= 0; rowIndex--) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                sheet.removeRow(row);
            }
        }
        String name="Ponraj:134567;status:PAssed";
        String name1="Ponraj:134567;status:failed";
       String[] data = {name,name1};
     

      
        int newRowNum = sheet.getLastRowNum() + 1;
        Row newRow = sheet.createRow(newRowNum);

    
        for (int i = 0; i < data.length; i++) {
            Cell cell = newRow.createCell(i);
            cell.setCellValue(data[i]);
        }
       
        try (FileOutputStream outputStream = new FileOutputStream("./src/test/resources/config/Writedatausingexcel.xlsx")) {
            workbook.write(outputStream);
            System.out.println("Data written to the existing Excel file and sheet successfully.");
        }
    }
}
