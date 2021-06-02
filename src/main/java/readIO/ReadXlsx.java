package readIO;

import controlTownPack.ControllerPersonClass;
import controlTownPack.ControllerTownS;
import interfaces.PathsAndCellAdress;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import townInfoPackega.Person;
import townInfoPackega.TownT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadXlsx {

    public void openBookTownOrPerson(final String path, ControllerTownS o) throws IOException, InterruptedException {

        System.out.println("Загрузка городов...");
        Thread.sleep(200);

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheetAt(PathsAndCellAdress.SheetTownIndex);


        Iterator<Row> rows = sheet.rowIterator();
        int count = 0;

        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.getRowNum() > 0) {

            try{
                String s = row.getCell(PathsAndCellAdress.cellAreaCell).toString();
                String s1 = row.getCell(PathsAndCellAdress.cellTownCell).toString();
                String s2 = row.getCell(PathsAndCellAdress.cellStreet).toString();
                // Can use StringBuilder
                TownT townT = new TownT(s,s2,s1);
                o.addPosition(townT);
                count ++;
            }
                catch (NullPointerException e){
                // ?
                //System.out.println("NULL, continue...");
            }

            }
        }
        wb.close();
        fis.close();

        System.out.println("Города загружены : Всего строк -  " + count);
    }

    public void openBookTownOrPerson(final String path, ControllerPersonClass o) throws IOException, InterruptedException {

        System.out.println("Загрузка сотрудников...");

        Thread.sleep(100);

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheetAt(PathsAndCellAdress.sheetPersonIndex);


        Iterator<Row> rows = sheet.rowIterator();
        int count = 0;

        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.getRowNum() > 0) {
                try {
                    String s = row.getCell(PathsAndCellAdress.cellFirtstName).toString();
                    String s1 = row.getCell(PathsAndCellAdress.cellDefoltCity).toString();
                    // Can use StringBuilder
                    Person person = new Person(s,s1);
                    o.addPosition(person);
                    count ++;
                }
                catch (NullPointerException e){
                    // ?
                    //System.out.println("NULL, continue...");
                }

            }
        }
        wb.close();
        fis.close();

        System.out.println("Сотрудники загружены : Всего строк -  " + count);
    }

}
