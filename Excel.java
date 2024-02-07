import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelCreator {

    public static InputStream createExcelStream(List<YourObject> objectList) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Column1");
            headerRow.createCell(1).setCellValue("Column2");
            // Add more columns as needed

            // Populate data rows
            int rowNum = 1;
            for (YourObject obj : objectList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(obj.getField1());
                row.createCell(1).setCellValue(obj.getField2());
                // Add more cells for other fields
            }

            // Write the workbook to ByteArrayOutputStream
            workbook.write(outputStream);

            // Convert ByteArrayOutputStream to ByteArrayInputStream
            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
