package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_RaedExcel {
    @Test
    public void C02_RaedExcel() throws IOException {    //assign file path to a String
        String filePath ="src/resources/Capitals (1).xlsx";
        //src/resources/Capitals (1).xlsx

        //create fileInput Object
        FileInputStream fis =new FileInputStream(filePath);

        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData =workbook
                .getSheet("capitals_sheet")
                .getRow(2)
                .getCell(2)
                .toString();

        System.out.println(actualData);//250000

    }


}
