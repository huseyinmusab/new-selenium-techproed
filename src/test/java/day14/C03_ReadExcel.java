package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void C02_RaedExcel() throws IOException {
        //assign file path to a String


        int row =5;
        int column =3;

        String filePath ="src/resources/Capitals (1).xlsx";
        //create fileInput Object
        FileInputStream fis =new FileInputStream(filePath);
        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);



        String actualData =workbook
                .getSheet("capitals_sheet")
                .getRow(row-1)
                .getCell(column-1)
                .toString();//1000000.0 (germanys)


//        String actualData =workbook
//                .getSheet("capitals_sheet")
//                .getRow(row-1)
//                .getCell(column-1).get


        System.out.println(actualData);

    }


}
