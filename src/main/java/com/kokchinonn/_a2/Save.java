//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Save implements FileHandler {

    @Override
    public void storeData(String[] headers, List<Information> informations) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java parser");

        String[] titles = {"Semester", "Course", "Group", "Task"};
        for (int i = 0; i < headers.length; i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(titles[i]);
            row.createCell(1).setCellValue(headers[i]);
        }

        Row row6 = sheet.createRow(5);
        row6.createCell(5).setCellValue("java keyword");

        Row row7 = sheet.createRow(6);
        row7.createCell(0).setCellValue("Matrik");
        row7.createCell(1).setCellValue("LOC");
        row7.createCell(2).setCellValue("Blank");
        row7.createCell(3).setCellValue("Comment");
        row7.createCell(4).setCellValue("ActualLOC");

        Set<String> usedKeywords = new HashSet<>();
        AssignmentTwo.KEYWORDS.forEach(kw -> informations.forEach(m -> {
            if (m.getWordCount().get(kw) > 0) {
                usedKeywords.add(kw);
            }
        }));

        int currentColumn = 5;
        for (String keyword : usedKeywords) {
            row7.createCell(currentColumn).setCellValue(keyword);
            currentColumn++;
        }
        
        int currentRow = 7;
        for (Information information : informations) {
            Row row = sheet.createRow(currentRow);
            row.createCell(0).setCellValue(information.getName());
            row.createCell(1).setCellValue(information.getLoc());
            row.createCell(2).setCellValue(information.getBlank());
            row.createCell(3).setCellValue(information.getComment());
            row.createCell(4).setCellValue(information.getActual());
            
            currentColumn = 5;
            for (String keyword : usedKeywords) {
                int count = information.getWordCount().get(keyword);
                if (count > 0) {
                    row.createCell(currentColumn).setCellValue(count);
                    currentColumn++;
                }
            }
            row.createCell(currentColumn).setCellValue(information.getTotal());
            currentRow++;
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("result.xls");
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
        }
        System.out.println("Finished!");
    }   
}
