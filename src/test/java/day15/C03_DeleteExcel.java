package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C03_DeleteExcel {

    @Test
    public void Delete01() throws IOException {
        String filePath = "src/resources/Capitals (1).xlsx";
        //create fileInput Object
        FileInputStream fis = new FileInputStream(filePath);
        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("capitals_sheet");
        //row
        Row row=sheet.getRow(6);
        //cell
        Cell cell=row.getCell(3);
        //removing the selected cell
        row.removeCell(cell);

        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(filePath);
        //write it
        workbook.write(fos);
        fos.close();
        workbook.close();
        //do assertion

        //LAST ROW
        int lastRow = workbook.getSheet("capitals_sheet").getLastRowNum();
        System.out.println("lastRow: "+lastRow);

        int activeCells=0;
        for (int i = 0; i <= lastRow; i++) {
            activeCells= workbook.getSheet("capitals_sheet").getRow(i).getPhysicalNumberOfCells();
            System.out.println("activeCells: "+i+": "+activeCells );
            Assert.assertTrue(activeCells<lastRow);
        }






//        int usedRows =workbook.getSheet("capitals_sheet").getRow()
//        System.out.println("usedRows: "+usedRows);//4









          //do assertion
        //last row
//        int lastRow = workbook.getSheet("capitals_sheet").getLastRowNum();
//        System.out.println("lastRow: "+lastRow);
//
//        //WRITE ALL EXCEL
//        List<String> cells = new ArrayList<>();
//
//        for (int i = 0; i <= lastRow; i++) {
//
//            cells.add(Collections.singletonList(workbook.getSheet("capitals_sheet").getRow(i).getCell(3).toString()).toString()) ;
//
//        }
//        System.out.print(cells);
//        System.out.println(cells.size());
//        //Assert.assertTrue(cells.size()<lastRow);
//

    }



}
