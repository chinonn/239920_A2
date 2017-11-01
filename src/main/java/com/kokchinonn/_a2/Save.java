//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Save implements FileHandler {

    @Override
    public void storeData(String[] headers, List<Information> informations) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Excel");

        String[] titles = {"Semester", "Course", "Group", "Task"};
        for (int i = 0; i < headers.length; i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(titles[i]);
            row.createCell(1).setCellValue(headers[i]);
        }

        Row r6 = sheet.createRow(5);
        r6.createCell(5).setCellValue("java keyword");

        Row r7 = sheet.createRow(6);
        r7.createCell(0).setCellValue("Matrik");
        r7.createCell(1).setCellValue("LOC");
        r7.createCell(2).setCellValue("Blank");
        r7.createCell(3).setCellValue("Comment");
        r7.createCell(4).setCellValue("ActualLOC");

        try {
            FileOutputStream outputStream = new FileOutputStream("result.xls");
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
        }
        System.out.println("Finished!");
    }   
 }
