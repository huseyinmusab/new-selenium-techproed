package day15;

import com.github.javafaker.Faker;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    /*
1)Yeni bir Class olusturalim WriteExcel
2) Yeni bir test method olusturalim writeExcelTest()
3) Adimlari takip ederek 1.satira kadar gidelim
4) 5.hucreye yeni bir cell olusturalim
5) Olusturdugumuz hucreye “Nufus” yazdiralim
6) 2.satir nufus kolonuna 1500000 yazdiralim
7) 10.satir nufus kolonuna 250000 yazdiralim
8) 15.satir nufus kolonuna 54000 yazdiralim
9)Dosyayi kaydedelim
10)Dosyayi kapatalim
     */
    @Test
    public void C02_WriteExcel1() throws IOException {
        String filePath = "src/resources/Capitals (1).xlsx";
        //create fileInput Object
        FileInputStream fis = new FileInputStream(filePath);
        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);
        //ALWAYS COME FROM ROW!!!

        workbook.getSheet("capitals_sheet").getRow(0).createCell(3).setCellValue("NEW POPULATION");
        workbook.getSheet("capitals_sheet").getRow(1).createCell(3).setCellValue("3000000");
        workbook.getSheet("capitals_sheet").getRow(2).createCell(3).setCellValue("4000000");
        workbook.getSheet("capitals_sheet").getRow(3).createCell(3).setCellValue("5000000");
        workbook.getSheet("capitals_sheet").getRow(4).createCell(3).setCellValue("6000000");
        workbook.getSheet("capitals_sheet").getRow(5).createCell(3).setCellValue("7000000");
        workbook.getSheet("capitals_sheet").getRow(6).createCell(3).setCellValue("8000000");

        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(filePath);
        //write it
        workbook.write(fos);
        fos.close();
        workbook.close();

    }

    @Test
    public void C02_WriteExcel2() throws IOException {
        String filePath = "src/resources/Capitals (1).xlsx";
        //create fileInput Object
        FileInputStream fis = new FileInputStream(filePath);
        //create Workbook object
        Workbook workbook = WorkbookFactory.create(fis);
        //?

//        Drawing<?> drawing = workbook.getSheet("capitals_sheet").createDrawingPatriarch();
//        CreationHelper factory = workbook.getCreationHelper();
//        ClientAnchor anchor = factory.createClientAnchor();

        // Normal comment creation
//        Comment comment1 = drawing.createCellComment(anchor);
//        RichTextString str1 = factory.createRichTextString("An example of normal comment!");
//        comment1.setString(str1);
//        comment1.setAuthor("Apache POI");




        //last row
        int lastRow = workbook.getSheet("capitals_sheet").getLastRowNum();
        Faker faker=new Faker();

        workbook.getSheet("capitals_sheet").getRow(0).createCell(3).setCellValue("NEW POPULATION");//first header

        for (int i = 1; i <=lastRow ; i++) {
            workbook.getSheet("capitals_sheet").getRow(i).createCell(3).setCellValue(faker.number().numberBetween(3000000,6000000));
            // Adding the comment1 t
//            workbook.getSheet("capitals_sheet").getRow(i).getCell(3).setCellComment(comment1);

        }
        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(filePath);
        //write it
        workbook.write(fos);
        fos.close();
        workbook.close();


    }

    }
