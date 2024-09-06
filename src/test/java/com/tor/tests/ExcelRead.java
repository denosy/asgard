package com.tor.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_Excel() throws IOException {

        String path = "practice.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Employees");


        // TODO : Print out Mary`s cell;
        XSSFCell mary = sheet.getRow(1).getCell(0);
        System.out.println("mary = " + mary);

        // TODO : Print out Developer`s job_id;
        XSSFCell dev = sheet.getRow(3).getCell(2);
        System.out.println("dev = " + dev);

        //starts from 1
        //ignoring empty rows
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows); //5

        //starts from 0
        //NOT ignoring empty rows
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum); //4

        //TODO : Crate logic to print Vinod`s name Dynamically;

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")) {
                System.out.println("sheet.getRow(rowNum).getCell(0) = " + sheet.getRow(rowNum).getCell(0));
            }


        }

    }
}
