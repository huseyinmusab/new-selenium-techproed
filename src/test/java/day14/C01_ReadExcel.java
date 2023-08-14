package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    /*
Excel icin daha once inceledigimiz Web Table yapisina
benzer bir yapi vardir.
➢ Excel’de bir hucredeki bilgiye ulasmak icin
dosya/sayfa/satir/sutun sirasiyla ilerlemeliyiz
➢ Excel ile ilgili otomasyonda web table’da oldugu gibi sutun yapisi yoktur,
ihtiyac duyarsak kodla sutunu elde edebiliriz ancak bir dataya ulasmak icin sutun kullanamayiz
Workbook==> excel dosyamiz
Sheet==> Her açık excel sekmesi (Sheet1, Sheet2, etc)
Row(satir)==> Java, yalnızca içeride veri varsa satırları sayar. Default olarak, Java perspektifinden satır sayısı 0'dır
Cell (hucre)==> Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar
**********************************************************************************************************
Apache POI
➢Apache POI, microsoft ofis dokumanlarina erişmek için kullanılan Java API'idir.
➢Poi.apache.com sayfasindan official dokumanlar incelenebilir. ➢Excel kullanmak icin;
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi --> <dependency>
<groupId>org.apache.poi</groupId> <artifactId>poi</artifactId> <version>4.1.2</version>
</dependency>
**********************************************************************************************************
Read Excel Class Work
1. apache poi dependency’i pom file’a ekleyelim
2. Java klasoru altinda resources klasoru olusturalim
3. Excel dosyamizi resources klasorune ekleyelim
4. excelAutomation isminde bir package olusturalim
5. ReadExcel isminde bir class olusturalim
6. readExcel() method olusturalim
7. Dosya yolunu bir String degiskene atayalim
8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim 10. WorkbookFactory.create(fileInputStream)
11. Worksheet objesi olusturun workbook.getSheetAt(index)
12. Row objesi olusturun sheet.getRow(index)
13. Cell objesi olusturun row.getCell(index)

     */

    @Test
    public void readExcelTest01() throws IOException {
        //assign file path to a String
        String filePath ="src/resources/Scrappel.xlsx";

        //create fileInput Object
        FileInputStream fis =new FileInputStream(filePath);

        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        //create Sheet object
        Sheet sheet =workbook.getSheet("Tabelle1");//opening the page at the bottom

        //row object
        Row row =sheet.getRow(1);//on the Tabelle 1 page 2nd row

        //Cell object
        Cell cell = row.getCell(3);//after the row selecting a cell
        System.out.println(cell);//There should be valid password to enter app

    }

    @Test
    public void readExcelTest02() throws IOException {
        //assign file path to a String
        String filePath ="src/resources/Capitals (1).xlsx";
        //src/resources/Capitals (1).xlsx

        //create fileInput Object
        FileInputStream fis =new FileInputStream(filePath);

        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        //create Sheet object
        Sheet sheet =workbook.getSheet("capitals_sheet");//opening the page at the bottom

        //row object
        Row row =sheet.getRow(2);//on the Tabelle 1 page 2nd row
   

        //Cell object
        Cell cell = row.getCell(2);//after the row selecting a cell
        System.out.println(cell.toString());//250000
        System.out.println(cell.getCellComment());//null
        System.out.println(cell.getStringCellValue());//250000
        System.out.println(cell.getRichStringCellValue());//250000
        System.out.println(cell.getCellStyle());//org.apache.poi.xssf.usermodel.XSSFCellStyle@dc8db6fb
        System.out.println(cell.getSheet());//Name: /xl/worksheets/sheet1.xml - Content Type: application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml
        System.out.println(cell.getCellType());//STRING

        Assert.assertEquals(cell.toString(),"250000");

//        Assert.assertEquals(cell,"250000");
//        java.lang.AssertionError: expected: org.apache.poi.xssf.usermodel.XSSFCell<250000> but was: java.lang.String<250000>
//                Expected :org.apache.poi.xssf.usermodel.XSSFCell<250000>
//                Actual   :java.lang.String<250000>
        //USE toString() METHOD


    }


}
