package tasks;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import utilities.ExcelUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TH26_EarningsRankingSystem {

    /*
     Task 3: Earnings Ranking System
     Given: Save EarningList.xlsx file into your project
     When: In the row column, write the row numbers according to the earnings amount (Natural Order lowest to highest).
     Then: Assert that row number of Wednesday is 1
    */

    @Test
    void earningsRankingSystemTest() throws IOException {

        Workbook workbook = new ExcelUtils("src/test/resources/EarningsRankingSystem.xlsx").getWorkbook();
        Sheet sheet = workbook.getSheet("Sheet1");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            double currentEarning = sheet.getRow(i).getCell(1).getNumericCellValue();

            int rank = 1;
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                double otherEarning = sheet.getRow(j).getCell(1).getNumericCellValue();
                if (otherEarning < currentEarning) {
                    rank++;
                }
            }
            sheet.getRow(i).createCell(2).setCellValue(rank);
        }

            FileOutputStream fos = new FileOutputStream("src/test/resources/EarningsRankingSystem.xlsx");
            workbook.write(fos);


            int wedRank = -1;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                if (sheet.getRow(i).getCell(0).getStringCellValue().equals("Wednesday")) {
                    wedRank = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
                }
            }

            assertEquals(1, wedRank);

            workbook.close();
            fos.close();

        }

    }
