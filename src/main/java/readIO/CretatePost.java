package readIO;

import townInfoPackega.Person;
import townInfoPackega.TownT;

public class CretatePost {


    public static String getpostFromTown(Person o1, TownT o2){

        String s1 = "https://www.google.com/maps/dir/";
        String s2 = o1.getDefoltcity();
        String s4 = o2.getArea()+" ";
        String s5 = o2.getTown()+" ";
        String s6 = o2.getStreet().contains("'\\") ? "" : "";

        String result = s1 + s2 + "/" + s4+s5+s6;
        // Заменяет пробелы
        return result.replace(" ","+");
    }
}
