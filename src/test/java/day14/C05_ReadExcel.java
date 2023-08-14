package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void C04_RaedExcel() throws IOException {

        String filePath = "src/resources/Capitals (1).xlsx";
        //create fileInput Object
        FileInputStream fis = new FileInputStream(filePath);
        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        //TASK:
        //Go to the second page and verify rows are 6,used rows are 3

        //LAST ROW
        int lastRow = workbook.getSheet("countries").getLastRowNum();
        System.out.println("lastRow :"+lastRow);
        int expectedLastRow = 11;
        System.out.println("expectedLastRow :"+expectedLastRow);
        Assert.assertEquals(expectedLastRow,lastRow+1);//according to indexes


       int usedRows =workbook.getSheet("countries").getPhysicalNumberOfRows();
       System.out.println("usedRows: "+usedRows);//4
        //do assertion


    }
}
