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
        Sheet sheet = wb.getSheetAt(PathsAndCellAdress.SHEET_TOWN_INDEX);


        Iterator<Row> rows = sheet.rowIterator();
        int count = 0;

        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.getRowNum() > 0) {

            try{
                String s  = row.getCell(PathsAndCellAdress.CELL_AREA_CELL).toString();
                String s1 = row.getCell(PathsAndCellAdress.CELL_TOWN_CELL).toString();
                String s2 = row.getCell(PathsAndCellAdress.CELL_STREET).toString();
                String index = doubleToString(row.getCell(PathsAndCellAdress.CELL_INDEX).toString());
                // Can use StringBuilder

                TownT townT = new TownT(s,s2,s1,index);
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
        Sheet sheet = wb.getSheetAt(PathsAndCellAdress.SHEET_PERSON_INDEX);


        Iterator<Row> rows = sheet.rowIterator();
        int count = 0;

        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.getRowNum() > 0) {
                try {
                    String s = row.getCell(PathsAndCellAdress.CELL_FIRTST_NAME).toString();
                    String s1 = row.getCell(PathsAndCellAdress.CELL_DEFOLT_CITY).toString();
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

    private static String doubleToString(String index){
        try{
        String[] s = index.split("\\.");
        return s[0];
        }
        catch (Exception e){
            return index;
        }
    }

}
