package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void C04_RaedExcel() throws IOException {
        String filePath = "src/resources/Capitals (1).xlsx";
        //create fileInput Object
        FileInputStream fis = new FileInputStream(filePath);
        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        //last row
        int lastRow = workbook.getSheet("capitals_sheet").getLastRowNum();

        //WRITE ALL EXCEL
        String cells = "";
        for (int i = 0; i <= lastRow; i++) {
            System.out.println(" ");//one line down for every iteration
            System.out.print(i);//put a number to rows
            for (int j = 0; j < workbook.getSheet("capitals_sheet").getRow(i).getLastCellNum(); j++) {
                cells = workbook.getSheet("capitals_sheet").getRow(i).getCell(j).toString();
                System.out.print(" : " + cells);
            }
        }
    }
}
