package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel_loop {
    @Test
    public void C04_RaedExcel() throws IOException {
        //assign file path to a String


        String filePath = "src/resources/Capitals (1).xlsx";
        //create fileInput Object
        FileInputStream fis = new FileInputStream(filePath);
        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);


        //LAST ROW
        int lastRow = workbook.getSheet("capitals_sheet").getLastRowNum();
        System.out.println(lastRow);

        //WRITE COUNTRIES
        String countries="";
        for (int i = 1; i < lastRow; i++) {
           countries= workbook.getSheet("capitals_sheet").getRow(i).getCell(0).toString();
            System.out.println(i+": "+countries );
        }



    }
}
